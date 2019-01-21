package com.github.krystianmadra.guitarshop.user;

import com.github.krystianmadra.guitarshop.entities.UserEntity;

public class UserDTOToEntity {

    public static UserEntity toEntity(UserDTO entity){
        UserEntity ret = new UserEntity();
        ret.setUsername(entity.getUsername());
        ret.setPassword(entity.getPassword());
        ret.setEmail(entity.getEmail());
        return ret;
    }
}
