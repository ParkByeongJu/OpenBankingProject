package kr.ac.kopo.VO;


public class TransferVO {
	
	private String bankCode; //보내는 은행 
	private String selectBankCode;//받는 은행
	private String senderAccountId;//보내는 계좌
	private String recieverAccountId;//받는계좌
	private Long amount;//이체금액
	private String senderName;// 보내는 이름
	private String reciverName;// 받는 이름
	
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
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getReciverName() {
		return reciverName;
	}
	public void setReciverName(String reciverName) {
		this.reciverName = reciverName;
	}
	
	
	
}