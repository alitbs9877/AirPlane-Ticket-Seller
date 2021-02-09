import java.time.LocalDate;
package ir.ac.kntu;

import java.util.ArrayList;
// بزرگتر بودن تاریخ

public class Main {
    public static ArrayList<Airline> airlines = new ArrayList<Airline>();
    public static ArrayList<Ticket> ticketBought = new ArrayList<Ticket>();


    public static ArrayList<Ticket> ticketCanceled = new ArrayList<Ticket>();

    public static Time now ;
    public static void main(String[] args) {
        System.out.println("please insert now time ");
        int year1= ScannerWrapper.getInstance().nextInt();
        int month1= ScannerWrapper.getInstance().nextInt();
        int day1= ScannerWrapper.getInstance().nextInt();
        int hour1= ScannerWrapper.getInstance().nextInt();
        int minute1= ScannerWrapper.getInstance().nextInt();
        now =  new Time (year1,month1,day1,hour1,minute1);

        showMainTable();
        int option = ScannerWrapper.getInstance().nextInt();
        while (option != 15 ){
            switchCase(option);
            showMainTable();
            option = ScannerWrapper.getInstance().nextInt(); ;


        }


    }
    public static void showMainTable (){
        System.out.println("welcome! Choose option :");
        System.out.println("1- Add Airline");
        System.out.println("2- Add Fly");

        System.out.println("3- Show airlines");
        System.out.println("4- Show flights");
        System.out.println("5- Search on fly ");
        System.out.println("6- Reserve ");
        System.out.println("7- Forget reserve");
        System.out.println("8- Buy ticket");

        System.out.println("9- Forget ticket");
        System.out.println("10- Show checklist");
        System.out.println("11-show flights by types");

        System.out.println("12-show chairs of a flight by types");

        System.out.println("13-show airline by type");

        System.out.println("14-show checklist just for perfessional ");
        System.out.println("15- Exit");
    }
    public static void switchCase(int option){
        switch (option){
            case 1:
                addAirline();

                break;
            case 2:
                addFly();

                break;
            case 3:
                showairlines();

                break;
            case 4:
                showflights();

                break;
             case 5:
                search();
                break;
            case 6:
                reserve();
                break;
            case 7:
                forgetReserve();
                break;
            case 8:
                buyTicket();
                break;
            case 9:
                forgrtTicket();
                break;
            case 10:
                showCheckList();
                break;
            case 11:
                showbyFlightType();
                break;
            case 12:
                showbyChairType();
                break;
            case 13:
                showAirlineType();
                break;
            case 14:
                showAirlineperfessional();
                break;

            default:
                System.out.println("Wrong key");
                break;
        }
    }
    public static void showAirlineperfessional(){
        System.out.println("insert name of airline");
        String name= ScannerWrapper.getInstance().next();
        for (int i=0; i < airlines.size();i++){
            if(name.equals(airlines.get(i).getName())){
                airlines.get(i).ShowCheckListPerfessional(ticketBought);
            }
        }
    }
    public static void addAirline(){
        System.out.println("please insert name of airline");
        String name = ScannerWrapper.getInstance().next();
        System.out.println("please insert number of airplane");
        int airpalne = ScannerWrapper.getInstance().nextInt();
        Airline airln ;
        System.out.println("please insert type of airline");
        System.out.println("1-perfessional");
        System.out.println("2-beginer");
        int option = ScannerWrapper.getInstance().nextInt();
        switch (option){
            case 1:
                airln=new Perfessional();
                break;
            case 2:
                airln=new Beginer();
                break;

            default:
                airln=new Beginer();
                break;

        }
        airln.setAirplane(airpalne);
        airln.setName(name);
        int b=0;
        for (int i=0 ; i<airlines.size(); i++) {
            if (airlines.get(i).getName().equals(name)) {

                System.out.println("this airline is exsited:))");
                b=1;
                break;
            }


        }

        if(b==0){
            airlines.add(airln);

            System.out.println("succesfuly added:))");

        }
    }
    public static void addFly(){
        System.out.println("please insert name of airline of Fly");
        int k=0;
        String nameAirplane = ScannerWrapper.getInstance().next();
        for (int i=0 ; i < airlines.size() ; i++){
            if (airlines.get(i).getName()== nameAirplane ){
              k=i;
              break;
            }
        }
        int num = 1000 + k;
        String help = String.format("%d", num);
        int num2 = airlines.get(k).getFly().size() +1000;
        String help2 = String.format("%d", num2);
        String numoffly = help + help2;
        System.out.println("please insert name of take off palce ");
        String takeoffplc = ScannerWrapper.getInstance().next();
        System.out.println("please insert name of landding palce ");
        String landdingplc = ScannerWrapper.getInstance().next();
        System.out.println("please insert name of take off date.first year,next month,day ,hour, last minute");
        int yeartak =ScannerWrapper.getInstance().nextInt();
        int monthtak =ScannerWrapper.getInstance().nextInt();
        int daytak =ScannerWrapper.getInstance().nextInt();
        int hourtak =ScannerWrapper.getInstance().nextInt();
        int mintak =ScannerWrapper.getInstance().nextInt();

         Time datetak = new Time(yeartak,monthtak,daytak,hourtak,mintak);
         if (now.bigger(datetak)){
             System.out.println("***alihaha");
         }
        System.out.println("please insert name of landding date.first year,next month, day ,hour, last minute");
        int yearlnd =ScannerWrapper.getInstance().nextInt();
        int monthlnd =ScannerWrapper.getInstance().nextInt();
        int daylnd =ScannerWrapper.getInstance().nextInt();

        int hourland =ScannerWrapper.getInstance().nextInt();
        int minland=ScannerWrapper.getInstance().nextInt();
       Time datelnd = new Time(yearlnd,monthlnd,daylnd,hourland,minland);
        System.out.println("please insert name of number of passenger");
        int passengers =ScannerWrapper.getInstance().nextInt();
        System.out.println("please insert name of price");
        String prices = ScannerWrapper.getInstance().next();
        Fly flys = new Fly(numoffly,takeoffplc,landdingplc,datetak,datelnd,passengers,prices);

        System.out.println(" what kind of Chair you want ?" );
        System.out.println(" 1-simple" );

        System.out.println(" 2-normal" );

        System.out.println(" 3-special" );
        int option= ScannerWrapper.getInstance().nextInt() ;
        FlyType typ;
        switch (option){
            case 1 :
                typ=FlyType.SIMPLE;
                break;

            case 2 :
                typ=FlyType.NORMAL;
                break;

            case 3 :
                typ=FlyType.SPECIAL;
                break;
            default:
                typ=FlyType.NORMAL;
        }

        flys.setType(typ);
        if (typ==FlyType.SIMPLE){
            flys.addChair(ChairType.ECONOMIC,passengers);

        }
        if (typ==FlyType.SPECIAL){
            flys.addChair(ChairType.SPECIAL,passengers);

        }
        if (typ==FlyType.NORMAL){
            System.out.println("please insert number of economic & special & comerical chair");
            //*****************
            // /***********
            // shart bezar
            int economic = ScannerWrapper.getInstance().nextInt() ;
            int special = ScannerWrapper.getInstance().nextInt();
            int comerical = ScannerWrapper.getInstance().nextInt();
            flys.addChair(ChairType.COMERICAL, comerical);
            flys.addChair(ChairType.SPECIAL,special);
            flys.addChair(ChairType.ECONOMIC,economic);

        }

        airlines.get(k).setFly(flys);
        System.out.println("succesfully added");
        System.out.println(flys.getNumOfFly());
    }
    public static void reserve() {
        System.out.println("please insert number of fly");
        String numfly = ScannerWrapper.getInstance().next();
        int k =0;
        int l=0;
        for (int i =0 ; i < airlines.size() ; i++){
            for (int j = 0 ; j<airlines.get(i).getFly().size() ; j++){
                if (airlines.get(i).getFly().get(i).getNumOfFly().equals(numfly) ){
                    k=i;
                    l=j;
                    break ;
                }
            }
        }
        System.out.println("please insert , first number of kids(<2) , next number of teenagers(<12) , last number of adult ");
        int kids = ScannerWrapper.getInstance().nextInt();
        int teenagers = ScannerWrapper.getInstance().nextInt();
        int adults = ScannerWrapper.getInstance().nextInt();
        if (airlines.get(k).getFly().get(l).getNumOfPassengerReverse() >  teenagers +adults) {
            airlines.get(k).getFly().get(l).addPassengerResserve( teenagers + adults);
            int helpnum = airlines.get(k).getFly().get(l).getNumOfPassengerReverse() + 100;
            for (int i = 0; i < kids; i++) {
                String help1 = airlines.get(k).getFly().get(l).getNumOfFly();

                String num = help1 + String.format("%d", helpnum) +"01" ;
                System.out.println("please insert first and last name of kids");
                String fnamekids = ScannerWrapper.getInstance().next();
                String lnamekids = ScannerWrapper.getInstance().next();
                Chair ch = new Chair(1800,ChairType.COMERICAL);
                Reserve reservs = new Reserve(num,fnamekids,lnamekids,ch,false);
                airlines.get(k).getFly().get(l).setreserve(reservs);

            }
            for (int i = 0; i < teenagers; i++) {
                String help1 = airlines.get(k).getFly().get(l).getNumOfFly();
                String num = help1 + String.format("%d", helpnum) +"02";
                System.out.println("please insert first and last name of teen");
                chairtyp(k,l,num);

                helpnum--;
            }
            for (int i = 0; i < adults; i++) {
                String help1 = airlines.get(k).getFly().get(l).getNumOfFly();
                String num = help1 + String.format("%d", helpnum) +"03";
                System.out.println("please insert first and last name of adult");
                chairtyp(k,l,num);

                helpnum--;
            }
        }
        // ***** مشکل سر تنظیم صندلی با بیلیط و رزرو
        else if (airlines.get(k).getFly().get(l).getExtra().size() > teenagers + adults) {
            for (int i = 0; i < kids; i++) {
                Reserve reservs = airlines.get(k).getFly().get(l).extrareserve();

                giveextrareserve(k,l,reservs,false);
///// hnja . name ........
            }
            for (int i = 0; i < teenagers; i++) {
                Reserve reservs =airlines.get(k).getFly().get(l).extrareserve();

                giveextrareserve(k,l,reservs,true);
            }
            for (int i = 0; i < adults; i++) {
                Reserve reservs = airlines.get(k).getFly().get(l).extrareserve();

                giveextrareserve(k,l,reservs,true);
            }
        }
        else {
            System.out.println("no capacity");
        }
    }
    public static void buychairtype(int k , int l , String num ,double cost ){

        String fnamekids = ScannerWrapper.getInstance().next();
        String lnamekids = ScannerWrapper.getInstance().next();

        System.out.println(" what kind of Cjhair you want ?" );
        System.out.println(" 1-economic" );

        System.out.println(" 2-comerical" );

        System.out.println(" 3-special" );
        int option= ScannerWrapper.getInstance().nextInt() ;
        ChairType typ=ChairType.ECONOMIC;
        switch (option){
            case 1 :
                typ=ChairType.ECONOMIC;
                break;

            case 2 :
                typ=ChairType.COMERICAL;
                break;

            case 3 :
                typ=ChairType.SPECIAL;
                break;

        }
        int chairNum;
        for(int o = airlines.get(k).getFly().get(l).getChair().size()-1 ; o >=0 ; o--){
            if (airlines.get(k).getFly().get(l).getChair().get(o).getType()==typ ){
                chairNum=airlines.get(k).getFly().get(l).getChair().get(o).getChairnumber();
                Chair ch= new Chair(chairNum,typ);
                airlines.get(k).getFly().get(l).deletchair(ch);
                cost =  cost * ch.getType().getNumber();
                Ticket ticks = new Ticket(num,fnamekids,lnamekids,cost,ch,true);
                airlines.get(k).getFly().get(l).setTicket( ticks );
                ticketBought.add(ticks);
                System.out.println("successful");
                break;
            }


        }
    }

