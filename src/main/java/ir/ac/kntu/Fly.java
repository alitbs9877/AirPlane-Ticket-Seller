package ir.ac.kntu;

import java.util.ArrayList;
enum FlyType{
    SIMPLE , NORMAL ,SPECIAL
}
public class Fly{
    private FlyType type;
    private ArrayList<Reserve> reserve1;
    private ArrayList<Reserve> reserved;
    private ArrayList<Ticket> ticket1;
    private ArrayList<Chair> chair ;
    private ArrayList<Chair> chairbought;

    private ArrayList<Ticket> ticketd;
    private String numOfFly;
    private String takeOffPlace;
    private String landdingPlace;
    private Time takeOffDate;
    private Time landdingDate;
    private int numOfPassenger;
    private int numOfResservePassenger;
    private String price;
    public Fly( String numOfFly,String takeOffPlace,String landdingPlace,
                Time takeOffDate, Time landdingDate,
                int numOfPassenger,String price){
        this.numOfFly=numOfFly;
        this.takeOffPlace= takeOffPlace;
        this.takeOffDate= takeOffDate;
        this.landdingPlace= landdingPlace;
        this.landdingDate=landdingDate;
        this.numOfPassenger= numOfPassenger;
        this.price=price;
        this.numOfResservePassenger=numOfPassenger;
        reserved =new ArrayList<Reserve>();
        reserve1 =new ArrayList<Reserve>();
        ticket1 =new ArrayList<Ticket>();
        ticketd =new ArrayList<Ticket>();

        chair =new ArrayList<Chair>();

        chairbought =new ArrayList<Chair>();
    }

    public void setType(FlyType typ){
        this.type=typ;
    }

    public FlyType getType(){
        return type;
    }
    public void addChair(ChairType type, int num1 ){
        Chair chair1;
        for (int i=0 ; i < num1+1 ; i ++ ){
             chair1= new Chair(i,type);
             if (chair1!=null) {
                 System.out.println("okeyeke");
             }
             chair.add(chair1);
        }
    }
    public ArrayList<Chair> getChair(){

        return chair;
    }
    public ArrayList<Chair> getChairbought(){

        return chairbought;
    }

    public void deletchair(Chair chair1){
        for (int i=0 ; i < chair.size(); i++ ){
            if (chair.get(i).equals(chair1)){

                chairbought.add(chair.get(i));
                chair.remove(i);
            }
        }

    }
    public void deletchairbought(Chair chair1){
        for (int i=0 ; i < chairbought.size(); i++ ){
            if (chairbought.get(i).equals(chair1)){

                chair.add(chairbought.get(i));
                chairbought.remove(i);
            }
        }

    }





    public ArrayList<Ticket> getExtraTicket() {
        return ticket1;
    }
    public Ticket extraticket(){
        Ticket tic= ticket1.get(0);
        ticket1.remove(0);
        return tic;
    }
    public void  deleteTicket(Ticket tic){

        for(int i=0; i< ticketd.size(); i++) {
            if (ticketd.get(i).equals(tic)) {
                ticketd.remove(i);
                break;
            }
        }

    }
    public ArrayList<Ticket> getticket() {
        return ticketd;
    }
    public void setTicket(Ticket resrv){
        ticketd.add(resrv);
    }
    public void setExtraTick(Ticket resrv){//when forget reserve
        ticket1.add(resrv);
    }


    public ArrayList<Reserve> getExtra() {
        return reserve1;
    }
    public Reserve extrareserve(){
        Reserve res= reserve1.get(0);
        reserve1.remove(0);
        return res;
    }
    public void  deleteReserve(Reserve res){

        for(int i=0; i< reserved.size(); i++) {
            if (reserved.get(i).equals(res)) {
                reserved.remove(i);
                break;
            }
        }

    }
    public ArrayList<Reserve> getreserve() {
        return reserved;
    }
    public void setreserve(Reserve resrv){
        reserved.add(resrv);
    }
    public void setExtra(Reserve resrv){//when forget reserve
        reserve1.add(resrv);
    }
    public String getNumOfFly() {
        return numOfFly;
    }
    public String getTakeOffPlace(){
        return takeOffPlace;
    }
    public String getLanddingPlace() {
        return landdingPlace;
    }
    public Time getTakeOffDate(){
        return takeOffDate;
    }
    public Time getLanddingDate(){
        return landdingDate;
    }
    public int getNumOfPassenger(){
        return numOfPassenger;
    }
    public int getNumOfPassengerReverse(){
        return numOfResservePassenger;
    }
    public String getPrice(){
        return price;
    }
    public void addPassengerResserve(int i){
        numOfResservePassenger = numOfResservePassenger -i;
    }
    public void forgetreserve(int i){
        numOfResservePassenger ++;
    }
    public void addPassengerTicket(int i){
         numOfPassenger = numOfPassenger -i ;
    }
    public void forgetTicket(int i){
        numOfPassenger ++;
    }

    public boolean equals(Fly flight) {
        if (this == flight) {
            return true;
        }
        if (this.landdingDate.equals(flight.landdingDate) &&
                this.landdingPlace == flight.landdingPlace &&
                this.numOfFly == flight.numOfFly &&
                this.takeOffDate.equals(flight.takeOffDate) &&
                this.takeOffPlace== flight.takeOffPlace) {
            return true;
        }
        return false;
    }
    //*************************************
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + numOfFly.hashCode();
        result = prime * result + numOfPassenger;
        result = prime * result + numOfResservePassenger ;
        result = prime * result + price.hashCode();
        result = prime * result + takeOffPlace.hashCode();

        result = prime * result + landdingPlace.hashCode();

        return result;
    }
    //*******************
    public String toString() {
        return " this flight with " + numOfFly + "number flight , will go from  " + takeOffPlace +"at " + takeOffDate + "to " +
                landdingPlace + "and will arrive at " + landdingDate +" that that price for every one is " +price + " , has " + numOfPassenger + "free chair .";
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Fly other = (Fly) obj;
        if (landdingPlace != other.landdingPlace)
            return false;
        if (takeOffPlace != other.takeOffPlace)
            return false;

        if (!takeOffDate.equals(other.takeOffDate))
            return false;

        if (!landdingDate.equals(other.landdingDate))
            return false;
        if (numOfFly != other.numOfFly)
            return false;
        return true;
    }

}
