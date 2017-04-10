package com.taotao.service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;

/**
 * Created by Asura on 2017/3/1.
 */
public interface ItemParamService {

    TaotaoResult getItemParamByCid(long cid);
   TaotaoResult insertItemParam(TbItemParam itemParam);

}
