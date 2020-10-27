package by.jrr.annotations.loader;

import by.jrr.annotations.loader.myano.ServiceProcessor;
import by.jrr.annotations.loader.service.BaseService;
import by.jrr.annotations.loader.service.MessageService;

import java.util.HashMap;
import java.util.Map;

public class AppLoader {
    public static Map<String, Object> serviceContext = new HashMap();

    static ServiceProcessor serviceProcessor = new ServiceProcessor();

    public static void main(String[] args) {
        serviceProcessor.process(BaseService.class, MessageService.class, String.class);

        MessageService messageService = (MessageService) serviceContext.get("MessageService");
        messageService.sendMessage();
    }
}
