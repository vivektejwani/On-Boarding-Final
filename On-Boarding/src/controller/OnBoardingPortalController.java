package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import requests.EmployeeGroupRequest;
import Entities.*;

public interface OnBoardingPortalController {

	// TODO:add methods after changing signature
	
	
	
	
	public ModelAndView loginUser(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") User user);

	public ModelAndView logout(HttpServletRequest request,
			HttpServletResponse response);

	public ModelAndView addHR(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") HR hr);

	public ModelAndView removeHR(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") HR hr);

	public ModelAndView generatePassword(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") HR hr);

	public ModelAndView createGroup(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") Group group);

	public ModelAndView removeGroup(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") Group group);

	public ModelAndView createPost(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") Message message);

	public ModelAndView removePost(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") Message message);
	
	
	
	

	public ModelAndView updateProfileOfEmployee(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") Employee employee);

	public ModelAndView updateProfileOfHR(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") HR hr);

	public ModelAndView addEmployeeToGroup(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("") EmployeeGroupRequest employeeGroupRequest);

	public ModelAndView removeEmployeeFromGroup(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("") EmployeeGroupRequest employeeGroupRequest);
}
