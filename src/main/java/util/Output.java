package util;

public class Output {

    public void printQuestion() {
        System.out.println("\"Do you want to continue?\\t [y/n]\"");
    }

    public void printInstruction() {
        System.out.println("Please, select method [Moscow/ Peter]");
    }

    public void printDefault() {
        System.out.println("Your answer is wrong, in default choice Moscow method");
    }

    public void countTickets(int count, String nameMethod) {
        System.out.println("\tCount: " + count + "\t method [" + nameMethod + "]");
    }

    public void printFileInstruction() {
        System.out.println("Please enter path to file");
    }

    public void printFileEmpty() {
        System.out.println("File which you enter is empty");
    }

    public void printFileExist() {
        System.out.println("File which you enter is not exist");
    }

}
