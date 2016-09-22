package com.scrumbot.services;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.work.web.controllers.ProcessController;

@Controller
public class SlashCommandService {
	private static Logger logger = Logger.getLogger(SlashCommandService.class.getPackage().getName());
	@RequestMapping("/")
	public void landDashboard(HttpServletRequest request, 
			HttpServletResponse response){
		try{
			System.out.println("Internally");
			response.sendRedirect("index");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/command/push",method=RequestMethod.POST)
	public void incomingSlackPush(HttpServletRequest request, 
			HttpServletResponse response, 
			@RequestBody String payload){
		try{
			logger.info(payload); 
		}catch(Exception e){
			e.printStackTrace();
		}
		response.setContentType("application/json");
		response.getWriter().write("{\"response_type\" : \"in_channel\"}");
	}
	
}
