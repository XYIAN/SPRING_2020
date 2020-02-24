public class Course {

    private int courseNumber;
    private String Name;
    private int Capacity;
    private String Location;
    private double classaverage;
    private int countstudents;

    public Course(int coursenum, String name, int coursecap, String location, double average, int count) {
        courseNumber = coursenum;
        Name = name;
        Capacity = coursecap;
        Location = location;
        classaverage = average;
        countstudents = count;
    }

    public String getName(){
        return Name;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public int getCapacity() {
        return Capacity;
    }

    public String getLocation() {
        return Location;
    }

    public double getClassaverage() {
        return classaverage;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public int getCountstudents() {
        return countstudents;
    }

    public void setCountstudentsinc(int countstudents) {
        if(countstudents > 0) {
            this.countstudents =+ 1;
        }else{
            this.countstudents =- 1;
        }
    }

    public void setClassaverage(double classAverage) {
        double sum = 0;
        double add = 0;
        if(countstudents <= 1){
            classaverage = classAverage;
        }else {
            sum = classaverage * (countstudents - 1);
            add = sum + classAverage;
            classaverage = add / countstudents;
        }
    }

    public void updateLocation(String newLocal) {
        Location = newLocal;
    }
}
