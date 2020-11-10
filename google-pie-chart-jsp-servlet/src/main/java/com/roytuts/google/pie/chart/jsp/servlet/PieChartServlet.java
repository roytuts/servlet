package com.roytuts.google.pie.chart.jsp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.roytuts.google.pie.chart.jsp.servlet.repo.PieChartRepo;
import com.roytuts.google.pie.chart.jsp.servlet.repo.PieChartRepo.KeyValue;

@WebServlet("/PieChart")
public class PieChartServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PieChartServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<KeyValue> pieDataList = PieChartRepo.getPieDataList();
        System.out.println("pieDataList: " + pieDataList);
        
        request.setAttribute("pieDataList", pieDataList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/chart.jsp");
        requestDispatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
