package devrabaioli.domain;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import devrabaioli.domain.enums.TypeUserApp;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;


@Entity
public class WhoFind {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Integer type;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "whoFind")
	private Lost lost;
	
	public WhoFind() {}

	public WhoFind(Integer id, String name,TypeUserApp type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type.getCod();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TypeUserApp getType() {
		return TypeUserApp.toEnum(type);
	}

	public void setType(TypeUserApp type) {
		this.type = type.getCod();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@JsonIgnore
	public Lost getLost() {
		return lost;
	}

	public void setLost(Lost lost) {
		this.lost = lost;
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
		WhoFind other = (WhoFind) obj;
		return Objects.equals(id, other.id);
	}



}
