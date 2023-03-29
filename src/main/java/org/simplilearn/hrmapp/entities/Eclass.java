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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Eclass {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	private String cname;
	@OneToMany(mappedBy = "eclass",cascade = CascadeType.ALL)
	private Set<Subject> subjects=new HashSet<>();
	
	@ManyToMany(mappedBy = "classes")
	private List<Teacher> teachers=new ArrayList<>();
	@OneToMany(mappedBy = "eclass")
	private Set<Student> students=new HashSet<>();
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
	public void remove(Subject subject)
	{
		subjects.remove(subject);
	}
	public void addTeacher(Teacher teacher)
	{
		teachers.add(teacher);
	}
	public void removeTeacher(Teacher teacher)
	{
		teachers.remove(teacher);
	}
	public void addStudent(Student student)
	{
		students.add(student);
	}
	public void removeStudent(Student student)
	{
		students.remove(student);
	}
}
