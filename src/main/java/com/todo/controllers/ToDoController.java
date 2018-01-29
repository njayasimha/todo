package com.todo.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.todo.domain.ToDo;
import com.todo.service.ToDoService;


@RestController
@RequestMapping(value = "/todo" )
public class ToDoController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ToDoController.class);
	
	@Autowired
    private ToDoService toDoService;
	
	/*-------------------Create a ToDo--------------------------------------------------------*/
	@PostMapping(value = "/", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Void> createToDo(@RequestBody ToDo toDo,    UriComponentsBuilder ucBuilder) {
		LOGGER.debug("Creating a TODO :" + toDo.getContent());
        if (toDoService.isToDoExist(toDo)) {
        	LOGGER.debug("A ToDo with content " + toDo.getContent() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        toDoService.saveToDo(toDo);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/todo/{id}").buildAndExpand(toDo.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
	
	/*------------------- Update a ToDo --------------------------------------------------------*/
	@PutMapping(value = "/{id}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<ToDo> updateToDo(@PathVariable("id") long id,
    		@RequestBody ToDo toDo) {
		LOGGER.debug("Updating ToDo " + id);
        ToDo currentToDo = toDoService.findById(id);
        if (currentToDo==null) {
        	LOGGER.debug("ToDo with id " + id + " not found");
            return new ResponseEntity<ToDo>(HttpStatus.NOT_FOUND);
        }
        currentToDo.setStatus(toDo.getStatus());
        toDoService.updateToDo(currentToDo);
        return new ResponseEntity<ToDo>(currentToDo, HttpStatus.OK);
    }
	
	/*-------------------Delete a ToDo--------------------------------------------------------*/
    @DeleteMapping(value = "/{id}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<ToDo> deleteToDo(@PathVariable("id") long id) {
    	LOGGER.debug("Fetching & Deleting ToDo with id " + id);
        ToDo toDo = toDoService.findById(id);
        if (toDo == null) {
        	LOGGER.debug("Unable to delete. ToDo with id " + id + " not found");
            return new ResponseEntity<ToDo>(HttpStatus.NOT_FOUND);
        }
        toDoService.deleteToDoById(id);
        return new ResponseEntity<ToDo>(HttpStatus.NO_CONTENT);
    }
    
    /*-------------------Delete all ToDo--------------------------------------------------------*/
    @DeleteMapping(value = "/", produces = "application/json;charset=UTF-8")
    public ResponseEntity<ToDo> deleteAllToDo() {
    	LOGGER.debug("Deleting All ToDo");
    	toDoService.deleteAllToDos();
        return new ResponseEntity<ToDo>(HttpStatus.NO_CONTENT);
    }
    
    /*-------------------Retrieve All ToDo's--------------------------------------------------------*/
    @GetMapping(value = "/" , produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<ToDo>> listAllToDos() {
        List<ToDo> todos = toDoService.findAllToDos();
        if(todos.isEmpty()){
            return new ResponseEntity<List<ToDo>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ToDo>>(todos, HttpStatus.OK);
    }
}