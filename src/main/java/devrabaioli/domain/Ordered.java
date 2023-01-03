package devrabaioli.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Ordered implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date instant;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "ordered")
	private Found found;
	
	public Ordered() {}

	public Ordered(Integer id, Date instant) {
		super();
		this.id = id;
		this.instant = instant;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInstant() {
		return instant;
	}

	public void setInstant(Date instant) {
		this.instant = instant;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	public Found getFound() {
		return found;
	}

	public void setFound(Found found) {
		this.found = found;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ordered other = (Ordered) obj;
		return Objects.equals(id, other.id);
	}



}
