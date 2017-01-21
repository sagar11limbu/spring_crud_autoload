package com.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.entities.Users;
import com.userServices.UserServices;

@Controller
public class UserController {
	
	@Autowired
	UserServices userservices;
	
	@RequestMapping(value="/mypage",method= RequestMethod.GET)
	public ModelAndView getPage(){
		ModelAndView view = new ModelAndView("hello");
		return view;
	}
	@RequestMapping(value = "/list", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> getAll(Users users) {
        Map<String, Object> map = new HashMap<String, Object>();
 
        List<Users> list = userservices.listUsers();
 
        if (list != null) {
            map.put("status", "200");
            map.put("message", "Data found");
            map.put("data", list);
        } else {
            map.put("status", "404");
            map.put("message", "Data not found");
 
        }
 
        return map;
    }
	 @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	    public @ResponseBody Map<String, Object> getSaved( Users user) {
	        Map<String, Object> map = new HashMap<String, Object>();
	 
	        if (userservices.saveOrUpdate(user)) {
	            map.put("status", "200");
	            map.put("message", "Your record have been saved successfully");
	        }
	 
	        return map;
	    }
	    @RequestMapping(value = "/delete", method = RequestMethod.POST)
	    public @ResponseBody Map<String, Object> delete(Users users) {
	        Map<String, Object> map = new HashMap<String, Object>();
	 
	        if (userservices.delete(users)) {
	            map.put("status", "200");
	            map.put("message", "Your record have been deleted successfully");
	        }
	 
	        return map;
	    }

}
