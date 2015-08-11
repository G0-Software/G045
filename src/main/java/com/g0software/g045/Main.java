package com.g0software.g045;

import com.g0software.g045.lotto.LottoNumbers;
import com.g0software.g045.lotto.utils.PrintUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by hanoseok on 14. 12. 12..
 */
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Lotto lotto = Lotto.create(new File("src/main/resources/lotto.txt"));
        int episode = 661;

        LottoNumbers lottoNumbers = lotto.getLottoNumbers(1, 1000);
        System.out.println(PrintUtils.toString(lottoNumbers.getNumberRankDesc(20, 14, 8, 12, 15, 27), ", "));
        System.out.println(PrintUtils.toString(lottoNumbers.getNumberRankAsc(20, 14, 8, 12, 15, 27), ", "));
        System.out.println(PrintUtils.toString(lottoNumbers.getNumberRankDesc(17, 31, 6, 12, 15, 19), ", "));



        for (int i = 1; i <= 662; i++) {
//            System.out.println("========================");
//            LottoNumbers lottoNumbers1 = lotto.getLottoNumbers(1, i-1);
//            System.out.print(lottoNumbers1.byLottoNumber(lotto.getLottoNumber(i)));
//            LottoNumbers lottoNumbers2 = lotto.getLottoNumbers(1, i);

//            System.out.print(lottoNumbers2.byLottoNumber(lotto.getLottoNumber(i)));
//            System.out.println("------------------------");
//            System.out.println(lotto.getLottoNumber(i).toStringSimple());
        }
    }



}
