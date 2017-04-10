package com.taotao.pagehelper;

import com.taotao.common.utils.FtpUtil;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by Asura on 2017/2/23.
 */
public class FTPTest {
    @Test
    public void testFtpClient() throws Exception{
        //创建一个FtpClient对象
        FTPClient ftpClient=new FTPClient();
        //创建ftp连接,默认是21
        ftpClient.connect("192.168.93.4");
        //登录ftp服务器,使用用户名和密码
        ftpClient.login("ftpuser","911013gong");
        //上传文件
        //读取本地文件
        FileInputStream inputStream=new FileInputStream(new File("C:\\Users\\Asura\\Desktop\\2.JPG"));
         //设置上传路径
        ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
        //修改上传文件的格式
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        //第一个参数:服务器端文件名
        //第二个参数：上传文件的inputstream

        ftpClient.storeFile("hello1.jpg",inputStream);
        //关闭连接
        ftpClient.logout();

    }
    @Test
    public void testFtpUtil()throws  Exception{
   FileInputStream inputStream=new FileInputStream(new File("C:\\Users\\Asura\\Desktop\\2.JPG"));
        FtpUtil.uploadFile("192.168.93.4",21,"ftpuser","911013gong","/home/ftpuser/www/images","2015/09/04","hello.jpg",inputStream);

    }
}
