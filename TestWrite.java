package My_Dictonary_package;

import java.io.*;

public class TestWrite {
    static String nameF = "testStudent.bin";
    static void writeStudent(Student student) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(nameF, true);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(student);
        objectOutputStream.close();
        fileOutputStream.close();

    }

    static Student readStudent() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(nameF);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Student s = (Student) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return s;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//     Student s1 = new Student("Misha");
//       Student s2 = new Student("Alex");
//       Student s3 = new Student("Leon");
//        writeStudent(s2);



        FileInputStream fileInputStream = new FileInputStream(nameF);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Student s11 = (Student) objectInputStream.readObject();
        Student s22 = (Student)objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        System.out.println(s11);
        System.out.println(s22);
    }
}
