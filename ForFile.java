package My_Dictonary_package;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static My_Dictonary_package.dictonary_application.*;

public class ForFile {

    static void saveListWords() throws IOException {
        сleanFile();
        for(Word w:listWord){
            saveTextWord(w);
        }
        System.out.println("Файл сохранен");

    }

    static void saveTextWord(Word word) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName, true );

        fileWriter.write(word.wordAndTranslate.getKey());
        fileWriter.write(delimetr);
        for(int i=0; i<word.wordAndTranslate.getValue().length; i++){
            fileWriter.write(word.wordAndTranslate.getValue()[i] + delimetrForArray);
            // fileWriter.write(word.wordAndTranslate.getValue()[i]);
        }
        // fileWriter.write(endArray+delimetr_WordAndProgres+word.progressWord+"\n");
        fileWriter.write(endArray+delimetr_WordAndProgres+word.progressWord + "\n");
        fileWriter.close();
    }

    static List<Word> readAllFile() throws FileNotFoundException {
        listWord.removeAll(listWord);
        Scanner scanner = new Scanner(new File(fileName));
        StringBuilder line = new StringBuilder();
        while (scanner.hasNextLine()){
            line.append(scanner.nextLine());
        }
        Pattern pattern = Pattern.compile("(\\w+)(,,-,,)(.+?)(,,,,---)(\\d+)");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()){
            // System.out.println(matcher.group());
            String key = matcher.group(1);
            String [] value = matcher.group(3).split(",");
            int progress = Integer.parseInt(matcher.group(5));
            Map.Entry<String, String[]> entry = new AbstractMap.SimpleEntry<>(key, value);
            Word w = new Word(entry, progress);
            listWord.add(w);

        }

        return listWord;

    }

    static void сleanFile() throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write("");
        fileWriter.close();
        System.out.println("Файл очищен");
    }





//    static void writeLength() throws IOException {
//        FileOutputStream fileOutputStream = new FileOutputStream(fileLength);
//        DataOutputStream dos = new DataOutputStream(fileOutputStream);
//        dos.writeInt(listWord.size());
//        dos.close();
//        fileOutputStream.close();
//        }
//
//        static int readLengh() throws IOException {
//        FileInputStream fileInputStream = new FileInputStream(fileLength);
//        DataInputStream dis = new DataInputStream(fileInputStream);
//        int length = dis.readInt();
//        dis.close();
//        fileInputStream.close();
//        return length;
//        }
//
//    static void saveListWords() throws IOException {
//
//        //oosAllFile.writeInt(listWord.size());
//        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//        writeLength();
//        for(Word w:listWord){
//            objectOutputStream.writeObject(w);
//        }
//        objectOutputStream.close();
//        fileOutputStream.close();
//
//    }
//
//    static void loadListWord() throws IOException, ClassNotFoundException {
//        FileInputStream fileInputStream = new FileInputStream(fileName);
//        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//        int listWordSize = readLengh();
//        listWord.removeAll(listWord);
//        for(int i=0; i< listWordSize; i++){
//            listWord.add((Word) objectInputStream.readObject());
//
//        }
//        objectInputStream.close();
//        fileInputStream.close();
//    }

}

