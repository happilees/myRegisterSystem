package com.hsp.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by zhanhengkitt on 2016/1/16.
 */
public class PullOutUtils {


    public static boolean pullOut(StringBuffer stringBuffer,String filePath) {
        boolean isPull = false;

        File file = new File(filePath);
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(stringBuffer.toString());

            bw.close();
            isPull = true;
        }
        catch (IOException e) {
           isPull = false;
            e.printStackTrace();
        }
        return isPull;
    }
}
