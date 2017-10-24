package com.company;


import javax.swing.*;
import java.awt.event.ActionEvent;

public class Greeter {
    public static void main(String[] args) {
        TimedGreeter timedGreeter = new TimedGreeter();
        timedGreeter.greet();
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }

    public void greet() {
        System.out.println("Hello, world!");
    }

    public void greet(ActionEvent actionEvent) {
        System.out.println("Hello, world!");
    }
}

class TimedGreeter extends Greeter {
    public void greet() {
        Timer t = new Timer(1000, super::greet);
        t.start();
    }

}


