package com.m2micro.smartFactory.service.impl;

import com.m2micro.smartFactory.bo.MerchantBO;
import com.m2micro.smartFactory.bo.PageBo;
import com.m2micro.smartFactory.dao.MerchantDao;
import com.m2micro.smartFactory.enums.DisableStatusEnum;
import com.m2micro.smartFactory.enums.MerchantStatusEnum;
import com.m2micro.smartFactory.enums.WebResultVoEnum;
import com.m2micro.smartFactory.model.Admin;
import com.m2micro.smartFactory.model.Merchant;
import com.m2micro.smartFactory.service.FileService;
import com.m2micro.smartFactory.service.MerchantService;
import com.m2micro.smartFactory.utils.PageModel;
import com.m2micro.smartFactory.vo.FileVo;
import com.m2micro.smartFactory.vo.MerchantListVo;
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
import java.util.ArrayList;
import java.util.List;

@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantDao merchantDao;
    @Autowired
    private FileService fileService;

    @Override
    public WebResultVo editMerchant(MerchantBO merchantBo) {

        //添加
        if(merchantBo.getId()==null){

            Merchant merchant = new Merchant();
            if(!StringUtils.hasText(merchantBo.getName())){
                return  WebResultVo.getInstance().building(WebResultVoEnum.PARAMETERERROR.getCode(),"商户名称必填！");
            }
            merchant.setName(merchantBo.getName());
            if(!StringUtils.hasText(merchantBo.getLegalPerson())){
                return  WebResultVo.getInstance().building(WebResultVoEnum.PARAMETERERROR.getCode(),"法人必填！");
            }
            merchant.setLegalPerson(merchantBo.getLegalPerson());

            if(!StringUtils.hasText(merchantBo.getIdLastNumber())){
                return  WebResultVo.getInstance().building(WebResultVoEnum.PARAMETERERROR.getCode(),"身份证后四位必填！");
            }
            merchant.setIdLastNumber(merchantBo.getLegalPerson());

            if(!StringUtils.hasText(merchantBo.getLinkPhone())){
                return  WebResultVo.getInstance().building(WebResultVoEnum.PARAMETERERROR.getCode(),"联系电话必填！");
            }
            merchant.setLinkPhone(merchantBo.getLinkPhone());

            if(!StringUtils.hasText(merchantBo.getLinkEmali())){
                return  WebResultVo.getInstance().building(WebResultVoEnum.PARAMETERERROR.getCode(),"类型邮箱必填！");
            }
            merchant.setLinkEmali(merchantBo.getLinkEmali());

            if(!StringUtils.hasText(merchantBo.getRegisteredAddress())){
                return  WebResultVo.getInstance().building(WebResultVoEnum.PARAMETERERROR.getCode(),"注册地址必填！");
            }
            merchant.setRegisteredAddress(merchantBo.getRegisteredAddress());

            if(!StringUtils.hasText(merchantBo.getOpenAddress())){
                return  WebResultVo.getInstance().building(WebResultVoEnum.PARAMETERERROR.getCode(),"营业地址必填！");
            }
            merchant.setOpenAddress(merchantBo.getOpenAddress());
            if(!StringUtils.hasText(merchantBo.getMailbox())){
                return  WebResultVo.getInstance().building(WebResultVoEnum.PARAMETERERROR.getCode(),"邮箱必填！");
            }
            merchant.setMailbox(merchantBo.getMailbox());
            if(merchantBo.getRegisteredDate()==null){
                return  WebResultVo.getInstance().building(WebResultVoEnum.PARAMETERERROR.getCode(),"营业时间必填！");
            }
            merchant.setRegisteredDate(merchantBo.getRegisteredDate());
            if(!StringUtils.hasText(merchantBo.getIndustry())){
                return  WebResultVo.getInstance().building(WebResultVoEnum.PARAMETERERROR.getCode(),"行业必填！");
            }
            merchant.setIndustry(merchantBo.getIndustry());
            if(!StringUtils.hasText(merchantBo.getDataDictionary())){
                return  WebResultVo.getInstance().building(WebResultVoEnum.PARAMETERERROR.getCode(),"数据字典必填！");
            }
            merchant.setDataDictionary(merchantBo.getDataDictionary());
            if(!StringUtils.hasText(merchantBo.getExplainContent())){
                return  WebResultVo.getInstance().building(WebResultVoEnum.PARAMETERERROR.getCode(),"解释内容必填！");
            }
            merchant.setExplainContent(merchantBo.getExplainContent());
            if(!StringUtils.hasText(merchantBo.getDoBusiness())){
                return  WebResultVo.getInstance().building(WebResultVoEnum.PARAMETERERROR.getCode(),"经营业务必填！");
            }
            merchant.setDoBusiness(merchantBo.getDoBusiness());
            merchant.setStatus(MerchantStatusEnum.A.toString());
            merchant.setDisableStatus(DisableStatusEnum.A.toString());
            if(merchantBo.getAdminId() != null){
                Admin admin = new Admin();
                admin.setId(merchantBo.getAdminId());
                merchant.setAdmin(admin);
            }

            merchantDao.save(merchant);
            fileService.updateBindMerchantFile(merchant.getId(),merchantBo.getFileVos());
            return WebResultVo.getInstance().buildingSuccess();
        }

        //修改

        Merchant merchantOld = merchantDao.findById(merchantBo.getId()).orElse(null);

        if(merchantOld==null){
            return  WebResultVo.getInstance().building(WebResultVoEnum.ERROR.getCode(),null);
        }


            if(StringUtils.hasText(merchantBo.getName())){
                merchantOld.setName(merchantBo.getName());
            }


            if(StringUtils.hasText(merchantBo.getLegalPerson())){
                merchantOld.setLegalPerson(merchantBo.getLegalPerson());
            }


            if(StringUtils.hasText(merchantBo.getIdLastNumber())){
                merchantOld.setIdLastNumber(merchantBo.getIdLastNumber());
            }


            if(StringUtils.hasText(merchantBo.getLinkPhone())){
                merchantOld.setLinkPhone(merchantBo.getLinkPhone());
            }


            if(StringUtils.hasText(merchantBo.getLinkEmali())){
                merchantOld.setLinkEmali(merchantBo.getLinkEmali());
            }


            if(StringUtils.hasText(merchantBo.getRegisteredAddress())){
                merchantOld.setRegisteredAddress(merchantBo.getRegisteredAddress());
            }


            if(StringUtils.hasText(merchantBo.getOpenAddress())){
                merchantOld.setOpenAddress(merchantBo.getOpenAddress());
            }

            if(StringUtils.hasText(merchantBo.getMailbox())){
                merchantOld.setMailbox(merchantBo.getMailbox());
            }

            if(merchantBo.getRegisteredDate()!=null){
                merchantOld.setRegisteredDate(merchantBo.getRegisteredDate());
            }

            if(StringUtils.hasText(merchantBo.getIndustry())){
                merchantOld.setIndustry(merchantBo.getIndustry());
            }

            if(StringUtils.hasText(merchantBo.getDataDictionary())){
                merchantOld.setDataDictionary(merchantBo.getDataDictionary());
            }

            if(StringUtils.hasText(merchantBo.getExplainContent())){
                merchantOld.setExplainContent(merchantBo.getExplainContent());
            }

            if(StringUtils.hasText(merchantBo.getDoBusiness())){
                merchantOld.setDoBusiness(merchantBo.getDoBusiness());
            }

            merchantDao.save(merchantOld);
            fileService.updateBindMerchantFile(merchantOld.getId(),merchantBo.getFileVos());

           return WebResultVo.getInstance().building(WebResultVoEnum.SUCCESS);


    }

    @Override
    public PageModel<MerchantListVo> pageMerchant(String searchContent, PageBo pageBo) throws Exception {
        Specification<Merchant> specification = new Specification<Merchant>() {
            @Override
            public Predicate toPredicate(Root<Merchant> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(StringUtils.hasText(searchContent)){
                    predicates.add(criteriaBuilder.like(root.get("name"),"%"+searchContent+"%"));
                }
                return criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
            }
        };

        Page<Merchant> page = merchantDao.findAll(specification, PageRequest.of(pageBo.getPageNo() - 1,pageBo.getPageSize(), Sort.by(Sort.Direction.DESC,"id")));
        List<MerchantListVo> merchantListVos = new ArrayList<>();
        for(Merchant merchant : page){
            MerchantListVo merchantListVo = new MerchantListVo();
            merchantListVo.setDataDictionary(merchant.getDataDictionary());
            merchantListVo.setDisableStatus(merchant.getDisableStatus());
            merchantListVo.setDoBusiness(merchant.getDoBusiness());
            merchantListVo.setExplainContent(merchant.getExplainContent());
            merchantListVo.setId(merchant.getId());
            merchantListVo.setIdLastNumber(merchant.getIdLastNumber());
            merchantListVo.setIndustry(merchant.getIndustry());
            merchantListVo.setRegisteredAddress(merchant.getRegisteredAddress());
            merchantListVo.setLegalPerson(merchant.getLegalPerson());
            merchantListVo.setLinkEmali(merchant.getLinkEmali());
            merchantListVo.setMailbox(merchant.getMailbox());
            merchantListVo.setLinkPhone(merchant.getLinkPhone());
            merchantListVo.setName(merchant.getName());
            merchantListVo.setOpenAddress(merchant.getOpenAddress());
            merchantListVo.setRegisteredDate(merchant.getRegisteredDate());
            merchantListVo.setStatus(merchant.getStatus());
            if(merchant.getAdmin() != null){
                merchantListVo.setAdminName(merchant.getAdmin().getNumber());
            }
             List<FileVo> fileVos =  fileService.findMerchantImageFile(merchant.getId());
             FileVo fileVo = fileService.findBusinessLicensetFile(merchant.getId());
            merchantListVo.setBusinessLicenseFileVo(fileVo);
            merchantListVo.setFileVos(fileVos);
            merchantListVos.add(merchantListVo);
        }

        PageModel<MerchantListVo> pageModel = new PageModel<MerchantListVo>(pageBo.getPageSize(),pageBo.getPageNo(),merchantListVos,page.getTotalElements());
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

    @Override
    public void updateDisableStatus(String disableStatus, Integer id) throws Exception {
        Merchant merchant = this.merchantDao.findById(id).get();
        merchant.setDisableStatus(disableStatus);
        this.merchantDao.save(merchant);
    }
}
