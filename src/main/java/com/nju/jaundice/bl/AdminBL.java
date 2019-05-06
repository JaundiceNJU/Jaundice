package com.nju.jaundice.bl;

import com.nju.jaundice.blservice.AdminBLService;
import com.nju.jaundice.dao.AdminDao;
import com.nju.jaundice.entity.Admin;
import com.nju.jaundice.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminBL implements AdminBLService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public ResultMessage adminLogin(String username, String password) {
        Admin admin=adminDao.find(username);
        if(admin == null){
            return ResultMessage.NOTEXIST;
        }
        if(admin.getPassword().equals(password)){
            return ResultMessage.ADMINLOGIN;
        }else {
            return ResultMessage.PASSERROR;
        }
    }
}
