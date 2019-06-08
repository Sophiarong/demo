package com.example.demo.service;

import com.example.demo.dao.ExpSaveForPageRepos;
import com.example.demo.entity.ExpSaveForPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service("ExpSaveForPageService")
public class ExpSaveForPageService {
    @Autowired
    ExpSaveForPageRepos expSaveForPageRepos;
    @Transactional(readOnly = true)
    public Page<ExpSaveForPage> getPage(Integer pageNum,Integer size){
        Pageable pageable = PageRequest.of(pageNum - 1,size);
        return expSaveForPageRepos.findAll(pageable);
    }
}
