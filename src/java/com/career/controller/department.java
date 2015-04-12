/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.career.controller;

import com.career.dao.audit_dao;
import com.career.dao.department_dao;
import com.career.model.audit;
import com.career.model.employee_user;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.attribute.AclEntryType;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author emam
 */
public class department extends HttpServlet {

    employee_user e;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        HttpSession session=request.getSession();
        e=(employee_user)session.getAttribute("login");
        String msg = null;
        ///add
        if (request.getParameter("action").equals("a")) {
            msg = addDepartment(request.getParameter("name"));

            //edit    
        } else if (request.getParameter("action").equals("e")) {
            msg = editdepartment(request.getParameter("name"), Integer.valueOf(request.getParameter("id")));

            //delete    
        } else {
            msg=deleteDepartment(Integer.valueOf(request.getParameter("id")));
        }

        response.getWriter().write(msg);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    protected String addDepartment(String name) {
        com.career.model.department d = new com.career.model.department();
        d.setNAME(name);
        department_dao dao = new department_dao();
        String result=dao.Presist(d);
        if(!result.contains("[")){
            audit_dao dap_aud=new audit_dao();
            audit a=new audit();
            a.setCreatedby(e.getU_name());
            a.setAction("["+name+"] اضافة ادارة");
            dap_aud.Presist(a);
        }
        return result;

    }

    protected String editdepartment(String name, int id) {
        com.career.model.department d = new com.career.model.department();
        d.setNAME(name);
        d.setId(id);

        department_dao dao = new department_dao();
        String result= dao.update(d);
        
        if(!result.contains("[")){
            audit_dao dap_aud=new audit_dao();
            audit a=new audit();
            a.setCreatedby(e.getU_name());
            a.setAction("["+name+"] تعديل ادارة");
            dap_aud.Presist(a);
        }
        return result;
    }

    protected String deleteDepartment(int id) {
        department_dao dao = new department_dao();
        String result=dao.remove(id);
         if(!result.contains("[")){
            audit_dao dap_aud=new audit_dao();
            audit a=new audit();
            a.setCreatedby(e.getU_name());
            a.setAction("["+id+"] تعديل ادارة");
            dap_aud.Presist(a);
        }
        return result;
    }
}
