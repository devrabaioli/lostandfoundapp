package devrabaioli.domain;

import java.io.Serializable;
import java.util.Objects;

import devrabaioli.domain.enums.StateFound;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Found implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private Integer state;
	
	@OneToOne
	@JoinColumn(name="ordered_id")
	@MapsId
	private Ordered ordered;
	
	public Found() {}
	
	
	public Found(Integer id, StateFound state) {
		super();
		this.id = id;
		this.state = state.getCod();
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public StateFound getState() {
		return StateFound.toEnum(state);
	}

	public void setState(StateFound state) {
		this.state = state.getCod();
	}
	
	public Ordered getOrdered() {
		return ordered;
	}


	public void setOrdered(Ordered ordered) {
		this.ordered = ordered;
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
		Found other = (Found) obj;
		return Objects.equals(id, other.id);
	}


}
