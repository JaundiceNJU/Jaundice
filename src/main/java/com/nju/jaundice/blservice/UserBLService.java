package com.nju.jaundice.blservice;

import com.nju.jaundice.entity.Baby;
import com.nju.jaundice.util.Blood;
import com.nju.jaundice.util.ResultMessage;
import com.nju.jaundice.util.Role;
import com.nju.jaundice.util.Sex;

import java.util.Date;

public interface UserBLService {

    /**
     * 用户登录
     * @param telephone 手机号码
     * @param password 密码
     * @return 登录结果
     */
    ResultMessage login(String telephone,String password);

    /**
     * 新用户注册，该方法参数应该不止，尚未考虑验证码
     * @param telephone 手机号码
     * @param password 密码
     * @return 注册结果
     */
    ResultMessage register(String telephone,String password);

    ResultMessage completeInfo(String telephone, Role parent, String nickname, Sex sex, int week, Blood blood, Date bornTime, double height, double weight, String area, String hospital);
}
