//title block insert later 

public class Instructor {
    private String Tname = "";
    private String Temail = "";
    private String Tphone = "";
    private int numClass;
    private int ID;

    public Instructor(String name, String email, String phone, int employeeID, int number) {
        Tname = name;
        Temail = email;
        Tphone = phone;
        ID = employeeID;
        numClass = number;
    }

    public String getTname() {
        return Tname;
    }

    public String getTemail() {
        return Temail;
    }

    public String getTphone() {
        return Tphone;
    }

    public int getNumClass() {
        return numClass;
    }

    public void setNumClass(int numclass) {
        this.numClass = numclass;
    }

    public int getID() {
        return ID;
    }
}
