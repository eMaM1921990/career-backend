/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.career.controller;

import com.career.dao.employee_user_dao;
import com.career.model.employee_user;
import com.career.utils.MD5;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author emam
 */
public class logauth extends HttpServlet {

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
        String u_name = request.getParameter("u_name");
        String password = request.getParameter("password");
        MD5 encrypt = new MD5();
        employee_user_dao dao = new employee_user_dao();
        employee_user u = new employee_user();
        u.setU_name(u_name);
        u.setPassword(encrypt.getMD5Password(password));
        u = dao.FindByData(u);
        if (u.getU_name() == null) {
            response.getWriter().write("اسم المتسخدم  او كلمة المرور غير صحيح");
        } else {
            HttpSession session = request.getSession();
            u.setEmp_id(u.getEmp_id());
            u.setFirst_login(u.getFirst_login());
            u.setPassword(encrypt.getMD5Password(u.getPassword()));
            u.setU_name(u.getU_name());
            session.setAttribute("login", u);
            if (u.getFirst_login() == 1) {
                response.getWriter().write("ChangePassword");
             
            } else {
                response.getWriter().write("Dashboard");
                
            }
        }
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

}
