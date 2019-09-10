package com.ht.shop.common.util;

public class PathUtil {

    /**
     * 根据操作系统的不同，获取保存图片的基本路径
     * @return
     */
    public static String getImgBasePath(){
        String os = System.getProperty("os.name");

        String basePath = "";

        if(os.toLowerCase().startsWith("win")){
            basePath = "d:/work/image";
        }else{
            basePath = "/usr/local/image";
        }
        return basePath;
    }

    /**
     * 商品图片的路径  存在数据库
     * @param fileName 文件名
     * @param  extName 扩展名
     * @return
     */
    public static String getShopImagePath(String fileName,String extName){
        String shopImgPath = "/shop/"+fileName+extName;
        return shopImgPath;
    }

}
