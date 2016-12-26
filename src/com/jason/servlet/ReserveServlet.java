package com.jason.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.jason.bean.WaitInformation;
import com.jason.utils.JSONResolver;
import com.jason.utils.TempDatabaseConnector;

/**
 * Servlet implementation class ReserveServlet
 */
public class ReserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TempDatabaseConnector connector = new TempDatabaseConnector();    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReserveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method
		//System.out.println(request.getHeader("user-agent"));
		String userAgent = request.getHeader("user-agent");
		if(userAgent.startsWith("Dalvik"))
			doGetFromApp(request, response);
		else
			doGetFromWebsite(request, response);
	}
	private void doGetFromWebsite(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String PID = request.getParameter("id");
		String doctor = request.getParameter("doctor");
		String reservationType = request.getParameter("reservationType");
		
		if(reservationType.equals("0"))
			connector.writeReservationInformation(PID, "jason", "");
		else{
			connector.writeReservationInformation(PID, "jason", doctor);
		}
		Vector vector = connector.queryReservationInformation(PID);
		WaitInformation info = new WaitInformation();
		//可能门诊诊间还没有生成排队信息，如果是这样就先默认几个值
		if(vector == null){
			info.setPeopleCount(0);
			info.setSucceed(true);
			info.setWaitTime(0);
		}else{
			int peopleCount = (Integer)vector.get(0);
			info.setPeopleCount(peopleCount);
			info.setSucceed(true);
			//因为门诊诊间没有提供预计等待时间的功能，所以这里我们假设等待时间是病人数*5
			info.setWaitTime(peopleCount * 5);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("show.jsp");
		request.setAttribute("data", info);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void doGetFromApp(HttpServletRequest request, HttpServletResponse response){
		JSONResolver resolver = new JSONResolver(request, response);
		JSONObject data = resolver.getJSONObeject();
		System.out.println(data.toString(2));
		
		String id = data.getString("id");
		String hospital = data.getString("hospital");
		String department = data.getString("department");
		int reservationType = data.getInt("reservationType");
		String doctor = data.getString("doctor");
		//如果是普通号，则医生那一项不填(与门诊诊间组的约定)
		if(reservationType == 0)
			connector.writeReservationInformation(id, "Jason", "");
		else
			connector.writeReservationInformation(id, "Jason", doctor);
		
		Vector vector = connector.queryReservationInformation(id);
		JSONObject returnData = new JSONObject();
		//可能门诊诊间还没有生成排队信息，如果是这样就先默认几个值
		if(vector == null){
			returnData.put("isSucceed", true);
			returnData.put("waitTime", 0);
			returnData.put("peopleCount", 0);
		}else{
			int peopleCount = (Integer)vector.get(0);
			returnData.put("isSucceed", true);
			//因为门诊诊间没有提供预计等待时间的功能，所以这里我们假设等待时间是病人数*5
			returnData.put("waitTime", peopleCount * 5);
			returnData.put("peopleCount", peopleCount);
		}
		resolver.sendJSONObject(returnData);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
