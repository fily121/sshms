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
 * PubAuthorities entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pub_authorities", catalog = "union_ssh")
public class PubAuthorities implements java.io.Serializable {

	// Fields

	private String authorityId;
	private String authorityName;
	private String authorityDesc;
	private Integer enabled;
	private Integer issys;
	private Set<PubAuthoritiesResources> pubAuthoritiesResourceses = new HashSet<PubAuthoritiesResources>(
			0);
	private Set<PubRolesAuthorities> pubRolesAuthoritieses = new HashSet<PubRolesAuthorities>(
			0);

	// Constructors

	/** default constructor */
	public PubAuthorities() {
	}

	/** minimal constructor */
	public PubAuthorities(String authorityId, String authorityName,
			Integer enabled, Integer issys) {
		this.authorityId = authorityId;
		this.authorityName = authorityName;
		this.enabled = enabled;
		this.issys = issys;
	}

	/** full constructor */
	public PubAuthorities(String authorityId, String authorityName,
			String authorityDesc, Integer enabled, Integer issys,
			Set<PubAuthoritiesResources> pubAuthoritiesResourceses,
			Set<PubRolesAuthorities> pubRolesAuthoritieses) {
		this.authorityId = authorityId;
		this.authorityName = authorityName;
		this.authorityDesc = authorityDesc;
		this.enabled = enabled;
		this.issys = issys;
		this.pubAuthoritiesResourceses = pubAuthoritiesResourceses;
		this.pubRolesAuthoritieses = pubRolesAuthoritieses;
	}

	// Property accessors
	@Id
	@Column(name = "authority_id", unique = true, nullable = false, length = 32)
	public String getAuthorityId() {
		return this.authorityId;
	}

	public void setAuthorityId(String authorityId) {
		this.authorityId = authorityId;
	}

	@Column(name = "authority_name", nullable = false, length = 40)
	public String getAuthorityName() {
		return this.authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}

	@Column(name = "authority_desc", length = 100)
	public String getAuthorityDesc() {
		return this.authorityDesc;
	}

	public void setAuthorityDesc(String authorityDesc) {
		this.authorityDesc = authorityDesc;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pubAuthorities")
	public Set<PubAuthoritiesResources> getPubAuthoritiesResourceses() {
		return this.pubAuthoritiesResourceses;
	}

	public void setPubAuthoritiesResourceses(
			Set<PubAuthoritiesResources> pubAuthoritiesResourceses) {
		this.pubAuthoritiesResourceses = pubAuthoritiesResourceses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pubAuthorities")
	public Set<PubRolesAuthorities> getPubRolesAuthoritieses() {
		return this.pubRolesAuthoritieses;
	}

	public void setPubRolesAuthoritieses(
			Set<PubRolesAuthorities> pubRolesAuthoritieses) {
		this.pubRolesAuthoritieses = pubRolesAuthoritieses;
	}

}