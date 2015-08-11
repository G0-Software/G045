package com.g0software.g045.lotto;

import com.g0software.g045.Order;

import java.util.*;

/**
 * Created by hanoseok on 14. 12. 15..
 */
public class LottoNumbers {

    List<LottoNumber> lottoNumberList;

    // 번호, 횟수
    private Map<Integer, Integer> numberMap = new HashMap<>();
    private Map<Integer, Integer> bonusMap = new HashMap<>();
    private Map<Integer, Integer> allNumberMap = new HashMap<>();

    // 번호, 등수 (많 횟수가 1등)
    private Map<Integer, Integer> numberDescRankMap = new HashMap<>();
    private Map<Integer, Integer> bonusDescRankMap = new HashMap<>();
    private Map<Integer, Integer> allNumberDescRankMap = new HashMap<>();

    // 번호, 등수 (적은 횟수가 1등)
    private Map<Integer, Integer> numberAscRankMap = new HashMap<>();
    private Map<Integer, Integer> bonusAscRankMap = new HashMap<>();
    private Map<Integer, Integer> allNumberAscRankMap = new HashMap<>();


    public LottoNumbers(List<LottoNumber> lottoNumberList) {
        for (LottoNumber lottoNumber : lottoNumberList) {
            setNumberMap(lottoNumber.getNumbers());
            setBonusMap(lottoNumber.getBonus());
            setAllNumberMap(lottoNumber.getAllNumbers());
        }
    }

    private void setNumberMap(List<Integer> numbers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : numbers) {
            setMap(numberMap, i);
        }
        numberDescRankMap = lottoMapToRankMap(numberMap, Sort.DESC);
        numberAscRankMap = lottoMapToRankMap(numberMap, Sort.ASC);
    }

    private void setBonusMap(Integer bonus) {
        Map<Integer, Integer> map = new HashMap<>();
        setMap(bonusMap, bonus);
        bonusDescRankMap = lottoMapToRankMap(bonusMap, Sort.DESC);
        bonusAscRankMap = lottoMapToRankMap(bonusMap, Sort.ASC);
    }

    private void setAllNumberMap(List<Integer> allNumbers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : allNumbers) {
            setMap(allNumberMap, i);
        }
        allNumberDescRankMap = lottoMapToRankMap(allNumberMap, Sort.DESC);
        allNumberAscRankMap = lottoMapToRankMap(allNumberMap, Sort.ASC);
    }

    public String minSix() {
        LinkedHashMap<Integer, Integer> map = sort(numberMap);
        return mapToString(map);
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

    public List<Integer> getAllNumberRankDesc(Integer ... i) {
        return getRate(allNumberDescRankMap, i);
    }

    public List<Integer> getAllNumberRankAsc(Integer ... i) {
        return getRate(allNumberAscRankMap, i);
    }

    public List<Integer> getNumberRankDesc(Integer ... i) {
        return getRate(numberDescRankMap, i);
    }

    public List<Integer> getNumberRankAsc(Integer ... i) {
        return getRate(numberAscRankMap, i);
    }

    public List<Integer> getBonusRankDesc(Integer ... i) {
        return getRate(bonusDescRankMap, i);
    }

    public List<Integer> getBonusRankAsc(Integer ... i) {
        return getRate(bonusAscRankMap, i);
    }

    public String byLottoNumber(LottoNumber lottoNumber) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : lottoNumber.getAllNumbers()) {
            map.put(i, numberDescRankMap.get(i));
        }
        return valueToStringLikeLottoResource(map);
    }

    @Override
    public String toString() {
        LinkedHashMap<Integer, Integer> map = sort(numberMap);
        return mapToString(map);
    }

    private void setMap(Map<Integer, Integer> map, Integer i) {
        if (map.get(i) == null) {
            map.put(i, 1);
        } else {
            map.put(i, map.get(i) + 1);
        }
    }
    private String mapToString(Map map){
        StringBuilder sb = new StringBuilder();
        for (Object num : map.keySet()) {
            sb.append(num + " : " + map.get(num) + "\n");
        }
        return sb.toString();
    }

    private String valueToStringLikeLottoResource(Map<Integer, Integer> map) {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (Object num : map.keySet()) {
            if(i++ < map.size() - 1){
                sb.append(map.get(num) + ",");
            }else if (i++ == map.size()){
                sb.append(map.get(num) + ":");
            }else {
                sb.append(map.get(num) + "\n");
            }
        }
        return sb.toString();
    }

    public LinkedHashMap sort(final Map map){
        return sort(map, Sort.ASC);
    }

    public LinkedHashMap sort(final Map map, final Sort sort){
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                if (e1.getValue() == null || e2.getValue() == null)
                    return 0;
                if (e1.getValue() == e2.getValue())
                    return e1.getKey().compareTo(e2.getKey());
                else
                    return e2.getValue().compareTo(e1.getValue());
            }
        });

        if(sort == Sort.ASC)
            Collections.reverse(list); // 주석시 오름차순

        LinkedHashMap<Integer, Integer> result = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> e : list) {
            result.put(e.getKey(), e.getValue());
        }

        return result;
    }

    private Map<Integer, Integer> lottoMapToRankMap(Map<Integer, Integer> nMap, Sort sort){
        Map<Integer, Integer> map = new HashMap<>();
        int r = 1;
        LinkedHashMap<Integer, Integer> sMap = sort(nMap, sort);
        for (int i : sMap.keySet()) {
            map.put(i, r++);
        }
        return map;
    }

    private List<Integer> getRate(Map<Integer,Integer> map, Integer ... i){
        List<Integer> list = new ArrayList<>();
        for (int a : i) {
            for(Integer key : map.keySet()){
                if(map.get(key).intValue() == a){

                    list.add(key);
                    continue;
                }
            }
        }
        return list;
    }

}
