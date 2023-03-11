import javax.swing.*;
import javax.swing.plaf.metal.MetalButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class EnterPin extends JFrame{
    public JFrame frame;
    private final JLabel l1,l2;
    private final JButton button1,button2,button3,button4,button5,button6,button7,button8,button9,button0,buttonOK,buttonBack;
    int count = 0, count1=0;
    public JPasswordField pwf;
    int password = 1234;
    public EnterPin() {

        frame = new JFrame("Mobile Phone ");
        frame.setContentPane(new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("image\\lockscreenblur.jpg")))));

        ImageIcon imgIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("image\\mobile-phone.jpg")));
        frame.setIconImage(imgIcon.getImage());

        l1=new JLabel("Enter Passcode");
        l1.setFont(new Font("Book Antiqua", Font.BOLD,20));
        l1.setForeground(Color.WHITE);
        l1.setBounds(110,30,500,30);

        frame.add(l1);

        pwf = new JPasswordField();
        pwf.setBounds(130,80,100,30);
        frame.add(pwf);

        l2=new JLabel("");
        l2.setBounds(110,120,130,30);
        l2.setFont(new Font("Boulder", Font.BOLD,12));
        frame.add(l2);

        button1 = new Main.RoundButton("1");
        button1.setBackground(new Color(208,208,208));
        button1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        button1.setBorderPainted(true);
        button1.setForeground(Color.black);
        button1.setUI(new MetalButtonUI() {
            protected Color getDisabledTextColor() {
                return Color.black;
            }
        });
        button1.setBounds(60,165,60,60);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pwf.setText(pwf.getText()+1);
            }
        });
        frame.add(button1);

        button2 = new Main.RoundButton("2");
        button2.setBackground(new Color(208,208,208));
        button2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        button2.setBorderPainted(true);
        button2.setForeground(Color.black);
        button2.setUI(new MetalButtonUI() {
            protected Color getDisabledTextColor() {
                return Color.black;
            }
        });
        button2.setBounds(148,165,60,60);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pwf.setText(pwf.getText()+2);
            }
        });
        frame.add(button2);

        button3 = new Main.RoundButton("3");
        button3.setBackground(new Color(208,208,208));
        button3.setForeground(Color.black);
        button3.setUI(new MetalButtonUI() {
            protected Color getDisabledTextColor() {
                return Color.black;
            }
        });
        button3.setBounds(235,165,60,60);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pwf.setText(pwf.getText()+3);
            }
        });
        frame.add(button3);

        button4 = new Main.RoundButton("4");
        button4.setBackground(new Color(208,208,208));
        button4.setForeground(Color.black);
        button4.setUI(new MetalButtonUI() {
            protected Color getDisabledTextColor() {
                return Color.black;
            }
        });
        button4.setBounds(60,235,60,60);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pwf.setText(pwf.getText()+4);

            }
        });
        frame.add(button4);

        button5 = new Main.RoundButton("5");
        button5.setBackground(new Color(208,208,208));
        button5.setForeground(Color.black);
        button5.setUI(new MetalButtonUI() {
            protected Color getDisabledTextColor() {
                return Color.black;
            }
        });
        button5.setBounds(148,235,60,60);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pwf.setText(pwf.getText()+5);

            }
        });
        frame.add(button5);

        button6 = new Main.RoundButton("6");
        button6.setBackground(new Color(208,208,208));
        button6.setForeground(Color.black);
        button6.setUI(new MetalButtonUI() {
            protected Color getDisabledTextColor() {
                return Color.black;
            }
        });
        button6.setBounds(235,235,60,60);
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pwf.setText(pwf.getText()+6);
            }
        });
        frame.add(button6);

        button7 = new Main.RoundButton("7");
        button7.setBackground(new Color(208,208,208));
        button7.setForeground(Color.black);
        button7.setUI(new MetalButtonUI() {
            protected Color getDisabledTextColor() {
                return Color.black;
            }
        });
        button7.setBounds(60,305,60,60);
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pwf.setText(pwf.getText()+7);
            }
        });
        frame.add(button7);

        button8 = new Main.RoundButton("8");
        button8.setBackground(new Color(208,208,208));
        button8.setForeground(Color.black);
        button8.setUI(new MetalButtonUI() {
            protected Color getDisabledTextColor() {
                return Color.black;
            }
        });
        button8.setBounds(148,305,60,60);
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pwf.setText(pwf.getText()+8);
            }
        });
        frame.add(button8);

        button9 = new Main.RoundButton("9");
        button9.setBackground(new Color(208,208,208));
        button9.setForeground(Color.black);
        button9.setUI(new MetalButtonUI() {
            protected Color getDisabledTextColor() {
                return Color.black;
            }
        });
        button9.setBounds(235,305,60,60);
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pwf.setText(pwf.getText()+9);
            }
        });
        frame.add(button9);

        button0 = new Main.RoundButton("0");
        button0.setBackground(new Color(208,208,208));
        button0.setForeground(Color.black);
        button0.setUI(new MetalButtonUI() {
            protected Color getDisabledTextColor() {
                return Color.black;
            }
        });
        button0.setBounds(148,375,60,60);
        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pwf.setText(pwf.getText()+0);
            }
        });
        frame.add(button0);

        buttonOK = new Main.RoundButton("OK");
        buttonOK.setBackground(new Color(208,208,208));
        buttonOK.setForeground(Color.black);
        buttonOK.setUI(new MetalButtonUI() {
            protected Color getDisabledTextColor() {
                return Color.black;
            }
        });
        buttonOK.setBounds(235,375,60,60);
        buttonOK.setBackground(new Color(238, 231, 231));
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int getPW = Integer.parseInt(pwf.getText());
                if(getPW==password){
                    frame.dispose();
                    frame.setVisible(false);
                    new MainInterface();
                    pwf.setText(null);
                }else{
//                    l2.setOpaque(true);
                    l2.setForeground(Color.red);
//                    l2.setBackground(new Color(0x000000));
                    l2.setText("      Wrong Password");
                    count++;
                    if(count==3){
                        count1++;
                        l2.setForeground(Color.red);
                        l2.setText("   Too many attempts!");
                        new Thread (() -> {
                            try{
                                button0.setEnabled(false);
                                button1.setEnabled(false);
                                button2.setEnabled(false);
                                button3.setEnabled(false);
                                button4.setEnabled(false);
                                button5.setEnabled(false);
                                button6.setEnabled(false);
                                button7.setEnabled(false);
                                button8.setEnabled(false);
                                button9.setEnabled(false);
                                button0.setEnabled(false);
                                buttonOK.setEnabled(false);
                                buttonBack.setEnabled(false);

                                int i=5;
                                int counti=count1;
                                while (counti>1){
                                    i=i+5;
                                    counti--;
                                }
                                while (i>=0){
                                    Thread.sleep(1000);
                                    l2.setText("        Re-Enter in " + i + "s");
                                    i--;
                                }
                                l2.setText("    Re-Enter Passcode!");
                                button0.setEnabled(true);
                                button1.setEnabled(true);
                                button2.setEnabled(true);
                                button3.setEnabled(true);
                                button4.setEnabled(true);
                                button5.setEnabled(true);
                                button6.setEnabled(true);
                                button7.setEnabled(true);
                                button8.setEnabled(true);
                                button9.setEnabled(true);
                                button0.setEnabled(true);
                                buttonOK.setEnabled(true);
                                buttonBack.setEnabled(true);
                                count = 0;
                            }catch(Exception ex) {
                                ex.printStackTrace();
                            }
                        }).start();
                    }
                    pwf.setText(null);
                }
            }
        });
        frame.add(buttonOK);


        buttonBack = new Main.RoundButton("");
        ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("image\\return.png")));
        buttonBack.setIcon(img);
        buttonBack.setBackground(new Color(208, 208, 208));
        buttonBack.setForeground(Color.black);
        buttonBack.setUI(new MetalButtonUI() {
            protected Color getDisabledTextColor() {
                return Color.black;
            }
        });
        buttonBack.setBounds(60,375,60,60);
        buttonBack.setBackground(new Color(238, 231, 231));
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String backspace = null;
                if(pwf.getText().length() > 0){
                    StringBuilder strB = new StringBuilder(pwf.getText());
                    strB.deleteCharAt(pwf.getText().length() - 1);
                    backspace = String.valueOf(strB);
                    pwf.setText(backspace);
                }
            }
        });
        frame.add(buttonBack);


        frame.setSize(360,500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main (String args[]) {
        new EnterPin();
    }

}