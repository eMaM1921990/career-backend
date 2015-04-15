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

            if (responsetext.indexOf("[") > 0) {
                var msg = '<div class=\"alert alert-danger\">' + responsetext + '</div>';
                $('#response').html(msg);
            } else {

                var msg = '<div class=\"alert alert-success\">تم اضافة المخطط بنجاح</div>';
                $('#response').html(msg);
            }
        });
    }
}


function addApproval() {
    var approval_one = $('#approval_one').val();
    var approval_two = $('#approval_two').val();
    var step_one = $('#step_one').val();
    var step_two = $('#step_two').val();
    var workflow_id = $('#workflow_id').val();
    if (parseInt(approval_one.length) === 0) {
        $('#approval_one-display').html('اختر المصدق للموافقة المبدئية ');
    } else if (parseInt(approval_two.length) === 0) {
        $('#approval_two-display').html('اختر المصدق للموافقة النهائية ');
    } else {
        $.post('approval?action=a', {approval_one: approval_one, approval_two: approval_two, step_one: step_one, step_two: step_two, workflow_id: workflow_id}, function(responsetext) {
            if (responsetext.indexOf('[') > 0) {
                var msg = '<div class=\"alert alert-danger\">' + responsetext + '</div>';
            } else {
                var msg = '<div class=\"alert alert-success\">' + responsetext + '</div>';
            }

            $('#response').html(msg);
        });
    }
}


function getDepartmentEmp() {
    var dept_id = $('#dept_id').val();
    if (parseInt(dept_id.trim().length) !== 0) {
        $.post('getDepartmentEmp', {dept_id: dept_id}, function(responseText) {

            $('#his_manager').empty();
            //$('#his_manager').append(responseText);

        });
    }
}


function addEmployee() {
    var f_name = $('#f_name').val();
    var l_name = $('#l_name').val();
    var dept_id = $('#dept_id').val();
    var his_manager = $('#his_manager').val();
    var email = $('#email').val();

    if (parseInt(f_name.trim().length) === 0) {
        $('#f_name-display').html('ادخل الاسم الاول');
    } else if (parseInt(l_name.trim().length) === 0) {
        
        $('#l_name-display').html('ادخل الاسم الاخير');
        $('#f_name-display').hide();
    } else if (parseInt(dept_id.trim().length) === 0) {
        $('#dept_id-display').html('اختر الادارة');
        $('#f_name-display').hide();
        $('#l_name-display').hide();
    } else if (parseInt(his_manager.trim().length) === 0) {
        $('#his_manager-display').html('اختر المدير المباشر');
        $('#f_name-display').hide();
        $('#l_name-display').hide();
        $('#dept_id-display').hide();
    } else if (parseInt(email.trim().length) === 0) {
        $('#email-display').html('ادخل البريد الالكترونى');
        $('#f_name-display').hide();
        $('#l_name-display').hide();
        $('#dept_id-display').hide();
        
    }else{
        $.post('employees?action=a', {f_name: f_name, l_name: l_name, dept_id: dept_id, his_manager: his_manager, email: email}, function(responseText) {
            if (responseText.indexOf('[') > 0) {
                var msg = '<div class=\"alert alert-danger\">' + responseText + '</div>';
            } else {
                var msg = '<div class=\"alert alert-success\">' + responseText + '</div>';
            }

            $('#response').html(msg);
        });
    }
}


function DeleteEmp(id){
    $.post('employees?action=d',{id:id},function (responseText){
         if (responseText.indexOf('[') > 0) {
                var msg = '<div class=\"alert alert-danger\">' + responseText + '</div>';
            } else {
                var msg = '<div class=\"alert alert-success\">' + responseText + '</div>';
            }

            $('#response').html(msg);
            location.reload();
    });
}


function EditEmp(){
     var f_name = $('#f_name').val();
    var l_name = $('#l_name').val();
    var dept_id = $('#dept_id').val();
    var his_manager = $('#his_manager').val();
    var email = $('#email').val();
    var id=$('#id').val();

    if (parseInt(f_name.trim().length) === 0) {
        $('#f_name-display').html('ادخل الاسم الاول');
    } else if (parseInt(l_name.trim().length) === 0) {
        
        $('#l_name-display').html('ادخل الاسم الاخير');
        $('#f_name-display').hide();
    } else if (parseInt(dept_id.trim().length) === 0) {
        $('#dept_id-display').html('اختر الادارة');
        $('#f_name-display').hide();
        $('#l_name-display').hide();
    } else if (parseInt(his_manager.trim().length) === 0) {
        $('#his_manager-display').html('اختر المدير المباشر');
        $('#f_name-display').hide();
        $('#l_name-display').hide();
        $('#dept_id-display').hide();
    } else if (parseInt(email.trim().length) === 0) {
        $('#email-display').html('ادخل البريد الالكترونى');
        $('#f_name-display').hide();
        $('#l_name-display').hide();
        $('#dept_id-display').hide();
    } else if (email.indexOf('@') < 0) {
        $('#email-display').html('البريد الالكترونى غير صحيح');
    } else {
        $.post('employees?action=e', {f_name: f_name, l_name: l_name, dept_id: dept_id, his_manager: his_manager, email: email,id:id}, function(responseText) {
            if (responseText.indexOf('[') > 0) {
                var msg = '<div class=\"alert alert-danger\">' + responseText + '</div>';
            } else {
                var msg = '<div class=\"alert alert-success\">' + responseText + '</div>';
            }

            $('#response').html(msg);
        });
    }
}