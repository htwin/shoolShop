package com.ht.shop.common.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class ValidateCode {



    public static void validateCode()  {

        int width = 90;
        int height = 35;

        Random random = new Random();

        //内存中创建一张图片，
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);

        //获取画笔 对该图片进行操作
        Graphics2D g = image.createGraphics();

        //画一个白色的小框
        g.setColor(Color.white);
        g.fillRect(1,1,width-2,height-2);

        //验证码数据
        String data = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        char[] dataArray = data.toCharArray();

        StringBuffer validateCode = new StringBuffer();

        for(int i=0;i<4;i++){
            int index = random.nextInt(dataArray.length);
            //随机一种颜色 每一个字符不同的颜色
            g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
            g.setFont(new Font("",1,20));
            //int temp = random.nextInt(15)+15;
            g.drawString(dataArray[index]+"",i*(width/4),random.nextInt(15)+15);
            validateCode.append(dataArray[index]);
        }

        OutputStream out = null;
        try {
            out = new FileOutputStream("d:/temp/validateCode/1.jpg");
            ImageIO.write(image,"jpg",out);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }









    }

    public static void main(String[] args) {

            validateCode();


    }

}
