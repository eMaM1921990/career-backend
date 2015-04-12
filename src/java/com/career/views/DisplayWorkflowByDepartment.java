package com.career.views;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.career.dao.workflow_approval_dao;
import com.career.dao.workflow_dao;
import com.career.model.workflow;
import com.career.model.workflow_approval;

/**
 * Servlet implementation class DisplayWorkflowByDepartment
 */
@WebServlet("/DisplayWorkflowByDepartment")
public class DisplayWorkflowByDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayWorkflowByDepartment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int Dept_id=Integer.valueOf(request.getParameter("dept_id"));
		workflow_dao dao=new workflow_dao();
		List<workflow> data=dao.FindByParentId(Dept_id);
		request.setAttribute("Department_wf", data);
		
		/**
		 * Display workflow approval
		 */
		
		int workflow_id=Integer.valueOf(request.getParameter("workflow_id"));
		workflow_approval_dao approval_dao=new workflow_approval_dao();
		List<workflow_approval> approval_data=approval_dao.FindByParentId(workflow_id);
		request.setAttribute("approval", approval_data);
		
		RequestDispatcher send=request.getRequestDispatcher("/workflow/DepartmentWorkflow.jsp");
		send.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
