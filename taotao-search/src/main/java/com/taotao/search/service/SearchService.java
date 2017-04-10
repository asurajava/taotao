package com.taotao.search.service;

import com.taotao.search.pojo.SearchResult;

/**
 * Created by Asura on 2017/3/18.
 */
public interface SearchService {
    SearchResult search(String queryString,int page,int rows)throws Exception;
}
