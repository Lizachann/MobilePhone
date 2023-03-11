import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;


public class LockScreen {
    public JLabel  timeLabel, dateLabel,l1;
    String time,date;
    public SimpleDateFormat timeFormat,dateFormat;
    public LockScreen() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                JFrame frame = new JFrame("Galaxy 1280 Pro-Max");

                frame.setContentPane(new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("image\\lockscreen.jpg")))));

                ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("image\\mobile-phone.jpg")));
                frame.setIconImage(img.getImage());

                timeFormat = new SimpleDateFormat("hh:mm");
                dateFormat = new SimpleDateFormat("EEEE, dd MMMM");


                timeLabel = new JLabel();
                timeLabel.setFont(new Font("Verdana",Font.PLAIN,30));
                timeLabel.setForeground(Color.white);
                timeLabel.setOpaque(true);

                time = timeFormat.format(Calendar.getInstance().getTime());
                timeLabel.setText(time);
                timeLabel.setBounds(130,60,150,50);

                dateLabel = new JLabel();
                dateLabel.setFont(new Font("Verdana",Font.PLAIN,15));
                dateLabel.setBounds(100,100,200,50);
                dateLabel.setForeground(Color.white);
                dateLabel.setOpaque(true);

                date = dateFormat.format(Calendar.getInstance().getTime());
                dateLabel.setText(date);

                timeLabel.setOpaque(false);
                dateLabel.setOpaque(false);

                frame.add(timeLabel);
                frame.add(dateLabel);

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



                JButton home= new JButton();
                home.setOpaque(false);
                home.setContentAreaFilled(false);
                home.setBorderPainted(false);
                home.setBounds(0,0,360,500);
                home.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                        frame.setVisible(false);
                        new EnterPin();

                    }
                });
                frame.add(home);

                l1 = new JLabel("Powered by RonteasBanh ");
                l1.setFont(new Font("Verdana",Font.BOLD,15));
                l1.setBounds(60,400,250,50);
                l1.setForeground(new Color(0xFF0000));
                frame.add(l1);

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(360,500);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.setResizable(false);
            }
        });
    }
    public static void main (String[] args)  {
        new LockScreen();

    }
}