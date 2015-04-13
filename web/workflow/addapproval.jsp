<%-- 
    Document   : home
    Created on : Jan 9, 2015, 8:41:12 PM
    Author     : emam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
        <!-- Apple devices fullscreen -->
        <meta name="apple-mobile-web-app-capable" content="yes" />
        <!-- Apple devices fullscreen -->
        <meta names="apple-mobile-web-app-status-bar-style" content="black-translucent" />

        <title>Career | Admin Panel</title>


        <!-- Bootstrap -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- Bootstrap responsive -->
        <link rel="stylesheet" href="css/bootstrap-responsive.min.css">
        <!-- jQuery UI -->
        <link rel="stylesheet" href="css/plugins/jquery-ui/smoothness/jquery-ui.css">
        <link rel="stylesheet" href="css/plugins/jquery-ui/smoothness/jquery.ui.theme.css">
        <!-- PageGuide -->
        <link rel="stylesheet" href="css/plugins/pageguide/pageguide.css">
        <!-- Fullcalendar -->
        <link rel="stylesheet" href="css/plugins/fullcalendar/fullcalendar.css">
        <link rel="stylesheet" href="css/plugins/fullcalendar/fullcalendar.print.css" media="print">
        <!-- Tagsinput -->
        <link rel="stylesheet" href="css/plugins/tagsinput/jquery.tagsinput.css">
        <!-- chosen -->
        <link rel="stylesheet" href="css/plugins/chosen/chosen.css">
        <!-- multi select -->
        <link rel="stylesheet" href="css/plugins/multiselect/multi-select.css">
        <!-- timepicker -->
        <link rel="stylesheet" href="css/plugins/timepicker/bootstrap-timepicker.min.css">
        <!-- colorpicker -->
        <link rel="stylesheet" href="css/plugins/colorpicker/colorpicker.css">
        <!-- Datepicker -->
        <link rel="stylesheet" href="css/plugins/datepicker/datepicker.css">
        <!-- Daterangepicker -->
        <link rel="stylesheet" href="css/plugins/daterangepicker/daterangepicker.css">
        <!-- Plupload -->
        <link rel="stylesheet" href="css/plugins/plupload/jquery.plupload.queue.css">
        <!-- select2 -->
        <link rel="stylesheet" href="css/plugins/select2/select2.css">
        <!-- icheck -->
        <link rel="stylesheet" href="css/plugins/icheck/all.css">
        <!-- Theme CSS -->
        <link rel="stylesheet" href="css/style.css">
        <!-- Color CSS -->
        <link rel="stylesheet" href="css/themes.css">


        <!-- jQuery -->
        <script src="js/jquery.min.js"></script>

        <!-- Nice Scroll -->
        <script src="js/plugins/nicescroll/jquery.nicescroll.min.js"></script>
        <!-- imagesLoaded -->
        <script src="js/plugins/imagesLoaded/jquery.imagesloaded.min.js"></script>
        <!-- jQuery UI -->
        <script src="js/plugins/jquery-ui/jquery.ui.core.min.js"></script>
        <script src="js/plugins/jquery-ui/jquery.ui.widget.min.js"></script>
        <script src="js/plugins/jquery-ui/jquery.ui.mouse.min.js"></script>
        <script src="js/plugins/jquery-ui/jquery.ui.resizable.min.js"></script>
        <script src="js/plugins/jquery-ui/jquery.ui.sortable.min.js"></script>
        <script src="js/plugins/jquery-ui/jquery.ui.spinner.js"></script>
        <script src="js/plugins/jquery-ui/jquery.ui.slider.js"></script>
        <!-- Bootstrap -->
        <script src="js/bootstrap.min.js"></script>
        <!-- Bootbox -->
        <script src="js/plugins/bootbox/jquery.bootbox.js"></script>
        <!-- Masked inputs -->
        <script src="js/plugins/maskedinput/jquery.maskedinput.min.js"></script>
        <!-- TagsInput -->
        <script src="js/plugins/tagsinput/jquery.tagsinput.min.js"></script>
        <!-- Datepicker -->
        <script src="js/plugins/datepicker/bootstrap-datepicker.js"></script>
        <!-- Daterangepicker -->
        <script src="js/plugins/daterangepicker/daterangepicker.js"></script>
        <script src="js/plugins/daterangepicker/moment.min.js"></script>
        <!-- Timepicker -->
        <script src="js/plugins/timepicker/bootstrap-timepicker.min.js"></script>
        <!-- Colorpicker -->
        <script src="js/plugins/colorpicker/bootstrap-colorpicker.js"></script>
        <!-- Chosen -->
        <script src="js/plugins/chosen/chosen.jquery.min.js"></script>
        <!-- MultiSelect -->
        <script src="js/plugins/multiselect/jquery.multi-select.js"></script>
        <!-- CKEditor -->
        <script src="js/plugins/ckeditor/ckeditor.js"></script>
        <!-- PLUpload -->
        <script src="js/plugins/plupload/plupload.full.js"></script>
        <script src="js/plugins/plupload/jquery.plupload.queue.js"></script>
        <!-- Custom file upload -->
        <script src="js/plugins/fileupload/bootstrap-fileupload.min.js"></script>
        <script src="js/plugins/mockjax/jquery.mockjax.js"></script>
        <!-- select2 -->
        <script src="js/plugins/select2/select2.min.js"></script>
        <!-- icheck -->
        <script src="js/plugins/icheck/jquery.icheck.min.js"></script>
        <!-- complexify -->
        <script src="js/plugins/complexify/jquery.complexify-banlist.min.js"></script>
        <script src="js/plugins/complexify/jquery.complexify.min.js"></script>
        <!-- Mockjax -->
        <script src="js/plugins/mockjax/jquery.mockjax.js"></script>

        <!-- dataTables -->
        <script src="js/plugins/datatable/jquery.dataTables.min.js"></script>
        <script src="js/plugins/datatable/TableTools.min.js"></script>
        <script src="js/plugins/datatable/ColReorderWithResize.js"></script>
        <script src="js/plugins/datatable/ColVis.min.js"></script>
        <script src="js/plugins/datatable/jquery.dataTables.columnFilter.js"></script>
        <script src="js/plugins/datatable/jquery.dataTables.grouping.js"></script>

        <!-- Theme framework -->
        <script src="js/eakroko.min.js"></script>
        <!-- Theme scripts -->
        <script src="js/application.min.js"></script>
        <!-- Just for demonstration -->
        <script src="js/demonstration.min.js"></script>
        <script src="js/custom.js"></script>

        <!--[if lte IE 9]>
                <script src="js/plugins/placeholder/jquery.placeholder.min.js"></script>
                <script>
                        $(document).ready(function() {
                                $('input, textarea').placeholder();
                        });
                </script>
                <![endif]-->

        <!-- Favicon -->
        <link rel="shortcut icon" href="img/favicon.ico" />
        <!-- Apple devices Homescreen icon -->
        <link rel="apple-touch-icon-precomposed" href="img/apple-touch-icon-precomposed.png" />

    </head>
    <body>
        <%@include file="../navigation.jsp" %>
        <div id="main">
            <div class="container-fluid">

                <span class="span12">



                    <div class="box">
                        <div class="box-title">
                            <h3>
                                <i class="icon-magic"></i>
                                المخططات
                            </h3>
                        </div>  

                    </div>
                    <div id="response"></div>


                </span>

                <div class="row-fluid">


                    <div class="span12">
                        <div class="box">

                            <div class="box-content ">
                                <table class="table table-hover table-nomargin table-colored-header">
                                    <thead>
                                        <tr>
                                            <th>المصـــــدق</th>
                                            <th class="hidden-350" colspan="2">الموافقة</th>

                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>

                                            <td><div class="controls">
                                                    <select name="s2" id="approval_one" class="select2-me input-xlarge select2-offscreen" data-placeholder="اختر المصدق للموافقة المبدئية" tabindex="-1">
                                                        <option value=""></option>
                                                        <c:forEach items="${emp_data}" var="e">
                                                            <c:choose>
                                                                <c:when test="${e.id==approvalone}">
                                                                    <option value="<c:out  value="${e.id}"/>" selected="selected"><c:out  value="${e.f_name}"/><c:out  value="${e.l_name}"/></option>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <option value="<c:out  value="${e.id}"/>"><c:out  value="${e.f_name}"/><c:out  value="${e.l_name}"/></option>
                                                                </c:otherwise>
                                                            </c:choose>

                                                        </c:forEach>


                                                    </select>
                                                    <span class="help-block" style="color: red" id="approval_one-display"></span>
                                                </div></td>
                                            <td><div class="controls">
                                                    <select name="s2" id="step_one" class="select2-me input-xlarge select2-offscreen" data-placeholder="نوع الموافقة" tabindex="-1">

                                                        <option value="0">موافقة مبدئية</option>
                                                    </select>
                                                    <span class="help-block" style="color: red" id="dept_id-display"></span>
                                                </div></td>
                                            <td><img src="img/1.png"  style="width: 50px;float: left;" /></td>
                                        </tr>
                                        <tr>

                                            <td><div class="controls">
                                                    <select name="s2" id="approval_two" class="select2-me input-xlarge select2-offscreen" data-placeholder="اختر المصدق للموافقة المبدئية" tabindex="-1">
                                                        <option value=""></option>
                                                        <c:forEach items="${emp_data}" var="e">
                                                            <c:choose>
                                                                <c:when test="${e.id==approvaltwo}">
                                                                    <option value="<c:out  value="${e.id}"/>" selected="selected"><c:out  value="${e.f_name}"/><c:out  value="${e.l_name}"/></option>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <option value="<c:out  value="${e.id}"/>"><c:out  value="${e.f_name}"/><c:out  value="${e.l_name}"/></option>
                                                                </c:otherwise>
                                                            </c:choose>

                                                        </c:forEach>


                                                    </select>
                                                    <span class="help-block" style="color: red" id="approval_two-display"></span>
                                                </div></td>
                                            <td><div class="controls">
                                                    <select name="s2" id="step_two" class="select2-me input-xlarge select2-offscreen" data-placeholder="نوع الموافقة" tabindex="-1">
                                                        <option value="1">موافقة نهائية</option>
                                                    </select>
                                                    <span class="help-block" style="color: red" id="dept_id-display"></span>
                                                </div></td>
                                            <td><img src="img/2.png"  style="width: 50px;float: left;" /></td>
                                        </tr>
                                    <input type="hidden" id="workflow_id" value="${workflow_id}"/>
                                    </tbody>
                                </table>
                                <button type="button" class="btn btn-orange" onclick="addApproval()">حفظ</button>

                            </div>
                        </div>


                    </div>
                </div>
            </div>
        </div>
    </body>


</html>
