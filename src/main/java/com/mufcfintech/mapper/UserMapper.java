package com.mufcfintech.mapper;

import com.mufcfintech.api.UserApi;
import com.mufcfintech.entity.User;
import com.mufcfintech.util.Util;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserMapper {

    public static User convertUserApiToEntity(UserApi userApi) {
        User userEntity = new User();
        setUserEntity(userEntity, userApi);
        return userEntity;
    }

    public static User setUserEntity(User userEntity, UserApi userApi) {
        userEntity.setName(userApi.getName());
        userEntity.setSurname(userApi.getSurname());
        userEntity.setBirthDate(userApi.getBirthDate());
        userEntity.setCountry(userApi.getCountry());
        userEntity.setCity(userApi.getCity());
        userEntity.setFullAddress(userApi.getFullAddress());
        userEntity.setPassword(userApi.getPassword());
        userEntity.setBirthDate(userApi.getBirthDate());
        userEntity.setReferralCode(UUID.randomUUID().toString());
        setTokenForNewUser(userEntity, userApi);
        return userEntity;
    }

    private static void setTokenForNewUser (User userEntity, UserApi userApi) {
        int token = 0;
        if(!StringUtils.isBlank(userApi.getReferralCode())){
            token += 5;
        }
        if(Util.isOver35YearsOld(userApi.getBirthDate())) {
            token += 10;
        } else {
            token += 5;
        }
        userEntity.setToken(String.valueOf(token));
    }

    public static List<UserApi> convertEntitiesToUserApiList(List<User> userEntity) {
        List<UserApi> userApiList = new ArrayList<>();
        for (User user : userEntity) {
            userApiList.add(convertEntityToUserApi(user));
        }
        return userApiList;
    }

    public static UserApi convertEntityToUserApi(User userEntity) {
        UserApi userApi = new UserApi();
        userApi.setId(userEntity.getId());
        userApi.setName(userEntity.getName());
        userApi.setSurname(userEntity.getSurname());
        userApi.setBirthDate(userEntity.getBirthDate());
        userApi.setCity(userEntity.getCity());
        userApi.setCountry(userEntity.getCountry());
        userApi.setFullAddress(userEntity.getFullAddress());
        userApi.setToken(userEntity.getToken());
        userApi.setReferralCode(userEntity.getReferralCode());
        return userApi;
    }


}
