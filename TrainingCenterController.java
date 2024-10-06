package com.Startup.Training.Center.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Startup.Training.Center.Entity.TrainingCenter;
import com.Startup.Training.Center.Service.TrainingCenterService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/training-centers")

public class TrainingCenterController
{
	
	private final TrainingCenterService Service ;
	
	public TrainingCenterController(TrainingCenterService Service)
	   {
		this.Service= Service;
	   }
	@PostMapping
	public ResponseEntity<TrainingCenter>createCenter(@Valid @RequestBody TrainingCenter center)
	{
		TrainingCenter savedCenter = Service.createTrainingCenter(center);
		return new ResponseEntity<>(savedCenter , HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<TrainingCenter>>getAllCenters()
	{
		List<TrainingCenter> centers = Service.getAllTrainingCenters();
		return new ResponseEntity<>(centers ,HttpStatus.OK);
	}
}
