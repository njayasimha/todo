package com.todo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.todo.domain.ToDo;
import com.todo.repository.ToDoRepository;

@Component
public class ToDoServiceImpl implements ToDoService {

	@Autowired
    ToDoRepository toDoRepository;

	@Override
	public ToDo findById(long id) {
		return toDoRepository.findOne(id);
	}

	@Override
	public void saveToDo(ToDo toDo) {
		toDoRepository.save(toDo);
	}

	@Override
	public void updateToDo(ToDo toDo) {
		toDoRepository.save(toDo);
	}

	@Override
	public void deleteToDoById(long id) {
		toDoRepository.delete(id);
	}

	@Override
	public List<ToDo> findAllToDos() {
		List<ToDo> toDoList = new ArrayList<ToDo>();
		toDoList = toDoRepository.findAll();
		return toDoList;
	}

	@Override
	public void deleteAllToDos() {
		toDoRepository.deleteAll();
	}

	@Override
	public boolean isToDoExist(ToDo toDo) {
		boolean recordExist = false;
		ToDo currentToDo = toDoRepository.findOne(toDo.getId());
		if(currentToDo != null) {
			recordExist = true;
		}
		return recordExist;
	}
}
