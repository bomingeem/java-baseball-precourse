package baseball.service;

import baseball.domain.Baseball;

public class BaseballServiceImpl implements BaseballService {

    @Override
    public Baseball resultBaseball(String userNumber, String computerNumber) {
        int resultCountBall = countBall(userNumber, computerNumber);
        int resultStrikeBall = strikeBall(userNumber, computerNumber);
        return Baseball.saveBaseball(resultCountBall, resultStrikeBall);
    }

    @Override
    public void validateGameNumber(String number) {
        validateEmptyValue(number);
        validateNumberValue(number);
        validateZeroValue(number);
        validateValueLength(number);
    }

    private int countBall(String userNumber, String computerNumber) {
        int count = 0;
        for (int i=0; i<userNumber.length(); i++) {
            if (computerNumber.charAt(i) != userNumber.charAt(i) && computerNumber.contains(String.valueOf(userNumber.charAt(i)))) {
                count++;
            }
        }
        return count;
    }

    private int strikeBall(String userNumber, String computerNumber) {
        int count = 0;
        for (int i=0; i<userNumber.length(); i++) {
            if (userNumber.charAt(i) == computerNumber.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    private void validateEmptyValue(String str) {
        if (isEmpty(str)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberValue(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateZeroValue(String str) {
        if (str.contains("0")) {
            throw new IllegalArgumentException();
        }
    }

    private void validateValueLength(String str) {
        if (str.length() != 3) {
            throw new IllegalArgumentException();
        }
    }


    private boolean isEmpty(String str) {
        return str == null || str.equals("");
    }
}
