package com.Startup.Training.Center.Service;

import java.time.Instant;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Startup.Training.Center.Entity.TrainingCenter;
import com.Startup.Training.Center.Repository.TrainingCenterRepository;

@Service
public class TrainingCenterService
{
	
	private final TrainingCenterRepository repository;

	public TrainingCenterService(TrainingCenterRepository repository) 
	{
        this.repository = repository;
    }

    public TrainingCenter createTrainingCenter(TrainingCenter center)
    {
        center.setCreatedOn(Instant.now());  
        return repository.save(center);
    }

    public List<TrainingCenter> getAllTrainingCenters() 
    {
        return repository.findAll();
    }
}
