package com.todo.service;

import java.util.List;

import com.todo.domain.ToDo;

public interface ToDoService {

	ToDo findById(long id);
	
	void saveToDo(ToDo toDo);
	
	void updateToDo(ToDo toDo);
	
	void deleteToDoById(long id);

	List<ToDo> findAllToDos(); 
	
	void deleteAllToDos();
	
	public boolean isToDoExist(ToDo toDo);
}
