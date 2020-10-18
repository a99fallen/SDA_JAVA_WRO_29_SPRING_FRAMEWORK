package pl.a99fallen.spring.core.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import pl.a99fallen.spring.core.config.WarmUpConfiguration;
import pl.a99fallen.spring.core.warmup.HelloWorld;

public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WarmUpConfiguration.class);
//        context.register(WarmUpConfiguration.class);
        context.scan("/pl.a99fallen.spring.core.warmup");
//        context.refresh();

        HelloWorld helloBean = context.getBean("helloBean", HelloWorld.class);
        helloBean.sayHello();

        HelloWorld helloWorld = context.getBean("helloWorld", HelloWorld.class);
        helloWorld.sayHello();

        System.out.println(helloBean == helloWorld);

        HelloWorld helloBean2 = context.getBean("helloBean", HelloWorld.class);
        HelloWorld helloWorld2 = context.getBean("helloWorld", HelloWorld.class);

        System.out.println(helloBean == helloBean2);
        System.out.println(helloWorld == helloWorld2);

        HelloWorld helloBuzz = context.getBean("buzzBuzz", HelloWorld.class);
        System.out.println("HELLO BUZZ");
        helloBuzz.sayHello();

//        to nie zadziała bo nie wiemy do ktrego beana się odwołać
//        HelloWorld helloBuzz1 = context.getBean(HelloWorld.class);
//        helloBuzz1.sayHello();
    }

    public static void classPathWarmUp() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        HelloWorld bean = (HelloWorld) context.getBean("helloBean");
        bean.sayHello();

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
