package com.workintech.fswebs17d1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/workintech")
public class AnimalController {

@Value("${course.name}")
private String courseName;

@Value("${project.developer.fullname}")
private String developerName;

private Map<Integer, Animal> animals = new HashMap<>();


}
