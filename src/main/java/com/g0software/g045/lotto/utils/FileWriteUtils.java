package com.g0software.g045.lotto.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by hanoseok on 2015. 8. 11..
 */
public class FileWriteUtils {

    public static void write(File file, String string) throws IOException {
        if(file.exists()){
            file.delete();
            file.createNewFile();
        }
        FileWriter fw = null;
        try {
            new FileWriter(file, true);
            fw.append(string);
            fw.flush();
        }finally {
            if(fw != null){
                fw.close();
            }
        }
    }
}
