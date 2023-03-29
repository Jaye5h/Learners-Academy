package org.simplilearn.hrmapp.dao;

import org.simplilearn.hrmapp.entities.User;

public interface UserDao {
	void insertUser(User user);
	User getUser(int id);
	User getUser(String username,String password);
}
