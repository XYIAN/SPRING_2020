// @author: Kyle Xyian Dilbeck 
// @title: project1 | School.java 
// @abstract: this program will 
// @date: 2/24/20
// v1.0.0
// CST338 | CSUMB2020

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class School {
    private String Name;
    static HashMap<Integer, Instructor> employee = new HashMap<>();
    static HashMap<Integer, Course> classes = new HashMap<>();
    static HashMap<Integer, Student> students = new HashMap<>();

    public String getName() {
        return Name;
    }

    public School(String name) {
        Name = name;
    }

    private static void teacherOrganize(String[] list) {
        for (String s : list) {

        }
    }

    public void readData(String txt) {
        try {
            Scanner read = new Scanner(new File(txt));
            int numemployee = Integer.parseInt(read.nextLine());
            for (int i = 0; i < numemployee; i++) {
                String employeeinfo = read.nextLine();
                String infoarr[] = employeeinfo.split(",", 0);
                int employeeID = Integer.parseInt(infoarr[0]);
                Instructor newTeacher = new Instructor(infoarr[1], infoarr[2], infoarr[3], employeeID, 0);
                if (employee.get(employeeID) == null) {
                    employee.put(employeeID, newTeacher);
                } else {
                    System.out.println("Instructor info reading failed - Employee number " + employeeID + " already used.");
                }
            }

            int numofcourse = Integer.parseInt(read.nextLine());
            for (int i = 0; i < numofcourse; i++) {
                String courseinfo = read.nextLine();
                String classload[] = courseinfo.split(",", 0);
                int coursenum = Integer.parseInt(classload[0]);
                int coursecap = Integer.parseInt(classload[2]);
                Course newCourse = new Course(coursenum, classload[1], coursecap, classload[3], 0, 0);
                if (classes.get(coursenum) == null) {
                    classes.put(coursenum, newCourse);
                } else {
                    System.out.println("Class already exist");
                }
            }
            int numofstudent = Integer.parseInt(read.nextLine());
            for (int i = 0; i < numofstudent; i++) {
                String studentinfo = read.nextLine();
                String studentload[] = studentinfo.split(",", 0);
                int studentID = Integer.parseInt(studentload[0]);
                Student newStudent = new Student(studentID, studentload[1], 0, 0);
                if (students.get(studentID) == null) {
                    students.put(studentID, newStudent);
                } else {
                    System.out.println("Student info reading failed - Student number " + studentID + " already used.");
                }
            }
            System.out.println("Done.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void schoolInfo() {
        System.out.println("School Name: " + getName());
        System.out.println("Instructor Information");
        employee.forEach((key, value) -> System.out.println("\t" + value.getTname()));
        System.out.println("    Course Info");
        classes.forEach((key, value) -> System.out.println("\t" + value.getName()));
        System.out.println("    Student Info");
        students.forEach((key, value) -> System.out.println("\t" + value.getName()));
    }

    public void searchByEmail(String email) {
        int count = 0;
        for (Map.Entry<Integer, Instructor> entry : employee.entrySet()) {
            Instructor value = entry.getValue();
            if (email.equals(value.getTemail())) {
                System.out.println("Search Key: " + value.getTemail());
                System.out.println("Employee Number: " + value.getID());
                System.out.println(("Name: " + value.getTname()));
                System.out.println("Phone: " + value.getTphone());
                count++;
                break;
            }
        }
        if (count == 0) {
            System.out.println("Search key: " + email);
            System.out.println("No employee with the email: " + email);
        }
    }

    public void addInstructor(int tID, String tName, String tEmail, String tNumber) {
        Instructor newadd = new Instructor(tName, tEmail, tNumber, tID, 0);
        if (employee.get(tID) == null) {
            employee.put(tID, newadd);
        } else {
            System.out.println("Instructor info reading failed - Employee number " + tID + " already used.");
        }
    }
    public void addCourse(int coursenum, String corsename, int corsecap, String courselocation) {
        for (Map.Entry<Integer, Course> entry : classes.entrySet()) {
            Course key = entry.getValue();
            Course newadd = new Course(coursenum, corsename, corsecap, courselocation, 0, 0);
            if (key.getCourseNumber() != coursenum) {
                classes.put(coursenum, newadd);
                return;
            }
        }
        System.out.println("Course addition failed - Course number " + coursenum + " already used.");
    }


    public void assignInstructor(int classID, int teacherID) {
        for (Map.Entry<Integer, Instructor> entry : employee.entrySet()) {
            Instructor value = entry.getValue();
            if (teacherID == value.getID()) {
                value.setNumClass(classID);
                return;
            }
        }
        System.out.println("Instructor " + teacherID + " does not exist.");
    }

    public void register(int classID, int studentID) {
        for (Map.Entry<Integer, Student> entry : students.entrySet()) {
            Student value = entry.getValue();
            if (studentID == value.getID()) {
                value.setClasses(classID);
            }
        }
        for (Map.Entry<Integer, Course> entry : classes.entrySet()) {
            Course value = entry.getValue();
            if (classID == value.getCourseNumber()) {
                value.setCountstudentsinc(1);
            }
        }
    }

    public void unRegister(int classID, int studentID) {
        for (Map.Entry<Integer, Student> entry : students.entrySet()) {
            Student value = entry.getValue();
            if (studentID == value.getID()) {
                value.setClasses(0);
                for (Map.Entry<Integer, Course> check : classes.entrySet()) {
                    Course place = check.getValue();
                    if (classID == place.getCourseNumber()) {
                        place.setCountstudentsinc(0);
                        place.setCountstudentsinc(-1);
                        return;
                    }
                }
            }
        }
        System.out.println("Not able to unregister " + studentID + " because not found");
    }

    public void putScore(int classID, int studentID, double score) {
        for (Map.Entry<Integer, Student> entry : students.entrySet()) {
            Student value = entry.getValue();
            if (studentID == value.getID()) {
                if (classID == value.getClasses()) {
                    value.setScore(score);
                    for (Map.Entry<Integer, Course> check : classes.entrySet()) {
                        Course place = check.getValue();
                        if (classID == place.getCourseNumber()) {
                            place.setClassaverage(score);
                        }
                    }
                } else {
                    System.out.println("Student " + value.getID() + " (" + value.getName() + ") " + "is not enrolled in " + classID);
                }
            } else {
                System.out.println("Student " + studentID + " does not exist");
            }
        }
    }


    public void courseInfo(int coursenum) {
        System.out.println("Course Number: " + coursenum);
        for (Map.Entry<Integer, Instructor> entry : employee.entrySet()) {
            Instructor value = entry.getValue();
            if (coursenum == value.getNumClass()) {
                System.out.println("Instructor: " + value.getTname());
                for (Map.Entry<Integer, Course> check : classes.entrySet()) {
                    Course place = check.getValue();
                    if (coursenum == place.getCourseNumber()) {
                        System.out.println("Course Title: " + place.getName());
                        System.out.println("Room: " + place.getLocation());
                        System.out.println("Total Enrolled: " + place.getCountstudents());
                        System.out.println("Course Average: " + place.getClassaverage());
                    }
                }
            }
        }
    }

    public Course getCourse(int coursenum) {
        Course obtain = classes.get(coursenum);
        return obtain;
    }

    public void courseInfo() {
        classes.forEach((key, value) -> System.out.println("\t" + value.getName()));
    }

    public void deleteCourse(int coursenum) {
        for (Map.Entry<Integer, Course> check : classes.entrySet()) {
            Course place = check.getValue();
            if (place.getCourseNumber() == coursenum) {
                classes.remove(coursenum);
            }
        }
    }

    public void addStudent(int sID, String studentname) {
        Student newadd = new Student(sID, studentname, 0, 0);
        if (students.get(sID) == null) {
            students.put(sID, newadd);
        } else {
            System.out.println("Student info failed - Student number " + sID + " already used.");
        }
    }

    public Instructor getInstructor(int tclass) {
        Instructor holder = new Instructor("none", "none@csumb.edu","0000000", 0000, 0 );
        for (Map.Entry<Integer, Instructor> check : employee.entrySet()) {
            Instructor place = check.getValue();
            if (place.getNumClass() == tclass) {
                return place;
            }
        }
        System.out.println("No Instructor found with course number " + tclass + " a default Instructor return");
        return holder;
    }

    public Student getStudent(int sID) {
        Student newadd = new Student(sID, "studentname", 0, 0);
        if (students.get(sID).getID() == sID) {
            return students.get(sID);
        } else {
            System.out.println("Student with " + sID + " does not exist. An empty student returned");
            return newadd;
        }
    }

    public void graduateStudent(int GID) {
        if(students.get(GID) != null){
            unRegister(students.get(GID).getClasses(), GID);
            students.remove(GID);
        } else{
            System.out.println("Student does not exist");
        }
    }
}
