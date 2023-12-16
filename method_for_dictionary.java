package My_Dictonary_package;

import java.io.*;
import java.util.*;

import static My_Dictonary_package.dictonary_application.*;

public class method_for_dictionary {

    public static void toStringMapEntry(Map.Entry<String, String[]> entry){
        System.out.println(entry.getKey() + " " + Arrays.toString(entry.getValue()));
    }
    public static Map.Entry<String, String[]> getCoupleKeyValue(int justNumber){
        Iterator<Map.Entry<String, String[]>> iterator = dictonary_application.hashMapAllWord.entrySet().iterator();

        for (int i=0; i< justNumber; i++) {
            iterator.next();
        };
        return iterator.next();
    }

    public static Map.Entry<String, String[]> getCoupleKeyValue2(int justNumber){
        Iterator<Map.Entry<String, String[]>> iterator = dictonary_application.hashMapAllWord.entrySet().iterator();

        for (int i=0; i< justNumber; i++) {
            iterator.next();
        };
        Map.Entry<String, String[]> entry1 = new AbstractMap.SimpleEntry<>("Thank you", new String[]{"Спасибо", "Благодарю"});
        Map.Entry<String, String[]> entry2 = iterator.next();
       boolean b = entry2.equals(entry1);
      //  System.out.println(b);
        return entry2;
    }



    static void addSpecificWord(String word){
        boolean isWordInListWords = false;
        for (Word w:listWord ){
            if(w.wordAndTranslate.getKey().equals(word)){
                isWordInListWords =true;
                System.out.println("Слово " + word + " уже есть в словаре");
                return;
            }
        }



        for(Map.Entry<String, String[]> entry:hashMapAllWord.entrySet()) {
          //  System.out.println(entry.getKey());
            if (word.equals(entry.getKey())) {
                String[] translate = entry.getValue();
                Map.Entry<String, String[]> entry2 = new AbstractMap.SimpleEntry<>(word, translate);
                listWord.add(new Word(entry2));
                System.out.println("Слово " + word + " было добавлено в словарь");
                return;
            }
        }
            System.out.println("Кажется в нашей базе нет слова " + word);

    }

    static void addSpecificWord2(String word, List<Word> listWord){
        boolean isWordInListWords = false;
        for (Word w:listWord ){
            if(w.wordAndTranslate.getKey().equals(word)){
                isWordInListWords =true;
                System.out.println("Слово " + word + " уже есть в словаре");
                return;
            }
        }


        for(Map.Entry<String, String[]> entry:hashMapAllWord.entrySet()) {
            //  System.out.println(entry.getKey());
            if (word.equals(entry.getKey())) {
                String[] translate = entry.getValue();
                Map.Entry<String, String[]> entry2 = new AbstractMap.SimpleEntry<>(word, translate);
                listWord.add(new Word(entry2));
                System.out.println("Слово " + word + " было добавлено в словарь");
                return;
            }
        }
        System.out.println("Кажется в нашей базе нет слова " + word);

    }


    static void addSpecificWord(String word, String [] translate){
        boolean isWordInListWords = false;
        for (Word w:listWord ){
            if(w.wordAndTranslate.getKey().equals(word)){
                isWordInListWords =true;
                System.out.println("Слово " + word + " уже есть в словаре");
                return;
            }}
            Map.Entry<String, String[]> entry = new AbstractMap.SimpleEntry<>(word, translate);
            Word w1 = new Word(entry);
            w1.progressWord = 0;
            listWord.add(w1);
            System.out.println("Слово " + word + " с вашим переводом " + translate + " было добавлено в словарь");

    }



static Word w10;

