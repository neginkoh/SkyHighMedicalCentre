/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package skyhighmedical;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class DocSeacrhPatient1 extends javax.swing.JFrame {

    /**
     * Creates new form SearchPatientSecretary1
     */
    public DocSeacrhPatient1() {
        initComponents();
        setupTable();
         connect();
         fetch();
         loadPopupMenu();
    }
    private static String USERNAME = "z3419939";
    private static String PASSWORD = "zAnAnah2";
    private Connection con;
    private DefaultTableModel tableModel;
    private PreparedStatement st;
    private ResultSet rs;
    private int tableRow;
    private String fname;
     List<PatientAll> entries;
    
    
   
    
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
            String sql = "SELECT USERNAME from STAFFMEMBER WHERE PRIVILEGE= 'doctor'";
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
            jLabel1.setText("Search query failed. Please try again later");

            JOptionPane.showMessageDialog(null, e);
        }
    }
     private final ActionListener AddNotesListener = new ActionListener() {
        private PatientAll beingEdited;

        @Override
        public void actionPerformed(ActionEvent ae) {
            int elementToEdit = jTable1.getSelectedRow();
            if (elementToEdit != -1) {
                beingEdited = entries.get(elementToEdit);
                String selected = beingEdited.getPatientID();
                System.out.println(selected);
                //confirmation box
                  new AddNote().setVisible(true);
                
            }
        }

    };
    private void loadPopupMenu() {
        JPopupMenu popupMenu = new JPopupMenu();
        //name right click text
        JMenuItem AddPatientNotes = new JMenuItem("Add Patient Notes");
        
        //assign to listener
        AddPatientNotes.addActionListener(AddNotesListener);
        
        //add to menu
        popupMenu.add(AddPatientNotes);
        
        jTable1.setComponentPopupMenu(popupMenu);

       
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Screen Shot 2014-09-10 at 3.18.41 PM.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setText("Username:");

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/1411298576_search_magnifying_glass_find-32.png"))); // NOI18N

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

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel4.setText("Doctor Patient Search");

        jLabel5.setText("jLabel5");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1041, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(332, 332, 332))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(38, 38, 38)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1082, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 611, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
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
            java.util.logging.Logger.getLogger(DocSeacrhPatient1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DocSeacrhPatient1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DocSeacrhPatient1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DocSeacrhPatient1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DocSeacrhPatient1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
