//insert title block later 
public class Student {
    private int ID;
    private String Name;
    private int Classes;
    private double Score;


    public Student(int studentID, String studentname, int assignedclass, int score) {
        ID = studentID;
        Name = studentname;
        Classes = assignedclass;
        Score = score;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public int getClasses() {
        return Classes;
    }

    public void setClasses(int classes) {
        Classes = classes;
    }

    public double getScore() {
        return Score;
    }

    public void setScore(double score) {
        Score = score;
    }
}
