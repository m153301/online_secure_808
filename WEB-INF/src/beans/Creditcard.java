package beans;

public class Creditcard {
	private int creditcardId;
	private String creditcardType;
	private String creditcardNumber;

	public Creditcard(int creditcardId, String creditcardType,
			String creditcardNumber) {
		super();
		this.creditcardId = creditcardId;
		this.creditcardType = creditcardType;
		this.creditcardNumber = creditcardNumber;
	}

	public Creditcard() {
		// TODO Auto-generated constructor stub
	}

	public int getCreditcardId() {
		return creditcardId;
	}

	public void setCreditcardId(int creditcardId) {
		this.creditcardId = creditcardId;
	}

	public String getCreditcardType() {
		return creditcardType;
	}

	public void setCreditcardType(String creditcardType) {
		this.creditcardType = creditcardType;
	}

	public String getCreditcardNumber() {
		return creditcardNumber;
	}

	public void setCreditcardNumber(String creditcardNumber) {
		this.creditcardNumber = creditcardNumber;
	}

}
