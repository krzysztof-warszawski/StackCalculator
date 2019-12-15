package com.kavit;

import javax.swing.*;

public class NewCalcJFrame  extends JFrame {
    public NewCalcJFrame() {
        setSize(500,525);
        setTitle("Calculator");
        setResizable(false);

        NewCalcJPanel newCalcJPanel = new NewCalcJPanel();
        add(newCalcJPanel);
    }
}

