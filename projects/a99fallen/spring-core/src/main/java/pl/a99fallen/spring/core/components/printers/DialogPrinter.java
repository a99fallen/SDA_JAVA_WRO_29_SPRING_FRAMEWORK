package pl.a99fallen.spring.core.components.printers;

import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class DialogPrinter implements Printer {
    @Override
    public void print(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
