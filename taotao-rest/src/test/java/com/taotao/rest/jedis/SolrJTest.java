package com.taotao.rest.jedis;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

/**
 * Created by Asura on 2017/3/16.
 */

public class SolrJTest {
    @Test
    public void addDocument()throws Exception{
        //创建一个连接
        SolrServer solrServer=new HttpSolrServer("http://192.168.93.4:8080/solr");
        //创建一个文档对象
        SolrInputDocument document=new SolrInputDocument();
        document.addField("id","test001");
        document.addField("item_title","测试商品1");
        document.addField("item_price",12345);
        //把文档对象写入索引库
         solrServer.add(document);
        //提交
        solrServer.commit();
    }
    @Test
    public void deleteDocument()throws  Exception{
        //创建连接
        SolrServer solrServer=new HttpSolrServer("http://192.168.93.4:8080/solr");
        //solrServer.deleteById("test001");
        solrServer.deleteByQuery("*:*");
        solrServer.commit();
    }
    @Test
    public void queryDocument()throws Exception{
        SolrServer solrServer=new HttpSolrServer("http://192.168.93.4:8080/solr");
        SolrQuery query=new SolrQuery();
        //设置查询条件
        query.setQuery("*:*");

        //执行查询
       QueryResponse response= solrServer.query(query);
        //取查询结果
        SolrDocumentList solrDocumentsList=response.getResults();
        System.out.println("共查询到记录："+solrDocumentsList.getNumFound());
        for(SolrDocument solrDocument:solrDocumentsList){
            System.out.println(solrDocument.get("id"));
            System.out.println(solrDocument.get("item_price"));
            System.out.println(solrDocument.get("item_title"));
            System.out.println(solrDocument.get("item_image"));
        }
    }

}
