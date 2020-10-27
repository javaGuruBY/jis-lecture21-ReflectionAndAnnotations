package by.jrr.annotations.logger.example;

import java.lang.annotation.*;

@Documented  // попадает в Javadoc
//@Inherited   // наследуется потомками
@Target(ElementType.TYPE) // область применения
@Retention(RetentionPolicy.RUNTIME) // время жизни
public @interface MyLogger {
    String value() default "";
    String name() default "";
}

//@Target(ElementType.ANNOTATION_TYPE)// - только над другой аннтотацией
//@Target(ElementType.CONSTRUCTOR)// - над конструктором
//@Target(ElementType.FIELD)// - над полем
//@Target(ElementType.LOCAL_VARIABLE) - над локальной переменной метода (@NotNull, @Nullable)
//@Target(ElementType.METHOD)// - над методом
//@Target(ElementType.PACKAGE)// - над пекеджем, можно применить ко всем классам пакета @Deprecated
//@Target(ElementType.PARAMETER)// - над аргументом метода
//@Target(ElementType.TYPE)// - над классом или интерфейсом

//@Retention(RetentionPolicy.SOURCE) - только в исходном коде (ни компилятор, ни рандайм - только для документации обычно)
//@Retention(RetentionPolicy.CLASS) - на вермя работы компилятора
//@Retention(RetentionPolicy.RUNTIME) - во время исполнения программы
