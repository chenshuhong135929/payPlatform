package com.m2micro.smartFactory.service.impl;

import com.m2micro.smartFactory.bo.AdminUserBo;
import com.m2micro.smartFactory.dao.AdminDao;
import com.m2micro.smartFactory.dao.AdminUserDao;
import com.m2micro.smartFactory.enums.Datastatus;
import com.m2micro.smartFactory.enums.DisableStatusEnum;
import com.m2micro.smartFactory.model.Admin;
import com.m2micro.smartFactory.model.AdminUser;
import com.m2micro.smartFactory.service.AdminUserService;
import com.m2micro.smartFactory.utils.Md5SaltTool;
import com.m2micro.smartFactory.utils.PageModel;
import com.m2micro.smartFactory.vo.AdminUserListVo;
import com.m2micro.smartFactory.vo.WebResultVo;
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
import java.util.Date;
import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private AdminUserDao adminUserDao;
    @Autowired
    private AdminDao adminDao;
    /**
     *
     * @param adminUserBo 参数
     * @throws Exception
     */
    @Override
    public void editAdminUser(AdminUserBo adminUserBo) throws Exception {
       AdminUser  adminUser = null;
        if(adminUserBo.getId() != null){
            adminUser = adminUserDao.findById(adminUserBo.getId()).get();
        }else{
            adminUser = new AdminUser();
            adminUser.setDisableStatus(DisableStatusEnum.A.toString());
            adminUser.setStatus(Datastatus.A.toString());
            adminUser.setCreateDate(new Date());
            adminUser.setPassword(Md5SaltTool.getEncryptedPwd(adminUserBo.getPhone()));
        }
        adminUser.setEmail(adminUserBo.getEmail());
        adminUser.setName(adminUserBo.getName());
        adminUser.setNumber(adminUserBo.getNumber());
        adminUser.setPhone(adminUserBo.getPhone());
        adminUser.setRemark(adminUserBo.getRemark());
        adminUserDao.save(adminUser);

    }
    @Override
    public PageModel<AdminUserListVo> findAdminListVo(String searchContent, Integer pageNo, Integer pageSize)  throws  Exception{
        Specification<AdminUser> specification = new Specification<AdminUser>() {
            @Override
            public Predicate toPredicate(Root<AdminUser> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                return null;
            }
        };

        Page<AdminUser> adminPage = adminUserDao.findAll(specification, PageRequest.of(pageNo - 1,pageSize, Sort.by(Sort.Direction.DESC,"id")));
        List<AdminUserListVo> adminUserListVos = new ArrayList<>();
        adminPage.forEach(adminUser -> {
            AdminUserListVo adminUserListVo = new AdminUserListVo();
            adminUserListVo.setId(adminUser.getId());
            adminUserListVo.setName(adminUser.getName());
            adminUserListVo.setNumber(adminUser.getNumber());
            adminUserListVo.setRemark(adminUser.getRemark());
            adminUserListVos.add(adminUserListVo);
        });
        PageModel<AdminUserListVo> pageModel = new PageModel<AdminUserListVo>(pageSize,pageNo,adminUserListVos,adminPage.getTotalElements());
        return pageModel;
    }
}
