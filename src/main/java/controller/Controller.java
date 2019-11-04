package controller;

import model.ModelTicket;
import service.Service;
import util.Input;
import util.Output;
import util.Validator;

import java.io.File;
import java.io.IOException;

public class Controller {

    private Service service = new Service();
    private Validator validator = new Validator();
    private Input input = new Input();
    private Output output = new Output();
    private ModelTicket modelTicket;

    public File setFile() {
        File file = new File(input.getAnswer());
        //File file = new File("D://task6.txt");
        return file;
    }

    public void run() throws IOException {
        output.printFileInstruction();
        modelTicket = new ModelTicket(setFile());
        if (validator.isFileExist(modelTicket.getFile())) {
            if (validator.isEmptyFile(modelTicket.getFile())) {
                choice();
            } else {
                output.printFileEmpty();
            }
        } else {
                output.printFileExist();
            }
    }

    public void runMsc() throws IOException {
        output.countTickets(service.mscMethod(modelTicket.getFile()), "MOSCOW");
    }

    public void runPtr() throws IOException {
        output.countTickets(service.ptrMethod(modelTicket.getFile()), "PETER");
    }

    public int choiceMethod() {
        output.printInstruction();
        String answer = input.getAnswer();
        if (answer.equalsIgnoreCase("moscow")) {
            return 1;
        } else
            if (answer.equalsIgnoreCase("peter")) {
            return 2;
        }
            else
            return 1;
    }

    public void choice() throws IOException {

        int point = choiceMethod();

        switch (point) {
            case 1:
                runMsc();
                break;
            case 2:
                runPtr();
                break;
            default:
                output.printDefault();
                runMsc();
        }

    }

    public void runController() throws IOException {
        String answer;
        do {
            run();
            output.printQuestion();
            answer = input.getAnswer();
        } while (answer.equalsIgnoreCase("y") ||
                answer.equalsIgnoreCase("yes"));
    }

}
