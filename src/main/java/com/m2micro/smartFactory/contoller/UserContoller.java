package com.m2micro.smartFactory.contoller;

import com.m2micro.smartFactory.model.User;
import com.m2micro.smartFactory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserContoller {
  @Autowired
  private UserService userService;

  @RequestMapping("/getOptionList")
  public User  getOptionList(Integer id){
    User optionList = userService.getOptionList(id);
    return  optionList;
  }

}
