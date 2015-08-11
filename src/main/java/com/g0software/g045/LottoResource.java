package com.g0software.g045;

import com.g0software.g045.lotto.LottoNumber;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by hanoseok on 14. 12. 15..
 */
public class LottoResource {

    Map<Integer, LottoNumber> map = new HashMap<>();

    protected LottoResource(File f) throws IOException {
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        int episode = 0;
        while ((line = br.readLine()) != null) {
            LottoNumber ln = new LottoNumber();
            List<Integer> numbers = new ArrayList<>();
            List<Integer> allNumbers = new ArrayList<>();

            String[] lottos = line.split("[,:]");
            for (int i = 0; i < 6; i++) {
                try {
                    numbers.add(Integer.parseInt(lottos[i]));
                    allNumbers.add(Integer.parseInt(lottos[i]));
                }catch (Exception e){}
            }
            ln.setNumbers(numbers);
            try {
                ln.setBonus(Integer.parseInt(lottos[6]));
                allNumbers.add(Integer.parseInt(lottos[6]));
            }catch (Exception e){
            }
            ln.setAllNumbers(allNumbers);
            ln.setEpisode(++episode);
            map.put(episode, ln);
        }
        fr.close();
    }

}
