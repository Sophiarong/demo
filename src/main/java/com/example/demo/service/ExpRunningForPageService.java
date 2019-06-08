package com.example.demo.service;

import com.example.demo.dao.ExpRunningForPageRepos;
import com.example.demo.dao.ExpSaveForPageRepos;
import com.example.demo.entity.ExpRunningForPage;
import com.example.demo.entity.ExpSaveForPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ExpRunningForPageService")
public class ExpRunningForPageService {
    @Autowired
    ExpRunningForPageRepos expRunningForPageRepos;
    @Transactional(readOnly = true)
    public Page<ExpRunningForPage> getPage(Integer pageNum, Integer size){
        Pageable pageable = PageRequest.of(pageNum - 1,size);
        return expRunningForPageRepos.findAll(pageable);
    }
}
