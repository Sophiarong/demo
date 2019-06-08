package com.example.demo.service;

import com.example.demo.dao.IndexRepos;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service("IndexService")
public class IndexService {
    @Resource
    private IndexRepos indexRepos;

    public List queryIndexAll(){
        return indexRepos.findAll();
    }
}