    public static void giveextrareserve(int k , int l ,Reserve reservs,boolean b){
        String id = reservs.getId();
        Chair ch = reservs.getChair();
        Reserve ress ;

        System.out.println("please insert first and last name of kids");
        String fnam =airlines.get(k).getFly().get(l).getExtraTicket().get(0).getFname();
        String lnam = airlines.get(k).getFly().get(l).extraticket().getLname();
        ress = new Reserve(id,fnam,lnam,ch,b);

        airlines.get(k).getFly().get(l).deletchair(ch);
        airlines.get(k).getFly().get(l).setreserve(ress);


    }
    public static void chairtyp(int k , int l,String num){
        String fnamekids = ScannerWrapper.getInstance().next();
        String lnamekids = ScannerWrapper.getInstance().next();

        System.out.println(" what kind of Cjhair you want ?" );
        System.out.println(" 1-economic" );

        System.out.println(" 2-comerical" );

        System.out.println(" 3-special" );
        int option= ScannerWrapper.getInstance().nextInt() ;
        ChairType typ=ChairType.ECONOMIC;
        switch (option){
            case 1 :
                typ=ChairType.ECONOMIC;
                break;

            case 2 :
                typ=ChairType.COMERICAL;
                break;

            case 3 :
                typ=ChairType.SPECIAL;
                break;

        }
        int chairNum;
        for(int o = airlines.get(k).getFly().get(l).getChair().size()-1 ; o >=0 ; o--){
            if (airlines.get(k).getFly().get(l).getChair().get(o).getType()==typ ){
                chairNum=airlines.get(k).getFly().get(l).getChair().get(o).getChairnumber();
                Chair ch= new Chair(chairNum,typ);
                airlines.get(k).getFly().get(l).deletchair(ch);

                Reserve reservs = new Reserve(num,fnamekids,lnamekids,ch,true);
                airlines.get(k).getFly().get(l).setreserve(reservs);
                System.out.println("successful");
                break;
            }


        }
    }
    public static void showbyChairType(){
        System.out.println("insert number of flight");
        String numofFlight= ScannerWrapper.getInstance().next();
        int com=0,spc=0,enc=0;
        for (int i=0 ; i< airlines.size(); i++){
            for (int j=0 ; j <airlines.get(i).getFly().size();j++){
                if (airlines.get(i).getFly().get(j).getNumOfFly().equals(numofFlight)){
                    for (int h=0 ; h<airlines.get(i).getFly().get(j).getChair().size() ; h++ ){
                        Chair ch=airlines.get(i).getFly().get(j).getChair().get(h);
                        if(ch.getType()==ChairType.COMERICAL){
                            com++;
                        }
                        if(ch.getType()==ChairType.SPECIAL){
                            spc++;
                        }
                        if(ch.getType()==ChairType.ECONOMIC){
                            enc++;
                        }
                    }
                }
            }
        }
        System.out.println("there is "+ enc+ " enconomic chair &"+com+ " comerical chair &"+spc+ " special chair ");

    }
    public static void showbyFlightType(){
        ArrayList<String> simp= new ArrayList<String>();
        ArrayList<String> norm= new ArrayList<String>();
        ArrayList<String> spc= new ArrayList<String>();
        for (int i=0 ; i< airlines.size(); i++){
            for (int j=0 ; j <airlines.get(i).getFly().size();j++){
                if (airlines.get(i).getFly().get(j).getType()==FlyType.NORMAL){
                    norm.add(airlines.get(i).getFly().get(j).getNumOfFly());
                }
                if (airlines.get(i).getFly().get(j).getType()==FlyType.SIMPLE){
                    simp.add(airlines.get(i).getFly().get(j).getNumOfFly());
                }
                if (airlines.get(i).getFly().get(j).getType()==FlyType.SPECIAL){
                    spc.add(airlines.get(i).getFly().get(j).getNumOfFly());
                }
            }
        }
        System.out.println("this list is simple flight ");
        for (int i=0; i < simp.size(); i++){
            System.out.println(simp.get(i));
        }
        System.out.println("this list is normal flight ");
        for (int i=0; i < norm.size(); i++){
            System.out.println(norm.get(i));
        }

        System.out.println("this list is special flight ");
        for (int i=0; i < spc.size(); i++){
            System.out.println(spc.get(i));
        }
    }
    public static void showAirlineType(){
        System.out.println("list of perfessional");
        for (int i =0 ; i < airlines.size(); i++){
            if (airlines.get(i) instanceof Perfessional){
                System.out.println(airlines.get(i));
            }
        }
        System.out.println("list of beginer");
        for (int i =0 ; i < airlines.size(); i++){
            if (airlines.get(i) instanceof Beginer){
                System.out.println(airlines.get(i));
            }
        }
    }
    public static void forgetReserve(){
        System.out.println("please insert reserve number");
        String numReserve = ScannerWrapper.getInstance().next();
        for (int i =0 ; i < airlines.size() ; i++){
            for (int j = 0 ; j< airlines.get(i).getFly().size() ; j++){
                for (int c = 0 ; c< airlines.get(i).getFly().get(j).getreserve().size() ; c++){
                    if (airlines.get(i).getFly().get(j).getreserve().get(c).equals(numReserve)){
                        Reserve res = airlines.get(i).getFly().get(j).getreserve().get(c);
                        Chair ch =res.getChair();
                        airlines.get(i).getFly().get(j).deletchairbought(ch);
                        airlines.get(i).getFly().get(j).deleteReserve(res);
                        airlines.get(i).getFly().get(j).setExtra(res);
                        break;

                    }
                }

            }
        }
    }
    public static void  buyTicket(){
        System.out.println("if you want buy by reserve number , insert 1 , and sepratly , insert 2");
        int option = ScannerWrapper.getInstance().nextInt();
        switch (option){
            case 1 :
                buyReservely();
                break;
            case 2:
                buySeprate();
                break;
            default:
                System.out.println("Wrong key");
                break;
        };
    }
    public static void buySeprate(){
        System.out.println("please insert number of fly");
        String numfly = ScannerWrapper.getInstance().next();
        int k =0;
        int l=0;
        for (int i =0 ; i < airlines.size() ; i++){
            for (int j = 0 ; j<airlines.get(i).getFly().size() ; j++){
                if (airlines.get(i).getFly().get(i).getNumOfFly().equals(numfly) ){
                    k=i;
                    l=j;
                    break ;
                }
            }
        }
        System.out.println("please insert , first number of kids(<2) , next number of teenagers(<12) , last number of adult ");
        int kids = ScannerWrapper.getInstance().nextInt();
        int teenagers = ScannerWrapper.getInstance().nextInt();
        int adults = ScannerWrapper.getInstance().nextInt();
        if (airlines.get(k).getFly().get(l).getNumOfPassenger() >  teenagers +adults) {
            airlines.get(k).getFly().get(l).addPassengerTicket( teenagers + adults);
            int helpnum = airlines.get(k).getFly().get(l).getNumOfPassenger() + 100;
            for (int i = 0; i < kids; i++) {
                String help1 = airlines.get(k).getFly().get(l).getNumOfFly();
                String costs = airlines.get(k).getFly().get(l).getPrice();
                double cost=(double) Integer.parseInt(costs);
                cost = cost * (0.2);
                String num = help1 + String.format("%d", helpnum) +"019" ;
                System.out.println("please insert first and last name of kids");
                String fnamekids = ScannerWrapper.getInstance().next();
                String lnamekids = ScannerWrapper.getInstance().next();

                Chair ch = new Chair(1800,ChairType.COMERICAL);
                Ticket ticks = new Ticket(num,fnamekids,lnamekids,cost,ch,false);
                airlines.get(k).getFly().get(l).setTicket( ticks );
                ticketBought.add(ticks);






            }
            for (int i = 0; i < teenagers; i++) {
                String help1 = airlines.get(k).getFly().get(l).getNumOfFly();

                String num = help1 + String.format("%d", helpnum) +"029";
                System.out.println("please insert first and last name of teen");
                String costs = airlines.get(k).getFly().get(l).getPrice();
                double cost= (double)Integer.parseInt(costs);
                cost = cost * (0.5);
                buychairtype(k,l,num,cost);
                helpnum--;
            }
            for (int i = 0; i < adults; i++) {
                String help1 = airlines.get(k).getFly().get(l).getNumOfFly();
                String num = help1 + String.format("%d", helpnum) +"039";
                System.out.println("please insert first and last name of adult");
                String costs = airlines.get(k).getFly().get(l).getPrice();
                double cost=(double) Integer.parseInt(costs);

                buychairtype(k,l,num,cost);
                helpnum--;
            }
        }
        else if (airlines.get(k).getFly().get(l).getExtraTicket().size() > kids+teenagers + adults) {
            for (int i = 0; i < kids; i++) {
                giveticketExtra( k ,  l,false,0.2);

            }
            for (int i = 0; i < teenagers; i++) {
                giveticketExtra( k ,  l,true,0.5);
            }
            for (int i = 0; i < adults; i++) {
                giveticketExtra( k ,  l,true,1);
            }
        }
        else {
            System.out.println("no capacity");
        }

    }
    public static void giveticketExtra(int k , int l,boolean b,double factor){
        String id = airlines.get(k).getFly().get(l).getExtraTicket().get(0).getId();

        Chair ch  = airlines.get(k).getFly().get(l).getExtraTicket().get(0).getChair();
        System.out.println("please insert first and last name of kids");
        String fnam =airlines.get(k).getFly().get(l).getExtraTicket().get(0).getFname();
        String lnam = airlines.get(k).getFly().get(l).extraticket().getLname();
        double cost = (double)(Integer.parseInt(airlines.get(k).getFly().get(l).getPrice() )  *factor );
        //*****************
        cost = cost*ch.getType().getNumber();

        airlines.get(k).getFly().get(l).deletchair(ch);
        Ticket ticks = new Ticket(id,fnam,lnam,cost,ch,b);

        airlines.get(k).getFly().get(l).setTicket(ticks);

        ticketBought.add(ticks);

    }
    public static void forgrtTicket(){
        System.out.println("please insert ticket number");
        String numticket = ScannerWrapper.getInstance().next();
        for (int i =0 ; i < airlines.size() ; i++){
            for (int j = 0 ; j< airlines.get(i).getFly().size() ; j++){
                for (int c = 0 ; c< airlines.get(i).getFly().get(j).getticket().size() ; c++){
                    if (airlines.get(i).getFly().get(j).getticket().get(c).equals(numticket)){
                        Ticket tic = airlines.get(i).getFly().get(j).getticket().get(c);
                        Chair ch =tic.getChair();
                        airlines.get(i).getFly().get(j).deletchairbought(ch);
                        airlines.get(i).getFly().get(j).deleteTicket(tic);
                        airlines.get(i).getFly().get(j).setExtraTick(tic);
                        double cost = (double)(Integer.parseInt(airlines.get(i).getFly().get(j).getPrice()) /10 );
                        cost = cost*ch.getType().getNumber();
                        tic.setCost(cost);
                        ticketCanceled.add(tic);
                        break;

                    }
                }

            }
        }
    }
    public static void buyReservely(){
        System.out.println("please insert reserve number");
        String numReserve = ScannerWrapper.getInstance().next();
        for (int i =0 ; i < airlines.size() ; i++){
            for (int j = 0 ; j< airlines.get(i).getFly().size() ; j++){
                for (int c = 0 ; c< airlines.get(i).getFly().get(j).getreserve().size() ; c++){
                    if (airlines.get(i).getFly().get(j).getreserve().get(c).equals(numReserve)){
                        Reserve res = airlines.get(i).getFly().get(j).getreserve().get(c);
                        String numofticket;
                        String fname = res.getFname();
                        String lname = res.getLname();
                        String help = res.getId();
                        Chair ch = res.getChair();
                        double cost=(double)(Integer.parseInt(airlines.get(i).getFly().get(j).getPrice() ) );
                        int size= help.length();
                        int base =help.charAt(size-1)-'0';
                        boolean haveChair=true ;
                        if (base ==1){
                            haveChair = false;
                            cost = (double)(Integer.parseInt(airlines.get(i).getFly().get(j).getPrice() )  /10);
                        }
                        if (base ==2){
                            haveChair =true;
                            cost = (double)(Integer.parseInt(airlines.get(i).getFly().get(j).getPrice() )  /2);
                        }
                        if (base ==3){
                            haveChair=true;
                            cost = (double)(Integer.parseInt(airlines.get(i).getFly().get(j).getPrice() )  );
                        }
                        cost= cost*ch.getType().getNumber();
                        numofticket = help + "9";
                        Ticket tic = new Ticket(numofticket,fname,lname, cost,ch,haveChair);

                        airlines.get(i).getFly().get(j).deletchair(ch);
                        airlines.get(i).getFly().get(j).setTicket(tic);
                        ticketBought.add(tic);
                        break;

                    }
                }

            }
        }
    }


