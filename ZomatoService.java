package com.example.zomato.project.service;

import java.util.List;

import com.example.zomato.project.blueprint.Zomato;

public interface ZomatoService {
	Zomato saveRestaurents(Zomato obj);
	List<Zomato> fetchAllRestaurents();
	Zomato fetchById(int restaurantId) throws Exception;
	Zomato updateRestaurents(int restaurantId, Zomato newVal);
	void deleteRestaurents(int restaurantId);
}
