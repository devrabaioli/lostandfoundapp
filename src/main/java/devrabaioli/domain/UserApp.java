package devrabaioli.domain;

import java.io.Serializable;
import java.util.Objects;

import devrabaioli.domain.enums.TypeUserApp;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class UserApp implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String email;
	private Integer type;
	
	public UserApp() {}

	public UserApp(Integer id, String name, String email, TypeUserApp type) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.type = type.getCod();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TypeUserApp getType() {
		return TypeUserApp.toEnum(type);
	}

	public void setType(TypeUserApp type) {
		this.type = type.getCod();
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		UserApp other = (UserApp) obj;
		return Objects.equals(id, other.id);
	}

	
	
	
	
	

}
