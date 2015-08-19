package com.g0software.g045.lotto.utils;

import com.g0software.g045.lotto.Sort;

import java.util.*;

/**
 * Created by hanoseok on 2015. 8. 5..
 */
public class PrintUtils {


    public static String toString(List list, String separator, boolean sort) {
        if(sort){
            Collections.sort(list);
        }
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
