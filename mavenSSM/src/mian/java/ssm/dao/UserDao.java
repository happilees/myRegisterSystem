package ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ssm.model.User;

public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> getAllUser();
    
    public List<User> selectUserByPage(@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize);  
    
    public int selectUserCount();  
}