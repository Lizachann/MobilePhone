import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.Color;
import java.util.Objects;
import javax.swing.JFrame;


public class Clock {
    public JLabel  timeLabel, dateLabel;
    String time,date;
    public SimpleDateFormat timeFormat,dateFormat;
    public JPanel JPDate;

    public Clock() {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {

                JFrame frame = new JFrame("Clock");

                ImageIcon imgIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("image\\clock.jpg")));
                frame.setIconImage(imgIcon.getImage());

                JButton Stopwatch;
                Stopwatch = new JButton("Stopwatch");
                Stopwatch.setBounds(120,300,120,30);
                Stopwatch.setBackground(new Color(183, 204, 210));
                Stopwatch.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                        frame.setVisible(false);
                        new Stopwatch();
                    }
                });
                frame.add(Stopwatch);


                JButton TimerClock;

                TimerClock = new JButton("Timer");
                TimerClock.setBounds(120,240,120,30);
                TimerClock.setBackground(new Color(183, 204, 210));
                TimerClock.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                        frame.setVisible(false);
                        new TimerClock();
                    }
                });
                frame.add(TimerClock);

                JButton home= new Main.RoundButton("");
                home.setBounds(150,410,45,45);
                home.setBackground(new Color(0xBBBBBB));
                home.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                        frame.setVisible(false);
                        new MainInterface();

                    }
                });
                frame.add(home);

                JPDate = new JPanel(null);

                timeFormat = new SimpleDateFormat("hh:mm");
                dateFormat = new SimpleDateFormat("EEEE / dd / MMMMMM / yyyy");
                //set bounds

                //change font
                timeLabel = new JLabel();
                timeLabel.setFont(new Font("Verdana",Font.PLAIN,30));
                timeLabel.setForeground(new Color(0x000000));
                timeLabel.setOpaque(true);

                time = timeFormat.format(Calendar.getInstance().getTime());
                timeLabel.setText(time);
                timeLabel.setBounds(130,60,100,50);

                dateLabel = new JLabel();
                dateLabel.setFont(new Font("Verdana",Font.PLAIN,15));
                dateLabel.setBounds(60,100,250,50);
                dateLabel.setForeground(new Color(0x000000));
                dateLabel.setOpaque(true);

                date = dateFormat.format(Calendar.getInstance().getTime());
                dateLabel.setText(date);
                JPDate.add(dateLabel);

                //frame.setBackground(new Color(180, 255, 255));
                dateLabel.setOpaque(false);
                timeLabel.setOpaque(false);
                frame.add(timeLabel);
                frame.add(JPDate);



                Timer timer = new Timer(500, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        time = timeFormat.format(Calendar.getInstance().getTime());
                        timeLabel.setText(time);

                        date = dateFormat.format(Calendar.getInstance().getTime());
                        dateLabel.setText(date);
                    }
                });

                timer.setRepeats(true);
                timer.setCoalesce(true);
                timer.setInitialDelay(0);
                timer.start();

//                JPDate.setBackground(new Color(0xE6FFFC));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(360,500);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.setResizable(false);
            }
        });
    }
    public static void main (String[] args)  {

        new Clock();

    }
}