package calculator;

public class MainCalc {
    public static void main(String[] args) {

        Calculator calc = new Calculator();
        calc.add(2,3);
        calc.add(2,11);
        calc.add(2,11);
        calc.add(2,11);
//        calc.printOperations();
        calc.returnListOfOperations();

        Calculator calculator = new Calculator();
        calculator.divide(8,12);
        calculator.printOperations();
    }
}
