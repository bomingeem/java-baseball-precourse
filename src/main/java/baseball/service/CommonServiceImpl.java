package baseball.service;

import baseball.constant.Constant;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class CommonServiceImpl implements CommonService {

    @Override
    public String getBaseballRandomNumber(int length) {
        Set<Integer> numbers = new HashSet<>();
        numbers = getResultRandomNumber(numbers, length);

        StringBuilder sb = new StringBuilder();
        for (Integer number : numbers) {
            sb.append(number);
        }

        return sb.toString();
    }

    @Override
    public String getReadLine() {
        return Console.readLine();
    }

    private Set<Integer> getResultRandomNumber(Set<Integer> numbers, int length) {
        int randomNumber = getRandomNumber();
        numbers.add(randomNumber);

        if (numbers.size() != length) {
            getResultRandomNumber(numbers, length);
        }
        return numbers;
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(Constant.MIN_VALUE, Constant.MAX_VALUE);
    }
}
