package edu.student.model.User;

import java.util.List;


public interface UserService 
{
	public void insertUser(User user);
	
	public void getUserById(Integer userId);
	
	public List<User> getAllUser();
	
	public void updateUser(User user);
	
	public void deleteUser(Integer userId);
}
