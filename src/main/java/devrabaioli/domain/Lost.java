package devrabaioli.domain;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


@Entity
public class Lost implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private String descriptrion;
	private String local;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date date;
	
	
	@OneToOne
	@JoinColumn(name="who_find_id")
	@MapsId
	private WhoFind whoFind;
	
	@ManyToOne
	@JoinColumn(name="grade_id")
	private Grade grade;
	
	
	@OneToMany(mappedBy = "id.lost")
	private Set<ItemOrdered> itens = new HashSet<>();
	
	public Lost() {}

	public Lost(Integer id, String descriptrion, String local, Date date, Grade grade, WhoFind whoFind) {
		super();
		this.id = id;
		this.descriptrion = descriptrion;
		this.local = local;
		this.date = date;
		this.grade = grade;
		this.whoFind = whoFind;
	}
	
	
	public List<Ordered> getOrdereds(){
		List<Ordered> list = new ArrayList<>();
		for(ItemOrdered x : itens) {
			list.add(x.getOrdered());
		}
		return list;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescriptrion() {
		return descriptrion;
	}

	public void setDescriptrion(String descriptrion) {
		this.descriptrion = descriptrion;
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

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	
	public WhoFind getWhoFind() {
		return whoFind;
	}

	public void setWhoFind(WhoFind whoFind) {
		this.whoFind = whoFind;
	}
	
	public Set<ItemOrdered> getItens() {
		return itens;
	}

	public void setItens(Set<ItemOrdered> itens) {
		this.itens = itens;
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
		Lost other = (Lost) obj;
		return Objects.equals(id, other.id);
	}



}
