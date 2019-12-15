package com.kavit;

import java.util.LinkedList;

public class NewCalc {

    private double finalResult;
    private LinkedList<Integer> stackOperations = new LinkedList<>();
    private LinkedList<Double> stackNumbers = new LinkedList<>();

    // push operation on the stack
    private void pushOperation(int methodNumber) {
        if (stackOperations.peek() == null) {
            stackOperations.push(methodNumber);
        } else if (stackOperations.peek() > 2) {
            if (stackOperations.peek() == 3) {
                multiply();
            } else {
                divide();
            }
            stackOperations.pop();
            pushOperation(methodNumber);
        } else if (stackOperations.peek() < 3 && methodNumber < 3) {
            if (stackOperations.peek() == 1) {
                add();
            } else {
                subtract();
            }
            stackOperations.pop();
            stackOperations.push(methodNumber);
        } else if (methodNumber > 2) {
            stackOperations.push(methodNumber);
        }
    }

    // push number on the stack
    private void pushNumbers(double d) {
        stackNumbers.push(d);
    }

    // reset the calculation
    public void reset() {
        stackNumbers.removeAll(stackNumbers);
        stackOperations.removeAll(stackOperations);
    }

    private void add() {
        double a = stackNumbers.peek();
        stackNumbers.pop();
        double b = stackNumbers.peek();
        stackNumbers.pop();
        stackNumbers.push(a + b);
    }

    private void subtract() {
        double b = stackNumbers.peek();
        stackNumbers.pop();
        double a = stackNumbers.peek();
        stackNumbers.pop();
        stackNumbers.push(a - b);
    }

    private void multiply() {
        double a = stackNumbers.peek();
        stackNumbers.pop();
        double b = stackNumbers.peek();
        stackNumbers.pop();
        stackNumbers.push(a * b);
    }

    private void divide() {
        double b = stackNumbers.peek();
        stackNumbers.pop();
        double a = stackNumbers.peek();
        stackNumbers.pop();
        stackNumbers.push(a / b);
    }

    // reduce brackets and simplify the calculation
    public String simplifyCalculation(String str) {
        int start = str.lastIndexOf('(');
        if (start < 0) {
            str = str.replace("+-", "-");
            str = str.replace("--", "+");
            return doTheMath(str);
        } else {
            int end = str.indexOf(')', str.lastIndexOf('(')) + 1;
            String subStr = str.substring(start, end);
            str = str.replace(subStr, doTheMath(subStr));
            return simplifyCalculation(str);
        }
    }

    public String doTheMath(String s) {
        double number = 0;
        int sign = 1;
        StringBuilder comma = new StringBuilder("0.");
        boolean commaFlag = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                if (!commaFlag) {
                    number = number * 10 + (c - 48);
                } else {
                    comma.append(c);
                }
            } else if (c == '.') {
                commaFlag = true;
            } else if (c == '*') {
                number += Double.parseDouble(comma.toString());
                pushNumbers(number * sign);
                sign = 1;
                number = 0;
                comma = new StringBuilder("0.");
                commaFlag = false;
                pushOperation(3);
                if (s.charAt(i + 1) == '-') {
                    sign = -1;
                    i += 1;
                }
            } else if (c == '/') {
                number += Double.parseDouble(comma.toString());
                pushNumbers(number);
                number = 0;
                comma = new StringBuilder("0.");
                commaFlag = false;
                pushOperation(4);
                if (s.charAt(i + 1) == '-') {
                    sign = -1;
                    i += 1;
                }
            } else if (c == '+') {
                number += Double.parseDouble(comma.toString());
                pushNumbers(number);
                number = 0;
                comma = new StringBuilder("0.");
                commaFlag = false;
                pushOperation(1);
            } else if (c == '-') {
                number += Double.parseDouble(comma.toString());
                pushNumbers(number);
                number = 0;
                comma = new StringBuilder("0.");
                commaFlag = false;
                pushOperation(2);
            }
        }
        number += Double.parseDouble(comma.toString());
        pushNumbers(number * sign);
        finalProduct();
        return Double.toString(getOperationResult());
    }

    private void finalProduct() {
        while (!stackOperations.isEmpty()) {
            if (stackOperations.peek() > 2) {
                if (stackOperations.peek() == 3) {
                    multiply();
                } else {
                    divide();
                }
            } else if (stackOperations.peek() < 3) {
                if (stackOperations.peek() == 1) {
                    add();
                } else {
                    subtract();
                }
            }
            stackOperations.pop();
        }
        setOperationResult(stackNumbers.peek());
    }

    public double getOperationResult() {
        return finalResult;
    }

    public void setOperationResult(double finalResult) {
        this.finalResult = finalResult;
    }
}
