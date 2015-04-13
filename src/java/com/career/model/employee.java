/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.career.model;

/**
 *
 * @author emam
 */
public class employee {
    private int id;
    private String f_name;
    private String l_name;
    private int dept_id;
    private int his_manager;
    private String email;
    private String department;
    private String manager_f_name;
    private String manager_l_name;

    public String getManager_f_name() {
        return manager_f_name;
    }

    public void setManager_f_name(String manager_f_name) {
        this.manager_f_name = manager_f_name;
    }

    public String getManager_l_name() {
        return manager_l_name;
    }

    public void setManager_l_name(String manager_l_name) {
        this.manager_l_name = manager_l_name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public int getHis_manager() {
        return his_manager;
    }

    public void setHis_manager(int his_manager) {
        this.his_manager = his_manager;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
