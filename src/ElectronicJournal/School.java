package ElectronicJournal;

public class School {
    public Employee[] employees;
    public Teacher[] teachers;
    public Learner[] learners;
    public String address;
    public String name;
    public Class[] classes;
    public Elective[] electives;
    public Section[] sections;
    public Teacher[] getListTeacher() {return new Teacher[2];}
    public Employee[] getListEmployees(){return new Employee[2];}
    public Learner[] getListLearners(){return new Learner[2];}
    public void getElectronicJournal(){}
    //public Participant[] getParticipants(){}
}
