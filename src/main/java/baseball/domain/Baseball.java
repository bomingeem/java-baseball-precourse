package baseball.domain;

public class Baseball {
    private int ballCount;
    private int strikeCount;
    private boolean isNothing;
    private boolean isSuccess;
    private boolean isStart;

    public static Baseball initBaseball() {
        return new Baseball(0, 0, false, false, true);
    }

    public static Baseball saveBaseball(int ballCount, int strikeCount) {
        return new Baseball(ballCount, strikeCount, ballCount == 0 && strikeCount == 0, strikeCount == 3);
    }

    public Baseball(int ballCount, int strikeCount, boolean isNothing, boolean isSuccess) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
        this.isNothing = isNothing;
        this.isSuccess = isSuccess;
    }

    public Baseball(int ballCount, int strikeCount, boolean isNothing, boolean isSuccess, boolean isStart) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
        this.isNothing = isNothing;
        this.isSuccess = isSuccess;
        this.isStart = isStart;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public boolean isNothing() {
        return isNothing;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public boolean isStart() {
        return isStart;
    }
}
