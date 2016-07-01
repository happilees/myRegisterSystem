package com.hsp.service.Impl;

import org.springframework.stereotype.Service;

import com.hsp.domain.User;
import com.hsp.service.Inter.UserService;
import com.hsp.service.base.BaseServiceImpl;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl implements UserService {

	@Override
	public User checkUser(User user) {
		String hql="from User where username=? and password=?";
		Object[] parameters={user.getUsername(),user.getPassword()};
		user=(User)this.uniqueQuery(hql, parameters);
		if(user!=null)
		{
			return user;
		}
		else
		{
			return null;
		}
	}

}
