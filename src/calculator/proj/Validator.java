package calculator.proj;

import java.util.stream.Stream;

public class Validator {

    public boolean isFirstSymbolOperator(String[] inputText) {
        if (Calculator.operations.containsKey(inputText[0])) {
            System.out.println("Первый символ выражения это операция, повторите ввод.");
            return true;
        }
        return false;
    }

    public boolean isLastSymbolOperator(String[] inputText) {
        if (Calculator.operations.containsKey(inputText[inputText.length - 1])) {
            System.out.println("Последний символ выражения это операция, повторите ввод.");
            return true;
        }
        return false;
    }

    public boolean isContainingDivisionByZero(String[] inputText) {
        int index = 0;
        for (int i = 0; i < inputText.length - 1; i++) {
            if (inputText[i].equals("/")) {
                index = i;
                break;
            }
        }
        if (index != 0) {
            if (inputText[index + 1].equals("0") && (index + 1 == inputText.length - 1)) {
                System.out.println("Обнаружено деление на ноль, повторите ввод.");
                return true;
            } else return inputText[index + 1].equals("0") && !inputText[index + 2].equals(".");
        }
        return false;
    }

    public boolean isTwoMathOperations(String[] inputText) {
        boolean flag = false;
        for (String c : inputText) {
            if (Calculator.operations.containsKey(c)) {
                if (flag) {
                    System.out.println("Обнаружены две математические операции подряд, повторите ввод.");
                    return true;
                } else {
                    flag = true;
                }
            } else {
                flag = false;
            }
        }
        return false;
    }

    public boolean isContainingIncorrectSymbols(String inputText) {
        Stream<String> stringStream = Stream.of(inputText.split("(\\+|-|/|\\*|\\d|\\.)+"));
        return stringStream.count() > 0;
    }
}
