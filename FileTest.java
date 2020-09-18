package iofile;



import java.io.*;

public class FileTest {




    public void printPath(String path,int num1){
        int num = num1+1;
       String blank = " ";
    File dir=new File(path);
    if(dir.exists()){
        File[] tmp =dir.listFiles();//用数组来装所有文件和文件夹的名字

         for (int j = 0; j < num; j++) {
            blank += "  ";
         }
        for (int i = 0; i < tmp.length; i++) {
            if(tmp[i].isDirectory()) {//如果是目录就调自己

                System.out.println(blank+"文件夹:"+ tmp[i].getName());
                printPath(tmp[i].getAbsolutePath(),num);
            }else {
//                for (int j = 0; j < num; j++) {
//                    blank += " ";
//                }
                System.out.println(blank+"文件名:"+tmp[i].getName());
            }
        }

    }
}
    public static void main(String[] args) throws IOException {

        FileTest fileTest = new FileTest();
        fileTest.printPath("D:\\fileTest",0);
        //写文件
          //File file = new File("D:\\fileTest");//File.separator跨平台用
//        OutputStream outputStream = new FileOutputStream(file,true);
//
//        byte[] bytes = "aaa".getBytes();
//        outputStream.write(bytes);
//        outputStream.close();

        //读文件
//        InputStream inputStream = new FileInputStream(file);
//
//        byte[] b=new byte[1024];
//        int temp=0;
//        int len=0;
//        while((temp=inputStream.read())!=-1){//-1为文件读完的标志
//            b[len]=(byte) temp;
//            len++;
//        }
//        inputStream.close();


    }


}
