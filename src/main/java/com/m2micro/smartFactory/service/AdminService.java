package com.m2micro.smartFactory.service;

import com.m2micro.smartFactory.model.Admin;
import com.m2micro.smartFactory.utils.PageModel;
import com.m2micro.smartFactory.vo.AdminUserListVo;

/*
超级管理员 service
 */
public interface AdminService {
    /*
        根据账号获取管理员
     */
    Admin getAdminByNumber(String number);


}
