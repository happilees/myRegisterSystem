package com.hsp.service.Inter;

import com.hsp.domain.User;
import com.hsp.service.base.BaseServiceInter;

public interface UserService extends BaseServiceInter{
	
	public User checkUser(User user);

}
