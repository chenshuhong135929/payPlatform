package com.m2micro.smartFactory.service.impl;

import com.m2micro.smartFactory.dao.AdminDao;
import com.m2micro.smartFactory.model.Admin;
import com.m2micro.smartFactory.service.AdminService;
import com.m2micro.smartFactory.utils.Md5SaltTool;
import com.m2micro.smartFactory.utils.PageModel;
import com.m2micro.smartFactory.vo.AdminUserListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/*
超级管理员接口实现类
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Override
    public Admin getAdminByNumber(String number) {
       /* Admin admin = adminDao.findById(1).get();
        try {
            admin.setPassword(Md5SaltTool.getEncryptedPwd("888888"));
        }catch (Exception e){

        }
      adminDao.save(admin);*/
        return adminDao.getByNumber(number);
    }


}
