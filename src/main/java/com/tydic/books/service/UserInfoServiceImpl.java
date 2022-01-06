package com.tydic.books.service;

import com.tydic.books.dao.UserInfoMapper;
import com.tydic.books.pojo.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl{
    @Autowired
    private UserInfoMapper userInfoMapper;

    public List<UserInformation> SignInCheak(int userId, String password) {
        return userInfoMapper.SignInCheak(userId,password);
    }

    //0登录成功，1则失败
    public int getSingInCheck(int userId, String password){
        List<UserInformation> userInformations = this.SignInCheak(userId,password);
        if (userInformations == null || userInformations.isEmpty()){
            return 1;
        }else {
            return 0;
        }
    }
}
