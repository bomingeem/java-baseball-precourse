package baseball.controller;

import baseball.config.AppConfig;
import baseball.constant.Constant;
import baseball.domain.Baseball;
import baseball.domain.BaseballResultMessage;
import baseball.service.BaseballService;
import baseball.service.CommonService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {
    public Baseball baseball;
    public CommonService commonService;
    public BaseballService baseballService;
    public String computerNumber;

    public void play() {
        initConfig();
        initGame();
        while (baseball.isStart()) {
            startGame();
            restartGame();
        }
    }

    private void startGame() {
        while (!baseball.isSuccess()) {
            InputView.printInputNumber();
            String userNumber = commonService.getReadLine();
            baseballService.validateGameNumber(userNumber);
            baseball = baseballService.resultBaseball(userNumber, computerNumber);
            BaseballResultMessage baseballResultMessage = new BaseballResultMessage(baseball);
            OutputView.printResultGame(baseballResultMessage.resultGameMessage());
            printEndGame();
        }

    }

    private void initConfig() {
        AppConfig appConfig = new AppConfig();
        baseballService = appConfig.baseballService();
        commonService = appConfig.commonService();
    }

    private void initGame() {
        baseball = Baseball.initBaseball();
        computerNumber = commonService.getBaseballRandomNumber(Constant.NUMBER_LENGTH);
    }

    private void restartGame() {
        InputView.printRestartGame();
        String restartGameValue = commonService.getReadLine();
        boolean isStart = restartGameValue.equals(Constant.RESTART_GAME);
        if (isStart) {
            this.initGame();
        }
    }

    private void printEndGame() {
        if (baseball.isSuccess()) {
            OutputView.printEndGame();
        }
    }
}
