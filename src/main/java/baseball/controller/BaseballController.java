package baseball.controller;

import baseball.config.AppConfig;
import baseball.domain.Baseball;
import baseball.service.BaseballService;
import baseball.service.CommonService;

public class BaseballController {
    public Baseball baseball;
    public CommonService commonService;
    public BaseballService baseballService;

    public void play() {
        initConfig();
        initGame();
    }

    private void initConfig() {
        AppConfig appConfig = new AppConfig();
        baseballService = appConfig.baseballService();
        commonService = appConfig.commonService();
    }

    private void initGame() {
        baseball = Baseball.initBaseball();
    }
}
