package org.simplilearn.hrmapp.dao;

import java.util.List;

import org.simplilearn.hrmapp.entities.Subject;

public interface SubjectDao {
	void addSubject(Subject subject);
	Subject getSubject(int sid);
	List<Subject> getSubjects();
}
