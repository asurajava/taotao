package com.taotao.service;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;

import java.util.List;

/**
 * Created by Asura on 2017/3/6.
 */
public interface ContentCategoryService {
    List<EasyUITreeNode> getCategoryList(long parentId);
    TaotaoResult insertContentCategory(long parentId,String name);
    TaotaoResult deleteContentCategory(long parentId,long id);
    TaotaoResult updateContentCategory(long id,String name);
}
