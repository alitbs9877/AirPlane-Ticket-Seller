package ir.ac.kntu;

enum ChairType {
    ECONOMIC(1),SPECIAL(1.2),COMERICAL(1.1);
    private double number;
    ChairType(double number){

        this.number=number;
    }
    public double getNumber(){
        return number;
    }
}
public class Chair {
    private ChairType type ;
    private int chairnumber;

    public Chair(int num,ChairType type){
        this.type = type ;
        this.chairnumber= num;

    }
    public int getChairnumber(){
        return chairnumber;
    }
    public ChairType getType(){
        return type;
    }
    public boolean equals(Chair chr) {
        if (this == chr) {
            return true;
        }
        if (this.type == chr.type&&
                this.chairnumber == chr.chairnumber ) {
            return true;
        }
        return false;
    }
    //*************************************
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + chairnumber*31;
        result = prime * result + (int)(51*type.getNumber());

        return result;
    }
}
