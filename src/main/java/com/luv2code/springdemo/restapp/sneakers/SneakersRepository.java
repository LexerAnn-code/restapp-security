package com.luv2code.springdemo.restapp.sneakers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface SneakersRepository extends JpaRepository<SneakersModel,Integer> {
  SneakersModel findByName(String name);
}
