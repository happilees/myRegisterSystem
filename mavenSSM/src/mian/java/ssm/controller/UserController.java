package ssm.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import ssm.model.User;
import ssm.service.UserService;
import ssm.util.FileUpload;
import ssm.util.Page;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger log = Logger.getLogger(UserController.class);
    @Resource
    private UserService userService;
    
    /*json数据交互*/
    @RequestMapping("/addUserJson")
    public void addUserJson(HttpServletRequest request, HttpServletResponse response, User user)
    throws IOException {
        log.info("添加用户");
        System.out.println("添加用户"+user.getUserName()+","+user.getUserPhone()+","+
        user.getUserEmail()+","+user.getUserPwd()+".");
        userService.addUser(user);
        List<User> userList = userService.getAllUsers();
        JSONArray jsons = new JSONArray();
        for(User a_user : userList) {
        	JSONObject jsonObject = new JSONObject();
        	jsonObject.put("id", a_user.getId());
        	jsonObject.put("UserName", a_user.getUserName());
        	jsonObject.put("UserPhone", a_user.getUserPhone());
        	jsonObject.put("UserEmail", a_user.getUserEmail());
        	jsonObject.put("UserPwd", a_user.getUserPwd());
        	jsons.add(jsonObject);  
        }
        /*设置字符集为'UTF-8'*/
        response.setCharacterEncoding("UTF-8"); 
        response.getWriter().print(jsons.toString()) ;
    }
    
    /*模板引擎渲染*/
    @RequestMapping("/addUserTemplet")
    public String addUserTemplet(HttpServletRequest request, Model model, User user){
        String flag = request.getParameter("flag");
        if(null != flag && flag.equals("add"))
        {
        	log.info("添加用户");
        	System.out.println("添加用户"+user.getUserName()+","+user.getUserPhone()+","+
        	    user.getUserEmail()+","+user.getUserPwd()+".");
        	userService.addUser(user);
        }
        Page page = null;
        String pageNow = request.getParameter("pageNow");
		List<User> userList = new ArrayList<User>();
	    int totalCount = userService.getUserCount();
	    if (pageNow != null) {  
	        page = new Page(totalCount, Integer.parseInt(pageNow));  
	        userList = userService.getUserByPage(page.getStartPos(), page.getPageSize());  
	    } else {  
	        page = new Page(totalCount, 1);  
	        userList = userService.getUserByPage(page.getStartPos(), page.getPageSize());  
	    } 
	    model.addAttribute("userList", userList);  
	    model.addAttribute("page", page); 
        return "showUser";
    }
    
    /*文件上传*/
    @RequestMapping("/addUserFileUpload")
    public String fileUpload(@RequestParam(value = "file", required = false) MultipartFile file, 
    		HttpServletRequest request, Model model){
        log.info("添加用户");
        System.out.println("文件上传");
        FileUpload fileUpload = new FileUpload();
        String filename = fileUpload.upload(request, file);
        System.out.println(filename);
        model.addAttribute("message", "文件上传成功");
        return "fileupload";
    }
    
    @RequestMapping("/goUser")
    public String goUser(HttpServletRequest request, Model model){
        log.info("前往用户界面");
        String flag = request.getParameter("flag");
        if(null != flag && flag.equals("fileupload")) {
        	return "fileupload";
        }
        if(null != flag && flag.equals("templet")) {
        	return "templet";
        }
        else {
            return "json";	
        }
    }
}
