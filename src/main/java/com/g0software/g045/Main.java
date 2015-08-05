package com.g0software.g045;

import com.g0software.g045.lotto.LottoNumbers;

import java.io.IOException;

/**
 * Created by hanoseok on 14. 12. 12..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Lotto lotto = Lotto.create();
        int episode = 661;
        LottoNumbers lottoNumbers = lotto.getLottoNumbers(1, episode - 1);
        lottoNumbers.byLottoNumber(lotto.getLottoNumber(episode));
        System.out.println(lottoNumbers);
        System.out.println(lotto.getLottoNumber(episode));
    }


}
