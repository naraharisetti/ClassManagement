package com.LAlistClasses;

import java.util.Date;
import java.util.List;
import java.util.Set;

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
import javax.persistence.Table;



@Entity
@Table(name="ListClass")
public class ListClass {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cid")
	private int cid;
	
	@Column(name="cname")
	private String cname;
	
	@OneToMany
	@JoinTable
	(name = "Class_Stu", 
	joinColumns = @JoinColumn(name = "cid_class", referencedColumnName = "cid"), 
	inverseJoinColumns = @JoinColumn(name = "cid_sname", referencedColumnName = "cid"))
	Set<ListStudents> ListStudents;// ***
//	Class_Stu is the combined mapping table
	
	@ManyToMany
	@JoinTable
	(name = "Class_Sub", 
	joinColumns = @JoinColumn(name = "cid_class", referencedColumnName = "cid"), 
	inverseJoinColumns = @JoinColumn(name = "cid_subname", referencedColumnName = "cid"))
	Set<ListSubjects> ListSubjects;// ***
//	Class_Sub is the combined mapping table
	
	public ListClass() {

	}
	
	public ListClass(String cname) {
		super();
		this.cname = cname;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Set<ListStudents> getListStudents() {
		return ListStudents;
	}

	public void setListStudents(Set<ListStudents> listStudents) {
		ListStudents = listStudents;
	}

	public Set<ListSubjects> getListSubjects() {
		return ListSubjects;
	}

	public void setListSubjects(Set<ListSubjects> listSubjects) {
		ListSubjects = listSubjects;
	}	
}
