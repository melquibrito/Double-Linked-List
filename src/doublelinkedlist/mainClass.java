package doublelinkedlist;

public class mainClass {

    public static void main(String[] args) {
        
        DoubleLinkedList<Student> list = new DoubleLinkedList();
        
        list.add(new Student("100", "Benjamin"));
        list.add(new Student("101", "David"));
        list.add(new Student("102", "Abraham"));
        list.add(new Student("103", "Carl"));
        list.add(new Student("104", "Adam"));
        list.add(new Student("105", "Carl"));
        
        System.out.println(list  + "\n");
        
        System.out.println(list.contains("104"));
        System.out.println(list.contains("Adam"));
        System.out.println(list.get("104"));
        System.out.println(list.get("ADAM") + "\n");
        
        System.out.println(list.contains("106"));
        System.out.println(list.contains("Melqui"));
        System.out.println(list.get("106"));
        System.out.println(list.get("Melqui"));
    }
    
}
