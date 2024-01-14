package My_Dictonary_package;

import java.io.*;
import java.util.*;

import static My_Dictonary_package.ForFile.*;
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

    static String[] transformingLineToArray(String line){
        String line_without_space = line.replaceAll("(\\s+)*,\\s+", ",");
        String [] array = line_without_space.split(",");
        return array;
    }
    static Word onlyKey(String [] value, int progress){
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Введите новое слово");
        String key = scanner1.nextLine();
        Map.Entry<String, String[]> entry = new AbstractMap.SimpleEntry<>(key, value);
        Word word = new Word(entry, progress);
        return word;
    }
    static Word onlyValue(String key, int progress){
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Введите новый перевод (разделяйте слова запяой)");
        String valueScan = scanner1.nextLine();
        Map.Entry<String, String[]> entry = new AbstractMap.SimpleEntry<>(key, transformingLineToArray(valueScan));
        Word word = new Word(entry, progress);
        return word;
    }

    static Word keyAndValue(int progress){
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Введите новое слово");
        String key = scanner1.nextLine();
        System.out.println("Введите новый перевод (разделяйте слова запяой)");
        String valueScan = scanner1.nextLine();
        Map.Entry<String, String[]> entry = new AbstractMap.SimpleEntry<>(key, transformingLineToArray(valueScan));
        Word word = new Word(entry, progress);
        return word;
    }

    static void сnagheWord(String word) throws IOException, ClassNotFoundException {

        readAllFile();
        for (int i=0; i<listWord.size(); i++){
            if(listWord.get(i).wordAndTranslate.getKey().toLowerCase().equals(word.toLowerCase())){
                System.out.println("Вы хотите изменить слово " + listWord.get(i).wordAndTranslate.getKey() +
                        " или перевод к нему? Введите\n1.Только слово \n2.Только перевод\n3.И слово и перевод\n4.Отмена "); //Доделать механизм изменения слова
//progres word должен сохраняться
                Word wordFromList = listWord.get(i);
                int action;
                try {
                     action = scanner.nextInt();
                }
                catch (InputMismatchException e){
                    action= 9;
                }

                switch (action){
                    case 1:
                        listWord.set(i, onlyKey(wordFromList.wordAndTranslate.getValue(),wordFromList.progressWord));
                        saveListWords();
                        break;
                    case 2:
                        listWord.set(i, onlyValue(wordFromList.wordAndTranslate.getKey(), wordFromList.progressWord));
                        saveListWords();
                        break;
                    case 3:
                        listWord.set(i, keyAndValue(wordFromList.progressWord));
                        saveListWords();
                        break;
                    case 4:
                        System.out.println("Отмена действия");
                        break;

                    default:
                        System.out.println("Неизвестное значение");

                }


                return;

            }


        }

        System.out.println("Не было найдено слово " + word);


    }




    static void deleteWord(String word) throws IOException, ClassNotFoundException {

        readAllFile();
        for (Word w:listWord ){
            if(w.wordAndTranslate.getKey().equals(word)){
                listWord.remove(w);
                System.out.println("Слово  " + word + " было удалено ");
                saveListWords();
                return;
            }
        }
        System.out.println("Не было найдено слово " + word);


    }





//Добавляет слово которое уже есть в общем списке
    static void addSpecificWord(String word) throws IOException, ClassNotFoundException {
       // boolean isWordInListWords = false;
        readAllFile();
        for (Word w:listWord ){
            if(w.wordAndTranslate.getKey().equals(word)){
              //  isWordInListWords =true;
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
                saveTextWord(w1);
                System.out.println("Слово " + word + " было добавлено в словарь");
                return;
            }
        }
        System.out.println("Кажется в нашей базе нет слова " + word);

    }

//    static void addSpecificWord2(String word, List<Word> listWord){
//     //   boolean isWordInListWords = false;
//        for (Word w:listWord ){
//            if(w.wordAndTranslate.getKey().equals(word)){
//            //   isWordInListWords =true;
//                System.out.println("Слово " + word + " уже есть в словаре");
//                return;
//            }
//        }
//
//
//        for(Map.Entry<String, String[]> entry:hashMapAllWord.entrySet()) {
//            //  System.out.println(entry.getKey());
//            if (word.equals(entry.getKey())) {
//                String[] translate = entry.getValue();
//                Map.Entry<String, String[]> entry2 = new AbstractMap.SimpleEntry<>(word, translate);
//                listWord.add(new Word(entry2));
//                System.out.println("Слово " + word + " было добавлено в словарь");
//                return;
//            }
//        }
//        System.out.println("Кажется в нашей базе нет слова " + word);
//
//    }

