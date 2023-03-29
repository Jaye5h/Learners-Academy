package org.simplilearn.hrmapp.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tid;
	private String teacherName;
	private int exp;
	@OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
	private Set<Subject> subjects=new HashSet<>();
	@ManyToMany
	@JoinTable(name = "teacher_class",joinColumns = @JoinColumn(name="tid"),inverseJoinColumns = @JoinColumn(name="cid"))
	private List<Eclass> classes=new ArrayList<>();
	
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public Set<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}
	public void addSubject(Subject subject)
	{
		subjects.add(subject);
	}
	public void removeSubject(Subject subject)
	{
		subjects.remove(subject);
	}
	public void addClass(Eclass eclass)
	{
		classes.add(eclass);
	}
	public void removeClass(Eclass eclass) {
		classes.remove(eclass);
	}
}
