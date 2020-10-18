package pl.a99fallen.spring.core.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.a99fallen.spring.core.components.printers.ConsolePrinter;
import pl.a99fallen.spring.core.components.printers.DialogPrinter;
import pl.a99fallen.spring.core.components.printers.FilePrinter;

public class PrinterApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("/pl.a99fallen.spring.core.components.printers");
        context.refresh();

        ConsolePrinter consolePrinter = context.getBean("consolePrinter", ConsolePrinter.class);
        consolePrinter.print("Hello World! ConsolePrinter");

        DialogPrinter dialogPrinter = context.getBean("dialogPrinter", DialogPrinter.class);
        dialogPrinter.print("Hello World! DialogPrinter");

        FilePrinter filePrinter = context.getBean("filePrinter", FilePrinter.class);
        filePrinter.print("Hello World! FilePrinter");
    }
}
