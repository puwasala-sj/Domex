package Model;

public class ChequePayment{
	private int chequePID;
	private String amount;
	private String chequeNumber;
	private String bank;

	public ChequePayment() {
		super();
	}

	public ChequePayment(int chequePID, String amount, String chequeNumber, String bank) {
		super();
		this.chequePID = chequePID;
		this.amount = amount;
		this.chequeNumber = chequeNumber;
		this.bank = bank;
	}

	public int getChequePID() {
		return chequePID;
	}

	public void setChequePID(int chequePID) {
		this.chequePID = chequePID;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getChequeNumber() {
		return chequeNumber;
	}

	public void setChequeNumber(String chequeNumber) {
		this.chequeNumber = chequeNumber;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

}
