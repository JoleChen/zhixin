package cn.theblueearth.zhixin.model;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = -3516742374750823885L;
	private Long id;
	private String name;
	
	public User(){}
	
	public User(String name){
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
