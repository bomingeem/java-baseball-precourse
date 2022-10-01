package baseball.domain;

public class BaseballResultMessage {
    private StringBuilder stringBuilder;

    public BaseballResultMessage(Baseball baseball) {
        stringBuilder = new StringBuilder();
        getBallMessage(baseball);
        getStrikeMessage(baseball);
        getNothingMessage(baseball);
    }

    public String resultGameMessage() {
        return stringBuilder.toString();
    }

    private void getBallMessage(Baseball baseball) {
        if (baseball.getBallCount() > 0) {
            stringBuilder.append(baseball.getBallCount());
            stringBuilder.append("볼 ");
        }
    }

    private void getStrikeMessage(Baseball baseball) {
        if (baseball.getStrikeCount() > 0) {
            stringBuilder.append(baseball.getStrikeCount());
            stringBuilder.append("스트라이크");
        }
    }

    private void getNothingMessage(Baseball baseball) {
        if (baseball.isNothing()) {
            stringBuilder.append("낫싱");
        }
    }
}
