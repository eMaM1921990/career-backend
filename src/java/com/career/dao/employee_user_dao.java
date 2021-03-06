package com.career.dao;

import com.career.model.employee;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.career.model.employee_user;
import com.career.utils.DBConnection;
import com.career.utils.SqlCommon;
import java.util.logging.Level;
import java.util.logging.Logger;

public class employee_user_dao implements dao<employee_user> {

	DBConnection db=new DBConnection();
	SqlCommon sql=new SqlCommon();
	@Override
	public String Presist(employee_user o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public employee_user Find(String phone) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String remove(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<employee_user> FindAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<employee_user> FindByParentId(int parentID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<employee_user> FindBy(employee_user o) {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	@Override
	public String update(employee_user o) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public employee_user FindByData(employee_user o){
		employee_user emp=new employee_user();
		db.connect();
		try {
			db.pstm=db.con.prepareStatement(sql.LOGIN);
			db.pstm.setString(1, o.getU_name());
			db.pstm.setString(2, o.getPassword());
			db.rs=db.pstm.executeQuery();
			while(db.rs.next()){
				emp.setU_name(db.rs.getString(1));
				emp.setPassword(db.rs.getString(2));
				emp.setFirst_login(db.rs.getInt(3));
				emp.setEmp_id(db.rs.getInt(4));
			}
			
			db.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			db.closeConnection();
			e.printStackTrace();
		}
		return emp;
	}
	
	public String updateFirstLogin(String u_name){
            String msg=null;
		db.connect();
		try {
			db.pstm=db.con.prepareStatement(sql.FIRST_LOGIN);
                        db.pstm.setInt(1, 0);
			db.pstm.setString(2, u_name);
			db.pstm.executeUpdate();
			db.closeConnection();
                        msg="تم تحديث البيانات";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			msg="["+e.getErrorCode()+"]"+e.getMessage();
			db.closeConnection();
		}
                
                return msg;
		
	}
        
        public String Changepasswordfirstlogin(employee_user u){
            String msg=null;
            try {
                db.connect();
                db.pstm=db.con.prepareStatement(sql.UPDATE_PASSWORD);
                db.pstm.setString(1, u.getPassword());
                db.pstm.setString(2, u.getU_name());
                db.pstm.executeUpdate();
                db.closeConnection();
                msg="تم تعديل كلمة المرور";
            } catch (SQLException ex) {
                db.closeConnection();
                msg="["+ex.getErrorCode()+"]"+ex.getMessage();
                Logger.getLogger(employee_user_dao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return msg;
        }

}
