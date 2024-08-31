package com.sky.service;

import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;

public interface UserService {
    /*
     * @Description: wx登录
     * @author Frailty
     * @date 2024/3/27 20:45
     * @param userLoginDTO 
     * @return com.sky.entity.User
     */
    User wxLogin(UserLoginDTO userLoginDTO);
}
