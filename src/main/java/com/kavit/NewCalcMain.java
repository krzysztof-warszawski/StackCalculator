package com.kavit;

import javax.swing.*;
import java.awt.*;

public class NewCalcMain {

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            NewCalcJFrame newCalcJFrame = new NewCalcJFrame();
            newCalcJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            newCalcJFrame.setVisible(true);
        });
    }
}