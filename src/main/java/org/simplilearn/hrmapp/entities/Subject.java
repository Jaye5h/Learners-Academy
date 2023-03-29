package org.simplilearn.hrmapp.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Subject {
	@Id
	private int sid;
	private String name;
	@ManyToOne
	@JoinColumn(name = "tid")
	private Teacher teacher;
	@ManyToOne
	@JoinColumn(name = "cid")
	private Eclass eclass;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Eclass getEclass() {
		return eclass;
	}
	public void setEclass(Eclass eclass) {
		this.eclass = eclass;
	}
	
	
}
