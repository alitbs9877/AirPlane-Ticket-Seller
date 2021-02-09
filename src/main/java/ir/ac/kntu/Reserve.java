package ir.ac.kntu;

import java.util.Objects;

public class Reserve {
    private String id;
    private String fname;
    private String lname;
    private Chair chair;
    private boolean ischair;
    public Reserve(String id, String fname, String lname,Chair chair,boolean ischair) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.ischair= ischair;
        if (ischair){
            setChair(chair);
        }
    }
    public void setChair(Chair ch){
        this.chair=ch;
    }
    public String getId() {
        return id;
    }
    public Chair getChair(){
        if (ischair)
        return chair;
        System.out.println("not found");
        return null;
    }
    public String getFname() {
        return fname;
    }
/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserve reserve = (Reserve) o;
        return Objects.equals(id, reserve.id) &&
                Objects.equals(fname, reserve.fname) &&
                Objects.equals(lname, reserve.lname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, fname, lname);
    }
*/
    public String getLname() {
        return lname;
    }
    public boolean equals(Reserve res) {
        if (this == res) {
            return true;
        }
        if (this.id == res.id &&
                this.fname == res.fname &&
                this.lname == res.lname) {
            return true;
        }
        return false;
    }
    //*************************************
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + fname.hashCode();
        result = prime * result + lname.hashCode();
        result = prime * result + id.hashCode();

        return result;
    }
//*******************
public String toString() {
    return   "reserve :" + fname + " " +   lname+ "-" + id ;
}

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Reserve other = (Reserve) obj;
        if (id != other.id)
            return false;
        if (fname != other.fname)
            return false;
        if (lname != other.lname)
            return false;
        return true;
    }

}
