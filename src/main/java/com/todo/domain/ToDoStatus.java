package com.todo.domain;

import java.io.Serializable;

public enum ToDoStatus implements Serializable {
	PENDING, ACTIVE;
	public String toString() {
		switch (this) {
		case PENDING:
			return "Pending";
		case ACTIVE:
			return "Active";
		}
		return null;
	}

	public static ToDoStatus valuOf(Class<ToDoStatus> enumType, String value) {
		if (value.equalsIgnoreCase(PENDING.toString()))
			return ToDoStatus.PENDING;
		else if (value.equalsIgnoreCase(ACTIVE.toString()))
			return ToDoStatus.ACTIVE;
		else
			return null;
	}
}
