/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinemovieticketbooking;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Cyber
 */
public class BookTicket extends javax.swing.JFrame {


    /**
     * Creates new form Shopselected
     */
    public BookTicket() {
        initComponents();
        loadlabels();
       
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        theatre = new javax.swing.JLabel();
        showtime = new javax.swing.JLabel();
        timevalue = new javax.swing.JComboBox<>();
        rate = new javax.swing.JLabel();
        rateval = new javax.swing.JLabel();
        seating = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        moviename = new javax.swing.JLabel();
        seatingtype = new javax.swing.JLabel();
        type = new javax.swing.JComboBox<>();
        facilities = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nooftickets = new javax.swing.JTextField();
        movieimg = new javax.swing.JLabel();
        datepicker = new javax.swing.JComboBox<>();
        booklimit = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Theatre Name ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, -1, -1));
        getContentPane().add(theatre, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 165, 23));

        showtime.setText("show timings");
        getContentPane().add(showtime, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 105, -1));

        timevalue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timevalueActionPerformed(evt);
            }
        });
        getContentPane().add(timevalue, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, 130, -1));

        rate.setText("Rate  per selected(Rs)");
        getContentPane().add(rate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 560, 121, -1));
        getContentPane().add(rateval, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 560, 49, 18));

        seating.setText("select seating");
        seating.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seatingActionPerformed(evt);
            }
        });
        getContentPane().add(seating, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 620, -1, -1));

        jLabel3.setText("Movie name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, -1, -1));
        getContentPane().add(moviename, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 165, 14));

        seatingtype.setText("Seating Type");
        getContentPane().add(seatingtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, -1, -1));

        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Normal", "Balcony" }));
        type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeActionPerformed(evt);
            }
        });
        getContentPane().add(type, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 490, -1, -1));

        facilities.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ac", "Non Ac" }));
        getContentPane().add(facilities, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, -1, -1));

        jLabel2.setText("Failities");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, 85, -1));

        jLabel4.setText("( Rs.100 more On A/c Tickets )");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 370, -1, -1));

        jLabel5.setText("SHOW DATE");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, -1, -1));

        jLabel6.setText("No of tickets");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 530, -1, -1));
        getContentPane().add(nooftickets, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 530, 62, -1));
        getContentPane().add(movieimg, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 743, 126));

        datepicker.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        datepicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datepickerActionPerformed(evt);
            }
        });
        getContentPane().add(datepicker, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, 175, -1));

        booklimit.setText("you can book upto :16 tickets");
        getContentPane().add(booklimit, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 530, -1, -1));

        jButton1.setText("cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 620, -1, -1));

        jLabel7.setText("book ticket");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 370, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void seatingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seatingActionPerformed
        // TODO add your handling code here:
        Constant.bookingdate=datepicker.getSelectedItem().toString();//simpledate.getText();
        System.out.println(".BookTicket.()"+Constant.bookingdate);
        Constant.nooftickets=nooftickets.getText();
        int maxt=12;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/cinimanage","root","");
            Statement stmt=con.createStatement();
            //String Sdate=SearchTicketNumber.getText();

            String str1="SELECT sum(`Status`) s FROM `seatlist` WHERE `Date` = '"+datepicker.getSelectedItem()+"' and Timing='"+timevalue.getSelectedItem()+"'";

            //            System.out.print(str1);
            ResultSet rs1=stmt.executeQuery(str1);
            if(rs1.next()){
                System.out.println("theatremanagement nop of ticket :"+rs1.getInt("s")+"\n     "+str1 );
                maxt=rs1.getInt("s");
                maxt=16-maxt;
                }
            //Ticket.setModel(DbUtils.resultSetToTableModel(rs1));
             
           if(maxt>=Integer.parseInt(Constant.nooftickets)){
            
                    Gridview g=new Gridview(Constant.movieid,Constant.theatrename,rateval.getText(),timevalue.getSelectedItem().toString(),Constant.bookingdate,Constant.nooftickets);
                    g.setVisible(true);
                    g.setSize(500, 500);
                    this.dispose();
            
                  }
             else{
             
               JOptionPane.showMessageDialog(this, new String("you can only oreder upto "+maxt+" ticket for the show"));
            
                }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
       
        
    }//GEN-LAST:event_seatingActionPerformed

    private void timevalueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timevalueActionPerformed
        // TODO add your handling code here:
        
        
        
    }//GEN-LAST:event_timevalueActionPerformed

    private void typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeActionPerformed

    private void datepickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datepickerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_datepickerActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new UserMain().show();
        this.dispose();
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
            java.util.logging.Logger.getLogger(BookTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookTicket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel booklimit;
    private javax.swing.JComboBox<String> datepicker;
    private javax.swing.JComboBox<String> facilities;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel movieimg;
    private javax.swing.JLabel moviename;
    private javax.swing.JTextField nooftickets;
    private javax.swing.JLabel rate;
    private javax.swing.JLabel rateval;
    private javax.swing.JButton seating;
    private javax.swing.JLabel seatingtype;
    private javax.swing.JLabel showtime;
    private javax.swing.JLabel theatre;
    private javax.swing.JComboBox<String> timevalue;
    private javax.swing.JComboBox<String> type;
    // End of variables declaration//GEN-END:variables

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
       Image newImg = img.getScaledInstance(650, 200, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }


    private void loadlabels() {
        System.out.println("loadlabels()"+Constant.theatrename);
        theatre.setText(Constant.theatrename);
        moviename.setText(Constant.moviename);
        movieimg.setIcon(ResizeImage(Constant.imgurl));
        String []a=Constant.showtimings.split(",");
        String []b=Constant.showdates.split(",");
        DefaultComboBoxModel model = new DefaultComboBoxModel(a);
        DefaultComboBoxModel model2 = new DefaultComboBoxModel(b);
        timevalue.setModel(model);
        datepicker.setModel(model2);
       type.addActionListener(new  ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(type.getSelectedItem().toString().equalsIgnoreCase("Balcony")){
               
                    rateval.setText(String.valueOf(Integer.parseInt(Constant.balconyrate)));
                }else{
                 if(facilities.getSelectedItem().toString().equalsIgnoreCase("Ac")){
                rateval.setText(String.valueOf(Integer.parseInt(Constant.normalrate)+100));
                    
                    }else{
                    rateval.setText(String.valueOf(Integer.parseInt(Constant.normalrate)));
                 }
                }
                
              
              //To change body of generated methods, choose Tools | Templates.
            }
        });
       
       
        
         //To change body of generated methods, choose Tools | Templates.
    }
}
