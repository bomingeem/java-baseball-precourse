package baseball.domain;

import baseball.constant.Constant;

public class BaseballResultMessage {
    private StringBuilder stringBuilder;

    public BaseballResultMessage(Baseball baseball) {
        stringBuilder = new StringBuilder();
        getBallMessage(baseball);
        getSpaceMessage(baseball);
        getStrikeMessage(baseball);
        getNothingMessage(baseball);
    }

    public String resultGameMessage() {
        return stringBuilder.toString();
    }

    private void getBallMessage(Baseball baseball) {
        if (baseball.getBallCount() > 0) {
            stringBuilder.append(baseball.getBallCount());
            stringBuilder.append(Constant.BALL);
        }
    }

    private void getStrikeMessage(Baseball baseball) {
        if (baseball.getStrikeCount() > 0) {
            stringBuilder.append(baseball.getStrikeCount());
            stringBuilder.append(Constant.STRIKE);
        }
    }

    private void getNothingMessage(Baseball baseball) {
        if (baseball.isNothing()) {
            stringBuilder.append(Constant.NOTHING);
        }
    }

    private void getSpaceMessage(Baseball baseball) {
        if (baseball.getBallCount() > 0 && baseball.getStrikeCount() > 0) {
            stringBuilder.append(Constant.SPACE);
        }

    }
}
