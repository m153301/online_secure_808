package beans;

import java.util.Date;

public class Sale {
	private int itemId;
	private String itemName;
	private Date buyDate;
	private int purchaceQuantity;
	private int itemPrice;



	public Sale(int itemId, String itemName, Date buyDate,
			int purchaceQuantity, int itemPrice) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.buyDate = buyDate;
		this.purchaceQuantity = purchaceQuantity;
		this.itemPrice = itemPrice;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	public int getPurchaceQuantity() {
		return purchaceQuantity;
	}

	public void setPurchaceQuantity(int purchaceQuantity) {
		this.purchaceQuantity = purchaceQuantity;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

}
