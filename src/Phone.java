import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class Phone extends JFrame{
    public JFrame frame;
//    private final JLabel l1;
    private final JButton home,button1,button2,button3,button4,button5,button6,button7,button8,button9,button0,buttonAdd,buttonBack
        ,buttonStar,buttonHastag,buttonCall;
//    Image img = Toolkit.getDefaultToolkit().getImage("1.bmp");
public static JTextField phoneNum;
    public Phone(){
        frame = new JFrame("Phone");


//////////////how to input image from file
//        try{
//            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Lesson\\Term 4\\OOP\\final project\\Test\\src\\image\\lockscreen.jpg")))));
//        }catch(IOException e) {
//            e.printStackTrace();
//        }

//////////////how to input image from get resource
//        frame.setContentPane(new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("image\\lockscreen.jpg")))));

        ImageIcon imgIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("image\\phone.jpg")));
        frame.setIconImage(imgIcon.getImage());


        phoneNum = new JTextField();
        phoneNum.setFont(new Font("Times New Roman", Font.BOLD,30));
        phoneNum.setHorizontalAlignment(SwingConstants.RIGHT);
        phoneNum.setBounds(10,10,330,60);
        phoneNum.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();  // if it's not a number, ignore the event
                }
            }
        });
        frame.add(phoneNum);

        button1 = new Main.RoundButton("1");
        button1.setFont(new Font("Times New Roman", Font.BOLD,20));
        button1.setBounds(60,80,55,55);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                phoneNum.setText(phoneNum.getText()+"1");
            }
        });
        frame.add(button1);

        button2 = new Main.RoundButton("2");
        button2.setFont(new Font("Times New Roman", Font.BOLD,20));
        button2.setBounds(150,80,55,55);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                phoneNum.setText(phoneNum.getText()+"2");
//                System.out.println(phoneNum);
            }
        });
        frame.add(button2);

        button3 = new Main.RoundButton("3");
        button3.setFont(new Font("Times New Roman", Font.BOLD,20));
        button3.setBounds(235,80,55,55);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                phoneNum.setText(phoneNum.getText()+"3");
            }
        });
        frame.add(button3);

        button4 = new Main.RoundButton("4");
        button4.setFont(new Font("Times New Roman", Font.BOLD,20));
        button4.setBounds(60,145,55,55);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                phoneNum.setText(phoneNum.getText()+"4");

            }
        });
        frame.add(button4);

        button5 = new Main.RoundButton("5");
        button5.setFont(new Font("Times New Roman", Font.BOLD,20));
        button5.setBounds(150,145,55,55);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                phoneNum.setText(phoneNum.getText()+"5");

            }
        });
        frame.add(button5);

        button6 = new Main.RoundButton("6");
        button6.setFont(new Font("Times New Roman", Font.BOLD,20));
        button6.setBounds(235,145,55,55);
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                phoneNum.setText(phoneNum.getText()+"6");
            }
        });
        frame.add(button6);

        button7 = new Main.RoundButton("7");
        button7.setFont(new Font("Times New Roman", Font.BOLD,20));
        button7.setBounds(60,210,55,55);
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                phoneNum.setText(phoneNum.getText()+"7");
            }
        });
        frame.add(button7);

        button8 = new Main.RoundButton("8");
        button8.setFont(new Font("Times New Roman", Font.BOLD,20));
        button8.setBounds(150,210,55,55);
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                phoneNum.setText(phoneNum.getText()+"8");
            }
        });
        frame.add(button8);

        button9 = new Main.RoundButton("9");
        button9.setFont(new Font("Times New Roman", Font.BOLD,20));
        button9.setBounds(235,210,55,55);
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                phoneNum.setText(phoneNum.getText()+"9");

            }
        });
        frame.add(button9);

        button0 = new Main.RoundButton("0");
        button0.setFont(new Font("Times New Roman", Font.BOLD,20));
        button0.setBounds(150,275,55,55);
        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                phoneNum.setText(phoneNum.getText()+"0");
            }
        });
        frame.add(button0);

        buttonStar = new Main.RoundButton("*");
        buttonStar.setFont(new Font("Times New Roman", Font.BOLD,20));
        buttonStar.setBackground(new Color(224, 227, 224));
        buttonStar.setBounds(60,275,55,55);
        buttonStar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                phoneNum.setText(phoneNum.getText()+"*");
            }
        });
        frame.add(buttonStar);

        buttonHastag = new Main.RoundButton("#");
        buttonHastag.setFont(new Font("Times New Roman", Font.BOLD,20));
        buttonHastag.setBackground(new Color(224, 227, 224));
        buttonHastag.setBounds(235,275,55,55);
        buttonHastag.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                phoneNum.setText(phoneNum.getText()+"#");
            }
        });
        frame.add(buttonHastag);

        buttonAdd = new Main.RoundButton("+");
        buttonAdd.setFont(new Font("Times New Roman", Font.BOLD,20));
        buttonAdd.setBackground(new Color(224, 227, 224));
        buttonAdd.setBounds(235,340,55,55);
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                frame.setVisible(false);
                new AddContactFromPhone();
            }
        });
        frame.add(buttonAdd);

        buttonCall = new Main.RoundButton("");
        buttonCall.setFont(new Font("Times New Roman", Font.BOLD,20));
        buttonCall.setBackground(new Color(101, 196, 69));
        buttonCall.setBounds(150,340,55,55);
        ImageIcon img1 = new ImageIcon(Objects.requireNonNull(getClass().getResource("image\\call.png")));
        buttonCall.setIcon(img1);
        buttonCall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame,"NO SIM");
            }
        });
        frame.add(buttonCall);

        buttonBack = new Main.RoundButton("");
        buttonBack.setFont(new Font("Times New Roman", Font.BOLD,20));
        buttonBack.setBackground(new Color(224, 227, 224));
        ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("image\\return.png")));
        buttonBack.setIcon(img);
        buttonBack.setBounds(60,340,55,55);
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String backspaceInput = null;

                if(phoneNum.getText().length() > 0){
                    StringBuilder strB = new StringBuilder(phoneNum.getText());
                    strB.deleteCharAt(phoneNum.getText().length() - 1);
                    backspaceInput = String.valueOf(strB);
                    phoneNum.setText(backspaceInput);
                }
            }
        });
        frame.add(buttonBack);


        home= new Main.RoundButton("");
        home.setBounds(155,410,45,45);
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

////////////////input icon image by file

//        try {
//            Image img = ImageIO.read(new File("C:\\Lesson\\Term 4\\OOP\\final project\\Test\\src\\image\\lockscreen.jpg"));
//            frame.setIconImage(img);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        ////////////////input icon image by get resource

//        ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("image\\lockscreen.jpg")));
//        frame.setIconImage(img.getImage());

        frame.setLayout(null);
        frame.setSize(360,500);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static String getPhoneNum(){
        String phone = phoneNum.getText();
        return phone;
    }
    public static void main (String[] args) {
        new Phone();
    }

}
