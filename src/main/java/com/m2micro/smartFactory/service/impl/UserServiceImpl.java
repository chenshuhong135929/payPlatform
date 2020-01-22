package com.m2micro.smartFactory.service.impl;

import com.m2micro.smartFactory.mapper.Usermapper;
import com.m2micro.smartFactory.model.User;
import com.m2micro.smartFactory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private Usermapper usermapper;

  @Override
  public User getOptionList(int id) {
    User optionList = usermapper.getOptionList(id);
    return optionList;
  }
}
