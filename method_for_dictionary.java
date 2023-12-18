package My_Dictonary_package;

import java.io.*;
import java.util.*;

import static My_Dictonary_package.dictonary_application.*;

public class method_for_dictionary {

    public static void toStringMapEntry(Map.Entry<String, String[]> entry){
        System.out.println(entry.getKey() + " " + Arrays.toString(entry.getValue()));
    }
//    public static Map.Entry<String, String[]> getCoupleKeyValue(int justNumber){
//        Iterator<Map.Entry<String, String[]>> iterator = dictonary_application.hashMapAllWord.entrySet().iterator();
//
//        for (int i=0; i< justNumber; i++) {
//            iterator.next();
//        };
//        return iterator.next();
//    }

    public static String getKey(int justNumber){
        Iterator<Map.Entry<String, String[]>> iterator = dictonary_application.hashMapAllWord.entrySet().iterator();

        String [] arrayKey = hashMapAllWord.keySet().toArray(new String[hashMapAllWord.size()]);
       // String [][] arrayValue = hashMapAllWord.values().toArray(new String[hashMapAllWord.size()][]);
  return arrayKey[justNumber];

    }

    public static String[] getValue(int justNumber){

        String [][] arrayValue = hashMapAllWord.values().toArray(new String[hashMapAllWord.size()][]);

        return arrayValue[justNumber];
    }












    static void addSpecificWord(String word) throws IOException {
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
                Word w1 = new Word(entry2);
                listWord.add(w1);
                oosOneEntry.writeObject(w1);
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


    static void addSpecificWord(String word, String [] translate) throws IOException {
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
        oosOneEntry.writeObject(w1);
        System.out.println("Слово " + word + " с вашим переводом " + translate + " было добавлено в словарь");

    }


    static void infinityAddRandomWordPart1() throws InterruptedException {
        boolean containWord = false;
        int random_int = r.nextInt(hashMapAllWord.size());
        String key = getKey(random_int);
        String [] value = getValue(random_int);
        for (Word w:listWord){
            if(w.wordAndTranslate.getKey().equals(key)){
                containWord = true;
            }
        }
        if(containWord==false){
            Map.Entry<String, String[]> entry = new AbstractMap.SimpleEntry<>(key, value);
            listWord.add(new Word(entry));
            System.out.println("Было добавлено слово " + entry.getKey());
            return;
        }
        else {
            System.out.println("Не получилось добавить слово " + key);
            //  Thread.sleep(1);
             Thread.sleep(25);

            try {
                infinityAddRandomWordPart1();
            }
            catch (StackOverflowError e){
                System.out.println("!!!!!!!!!");
                  Thread.sleep(500);
            }

        }

    }
    public static Map.Entry<String, String[]> infinityAddRandomWordPart1(List <Map.Entry<String, String[]>> entryList) throws InterruptedException {
        int random_int = r.nextInt(hashMapAllWord.size());
        String key = getKey(random_int);
        String [] value = getValue(random_int);

        Map.Entry<String, String[]> entry = new AbstractMap.SimpleEntry<>(key, value);
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


        int random_int = r.nextInt(hashMapAllWord.size());
        String key = getKey(random_int);
        String [] value = getValue(random_int);

        Map.Entry<String, String[]> entry = new AbstractMap.SimpleEntry<>(key, value);
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

        oosAllFile.writeInt(listWord.size());
        for(Word w:listWord){
            oosAllFile.writeObject(w);
        }
        oosAllFile.close();

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


    static void playSimpleMod() throws InterruptedException, IOException {
        Collections.shuffle(listWord);
        for(int i=0; i<listWord.size(); i++){
            listWord.get(i).oneWordHandling();
        }
        saveListWords();


    }


}







