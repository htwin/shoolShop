package com.ht.shop.common.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImageUtil {



    //水印的路径
    private static String wartMarkPath = Thread.currentThread().getContextClassLoader().getResource("watermark.jpg").getPath();

    /**
     * 生成加水印的缩略图
     * @param thumbnail
     * @return
     * @throws IOException
     */
    public static String generateThumbnail(MultipartFile thumbnail) throws IOException {

        //原始的文件名
        String  originalFilename= thumbnail.getOriginalFilename();

        //文件扩展名
        String extName = originalFilename.substring(originalFilename.lastIndexOf("."));

        //获取随机文件名
        String  realFileName = getRandomFileName();

        //得到存储在数据库中的路径
        String shopImagePath = PathUtil.getShopImagePath(realFileName, extName);

        //最终文件   系统基本路径 + 数据库中存储路径
        String targetPath = PathUtil.getImgBasePath()+shopImagePath;

        //获取缩略图
        Thumbnails.of(thumbnail.getInputStream())
                .size(200,300)
                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(wartMarkPath)),0.2f)
                .outputQuality(0.8f)
                .toFile(targetPath);

        return shopImagePath;

    }

    /**
     * 生成随机文件名 当前年月日小时分钟秒 + 5位随机数
     * @return
     */
    private static String getRandomFileName() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

        //5为随机数
        Random random = new Random();
        int ranNum = random.nextInt(89999)+10000;

        String format = simpleDateFormat.format(new Date());

        return format + ranNum;

    }


    public static void main(String[] args) throws IOException {


        System.out.println(Thread.currentThread().getContextClassLoader().getResource("watermark.jpg").getPath());


        Thumbnails.of("d:/temp/my.jpg")
                .size(400,600)
                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("d:/temp/watermark.jpg")),0.5f)
                .outputQuality(0.8f)
                .toFile("d:/temp/img/my_watermark.jpg");

    }
}
