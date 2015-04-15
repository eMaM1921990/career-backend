package com.career.utils;

public class SqlCommon {

    public String GET_ALL_WORKFLOW_FOR_DEPT = "SELECT W.id, W.name, W.description, W.dept_id, W.created_ar, W.created_by,D.\"NAME\"\n"
            + ",W.is_active FROM employment.workflow W INNER JOIN employment.\"Department\" D\n"
            + "ON W.dept_id=D.id;";
    public String GET_WORKFLOW_APPROVAL = "SELECT W.id, W.approval_id, W.step, W.workflow_id,E.f_name||' '||E.L_name,WF.name"
            + "FROM employment.workflow_approval W INNER JOIN employment.employee E"
            + "ON W.approval_id=E.id INNER JOIN employment.workflow WF"
            + "ON WF.id=W.workflow_id AND W.workflow_id=?;";
    public String INSERT_WORKFLOW_APPROVAL = "INSERT INTO employment.workflow_approval(approval_id, step, workflow_id) VALUES ( ?, ?, ?); ";

    public String UPDATE_WORKFLOW_APPROVAL = "UPDATE employment.workflow_approval SET approval_id=?, step=?, workflow_id=? WHERE id=?;";

    public String DELETE_WORKFLOW_APPROVAL = "DELETE FROM employment.workflow_approval WHERE workflow_id=?;";

    public String LOGIN = "SELECT u_name, password, first_login, user_type, emp_id\n"
            + "  FROM employment.employee_user  WHERE u_name=? AND password=?;";

    public String FIRST_LOGIN = "UPDATE employment.employee_user SET first_login=? WHERE u_name=?";

    public String INSERT_DEPARTMENT = "INSERT INTO employment.\"Department\"(\n"
            + "             \"NAME\")\n"
            + "    VALUES ( ?);";

    public String GET_ALL_DEPARTMENT = "SELECT id, \"NAME\"\n"
            + "  FROM employment.\"Department\";";

    public String UPDATE_DEPARTMENT = "UPDATE employment.\"Department\"\n"
            + "   SET  \"NAME\"=?\n"
            + " WHERE id=?;";

    public String DELETE_DEPARTMENT = "DELETE FROM employment.\"Department\"\n"
            + " WHERE id=?";

    public String INSERT_AUDIT = "INSERT INTO employment.audit_log(\n"
            + "            action, createdby)\n"
            + "    VALUES ( ?, ?);";

    public String DISPLAY_LOG = "SELECT createdat, action, id, createdby\n"
            + "  FROM employment.audit_log WHERE createdat >= ?::date AND createdat <= ?::date;";

    public String GET_DEPARTMENT_NOT_HAVE_WORKFLOW = "SELECT id,\"NAME\" FROM employment.\"Department\" D \n"
            + "WHERE D.id NOT IN (SELECT dept_id FROM employment.workflow);";

    public String INSERT_WORKFLOW = "INSERT INTO employment.workflow(\n"
            + "             name, description, dept_id, created_by)\n"
            + "    VALUES (?, ?, ?, ?);";

    public String GET_DEPT_EMP = "SELECT id, f_name, l_name, dept_id, his_manager, email\n"
            + "  FROM employment.employee WHERE dept_id=?;";

    public String GET_STEP_APPROVAL = "SELECT approval_id FROM employment.workflow_approval WHERE workflow_id=? AND step=?";

    public String GET_ALL_EMP = "SELECT e.id, e.f_name, e.l_name, e.dept_id, e.his_manager, e.email,D.\"NAME\",emp.f_name,emp.l_name\n"
            + "FROM employment.employee e INNER JOIN employment.\"Department\" D ON D.id=e.dept_id INNER JOIN employment.employee emp\n"
            + "ON emp.id=e.id;";

    public String INSERT_EMP = "INSERT INTO employment.employee(\n"
            + "             f_name, l_name, dept_id, his_manager, email)\n"
            + "    VALUES (?, ?, ?, ?, ?);";

    public String DELETE_EMP = "DELETE FROM employment.employee\n"
            + " WHERE id=?";

    public String UPDATE_EMP = "UPDATE employment.employee\n"
            + "   SET  f_name=?, l_name=?, dept_id=?, his_manager=?, email=?\n"
            + " WHERE id=?";

    public String UPDATE_PASSWORD = "UPDATE employment.employee_user\n"
            + "   SET  password=?\n"
            + " WHERE u_name=?";
}
