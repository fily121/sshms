package com.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * PubUsersRoles entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pub_users_roles", catalog = "union_ssh")
public class PubUsersRoles implements java.io.Serializable {

	// Fields

	private Integer id;
	private PubUsers pubUsers;
	private PubRoles pubRoles;

	// Constructors

	/** default constructor */
	public PubUsersRoles() {
	}

	/** full constructor */
	public PubUsersRoles(Integer id, PubUsers pubUsers, PubRoles pubRoles) {
		this.id = id;
		this.pubUsers = pubUsers;
		this.pubRoles = pubRoles;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public PubUsers getPubUsers() {
		return this.pubUsers;
	}

	public void setPubUsers(PubUsers pubUsers) {
		this.pubUsers = pubUsers;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", nullable = false)
	public PubRoles getPubRoles() {
		return this.pubRoles;
	}

	public void setPubRoles(PubRoles pubRoles) {
		this.pubRoles = pubRoles;
	}

}