package edu.student.model.User;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl implements UserService 
{
	
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession pSqlSession) {
   	sqlSession = pSqlSession;
   }

	@Override
	public void insertUser(User pUser) 
	{
		sqlSession.insert("User.insertUser", pUser);
	}

	@Override
	public User getUserById(Integer pUserId) 
	{
		return ((User)sqlSession.selectOne("User.getUserById", pUserId));
	}

	@Override
	public List<User> getAllUser() 
	{
		return (sqlSession.selectList("User.getAllUser"));
	}

	@Override
	public void updateUser(User pUser) 
	{
		sqlSession.insert("User.updateUser", pUser);
	}

	@Override
	public void deleteUser(User pUser) 
	{
		sqlSession.insert("User.deleteUser", pUser);
	}

	@Override
   public User getUserLogin(User pUser)
	{
	   return ((User)sqlSession.selectOne("User.getUserLogin", pUser));
   }

}
