package com.todo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder
@Entity
@Table(name = "TODO")
public class ToDo  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, updatable = false)
	public Long id;
	
	@Column(name = "TYPE", nullable = false, updatable = false)
	public String type;
	
	@Column(name = "CONTENT", nullable = false, updatable = false)
	public String content;
	
	@Column(name = "STATUS", nullable = false, updatable = false)
	public ToDoStatus status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public ToDoStatus getStatus() {
		return status;
	}
	public void setStatus(ToDoStatus status) {
		this.status = status;
	}
}
