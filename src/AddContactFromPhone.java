import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public class AddContactFromPhone extends JFrame {
    public JLabel l1,l2,l3,l4,l5;
    public JTextField tf1,tf2,tf3;
    public JButton btnAdd, btnHome;
    public AddContactFromPhone(){
        /*FOR DATABASE*/
        String URL = "jdbc:mysql://localhost:3306/cst4_oop_finalproject";
        String username = "root";
        String password = "";

        /* FOR SWING APPLICATION */
        JFrame frame = new JFrame("Add Contact");

        ImageIcon imgIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("image\\contact-book.jpg")));
        frame.setIconImage(imgIcon.getImage());

        l1 = new JLabel("New Contact");
        l1.setForeground(new Color(80, 75, 139));
        l1.setFont(new Font("Times New Roman",Font.BOLD,30));
        l1.setBounds(100,20,400,40);
        frame.add(l1);

        l2 = new JLabel("Name");
        l2.setBounds(70,50,200,15);
        frame.add(l2);
        tf1 = new JTextField();
        tf1.setBounds(70,65,200,35);
        frame.add(tf1);

        l3 = new JLabel("Number");
        l3.setBounds(70,105,200,15);
        frame.add(l3);

        tf2 = new JTextField(Phone.getPhoneNum());
        tf2.setBounds(70,120,200,35);
        frame.add(tf2);

        l4 = new JLabel("Other");
        l4.setBounds(70,165,200,15);
        frame.add(l4);
        tf3 = new JTextField();
        tf3.setBounds(70,180,200,35);
        frame.add(tf3);

        l5 = new JLabel("");
        l5.setBounds(60,300,270,15);
        l5.setForeground(new Color(0x00CB00));
        frame.add(l5);



        btnAdd = new JButton("Add Contact");
        btnAdd.setBounds(110,240,120,50);
        btnAdd.setBackground(new Color(64, 194, 212));
        frame.add(btnAdd);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name, other, number;
                try {
                    if((!Objects.equals(tf1.getText(), "") && !Objects.equals(tf2.getText(), ""))) {
                        Connection connection = DriverManager.getConnection(URL,username,password);
                        name = tf1.getText();
                        System.out.println("name :"+ name+"y");
                        number = tf2.getText();
                        other = tf3.getText();

                        String sql = "insert into contact (name,number,other)"
                                + "values(?,?,?)";

                        PreparedStatement statement = connection.prepareStatement(sql);
                        statement.setString(1,name);
                        statement.setString(2,number);
                        statement.setString(3,other);
                        statement.executeUpdate();
                        tf1.setText("");
                        tf2.setText("");
                        tf3.setText("");
                        l5.setForeground(Color.green);
                        l5.setText("You have successfully add new contact!");
                        connection.close();
                    }else {
                        l5.setForeground(Color.BLUE);
                        l5.setText("                     Empty values!!");
                    }

                } catch (SQLException ex) {
                    l5.setForeground(Color.RED);
                    l5.setText("                     Name existed!");
                    ex.printStackTrace();
                }
            }
        });

        btnHome= new Main.RoundButton("");
        btnHome.setBounds(150,410,45,45);
        btnHome.setBackground(new Color(0xBBBBBB));
        btnHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                frame.setVisible(false);
                new Phone();
            }
        });
        frame.add(btnHome);

        frame.setSize(360,500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new AddContact();
    }
}