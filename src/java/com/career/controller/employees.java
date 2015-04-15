/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.career.controller;

import com.career.dao.employee_dao;
import com.career.model.employee;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author emam
 */
public class employees extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
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
        String msg=null;
        if(request.getParameter("action").equals("a")){
            msg=addEmp(request.getParameter("f_name"), request.getParameter("l_name"),Integer.valueOf(request.getParameter("dept_id")), Integer.valueOf(request.getParameter("his_manager")), request.getParameter("email"));
        }else if(request.getParameter("action").equals("d")){
            msg=deteleEmp(Integer.valueOf(request.getParameter("id")));
        }else {
            
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

    
    protected String addEmp(String f_name,String l_name,int dept_id,int his_manager,String email){
        employee e=new employee();
        e.setL_name(l_name);
        e.setF_name(f_name);
        e.setDept_id(dept_id);
        e.setHis_manager(his_manager);
        e.setEmail(email);
        employee_dao dao=new employee_dao();
        
        return dao.Presist(e);
    }
    
    protected String deteleEmp(int id){
        employee_dao dao=new employee_dao();
        return dao.remove(id);
    }
    
    protected String EditEmp(String f_name,String l_name,int dept_id,int his_manager,String email,int id){
        employee e=new employee();
        e.setL_name(l_name);
        e.setF_name(f_name);
        e.setDept_id(dept_id);
        e.setHis_manager(his_manager);
        e.setEmail(email);
        e.setId(id);
        employee_dao dao=new employee_dao();
        return dao.update(e);
    }
}
