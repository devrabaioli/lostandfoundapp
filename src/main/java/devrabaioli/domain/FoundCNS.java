package devrabaioli.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import devrabaioli.domain.enums.StateFound;
import jakarta.persistence.Entity;

@Entity
public class FoundCNS extends Found{

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dateClaim;
	
	
	public FoundCNS() {}

	public FoundCNS(Integer id, StateFound state, Ordered ordered, String name, Date dateClaim) {
		super(id, state, ordered);
		this.name = name;
		this.dateClaim = dateClaim;
	}
	

	public Date getDateClaim() {
		return dateClaim;
	}

	public void setDateClaim(Date dateClaim) {
		this.dateClaim = dateClaim;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
