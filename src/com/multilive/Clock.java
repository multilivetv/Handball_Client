package com.multilive;
import java.awt.EventQueue;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Clock {

    private Timer timer = new Timer();
    private static JLabel timeLabel = new JLabel(" ", JLabel.CENTER);

    public void Clock() {
        JFrame f = new JFrame("Seconds");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(timeLabel);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        timer.schedule(new UpdateUITask(), 0, 1000);
    }

    public static class UpdateUITask extends TimerTask {

        public static int nSeconds;

        public static int nMinutes;

        @Override
        public void run() {
            EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                    timeLabel.setText(String.valueOf(nMinutes + nSeconds++));
                    if (nSeconds == 60) {
                        nMinutes++;
                        nSeconds = 0;
                    }
                }
            });
        }
    }

}