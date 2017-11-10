


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinemovieticketbooking;

/**
 *
 * @author Cyber
 */
public class Tablemodel {
    String id;
    String name;
    String place;
     String movie;
     String movieId;
    String manid;
    String mobile;
    String timings;
    String dates;
    String balconyrate;
    String normalrate;
    String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Tablemodel(String Dates,String Mid,String id, String name, String place,  String mobile, String timings, String balconyrate, String normalrate,String img,String movie) {
        this.id = id;
        this.name = name;
        this.dates=Dates;
        this.place = place;
        //this.manid = manid;
        this.mobile = mobile;
        this.timings = timings;
        this.balconyrate = balconyrate;
        this.normalrate = normalrate;
        this.img=img;
        this.movie=movie;
        this.movieId=Mid;
    }

    public String getBalconyrate() {
        return balconyrate;
    }

    public void setBalconyrate(String balconyrate) {
        this.balconyrate = balconyrate;
    }

    public String getNormalrate() {
        return normalrate;
    }

    public void setNormalrate(String normalrate) {
        this.normalrate = normalrate;
    }

  

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getManid() {
        return manid;
    }

    public void setManid(String manid) {
        this.manid = manid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTimings() {
        return timings;
    }

    public void setTimings(String timings) {
        this.timings = timings;
    } 
    
    public String getDAtes() {
        return dates;
    }

    public void setDates(String timings) {
        this.dates = timings;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }
     public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movie) {
        this.movieId = movie;
    }
    
    
    
    
}
