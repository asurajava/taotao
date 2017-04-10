package com.taotao.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Created by Asura on 2017/2/23.
 */
public interface PictureService {
    Map uploadPicture(MultipartFile uploadFile);
}
