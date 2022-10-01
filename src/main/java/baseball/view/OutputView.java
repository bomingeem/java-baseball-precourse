package baseball.view;

import baseball.constant.Constant;

public class OutputView {
    public static void printResultGame(String message) {
        System.out.println(message);
    }

    public static void printEndGame() {
        System.out.println(Constant.END_MESSAGE);

    }
}
