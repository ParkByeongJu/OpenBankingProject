package kr.ac.kopo.VO;

import java.sql.Date;

public class AccountVO {
	
	private int accountId;
	private int bankId;
	private int blance;
	private Date accountDate;
	private int accountPassword;
	private String id;
	private int productCode;
	private int passwordCount;
	private int dormantAccount;
	private String accountName;
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public int getBlance() {
		return blance;
	}
	public void setBlance(int blance) {
		this.blance = blance;
	}
	public Date getAccountDate() {
		return accountDate;
	}
	public void setAccountDate(Date accountDate) {
		this.accountDate = accountDate;
	}
	public int getAccountPassword() {
		return accountPassword;
	}
	public void setAccountPassword(int accountPassword) {
		this.accountPassword = accountPassword;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public int getPasswordCount() {
		return passwordCount;
	}
	public void setPasswordCount(int passwordCount) {
		this.passwordCount = passwordCount;
	}
	public int getDormantAccount() {
		return dormantAccount;
	}
	public void setDormantAccount(int dormantAccount) {
		this.dormantAccount = dormantAccount;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	
	

}
