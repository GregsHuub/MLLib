package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    private String[] history;
    private List<String> listaOperacji;
    public Calculator() {
        history = new String[0];
        listaOperacji = new ArrayList<>();
    }
    public void returnListOfOperations(){
        listaOperacji.forEach(System.out::println);
    }

    public int add(int num1, int num2) {
        int value = num1 + num2;
        String addingOperation = String.format("added %s to %s got %s", num1, num2, value);
        listaOperacji.add(addingOperation);
        addOperations(addingOperation);
        return value;
    }

    public int substract(int num1, int num2) {
        int value = num1 - num2;
        String subOperation = String.format("substracted %s from %s got %s", num1, num2, value);
        listaOperacji.add(subOperation);
        addOperations(subOperation);
        return value;
    }

    public int multiply(int num1, int num2) {
        int value = num1 * num2;
        String multOperation = String.format("multiplied %s with %s got %s", num1, num2, value);
        addOperations(multOperation);
        return value;
    }

    public double divide(double num1, double num2) {
        double value = num1 / num2;
        String divideOperation = String.format("divided %s from %s got %s", num1, num2, value);
        addOperations(divideOperation);
        return value;
    }


    public void printOperations() {
        for (int i = 0; i < history.length; i++) {
            System.out.println(history[i]);
        }
    }

    public void clearOperations() {
        //do istniejacej tablicy przypisuje na nowo 0, zeby wyczyscic
        history = new String[0];
        System.out.println("History operation is clear");
    }

    public void addOperations(String operation) {
        history = Arrays.copyOf(history, history.length + 1);
        history[history.length - 1] = operation;
    }
}
