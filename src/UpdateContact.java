import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;

public class UpdateContact extends JFrame{
    public JPanel panel;
    public JLabel l1,l2,l3,l4,l5;
    public JTextField tf1,tf2,tf3,tf4;
    public JButton btnDelete, btnHome;
    public JFrame frame;


    public JTable table = new JTable();
    public JScrollPane scrollPane = new JScrollPane(table);
    public void update(){
        // Create a table model for display contact
        DefaultTableModel model = new DefaultTableModel();
        // Add the columns to the model
        model.addColumn("Name");
        model.addColumn("Number");
        model.addColumn("Other");
        try {
            // Connect to the database
            String DB_URL = "jdbc:mysql://localhost:3306/cst4_oop_finalproject";
            String DB_Username = "root";
            String DB_Password = "";
            Connection con = DriverManager.getConnection(DB_URL, DB_Username, DB_Password);

            String query = "SELECT * FROM contact order by name asc";
            // Execute the query and retrieve the results
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Add the rows to the model
            while (rs.next()) {

                String col1 = rs.getString("name");
                String col2 = rs.getString("number");
                String col3 = rs.getString("other");
                model.addRow(new Object[] { col1, col2, col3 });
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        // Create a JTable and set the model
        table.setModel(model);
        table.setEnabled(false);

        // Add the table to a scroll pane
        //scrollPane.setBounds(20,0,320,180);
        scrollPane.setBounds(20,0,320,130);
        panel.add(scrollPane);
        frame.add(panel);
        //panel.setBounds(0,220,360,180);
        panel.setBounds(0,270,360,130);
    }
    UpdateContact(){
        /*FOR DATABASE*/
        String URL = "jdbc:mysql://localhost:3306/cst4_oop_finalproject";
        String username = "root";
        String password = "";

        /* FOR SWING APPLICATION */
        frame = new JFrame("Update Contact");
        panel = new JPanel(null);

        ImageIcon imgIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("image\\contact-book.jpg")));
        frame.setIconImage(imgIcon.getImage());

        l1 = new JLabel("Update Contact");
        l1.setForeground(new Color(45, 75, 139));
        l1.setFont(new Font("Times New Roman",Font.BOLD,30));
        l1.setBounds(50,5,400,40);
        frame.add(l1);

        l2 = new JLabel("Name");

        l2.setBounds(40,105,200,15);
        frame.add(l2);
        tf1 = new JTextField();
        tf1.setBounds(40,120,170,35);


        frame.add(tf1);

        l3 = new JLabel("Number");
        l3.setBounds(40,160,200,15);

        frame.add(l3);
        tf2 = new JTextField();
        tf2.setBounds(40,175,170,35);
        frame.add(tf2);

        l4 = new JLabel("Other");
        l4.setBounds(40,210,200,15);
        frame.add(l4);
        tf3 = new JTextField();
        tf3.setBounds(40,230,170,35);
        frame.add(tf3);
        /*If delete here*/
        l5 = new JLabel("Condition Name");
        l5.setBounds(40,50,200,15);
        frame.add(l5);
        tf4 = new JTextField();
        tf4.setBounds(40,65,170,35);
        frame.add(tf4);


        update();

        btnDelete = new JButton("Update");
        btnDelete.setBackground(new Color(104, 194, 104));
        btnDelete.setBounds(250,110,80,50);
        frame.add(btnDelete);
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = tf1.getText();
                String number = tf2.getText();
                String other = tf3.getText();
                String condition = tf4.getText();

                try{
                    Connection connection = DriverManager.getConnection(URL, username, password);
                    String sql = "update contact set name=?, number=?, other=? where name=?";

                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1,name);
                    statement.setString(2,number);
                    statement.setString(3,other);
                    statement.setString(4,condition);
                    statement.executeUpdate();
                    tf1.setText("");
                    tf2.setText("");
                    tf3.setText("");
                    tf4.setText("");
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                panel.repaint();
                table.repaint();
                scrollPane.repaint();
                update();
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
                try {
                    new Contact();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
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
        new UpdateContact();
    }
}