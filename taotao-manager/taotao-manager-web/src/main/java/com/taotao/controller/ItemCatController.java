package com.taotao.controller;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**商品分类管理controller
 * Created by Asura on 2017/2/18.
 */
@Controller

@RequestMapping("/item/cat")
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatService;

    /**
     * 点击新增商品,再点击选择类目后，展示分类信息
     * @param parentId
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITreeNode> getItemCatList(@RequestParam(value="id",defaultValue = "0") long parentId){
              List<EasyUITreeNode> list= itemCatService.getItemCatList(parentId);
return list;
    }
}
