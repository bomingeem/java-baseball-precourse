package baseball.service;

import baseball.domain.Baseball;

public class BaseballServiceImpl implements BaseballService {

    @Override
    public Baseball resultBaseball(String userNumber, String computerNumber) {
        int resultCountBall = countBall(userNumber, computerNumber);
        int resultStrikeBall = strikeBall(userNumber, computerNumber);
        return Baseball.saveBaseball(resultCountBall, resultStrikeBall);
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
}
