import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Objects;

public class MainInterface extends JFrame {
    public JFrame frame;
    private final JButton phone, contact ,calculator,clock,calendar,game;
//      private final JButton phone, contact ,calculator;
    private JLabel l1,l2,l3,l4,l5,l6;

    public MainInterface() {
        frame = new JFrame("Main Interface");

        frame.setContentPane(new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("image\\homescreen.jpg")))));

        ImageIcon imgIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("image\\home.jpg")));
        frame.setIconImage(imgIcon.getImage());

        phone = new JButton();
        ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("image\\phone-call.png")));
        phone.setIcon(img);
        phone.setOpaque(false);
        phone.setContentAreaFilled(false);
        phone.setBorderPainted(false);
        phone.setBounds(60,40,80,80);

        phone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                frame.setVisible(false);
                new Phone();
            }
        });
        frame.add(phone);

        l1=new JLabel("Phone");
        l1.setBounds(75,120,80,30);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Verdana", Font.BOLD,13));
        frame.add(l1);

        contact = new JButton();
        ImageIcon img1 = new ImageIcon(Objects.requireNonNull(getClass().getResource("image\\user.png")));
        contact.setIcon(img1);
        contact.setOpaque(false);
        contact.setContentAreaFilled(false);
        contact.setBorderPainted(false);
        contact.setBounds(210,40,80,80);
        contact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                frame.setVisible(false);
                try {
                    new Contact();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        frame.add(contact);

        l2=new JLabel("Contact");
        l2.setBounds(220,120,80,30);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Verdana", Font.BOLD,13));
        frame.add(l2);

        calculator = new JButton();
        ImageIcon img2 = new ImageIcon(Objects.requireNonNull(getClass().getResource("image\\calculator.png")));
        calculator.setIcon(img2);
        calculator.setOpaque(false);
        calculator.setContentAreaFilled(false);
        calculator.setBorderPainted(false);
        calculator.setBounds(60,170,80,80);
        calculator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                frame.setVisible(false);
                new Standard_Calculator();
            }
        });
        frame.add(calculator);

        l3=new JLabel("Calculator");
        l3.setBounds(60,250,100,30);
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("Verdana", Font.BOLD,13));

        frame.add(l3);

        clock = new JButton();
        ImageIcon img3 = new ImageIcon(Objects.requireNonNull(getClass().getResource("image\\clock.png")));
        clock.setIcon(img3);
        clock.setOpaque(false);
        clock.setContentAreaFilled(false);
        clock.setBorderPainted(false);
        clock.setBounds(210,170,80,80);
        clock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                frame.setVisible(false);
                new Clock();
            }
        });
        frame.add(clock);


        l4=new JLabel("Clock");
        l4.setBounds(230,250,80,30);
        l4.setForeground(Color.WHITE);
        l4.setFont(new Font("Verdana", Font.BOLD,13));
        frame.add(l4);

        calendar = new JButton();
        ImageIcon img4 = new ImageIcon(Objects.requireNonNull(getClass().getResource("image\\calendar.png")));
        calendar.setIcon(img4);
        calendar.setOpaque(false);
        calendar.setContentAreaFilled(false);
        calendar.setBorderPainted(false);
        calendar.setBounds(60,300,80,80);
        calendar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                frame.setVisible(false);
                new Calendar();
            }
        });
        frame.add(calendar);

        l5=new JLabel("Calender");
        l5.setBounds(73,380,80,30);
        l5.setForeground(Color.WHITE);
        frame.add(l5);

        game = new JButton();
        ImageIcon img5 = new ImageIcon(Objects.requireNonNull(getClass().getResource("image\\tic-tac-toe.png")));
        game.setIcon(img5);
        game.setOpaque(false);
        game.setContentAreaFilled(false);
        game.setBorderPainted(false);
        game.setBounds(210,300,80,80);
        game.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                frame.setVisible(false);
                new Tic_Tac_Toe();
            }
        });
        frame.add(game);

        l6=new JLabel("Tic-Tac-Toe");
        l6.setBounds(215,380,80,30);
        l6.setForeground(Color.WHITE);
        frame.add(l6);

        frame.setLayout(null);
        frame.setSize(360,500);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main (String args[]) {
        new MainInterface();
    }
}
