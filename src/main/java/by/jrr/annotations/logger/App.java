package by.jrr.annotations.logger;

import by.jrr.annotations.logger.bean.Human;
import by.jrr.annotations.logger.bean.Person;
import by.jrr.annotations.logger.processor.MyLoggerProcessor;

public class App {

    public static void main(String[] args) {
        Person person = new Person("Max", "Shelkovich");
        Human human = new Human("Maxim", "Shelkovichs");
        MyLoggerProcessor.process(person);
        MyLoggerProcessor.process(human);
    }
}
