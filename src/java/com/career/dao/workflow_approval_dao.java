package com.career.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.career.model.workflow_approval;
import com.career.utils.DBConnection;
import com.career.utils.SqlCommon;

public class workflow_approval_dao implements dao<workflow_approval> {
	
	final String saved_msg="تم حفظ البيانات";
	final String update_msg="تم تعديل البيانات";
	final String delete_msg="تم حذف البيانات";
	
	DBConnection db=new DBConnection();
	SqlCommon sql=new SqlCommon();
	

	public String Presist(workflow_approval o) {
		// TODO Auto-generated method stub
		String msg=null;
		db.connect();
		try {
			db.pstm=db.con.prepareStatement(sql.INSERT_WORKFLOW_APPROVAL);
			db.pstm.setInt(1, o.getApproval_id());
			db.pstm.setInt(2, o.getStep());
			db.pstm.setInt(3, o.getWorkflow_id());
			db.pstm.executeUpdate();
			db.closeConnection();
			msg=saved_msg;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg="["+e.getErrorCode()+"]"+e.getMessage();
			db.closeConnection();
		}
		
		return msg;
	}

	public workflow_approval Find(String phone) {
		// TODO Auto-generated method stub
		return null;
	}

	public String remove(int id) {
		// TODO Auto-generated method stub
		String msg=null;
		db.connect();
		try {
			db.pstm=db.con.prepareStatement(sql.DELETE_WORKFLOW_APPROVAL);
			db.pstm.setInt(1, id);
			db.pstm.executeUpdate();
			db.closeConnection();
			msg=delete_msg;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg="["+e.getErrorCode()+"]"+e.getMessage();
		}
		
		return msg;
	}

	public List<workflow_approval> FindAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<workflow_approval> FindByParentId(int parentID) {
		// TODO Auto-generated method stub
		List<workflow_approval> data=new ArrayList<>();
		db.connect();
		try {
			db.pstm=db.con.prepareStatement(sql.GET_WORKFLOW_APPROVAL);
			db.pstm.setInt(1, parentID);
			db.rs=db.pstm.executeQuery();
			while(db.rs.next()){
				workflow_approval w=new workflow_approval();
				w.setId(db.rs.getInt(1));
				w.setApproval_id(db.rs.getInt(2));
				w.setStep(db.rs.getInt(3));
				w.setWorkflow_id(db.rs.getInt(4));
				w.setWorkflow_name(db.rs.getString(5));
				w.setWorkflow_name(db.rs.getString(6));
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

	
	public List<workflow_approval> FindBy(workflow_approval o) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String update(workflow_approval o) {
		// TODO Auto-generated method stub 
		String msg=null;
		db.connect();
		try {
			db.pstm=db.con.prepareStatement(sql.UPDATE_WORKFLOW_APPROVAL);
			db.pstm.setInt(1, o.getApproval_id());
			db.pstm.setInt(2, o.getStep());
			db.pstm.setInt(3, o.getWorkflow_id());
			db.pstm.setInt(4, o.getId());
			db.pstm.executeUpdate();
			db.closeConnection();
			msg=update_msg;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg="["+e.getErrorCode()+"]"+e.getMessage();
			db.closeConnection();
		}
		
		return msg;
	}

	
	
}
