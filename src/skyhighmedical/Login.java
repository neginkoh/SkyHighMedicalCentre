/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package skyhighmedical;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Negin
 */
public class Login extends javax.swing.JFrame
{
    private Connection con;
    private PreparedStatement st;
    private ResultSet rs;
    public static String USERNAME = "z3419939";
    public static String PASSWORD = "zAnAnah2";

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        
        this.setTitle("Welcome to Sky High Medical Center");
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        connect();
        
    }
     public void connect() {
        try {
            Class.forName("oracle.jdbc.OracleDriver").newInstance();
            String url = "jdbc:oracle:thin:@//" + "sage.business.unsw.edu.au" + ":" + "1521" + "/" + "orcl01" + ".asbpldb001.ad.unsw.edu.au";
           
            con = DriverManager.getConnection(url, USERNAME, PASSWORD);
            System.out.println("Connected to database");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed to connect to the database, please start the server"
                    + " in the 'Services' tab or read the setup instructions.");
            welcomeLabel.setText("Database failure. Please start the database.");
        }
    }
    
    
     public void validateLogin() {
        String userName = txtUsername.getText();
        String userPassword = txtPassword.getText();
/*
        if (txtUsername.getText().length() == 0 || txtPassword.getText().length() == 0) {
            welcomeLabel.setText("Either username or password field is empty.");
            JOptionPane.showMessageDialog(null, "Either the username or password field is empty,"
                            + " please try again.");

        } else if ("negina".equals(userName) && "negina".equals(userPassword)) {
            welcomeLabel.setText("Success! Logging you in....");
        //backup user which always works

            new AdminDashboard().setVisible(true);
            this.dispose();

        } 
        else if ("sanea".equals(userName) && "sanea".equals(userPassword)) {
            welcomeLabel.setText("Success! Logging you in....");
        //backup user which always works

            new DoctorDashboard().setVisible(true);
            this.dispose();

        }
        else{

 */           try {
                //look through users table for a match of both user and password
                String sql = "SELECT privilege FROM z3419939.staffmember WHERE USERNAME = ? and PASSWORD = ?";
               
                int i = 0;
                String privilege = "";
                st = con.prepareStatement(sql);
                st.setString(1, userName);
                st.setString(2, userPassword);
                
                rs = st.executeQuery();

                while (rs.next()) {
           //         i++;
                    privilege = rs.getNString("PRIVILEGE");
                    //increment i if match found
                }
         //       if (i == 1) {
                if (privilege.equalsIgnoreCase("admin")) {
                    //login if there is ONLY one match for security
                    welcomeLabel.setText("Success! Logging you in....");
                    new AdminDashboard().setVisible(true);
          //          new NurseDashboard().setVisible(true);
                    this.dispose();
                } else if (privilege.equalsIgnoreCase("doctor")) {
                     welcomeLabel.setText("Success! Logging you in....");
                    new DoctorDashboard().setVisible(true);
                } else if (privilege.equalsIgnoreCase("nurse")) {
                     welcomeLabel.setText("Success! Logging you in....");
                    new NurseDashboard().setVisible(true);
                } 
                
                else {
                    welcomeLabel.setText("Username or password incorrect. Please try again.");
                    JOptionPane.showMessageDialog(null, "Username or password was entered incorrectly,"
                            + " please try again.");
                }
            } catch (SQLException | HeadlessException e) {

                e.printStackTrace();
                welcomeLabel.setText("We failed to connect to the database.");

            }
 //       }
    }


    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLable3 = new javax.swing.JLabel();
        jLable4 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        welcomeLabel = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(300, 200, 0, 0));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/10685071_552528208208092_1866046325_n.jpg"))); // NOI18N

        jLable3.setFont(new java.awt.Font("Malayalam MN", 0, 13)); // NOI18N
        jLable3.setForeground(new java.awt.Color(0, 153, 153));
        jLable3.setText("Username:");

        jLable4.setFont(new java.awt.Font("Malayalam MN", 0, 13)); // NOI18N
        jLable4.setForeground(new java.awt.Color(0, 153, 153));
        jLable4.setText("Password:");

        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        welcomeLabel.setFont(new java.awt.Font("Malayalam MN", 0, 13)); // NOI18N
        welcomeLabel.setForeground(new java.awt.Color(255, 0, 51));
        welcomeLabel.setText("Please enter the required fields to log-in:");

        loginButton.setFont(new java.awt.Font("Malayalam MN", 1, 13)); // NOI18N
        loginButton.setForeground(new java.awt.Color(0, 153, 153));
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(160, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(209, 209, 209))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLable3)
                                    .addComponent(jLable4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtUsername)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(loginButton))
                                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(115, 115, 115))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(welcomeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLable3)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLable4)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loginButton)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txtUsernameActionPerformed
    {//GEN-HEADEREND:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_loginButtonActionPerformed
    {//GEN-HEADEREND:event_loginButtonActionPerformed
validateLogin();        // TODO add your handling code here:
    }//GEN-LAST:event_loginButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLable3;
    private javax.swing.JLabel jLable4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
