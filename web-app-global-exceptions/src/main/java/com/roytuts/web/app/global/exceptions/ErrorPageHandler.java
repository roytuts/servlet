package com.roytuts.web.app.global.exceptions;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ErrorPageHandler")
public class ErrorPageHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ErrorPageHandler() {
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

		StringBuilder sb = new StringBuilder();

		if (throwable == null && statusCode == null) {
			sb.append("Error information is missing").append("<br/>").append("Please return to the Home Page");
		} else if (statusCode != null) {
			sb.append("Status Code: ").append(statusCode).append("</br/>")
					.append("For more information on status code please go to Status Code Definitions");
		} else {
			sb.append("Error information").append("<br/>").append("Servlet Name : ").append(servletName)
					.append("Exception Type : ").append(throwable.getClass().getName()).append("The request URI: ")
					.append(requestUri).append("<br/>").append("The exception message: ")
					.append(throwable.getMessage());
		}

		request.setAttribute("errorMsg", sb.toString());

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/error/error.jsp");
		requestDispatcher.forward(request, response);
	}

}
