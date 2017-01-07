package ssm.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ssm.dao.UserDao;
import ssm.model.User;
import ssm.service.UserService;
import ssm.util.Page;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    
    @Resource
    private UserDao userDao;

	public void addUser(User user) {
	    userDao.insert(user);
		
	}

	public List<User> getAllUsers() {
		return userDao.getAllUser();
	}

	public List<User> getUserByPage(Integer startPos, Integer pageSize) {
		return userDao.selectUserByPage(startPos, pageSize);
	}

	public int getUserCount() {
		return userDao.selectUserCount();
	}

}
