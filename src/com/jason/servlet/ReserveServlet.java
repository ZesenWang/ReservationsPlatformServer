package com.jason.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.jason.bean.WaitInformation;
import com.jason.utils.JSONResolver;

/**
 * Servlet implementation class ReserveServlet
 */
public class ReserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		WaitInformation info = new WaitInformation();
		info.setPeopleCount(0);
		info.setSucceed(true);
		info.setWaitTime(0);
		
		
	}

	private void doGetFromApp(HttpServletRequest request, HttpServletResponse response){
		JSONResolver resolver = new JSONResolver(request, response);
		JSONObject data = resolver.getJSONObeject();
		System.out.println(data.toString(2));
		
		String id = data.getString("id");
		String hospital = data.getString("hospital");
		int department = data.getInt("department");
		int reservationType = data.getInt("reservationType");
		int doctor = data.getInt("doctor");
		
		JSONObject returnData = new JSONObject();
		returnData.put("isSucceed", true);
		returnData.put("waitTime", 0);
		returnData.put("peopleCount", 0);
		
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
