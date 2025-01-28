class Student{
    String name;
    int age;
    int rollNumber;
    char grade;
    Student next;

    Student(String name,int age,int rollNumber,char grade) {
        this.name = name;
        this.age = age;
        this.rollNumber = rollNumber;
        this.grade = grade;
        this.next = null;
    }
}

class StudentList{
    private Student head;

    public void addAtBeginning(String name,int age,int rollNumber,char grade){
        Student newStudent = new Student(name,age,rollNumber,grade);
        newStudent.next = head;
        head = newStudent;
    }

    public void addAtEnd(String name,int age,int rollNumber,char grade){
        Student newStudent = new Student(name,age,rollNumber,grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student current = head;
        while (current.next!=null){
           current = current.next;
        }
        current.next=newStudent;
    }

    public void addAtPosition(int position,String name,int age,int rollNumber,char grade){
        if (position<1){
            System.out.println("Position must be greater than 0");
            return;
        }
        if (position==1){
            addAtBeginning(name,age,rollNumber,grade);
            return;
        }
        Student newStudent = new Student(name,age,rollNumber,grade);
        Student current = head;
        for (int i =1; i< position-1 && current!=null; i++){
            current=current.next;
        }
        if (current==null){
            System.out.println("Wrong Position");
        }
        else {
            newStudent.next=current.next;
            current.next=newStudent;
        }
    }

    public void deleteById(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.rollNumber ==rollNumber) {
            head = head.next;
            System.out.println("Student with roll number " + rollNumber + " deleted.");
            return;
        }
        Student current = head;
        while (current.next != null && current.next.rollNumber != rollNumber) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Student with roll number  " + rollNumber + " not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Student with roll number " + rollNumber + " deleted.");
        }
    }
    public void updateGrade(int rollNumber,char newGrade){
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Student current = head;
        while (current!=null){
            if(current.rollNumber==rollNumber){
                current.grade=newGrade;
                return;
            }
            current = current.next;
        }
    }

    public void displayAllStudents(){
        if (head==null){
            return;
        }
        Student current = head;
        while (current!=null){
            System.out.println("Name :"+current.name+" Age : "+current.age+" Roll Number ; "+
                    current.rollNumber+" Grade: "+current.grade);
            current=current.next;
        }
    }
}
public class StudentRecordManagement {
    public static void main(String[] args) {
        StudentList lists = new StudentList();
        lists.addAtPosition(1,"Kapil",23,002,'A');
        lists.addAtBeginning("Kalpesh",24,001,'C');
        lists.addAtBeginning("Mohan",25,003,'E');

        lists.deleteById(003);
        lists.updateGrade(001,'B');

        lists.displayAllStudents();
    }

}
