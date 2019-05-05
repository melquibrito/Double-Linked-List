package doublelinkedlist;

public class Student implements Item{

    private String name, registrationNumber;

    public Student(String rn, String name) {
        this.registrationNumber = rn;
        this.name = name;
    }
    
    public void showData() {
        System.out.printf("%s%s %18s%s\n","RN: " , getRegistrationNumber(), "Name: ", getName());
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String rn) {
        this.registrationNumber = rn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        Student x = (Student)o;
        int c = this.name.compareToIgnoreCase(x.getName());
        if(c > 0) {
            return 1;
        }else if(c < 0) {
            return -1;
        }
        return 0;
    }
    
    @Override
    public String toString() {
        return name;
    }

    @Override
    public String key() {
        return registrationNumber;
    }
}
