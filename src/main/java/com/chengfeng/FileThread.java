package com.chengfeng;

import java.io.File;
import java.io.FileWriter;

/**
 * IO线程
 * @author chengfeng on 2016/8/26.
 */
public class FileThread extends Thread {

    public FileThread() {
        super("FileThread");
    }

    @Override
    public void run() {
        try {
            File file = new File("/app/test.txt");
            if(!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file);
            String str = "abcdefghjiklmn";
            while (true){
                fileWriter.write(str.toCharArray());
                fileWriter.flush();
                Thread.sleep(1);
                System.out.println("File write!");
            }
        }catch (Exception e){

        }

    }
}
