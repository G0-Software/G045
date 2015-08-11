package com.g0software.g045;

import com.g0software.g045.lotto.utils.FileWriteUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;

import java.io.*;
import java.util.regex.Pattern;

/**
 * Created by hanoseok on 2015. 8. 4..
 */
public class LottoResourceMaker {

    private static final Pattern BALL_PATTERN = Pattern.compile("/img/common/ball_");
    private static final Pattern BONUS_PATTERN = Pattern.compile("<p class=\"number_bonus\">");
    public static void main(String[] args) throws IOException, InterruptedException {


        StringBuilder sb = new StringBuilder();
        int no = 1;
        while (true) {
            HttpClient client = new HttpClient();
            HttpMethod method = new GetMethod("http://www.nlotto.co.kr/lotto645Confirm.do?method=byWin&drwNo=" + (no++));
            client.executeMethod(method);
            String s = null;
            BufferedReader br = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream()));

            boolean start = false;
            int i = 0;

            String lotto = new String();
            while ((s = br.readLine()) != null) {
                if (!start && BONUS_PATTERN.matcher(s).find()) {
                    start = true;
                }
                if (start && BALL_PATTERN.matcher(s).find()) {
                    try {
                        int number = Integer.parseInt(s.split("\"")[3]);
                        if (i++ < 5) {
                            lotto += number + (",");
                        } else if (i++ == 6) {
                            lotto += number + (":");
                        } else {
                            lotto += number + ("\n");
                        }
                    } catch (NumberFormatException e) {
                    }
                }
            }

            System.out.print(lotto);
            sb.append(lotto);

            Thread.sleep(300);
            if (!start) {
                break;
            }
        }

        FileWriteUtils.write(new File("src/main/resources/lotto.txt"), sb.toString());
    }
}
