package edu.student.model.User;

import java.util.List;
import java.util.Map;


public interface UserService 
{
	public void insertUser(User user);
	
	public User getUserById(Integer userId);
	
	public User getUserLogin(Map pCredentials);
	
	public List<User> getAllUser();
	
	public void updateUser(User user);
	
	public void deleteUser(User user);
}
