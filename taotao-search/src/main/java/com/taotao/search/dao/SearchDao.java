package com.taotao.search.dao;

import com.taotao.search.pojo.SearchResult;
import org.apache.solr.client.solrj.SolrQuery;

/**
 * Created by Asura on 2017/3/18.
 */
public interface SearchDao {
    SearchResult search(SolrQuery query)throws Exception;
}
