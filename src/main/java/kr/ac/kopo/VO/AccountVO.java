package kr.ac.kopo.VO;

import java.sql.Date;

public class AccountVO {
	
	private long accountId;
	private int bankId;
	private long blance;
	private Date accountDate;
	private int accountPassword;
	private String id;
	private int productCode;
	private int passwordCount;
	private int dormantAccount;
	private String accountName;
	private String bankName;
	private String productName;
	
	
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public long getBlance() {
		return blance;
	}
	public void setBlance(long blance) {
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
	
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	

}
