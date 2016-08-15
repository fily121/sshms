package com.user.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * PubUsers entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pub_users", catalog = "union_ssh")
public class PubUsers implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -5395095858734027949L;
	private Integer userId;
	private String userAccount;
	private String userName;
	private String userPassword;
	private Integer enabled;
	private Integer issys;
	private String userDesc;
	private Set<PubUsersRoles> pubUsersRoleses = new HashSet<PubUsersRoles>(0);

	// Constructors

	/** default constructor */
	public PubUsers() {
	}

	/** minimal constructor */
	public PubUsers(Integer userId, String userAccount, String userName,
			String userPassword, Integer enabled, Integer issys) {
		this.userId = userId;
		this.userAccount = userAccount;
		this.userName = userName;
		this.userPassword = userPassword;
		this.enabled = enabled;
		this.issys = issys;
	}

	/** full constructor */
	public PubUsers(Integer userId, String userAccount, String userName,
			String userPassword, Integer enabled, Integer issys,
			String userDesc, Set<PubUsersRoles> pubUsersRoleses) {
		this.userId = userId;
		this.userAccount = userAccount;
		this.userName = userName;
		this.userPassword = userPassword;
		this.enabled = enabled;
		this.issys = issys;
		this.userDesc = userDesc;
		this.pubUsersRoleses = pubUsersRoleses;
	}

	// Property accessors
	@Id
	@Column(name = "user_id", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "user_account", nullable = false, length = 30)
	public String getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	@Column(name = "user_name", nullable = false, length = 40)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "user_password", nullable = false, length = 100)
	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Column(name = "enabled", nullable = false)
	public Integer getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	@Column(name = "issys", nullable = false)
	public Integer getIssys() {
		return this.issys;
	}

	public void setIssys(Integer issys) {
		this.issys = issys;
	}

	@Column(name = "user_desc", length = 100)
	public String getUserDesc() {
		return this.userDesc;
	}

	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pubUsers")
	public Set<PubUsersRoles> getPubUsersRoleses() {
		return this.pubUsersRoleses;
	}

	public void setPubUsersRoleses(Set<PubUsersRoles> pubUsersRoleses) {
		this.pubUsersRoleses = pubUsersRoleses;
	}

}