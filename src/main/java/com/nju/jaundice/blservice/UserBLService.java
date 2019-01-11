package com.nju.jaundice.blservice;

import com.nju.jaundice.util.ResultMessage;

public interface UserBLService {

    /**
     * 用户登录
     * @param telephone 手机号码
     * @param password 密码
     * @return 登录结果
     */
    public ResultMessage login(String telephone,String password);

    /**
     * 新用户注册，该方法参数应该不止，尚未考虑验证码
     * @param telephone 手机号码
     * @param password 密码
     * @return 注册结果
     */
    public ResultMessage register(String telephone,String password);
}
