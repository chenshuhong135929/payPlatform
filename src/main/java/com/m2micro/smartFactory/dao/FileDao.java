package com.m2micro.smartFactory.dao;

import com.m2micro.smartFactory.model.AdminUser;
import com.m2micro.smartFactory.model.File;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface FileDao extends PagingAndSortingRepository<File,Integer>, JpaSpecificationExecutor<File> {
    public List<File> findByRelatedAndType(Integer merchantId, String toString);
}
