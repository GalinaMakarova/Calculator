package calculator.proj;

import java.util.*;

public class Calculator {

    static Map<String, Integer> operations = new HashMap<>();

    static {
        operations.put("+", 1);
        operations.put("-", 1);
        operations.put("/", 2);
        operations.put("*", 2);
    }

    double plus(double a, double b) {
        return a + b;
    }

    double minus(double a, double b) {
        return a - b;
    }

    double multiplication(double a, double b) {
        return a * b;
    }

    double division(double a, double b) {
        return a / b;
    }

    double calculation(String[] inputTextArr) {
        String[] inputText = Arrays.copyOf(inputTextArr, inputTextArr.length);
        double a;
        double b;
        for (int i = 0; i < inputText.length; i++) {
            if (Calculator.operations.containsKey(inputText[i])) {
                if (inputText[i - 2].equals("")) {
                    String bufA = inputText[i - 2];
                    int j = i - 2;
                    while (bufA.equals("")) {
                        j--;
                        bufA = inputText[j];
                    }
                    a = Double.parseDouble(bufA);
                } else {
                    a = Double.parseDouble(inputText[i - 2]);
                }
                b = Double.parseDouble(inputText[i - 1]);
                switch (inputText[i]) {
                    case "+":
                        b = plus(a, b);
                        break;
                    case "-":
                        b = minus(a, b);
                        break;
                    case "*":
                        b = multiplication(a, b);
                        break;
                    case "/":
                        b = division(a, b);
                        break;
                }
                if (b % 1 == 0) {
                    int bInt = (int) b;
                    inputText[i] = String.valueOf(bInt);
                } else {
                    inputText[i] = String.valueOf(b);
                }
                inputText[i - 2] = "";
                inputText[i - 1] = "";
            }
        }
        return Double.parseDouble(inputText[inputText.length - 1]);
    }
}
