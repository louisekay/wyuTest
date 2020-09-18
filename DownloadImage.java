package iofile;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class DownloadImage {
    static BASE64Encoder encoder = new sun.misc.BASE64Encoder();
    static BASE64Decoder decoder = new sun.misc.BASE64Decoder();


    public  static byte[] getBytesByURL(String imageUrl)throws IOException {
                   ByteArrayOutputStream baos = new ByteArrayOutputStream();
                   BufferedInputStream bis = null;
                   HttpURLConnection urlconnection= null;
                URL url = null;
                 byte[] buf = new byte[1024];
                  try {
                          url = new URL(imageUrl);
                           urlconnection = (HttpURLConnection) url.openConnection();
                           urlconnection.connect();
                           bis = new BufferedInputStream(urlconnection.getInputStream());
                           for (int len = 0; (len = bis.read(buf)) != -1;){
                                    baos.write(buf,0,len);
                               }
                           return baos.toByteArray();
                       } finally {
                           try {
                                   urlconnection.disconnect();
                                    bis.close();
                              } catch (IOException ignore) {
                               }
                       }
              }

    public static void main(String[] args) throws IOException {
//        String str = "http://pic1.win4000.com/pic/1/5c/b19b23087f.jpg";
//
//        File f = new File(str);
//        BufferedImage bi;
//        try {
//            bi = ImageIO.read(f);
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            ImageIO.write(bi, "jpg", baos);  //经测试转换的图片是格式这里就什么格式，否则会失真
//            byte[] bytes = baos.toByteArray();
//
            File file = new File("D:\\fileTest"+"\\aaa.jpg");
            file.mkdirs();
            OutputStream outputStream = new FileOutputStream(file);
            outputStream.write(getBytesByURL("http://pic1.win4000.com/pic/1/5c/b19b23087f.jpg"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }




    }
}
