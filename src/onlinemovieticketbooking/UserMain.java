/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinemovieticketbooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author anishsnair
 */
public class UserMain extends javax.swing.JFrame {

    ArrayList<Tablemodel> list;
    ArrayList<Booking> list2;
    Object[][] rows;
    class Booking{
        public int id;
         public int bid;
        public Booking(int a,int b){
        id=a;
        bid=b;
        }
    
    }
    /**
     * Creates new form UserMain
     */
    public void showSucc() {
                JOptionPane.showMessageDialog(this, "Ticket Cancelled Succesfully"); 
                loadtable();
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
    public UserMain
        () {
        initComponents();
        fillup();
        loadtable();
        jTable2.addMouseListener(new java.awt.event.MouseAdapter(){
                @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        int row=jTable2.rowAtPoint(evt.getPoint());
                        System.out.println(".mouseClicked()"+row);
                        int bkid=list2.get(row).bid;
                        
                 try{
                    
                    //int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Save your Previous Note First?");
                    //if(dialogResult == JOptionPane.YES_OPTION){
                      // Saving code here
                       
                  //  }
                    // p.setString(4, d);
                   
           
                     
                     int response = JOptionPane.showConfirmDialog(null, "do you want to delete the booking?");
                     System.out.println("res:"+response);
                     if(response==0){
                         deleteqry(bkid);
                            
                            showSucc();
                            
                     }
                     //con.close();
                     } catch (Exception ex) {
                     System.out.println("ERROR OCCURED");
                     System.out.println("ERROR:" + ex);
                        }
                        
                    }

            private void deleteqry(int bkid) throws Exception {
                deleteSeatList(bkid);
                deleteBookings(bkid);
                 

// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            private void deleteSeatList(int bkid) throws Exception{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cinimanage", "root", "");
                PreparedStatement p = con.prepareStatement("Update Seatlist set `status`=0 where bookingId=?");
                p.setInt(1, bkid);
                System.out.println(".deleteSeatList()");
                int rs = p.executeUpdate();//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            private void deleteBookings(int bkid) throws Exception{
               Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cinimanage", "root", "");
                PreparedStatement p = con.prepareStatement("delete  from bookings where  TicketNumber=?");
                p.setInt(1, bkid);
                int rs = p.executeUpdate();//
                System.out.println(".deleteBookings()");
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

           
        
        });
         
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        int row = jTable1.rowAtPoint(evt.getPoint());
                        int col = jTable1.columnAtPoint(evt.getPoint());
                        //if (row >= 0 ) {
                            System.out.println(".mouseClicked()" + row);
                            //Constant.managerid = list.get(row).getManid();
                            Constant.TheatreId = list.get(row).getId();
                            Constant.theatrename = list.get(row).getName();
                            Constant.moviename = list.get(row).getMovie();
                            Constant.movieid = list.get(row).getMovieId();
                            Constant.showtimings = list.get(row).getTimings();
                            Constant.showdates = list.get(row).getDAtes();
                            Constant.balconyrate = list.get(row).getBalconyrate();
                            Constant.normalrate = list.get(row).getNormalrate();

                            Constant.imgurl = list.get(row).getImg();
                           BookTicket x =new BookTicket();
                           x.show();
                           dsposeit();
                    
                            System.out.println(".mouseClicked()" + list.get(row).getManid());
                            
                            

                        //}
                    }

            
                });
    }

    private void dsposeit() {
                this.dispose();//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        movie = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        crit = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        home = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("SEARCH");
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

        crit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Movie", "Place" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(279, 279, 279)
                .addComponent(crit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(movie, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(191, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(movie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(crit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Book Ticket", jPanel1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("View History", jPanel2);

        home.setText("LOGOUT");
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 865, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(home)
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        fillup();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void fillup(){
        list2 = new ArrayList<>();
        String[] columns = new String[]{"Id", "Name", "place", "mobile", "timings",};
        String Pin = movie.getText();
        try {

            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost:3306/cinimanage?"
                    + "user=root&password=";
            Connection con = DriverManager.getConnection(connectionUrl);

            PreparedStatement st = null;
            ResultSet rs;

            try {
                list = new ArrayList<>();
                if(crit.getSelectedItem().toString().equalsIgnoreCase("Movie")){
                st = con.prepareStatement("SELECT "
                                                + "mov.Dates,mov.AutoId mid,mov.Movie Movie,mov.MovieBadge MovieBadge,mov.Timing ShowTimings,tl.Name TheatreName,tl.Mobile Mobile,tl.Place Place,tl.BalconyRate BalconyRate,tl.NormalRate NormalRate"
                                            + " from "
                                                    + "theatrelist tl,movies mov "
                                            + "where "
                                                    + "  mov.`Theatre`=tl.`AutoId` and tl.Status=1 and mov.Status=1 "
                                                    + "and mov.Movie like ?");
                }else{
                     st = con.prepareStatement("SELECT "
                                                + "mov.Dates,mov.AutoId mid,mov.Movie Movie,mov.MovieBadge MovieBadge,mov.Timing ShowTimings,tl.Name TheatreName,tl.Mobile Mobile,tl.Place Place,tl.BalconyRate BalconyRate,tl.NormalRate NormalRate"
                                            + " from "
                                                    + "theatrelist tl,movies mov "
                                            + "where "
                                                    + "  mov.`Theatre`=tl.`AutoId` and tl.Status=1 and mov.Status=1 "
                                                    + "and tl.Place like ?");
                    // con.prepareStatement("SELECT b.`TheatreName`, b.`Place`, a.`MovieBadge`, a.`Movie`, b.`Mobile` ,a.`ManagerId`,a.`ManagerId`,a.`ShowTimings`,a.`NormalRate`,a.`BalconyRate` FROM `owners` b left join  `theatrelist` a  on a.`ManagerId`=b.`AutoId` WHERE b.`Place` like ?");
                }
                System.out.println("theatremanagement.UserMain.fillup()"+"SELECT "
                                                + "mov.AutoId mid,mov.Movie Movie,mov.MovieBadge MovieBadge,mov.Timing ShowTimings,tl.Name TheatreName,tl.Mobile Mobile,tl.Place Place,tl.BalconyRate BalconyRate,tl.NormalRate NormalRate"
                                            + " from "
                                                    + "theatrelist tl,movies mov "
                                            + "where "
                                                    + "  mov.`Theatre`=tl.`AutoId` and tl.Status=1 and mov.Status=1 "
                                                    + "and tl.Place like ?");
                st.setString(1, '%'+movie.getText()+'%');

                rs = st.executeQuery();

                while (rs.next()) {
                    list.add(new Tablemodel(rs.getString("Dates"),rs.getString("mid"),String.valueOf(rs.getRow()), rs.getString("TheatreName"), rs.getString("Place"), rs.getString("Mobile"), rs.getString("ShowTimings"), rs.getString("BalconyRate"), rs.getString("NormalRate"), rs.getString("MovieBadge"), rs.getString("Movie")));
                }
                rows = new Object[list.size()][5];
                for (int j = 0; j < list.size(); j++) {
                    rows[j][0] = list.get(j).getId();
                    rows[j][1] = list.get(j).getName();
                    rows[j][3] = list.get(j).getMobile();
                    rows[j][2] = list.get(j).getPlace();
                    rows[j][4] = list.get(j).getTimings();
                }
                
                DefaultTableModel model = new DefaultTableModel(rows, columns);
                model.fireTableRowsUpdated(0, list.size());
                jTable1.setModel(model);

                jTable1.setRowHeight(25);
                jTable1.getColumnModel().getColumn(2).setPreferredWidth(25);
                jTable1.setCellSelectionEnabled(false);

                

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    
    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
        // TODO add your handling code here:
       User x= new User();
        this.dispose();
        x.show();
    }//GEN-LAST:event_homeActionPerformed

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
            java.util.logging.Logger.getLogger(UserMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> crit;
    private javax.swing.JButton home;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField movie;
    // End of variables declaration//GEN-END:variables

    private void loadtable() {
        try {
             
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cinimanage", "root", "");
            Statement stmt = con.createStatement();

            String str1 = "select * from bookings WHERE User=" + Constant.userid + "";

            System.out.print(str1);
            ResultSet rs1 = stmt.executeQuery(str1);
            int i=0;
            //rs1.first();
            String[] columns = new String[]{
            "bookingId", "Date", "Ticket Count", "Movie"};
            rows = new Object[50][5];
            while (rs1.next()) {
                    System.out.println("onlinemovieticketbooking.UserMain.loadtable(sdsds)");
                    list2.add(new Booking(i,rs1.getInt("TicketNumber")));
                    rows[i][0] = rs1.getInt("TicketNumber");
                    rows[i][1] = rs1.getString("ShowDate");
                    rows[i][3] = rs1.getInt("NoOfTickets");
                    rows[i][4] = rs1.getString("Movie");
                   // rows[j][4] = list.get(j).getTimings();
                    i++;
                }
            DefaultTableModel model = new DefaultTableModel(rows, columns);
                model.fireTableRowsUpdated(0, list.size());
                jTable2.setModel(model);
            
            
            con.close();
        } catch (Exception ex) {
            System.out.println("ERROR OCCURED");
            System.out.println("ERROR:" + ex);
        } //To change body of generated methods, choose Tools | Templates.
    }
}
