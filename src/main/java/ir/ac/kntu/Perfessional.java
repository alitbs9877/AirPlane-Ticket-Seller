
package ir.ac.kntu;
import java.util.ArrayList;

public class Perfessional extends Airline {

    public Perfessional(){
        super();
    }
    @Override
    public void ShowCheckListPerfessional(ArrayList<Ticket> ticketArrayList){
        System.out.println("this is list of bought");
        for (int i=0 ; i < this.getFly().size(); i ++){
            for(int j =0 ; j < this.getFly().get(i).getticket().size(); j ++){
                System.out.println("ticket:" +this.getFly().get(i).getticket().get(j) +"in flight :"+this.getFly().get(i) );
            }
        }
        System.out.println("this is list of canceled ticket ");
        for (int i=0 ; i < this.getFly().size(); i ++){
            for(int j =0 ; j < this.getFly().get(i).getExtraTicket().size(); j ++){
                System.out.println("ticket:" +this.getFly().get(i).getExtraTicket().get(j) +"in flight :"+this.getFly().get(i) );
            }
        }
        System.out.println("price of every flight");
        int sum=0 , mainsum=0;
        System.out.println("from canceled ticket");
        for (int i=0 ; i < this.getFly().size(); i ++){
            for(int j =0 ; j < this.getFly().get(i).getExtraTicket().size(); j ++){
                String costs = this.getFly().get(i).getPrice();
                double cost=(double) Integer.parseInt(costs);
                sum+=(cost/10);
            }
            System.out.println(sum);
            mainsum+=sum;
        }

        System.out.println("from bought ticket");
        for (int i=0 ; i < this.getFly().size(); i ++){
            for(int j =0 ; j < this.getFly().get(i).getticket().size(); j ++){

                double cost = this.getFly().get(i).getticket().get(j).getCost();
                sum+=cost;
            }
            System.out.println(sum);
            mainsum+=sum;
        }
        System.out.println("final price :"+ mainsum);

    }

}
