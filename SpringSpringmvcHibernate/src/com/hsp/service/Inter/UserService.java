package com.hsp.service.Inter;

import com.hsp.domain.User;
import com.hsp.service.base.BaseServiceInter;

public interface UserService extends BaseServiceInter{
	
	//检验用户是否合法
	public User checkUser(User user);

}
