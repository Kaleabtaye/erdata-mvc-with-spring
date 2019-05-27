package com.Abogida.Erdata.domains;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Receiver{
	public String name;
	@Id
	public String userName;
	public String passcode;
	public int familyMemberNumber;
}
