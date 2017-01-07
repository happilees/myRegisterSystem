package ssm.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ssm.model.User;
import ssm.service.UserService;
import ssm.service.impl.UserServiceImpl;

public class TestService {
	
	ApplicationContext ctx;
	
	@Before
	public void setUp() throws Exception {
		ctx=new ClassPathXmlApplicationContext("spring-mybatis.xml");
	}
    
    @Test
    public void test() {
    }

}
