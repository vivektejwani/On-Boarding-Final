package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import Entities.Admin;
import Entities.Employee;
import Entities.HR;

public interface OnBoardingPortalController  {

	public ModelAndView loginEmployee(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") Employee employee) ;

	public ModelAndView loginAdmin(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") Admin admin);

	public ModelAndView loginHr(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") HR hr) ;
}
