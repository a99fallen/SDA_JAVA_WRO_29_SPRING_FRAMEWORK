package pl.a99fallen.spring.core.warmup;

import org.springframework.stereotype.Component;
import pl.a99fallen.spring.core.components.printers.ConsolePrinter;
import pl.a99fallen.spring.core.components.printers.DialogPrinter;
import pl.a99fallen.spring.core.components.printers.FilePrinter;
import pl.a99fallen.spring.core.components.printers.Printer;

@Component
public class HelloWorld {

    private Printer printer;

    public HelloWorld (Printer printer) {
        this.printer = printer;
    }

    public void setPrinter (Printer printer) {
        this.printer = printer;
    }

   public void sayHello() {
        printer.print("Hello World!");
   }

    public static void main(String[] args) {
        HelloWorld consoleHelloWorld = new HelloWorld(new ConsolePrinter());
        consoleHelloWorld.sayHello();

        HelloWorld dialogHelloWorld = new HelloWorld(new DialogPrinter());
        dialogHelloWorld.sayHello();

        HelloWorld fileHelloWorld = new HelloWorld(new FilePrinter());
        fileHelloWorld.sayHello();
    }
}
