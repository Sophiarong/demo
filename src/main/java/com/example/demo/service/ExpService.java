package com.example.demo.service;

import com.example.demo.dao.ExpPastForPageRepos;
import com.example.demo.dao.ExpRepos;
import com.example.demo.entity.Exp;
import com.example.demo.entity.ExpPastForPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("ExpService")
public class ExpService {
    @Resource
    private ExpRepos expRepos;

    public List queryExpRunning(){
        return expRepos.expRunning();
    }
    public List queryExpSelected(int a,String expId) {return expRepos.expInfo(a, expId);}
    public void queryExpStatus(String s){expRepos.changeExpStatus(s);}
    public void queryExpStop(String s){expRepos.changeExpStop(s);}
    public void queryExpTable(String purpose,String description,String address,String expId){expRepos.changeExpTable(purpose,description,address,expId);}

}
