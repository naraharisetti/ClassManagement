package com.LAlistClasses;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="ListStudents")
public class ListStudents {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cid")
	private int cid;

	@Column(name="sname")
	private String sname;

	@Column(name="email")
	private String email;

	@Column(name="phone")
	Long phone;

	@ManyToMany(mappedBy="ListStudents")
	Set<ListClass> ListClass;

	public ListStudents() {

	}

	public ListStudents( String sname, String email, Long phone) {
		super();
		this.sname = sname;
		this.email = email;
		this.phone = phone;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
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

	public Set<ListClass> getListClass() {
		return ListClass;
	}

	public void setListClass(Set<ListClass> listClass) {
		ListClass = listClass;
	}
	
	



}
