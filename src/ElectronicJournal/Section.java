package ElectronicJournal;

public class Section {
    public String name;
    public Learner[] learners;
    public Teacher classTeacher;
    public Learner[] getList() {return new Learner[2];}
    public Parent[] getListParents() {return new Parent[2];}
}
