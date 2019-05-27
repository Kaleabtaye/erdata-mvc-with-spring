package com.Abogida.Erdata.domains;
import lombok.Data;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank(message = "Field cannot be empty")
	private String type;
	@Digits(integer = 7,fraction = 5,message = "Invalid amount")
	private double salary;
	private boolean haveQualification;
	@Digits(integer = 2,fraction = 0 ,message = "Invalid type")
	private int experience;
	@NotBlank(message = "field cannot be empty")
	private Date expirationDate;
}
