<%-- 
    Document   : header_segment
    Created on : Jan 6, 2015, 9:31:33 PM
    Author     : emam
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int timeout = session.getMaxInactiveInterval();
    response.setHeader("Refresh", timeout + "; URL = Login");
%>
<!DOCTYPE html>
<div id="navigation">
    <div class="container-fluid">
        <a href="#" id="brand">اﻷدارة </a>
        <a href="#" class="toggle-nav" rel="tooltip" data-placement="bottom" title="Toggle navigation"><i class="icon-reorder"></i></a>
        <ul class='main-nav'>
            <li >
                <a href="Dashboard">
                    <span>اللوحة الرئيسية</span>
                </a>
            </li>
            <li >
                <a href="#" data-toggle="dropdown" class='dropdown-toggle'>
                    <span>اﻹعدادات</span>
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">

                    <li>
                        <a href="Departments">إعداد الادارات</a>
                    </li>
                    <li>
                        <a href="Workflows">إعداد المخططات</a>
                    </li>


                </ul>
            </li>
            <li >
                <a href="#" data-toggle="dropdown" class='dropdown-toggle'>
                    <span>الوظائف</span>
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                    <li>
                        <a href="">طليات التصديقات</a>
                    </li>
                    <li>
                        <a href="">ادخال وظيفة</a>
                    </li>


                </ul>
            </li>
            <li >
                <a href="#" data-toggle="dropdown" class='dropdown-toggle'>
                    <span>التقارير</span>
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                    <li>
                        <a href="DisplayAudit">تقرير وحدة التدقيق</a>
                    </li>


                </ul>
            </li>

        </ul>
        <div class="user">

            <div class="dropdown">
                <a href="#" class='dropdown-toggle' data-toggle="dropdown"> <img src="img/demo/user-avatar.jpg" alt=""></a>
                <ul class="dropdown-menu pull-right">

                    <li>
                        <a href="Logout">تسجيل خروج</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>