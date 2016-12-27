package com.jason.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.jason.utils.JSONResolver;
import com.jason.utils.TempDatabaseConnector;

/**
 * Servlet implementation class CheckServlet
 */
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TempDatabaseConnector connector = new TempDatabaseConnector();    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String userAgent = request.getHeader("user-agent");
		if(userAgent.startsWith("Dalvik"))
			doGetFromApp(request, response);
	}

	private void doGetFromApp(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		JSONResolver resolver = new JSONResolver(request, response);
		JSONObject data = resolver.getJSONObeject();
		System.out.println(data.toString(2));
		
		String id = data.getString("id");
		boolean isCancel = data.getBoolean("isCancel");
		
		JSONObject returnData = new JSONObject();
		//如果取消挂号就从数据库里删除此人，否则返回最新的排队信息
		if(isCancel){
			connector.deleteReservationInformation(id);
			returnData.put("queueNumber", -1);
			//这里的值填什么都无所谓
			returnData.put("waitTime", 0);
			returnData.put("peopleCount", 0);
		}else{
			Vector vector = connector.queryReservationInformation(id);
			//可能门诊诊间还没有生成排队信息，如果是这样就先默认几个值
			if(vector == null){
				returnData.put("queueNumber", 0);
				returnData.put("waitTime", 0);
				returnData.put("peopleCount", 0);
			}else{
				int peopleCount = (Integer)vector.get(0);
				//因为门诊诊间没有提供预计等待时间的功能，所以这里我们假设等待时间是病人数*5
				returnData.put("queueNumber", vector.get(1));
				returnData.put("waitTime", peopleCount * 5);
				returnData.put("peopleCount", peopleCount);
			}
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
