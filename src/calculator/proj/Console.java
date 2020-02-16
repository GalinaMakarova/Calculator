package calculator.proj;

import java.io.*;
import java.util.*;

public class Console {

    public String inputText() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Пожалуйста, введите математическое выражение");
        System.out.println("Допускаются только дробные числа с разделителем . и математические операции: " + Calculator.operations.keySet());
        String inputString = "";
        try {
            inputString = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (inputString.length() != 0) {
            return inputString;
        } else {
            return "";
        }
    }

    String[] doubleChecking(String inputString) {
        char[] inputText = inputString.toCharArray();
        List<String> outputText = new ArrayList<>();
        String bufString = "";
        for (int i = 0; i < inputText.length; i++) {
            if (Calculator.operations.containsKey(String.valueOf(inputText[i]))) {
                if (bufString.length() > 0) {
                    double bufDouble = Double.parseDouble(bufString);
                    if (bufDouble % 1 == 0) {
                        int bufInt = (int) (bufDouble);
                        outputText.add(String.valueOf(bufInt));
                    } else {
                        outputText.add(String.valueOf(bufDouble));
                    }
                    bufString = "";
                }
                outputText.add(String.valueOf(inputText[i]));
            } else {
                if (i == inputText.length - 1) {
                    bufString = bufString + inputText[i];
                    double bufDouble = Double.parseDouble(bufString);
                    if (bufDouble % 1 == 0) {
                        int bufInt = (int) (bufDouble);
                        outputText.add(String.valueOf(bufInt));
                    } else {
                        outputText.add(String.valueOf(bufDouble));
                    }
                    bufString = "";
                } else {
                    bufString = bufString + inputText[i];
                }
            }
        }

        if (bufString.length() > 0) {
            Double bufDouble = Double.parseDouble(bufString);
            outputText.add(String.valueOf(bufDouble));
        }

        return outputText.toArray(new String[0]);
    }
}
