package My_Dictonary_package;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;

import static My_Dictonary_package.ForFile.*;
import static My_Dictonary_package.Word.firstCharactersMatch;
import static My_Dictonary_package.method_for_dictionary.*;

public class dictonary_application {
    static File fileAllWordTxt = new File("D:\\java\\forDictionary\\2000 raw words.txt");

    //static int randomNumber = 2;
    static List<String> unprocessedList = new ArrayList<>();
    static List<String[]> listKeyAndValue = new ArrayList<>();

    static  Map<String, String[]> hashMapAllWord = new HashMap();
    static Map<String, String[]> hashMapAllWordsFromFile = new HashMap<>();
    static boolean fileLoaded = false;
    static boolean continueAddRandom = true;
    static Scanner scanner = new Scanner(System.in);
    //   public static List<Map.Entry<String, String[]>> listPartOfWords = new ArrayList<>();
    static List<Word> listWords = new ArrayList<>();
    static String fileNameAllWords; //имя файла в котором содержатса все слова
    static String fileName = "MyTextWords.txt"; //имя файда в котором содержатся слова которые добавил в свой словарь пользователь
    static String fileLength = "length.bin";
    static String nameTest = "Test Write.bin";
    static String delimetr = ",,-,,";
    static String delimetrForArray = ",";
    static  String endArray = ",,,";
    static String  delimetr_WordAndProgres ="---";
    static int numberOfCorrectWords;
    static int numberOfIncorrectAnswers;
    static int numberOfIncorrectWords;
    static int basicWordNumberNumber = 0;
    static List<Word> copyListWords =  new ArrayList<>(listWords);
    public static  int stepSize = 4;
    public static Random r = new Random();
    public static int numberOfSuggestedWords = 6; //количество слов предлагаемых в простой проверке знанмй

//    static {
//        File file = new File("allWords.txt");
//        Scanner sc1;
//        try {
//            sc1 = new Scanner(file);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);   }
//        while (sc1.hasNextLine()){
//
//            unprocessedList.add(sc1.nextLine());
//
//        }
//        for(int i=0; i<unprocessedList.size(); i++){
//            unprocessedList.set(i,unprocessedList.get(i).replaceAll("\\s+",""));
//            listKeyAndValue.add(i, unprocessedList.get(i).split("-"));
//            hashMapAllWord.put(listKeyAndValue.get(i)[0], listKeyAndValue.get(i)[1].split(","));
//
//        }
//
//    }



    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
//playSimpleModKey();
//        readAllFile();
//        System.out.println(listWords);
//
//        for (int i=0; i<listWords.size(); i++){
//            listWords.get(i).oneWordHandlingFindKeyOrValue(1, i);
//
//
//        }
//        System.out.println(listWords);
       // System.out.println(firstCharactersMatch("Одинокий", "одинок"));

       enableDictiorary();
//       readAllFile();
//        Collections.shuffle(listWords);
//        saveListWords();
//playSimpleModKey();
     //   readAllFile();
//        for(int i=0; i<listWords.size(); i++){
//            listWords.get(i).oneWordHandlingFindKeyOrValue(1);
//        }
//        System.out.println(listWords);


////        System.out.println(listWords);
//        Collections.shuffle(listWords);
//        for (int i=0; i<listWords.size(); i++){
//            System.out.println(listWords.get(i));
//        }
//        System.out.println(listWords);
//        System.out.println(listWords);
//      //enableDictiorary();


        //addMuchWords();
        //deleteAllWord();
        // readAllFile();
        //System.out.println(listWords.size());
       // System.out.println(listWords);

        //addMuchWords(1000);
        //System.out.println(listWords);
//        System.out.println(listWords.size());
//        System.out.println(listWords);
//        enableDictiorary();
        //sorting();
     //   System.out.println(listWords);






    }


}

