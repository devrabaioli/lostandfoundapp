package devrabaioli.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import devrabaioli.domain.Grade;
import devrabaioli.domain.Lost;


public class LostDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	private String description;
	private String local;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date date;
	private String whoFind;
	private Grade grade;
	
	
	public LostDTO() {}
	
	public LostDTO(Lost obj) {
		description = obj.getDescriptrionLost();
		local = obj.getLocal();
		date = obj.getDate();
		whoFind = obj.getWhoFind().getName();
		setGrade(obj.getGrade());
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getWhoFind() {
		return whoFind;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	
	
	
}
