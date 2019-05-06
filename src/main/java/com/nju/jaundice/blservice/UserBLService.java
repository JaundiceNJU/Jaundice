package com.nju.jaundice.blservice;

import com.nju.jaundice.entity.Baby;
import com.nju.jaundice.util.Blood;
import com.nju.jaundice.util.ResultMessage;
import com.nju.jaundice.util.Role;
import com.nju.jaundice.util.Sex;
import com.nju.jaundice.vo.BabyVO;

import java.util.ArrayList;
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
     * 新用户注册
     * @param telephone 手机号码
     * @param password 密码
     * @return 注册结果
     */
    ResultMessage register(String telephone,String password);

    /**
     * 完善用户信息
     * @param telephone 用户电话即ID
     * @param parent 父亲或母亲
     * @param nickname 婴儿昵称
     * @param sex 婴儿性别
     * @param week 孕周
     * @param blood 血型
     * @param bornTime 出生时间
     * @param height 出生身长
     * @param weight 出生体重
     * @param area 出生地区
     * @param hospital 出生医院
     * @return 更新结果
     */
    ResultMessage completeInfo(String telephone, String parent, String nickname, String sex, int week, String blood,
                               String bornTime, double height, double weight, String area, String hospital);


    /**
     * 得到用户信息用以前台显示
     * @return 所有用户数组
     */
    ArrayList<BabyVO> getUserInfoList();

    BabyVO getOneUserInfo(String username);

    ResultMessage saveNewUser(String tel,String babyName,int week,double height,double weight,String area,String hospital,String parent,String blood,String birthday,String sex);

    ResultMessage deleteUser(String[] tel);
}
