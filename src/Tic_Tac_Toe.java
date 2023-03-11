import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Tic_Tac_Toe {
    public JFrame frame;
    public JButton single,multi,home;
    public JLabel l1;
    public Tic_Tac_Toe(){
        frame = new JFrame("Tic-Tac-Toe");
        frame.setContentPane(new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("image\\tic_tac_toe.jpg")))));
        ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("image\\tic-tac-toe-icon.jpg")));
        frame.setIconImage(img.getImage());

        l1=new JLabel("Tic Tac Toe");
        l1.setBounds(70,70,300,30);
        l1.setFont(new Font("Times New Roman", Font.BOLD,40));
        l1.setForeground(new Color(70, 255, 255));
        frame.add(l1);

        single = new JButton("Single Player");
        single.setBounds(100,180,150,60);
        single.setFont(new Font("Times New Roman", Font.BOLD,20));
        single.setForeground(Color.black);
        single.setBackground(new Color(231, 255, 253));
//        single.setOpaque(false);
//        single.setContentAreaFilled(false);
        single.setBorderPainted(false);
        single.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new SinglePlayer();

            }
        });
        frame.add(single);

        multi = new JButton("Multi Player");
        multi.setBounds(100,270,150,60);
        multi.setFont(new Font("Times New Roman", Font.BOLD,20));
        multi.setForeground(Color.black);
        multi.setBackground(new Color(231, 255, 253));
        multi.setBorderPainted(false);
        multi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new MultiPlayer();
            }
        });
        frame.add(multi);

        home= new Main.RoundButton("");
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

        frame.setLayout(null);
        frame.setSize(360,500);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main (String args[]) {
        new Tic_Tac_Toe();
    }

}
