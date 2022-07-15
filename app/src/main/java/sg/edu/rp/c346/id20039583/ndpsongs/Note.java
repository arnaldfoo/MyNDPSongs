package sg.edu.rp.c346.id20039583.ndpsongs;

import java.io.Serializable;

public class Note implements Serializable {


    private 	int id;
    private 	String title;
    private     String singers;


    public Note( int id, String title , String singers  ) {
        this.id = id;
        this.title = title;
        this.singers = singers;
    }

    public Note(int id, String song) {
    }

    public int getId() {  return id;  }

    public String getTitle() { return title; }

    public String getSingers() { return singers; }

    public void settitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() { return "ID:" + id + ", " + title;  }






}


