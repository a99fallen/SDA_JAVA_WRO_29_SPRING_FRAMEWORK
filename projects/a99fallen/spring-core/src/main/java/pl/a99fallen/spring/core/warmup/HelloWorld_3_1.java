package pl.a99fallen.spring.core.warmup;

import org.springframework.stereotype.Component;
import pl.a99fallen.spring.core.components.printers.ConsolePrinter;
import pl.a99fallen.spring.core.components.printers.DialogPrinter;
import pl.a99fallen.spring.core.components.printers.FilePrinter;
import pl.a99fallen.spring.core.components.printers.Printer;

@Component
public class HelloWorld_3_1 {

    private Printer printer;

    public HelloWorld_3_1(Printer printer) {
        this.printer = printer;
    }

    public void setPrinter (Printer printer) {
        this.printer = printer;
    }

   public void sayHello() {
        printer.print("Hello World!");
   }

    public static void main(String[] args) {
        HelloWorld_3_1 consoleHelloWorld = new HelloWorld_3_1(new ConsolePrinter());
        consoleHelloWorld.sayHello();

        HelloWorld_3_1 dialogHelloWorld = new HelloWorld_3_1(new DialogPrinter());
        dialogHelloWorld.sayHello();

        HelloWorld_3_1 fileHelloWorld = new HelloWorld_3_1(new FilePrinter());
        fileHelloWorld.sayHello();
    }
}
