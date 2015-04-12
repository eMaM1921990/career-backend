/**
 * message 
 */

var u_name_msg = "ادخل اسم المستخدم";
var password_msg = "ادخل كلمة المرور";
var login_msg = "خطأ فى اسم المستخدم او كلمة المرور";
var departmentname_msg = " ادخل اسم الادارة";
var fromdate_msg = "ادخل التاريخ من ";
var todate_msg = "ادخل التاريخ الى";

function CheckLogin() {
    var u_name = $('#u_name').val();
    var password = $('#password').val();

    if (parseInt(u_name.length) === 0) {
        $('#err').html(u_name_msg);
    } else if (parseInt(password.length) === 0) {
        $('#err').html(password_msg);
    } else {

        DoLogin(u_name, password);
    }
}

function DoLogin(u_name, password) {

    $.post('logauth', {u_name: u_name, password: password}, function(responseText) {

        if (responseText === "Dashboard") {
            window.open('Dashboard', '_self');
        } else if (responseText === "ChangePassword") {
            window.open('ChangePassword', '_self');
        } else {
            $('#err').html(responseText);
        }

    });
}


function addDepartment() {
    var name = $('#name').val();

    if (parseInt(name.length) === 0) {
        $('#display').html(departmentname_msg);
    } else {
        $.post('department?action=a', {name: name}, function(responseText) {

        });
    }
}

function DeleteDepartment(id) {


    $.post('department?action=d', {id: id}, function(responseText) {
        location.reload();
    });
}

function AddWorkflow(id) {
    $.post('', {}, function(responseText) {

    });
}

function EditDepartment() {
    var id = $('#id').val();
    var name = $('#name').val();
    if (parseInt(name.length) === 0) {
        $('#display').html(departmentname_msg);
    } else {
        $.post('department?action=e', {name: name, id: id}, function(responseText) {

        });
    }

}


function LoadAudit() {
    var from = $('#from').val();
    var to = $('#to').val();
    if (parseInt(from.length) === 0) {
        $('#displayfrom').html(fromdate_msg);
    } else if (parseInt(to.length) === 0) {
        $('#displayto').html(todate_msg);
    } else {
        $.post('getAuditReports', {from: from, to: to}, function(responseText) {
            $('#audittable tr:last').after(responseText);
        });
    }

}


function addWorkflow() {
    var name = $('#name').val();
    var description = $('#description').val();
    var dept_id = $('#dept_id').val();

    if (parseInt(name.length) === 0) {
        $('#dept_id-display').html('اختر الادارة');
    } else if (parseInt(description.length) === 0) {
        $('#name-display').html('ادخل اسم المخطط');
    } else if (parseInt(dept_id.trim().length) === 0) {
        $('#description-display').html('ادخل الوصف');
    } else {
        $.post('workflow?action=a', {name: name, description: description, dept_id: dept_id}, function(responsetext) {
            
            if (responsetext.indexOf("[")>0) {
                var msg = '<div class=\"alert alert-danger\">' + responsetext + '</div>';
                $('#response').html(msg);
            } else {
                
                var msg = '<div class=\"alert alert-success\">تم اضافة المخطط بنجاح</div>';
                $('#response').html(msg);
            }
        });
    }
}