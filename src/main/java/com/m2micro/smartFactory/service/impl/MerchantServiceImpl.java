package com.m2micro.smartFactory.service.impl;

import com.m2micro.smartFactory.bo.PageBo;
import com.m2micro.smartFactory.dao.MerchantDao;
import com.m2micro.smartFactory.enums.WebResultVoEnum;
import com.m2micro.smartFactory.model.Merchant;
import com.m2micro.smartFactory.service.MerchantService;
import com.m2micro.smartFactory.utils.PageModel;
import com.m2micro.smartFactory.vo.WebResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantDao merchantDao;

    @Override
    public WebResultVo editMerchant(Merchant merchant) {

        //添加
        if(merchant.getId()==null){

            if(!StringUtils.hasText(merchant.getName())){
                return  WebResultVo.getInstance().building(WebResultVoEnum.PARAMETERERROR.getCode(),"商户名称必填！");
            }


            if(!StringUtils.hasText(merchant.getLegalPerson())){
                return  WebResultVo.getInstance().building(WebResultVoEnum.PARAMETERERROR.getCode(),"法人必填！");
            }


            if(!StringUtils.hasText(merchant.getIdLastNumber())){
                return  WebResultVo.getInstance().building(WebResultVoEnum.PARAMETERERROR.getCode(),"身份证后四位必填！");
            }


            if(!StringUtils.hasText(merchant.getLinkPhone())){
                return  WebResultVo.getInstance().building(WebResultVoEnum.PARAMETERERROR.getCode(),"联系电话必填！");
            }


            if(!StringUtils.hasText(merchant.getLinkEmali())){
                return  WebResultVo.getInstance().building(WebResultVoEnum.PARAMETERERROR.getCode(),"类型邮箱必填！");
            }


            if(!StringUtils.hasText(merchant.getRegisteredAddress())){
                return  WebResultVo.getInstance().building(WebResultVoEnum.PARAMETERERROR.getCode(),"注册地址必填！");
            }


            if(!StringUtils.hasText(merchant.getOpenAddress())){
                return  WebResultVo.getInstance().building(WebResultVoEnum.PARAMETERERROR.getCode(),"营业地址必填！");
            }

            if(!StringUtils.hasText(merchant.getMailbox())){
                return  WebResultVo.getInstance().building(WebResultVoEnum.PARAMETERERROR.getCode(),"邮箱必填！");
            }

            if(merchant.getRegisteredDate()==null){
                return  WebResultVo.getInstance().building(WebResultVoEnum.PARAMETERERROR.getCode(),"营业时间必填！");
            }

            if(!StringUtils.hasText(merchant.getIndustry())){
                return  WebResultVo.getInstance().building(WebResultVoEnum.PARAMETERERROR.getCode(),"行业必填！");
            }

            if(!StringUtils.hasText(merchant.getDataDictionary())){
                return  WebResultVo.getInstance().building(WebResultVoEnum.PARAMETERERROR.getCode(),"数据字典必填！");
            }

            if(!StringUtils.hasText(merchant.getExplainContent())){
                return  WebResultVo.getInstance().building(WebResultVoEnum.PARAMETERERROR.getCode(),"解释内容必填！");
            }

            if(!StringUtils.hasText(merchant.getDoBusiness())){
                return  WebResultVo.getInstance().building(WebResultVoEnum.PARAMETERERROR.getCode(),"经营业务必填！");
            }

            merchantDao.save(merchant);
            return WebResultVo.getInstance().buildingSuccess();
        }

        //修改

        Merchant merchantOld = merchantDao.findById(merchant.getId()).orElse(null);

        if(merchantOld==null){
            return  WebResultVo.getInstance().building(WebResultVoEnum.ERROR.getCode(),null);
        }


            if(StringUtils.hasText(merchant.getName())){
                merchantOld.setName(merchant.getName());
            }


            if(StringUtils.hasText(merchant.getLegalPerson())){
                merchantOld.setLegalPerson(merchant.getLegalPerson());
            }


            if(StringUtils.hasText(merchant.getIdLastNumber())){
                merchantOld.setIdLastNumber(merchant.getIdLastNumber());
            }


            if(StringUtils.hasText(merchant.getLinkPhone())){
                merchantOld.setLinkPhone(merchant.getLinkPhone());
            }


            if(StringUtils.hasText(merchant.getLinkEmali())){
                merchantOld.setLinkEmali(merchant.getLinkEmali());
            }


            if(StringUtils.hasText(merchant.getRegisteredAddress())){
                merchantOld.setRegisteredAddress(merchant.getRegisteredAddress());
            }


            if(StringUtils.hasText(merchant.getOpenAddress())){
                merchantOld.setOpenAddress(merchant.getOpenAddress());
            }

            if(StringUtils.hasText(merchant.getMailbox())){
                merchantOld.setMailbox(merchant.getMailbox());
            }

            if(merchant.getRegisteredDate()!=null){
                merchantOld.setRegisteredDate(merchant.getRegisteredDate());
            }

            if(StringUtils.hasText(merchant.getIndustry())){
                merchantOld.setIndustry(merchant.getIndustry());
            }

            if(StringUtils.hasText(merchant.getDataDictionary())){
                merchantOld.setDataDictionary(merchant.getDataDictionary());
            }

            if(StringUtils.hasText(merchant.getExplainContent())){
                merchantOld.setExplainContent(merchant.getExplainContent());
            }

            if(StringUtils.hasText(merchant.getDoBusiness())){
                merchantOld.setDoBusiness(merchant.getDoBusiness());
            }

            merchantDao.save(merchantOld);

           return WebResultVo.getInstance().building(WebResultVoEnum.ILLEGALOPERATION);


    }

    @Override
    public PageModel<Merchant> pageMerchant(String searchContent, PageBo pageBo) throws Exception {
        Specification<Merchant> specification = new Specification<Merchant>() {
            @Override
            public Predicate toPredicate(Root<Merchant> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                return null;
            }
        };

        Page<Merchant> adminPage = merchantDao.findAll(specification, PageRequest.of(pageBo.getPageNo() - 1,pageBo.getPageSize(), Sort.by(Sort.Direction.DESC,"id")));

        PageModel<Merchant> pageModel = new PageModel<Merchant>(pageBo.getPageSize(),pageBo.getPageNo(),adminPage.getContent(),adminPage.getTotalElements());
        return pageModel;
    }

    @Override
    public WebResultVo deleteMerchant(Integer id) {

        try {
            merchantDao.deleteById(id);
        } catch (Exception e){
        e.printStackTrace();
        return WebResultVo.getInstance().building(WebResultVoEnum.ERROR);
    }

        return WebResultVo.getInstance().buildingSuccess();
    }
}
