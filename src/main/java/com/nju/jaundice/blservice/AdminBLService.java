package com.nju.jaundice.blservice;

import com.nju.jaundice.util.ResultMessage;

public interface AdminBLService {

    ResultMessage adminLogin(String username,String password);
}
