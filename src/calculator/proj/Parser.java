package calculator.proj;

import java.util.*;

public class Parser {

    private List<String> outputText = new ArrayList<>();
    private Stack<String> mathStack = new Stack<>();

    public String[] polishParsing(String[] inputText) {
        for (int i = 0; i < inputText.length; i++) {
            if (Calculator.operations.containsKey(inputText[i])) {
                if (mathStack.size() > 0) {
                    if (Calculator.operations.get(inputText[i]) <= Calculator.operations.get(mathStack.peek())) {
                        if (Calculator.operations.get(mathStack.peek()).equals(Calculator.operations.get(inputText[i]))) {
                            outputText.add(mathStack.pop());
                        } else {
                            for (int j = 0; j < mathStack.size(); j = 0) {
                                outputText.add(mathStack.pop());
                            }
                        }
                    }
                }
                mathStack.push(inputText[i]);
            } else {
                outputText.add(inputText[i]);
            }
        }
        if (mathStack.size() > 0) {
            for (int j = 0; j < mathStack.size(); j = 0)
                outputText.add(mathStack.pop());
        }
        return outputText.toArray(new String[0]);
    }
}
