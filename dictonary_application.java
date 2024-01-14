package My_Dictonary_package;

import java.io.*;
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


    static List<Word> copyListWords =  new ArrayList<>(listWord);


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


      //  playSimpleModKey();


// playAdvancedModKey();
       playAdvancedModValue();
//        Map.Entry<String, String[]> testEntry = new AbstractMap.SimpleEntry<>("Key", new String []{"ключ", "код","пароль", "Клювоч", "ключик", "клоуч", "пин-код"});
//        Word testWord = new Word(testEntry);
//        ;
//        System.out.println(testWord.patrialReconcilationValue( "клюви", 2));


//        readAllFile();
//        System.out.println(listWord);
//        сnagheWord("superplay");
//        readAllFile();
//        System.out.println(listWord);
//addSpecificWord("Laptop", new String[]{"Ноутбук"});

//addMuchWords(5);

//saveListWords();
//playSimpleMod();
//addSpecificWord("Water");
//addSpecificWord("Computer");
//addSpecificWord("Beautiful");
//addSpecificWord("Dance");
      //  playSimpleMod();
//
//        System.out.println(listWord);
//deleteWord("Water");
//addMuchWords(10);


       // System.out.println(listWord.get(2).oneWordHandling());
       // сleanFile();



    }


}

