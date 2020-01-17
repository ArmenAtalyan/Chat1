package model;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {

        private int id;
        private String name;
        private String text;
        Format f = new SimpleDateFormat("mm-dd-yyyy hh:mm:ss");

        public User(){}

    public User(int id, String name, String text) {
        this.id = id;
        this.name = name;
        this.text = text;
    }

    public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void printMassage(){
            System.out.println(f.format(new Date()) + "  :" + "member " + id + "\n" + name + ": " + text);
        }
}
