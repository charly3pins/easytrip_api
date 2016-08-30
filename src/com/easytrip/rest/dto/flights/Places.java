package com.easytrip.rest.dto.flights;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Places {
	@JsonProperty("Id")
	String id;
	@JsonProperty("ParentId")
	String parentId;
	@JsonProperty("Code")
	String code;
	@JsonProperty("Type")
	String type;
	@JsonProperty("Name")
	String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
		
}
