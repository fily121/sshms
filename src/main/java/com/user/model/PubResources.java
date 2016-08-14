package com.user.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * PubResources entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pub_resources", catalog = "union_ssh")
public class PubResources implements java.io.Serializable {

	// Fields

	private String resourceId;
	private PubResources pubResources;
	private String resourceName;
	private String resourceType;
	private Integer priority;
	private String resourceString;
	private String resourceDesc;
	private Integer enabled;
	private Integer issys;
	private Set<PubResources> pubResourceses = new HashSet<PubResources>(0);
	private Set<PubAuthoritiesResources> pubAuthoritiesResourceses = new HashSet<PubAuthoritiesResources>(
			0);

	// Constructors

	/** default constructor */
	public PubResources() {
	}

	/** minimal constructor */
	public PubResources(String resourceId, String resourceName,
			String resourceType, Integer priority, String resourceString,
			Integer enabled, Integer issys) {
		this.resourceId = resourceId;
		this.resourceName = resourceName;
		this.resourceType = resourceType;
		this.priority = priority;
		this.resourceString = resourceString;
		this.enabled = enabled;
		this.issys = issys;
	}

	/** full constructor */
	public PubResources(String resourceId, PubResources pubResources,
			String resourceName, String resourceType, Integer priority,
			String resourceString, String resourceDesc, Integer enabled,
			Integer issys, Set<PubResources> pubResourceses,
			Set<PubAuthoritiesResources> pubAuthoritiesResourceses) {
		this.resourceId = resourceId;
		this.pubResources = pubResources;
		this.resourceName = resourceName;
		this.resourceType = resourceType;
		this.priority = priority;
		this.resourceString = resourceString;
		this.resourceDesc = resourceDesc;
		this.enabled = enabled;
		this.issys = issys;
		this.pubResourceses = pubResourceses;
		this.pubAuthoritiesResourceses = pubAuthoritiesResourceses;
	}

	// Property accessors
	@Id
	@Column(name = "resource_id", unique = true, nullable = false, length = 32)
	public String getResourceId() {
		return this.resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pid")
	public PubResources getPubResources() {
		return this.pubResources;
	}

	public void setPubResources(PubResources pubResources) {
		this.pubResources = pubResources;
	}

	@Column(name = "resource_name", nullable = false, length = 100)
	public String getResourceName() {
		return this.resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	@Column(name = "resource_type", nullable = false, length = 40)
	public String getResourceType() {
		return this.resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	@Column(name = "priority", nullable = false)
	public Integer getPriority() {
		return this.priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	@Column(name = "resource_string", nullable = false, length = 200)
	public String getResourceString() {
		return this.resourceString;
	}

	public void setResourceString(String resourceString) {
		this.resourceString = resourceString;
	}

	@Column(name = "resource_desc", length = 100)
	public String getResourceDesc() {
		return this.resourceDesc;
	}

	public void setResourceDesc(String resourceDesc) {
		this.resourceDesc = resourceDesc;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pubResources")
	public Set<PubResources> getPubResourceses() {
		return this.pubResourceses;
	}

	public void setPubResourceses(Set<PubResources> pubResourceses) {
		this.pubResourceses = pubResourceses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pubResources")
	public Set<PubAuthoritiesResources> getPubAuthoritiesResourceses() {
		return this.pubAuthoritiesResourceses;
	}

	public void setPubAuthoritiesResourceses(
			Set<PubAuthoritiesResources> pubAuthoritiesResourceses) {
		this.pubAuthoritiesResourceses = pubAuthoritiesResourceses;
	}
}