package pl.a99fallen.spring.core.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import pl.a99fallen.spring.core.config.WarmUpConfiguration;
import pl.a99fallen.spring.core.warmup.HelloWorld_3_1;

public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WarmUpConfiguration.class);
//        context.register(WarmUpConfiguration.class);
        context.scan("/pl.a99fallen.spring.core.warmup");
//        context.refresh();

        HelloWorld_3_1 helloBean = context.getBean("helloBean", HelloWorld_3_1.class);
        helloBean.sayHello();

        HelloWorld_3_1 helloWorld = context.getBean("helloWorld", HelloWorld_3_1.class);
        helloWorld.sayHello();

        System.out.println(helloBean == helloWorld);

        HelloWorld_3_1 helloBean2 = context.getBean("helloBean", HelloWorld_3_1.class);
        HelloWorld_3_1 helloWorld2 = context.getBean("helloWorld", HelloWorld_3_1.class);

        System.out.println(helloBean == helloBean2);
        System.out.println(helloWorld == helloWorld2);

        HelloWorld_3_1 helloBuzz = context.getBean("buzzBuzz", HelloWorld_3_1.class);
        System.out.println("HELLO BUZZ");
        helloBuzz.sayHello();

//        to nie zadziała bo nie wiemy do ktrego beana się odwołać
//        HelloWorld helloBuzz1 = context.getBean(HelloWorld.class);
//        helloBuzz1.sayHello();
    }

    public static void classPathWarmUp() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        HelloWorld_3_1 bean = (HelloWorld_3_1) context.getBean("helloBean");
        bean.sayHello();

    }
    public static void genericContextA1() {
        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean("helloWorld", HelloWorld_3_1.class);
        context.refresh();

        HelloWorld_3_1 bean = (HelloWorld_3_1) context.getBean("helloWorld");
        bean.sayHello();

        bean = context.getBean("helloWorld", HelloWorld_3_1.class);
        bean.sayHello();

        bean = context.getBean(HelloWorld_3_1.class);
        bean.sayHello();
    }
}
