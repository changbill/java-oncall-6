package oncall.controller;

import oncall.repository.OnCallRepository;
import oncall.service.OnCallParser;
import oncall.service.OnCallService;
import oncall.service.OnCallValidator;

public class OnCallControllerFactory {

    public static OnCallController getController() {
        OnCallValidator onCallValidator = new OnCallValidator();
        OnCallParser onCallParser = new OnCallParser();
        OnCallRepository onCallRepository = new OnCallRepository();
        OnCallService onCallService = new OnCallService(onCallValidator, onCallParser, onCallRepository);

        return new OnCallController(onCallService);
    }

    private OnCallControllerFactory() {}
}
