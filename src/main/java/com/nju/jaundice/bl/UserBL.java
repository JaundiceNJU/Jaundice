package com.nju.jaundice.bl;

import com.nju.jaundice.blservice.UserBLService;
import com.nju.jaundice.util.ResultMessage;
import org.springframework.stereotype.Service;

@Service
public class UserBL implements UserBLService {
    @Override
    public ResultMessage login(String telephone, String password) {
        return null;
    }

    @Override
    public ResultMessage register(String telephone, String password) {
        return null;
    }
}
