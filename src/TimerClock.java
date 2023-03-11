import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.*;
import javax.swing.plaf.metal.MetalButtonUI;

public class TimerClock implements ActionListener{
    JFrame frame = new JFrame("Timer");
    JButton startButton = new JButton("START");
    JButton resetButton = new JButton("RESET");
    JLabel timeLabel = new JLabel();
    JButton home;
    public JComboBox hourCmb,minCmb,secCmb ;
    JLabel l1,l2,l3;
    int elapsedTime = 0 ;
    int seconds =0;
    int minutes =0;
    int hours =0;
    boolean started = false;
    boolean paused = false;
    int secondInput,minuteInput,hourInput;
    public String valueMin = "00",valueHour = "00",valueSec= "00";

    String seconds_string = String.format("%02d", seconds);
    String minutes_string = String.format("%02d", minutes);
    String hours_string = String.format("%02d", hours);

    Timer timer = new Timer(1000, new ActionListener() {

        public void actionPerformed(ActionEvent e) {


            if (elapsedTime==1) {
                reset(elapsedTime);
            }

            elapsedTime= elapsedTime - 1;
            hours = (elapsedTime/3600);
            minutes = (elapsedTime/60) % 60;
            seconds = (elapsedTime) % 60;

            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            hours_string = String.format("%02d", hours);
            timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);

        }
    });
    public TimerClock(){

        ImageIcon imgIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("image\\clock.jpg")));
        frame.setIconImage(imgIcon.getImage());

        int StringHour[] = new int[24];
        String StringHour_format[] = new String[24];
        for(int i = 0 ;i<24; i++){
            StringHour[i] = i;
            StringHour_format[i]=String.format("%02d",StringHour[i]);
        }
        hourCmb = new JComboBox(StringHour_format);
        hourCmb.setBounds(25,50,60,30);
        hourCmb.setBackground(new Color(0xFFFFFF));

        hourCmb.addActionListener(new hourCmb_Action());
        frame.add(hourCmb);

        l1= new JLabel();
        l1.setText("   H");
        l1.setBounds(85,50,30,30);
        l1.setOpaque(true);
        frame.add(l1);

        int StringMin[] = new int[60];
        String StringMin_format[] = new String[60];
        for(int i = 0 ;i<60; i++){
            StringMin[i] = i;
            StringMin_format[i]=String.format("%02d",StringMin[i]);
        }
        minCmb = new JComboBox(StringMin_format);
        minCmb.setBounds(130,50,60,30);
        minCmb.setBackground(new Color(0xFFFFFF));
        minCmb.addActionListener(new minCmb_Action());
        frame.add(minCmb);

        l2= new JLabel();
        l2.setText("   M");
        l2.setBounds(190,50,30,30);
        l2.setOpaque(true);
        frame.add(l2);

        int StringSec[] = new int[60];
        String StringSec_format[] = new String[60];
        for(int i = 0 ;i<60; i++){
            StringSec[i] = i;
            StringSec_format[i]=String.format("%02d",StringSec[i]);
        }
        secCmb = new JComboBox(StringSec_format);
        secCmb.setBounds(230,50,60,30);
        secCmb.setBackground(new Color(0xFFFFFF));
        secCmb.addActionListener(new secCmb_Action());
        frame.add(secCmb);

        l3= new JLabel();
        l3.setText("  S");
        l3.setBounds(290,50,30,30);
        l3.setOpaque(true);
        frame.add(l3);

        timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
        timeLabel.setBounds(20,160,300,100);
        timeLabel.setFont(new Font("Verdana",Font.PLAIN,35));
        timeLabel.setBackground(new Color(208,208,208));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);

        startButton.setBounds(190,280,100,50);
        startButton.setFont(new Font("Verdana",Font.PLAIN,15));
        startButton.setBackground(new Color(213, 225, 238));
        startButton.setFocusable(false);
        startButton.setUI(new MetalButtonUI() {
            protected Color getDisabledTextColor() {
                return Color.black;
            }
        });

        startButton.addActionListener(this);
        if((secondInput==0&&minuteInput==0&&hourInput==0)){
            startButton.setEnabled(false);
        }

        resetButton.setBounds(50,280,100,50);
        resetButton.setFont(new Font("Verdana",Font.PLAIN,15));
        resetButton.setBackground(new Color(213, 225, 238));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        frame.add(startButton);
        frame.add(resetButton);
        frame.add(timeLabel);

        home= new Main.RoundButton("");
        home.setBounds(150,410,45,45);
        home.setBackground(new Color(0xBBBBBB));
        // home.addActionListener(this);
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                frame.setVisible(false);
                new Clock();

            }
        });
        frame.add(home);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(360,500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==startButton) {
            if(started==false) {
                started=true;
                startButton.setText("PAUSE");
                start();
            } else if (paused) {
                paused = false;
                startButton.setText("PAUSE");
                start(elapsedTime);
            } else {
                paused=true;
                startButton.setText("RESUME");
                pause();
            }

        }
        if(e.getSource()==resetButton) {
            hourCmb.setEnabled(true);
            minCmb.setEnabled(true);
            secCmb.setEnabled(true);
            started=false;
            startButton.setText("START");
            reset(elapsedTime);
        }
        if(e.getSource()==home){
            frame.setVisible(false);
            new MainInterface();
        }

    }
    public class hourCmb_Action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            valueHour = hourCmb.getSelectedItem().toString();
            hourInput = Integer.parseInt(valueHour);
            if (hourInput != 0) {
                startButton.setEnabled(true);
            }
            if(started==false)
                timeLabel.setText(valueHour + ":" + valueMin + ":" + valueSec);
        }
    }
    public class minCmb_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            valueMin = minCmb.getSelectedItem().toString();
            minuteInput =Integer.parseInt(valueMin);
            if(minuteInput!=0){
                startButton.setEnabled(true);
            }
            if(started==false)
                timeLabel.setText(valueHour + ":" + valueMin + ":" + valueSec);
        }
    }

    public class secCmb_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            valueSec = secCmb.getSelectedItem().toString();
            secondInput =Integer.parseInt(valueSec);
            if(secondInput!=0){
                startButton.setEnabled(true);
            }
            if(started==false)
                timeLabel.setText(valueHour + ":" + valueMin + ":" + valueSec);

        }
    }

    void start() {
        int ConvertToSec = secondInput + (minuteInput*60) + (hourInput*3600);
        elapsedTime = ConvertToSec + 1 ;
        timer.start();


    }
    void start(int remainTime) {
        if(remainTime>0){
            elapsedTime = remainTime;
            timer.start();
        }
    }

    void pause() {
        timer.stop();
    }

    void reset(int elapsedTime) {
        timer.stop();
        seconds =0;
        hours=0;
        minutes=0;

        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);
        timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
    }

    public static void main (String[] args)  {
        new TimerClock();
    }

}