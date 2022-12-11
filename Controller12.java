package com.example.zomato.project.controller;



import java.util.List;

import com.example.zomato.project.blueprint.Zomato;
import com.example.zomato.project.service.ZomatoService;

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

@RestController
@RequestMapping("/zomato")
public class Controller12 {
	private ZomatoService zomatoServ;

	public Controller12(ZomatoService zomatoServ) {
		this.zomatoServ = zomatoServ;
	}
	@PostMapping("/insert")
	//when u try to insert a rec
	//@reqBod --> when u r expectmg an obj frm the url
	public ResponseEntity<Zomato> saveRestaurents(@RequestBody Zomato obj) {
		return new ResponseEntity<Zomato>(zomatoServ.saveRestaurents(obj), 
				HttpStatus.CREATED);	
	}
	@GetMapping("/viewAllRestaurents")
	public List<Zomato> getAllLearnersFromDb(){

		return zomatoServ.fetchAllRestaurents(); //all the recrds from the db
	}

	///learners/8
	@GetMapping("{id}")
	public ResponseEntity<Zomato>
	fetchOneLearner(@PathVariable("id")  int zomatoId) throws Exception{
		return new ResponseEntity<Zomato>(zomatoServ.fetchById(zomatoId), HttpStatus.OK)	;
	}
	//learners/update/8
		@PutMapping("/update/{id}")
		public ResponseEntity<Zomato>
		updateLeanre(@PathVariable("id") int id, @RequestBody Zomato fromServer ){
			return new ResponseEntity<Zomato>(zomatoServ.updateRestaurents(id, fromServer),HttpStatus.OK);

		}

			@DeleteMapping("{id}")
			public ResponseEntity<String>
			deleteRestaurentsByAcceptingId(@PathVariable("id") int id){
				zomatoServ.deleteRestaurents(id);
				return new ResponseEntity<String>("record deleted", HttpStatus.OK);
			}
}
