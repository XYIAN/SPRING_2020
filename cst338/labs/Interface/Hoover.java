package Interface;

public class Hoover extends Vaccum{
    Hoover(){}//constructor 
    public int activate(){
        System.out.println("Turning this vaccum on");
        return 0; //0 == on == true
    } 
    
    public int deactivate(){
        System.out.println("Turning this vaccum off");
        return 1; //1 == off == false
    } 
    public static void main(String args[]){
        activate(); 
        deactivate(); 
    }//end main
}//end hoover