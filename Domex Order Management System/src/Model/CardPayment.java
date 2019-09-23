package Model;


public class CardPayment{
	private int cardPID;
	private String amount;
	private String cardType;
	private String cardNumber;
	private String expiryDate;
	private String ccv;
	
	public CardPayment() {
		super();
		
	}

	public CardPayment(int cardPID, String amount, String cardType, String cardNumber, String expiryDate, String ccv) {
		super();
		this.cardPID = cardPID;
		this.amount = amount;
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.ccv = ccv;
	}

	public int getCardPID() {
		return cardPID;
	}

	public void setCardPID(int cardPID) {
		this.cardPID = cardPID;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getCcv() {
		return ccv;
	}

	public void setCcv(String ccv) {
		this.ccv = ccv;
	}

}
