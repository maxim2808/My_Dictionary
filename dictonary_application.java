package My_Dictonary_package;

import java.io.*;
import java.util.*;

import static My_Dictonary_package.method_for_dictionary.*;

public class dictonary_application {
    static File fileAllWordTxt = new File("2000 raw words.txt"); //база слов
    static  Map<String, String[]> hashMapAllWord = new HashMap();
    static Map<String, String[]> hashMapAllWordsFromFile = new HashMap<>();
    static boolean fileAllWordLoaded = false;
    static boolean continueAddRandom = true;
    static Scanner scanner = new Scanner(System.in);
    //   public static List<Map.Entry<String, String[]>> listPartOfWords = new ArrayList<>();
    static List<Word> listWords = new ArrayList<>();
    static String fileName = "MyTextWords.txt"; //имя файда в котором содержатся слова которые добавил в свой словарь пользователь
    static String nameFileParametrs = "parametrs.txt";
    static String delimetr = ",,-,,";
    static String delimetrForArray = ",";
    static  String endArray = ",,,";
    static String  delimetr_WordAndProgres ="---";
    static int numberOfCorrectWords;
    static int numberOfIncorrectAnswers;
    static int numberOfIncorrectWords;
    //static int basicWordNumberNumber = 0;
    //static List<Word> copyListWords =  new ArrayList<>(listWords);
    static int typeSorting;
    public static  int stepSize = 4;
    public static Random r = new Random();
    public static int numberOfSuggestedWords = 6; //количество слов предлагаемых в простой проверке знанмй





    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        enableDictiorary();

    }


}

