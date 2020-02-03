package com.m2micro.smartFactory.service;

import com.m2micro.smartFactory.bo.AdminUserBo;
import com.m2micro.smartFactory.bo.PageBo;
import com.m2micro.smartFactory.utils.PageModel;
import com.m2micro.smartFactory.vo.AdminUserListVo;

/*
管理员用户service
 */
public interface AdminUserService {
    /*
     编辑管理员用户
     */
    void editAdminUser(AdminUserBo adminUserBo) throws  Exception;

    /*
     分页获取管理员用户信息
     searchContent 根据账号还有姓名搜索
      */
    PageModel<AdminUserListVo> findAdminListVo(String searchContent, PageBo pageBo) throws  Exception;
}
