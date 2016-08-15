package com.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * PubRolesAuthorities entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pub_roles_authorities", catalog = "union_ssh")
public class PubRolesAuthorities implements java.io.Serializable {

	// Fields

	private String id;
	private PubAuthorities pubAuthorities;
	private PubRoles pubRoles;

	// Constructors

	/** default constructor */
	public PubRolesAuthorities() {
	}

	/** full constructor */
	public PubRolesAuthorities(String id, PubAuthorities pubAuthorities,
			PubRoles pubRoles) {
		this.id = id;
		this.pubAuthorities = pubAuthorities;
		this.pubRoles = pubRoles;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false, length = 32)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "authority_id", nullable = false)
	public PubAuthorities getPubAuthorities() {
		return this.pubAuthorities;
	}

	public void setPubAuthorities(PubAuthorities pubAuthorities) {
		this.pubAuthorities = pubAuthorities;
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