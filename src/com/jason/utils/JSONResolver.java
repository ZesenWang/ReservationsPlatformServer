package com.jason.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class JSONResolver {
	HttpServletRequest request;
	HttpServletResponse response;
	
	public JSONResolver(HttpServletRequest request, HttpServletResponse response){
		this.request = request;
		this.response = response;
	}
	public JSONObject getJSONObeject(){
		InputStream in = null;
		JSONObject object = null;
		try {
			in = request.getInputStream();
			InputStreamReader reader = new InputStreamReader(in);
			char buffer[] = new char[10];
			StringBuilder sb = new StringBuilder();
			while(reader.read(buffer) != -1){
				sb.append(buffer);
			}
			object = new JSONObject(sb.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(in != null){
					in.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return object;
	}
	public void sendJSONObject(JSONObject object){
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(object.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(out != null){
				out.close();
			}
		}
		
	}
}
