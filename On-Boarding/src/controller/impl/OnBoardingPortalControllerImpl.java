package controller.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import controller.OnBoardingPortalController;
import DAO.OnBoardingPortalDAO;
import Entities.Admin;
import Entities.Employee;
import Entities.Group;
import Entities.HR;
import Entities.Message;

@Controller
public class OnBoardingPortalControllerImpl implements
		OnBoardingPortalController {

	@Autowired
	OnBoardingPortalDAO onBoardingPortalDAO;

	//TODO: put url and model attribute
	@RequestMapping("")
	public ModelAndView loginEmployee(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") Employee employee) {

		ModelAndView modelAndView = new ModelAndView();

		if (onBoardingPortalDAO.validateEmployee(employee)) {

			HttpSession session = request.getSession();
			session.setAttribute("user", employee);
			// session.setMaxInactiveInterval(1800);
			// TODO:set view name for page after successful login
			modelAndView.setViewName("");
			return modelAndView;
		}

		// TODO: set view name for error page
		modelAndView.setViewName("");

		return modelAndView;

	}

	//TODO: put url and model attribute
	@RequestMapping("")
	public ModelAndView loginAdmin(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") Admin admin) {
		ModelAndView modelAndView = new ModelAndView();

		if (onBoardingPortalDAO.validateAdmin(admin)) {

			HttpSession session = request.getSession();
			session.setAttribute("user", admin);
			// session.setMaxInactiveInterval(1800);
			// TODO:set view name for page after successful login
			modelAndView.setViewName("");
			return modelAndView;
		}

		// TODO: set view name for error page
		modelAndView.setViewName("");

		return modelAndView;

	}

	//TODO: put url and model attribute
	@RequestMapping("")
	public ModelAndView loginHr(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") HR hr) {
		ModelAndView modelAndView = new ModelAndView();

		if (onBoardingPortalDAO.validateHr(hr)) {

			HttpSession session = request.getSession();
			session.setAttribute("user", hr);
			// session.setMaxInactiveInterval(1800);
			// TODO:set view name for page after successful login
			modelAndView.setViewName("");
			return modelAndView;
		}

		// TODO: set view name for error page
		modelAndView.setViewName("");

		return modelAndView;

	}

	@RequestMapping("")
	public ModelAndView addHR(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") HR hr) {
		return null;
	}

	@RequestMapping("")
	public ModelAndView removeHR(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") HR hr) {
		return null;
	}

	@RequestMapping("")
	public ModelAndView generatePassword(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") HR hr) {
		return null;
	}

	@RequestMapping("")
	public ModelAndView createGroup(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") Group group) {
		return null;
	}

	@RequestMapping("")
	public ModelAndView removeGroup(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") Group group) {
		return null;
	}

	@RequestMapping("")
	public ModelAndView createPost(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") Message message) {
		return null;
	}

	@RequestMapping("")
	public ModelAndView removePost(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") Message message) {
		return null;
	}

	@RequestMapping("")
	public ModelAndView updateProfileOfEmployee(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") Employee employee) {
		return null;

	}

	@RequestMapping("")
	public ModelAndView updateProfileOfHR(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") HR hr) {
		return null;

	}
}
