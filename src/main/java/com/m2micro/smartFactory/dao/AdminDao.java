package com.m2micro.smartFactory.dao;

import com.m2micro.smartFactory.model.Admin;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AdminDao extends PagingAndSortingRepository<Admin,Integer> , JpaSpecificationExecutor<Admin> {

    public Admin getByNumber(String number);
}
