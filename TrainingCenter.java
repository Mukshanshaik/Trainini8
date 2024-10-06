package com.Startup.Training.Center.Entity;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.Instant;
import java.util.List;

@Entity
public class TrainingCenter 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "CenterName is required")
    @Size(max = 40, message = "CenterName must be less than 40 characters")
    private String centerName;

    @NotBlank(message = "CenterCode is required")
    @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "CenterCode must be 12 alphanumeric characters")
    private String centerCode;

    @Embedded
    private Address address;

    @Min(value = 1, message = "Student Capacity must be positive")
    private int studentCapacity;

    @ElementCollection
    @Size(min = 1, message = "At least one course must be offered")
    private List<String> coursesOffered;

    private Instant createdOn;

    @Email(message = "Invalid email format")
    private String contactEmail;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    private String contactPhone;

	public void setCreatedOn(Instant now) {
		// TODO Auto-generated method stub
		
	}
}

@Embeddable

class Address 
{
    private String detailedAddress;
    private String city;
    private String state;
    private String pincode;
}
