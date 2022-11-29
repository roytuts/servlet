package com.roytuts.ajax.servlets.username.availability;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.roytuts.ajax.servlets.username.availability.utils.DBUtils;

/**
 * Servlet implementation class AuthServlet
 */
@WebServlet("/AuthServlet")
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AuthServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		PrintWriter out = response.getWriter();
		if (username != null && username.trim().length() > 0) {
			String sql = "SELECT * FROM user WHERE login_username='" + username.trim() + "' LIMIT 1";
			Connection connection = null;
			ResultSet resultSet = null;
			try {
				connection = DBUtils.getDBConnection();
				resultSet = DBUtils.getDBResultSet(connection, sql);
				if (resultSet != null) {
					if (resultSet.next()) {
						out.print("<span style=\"color:red;\">Username unavailable</span>");
					} else {
						out.print("<span style=\"color:green;\">Username available</span>");
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (resultSet != null) {
					try {
						DBUtils.closeResultSet(resultSet);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (connection != null) {
					try {
						DBUtils.closeDBConnection(connection);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			out.print("<span style=\"color:red;\">Username is required field.</span>");
		}
	}

}