    public static void search(){

        System.out.println("insert take off place ");
        String takplc = ScannerWrapper.getInstance().nextline();
        System.out.println("insert landding place ");
        String lndplc = ScannerWrapper.getInstance().nextline();
        System.out.println("insert take off1 first year,next month,day,hour,minute ");
        String takyr1= ScannerWrapper.getInstance().nextline();
        String takmnth1= ScannerWrapper.getInstance().nextline();
        String takdy1= ScannerWrapper.getInstance().nextline();
        String takhr1= ScannerWrapper.getInstance().nextline();
        String takmin1= ScannerWrapper.getInstance().nextline();
        System.out.println("insert take off2 first year,next month,day,hour,minute ");
        String takyr2= ScannerWrapper.getInstance().nextline();
        String takmnth2= ScannerWrapper.getInstance().nextline();
        String takdy2= ScannerWrapper.getInstance().nextline();
        String takhr2= ScannerWrapper.getInstance().nextline();
        String takmin2= ScannerWrapper.getInstance().nextline();
        System.out.println("insert landding time1 first year,next month,day,hour,minute");
        String lndyr1= ScannerWrapper.getInstance().nextline();
        String lndmnth1= ScannerWrapper.getInstance().nextline();
        String lnddy1= ScannerWrapper.getInstance().nextline();
        String lndhr1= ScannerWrapper.getInstance().nextline();
        String lndmin1= ScannerWrapper.getInstance().nextline();

        System.out.println("insert landding time2 first year,next month,day,hour,minute");
        String lndyr2= ScannerWrapper.getInstance().nextline();
        String lndmnth2= ScannerWrapper.getInstance().nextline();
        String lnddy2= ScannerWrapper.getInstance().nextline();
        String lndhr2= ScannerWrapper.getInstance().nextline();
        String lndmin2= ScannerWrapper.getInstance().nextline();
        System.out.println("insert free capacity ");
        String freecpcty = ScannerWrapper.getInstance().nextline();
        System.out.println("insert airline agency ");
        String airlin= ScannerWrapper.getInstance().nextline();
        if(takplc.length() == 0)
        {
            takplc = null;

        }
        if(lndplc.length() == 0)
        {
            lndplc = null;

        }
        if(freecpcty.length() == 0)
        {
            freecpcty = null;

        }
        if(airlin.length() == 0)
        {
            airlin= null;

        }
        System.out.println("choose Type of chair of flight ");

        System.out.println("1-economic ");

        System.out.println("2-comerical ");

        System.out.println("3-special ");

        System.out.println("0-not important ");
        int option1 = ScannerWrapper.getInstance().nextInt();
        ChairType  chtype =ChairType.ECONOMIC;
        switch (option1){
            case 1:
                chtype=ChairType.ECONOMIC;
                break;

            case 2:
                chtype=ChairType.COMERICAL;
                break;

            case 3:
                chtype=ChairType.SPECIAL;
                break;

            case 0:

                break;
        }
        System.out.println("choose Type of flight ");

        System.out.println("1-simple ");

        System.out.println("2-normal ");

        System.out.println("3-special ");

        System.out.println("0-not important ");
        int option = ScannerWrapper.getInstance().nextInt();
        FlyType flyType=FlyType.NORMAL;
        switch (option){
            case 1:
                flyType=FlyType.SIMPLE;
                break;

            case 2:
                flyType=FlyType.NORMAL;
                break;

            case 3:
                flyType=FlyType.SPECIAL;
                break;

            case 0:

                break;
        }
        System.out.println("choose Type of Airline ");

        System.out.println("1-beginer ");

        System.out.println("2-perfessional ");

        System.out.println("0-not important ");
        int option2 = ScannerWrapper.getInstance().nextInt();


        Time timeTak1 = checkEmptyTime(takyr1,takmnth1,takdy1,takhr1,takmin1);
        Time timeTak2 = checkEmptyTime(takyr2,takmnth2,takdy2,takhr2,takmin2);
        Time timelnd1 = checkEmptyTime(lndyr1,lndmnth1,lnddy1,lndhr1,lndmin1);
        Time timelnd2 = checkEmptyTime(lndyr2,lndmnth2,lnddy2,lndhr2,lndmin2);



        for (int i = 0 ; i < airlines.size() ; i++){
            for (int j =0 ; j < airlines.get(i).getFly().size() ; j ++){

                if ((emptyVariable(takplc) || airlines.get(i).getFly().get(j).getTakeOffPlace().equals(takplc)) &&
                        (emptyVariable(lndplc) || airlines.get(i).getFly().get(j).getLanddingPlace().equals(lndplc)) &&
                        (emptyVariable(freecpcty) || airlines.get(i).getFly().get(j).getNumOfPassenger()== Integer.parseInt(freecpcty) ) &&
                        (emptyVariable(airlin) || airlines.get(i).getName().equals(airlin)) &&
                        (checkDate(timeTak1)|| airlines.get(i).getFly().get(j).getTakeOffDate().bigger(timeTak1) )&&
                        (checkDate(timeTak2)||timeTak2.bigger(airlines.get(i).getFly().get(j).getTakeOffDate()) ) &&
                        (checkDate(timelnd1)||airlines.get(i).getFly().get(j).getLanddingDate().bigger(timelnd1) )&&
                        (checkDate(timelnd2)||timelnd2.bigger(airlines.get(i).getFly().get(j).getLanddingDate()) ) &&
                        (emptyType(option)|| airlines.get(i).getFly().get(j).getType()==flyType) &&
                        (emptyType(option1 )|| checkChairtype(i,j,chtype)) &&
                        (emptyType(option2) || checkTypeAirline(option2,i))
                        ){
                    System.out.println(airlines.get(i).getFly().get(j));
                }
            }
        }
    }
    public static boolean checkDate(Time time){
        Time time0= new Time(now.getYear(),now.getMonth(),now.getDay(),now.getHour(),now.getMinute());
        if (time.equals(time0)){
            return true;

        }
        return false;
    }
    public static boolean checkTypeAirline(int m,int i) {
        if (m==1){
            if(airlines.get(i) instanceof Perfessional){
                return true;
            }
        }
        if (m==2){
            if(airlines.get(i) instanceof Beginer){
                return true;
            }
        }
        return false ;

    }
    public static boolean checkChairtype (int i , int j , ChairType chtyp){
        for (int o=0; o < airlines.get(i).getFly().get(j).getChair().size() ; o++){
            if (airlines.get(i).getFly().get(j).getChair().get(o).getType()==chtyp){
                return true;
            }
        }
        return false ;
    }
    public static boolean emptyVariable( String variable) {
        if (variable==null ){
            return true ;
        }
        return false;
    }
    public static boolean emptyType(int m){
        if (m == 0) {

            return true ;
        }
        return false;
    }
    public static void showCheckList(){
        int counter = 0;
        int m=1 ;
        for (int i=0 ; i <ticketBought.size() ; i ++  ){
            System.out.println(ticketBought.get(i));
            counter++;
            if (counter%30==0){

                System.out.println("do you wnat to continue? 1-yes  , oher number-no");
                 m = ScannerWrapper.getInstance().nextInt();
                if (m==1){
                    continue;
                }
                else{
                    break;
                }
            }
        }
        if (m==1) {
            for (int i = 0; i < ticketCanceled.size(); i++) {
                System.out.println(ticketCanceled.get(i));
                counter++;
                if (counter % 30 == 0) {

                    System.out.println("do you wnat to continue? 1-yes  , oher number-no");
                    m = ScannerWrapper.getInstance().nextInt();
                    if (m == 1) {
                        continue;
                    } else {
                        break;
                    }
                }
            }
        }
    }
    public static void showairlines(){
        for (int i=0 ; i< airlines.size(); i++){
            System.out.println(airlines);
        }
    }
    public static void showflights(){
        for (int i=0 ; i< airlines.size(); i++){
            for (int j=0 ; j <airlines.get(i).getFly().size();j++){
                System.out.println(airlines.get(i).getFly().get(j));
            }
        }
    }
    public static Time checkEmptyTime(String year,String  month ,String  day,String hour,String minute){
        int yaer1,month1,day1,hour1,minute1;
        if(year.length() == 0)
        {
            yaer1=now.getYear();

        }
        else {
            yaer1 = Integer.parseInt(year);
        }
        if(month.length() == 0)
        {
            month1=now.getMonth();

        }
        else {
            month1= Integer.parseInt(month);
        }
        if(day.length() == 0)
        {
            day1=now.getDay();

        }
        else {
            day1= Integer.parseInt(day);
        }
        if(hour.length() == 0)
        {
            hour1 =now.getHour();

        }
        else {
            hour1=Integer.parseInt( hour);
        }
        if(minute.length() == 0)
        {
            minute1=now.getMinute();

        }
        else {
            minute1=Integer.parseInt( minute);
        }
        return new Time(yaer1,month1,day1,hour1,minute1);
    }
}
//  sort
//
// hashfunction
//cryptography hashfunction
//search use boolean for shart:)
