package com.g0software.g045;

import com.g0software.g045.lotto.LottoNumbers;
import com.g0software.g045.lotto.utils.FileWriteUtils;
import com.g0software.g045.lotto.utils.PrintUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by hanoseok on 14. 12. 12..
 */
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Lotto lotto = Lotto.create(new File("src/main/resources/lotto.txt"));
        int episode = 662;

        LottoNumbers lottoNumbers = lotto.getLottoNumbers(1, episode);
        System.out.println(PrintUtils.toString(lottoNumbers.getNumberRankDesc(20, 14, 8, 12, 15, 27), ", ", true));
        System.out.println(PrintUtils.toString(lottoNumbers.getNumberRankAsc(20, 14, 8, 12, 15, 27), ", ", true));

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= episode; i++) {
            LottoNumbers lottoNumbers1 = lotto.getLottoNumbers(1, i - 1);
            sb.append(lottoNumbers1.byLottoNumber(lotto.getLottoNumber(i)));
        }
        FileWriteUtils.write(new File("src/main/resources/lotto.tmp"), sb.toString());


        Lotto lottoTmp = Lotto.create(new File("src/main/resources/lotto.tmp"));
        LottoNumbers lottoNumbersTmp = lottoTmp.getLottoNumbers(1, episode);
        System.out.println(PrintUtils.toString(lottoNumbers.getNumberRankDesc(lottoNumbersTmp.getNumberRankDesc(1, 2, 3, 4, 5, 6).toArray(new Integer[6])), ", ", true));

    }



}
