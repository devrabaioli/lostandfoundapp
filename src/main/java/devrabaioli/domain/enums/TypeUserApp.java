package devrabaioli.domain.enums;

public enum TypeUserApp {
	
	EMPLOYEE(1, "Employee"),
	CLIENTE(2, "Client"),
	OTHER(3, "Other");
	
	private int cod;
	private String description;
	
	private TypeUserApp(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}
	
	public int getCod() {
		return this.cod;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public static TypeUserApp toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for (TypeUserApp x : TypeUserApp.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Object not found: TypeUserApp id: " + cod + "Class: " + TypeUserApp.class.getName());
	}

}
