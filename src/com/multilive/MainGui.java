package com.multilive;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGui {

    public static int seconds = 55;
    public static int minutes = 9;
    public static String strSeconds;
    public static String strMinutes = "09";

    private JButton startButton;
    private JButton zatrzymajButton;
    private JPanel panel1;
    private JLabel timeArea;



    public MainGui(){

        zatrzymajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    timeLoop(false);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }

            }
        });
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    timeLoop(true);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        });
    }

    public void timeLoop(boolean Runs) throws InterruptedException {
        do{

            timeArea.setText(strMinutes + ":" + strSeconds);
            System.out.println(strMinutes + ":" + strSeconds);
            Thread.sleep(1000);
            updateClock();//the timing mechanism
        } while(Runs);
    }


    public void updateClock() {
        seconds++;
        if (seconds < 10)
            strSeconds = "0" + seconds;
        else if (seconds > 9) {
            strSeconds = String.valueOf(seconds);
            if (seconds == 60) {
                minutes++;
                if(minutes < 10){
                    strMinutes = "0" + String.valueOf(minutes);
                }
                else if(minutes > 9){
                    strMinutes = String.valueOf(minutes);
                }
                seconds = 0;
                strSeconds = "00";
            }
        }
    }

    public static void main(String[] args) {
        minutes = 0;
        JFrame frame = new JFrame("TEST");
        frame.setContentPane(new MainGui().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}