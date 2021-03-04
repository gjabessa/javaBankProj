public enum accountType {
	SAVINGS("Savings"),
	CREDIT("Credit"), 
	CHECKING("Checking");
	
	private accountType(String s){
		this.name = s;
	}
	private final String name;
	
	public String toString() {
		return this.name;
	}
};

