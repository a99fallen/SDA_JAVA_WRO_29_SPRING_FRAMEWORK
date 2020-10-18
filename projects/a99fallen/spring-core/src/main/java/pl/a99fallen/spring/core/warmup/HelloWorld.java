package pl.a99fallen.spring.core.warmup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.a99fallen.spring.core.components.printers.ConsolePrinter;
import pl.a99fallen.spring.core.components.printers.DialogPrinter;
import pl.a99fallen.spring.core.components.printers.Printer;

import javax.swing.text.html.Option;
import java.util.Optional;
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
        random();
//        if (new Random().nextInt(2) > 0) {
//            dialogPrinter.print("Hello, world!");
//        }
//        else {
//            consolePrinter.print("Hello, world!");
//        }
    }

    public void random() {
        String helloMsg = "Hello World!";
        Integer r = new Random().nextInt(3);
        Optional.of(r).filter(v -> v.equals(0))
                .ifPresentOrElse(v -> consolePrinter.print(helloMsg),
                        () -> Optional.of(r).filter(v -> v.equals(1))
                                .ifPresentOrElse(
                                        v -> dialogPrinter.print(helloMsg),
                        () -> somePrinter.print(helloMsg)));
    }
}