//Добавляет слово которого нет в общем списке (пользователь также должен указать его перевод)
    static void addSpecificWord(String word, String [] translate) throws IOException {
        readAllFile();
        for (Word w:listWord ){
            if(w.wordAndTranslate.getKey().equals(word)){

                System.out.println("Слово " + word + " уже есть в словаре");
                return;
            }}
        Map.Entry<String, String[]> entry = new AbstractMap.SimpleEntry<>(word, translate);
        Word w1 = new Word(entry);
        w1.progressWord = 0;
        listWord.add(w1);
        saveTextWord(w1);
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
        boolean rezult = entry.getKey().equals(keyWord.getKey());
        System.out.println("entry key " +  entry.getKey() + " keyWord key " + keyWord.getKey() + " rezult " + rezult); //удалить если не будет повторов слов в playsimplemethod
        if(entry.getKey().equals(keyWord.getKey())){
            System.out.println("inner!!!!!"); //удалить если не будет повторов слов в playsimplemethod
            System.out.println("entry key " +  entry.getKey() + " keyWord key " + keyWord.getKey() + " rezult " + rezult); //удалить если не будет повторов слов в playsimplemethod
            return infinityAddRandomWordPart1(entryList, keyWord);
        }
        if(!entryList.contains(entry)){
            entryList.add(entry);
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



//    public static Map.Entry<String, String[]> infinityAddRandomWordPart1(List <Map.Entry<String, String[]>> entryList, Map.Entry<String, String[]> keyWord) throws InterruptedException {
//
//
//        int random_int = r.nextInt(hashMapAllWord.size());
//        String key = getKey(random_int);
//        String [] value = getValue(random_int);
//
//        Map.Entry<String, String[]> entry = new AbstractMap.SimpleEntry<>(key, value);
//        boolean rezult = entry.getKey().equals(keyWord.getKey());
//        System.out.println("entry key " +  entry.getKey() + " keyWord key " + keyWord.getKey() + " rezult " + rezult); //удалить если не будет повторов слов в playsimplemethod
//        if(entry.getKey().equals(keyWord.getKey())){
//            System.out.println("inner!!!!!"); //удалить если не будет повторов слов в playsimplemethod
//            System.out.println("entry key " +  entry.getKey() + " keyWord key " + keyWord.getKey() + " rezult " + rezult); //удалить если не будет повторов слов в playsimplemethod
//            return infinityAddRandomWordPart1(entryList, keyWord);
//        }
//        if(!entryList.contains(entry)){
//            entryList.add(entry);
//            System.out.println("Было добавлено слово " + entry.getKey());
//            return entry;
//        }
//
//        else {
//            System.out.println("Не получилось добавить слово " + entry.getKey());
//            Thread.sleep(1);
//            //  Thread.sleep(25);
//
//            try {
//                return infinityAddRandomWordPart1(entryList);
//            }
//            catch (StackOverflowError e){
//                System.out.println("!!!!!!!!!");
//                Thread.sleep(500);
//                return null;
//            }
//
//        }
//
//    }



    public static void addMuchWords(int number) throws InterruptedException, IOException {
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
        saveListWords();
    }






    static void playSimpleModKey() throws InterruptedException, IOException {

        readAllFile();
        numberOfCorrectWords = 0;
        numberOfIncorrectAnswers = 0;
        Collections.shuffle(listWord);
        System.out.println("Тест начался");
        for(int i=0; i<listWord.size(); i++){
            listWord.get(i).oneWordHandlingFindKeyOrValue(1);
        }

        saveListWords();
        System.out.println("Тест закончен, количество правильных ответов " + numberOfCorrectWords + " количество неправильных ответов " + numberOfIncorrectAnswers);

    }

    static void playSimpleModValue() throws InterruptedException, IOException {

        readAllFile();
        numberOfCorrectWords = 0;
        numberOfIncorrectAnswers = 0;
        Collections.shuffle(listWord);
        System.out.println("Тест начался");
        for(int i=0; i<listWord.size(); i++){
            listWord.get(i).oneWordHandlingFindKeyOrValue(2);
        }

        saveListWords();
        System.out.println("Тест закончен, количество правильных ответов " + numberOfCorrectWords + " количество неправильных ответов " + numberOfIncorrectAnswers);

    }
    static void playAdvancedModKey() throws InterruptedException, IOException {

        readAllFile();
        numberOfCorrectWords = 0;
        numberOfIncorrectWords = 0;
        numberOfIncorrectAnswers = 0;
        Collections.shuffle(listWord);
        System.out.println("Тест начался");
        for(int i=0; i<listWord.size(); i++){
         listWord.get(i).oneWordHandlingKeyForDifficultMethod();
        }

        saveListWords();
        System.out.println("Тест закончен, количество правильных ответов " + numberOfCorrectWords + " количество неправильных ответов " + numberOfIncorrectAnswers + " количнство неправильных слов " + numberOfIncorrectWords);

    }

    static void playAdvancedModValue() throws InterruptedException, IOException {

        readAllFile();
        numberOfCorrectWords = 0;
        numberOfIncorrectWords = 0;
        numberOfIncorrectAnswers = 0;
        Collections.shuffle(listWord);
        System.out.println("Тест начался");
        for(int i=0; i<listWord.size(); i++){
            listWord.get(i).oneWordHandlingValueForDifficultMethod();
        }

        saveListWords();
        System.out.println("Тест закончен, количество правильных ответов " + numberOfCorrectWords + " количество неправильных ответов " + numberOfIncorrectAnswers + " количнство неправильных слов " + numberOfIncorrectWords);

    }





}







