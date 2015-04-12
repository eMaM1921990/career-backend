package com.career.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.career.model.workflow;
import com.career.utils.DBConnection;
import com.career.utils.SqlCommon;
import java.util.logging.Level;
import java.util.logging.Logger;

public class workflow_dao implements dao<workflow> {

    DBConnection db = new DBConnection();
    SqlCommon sql = new SqlCommon();

    @Override
    public String Presist(workflow o) {
        String msg=null;
        try {
            // TODO Auto-generated method stub
            db.connect();
            db.pstm = db.con.prepareStatement(sql.INSERT_WORKFLOW, db.pstm.RETURN_GENERATED_KEYS);
            db.pstm.setString(1, o.getName());
            db.pstm.setString(2, o.getDescription());
            db.pstm.setInt(3, o.getDept_id());
            db.pstm.setString(4, o.getCreated_by());
            db.pstm.execute();
            db.rs = db.pstm.getGeneratedKeys();
            while (db.rs.next()) {
                msg = db.rs.getString(1);
            }
            
            db.closeConnection();
        } catch (SQLException ex) {
            db.closeConnection();
            Logger.getLogger(workflow_dao.class.getName()).log(Level.SEVERE, null, ex);
            msg="["+ex.getErrorCode()+"]"+ex.getMessage();
        }
        
        return msg;
    }

    @Override
    public workflow Find(String phone) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String remove(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<workflow> FindAll() {
        // TODO Auto-generated method stub
        List<workflow> data = new ArrayList<>();
        db.connect();
        try {
            db.pstm = db.con.prepareStatement(sql.GET_ALL_WORKFLOW_FOR_DEPT);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            db.rs = db.pstm.executeQuery();
            while (db.rs.next()) {
                workflow w = new workflow();
                w.setId(db.rs.getInt(1));
                w.setName(db.rs.getString(2));
                w.setDescription(db.rs.getString(3));
                w.setCreated_at(db.rs.getString(5));
                w.setCreated_by(db.rs.getString(6));
                w.setDept_id(db.rs.getInt(4));
                w.setDepartment(db.rs.getString(7));
                w.setIs_active(db.rs.getInt(8));
                data.add(w);
            }

            db.closeConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            db.closeConnection();
            e.printStackTrace();
        }

        return data;
    }

    @Override
    public List<workflow> FindByParentId(int parentID) {
        // TODO Auto-generated method stub
        List<workflow> data = new ArrayList<>();
        db.connect();
        try {
            db.pstm = db.con.prepareStatement(sql.GET_ALL_WORKFLOW_FOR_DEPT + " AND W.dept_id=?");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            db.pstm.setInt(1, parentID);
            db.rs = db.pstm.executeQuery();
            while (db.rs.next()) {
                workflow w = new workflow();
                w.setId(db.rs.getInt(1));
                w.setName(db.rs.getString(2));
                w.setDescription(db.rs.getString(3));
                w.setCreated_at(db.rs.getString(4));
                w.setCreated_by(db.rs.getString(5));
                w.setDept_id(db.rs.getInt(6));
                w.setDepartment(db.rs.getString(7));
                data.add(w);
            }

            db.closeConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            db.closeConnection();
            e.printStackTrace();
        }

        return data;
    }

    @Override
    public List<workflow> FindBy(workflow o) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String update(workflow o) {
        // TODO Auto-generated method stub
        return null;
    }

}
