package com.taotao.portal.service;

import com.taotao.portal.pojo.ItemInfo;

/**
 * Created by Asura on 2017/4/12.
 */
public interface ItemService {
    ItemInfo getItemById(Long itemId);
    String getItemDescById(Long itemId);
    String getItemParam(Long itemId);

}
