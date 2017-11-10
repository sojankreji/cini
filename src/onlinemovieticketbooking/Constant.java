/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinemovieticketbooking;

import java.util.ArrayList;

/**
 *
 * @author Cyber
 */
public class Constant {
    public static String adminId;
    public  static  String movieid;
     public  static  String name; public  static  String mob;
      public  static  String email;
      public  static  String totalrate;
        public  static  String imgurl;
    public  static  String theatrename;
    public  static  String moviename;
    public  static  String userid;
    public  static  String showtimings;
    public  static  String showdates;
    public  static  String balconyrate;
    public  static  String normalrate;
    public  static  String nooftickets;
       public  static  ArrayList<String>a;
     public  static  String bookingdate;
        public  static  String  TheatreId;
     
     public  String pos(int p){
         String a="";
         switch(p){
         case 1:a=0+"-"+0;
             break;
         case 2:a= 0+"-"+1;
         break;
         case 3:a= 0+"-"+2;
         break;
          case 4:a= 0+"-"+3;
         break;
         case 5:a= 1+"-"+0;
         break;
         case 6:a= 1+"-"+1;
         break;
         case 7:a= 1+"-"+2;
         break;
         
          case 8:a= 1+"-"+3;
         break;
           case 9:a= 2+"-"+0;
         break;
         case 10:a= 2+"-"+1;
         break;
           case 11:a= 2+"-"+2;
         break;
           case 12:a= 2+"-"+3;
         break;
           case 13:a= 3+"-"+0;
         break;
           case 14:a= 3+"-"+1;
         break;
           case 15:a= 3+"-"+2;
         break;
           case 16:a= 3+"-"+3;
         break;
         }
      return  a;
     }
     
     
     
     public static void clearall(){
       
         movieid="";
       
         totalrate="";
         imgurl="";
         theatrename="";
         moviename="";
     
         showdates="";
         showtimings="";
         balconyrate="";
         normalrate="";
         nooftickets="";
         a=new ArrayList<>();
         bookingdate="";
         TheatreId="";
         
     }
     
     
     
}