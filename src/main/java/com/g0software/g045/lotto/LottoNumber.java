package com.g0software.g045.lotto;

import java.util.List;

/**
 * Created by hanoseok on 14. 12. 15..
 */
public class LottoNumber {

    private int episode;

    private List<Integer> numbers;

    public List<Integer> getAllNumbers() {
        return allNumbers;
    }

    public void setAllNumbers(List<Integer> allNumbers) {
        this.allNumbers = allNumbers;
    }

    private List<Integer> allNumbers;

    private Integer bonus;

    public int getEpisode() {
        return episode;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Episode : " + episode + "\n");
        sb.append("numbers : ");

        for (int i = 0; i < 5; i++) {
            sb.append(numbers.get(i) + ",");
        }
        sb.append(numbers.get(5));
        sb.append("\n");
        sb.append("bonus : " + bonus + "\n");

        return sb.toString();
    }
}
