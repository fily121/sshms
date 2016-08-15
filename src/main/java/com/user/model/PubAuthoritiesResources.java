package com.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * PubAuthoritiesResources entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pub_authorities_resources", catalog = "union_ssh")
public class PubAuthoritiesResources implements java.io.Serializable {

	// Fields

	private String id;
	private PubAuthorities pubAuthorities;
	private PubResources pubResources;

	// Constructors

	/** default constructor */
	public PubAuthoritiesResources() {
	}

	/** full constructor */
	public PubAuthoritiesResources(String id, PubAuthorities pubAuthorities,
			PubResources pubResources) {
		this.id = id;
		this.pubAuthorities = pubAuthorities;
		this.pubResources = pubResources;
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
	@JoinColumn(name = "resource_id", nullable = false)
	public PubResources getPubResources() {
		return this.pubResources;
	}

	public void setPubResources(PubResources pubResources) {
		this.pubResources = pubResources;
	}

}