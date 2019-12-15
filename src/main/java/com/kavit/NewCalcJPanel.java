package com.kavit;

import javax.swing.*;

public class NewCalcJPanel extends JPanel {

    private NewCalc calc = new NewCalc();
    private JTextField display, displayAll;
    private JButton one, two, three, four, five, six, seven, eight, nine, zero,
            divide, multiply, add, subtract, comma, result, resetAll, leftBracket, rightBracket;

    private StringBuilder stringBuilder = new StringBuilder();

    public NewCalcJPanel() {
        setLayout(null);

        display = new JTextField();
        display.setBounds(0,0,500,50);
        display.setText("0");

        displayAll = new JTextField();
        displayAll.setBounds(0,50,500,50);

        comma = new JButton(".");
        comma.setBounds(100,400,100,100);
        comma.addActionListener(e -> {
            stringBuilder.append(".");
            displayAll();
        });

        add = new JButton("+");
        add.setBounds(300,100,100,100);
        add.addActionListener(e -> {
            stringBuilder.append("+");
            displayAll();
        });

        subtract = new JButton("-");
        subtract.setBounds(300,200,100,100);
        subtract.addActionListener(e -> {
            stringBuilder.append("-");
            displayAll();
        });

        multiply = new JButton("*");
        multiply.setBounds(300,300,100,100);
        multiply.addActionListener(e -> {
            stringBuilder.append("*");
            displayAll();
        });

        divide = new JButton("/");
        divide.setBounds(200,400,100,100);
        divide.addActionListener(e -> {
            stringBuilder.append("/");
            displayAll();
        });

        result = new JButton("=");
        result.setBounds(300,400,100,100);
        result.addActionListener(e -> {
            stringBuilder.append("=");
            calc.simplifyCalculation(stringBuilder.toString());
            display.setText(stringBuilder.toString());
            stringBuilder.delete(0,stringBuilder.length());
            stringBuilder.append(calc.getOperationResult());
            displayAll();
        });

        leftBracket = new JButton("(");
        leftBracket.setBounds(400,100,100,100);
        leftBracket.addActionListener(e -> {
            stringBuilder.append("(");
            displayAll();
        });

        rightBracket = new JButton(")");
        rightBracket.setBounds(400,200,100,100);
        rightBracket.addActionListener(e -> {
            stringBuilder.append(")");
            displayAll();
        });

        zero = new JButton("0");
        zero.setBounds(0,400,100,100);
        zero.addActionListener(e -> {
            stringBuilder.append("0");
            displayAll();
        });

        one = new JButton("1");
        one.setBounds(0,300,100,100);
        one.addActionListener(e -> {
            stringBuilder.append("1");
            displayAll();
        });

        two = new JButton("2");
        two.setBounds(100,300,100,100);
        two.addActionListener(e -> {
            stringBuilder.append("2");
            displayAll();
        });

        three = new JButton("3");
        three.setBounds(200,300,100,100);
        three.addActionListener(e -> {
            stringBuilder.append("3");
            displayAll();
        });

        four = new JButton("4");
        four.setBounds(0,200,100,100);
        four.addActionListener(e -> {
            stringBuilder.append("4");
            displayAll();
        });

        five = new JButton("5");
        five.setBounds(100,200,100,100);
        five.addActionListener(e -> {
            stringBuilder.append("5");
            displayAll();
        });

        six = new JButton("6");
        six.setBounds(200,200,100,100);
        six.addActionListener(e -> {
            stringBuilder.append("6");
            displayAll();
        });

        seven = new JButton("7");
        seven.setBounds(0,100,100,100);
        seven.addActionListener(e -> {
            stringBuilder.append("7");
            displayAll();
        });

        eight = new JButton("8");
        eight.setBounds(100,100,100,100);
        eight.addActionListener(e -> {
            stringBuilder.append("8");
            displayAll();
        });

        nine = new JButton("9");
        nine.setBounds(200,100,100,100);
        nine.addActionListener(e -> {
            stringBuilder.append("9");
            displayAll();
        });

        resetAll = new JButton("AC");
        resetAll.setBounds(400,300,100,200);
        resetAll.addActionListener(e -> {
            stringBuilder.delete(0,stringBuilder.length());
            calc.reset();
            displayAll();
            display.setText("0");
        });

        add(display);
        add(displayAll);
        add(add);
        add(divide);
        add(subtract);
        add(result);
        add(comma);
        add(multiply);
        add(resetAll);
        add(leftBracket);
        add(rightBracket);
        add(zero);
        add(one);
        add(two);
        add(three);
        add(four);
        add(five);
        add(six);
        add(seven);
        add(eight);
        add(nine);
    }

    public void displayAll(){
        displayAll.setText(stringBuilder.toString());
    }
}
