package beans;

public class Customer {
	private String userId;
	private int tel;
	private int creditcardId;

	public Customer(String userId, int tel, int creditcardId) {
		super();
		this.userId = userId;
		this.tel = tel;
		this.creditcardId = creditcardId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public int getCreditcardId() {
		return creditcardId;
	}

	public void setCreditcardId(int creditcardId) {
		this.creditcardId = creditcardId;
	}

}
