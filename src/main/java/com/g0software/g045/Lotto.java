package com.g0software.g045;

import com.g0software.g045.lotto.LottoNumber;
import com.g0software.g045.lotto.LottoNumbers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanoseok on 14. 12. 15..
 */
public class Lotto {

    LottoResource lottoResource;

    private Lotto(){};

    public static Lotto create() throws IOException {
        Lotto lotto = new Lotto();
        lotto.lottoResource = new LottoResource(new File("G045/src/main/resources/lotto.txt"));
        return lotto;
    }

    public LottoNumber getEpisode(int episode){
        return lottoResource.map.get(episode);
    }

    public LottoNumbers getLottoNumbers(int start, int end){
        List<LottoNumber> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if(lottoResource.map.get(i) == null){
                break;
            }
            list.add(lottoResource.map.get(i));
        }
        return new LottoNumbers(list);
    }



}
