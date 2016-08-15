package com.menu.pageModel;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Tree entity. @author MyEclipse Persistence Tools
 */

public class TreeMenu implements java.io.Serializable {

	// Fields

	private Integer id;

	private String text;
	
	private String pid;

	private Map<String, Object> attributes;
	
	// Constructors

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	/** default constructor */
	public TreeMenu() {
	}

	/** full constructor */
	public TreeMenu(TreeMenu tree, String text, Set<TreeMenu> trees) {
	
		this.text = text;
		
	}

	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	


	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	

}