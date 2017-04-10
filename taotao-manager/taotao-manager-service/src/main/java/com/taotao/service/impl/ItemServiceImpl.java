package com.taotao.service.impl;

import com.github.pagehelper.*;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.IDUtils;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

/**商品查询Service
 * Created by Asura on 2017/2/16.
 */
@Service
public class ItemServiceImpl implements ItemService {
   @Autowired
   private TbItemMapper itemMapper;
    @Autowired
    private TbItemDescMapper itemDescMapper;
    @Autowired
    private TbItemParamItemMapper itemParamItemMapper;
    @Override
    public TbItem getItemById(Long itemId) {
       TbItemExample example=new TbItemExample();
        //创建查询条件
      TbItemExample.Criteria criteria=example.createCriteria();
        criteria.andIdEqualTo(itemId);
       List<TbItem> list= itemMapper.selectByExample(example);
 //判断list中是否为空
        TbItem item=null;
        if(list!=null && list.size()>0){
            item=list.get(0);
        }
        return item;
    }

    @Override
    public EasyUIDataGridResult getItemList(int page, int rows) {
       //分页处理
        PageHelper.startPage(page,rows);

        //执行查询
        TbItemExample example=new TbItemExample();
       List<TbItem> list= itemMapper.selectByExample(example);
        //取分页信息
        PageInfo<TbItem> pageInfo=new PageInfo<>(list);
        //返回处理结果
        EasyUIDataGridResult result=new EasyUIDataGridResult();
            result.setTotal(pageInfo.getTotal());
        result.setRows(list);
        return result;
    }

    @Override
    public TaotaoResult createItem(TbItem item,String desc,String itemParam) throws Exception {
        //Item补全
        //生成商品id
        Long itemId= IDUtils.genItemId();
        item.setId(itemId);
        //商品状态：1-正常 2-下架 3-删除
        item.setStatus((byte)1);
        item.setCreated(new Date());
        item.setUpdated(new Date());
        //插入到数据库
        itemMapper.insert(item);
        //添加商品描述信息
       TaotaoResult result= insertItemDesc(itemId,desc);

        if(result.getStatus()!=200){
            throw new Exception();
        }
        //添加规格参数
       result= insertItemParamItem(itemId,itemParam);
        if(result.getStatus()!=200){
            throw new Exception();
        }
        return TaotaoResult.ok();
    }


    /**
     * 添加商品描述
     * @param desc
     */
    private TaotaoResult insertItemDesc(Long itemId,String desc){
        TbItemDesc itemDesc=new TbItemDesc();
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(new Date());
        itemDesc.setUpdated(new Date());

        itemDescMapper.insert(itemDesc);
        return TaotaoResult.ok();
    }

    /**
     * 添加规格参数
     * @param itemId
     * @param itemParam
     * @return
     */
    private TaotaoResult insertItemParamItem(Long itemId,String itemParam){
        //创建pojo
        TbItemParamItem itemParamItem=new TbItemParamItem();
        itemParamItem.setItemId(itemId);
        itemParamItem.setParamData(itemParam);
        itemParamItem.setCreated(new Date());
        itemParamItem.setUpdated(new Date());
        //向表中插入数据
        itemParamItemMapper.insert(itemParamItem);
        return TaotaoResult.ok();
    }
}
