package com.g0software.g045.lotto;

import com.g0software.g045.Order;

import java.util.*;

/**
 * Created by hanoseok on 14. 12. 15..
 */
public class LottoNumbers {

    List<LottoNumber> lottoNumberList;

    private Map<Integer, Integer> numberMap = new HashMap<>();
    private Map<Integer, Integer> bonusMap = new HashMap<>();
    private Map<Integer, Integer> allNumberMap = new HashMap<>();

    public class Builder {

        LottoNumbers lottoNumbers;

        public Builder(List<LottoNumber> list) {
            for (LottoNumber lottoNumber : lottoNumberList) {
                setNumberMap(lottoNumber.getNumbers());
                setBonusMap(lottoNumber.getBonus());
                setAllNumberMap(lottoNumber.getAllNumbers());
            }
        }

        private void setBonusMap(Integer bonus) {
            Map<Integer, Integer> map = new HashMap<>();
            setMap(lottoNumbers.bonusMap, bonus);
        }

        private void setAllNumberMap(List<Integer> allNumbers) {
            Map<Integer, Integer> map = new HashMap<>();
            for (Integer i : allNumbers) {
                setMap(lottoNumbers.allNumberMap, i);
            }
        }

        private void setNumberMap(List<Integer> numbers) {
            Map<Integer, Integer> map = new HashMap<>();
            for (Integer i : numbers) {
                setMap(lottoNumbers.numberMap, i);
            }
        }

        private void setMap(Map<Integer, Integer> map, Integer i) {
            if (map.get(i) == null) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }

    }


    public String minSix() {
        LinkedHashMap<Integer, Integer> map = sort(numberMap);

        StringBuilder sb = new StringBuilder();
        for (Integer num : map.keySet()) {
            sb.append(num + " : " + map.get(num) + "\n");
        }
        return sb.toString();
    }

    public String maxSix() {
        return null;
    }

    public String allMinSix() {
        return null;
    }

    public String allMaxSix() {
        return null;
    }

    public String minBonus() {
        return null;
    }

    public String maxBonus() {
        return null;
    }

    public String listNumber(Order order) {
        return null;
    }

    public String listAllNumber(Order order) {
        return null;
    }

    public String listBonus(Order order) {
        return null;
    }

    @Override
    public String toString() {
        LinkedHashMap<Integer, Integer> map = sort(numberMap);

        StringBuilder sb = new StringBuilder();
        for (Integer num : map.keySet()) {
            sb.append(num + " : " + map.get(num) + "\n");
        }
        return sb.toString();
    }

    public LinkedHashMap sort(final Map map){
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                if (e1.getValue() == e2.getValue())
                    return e1.getKey().compareTo(e2.getKey());
                else
                    return e2.getValue().compareTo(e1.getValue());
            }
        });

        Collections.reverse(list); // 주석시 오름차순
        LinkedHashMap<Integer, Integer> result = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> e : list)
            result.put(e.getKey(), e.getValue());

        return result;
    }

    public String byLottoNumber(LottoNumber lottoNumber) {
return null;
    }



}
