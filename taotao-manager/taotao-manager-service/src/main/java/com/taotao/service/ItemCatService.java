package com.taotao.service;

import com.taotao.common.pojo.EasyUITreeNode;

import java.util.List;

/**
 * Created by Asura on 2017/2/18.
 */
public interface ItemCatService {
    List<EasyUITreeNode> getItemCatList(long parentId);
}
