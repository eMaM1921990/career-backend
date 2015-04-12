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

    public String DELETE_WORKFLOW_APPROVAL = "DELETE FROM employment.workflow_approval WHERE id=?;";

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
}
