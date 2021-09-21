package com.model;

public class Role {
	
	private int rolid;
	private String roleNmae;
	
	
	public Role(int rolid, String roleNmae) {
		super();
		this.rolid = rolid;
		this.roleNmae = roleNmae;
	}
	
	public int getRolid() {
		return rolid;
	}
	public void setRolid(int rolid) {
		this.rolid = rolid;
	}
	public String getRoleNmae() {
		return roleNmae;
	}
	public void setRoleNmae(String roleNmae) {
		this.roleNmae = roleNmae;
	}

}
