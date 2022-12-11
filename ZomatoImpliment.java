package com.example.zomato.project.impliment;

import java.util.List;
import java.util.Optional;
import com.example.zomato.project.blueprint.Zomato;
import com.example.zomato.project.reposatory.ZomatoInterface;
import com.example.zomato.project.service.ZomatoService;

import org.springframework.stereotype.Service;
@Service
public class ZomatoImpliment implements ZomatoService{
	private ZomatoInterface zomatoInt;

	public ZomatoImpliment(ZomatoInterface zomatoInt) {
		this.zomatoInt = zomatoInt;
	}
	public Zomato saveRestaurents(Zomato obj) {
		return zomatoInt.save(obj);  //insert query 
	}

	//get , find --> fetch only 1 rec on the basis id provided
	//findall
	public List<Zomato> fetchAllRestaurents(){

		return zomatoInt.findAll();//select * from learners_table
	}
	public Zomato fetchById(int id) throws Exception {
		Optional<Zomato> obj = zomatoInt.findById(id);	
		if(obj.isPresent()) {
			return obj.get();
		}
		else
		{
			throw new Exception("not found"); 
		}
	}
	public Zomato updateRestaurents(int id, Zomato newVal){
		Optional<Zomato> obj = zomatoInt.findById(id);	
		if(obj.isPresent()) {
			Zomato objFromDB = obj.get();
			objFromDB.setRestaurantName(newVal.getRestaurantName());
			objFromDB.setAverageCost(newVal.getAverageCost());
			objFromDB.setRating(newVal.getRating());
			zomatoInt.save(objFromDB);
			return objFromDB;
		}
		return new Zomato();
	}
	
	public void deleteRestaurents(int restaurantId) {
		Optional<Zomato> obj = zomatoInt.findById(restaurantId);	
		if(obj.isPresent()) {
			zomatoInt.deleteById(restaurantId);
		}

	}
}
