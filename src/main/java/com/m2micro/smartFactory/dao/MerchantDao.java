package com.m2micro.smartFactory.dao;

import com.m2micro.smartFactory.model.Merchant;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MerchantDao extends PagingAndSortingRepository<Merchant,Integer>, JpaSpecificationExecutor< Merchant> {
    
}
