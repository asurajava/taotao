package com.taotao.portal.service.impl;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.common.utils.JsonUtils;
import com.taotao.portal.pojo.Order;
import com.taotao.portal.service.OrderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


/**
 * Created by Asura on 2017/4/19.
 */
@Service
public class OrderServiceImpl implements OrderService {
    /**
     * 订单处理service
     * @param order
     * @return
     */

    @Value("${ORDER_BASE_URL}")
    private String ORDER_BASE_URL;
    @Value("${ORDER_CREATE_URL}")
    private String ORDER_CREATE_URL;
    @Override
    public String createOrder(Order order) {
      //调用创建订单服务之前补全用户信息
        //从cookie中获取TT_TOKEN内容，根据token换取用户信息
        //调用taotao-order的服务提交订单
       String json= HttpClientUtil.doPostJson(ORDER_BASE_URL+ORDER_CREATE_URL, JsonUtils.objectToJson(order));
        //把json转换成taotaoresult
       TaotaoResult taotaoResult= TaotaoResult.format(json);
        if(taotaoResult.getStatus()==200){
           Object orderId= taotaoResult.getData();
            return orderId.toString();
        }
        return  "";
    }
}
