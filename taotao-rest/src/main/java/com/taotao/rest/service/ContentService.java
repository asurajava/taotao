package com.taotao.rest.service;

import com.taotao.pojo.TbContent;

import java.util.List;

/**
 * Created by Asura on 2017/3/9.
 */
public interface ContentService {
    List<TbContent> getContentList(long contentCid);
}
