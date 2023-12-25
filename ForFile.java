package My_Dictonary_package;

import java.io.*;

import static My_Dictonary_package.dictonary_application.*;

public class ForFile {
    static void writeLength() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileLength);
        DataOutputStream dos = new DataOutputStream(fileOutputStream);
        dos.writeInt(listWord.size());
        dos.close();
        fileOutputStream.close();
        }

        static int readLengh() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(fileLength);
        DataInputStream dis = new DataInputStream(fileInputStream);
        int length = dis.readInt();
        dis.close();
        fileInputStream.close();
        return length;
        }

    static void saveListWords() throws IOException {

        //oosAllFile.writeInt(listWord.size());
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        writeLength();
        for(Word w:listWord){
            objectOutputStream.writeObject(w);
        }
        objectOutputStream.close();
        fileOutputStream.close();

    }

    static void loadListWord() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        int listWordSize = readLengh();
        listWord.removeAll(listWord);
        for(int i=0; i< listWordSize; i++){
            listWord.add((Word) objectInputStream.readObject());

        }
        objectInputStream.close();
        fileInputStream.close();
    }

}

