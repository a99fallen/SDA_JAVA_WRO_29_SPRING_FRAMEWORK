package pl.a99fallen.spring.core.components.printers;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.a99fallen.spring.core.qualifiers.Console;

@Console
@Component @Primary
public class ConsolePrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
