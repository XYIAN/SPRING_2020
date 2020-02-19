/**
 * @author Kyle Dilbeck 
 * @Title EasyClass.java
 * @Date 2/14/20
 * This is an example setter/getter class with java conventions 
 */
 
public class EasyClass{
    public String getName(){return name;}
    public void setName(String Name){this.name = name;}
    public int getCount(){return count;}
    public void setCount(int interger){count = interger;}
    public double getScore(){return score;}
    public void setScore(double s){score = s;}
    //end getter/setter begin constructors 
    EasyClass(String name, Double score){this.name = name; this.score = score;}
    EasyClass(String name, Integer count, Double score){this.name = name; this.score = score; this.count = count;}

    private String name; 
    private double score;
    private int count; 
    
} 
