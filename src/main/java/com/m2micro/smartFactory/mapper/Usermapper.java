package com.m2micro.smartFactory.mapper;

import com.m2micro.smartFactory.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface Usermapper {
  User getOptionList(int id);
}
