package devrabaioli.domain;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import devrabaioli.domain.enums.TypeGrade;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Grade implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer type;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "grade")
	private List<Lost> losts = new ArrayList<>();
	
	public Grade() {}

	public Grade(Integer id, TypeGrade type) {
		super();
		this.id = id;
		this.type = type.getCod();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TypeGrade getType() {
		return TypeGrade.toEnum(type);
	}

	public void setType(TypeGrade type) {
		this.type = type.getCod();
	}
	
	@JsonIgnore
	public List<Lost> getLosts() {
		return losts;
	}

	public void setLosts(List<Lost> losts) {
		this.losts = losts;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grade other = (Grade) obj;
		return Objects.equals(id, other.id);
	}


}
