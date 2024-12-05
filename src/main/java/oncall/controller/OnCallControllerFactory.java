package oncall.controller;

import oncall.repository.OnCallRepository;
import oncall.service.OnCallParser;
import oncall.service.OnCallSaveService;
import oncall.service.OnCallValidator;

public class OnCallControllerFactory {

    public static OnCallController getController() {
        OnCallValidator onCallValidator = new OnCallValidator();
        OnCallParser onCallParser = new OnCallParser();
        OnCallRepository onCallRepository = new OnCallRepository();
        OnCallSaveService onCallSaveService = new OnCallSaveService(onCallValidator, onCallParser, onCallRepository);

        return new OnCallController(onCallSaveService);
    }

    private OnCallControllerFactory() {}
}
