package pl.a99fallen.spring.core.components.printers;

import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class FilePrinter implements Printer {
    @Override
    public void print(String message) {
        String userHomePath = System.getProperty("user.home");
        Path outputPath = Paths.get(userHomePath, "out.log");
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(outputPath.toFile(), true))) {
            printWriter.println(message);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
