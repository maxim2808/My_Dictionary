package My_Dictonary_package;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static My_Dictonary_package.method_for_dictionary.*;

public class dictonary_application {
    //static int randomNumber = 2;
    static List<String> unprocessedList = new ArrayList<>();
    static List<String[]> listKeyAndValue = new ArrayList<>();
    static Map<String, String[]> hashMapAllWord = new HashMap();
    static Scanner scanner = new Scanner(System.in);
    public static List<Map.Entry<String, String[]>> listPartOfWords = new ArrayList<>();
    static List<Word> listWord = new ArrayList<>();
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

    }



    public static void main(String[] args) throws FileNotFoundException, InterruptedException {

       int randon_number = r.nextInt(hashMapAllWord.size()-1);


            addMuchWords(3);

          ;
            createWordObjects();
           // playSimpleMod();
        System.out.println(listWord);
         playSimpleMod();
        System.out.println(listWord);
        playSimpleMod();
        System.out.println(listWord);
        playSimpleMod();
        System.out.println(listWord);

        }


    }

