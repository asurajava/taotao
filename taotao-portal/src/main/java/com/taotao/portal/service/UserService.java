package com.taotao.portal.service;

import com.taotao.pojo.TbUser;

/**
 * Created by Asura on 2017/4/18.
 */
public interface UserService {
    TbUser getUserByToken(String token);
}
