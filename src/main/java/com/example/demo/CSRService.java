package com.example.demo;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service
@Transactional
public class CSRService {
 
    @Autowired
    private CSRRepository repo;
     
    public List<TblProgramCSR> listAll() {
        return repo.findAll();
    }
     
    public void save(TblProgramCSR tbl_csr) {
        repo.save(tbl_csr);
    }
     
    public TblProgramCSR get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
}
