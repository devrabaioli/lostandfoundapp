package devrabaioli.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ItemOrderedPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "ordered_id")
	private Ordered ordered;
	
	@ManyToOne
	@JoinColumn(name ="lost_id")
	private Lost lost;
	
	
	public Ordered getOrdered() {
		return ordered;
	}
	public void setOrdered(Ordered ordered) {
		this.ordered = ordered;
	}
	public Lost getLost() {
		return lost;
	}
	public void setLost(Lost lost) {
		this.lost = lost;
	}
	@Override
	public int hashCode() {
		return Objects.hash(lost, ordered);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemOrderedPK other = (ItemOrderedPK) obj;
		return Objects.equals(lost, other.lost) && Objects.equals(ordered, other.ordered);
	}
	
	
	
	

}
