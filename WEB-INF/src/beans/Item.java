package beans;

public class Item {
	private int itmeId;
	private String itmeName;
	private int itmePrice;
	private int itmeStock;

	public Item(int itmeId, String itmeName, int itmePrice, int itmeStock) {
		super();
		this.itmeId = itmeId;
		this.itmeName = itmeName;
		this.itmePrice = itmePrice;
		this.itmeStock = itmeStock;
	}

	public int getItmeId() {
		return itmeId;
	}
	public void setItmeId(int itmeId) {
		this.itmeId = itmeId;
	}
	public String getItmeName() {
		return itmeName;
	}
	public void setItmeName(String itmeName) {
		this.itmeName = itmeName;
	}
	public int getItmePrice() {
		return itmePrice;
	}
	public void setItmePrice(int itmePrice) {
		this.itmePrice = itmePrice;
	}
	public int getItmeStock() {
		return itmeStock;
	}
	public void setItmeStock(int itmeStock) {
		this.itmeStock = itmeStock;
	}



}
