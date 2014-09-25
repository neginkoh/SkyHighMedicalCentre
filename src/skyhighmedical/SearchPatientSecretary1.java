/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package skyhighmedical;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class SearchPatientSecretary1 extends javax.swing.JFrame {

    /**
     * Creates new form SearchPatientSecretary1
     */
    public SearchPatientSecretary1() {
        initComponents();
        setupTable();
         connect();
         fetch();
    }
    private static String USERNAME = "z3419939";
    private static String PASSWORD = "zAnAnah2";
    private Connection con;
    private DefaultTableModel tableModel;
    private PreparedStatement st;
    private ResultSet rs;
    private int tableRow;
    private String fname;
    
    
   
    
     public void connect() {
        try {
            Class.forName("oracle.jdbc.OracleDriver").newInstance();
            String url = "jdbc:oracle:thin:@//" + "sage.business.unsw.edu.au" + ":" + "1521" + "/" + "orcl01" + ".asbpldb001.ad.unsw.edu.au";
           
            con = DriverManager.getConnection(url, USERNAME, PASSWORD);
            System.out.println("Connected to database");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed to connect to the database, please start the server"
                    + " in the 'Services' tab or read the setup instructions.");
                   }
    }
     public void fetch(){
             try {
            String sql = "SELECT USERNAME from STAFFMEMBER WHERE PRIVILEGE= 'admin'";
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
               
                fname = rs.getString("USERNAME");
                
                jLabel5.setText(fname + " " );
            }
                           

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e);
        }
             }
     
    

     
    
    public void setupTable() {
        setupSearchTable();
    }
    private void setupSearchTable() {

        tableModel = new DefaultTableModel();
        tableModel.setColumnCount(4);
        tableModel.setColumnIdentifiers(new String[]{"Patient ID", "First Name", "Last Name", "Contact"});
        jTable1.setModel(tableModel);
    }
    private void search() {
        try {
            String sql = "Select * from PATIENT where PATIENTID LIKE ?";
            st = con.prepareStatement(sql);
            st.setString(1, jTextField2.getText());
            rs = st.executeQuery();
            if (rs.next()) {
                tableModel.setNumRows(1);
                String add1 = rs.getString("PATIENTID");
                tableModel.setValueAt(add1, tableRow, 0);
                String add2 = rs.getString("FIRSTNAME");
                tableModel.setValueAt(add2, tableRow, 1);
                String add3 = rs.getString("LASTNAME");
                tableModel.setValueAt(add3, tableRow, 2);
                String add4 = rs.getString("CONTACT");
                tableModel.setValueAt(add4, tableRow, 3);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        try {
            String sql = "Select * from PATIENT where FIRSTNAME LIKE ?";
            st = con.prepareStatement(sql);
            st.setString(1, jTextField2.getText());
            rs = st.executeQuery();
            if (rs.next()) {
                tableModel.setNumRows(1);
                String add1 = rs.getString("PATIENTID");
                tableModel.setValueAt(add1, tableRow, 0);
                String add2 = rs.getString("FIRSTNAME");
                tableModel.setValueAt(add2, tableRow, 1);
                String add3 = rs.getString("LASTNAME");
                tableModel.setValueAt(add3, tableRow, 2);
                String add4 = rs.getString("CONTACT");
                tableModel.setValueAt(add4, tableRow, 3);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        try {
            String sql = "Select * from PATIENT where LASTNAME LIKE ?";
            st = con.prepareStatement(sql);
            st.setString(1, jTextField2.getText());
            rs = st.executeQuery();
            if (rs.next()) {
                tableModel.setNumRows(1);
                String add1 = rs.getString("PATIENTID");
                tableModel.setValueAt(add1, tableRow, 0);
                String add2 = rs.getString("FIRSTNAME");
                tableModel.setValueAt(add2, tableRow, 1);
                String add3 = rs.getString("LASTNAME");
                tableModel.setValueAt(add3, tableRow, 2);
                String add4 = rs.getString("CONTACT");
                tableModel.setValueAt(add4, tableRow, 3);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        try {
            String sql = "Select * from PATIENT where CONTACT LIKE ?";
            st = con.prepareStatement(sql);
            st.setString(1, jTextField2.getText());
            rs = st.executeQuery();
            if (rs.next()) {
                tableModel.setNumRows(1);
                String add1 = rs.getString("PATIENTID");
                tableModel.setValueAt(add1, tableRow, 0);
                String add2 = rs.getString("FIRSTNAME");
                tableModel.setValueAt(add2, tableRow, 1);
                String add3 = rs.getString("LASTNAME");
                tableModel.setValueAt(add3, tableRow, 2);
                String add4 = rs.getString("CONTACT");
                tableModel.setValueAt(add4, tableRow, 3);

            }

        } catch (Exception e) {
            jLabel5.setText("Search query failed. Please try again later");

            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Nanum Pen Script", 1, 24)); // NOI18N
        jLabel2.setText("Username:");

        jButton1.setBackground(java.awt.SystemColor.textHighlight);
        jButton1.setFont(new java.awt.Font("Oriya MN", 0, 14)); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setFont(new java.awt.Font("Mongolian Baiti", 1, 36)); // NOI18N
        jLabel4.setText("Patient Search");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Screen Shot 2014-09-10 at 11.00.32 PM.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(238, 238, 238)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 898, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 133, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(29, 29, 29)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jTextField2)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setupSearchTable();
        search();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SearchPatientSecretary1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchPatientSecretary1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchPatientSecretary1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchPatientSecretary1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchPatientSecretary1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
