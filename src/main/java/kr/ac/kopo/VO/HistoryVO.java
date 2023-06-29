package kr.ac.kopo.VO;

import java.sql.Date;

public class HistoryVO {
	
	private int bankNo;//시퀀스 자동 생성 번호
	private String bankCode;//은행코드
	private int accountId;//계좌 번호
	private Date historyDate;//입출금 날짜
	private String srHistory;//입출금 내역
	private String transferBank;//받는 은행
	private int transferAccount;//거래 계좌
	private int balance;//거래후 잔액
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
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
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
	public int getTransferAccount() {
		return transferAccount;
	}
	public void setTransferAccount(int transferAccount) {
		this.transferAccount = transferAccount;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	

}
