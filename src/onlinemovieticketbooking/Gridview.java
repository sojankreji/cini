/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinemovieticketbooking;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.*;
import static java.lang.Math.random;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import javax.swing.*;
import onlinemovieticketbooking.Constant;
import onlinemovieticketbooking.PaymentGateway;

public class Gridview extends JFrame implements ActionListener {

    JButton b[][]= new JButton[5][5];;
    ArrayList<String>seatnum;
   

        int count=0;
   Random rand = new Random();
     int tick=rand.nextInt(100000);
    String shop,rate,time,nooftic,mid,date;
    //int v1[] = { 2, 5, 3, 7, 10 };
    //int v2[] = { 3, 5, 6, 9, 12 };
    public Gridview(String mid,String shop, String rate,String time,String date,String nooftickets) {
        //b=new JButton[5][5];
     
        this.count=0;
        this.shop=shop;
        this.mid=mid;
        this.rate=rate;
        this.time=time;
        this.date=date;
        this.nooftic=nooftickets;
        Constant.totalrate=rate;
        seatnum=new ArrayList<>();
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost:3306/cinimanage?"
                    + "user=root&password=";
            Connection con = DriverManager.getConnection(connectionUrl);

            PreparedStatement st = null;
            ResultSet rs;

            try {
                st = con.prepareStatement("SELECT `AutoId`,Timing,`moveId`, `row`,`Date`, `col`, `status` FROM `Seatlist` WHERE moveId =? and Timing=? and Date=?");
                st.setString(1, mid);
                 st.setString(2, this.time);
                 st.setString(3, this.date);
                rs = st.executeQuery();
                setLayout(new GridLayout(4, 4));
                
                
                //setDefaultCloseOperation(EXIT_ON_CLOSE);
                int k = 1;
                for(int i=0;i<4;i++){
                    for(int j=0;j<4;j++){
                        System.out.println("initializing");
                        b[i][j] = new JButton();
                        b[i][j].addActionListener(this);
                        b[i][j].setText("" + k);
                        add(b[i][j]);
                        b[i][j].setBackground(Color.GREEN);
                        k++;
                    }
                }
                while (rs.next()) {
                    int i = rs.getInt("row");
                    int j = rs.getInt("col");
                    

                    System.err.printf("row %d %d", rs.getInt("row"), rs.getInt("col"));

                    if (rs.getInt("status") == 1) {
                        b[i][j].setBackground(Color.red);
                    } else {
                        b[i][j].setBackground(Color.GREEN);

                    }
                }

            } catch (Exception e) {
                System.out.println("initializing failed");
                e.printStackTrace();
            }

        } catch (Exception e) {
            System.out.println("connection failed");
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae
    ) {
        /*if (((JButton) ae.getSource()).getBackground() == Color.red) {
            ((JButton) ae.getSource()).setBackground(Color.green);
        } else {
            ((JButton) ae.getSource()).setBackground(Color.red);
        }*/
        
      
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (b[i][j] == (JButton) ae.getSource()) {    
                    System.out.printf("Selected row and column: %d %d%n%d", i, j, count);
                    try {
                        if( b[i][j].getBackground()==Color.green){
                            if(Integer.parseInt(nooftic)>count){
                                count=count+1;
                                ((JButton) ae.getSource()).setBackground(Color.BLUE);
                                 seatnum.add(b[i][j].getText());
                               }
                            else{
                                System.out.println("color green but count issue");
                            }

                        }
                        else  if( b[i][j].getBackground()==Color.BLUE){
                            if(Integer.parseInt(nooftic)>count&&count!=0)
                                {
                                count=count-1;
                                ((JButton) ae.getSource()).setBackground(Color.GREEN);
                                
                                seatnum.remove(b[i][j].getText());
                                }
                            if(Integer.parseInt(nooftic)==count&&count!=0)
                                {
                                count=count-1;
                                ((JButton) ae.getSource()).setBackground(Color.GREEN);
                                 seatnum.remove(b[i][j].getText());
                                }
                            }
                        else{

                            System.out.println("theatremanagement.Gridview.actionPerformed() \n ERR count:"+count+" \n no:"+Integer.parseInt(nooftic));
                            }
                        
                        
                        
                        if(seatnum.size()==Integer.parseInt(Constant.nooftickets)){

                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cinimanage", "root", "");
                            int kl=0;
                            for(int k=0;k<seatnum.size();k++){
                                
                                System.out.println("onlinemovieticketbooking tick num"+this.tick);
                                String rc[]=new Constant().pos(Integer.parseInt(seatnum.get(k).toString())).split("-");
                                PreparedStatement p = con.prepareStatement("INSERT INTO `Seatlist` (`row`,`col`,`moveId`,`Timing`,`Date`,`status`,`bookingId`,`userId`) values(?,?,?,?,?,?,?,?)");
                                p.setString(1, rc[0]);
                                p.setString(2, rc[1]);
                                p.setString(3, this.mid); 
                                p.setString(4, this.time);
                                p.setString(5, this.date);
                                p.setInt(6,0);
                                
                           
                                p.setInt(7,this.tick);
                                p.setInt(8,Integer.parseInt(Constant.userid));
                                p.execute();
                                }
                            System.out.println("Ticket :"+this.tick);
                            PaymentGateway paymentGateway=new PaymentGateway(this.tick);
                            paymentGateway.show();
                            this.dispose();


                        }

                        System.out.printf("Selected row and column: %d %d%n%d", i, j, seatnum.size());
                   
                     }
                    catch (Exception ex) 
                    {
                        System.out.println("exception jjjj");
                     ex.printStackTrace();
                    }
                }
            }
        }
            
    }

}
