package controller.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import controller.OnBoardingPortalController;
import Entities.Admin;
import Entities.Employee;
import Entities.Group;
import Entities.HR;
import Entities.Message;

@Controller
public class OnBoardingPortalControllerImpl implements OnBoardingPortalController{

	@RequestMapping("login")
	public ModelAndView loginEmployee(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") Employee employee) {
				return null;
		

	}

	public ModelAndView loginAdmin(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") Admin admin) {
				return null;

	}

	public ModelAndView loginHr(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") HR hr) {
				return null;

	}
	
	public ModelAndView addHR(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") HR hr){
		return null;
	}
	
	public ModelAndView removeHR(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") HR hr){
		return null;
	}
	
	public ModelAndView generatePassword(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") HR hr){
		return null;
	}
	
	public ModelAndView createGroup(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") Group group){
		return null;
	}
	
	public ModelAndView removeGroup(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") Group group){
		return null;
	}
	
	public ModelAndView createPost(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") Message message){
		return null;
	}
	
	public ModelAndView removePost(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") Message message){
		return null;
	}
	
	public ModelAndView updateProfileOfEmployee(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") Employee employee) {
		return null;


}
	
	public ModelAndView updateProfileOfHR(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") HR hr) {
		return null;


}
}
