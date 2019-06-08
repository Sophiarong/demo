package com.example.demo.service;

import com.example.demo.dao.ExpPastForPageRepos;
import com.example.demo.entity.ExpPastForPage;
import com.example.demo.entity.ExpSaveForPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ExpPastForPageService")
public class ExpPastForPageService {
    @Autowired
    ExpPastForPageRepos expPastForPageRepos;
    @Transactional(readOnly = true)
    public Page<ExpPastForPage> getPage(Integer pageNum, Integer size){
        Pageable pageable = PageRequest.of(pageNum - 1,size);
        return expPastForPageRepos.findAll(pageable);
    }
}
