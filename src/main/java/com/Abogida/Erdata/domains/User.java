package com.Abogida.Erdata.domains;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.awt.Image;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@Entity
public class User {
	@NotNull
	@Size(min=8, message="Name must be at least 8 characters long")
	private String name;
	@NotNull
	@Id
	private String userName;
	@NotNull
	@Size(min = 5 ,message = "passcode must be greater than 4 characters")
	private String passcode;
	@NotNull
	private String accountType;
}
