/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.career.dao;

import com.career.model.employee;
import com.career.utils.DBConnection;
import com.career.utils.SqlCommon;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emam
 */
public class employee_dao implements dao<employee> {

    DBConnection db = new DBConnection();
    SqlCommon sql = new SqlCommon();

    @Override
    public String Presist(employee o) {
        String msg = null;
        try {
            db.connect();
            db.pstm = db.con.prepareStatement(sql.INSERT_EMP);
            db.pstm.setString(1, o.getF_name());
            db.pstm.setString(2, o.getL_name());
            db.pstm.setInt(3, o.getDept_id());
            db.pstm.setInt(4, o.getHis_manager());
            db.pstm.setString(5, o.getEmail());
            db.pstm.executeUpdate();
            db.closeConnection();
            msg = "تم حفظ البيانات";
        } catch (SQLException ex) {
            db.closeConnection();
            msg = "[" + ex.getErrorCode() + "]" + ex.getMessage();
            Logger.getLogger(employee_dao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return msg;
    }

    @Override
    public employee Find(String phone) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String remove(int id) {
        String msg = null;
        try {
            db.connect();
            db.pstm = db.con.prepareStatement(sql.DELETE_EMP);
            db.pstm.setInt(1, id);
            db.pstm.executeUpdate();
            db.closeConnection();
            msg = "تم حذف البيانات";
        } catch (SQLException ex) {
            db.closeConnection();
            msg = "[" + ex.getErrorCode() + "]" + ex.getMessage();
            Logger.getLogger(employee_dao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return msg;
    }

    @Override
    public List<employee> FindAll() {
        List<employee> data = new ArrayList<>();
        try {
            db.connect();
            db.pstm = db.con.prepareStatement(sql.GET_ALL_EMP);
            db.rs = db.pstm.executeQuery();
            while (db.rs.next()) {
                employee e = new employee();
                e.setId(db.rs.getInt(1));
                e.setF_name(db.rs.getString(2));
                e.setL_name(db.rs.getString(3));
                e.setDept_id(db.rs.getInt(4));
                e.setHis_manager(db.rs.getInt(5));
                e.setEmail(db.rs.getString(6));
                e.setDepartment(db.rs.getString(7));
                e.setManager_f_name(db.rs.getString(8));
                e.setManager_l_name(db.rs.getString(9));
                data.add(e);
            }

            db.closeConnection();
        } catch (SQLException ex) {
            db.closeConnection();
            Logger.getLogger(employee_dao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return data;
    }

    @Override
    public List<employee> FindByParentId(int parentID) {
        List<employee> data = new ArrayList<>();
        try {
            db.connect();
            db.pstm = db.con.prepareStatement(sql.GET_DEPT_EMP);
            db.pstm.setInt(1, parentID);
            db.rs = db.pstm.executeQuery();
            while (db.rs.next()) {
                employee e = new employee();
                e.setId(db.rs.getInt(1));
                e.setF_name(db.rs.getString(2));
                e.setL_name(db.rs.getString(3));
                e.setDept_id(db.rs.getInt(4));
                e.setHis_manager(db.rs.getInt(5));
                e.setEmail(db.rs.getString(6));
                data.add(e);
            }
            db.closeConnection();
        } catch (SQLException ex) {
            db.closeConnection();
            Logger.getLogger(employee_dao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return data;
    }

    @Override
    public List<employee> FindBy(employee o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String update(employee o) {
        String msg=null;
        try {
            db.connect();
            db.pstm = db.con.prepareStatement(sql.UPDATE_EMP);
            db.pstm.setString(1, o.getF_name());
            db.pstm.setString(2, o.getL_name());
            db.pstm.setInt(3, o.getDept_id());
            db.pstm.setInt(4, o.getHis_manager());
            db.pstm.setString(5, o.getEmail());
            db.pstm.setInt(6, o.getId());
            db.pstm.executeUpdate();
            db.closeConnection();
            msg="تم تعديل البيانات";
        } catch (SQLException ex) {
            db.closeConnection();
            msg = "[" + ex.getErrorCode() + "]" + ex.getMessage();
            Logger.getLogger(employee_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return msg;
    }

}
