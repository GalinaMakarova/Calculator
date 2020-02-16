package calculator.proj;

public class Main {

    public static void main(String[] args) {
        String inputText = "";
        String[] inputTextArr = new String[]{};

        Validator validator = new Validator();
        Console console = new Console();
        Parser parser = new Parser();
        Calculator calculator = new Calculator();

        while (validator.isContainingIncorrectSymbols(inputText) ||
                validator.isFirstSymbolOperator(inputTextArr) ||
                validator.isLastSymbolOperator(inputTextArr) ||
                validator.isTwoMathOperations(inputTextArr) ||
                validator.isContainingDivisionByZero(inputTextArr)) {
            inputText = console.inputText();
            if (!validator.isContainingIncorrectSymbols(inputText)) {
                inputTextArr = console.doubleChecking(inputText);
            }
        }
        String[] outputTextArr = parser.polishParsing(inputTextArr);
        System.out.println("Результат вычислений = " + String.format("%.2f", calculator.calculation(outputTextArr)).replace(',', '.'));
    }
}
