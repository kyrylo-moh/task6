package service;

import util.Validator;

import java.io.*;

public class Service {

    private Validator validator = new Validator();

    public BufferedReader fileReader(File file) throws FileNotFoundException {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        return bufferedReader;
    }

    public String readFromFile(File file) throws IOException {
        BufferedReader bufferedReader = fileReader(file);
        String fileString = "";
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            fileString += line + " ";
        }
        return fileString;
    }

    public char[][] allTickets(File file) throws IOException {
        String[] fileString = validator.fileString(readFromFile(file));
        char[][] stringTicket = new char[fileString.length][];
        for (int i = 0; i < fileString.length; i++) {
            stringTicket[i] = fileString[i].toCharArray();
        }
        return stringTicket;
    }

    public int[][] ticketsToDigits(File file) throws IOException {
        char[][] stringTicket = allTickets(file);
        int[][] intTicket = new int[stringTicket.length][6];
        try {
            for (int i = 0; i < stringTicket.length; i++) {
                for (int j = 0; j < 6; j++) {
                    intTicket[i][j] = Integer.parseInt(String.valueOf(stringTicket[i][j]));
                }
            }
        } catch (Exception e) {
            System.out.println("Your file consist from numbers and symbols, check it please");
        }
        return intTicket;
    }

    public int getSum(int[] num, int firstValue, int secondValue) {
        int sum = 0;
        for (int i = firstValue; i <= secondValue; i++)
            sum += num[i];
        return sum;
    }

    public int mscMethod(File file) throws IOException {
        int num[][] = ticketsToDigits(file);
        int count = 0;
        for (int i = 0; i < num.length; i++) {
            if (getSum(num[i], 0, 2) == getSum(num[i], 3, 5))
                count++;
        }
        return count;
    }

    public boolean getPtr(int[] num) {
        int sumFirst = 0;
        int sumSecond = 0;
        for (int i = 0; i < 6; i++) {
            if (i % 2 == 0) {
                sumFirst += num[i];
            } else {
                sumSecond += num[i];
            }
        }
        return (sumFirst == sumSecond);
    }

    public int ptrMethod(File file) throws IOException {
        int num[][] = ticketsToDigits(file);
        int count = 0;
        for (int i = 0; i < num.length; i++){
            if (getPtr(num[i])) {
                count++;
            }
        }
        return count;
    }

}
