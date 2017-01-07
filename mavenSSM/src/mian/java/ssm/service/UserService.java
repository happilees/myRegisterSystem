package ssm.service;


import ssm.model.User;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserService {

	/*添加用户*/
    void addUser(User user);
    
    /*获得所有用户*/
    List<User> getAllUsers();
    
    public List<User> getUserByPage(Integer startPos, Integer pageSize);  
    
    public int getUserCount();  
    
}
