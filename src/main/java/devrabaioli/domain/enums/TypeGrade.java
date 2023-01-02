package devrabaioli.domain.enums;

public enum TypeGrade {
	
	WITHVALUE(1, "With Value"),
	OUTVALUE(2, "Without Value"),
	OTHER(3, "Other"),
	WHOLESALE(4, "Wholesale");
	
	private int cod;
	private String description;
	
	private TypeGrade(int cod, String description) {
		this.cod = cod;
		this.description = description;
		
	}
	
	public int getCod() {
		return this.cod;
	}
	
	public String getDescription() {
		return this.description;
	}

	public static TypeGrade toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for (TypeGrade x : TypeGrade.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Invalid Id: " + cod);
	}
}
