import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.*;

public class Stopwatch implements ActionListener{
    JFrame frame = new JFrame("Stop Watch");
    JButton startButton = new JButton("START");
    JButton resetButton = new JButton("RESET");
    JLabel timeLabel = new JLabel();
    int elapsedTime = 0;
    int seconds =0, miliSeconds=0;
    int minutes =0;
    int hours =0;
    boolean started = false;
    String miliSeconds_string = String.format("%02d",miliSeconds);
    String seconds_string = String.format("%02d", seconds);
    String minutes_string = String.format("%02d", minutes);
    String hours_string = String.format("%02d", hours);

    Timer timer = new Timer(10, new ActionListener() {

        public void actionPerformed(ActionEvent e) {

            elapsedTime=elapsedTime+1000;
            hours = (elapsedTime/216000000);
            minutes = (elapsedTime/3600000) % 60;
            seconds = (elapsedTime/60000) % 60;
            miliSeconds = (elapsedTime/1000)%60;

            miliSeconds_string = String.format("%02d",miliSeconds);
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            hours_string = String.format("%02d", hours);
            timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string+":"+miliSeconds_string);

        }

    });


    public Stopwatch(){

        ImageIcon imgIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("image\\clock.jpg")));
        frame.setIconImage(imgIcon.getImage());

        timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string+":"+miliSeconds_string);
        timeLabel.setBounds(25,120,300,100);
        timeLabel.setFont(new Font("Verdana",Font.PLAIN,35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setBackground(new Color(208,208,208));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);

        startButton.setBounds(190,250,100,50);
        startButton.setFont(new Font("Verdana",Font.PLAIN,15));
        startButton.setBackground(new Color(213, 225, 238));
        startButton.setFocusable(false);
        startButton.addActionListener(this);

        resetButton.setBounds(50,250,100,50);
        resetButton.setFont(new Font("Verdana",Font.PLAIN,15));
        resetButton.setBackground(new Color(213, 225, 238));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        frame.add(startButton);
        frame.add(resetButton);
        frame.add(timeLabel);


        JButton home= new Main.RoundButton("");
        home.setBounds(150,410,45,45);
        home.setBackground(new Color(0xBBBBBB));
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                frame.setVisible(false);
                new Clock();
            }
        });

        frame.add(home);

        frame.setBackground(new Color(0xE6FFFC));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(360,500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==startButton) {

            if(started==false) {
                started=true;
                startButton.setText("STOP");
                start();
            }
            else {
                started=false;
                startButton.setText("START");
                stop();
            }

        }
        if(e.getSource()==resetButton) {
            started=false;
            startButton.setText("START");
            reset();
        }

    }

    void start() {
        timer.start();
    }

    void stop() {
        timer.stop();
    }

    void reset() {
        timer.stop();
        elapsedTime=0;
        seconds =0;
        miliSeconds=0;
        hours=0;
        minutes=0;
        miliSeconds_string=String.format("%02d",miliSeconds);
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);
        timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string+":"+miliSeconds_string);
    }

    public static void main (String[] args)  {
        new Stopwatch();
    }

}