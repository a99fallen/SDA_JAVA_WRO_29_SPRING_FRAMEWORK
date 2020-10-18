package pl.a99fallen.spring.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.a99fallen.spring.core.components.printers.Printer;
import pl.a99fallen.spring.core.warmup.HelloWorld;

@Configuration
public class WarmUpConfiguration {

    private Printer printer;

    @Bean
    public HelloWorld helloBean() {
        return new HelloWorld(printer);
    }

    @Bean
    public HelloWorld buzzBuzz() {
        return new HelloWorld(printer);
    }
}
