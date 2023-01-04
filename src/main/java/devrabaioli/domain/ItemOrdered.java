package devrabaioli.domain;

import java.io.Serializable;

import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class ItemOrdered  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private ItemOrderedPK id = new ItemOrderedPK();
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date date;
	
	public ItemOrdered() {}

	public ItemOrdered(Date date, Ordered ordered, Lost lost) {
		super();
		this.date = date;
		id.setOrdered(ordered);
		id.setLost(lost);
	}
	
	@JsonIgnore
	public Lost getLos() {
		return id.getLost();
	}
	
	@JsonIgnore
	public Ordered getOrdered() {
		return id.getOrdered();
	}

	public ItemOrderedPK getId() {
		return id;
	}

	public void setId(ItemOrderedPK id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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
		ItemOrdered other = (ItemOrdered) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
