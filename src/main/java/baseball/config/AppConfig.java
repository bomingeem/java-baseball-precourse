package baseball.config;

import baseball.service.BaseballService;
import baseball.service.BaseballServiceImpl;
import baseball.service.CommonService;
import baseball.service.CommonServiceImpl;

public class AppConfig {

    public BaseballService baseballService() {
        return new BaseballServiceImpl();
    }
    public CommonService commonService() {
        return new CommonServiceImpl();
    }
}
