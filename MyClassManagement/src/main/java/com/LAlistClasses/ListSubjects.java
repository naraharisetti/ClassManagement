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
@Table(name="ListSubjects")
public class ListSubjects {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cid")
	private int cid;
	
	@Column(name="subname")
	private String subname;
	
	@ManyToMany(mappedBy="ListSubjects")
	Set<ListClass> ListClass;
	
	@ManyToMany(mappedBy="ListSubjects")
	Set<ListTeachers> ListTeachers;
	
	public ListSubjects() {

	}

	public ListSubjects(String subname) {
		super();
		this.subname = subname;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	public Set<ListClass> getListClass() {
		return ListClass;
	}

	public void setListClass(Set<ListClass> listClass) {
		ListClass = listClass;
	}

	public Set<ListTeachers> getListTeachers() {
		return ListTeachers;
	}

	public void setListTeachers(Set<ListTeachers> listTeachers) {
		ListTeachers = listTeachers;
	}

	
	
	
	



}