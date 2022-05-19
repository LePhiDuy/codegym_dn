package _9_ArrayList_LinkedList.exercise.e1;

public class MyListTest {
    public static class Student {
        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Student() {
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student(1, "Duy");
        Student student2 = new Student(2, "Hoang");
        Student student3 = new Student(3, "DUc");

        MyList<Student> studentMyList = new MyList<>();
        studentMyList.add(student1);
        studentMyList.add(student2);
        studentMyList.add(student3);

        for (int i = 0; i < studentMyList.size(); i++) {
            System.out.println(((Student)studentMyList.elements[i]).toString());
        }
        Student student4 = new Student(4, "Minh");

        studentMyList.add(1, student4);
        for (int i = 0; i < studentMyList.size(); i++) {
            System.out.println(((Student)studentMyList.elements[i]).toString());
        }
        studentMyList.remove(2);
        for (int i = 0; i < studentMyList.size(); i++) {
            System.out.println(((Student)studentMyList.elements[i]).toString());
        }
        System.out.println(studentMyList.get(2).toString());
        System.out.println(studentMyList.contains(student2));
    }
}
