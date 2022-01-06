package com.tydic.books.dao;

import com.tydic.books.pojo.UserInformation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserInfoMapper {
    @Select("select * from mybatislearning.userinformation where userId=#{userId} and password=#{password}")
    public List<UserInformation> SignInCheak(@Param("userId") int userId, @Param("password") String password);
}
