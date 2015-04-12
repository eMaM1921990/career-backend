package com.career.model;

public class workflow_approval {

	private int id;
	private int approval_id;
	private int step;
	private int workflow_id;
	private String workflow_name;
	private String approval_name;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the approval_id
	 */
	public int getApproval_id() {
		return approval_id;
	}
	/**
	 * @param approval_id the approval_id to set
	 */
	public void setApproval_id(int approval_id) {
		this.approval_id = approval_id;
	}
	/**
	 * @return the step
	 */
	public int getStep() {
		return step;
	}
	/**
	 * @param step the step to set
	 */
	public void setStep(int step) {
		this.step = step;
	}
	/**
	 * @return the workflow_id
	 */
	public int getWorkflow_id() {
		return workflow_id;
	}
	/**
	 * @param workflow_id the workflow_id to set
	 */
	public void setWorkflow_id(int workflow_id) {
		this.workflow_id = workflow_id;
	}
	/**
	 * @return the workflow_name
	 */
	public String getWorkflow_name() {
		return workflow_name;
	}
	/**
	 * @param workflow_name the workflow_name to set
	 */
	public void setWorkflow_name(String workflow_name) {
		this.workflow_name = workflow_name;
	}
	/**
	 * @return the approval_name
	 */
	public String getApproval_name() {
		return approval_name;
	}
	/**
	 * @param approval_name the approval_name to set
	 */
	public void setApproval_name(String approval_name) {
		this.approval_name = approval_name;
	}
	
}
