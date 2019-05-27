package com.Abogida.Erdata.domains;
import com.Abogida.Erdata.domains.Job.Type;

import lombok.Data;

import java.awt.Image;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.Abogida.Erdata.domains.FreeAid.AidType;

@Data
@Entity
public class Donor{ 
	public String name;
	@Id
	public String userName;
	public String passcode;
	public Job postJob(Type type,double salary,boolean haveQualification) {
		
		return new Job(type,salary,haveQualification);
	}
	public FreeAid giveFreeAid(AidType aidType) {
		return new FreeAid(aidType);
	}
}
