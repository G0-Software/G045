package com.g0software.g045;

import java.io.IOException;

/**
 * Created by hanoseok on 14. 12. 12..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Lotto lotto = Lotto.create();

        System.out.println(lotto.getLottoNumbers(1,650).minSix());


    }
}
