package My_Dictonary_package;

import java.io.*;
import java.util.*;

import static My_Dictonary_package.method_for_dictionary.*;

public class dictonary_application {

    //static int randomNumber = 2;
    static List<String> unprocessedList = new ArrayList<>();
    static List<String[]> listKeyAndValue = new ArrayList<>();
    static  Map<String, String[]> hashMapAllWord = new HashMap();
    static Scanner scanner = new Scanner(System.in);
    //   public static List<Map.Entry<String, String[]>> listPartOfWords = new ArrayList<>();
    static List<Word> listWord = new ArrayList<>();
    static String fileName = "My Words.bin";
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
//        for(int i=0; i<unprocessedList.size(); i++){
//            unprocessedList.set(i,unprocessedList.get(i).replaceAll("\\s+",""));
//            listKeyAndValue.add(i, unprocessedList.get(i).split("-"));
//            hashMapAllWord.put(listKeyAndValue.get(i)[0], listKeyAndValue.get(i)[1].split(","));
//
//        }
        hashMapAllWord.put("Thank you", new String[]{"1"});
    }



    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

//        Map.Entry<String, String[]> entry1 = new AbstractMap.SimpleEntry<>("Thank you", new String[]{"1"});
//        System.out.println(getCoupleKeyValue2(0).getKey());
//        System.out.println(getCoupleKeyValue2(0).getValue()
//        );
//        System.out.println(entry1.getKey().equals(getCoupleKeyValue2(0).getKey()));
//        System.out.println(entry1.getValue().equals(getCoupleKeyValue2(0).getValue()));
//        System.out.println(Arrays.toString(entry1.getValue()));
//        System.out.println(Arrays.toString(getCoupleKeyValue2(0).getValue()));
//        String [] arrayEntry = entry1.getValue();
//        String [] arrayIterator = getCoupleKeyValue2(0).getValue();
//        System.out.println(Arrays.equals(arrayEntry, arrayIterator));
//






        System.out.println();
        Map.Entry<String, String[]> entry = new AbstractMap.SimpleEntry<>("Thank you", new String[]{"1"});
        Word w1 =new Word(test());
        Word w2 = new Word(entry);
        System.out.println(w1.equals(w2));
        System.out.println(listWord);
       // listWord.add(w10);
//
//        Word w1 = new Word(entry, 0);
//        listWord.add(w1);
//        infinityAddRandomWordPart1();
//        System.out.println(listWord);
//    List<Word> testList = new ArrayList<>();
//    addSpecificWord2("Thankyou", testList);
//        System.out.println(testList);
//        System.out.println(testList.equals(listWord));;
//        // addMuchWords(2);
//        // Thread.sleep(500);
//      //test();
        FileOutputStream f1 = new FileOutputStream("test.bin");
        ObjectOutputStream oo1 = new ObjectOutputStream(f1);

        for (int i = 0; i<listWord.size(); i++){
            oo1.writeObject(listWord.get(i));
        }

     oo1.close();



//
//                  addSpecificWord("Car");
//          addSpecificWord("Weak");
//          addSpecificWord("Sun");
//          addSpecificWord("Car");
//          addSpecificWord("AirShip", new String[]{"Дирижабль, Воздушный корабль"});
//          addSpecificWord("a12321213");
//          addSpecificWord("House");
//        System.out.println(listWord);
//        System.out.println(listWord.size());









       // saveListWords();
//          addSpecificWord("Car");
//          addSpecificWord("Weak");
//          addSpecificWord("Sun");
//          addSpecificWord("Car");
//          addSpecificWord("AirShip", new String[]{"Дирижабль, Воздушный корабль"});
//          addSpecificWord("a12321213");
//          addSpecificWord("House");
         // saveListWords();

     //   saveListWords();
       // loadListWord();
//         saveListWords();
//       // loadListWord();
//        System.out.println(listWord);



//          FileOutputStream fileOutputStream = new FileOutputStream("My Words2.bin");
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//        objectOutputStream.writeInt(listWord.size());
//        for (Word w:listWord){
//            objectOutputStream.writeObject(w);
//
//        }
//        objectOutputStream.close();

          //  createWordObjects();
           // playSimpleMod();
       // System.out.println(listWord);
//         playSimpleMod();
//        System.out.println(listWord);
//        playSimpleMod();
//        System.out.println(listWord);
//        playSimpleMod();
//        System.out.println(listWord);

        }


    }