    static Map.Entry<String, String[]> test() throws InterruptedException {


      Map.Entry<String, String[]> entry = getCoupleKeyValue2(r.nextInt(hashMapAllWord.size()));
       // Map.Entry<String, String[]> entry = new AbstractMap.SimpleEntry<>("test", new String[]{"zaza"});
            //w10 = new Word(entry, 0);
          //  listWord.add(new Word(entry, 0));
            return  entry;
    }
   static void infinityAddRandomWordPart1() throws InterruptedException {
        boolean containWord = false;

        Map.Entry<String, String[]> entry = getCoupleKeyValue(r.nextInt(hashMapAllWord.size()));
        for (Word w:listWord){
            if(w.wordAndTranslate.getKey().equals(entry.getKey())){
                containWord = true;
            }
        }
        if(containWord==false){
            listWord.add(new Word(entry));
            System.out.println("Было добавлено слово " + entry.getKey());
            return;
        }
        else {
            System.out.println("Не получилось добавить слово " + entry.getKey());
          //  Thread.sleep(1);
          //  Thread.sleep(25);

            try {
                infinityAddRandomWordPart1();
            }
            catch (StackOverflowError e){
                System.out.println("!!!!!!!!!");
              //  Thread.sleep(500);
            }

        }

    }
    public static Map.Entry<String, String[]> infinityAddRandomWordPart1(List <Map.Entry<String, String[]>> entryList) throws InterruptedException {


        Map.Entry<String, String[]> entry = getCoupleKeyValue(r.nextInt(hashMapAllWord.size()));
        if(!entryList.contains(entry)){entryList.add(entry);
            System.out.println("Было добавлено слово " + entry.getKey());
            return entry;
        }
        else {
            System.out.println("Не получилось добавить слово " + entry.getKey());
            Thread.sleep(1);
            //  Thread.sleep(25);

            try {
                return infinityAddRandomWordPart1(entryList);
            }
            catch (StackOverflowError e){
                System.out.println("!!!!!!!!!");
                Thread.sleep(500);
                return null;
            }

        }

    }

    public static Map.Entry<String, String[]> infinityAddRandomWordPart1(List <Map.Entry<String, String[]>> entryList, Map.Entry<String, String[]> keyWord) throws InterruptedException {


        Map.Entry<String, String[]> entry = getCoupleKeyValue(r.nextInt(hashMapAllWord.size()));
        if(!entryList.contains(entry)){entryList.add(entry);
            System.out.println("Было добавлено слово " + entry.getKey());
            return entry;
        }
        if(entry.getKey().equals(keyWord.getKey())){
            return infinityAddRandomWordPart1(entryList, keyWord);
        }
        else {
            System.out.println("Не получилось добавить слово " + entry.getKey());
            Thread.sleep(1);
            //  Thread.sleep(25);

            try {
                return infinityAddRandomWordPart1(entryList);
            }
            catch (StackOverflowError e){
                System.out.println("!!!!!!!!!");
                Thread.sleep(500);
                return null;
            }

        }

    }

    public static void addMuchWords(int number) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }

            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < number; i++) {
                    try {

                        infinityAddRandomWordPart1();
                    } catch (InterruptedException e) {
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        break;
                    }

                }

            thread1.interrupt();


            }

        });
        thread1.start();

        thread2.start();
        thread1.join();
        thread2.interrupt();
        System.out.println("Мы ждали какое-то время, но метод не завершился"); // кажется не корректно работает

        }

        static void saveListWords() throws IOException {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream1= new ObjectOutputStream(fileOutputStream);
            objectOutputStream1.writeInt(listWord.size());
            for(Word w:listWord){
                objectOutputStream1.writeObject(w);
            }
            objectOutputStream1.close();

        }

        static void loadListWord() throws IOException, ClassNotFoundException {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            int listWordSize = objectInputStream.readInt();
            listWord.removeAll(listWord);
            for(int i=0; i< listWordSize; i++){
                listWord.add((Word) objectInputStream.readObject());

            }
            objectInputStream.close();
        }


    static void playSimpleMod() throws InterruptedException {
        Collections.shuffle(listWord);
        for(int i=0; i<listWord.size(); i++){
        listWord.get(i).oneWordHandling();
        }



    }


    }







