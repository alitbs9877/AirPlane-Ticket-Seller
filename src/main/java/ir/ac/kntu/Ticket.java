package ir.ac.kntu;

public class Ticket {
    private String id ;
    private String fname ;
    private String lname ;

    private Chair chair;
    private boolean ischair;
    private double cost ;
    public  Ticket(String id,String fname , String lname,double cost,Chair chair,boolean ischair){
            this.id =id;
            this.fname=fname;
        this.cost = cost;
            this.lname=lname;
        this.ischair= ischair;
        if (ischair){
            setChair(chair);
        }
        }
    public void setChair(Chair ch){
        this.chair=ch;
    }

    public Chair getChair(){
        if (ischair)
            return chair;
        System.out.println("not found");
        return null;
    }
    public String getId(){
        return id;
        }
    public String getFname(){
        return fname;
    }
    public String getLname(){
        return lname;
    }
    public double getCost(){
        return cost;
    }
    public void setCost(Double cst){
        cost=cst;
    }

    public boolean equals(Ticket tic) {
        if (this == tic) {
            return true;
        }
        if (this.id == tic.id &&
                this.fname == tic.fname &&
                this.lname == tic.lname) {
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
        return "ticket : " + fname + " " +   lname+ "-" + id +"  " +cost +"$";
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ticket other = (Ticket) obj;
        if (id != other.id)
            return false;
        if (fname != other.fname)
            return false;
        if (lname != other.lname)
            return false;
        return true;
    }

}
