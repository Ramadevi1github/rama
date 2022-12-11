package com.example.zomato.project.reposatory;

import com.example.zomato.project.blueprint.Zomato;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ZomatoInterface extends JpaRepository<Zomato, Integer>{


}
