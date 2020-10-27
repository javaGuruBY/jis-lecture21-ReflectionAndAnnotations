package by.jrr.annotations.loader.service;

import by.jrr.annotations.loader.AppLoader;
import by.jrr.annotations.loader.myano.Service;

import static by.jrr.annotations.loader.AppLoader.serviceContext;

@Service
public class MessageService {

    public void sendMessage() {
        BaseService baseService = (BaseService) serviceContext.get("BaseService");
        System.out.println(baseService);
    }
}
