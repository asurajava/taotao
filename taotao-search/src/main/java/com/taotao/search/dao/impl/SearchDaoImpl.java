package com.taotao.search.dao.impl;

import com.taotao.search.dao.SearchDao;
import com.taotao.search.pojo.Item;
import com.taotao.search.pojo.SearchResult;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Asura on 2017/3/18.
 */
@Repository
public class SearchDaoImpl implements SearchDao{
    @Autowired
    private SolrServer solrServer;

    @Override
    public SearchResult search(SolrQuery query) throws Exception {
        //返回值对象
        SearchResult result=new SearchResult();
        //根据查询条件查询索引库
        QueryResponse queryResponse=solrServer.query(query);
        //取查询结果
        SolrDocumentList solrDocumentsList=queryResponse.getResults();
        //取查询结果总数量
        result.setRecordCount(solrDocumentsList.getNumFound());
        //商品列表
        List<Item> itemList=new ArrayList<>();
        //取高亮显示
        Map<String,Map<String,List<String>>> highlighting=queryResponse.getHighlighting();
        //取商品列表
        for(SolrDocument solrDocument:solrDocumentsList){
            //创建一商品对象
            Item item=new Item();
            item.setId((String)solrDocument.get("id"));
            //取高亮显示的结果
           List<String> list=highlighting.get(solrDocument.get("id")).get("item_title");
            String title="";
            if(list!=null && list.size()>0){
                title=list.get(0);
            }else{
                title=(String)solrDocument.get("item_title");
            }
            item.setTitle((String)solrDocument.get(title));
            item.setImage((String)solrDocument.get("item_image"));
            item.setPrice((long)solrDocument.get("item_price"));
            item.setSell_point((String)solrDocument.get("item_sell_point"));
            item.setCategory_name((String)solrDocument.get("item_category_name"));
        //添加到商品列表
            itemList.add(item);
        }
        result.setItemList(itemList);
        return result;
    }
}