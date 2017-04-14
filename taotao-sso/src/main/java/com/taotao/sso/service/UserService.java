package com.taotao.sso.service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbUser;

/**
 * Created by Asura on 2017/4/13.
 */
public interface UserService {
    TaotaoResult checkData(String content,Integer type);
    TaotaoResult createUser(TbUser user);
    TaotaoResult userLogin(String username,String password);
    TaotaoResult getUserByToken(String token);
}
