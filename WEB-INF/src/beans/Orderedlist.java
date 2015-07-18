package beans;

import java.util.Date;

public class Orderedlist {
	private int orderId;
	private String userName;
	private String itemName;
	private int orderQuantity;
	private Date orderDate;

	public Orderedlist(int orderId, String userName, String itemName, int orderQuantity,
			Date orderDate) {
		super();
		this.orderId = orderId;
		this.userName = userName;
		this.itemName = itemName;
		this.orderQuantity = orderQuantity;
		this.orderDate = orderDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

}
