package devrabaioli.dto;

import java.io.Serializable;

import devrabaioli.domain.Grade;
import devrabaioli.domain.enums.TypeGrade;

public class GradeDTO implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private TypeGrade description;
	
	public GradeDTO() {}
	
	public GradeDTO(Grade obj) {
		description = obj.getType();
	}

	public TypeGrade getDescription() {
		return description;
	}

	public void setDescription(TypeGrade description) {
		this.description = description;
	}
	
	

}
