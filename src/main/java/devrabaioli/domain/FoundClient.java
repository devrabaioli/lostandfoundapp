package devrabaioli.domain;

import java.util.Date;

import devrabaioli.domain.enums.StateFound;
import jakarta.persistence.Entity;

@Entity
public class FoundClient extends Found {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String localAddress;
	private Date dateClaim;
	
	public FoundClient () {}

	public FoundClient(Integer id, StateFound state, String name, String localAddress, Date dateClaim) {
		super(id, state);
		this.name = name;
		this.localAddress = localAddress;
		this.dateClaim = dateClaim;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocalAddress() {
		return localAddress;
	}

	public void setLocalAddress(String localAddress) {
		this.localAddress = localAddress;
	}

	public Date getDateClaim() {
		return dateClaim;
	}

	public void setDateClaim(Date dateClaim) {
		this.dateClaim = dateClaim;
	}
	
	

}
