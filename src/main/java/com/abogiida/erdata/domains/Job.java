package com.abogiida.erdata.domains;
import lombok.Data;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

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
    //@Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message="Must be formatted MM/YY")
	private String expirationDate;
}
