package pl.a99fallen.spring.core.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.a99fallen.spring.core.components.printers.ConsolePrinter;
import pl.a99fallen.spring.core.components.printers.DialogPrinter;
import pl.a99fallen.spring.core.components.printers.FilePrinter;
import pl.a99fallen.spring.core.warmup.HelloWorld;

public class PrinterApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("pl.a99fallen.spring.core.warmup", "pl.a99fallen.spring.core.components");
        context.refresh();

        HelloWorld helloWorld = context.getBean(HelloWorld.class);
        helloWorld.sayHello();
    }

//    public static void quest_2() {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.scan("/pl.a99fallen.spring.core.components.printers");
//        context.refresh();
//
//        ConsolePrinter consolePrinter = context.getBean("consolePrinter", ConsolePrinter.class);
//        consolePrinter.print("Hello World! ConsolePrinter");
//
//        DialogPrinter dialogPrinter = context.getBean("dialogPrinter", DialogPrinter.class);
//        dialogPrinter.print("Hello World! DialogPrinter");
//
//        FilePrinter filePrinter = context.getBean("filePrinter", FilePrinter.class);
//        filePrinter.print("Hello World! FilePrinter");
//    }
}
