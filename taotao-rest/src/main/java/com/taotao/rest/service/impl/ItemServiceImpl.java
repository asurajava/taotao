package com.taotao.rest.service.impl;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.rest.dao.JedisClient;
import com.taotao.rest.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**商品信息管理
 * Created by Asura on 2017/4/9.
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper itemMapper;
    @Autowired
    private JedisClient jedisClient;
    @Override
    public TaotaoResult getItemBaseInfo(long itemId) {
        //添加缓存逻辑
        //从缓存中取商品信息，商品id对应的信息


        //根据商品id查询商品信息
        TbItem item=itemMapper.selectByPrimaryKey(itemId);
        //使用TaoTaoResult包装一下
        //把商品信息写入缓存
        //设置key的有效期

        return TaotaoResult.ok(item);
    }
}
