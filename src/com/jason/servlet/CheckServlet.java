package com.jason.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.jason.utils.JSONResolver;

/**
 * Servlet implementation class CheckServlet
 */
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		else
			doGetFromWebsite(request, response);
	}

	private void doGetFromWebsite(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void doGetFromApp(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		JSONResolver resolver = new JSONResolver(request, response);
		JSONObject data = resolver.getJSONObeject();
		System.out.println(data.toString(2));
		
		String id = data.getString("id");
		boolean isCancel = data.getBoolean("isCancel");
		
		
		JSONObject returnData = new JSONObject();
		if(isCancel)
			returnData.put("queueNumber", -1);
		else
			returnData.put("queueNumber", 1);
		returnData.put("waitTime", 0);
		returnData.put("peopleNumber", 0);
		
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
