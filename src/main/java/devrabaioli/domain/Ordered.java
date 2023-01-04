package devrabaioli.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Ordered implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date instant;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "ordered")
	private Found found;
	
	@ManyToOne
	@JoinColumn(name="userapp_id")
	private UserApp userapp;
	
	@OneToMany(mappedBy = "id.ordered")
	private Set<ItemOrdered> itens = new HashSet<>();
	
	public Ordered() {}

	public Ordered(Integer id, Date instant, UserApp userapp) {
		super();
		this.id = id;
		this.instant = instant;
		this.userapp = userapp;
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
	
	public UserApp getUserapp() {
		return userapp;
	}

	public void setUserapp(UserApp userapp) {
		this.userapp = userapp;
	}
	
	public Set<ItemOrdered> getItens() {
		return itens;
	}

	public void setItens(Set<ItemOrdered> itens) {
		this.itens = itens;
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
