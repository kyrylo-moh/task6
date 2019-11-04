package util;

import java.util.Scanner;

public class Input {

    private Scanner scanner = new Scanner(System.in);

    public String getAnswer() {
        return scanner.nextLine();
    }

}
