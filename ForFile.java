package My_Dictonary_package;

import java.io.*;

import static My_Dictonary_package.dictonary_application.fileLength;
import static My_Dictonary_package.dictonary_application.listWord;

public class ForFile {
    static void writeLength() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileLength);
        DataOutputStream dos = new DataOutputStream(fileOutputStream);
        dos.writeInt(listWord.size());
        dos.close();
        }

        static int readLengh() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(fileLength);
        DataInputStream dis = new DataInputStream(fileInputStream);
        return dis.readInt();

        }

    }

