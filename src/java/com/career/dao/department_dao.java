/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.career.dao;

import com.career.model.department;
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
public class department_dao implements dao<department>{

    DBConnection db=new DBConnection();
    SqlCommon sql=new SqlCommon();
    @Override
    public String Presist(department o) {
        String msg=null;
        try {
            db.connect();
            db.pstm=db.con.prepareStatement(sql.INSERT_DEPARTMENT);
            db.pstm.setString(1, o.getNAME());
            db.pstm.executeUpdate();
            db.closeConnection();
            msg="تم حفظ البيانات";
        } catch (SQLException ex) {
            db.closeConnection();
            Logger.getLogger(department_dao.class.getName()).log(Level.SEVERE, null, ex);
            msg="["+ex.getErrorCode()+"]"+ex.getMessage();
        }
        return msg;
    }

    @Override
    public department Find(String phone) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String remove(int id) {
        String msg=null;
        try {
            db.connect();
            db.pstm=db.con.prepareStatement(sql.DELETE_DEPARTMENT);
            db.pstm.setInt(1, id);
            db.pstm.executeUpdate();
            db.closeConnection();
            msg="تم حذف البيانات";
        } catch (SQLException ex) {
            Logger.getLogger(department_dao.class.getName()).log(Level.SEVERE, null, ex);
            msg="["+ex.getErrorCode()+"]"+ex.getMessage();
            db.closeConnection();
        }
        return msg;
    }

    @Override
    public List<department> FindAll() {
        List<department> data=new ArrayList<>();
        try {
            db.connect();
            db.pstm=db.con.prepareStatement(sql.GET_ALL_DEPARTMENT);
            db.rs=db.pstm.executeQuery();
            while(db.rs.next()){
                department d=new department();
                d.setId(db.rs.getInt(1));
                d.setNAME(db.rs.getString(2));
                data.add(d);
            }
            
            db.closeConnection();
        } catch (SQLException ex) {
            db.closeConnection();
            Logger.getLogger(department_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;
    }

    @Override
    public List<department> FindByParentId(int parentID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<department> FindBy(department o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String update(department o) {
        String msg=null;
        try {
            db.connect();
            db.pstm=db.con.prepareStatement(sql.UPDATE_DEPARTMENT);
            db.pstm.setString(1, o.getNAME());
            db.pstm.setInt(2, o.getId());
            db.pstm.executeUpdate();
            db.closeConnection();
            msg="تم تعديل البيانات";
        } catch (SQLException ex) {
            db.closeConnection();
            Logger.getLogger(department_dao.class.getName()).log(Level.SEVERE, null, ex);
            msg="["+ex.getErrorCode()+"]"+ex.getMessage();
        }
        return msg;
    }
    
    public List<department> FindAllDepartmentNotinWork() {
        List<department> data=new ArrayList<>();
        try {
            db.connect();
            db.pstm=db.con.prepareStatement(sql.GET_DEPARTMENT_NOT_HAVE_WORKFLOW);
            db.rs=db.pstm.executeQuery();
            while(db.rs.next()){
                department d=new department();
                d.setId(db.rs.getInt(1));
                d.setNAME(db.rs.getString(2));
                data.add(d);
            }
            
            db.closeConnection();
        } catch (SQLException ex) {
            db.closeConnection();
            Logger.getLogger(department_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;
    }

    
}
