package pl.a99fallen.spring.core.warmup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.a99fallen.spring.core.components.printers.ConsolePrinter;
import pl.a99fallen.spring.core.components.printers.DialogPrinter;
import pl.a99fallen.spring.core.components.printers.Printer;

import java.util.Random;

@Component
public class HelloWorld {

    private DialogPrinter dialogPrinter;
    private Printer consolePrinter;
    private Printer somePrinter;

    @Autowired @Primary
    public void setSomePrinter(Printer somePrinter) {
        this.somePrinter = somePrinter;
    }

    @Autowired @Qualifier ("consolePrinter")
    public void setConsolePrinter(Printer consolePrinter) {
        this.consolePrinter = consolePrinter;
    }

    @Autowired
    public HelloWorld (DialogPrinter dialogPrinter) {
        this.dialogPrinter = dialogPrinter;
    }

    public HelloWorld() {

    }

    public void sayHello() {
        if (new Random().nextInt(2) > 0) {
            dialogPrinter.print("Hello, world!");
        }
        else {
            consolePrinter.print("Hello, world!");
        }
    }
}
