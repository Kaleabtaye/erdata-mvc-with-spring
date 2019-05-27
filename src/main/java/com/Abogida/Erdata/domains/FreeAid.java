package com.Abogida.Erdata.domains;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class FreeAid {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	private AidType aidType;
	@Digits(integer = 5 ,fraction = 3,message = "invalid amount")
	private float amount;
	@NotBlank(message = "field cannot be empty")
	private String materialName;

	public static enum AidType{
		MATERIAL,MONEY
	}
}
