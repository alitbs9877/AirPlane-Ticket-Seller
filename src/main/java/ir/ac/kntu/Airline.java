import java.util.ArrayList;
package ir.ac.kntu;

public class Airline{
    private ArrayList<Fly> fly;
    private String name;
    private int airpalne;
    public Airline(){

        fly = new ArrayList<Fly>();
    }
    public void setFly (Fly flys){
        fly.add(flys);
    }
    public void setName(String name){
        this.name = name ;
    }
    public void setAirplane( int i){

        airpalne=i;
    }
    public void ShowCheckListPerfessional(ArrayList<Ticket> ticketArrayList){

    }
    public ArrayList<Fly> getFly(){
        return fly;
    }

    public int getAirpalne(){
        return airpalne;
    }

    public String getName(){
        return name;
    }

    public boolean equals(Airline airln) {
        if (this == airln) {
            return true;
        }
        if (this.name== airln.name &&
                this.airpalne == airln.airpalne &&
                equalarray(this.fly , airln.fly)) { //*******
            return true;
        }
        return false;
    }
    public boolean equalarray(ArrayList<Fly>  fly1 , ArrayList<Fly> fly2){
        for (int i=0 ; i<fly1.size() ; i++){
            if (!fly1.get(i).equals(fly2.get(i))){
                return false;
            }
        }
        return true;
    }
    //*************************************
    public int hashCode() {
        final int prime = 101;
        int result = 1;
        result = prime * result + airpalne;
        result = prime * result + name.hashCode();
        return result;
    }
    //*******************
    public String toString() {
        return name  + "airline  have " +  airpalne  + "airplanes";
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Airline other = (Airline) obj;
        if (name .equals( other.name))
            return false;
        if (airpalne != other.airpalne)
            return false;
        if (equalarray(fly , other.fly ))
            return false;
        return true;
    }
}
