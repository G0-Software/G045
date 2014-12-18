package com.g0software.g045.lotto.utils;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by hanoseok on 14. 12. 15..
 */
public class LottoMap {


    Map<Integer, LottoNumberMap> map = new TreeMap<>();

    public void addNumber(int number){
        LottoNumberMap lnm = map.get(number);
        if(lnm == null){
            lnm = new LottoNumberMap();
            lnm.count = 0;
            lnm.number = number;
        }
        lnm.count ++;
        map.put(number, lnm);
    }


    class LottoNumberMap{
        private int number;
        private int count;
    }




}
