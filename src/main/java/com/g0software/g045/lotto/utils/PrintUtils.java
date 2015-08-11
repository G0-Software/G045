package com.g0software.g045.lotto.utils;

import java.util.List;

/**
 * Created by hanoseok on 2015. 8. 5..
 */
public class PrintUtils {


    public static String toString(List list, String separator) {
        StringBuilder sb = new StringBuilder();
        if(list != null)
            for (int i = 0; i <  list.size(); i++){
                sb.append(String.valueOf(list.get(i)));
                if(i < list.size() - 1){
                    sb.append(separator);
                }
            }
        return sb.toString();
    }
}
