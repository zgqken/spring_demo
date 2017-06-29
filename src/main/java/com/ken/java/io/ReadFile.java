package com.ken.java.io;

import org.apache.commons.io.FileUtils;

import java.io.*;

/**
 * 类名称：
 * 类描述：
 * 创建人：zgquan
 * 创建日期：2017/6/29 0029
 */
public class ReadFile {

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        try {
            String fs = FileUtils.readFileToString(new File("D://test.txt"), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }


//        String str = getChar("D://test.txt");
//        String str = getFileByByte("D://test.txt");
//        String str = readFileByChars("D://test.txt");
        System.out.println("耗时：" + (System.currentTimeMillis() - begin));
//        System.out.println(str.length());
    }

    /**
     * 按行读取
     * @param filePath
     * @return
     */
    public static String getChar(String filePath) {
        StringBuffer sb = new StringBuffer();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8")
        )) {
            //中文编码
            String tempString;
            while ((tempString = reader.readLine()) != null) {
                sb.append(tempString);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * 按字节读取
     * @param fileName
     * @return
     */
    public static String getFileByByte(String fileName){

        StringBuffer sb = new StringBuffer();
        try(InputStream in = new FileInputStream(fileName)) {
            // 一次读多个字节
            byte[] tempbytes = new byte[2048];
            // 读入多个字节到字节数组中，byteread为一次读入的字节数
            while ((in.read(tempbytes)) != -1) {
                sb.append(new String(tempbytes));
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * 按字符读取
     * @param fileName
     */
    public static String  readFileByChars(String fileName) {

        StringBuffer sb = new StringBuffer();
        try(Reader reader = new InputStreamReader(new FileInputStream(fileName))) {
            char[] tempchars = new char[1024];
            int charread = 0;
            // 读入多个字符到字符数组中，charread为一次读取字符数
            while ((charread = reader.read(tempchars)) != -1) {
                // 对于windows下，\r\n这两个字符在一起时，表示一个换行。
                // 但如果这两个字符分开显示时，会换两次行。
                // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行
                if ((charread == tempchars.length)
                        && (tempchars[tempchars.length - 1] != '\r')) {
                    sb.append(new String(tempchars));
                } else {
                    for (int i = 0; i < charread; i++) {
                        if (tempchars[i] == '\r') {
                            continue;
                        } else {
                            sb.append(tempchars[i]);
                        }
                    }
                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return sb.toString();
    }


}
