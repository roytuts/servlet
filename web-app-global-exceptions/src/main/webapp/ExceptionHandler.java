package com.roytuts.web.app.global.exceptions;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ExceptionHandler")
public class ExceptionHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExceptionHandler() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		cathException(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		cathException(request, response);
	}

	private void cathException(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");

		String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
		if (servletName == null) {
			servletName = "Unknown Path Segment";
		}

		String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
		if (requestUri == null) {
			requestUri = "Unknown Request URI";
		}

		if (throwable == null && statusCode == null) {
			String msg = "Error information is missing";
			msg += "Please return to the Home Page";
			request.setAttribute("errorMsg", msg);
		} else if (statusCode != null) {
			String msg = "Status Code: " + statusCode + " ";
			msg += "For more information on status code please go to Status Code Definitions";
			request.setAttribute("errorMsg", msg);
		} else {
			String msg = "Error information";
			msg += "Servlet Name : " + servletName + " ";
			msg += "Exception Type : " + throwable.getClass().getName() + "";
			msg += "The request URI: " + requestUri + " ";
			msg += "The exception message: " + throwable.getMessage();
			request.setAttribute("errorMsg", msg);
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/error/error.jsp");
		requestDispatcher.forward(request, response);
	}

}
