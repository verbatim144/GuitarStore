package com.github.krystianmadra.guitarshop.user;

import com.github.krystianmadra.guitarshop.entities.UserEntity;

public class UserDTOToEntity {

    public static UserEntity toEntity(UserDTO dto){
        UserEntity ret = new UserEntity();
        ret.setUsername(dto.getUsername());
        ret.setPassword(dto.getPassword());
        ret.setEmail(dto.getEmail());
        return ret;
    }
}
