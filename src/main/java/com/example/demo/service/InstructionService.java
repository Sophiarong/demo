package com.example.demo.service;

import com.example.demo.dao.InstructionRepos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("InstructionService")
public class InstructionService {
    @Resource
    private InstructionRepos instructionRepos;

    public List queryInstructionSec(String s){
        return instructionRepos.insSaved(s);
    }

    public void queryChangeInsStatus(String s){
        instructionRepos.changeInsStatus(s);
    }

    public List queryLastIns(String s,int k){ return instructionRepos.lastInstruction(s,k);}

    public List queryPastIns(String s){return instructionRepos.insPast(s);}
}
