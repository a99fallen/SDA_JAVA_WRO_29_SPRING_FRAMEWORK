package pl.a99fallen.spring.core.app;

import org.springframework.context.support.GenericApplicationContext;
import pl.a99fallen.spring.core.warmup.HelloWorld;

public class Application {

    public static void main(String[] args) {
        
    }
    public static void genericContextA1() {
        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean("helloWorld", HelloWorld.class);
        context.refresh();

        HelloWorld bean = (HelloWorld) context.getBean("helloWorld");
        bean.sayHello();

        bean = context.getBean("helloWorld", HelloWorld.class);
        bean.sayHello();

        bean = context.getBean(HelloWorld.class);
        bean.sayHello();
    }
}
