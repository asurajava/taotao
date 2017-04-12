package com.taotao.controller;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**商品管理controller
 * Created by Asura on 2017/2/17.
 */
@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;

    /**
     * 点击之后根据id查询某一个商品
     * @param itemId
     * @return
     */
    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId){
        TbItem item=itemService.getItemById(itemId);
        return  item;
    }

    /**
     * 点击查询商品,在itemlist页面展示所有商品
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/item/list")
    @ResponseBody
    public EasyUIDataGridResult getItemList(Integer page,Integer rows){
   EasyUIDataGridResult result=itemService.getItemList(page,rows);
        return  result;
    }

    /**
     *新增商品提交按钮
     * @param item
     * @param desc
     * @param itemParams
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/item/save",method = RequestMethod.POST)
@ResponseBody
    public TaotaoResult createItem(TbItem item,String desc,String itemParams)throws Exception{
         TaotaoResult result=itemService.createItem(item,desc,itemParams);
    return result;
}
}
