package My_Dictonary_package;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

import static My_Dictonary_package.ForFile.*;
import static My_Dictonary_package.method_for_dictionary.*;

public class dictonary_application {

    //static int randomNumber = 2;
    static List<String> unprocessedList = new ArrayList<>();
    static List<String[]> listKeyAndValue = new ArrayList<>();
    static  Map<String, String[]> hashMapAllWord = new HashMap();
    static Scanner scanner = new Scanner(System.in);
    //   public static List<Map.Entry<String, String[]>> listPartOfWords = new ArrayList<>();
    static List<Word> listWord = new ArrayList<>();
    static String fileName = "MyWords.bin";
    static String fileLength = "length.bin";
    static String nameTest = "Test Write.bin";


    static List<Word> copyListWords =  new ArrayList<>(listWord);

//   static FileOutputStream fosAllFile;
//
//    static {
//        try {
//            fosAllFile = new FileOutputStream(fileName);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    static  ObjectOutputStream oosAllFile;
//
//    static {
//        try {
//            oosAllFile = new ObjectOutputStream(fosAllFile);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    static FileOutputStream fosOneEntry;
//
//    static {
//        try {
//            fosOneEntry = new FileOutputStream(fileName);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    static ObjectOutputStream oosOneEntry;
//
//    static {
//        try {
//            oosOneEntry = new ObjectOutputStream(fosOneEntry);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }



    public static  int stepSize = 4;



    public static Random r = new Random();
    public static int numberOfSuggestedWords = 6;

    static {
        File file = new File("allWords.txt");
        Scanner sc1;
        try {
            sc1 = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);   }
        while (sc1.hasNextLine()){
            //System.out.println(sc1.nextLine());
            unprocessedList.add(sc1.nextLine());

        }
        for(int i=0; i<unprocessedList.size(); i++){
            unprocessedList.set(i,unprocessedList.get(i).replaceAll("\\s+",""));
            listKeyAndValue.add(i, unprocessedList.get(i).split("-"));
            hashMapAllWord.put(listKeyAndValue.get(i)[0], listKeyAndValue.get(i)[1].split(","));

        }
//        try {
//            loadListWord();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
    }



    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {





//addSpecificWord("Water");
//addSpecificWord("Computer");
//addSpecificWord("Beautiful");
       // addSpecificWord("Dance");
       // loadListWord();
    // System.out.println(listWord);
deleteWord("Water");
      //  writeLength();

//saveListWords();
      //  System.out.println(listWord);



    }


}

