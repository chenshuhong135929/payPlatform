package com.m2micro.smartFactory.contoller;

import com.m2micro.smartFactory.bo.AdminUserBo;
import com.m2micro.smartFactory.constants.PublicConstant;
import com.m2micro.smartFactory.service.AdminUserService;
import com.m2micro.smartFactory.utils.PageModel;
import com.m2micro.smartFactory.vo.AdminUserListVo;
import com.m2micro.smartFactory.vo.WebResultVo;
import com.m2micro.smartFactory.enums.WebResultVoEnum;
import com.m2micro.smartFactory.model.Admin;
import com.m2micro.smartFactory.service.AdminService;
import com.m2micro.smartFactory.utils.Md5SaltTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.awt.image.IntegerComponentRaster;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminUserService adminUserService;

    /*登录接口*/
    @PostMapping("/loginIn")
    public WebResultVo loginIn(String number, String password, HttpServletRequest request) {
        if (!StringUtils.hasText(number)) {
            return WebResultVo.getInstance().building(WebResultVoEnum.PARAMETERERROR.getCode(), "用户账号不能为空!");
        }
        if (!StringUtils.hasText(password)) {
            return WebResultVo.getInstance().building(WebResultVoEnum.PARAMETERERROR.getCode(), "用户密码不能为空!");
        }

        //根据账号获取管理员
        Admin admin = adminService.getAdminByNumber(number);
        if (admin == null) {
            return WebResultVo.getInstance().building(WebResultVoEnum.PARAMETERERROR.getCode(), "登录失败，账号不存在!");
        }
        boolean validPassword = false;
        try {
            validPassword = Md5SaltTool.validPassword(password, admin.getPassword());
        } catch (Exception e) {
            return WebResultVo.getInstance().building(WebResultVoEnum.PARAMETERERROR.getCode(), "登录失败，账号或者密码错误!");
        }
        if (validPassword) {
            request.getSession().setAttribute(PublicConstant.ADMINLOGINKEY,admin);
            return WebResultVo.getInstance().buildingSuccess("登录成功", null);
        } else {
            return WebResultVo.getInstance().building(WebResultVoEnum.ILLEGALOPERATION.getCode(), "登录失败，账号或者密码错误!");
        }
    }

    /*
     * 修改/添管理员
     * */
    @PostMapping("/editAdminUser")
    public WebResultVo editAdminUser(AdminUserBo adminUserBo) {

        // 校验参数
       if(adminUserBo == null){
            return  WebResultVo.getInstance().building(WebResultVoEnum.PARAMETERERROR);
        }
        if(!StringUtils.hasText(adminUserBo.getName())){
            return  WebResultVo.getInstance().building(WebResultVoEnum.PARAMETERERROR.getCode(),"用户名称必须填写！");
        }
        if(!StringUtils.hasText(adminUserBo.getEmail())){
            return  WebResultVo.getInstance().building(WebResultVoEnum.PARAMETERERROR.getCode(),"用户邮箱必须填写！");
        }
        if(!StringUtils.hasText(adminUserBo.getNumber())){
            return  WebResultVo.getInstance().building(WebResultVoEnum.PARAMETERERROR.getCode(),"用户账号必须填写！");
        }
        if(!StringUtils.hasText(adminUserBo.getPhone())){
            return  WebResultVo.getInstance().building(WebResultVoEnum.PARAMETERERROR.getCode(),"用户电话必须填写！");
        }

        //修改员工
        try {
            adminUserService.editAdminUser(adminUserBo);

            return WebResultVo.getInstance().buildingSuccess();
        }catch (Exception e){
            return WebResultVo.getInstance().building(WebResultVoEnum.ERROR);
        }
    }

    /*
     * 修改/添管理员
     * */
    @PostMapping("/pageAdminUser")
    public WebResultVo pageAdminUser(String searchContent,Integer pageNo,Integer pageSize){
        try {
            PageModel<AdminUserListVo> pageModel = this.adminUserService.findAdminListVo(searchContent,pageNo,pageSize);
            return WebResultVo.getInstance().buildingSuccess(pageModel);
        }catch (Exception e){
            return WebResultVo.getInstance().building(WebResultVoEnum.ERROR);
        }

    }


}
