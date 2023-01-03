package devrabaioli.domain.enums;

public enum StateFound {

	DELIVERY(1, "Delivery"),
	NOTDELIVERY(2, "Not Delivery"),
	OTHER(3, "Other");
	
	private int cod;
	private String description;
	
	private StateFound(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}
	
	public int getCod() {
		return this.cod;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public static StateFound toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(StateFound x : StateFound.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Invalid cod: " + cod + " Class: " + StateFound.class);
	}
	
}
