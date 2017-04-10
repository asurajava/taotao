package com.taotao.portal.service;

import com.taotao.portal.pojo.SearchResult;

/**
 * Created by Asura on 2017/4/7.
 */
public interface SearchService {
    SearchResult search(String queryString, int page);
}
