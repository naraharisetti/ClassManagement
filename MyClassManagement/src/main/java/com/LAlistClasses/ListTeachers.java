package com.LAlistClasses;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="ListTeachers")
public class ListTeachers {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cid")
	private int cid;
	
	@Column(name="tname")
	private String tname;
	
	@Column(name="email")
	private String email;
	
	
	@Column(name="phone")
	Long phone;
	
	@ManyToMany
	@JoinTable
	(name = "Teacher_Sub", 
	joinColumns = @JoinColumn(name = "cid_teach", referencedColumnName = "cid"), 
	inverseJoinColumns = @JoinColumn(name = "cid_subname", referencedColumnName = "cid"))
	Set<ListSubjects> ListSubjects;// ***
//	Class_Sub is the combined mapping table


	public ListTeachers() {

	}
	
	public ListTeachers(String tname, String email, Long phone) {
		super();
		this.tname = tname;
		this.email = email;
		this.phone = phone;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Set<ListSubjects> getListSubjects() {
		return ListSubjects;
	}

	public void setListSubjects(Set<ListSubjects> listSubjects) {
		ListSubjects = listSubjects;
	}	
}
