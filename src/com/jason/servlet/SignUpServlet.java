package com.jason.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.jason.utils.JSONResolver;

/**
 * Servlet implementation class SignUpServlet
 */
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		JSONResolver resolver = new JSONResolver(request, response);
		JSONObject data = resolver.getJSONObeject();
		System.out.println(data.toString(2));
		
		String name = data.getString("sName");
		String password = data.getString("sPassword");
		int genderCode = data.getInt("genderCode");
		String id = data.getString("sId");
		String insuranceId = data.getString("sInsuranceId");
		String insuranceCode = data.getString("insuranceCode");
		
		JSONObject returnData = new JSONObject();
		returnData.put("isSucceed", true);
		
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
