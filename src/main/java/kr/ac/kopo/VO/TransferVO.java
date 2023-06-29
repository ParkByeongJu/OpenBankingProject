package kr.ac.kopo.VO;


public class TransferVO {
	
	private String bankCode;
	private String selectBankCode;
	private String senderAccountId;
	private String recieverAccountId;
	private Long amount;
	
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getSenderAccountId() {
		return senderAccountId;
	}
	public void setSenderAccountId(String senderAccountId) {
		this.senderAccountId = senderAccountId;
	}
	public String getRecieverAccountId() {
		return recieverAccountId;
	}
	public void setRecieverAccountId(String recieverAccountId) {
		this.recieverAccountId = recieverAccountId;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public String getSelectBankCode() {
		return selectBankCode;
	}
	public void setSelectBankCode(String selectBankCode) {
		this.selectBankCode = selectBankCode;
	}
	
	
	
}