package kr.ac.kopo.VO;

import java.sql.Date;

public class HistoryVO {
	
	private int bankNo;//시퀀스 자동 생성 번호
	private String bankCode;//보내는 은행 코드
	private String accountId;//보내는 계좌 번호
	private Date historyDate;//입출금 날짜, 디폴트 입력
	private String srHistory;//입출금 내역
	private String transferBank;//받는 은행 코드
	private String transferAccount;//받는 은행 계좌
	private Long balance;//이체 금액
	private String senderName; //보내는 이름
	private String reciverName;//받는 이름
	public int getBankNo() {
		return bankNo;
	}
	public void setBankNo(int bankNo) {
		this.bankNo = bankNo;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public Date getHistoryDate() {
		return historyDate;
	}
	public void setHistoryDate(Date historyDate) {
		this.historyDate = historyDate;
	}
	public String getSrHistory() {
		return srHistory;
	}
	public void setSrHistory(String srHistory) {
		this.srHistory = srHistory;
	}
	
	public String getTransferBank() {
		return transferBank;
	}
	public void setTransferBank(String transferBank) {
		this.transferBank = transferBank;
	}
	public String getTransferAccount() {
		return transferAccount;
	}
	public void setTransferAccount(String transferAccount) {
		this.transferAccount = transferAccount;
	}
	public Long getBalance() {
		return balance;
	}
	public void setBalance(Long balance) {
		this.balance = balance;
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
