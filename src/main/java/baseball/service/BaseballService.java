package baseball.service;

import baseball.domain.Baseball;

public interface BaseballService {
    Baseball resultBaseball(String userNumber, String computerNumber);
    void validateGameNumber(String number);
}
