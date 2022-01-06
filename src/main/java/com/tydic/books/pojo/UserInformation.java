package com.tydic.books.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

//顺序不能错，Alias要放上面
@Alias("UInf")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInformation {
    private int userId;
    private String userName;
    private String age;
    private String address;
    private String exInfo;
    private String password;
}