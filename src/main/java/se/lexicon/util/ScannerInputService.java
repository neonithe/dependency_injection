package se.lexicon.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ScannerInputService implements UserInputService {

    private final Scanner scanner;

    @Autowired
    public ScannerInputService(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getString() {
        return scanner.nextLine().trim();
    }

    @Override
    public Integer getInt() {
        boolean invalid = true;
        int number = 0;
        while(invalid){
            try{
                number = Integer.parseInt(getString().replace(',','.'));
            } catch (NumberFormatException ex){
                System.out.println("Invalid input");
            }
        }
        return number;
    }
}
