/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.career.dao;

import com.career.model.audit;
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
public class audit_dao implements dao<audit>{

    DBConnection db=new DBConnection();
    SqlCommon sql=new SqlCommon();
    @Override
    public String Presist(audit o) {
        try {
            db.connect();
            db.pstm=db.con.prepareStatement(sql.INSERT_AUDIT);
            db.pstm.setString(1, o.getCreatedby());
            db.pstm.setString(2, o.getAction());
            db.pstm.executeUpdate();
            db.closeConnection();
        } catch (SQLException ex) {
            db.closeConnection();
            Logger.getLogger(audit_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "ok";
        
    }

    @Override
    public audit Find(String phone) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<audit> FindAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<audit> FindByParentId(int parentID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<audit> FindBy(audit o) {
        List<audit> data=new ArrayList<>();
        try {
            db.connect();
            db.pstm=db.con.prepareStatement(sql.DISPLAY_LOG);
            db.pstm.setString(1, o.getDatefrom());
            db.pstm.setString(2, o.getDateto());
            db.rs=db.pstm.executeQuery();
            while(db.rs.next()){
                audit a=new audit();
                a.setCreatedat(db.rs.getString(1));
                a.setAction(db.rs.getString(2));
                a.setCreatedby(db.rs.getString(3));
                data.add(a);
            }
            
            db.closeConnection();
        } catch (SQLException ex) {
            
            db.closeConnection();
            Logger.getLogger(audit_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;
    }

    @Override
    public String update(audit o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
