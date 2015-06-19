package beans;

public class Customer {
	private String userId;
	private String tel;
	private int creditcardId;

	public Customer(String userId, String tel, int creditcardId) {
		super();
		this.userId = userId;
		this.tel = tel;
		this.creditcardId = creditcardId;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getCreditcardId() {
		return creditcardId;
	}

	public void setCreditcardId(int creditcardId) {
		this.creditcardId = creditcardId;
	}

}
