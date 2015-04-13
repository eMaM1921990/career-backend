package com.career.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.career.dao.workflow_approval_dao;
import com.career.model.workflow_approval;

/**
 * Servlet implementation class approval
 */
@WebServlet("/approval")
public class approval extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public approval() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     *
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    /**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     *
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String msg = null;
        if (request.getParameter("action").equals("a")) {
            msg = RemoveApproval(Integer.valueOf(request.getParameter("workflow_id")));
            if (!msg.contains("[")) {
                msg = addApproval(Integer.valueOf(request.getParameter("approval_one")), Integer.valueOf(request.getParameter("step_one")), Integer.valueOf(request.getParameter("workflow_id")));
                if (!msg.contains("[")) {
                    msg = addApproval(Integer.valueOf(request.getParameter("approval_two")), Integer.valueOf(request.getParameter("step_two")), Integer.valueOf(request.getParameter("workflow_id")));
                }
            }

        }

        response.getWriter().write(msg);

    }

    protected String addApproval(int approval_id, int step, int workflow) {
        workflow_approval w = new workflow_approval();
        w.setApproval_id(approval_id);
        w.setStep(step);
        w.setWorkflow_id(workflow);

        workflow_approval_dao approval_dao = new workflow_approval_dao();
        String return_msg = approval_dao.Presist(w);
        return return_msg;
    }

    

    protected String RemoveApproval(int id) {
        workflow_approval w = new workflow_approval();
        w.setId(id);
        workflow_approval_dao approval_dao = new workflow_approval_dao();
        String returned_msg = approval_dao.remove(id);

        return returned_msg;
    }

}
