package My_Dictonary_package;

import java.io.*;
import java.util.*;

import static My_Dictonary_package.ForFile.*;
import static My_Dictonary_package.SortingWords.*;
import static My_Dictonary_package.dictonary_application.*;

public class method_for_dictionary {

    public static void toStringMapEntry(Map.Entry<String, String[]> entry) {
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

    public static String getKey(int justNumber) {
        Iterator<Map.Entry<String, String[]>> iterator = dictonary_application.hashMapAllWord.entrySet().iterator();

        String[] arrayKey = hashMapAllWord.keySet().toArray(new String[hashMapAllWord.size()]);
        // String [][] arrayValue = hashMapAllWord.values().toArray(new String[hashMapAllWord.size()][]);
        return arrayKey[justNumber];

    }

    public static String[] getValue(int justNumber) {

        String[][] arrayValue = hashMapAllWord.values().toArray(new String[hashMapAllWord.size()][]);

        return arrayValue[justNumber];
    }

    static String[] transformingLineToArray(String line) {
        String line_without_space = line.replaceAll("(\\s+)*,\\s+", ",");
        String[] array = line_without_space.split(",");
        return array;
    }

    static Word onlyKey(String[] value, int progress) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Введите новое слово");
        String key = scanner1.nextLine();
        Map.Entry<String, String[]> entry = new AbstractMap.SimpleEntry<>(key, value);
        Word word = new Word(entry, progress);
        return word;
    }

    static Word onlyValue(String key, int progress) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Введите новый перевод (разделяйте слова запяой)");
        String valueScan = scanner1.nextLine();
        Map.Entry<String, String[]> entry = new AbstractMap.SimpleEntry<>(key, transformingLineToArray(valueScan));
        Word word = new Word(entry, progress);
        return word;
    }

    private static Word keyAndValue(int progress) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Введите новое слово");
        String key = scanner1.nextLine();
        System.out.println("Введите новый перевод (разделяйте слова запяой)");
        String valueScan = scanner1.nextLine();
        Map.Entry<String, String[]> entry = new AbstractMap.SimpleEntry<>(key, transformingLineToArray(valueScan));
        Word word = new Word(entry, progress);
        return word;
    }

    static void changeWord() throws IOException, ClassNotFoundException {
        scanner.nextLine();
        System.out.println("Введите слово которое хотите изменить");
        String word = scanner.nextLine();
        readAllFile();
        for (int i = 0; i < listWords.size(); i++) {
            if (listWords.get(i).wordAndTranslate.getKey().toLowerCase().equals(word.toLowerCase())) {
                System.out.println("Вы хотите изменить слово " + listWords.get(i).wordAndTranslate.getKey() +
                        " или перевод к нему? Введите\n1.Только слово \n2.Только перевод\n3.И слово и перевод\n4.Отмена "); //Доделать механизм изменения слова
//progres word должен сохраняться
                Word wordFromList = listWords.get(i);
                int action;
                try {
                    action = scanner.nextInt();
                } catch (InputMismatchException e) {
                    action = 9;
                }

                switch (action) {
                    case 1:
                        listWords.set(i, onlyKey(wordFromList.wordAndTranslate.getValue(), wordFromList.progressWord));
                        saveListWords();
                        break;
                    case 2:
                        listWords.set(i, onlyValue(wordFromList.wordAndTranslate.getKey(), wordFromList.progressWord));
                        saveListWords();
                        break;
                    case 3:
                        listWords.set(i, keyAndValue(wordFromList.progressWord));
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


    static void deleteWord() throws IOException, ClassNotFoundException {
        scanner.nextLine();
        System.out.println("Введите слово которое хотите удалить");
        String word = scanner.nextLine();
        readAllFile();
        for (Word w : listWords) {
            if (w.wordAndTranslate.getKey().equals(word)) {
                listWords.remove(w);
                System.out.println("Слово  " + word + " было удалено ");
                saveListWords();
                return;
            }
        }
        System.out.println("Не было найдено слово " + word);


    }

    //Просмотр всех слов в listWord
    static void viewMyWords() throws FileNotFoundException {
        readAllFile();
        for (Word word:listWords){
            System.out.println(word);
        }






    }
    static boolean scanningForAddSpecicificWordPart2(String word) {
        System.out.println("Начало метода scanningForAddSpecicificWordPart2");
        String scanner1or2Number2 = scanner.nextLine();
        if (scanner1or2Number2.equals("1")) {
            listWords.add(onlyValue(word, 0));
            return true;

        }
        if (scanner1or2Number2.equals("2")) {
            System.out.println("Метод добавления слова завершен ");
            return false;
        } else {
            System.out.println("Неверное значение, поробуйте ещё раз");
            return scanningForAddSpecicificWordPart2(word);
        }
    }

    static boolean scanningForAddSpecicificWordIfWordAbsentInFile(String word) {
        String scanner1or2Number2 = scanner.nextLine();
        if (scanner1or2Number2.equals("1")) {
            // listWord.add(keyAndValue(0));
            return true;

        }
        if (scanner1or2Number2.equals("2")) {
            System.out.println("Метод добавления слова завершен ");
            return false;
        } else {
            System.out.println("Неверное значение, поробуйте ещё раз");
            return scanningForAddSpecicificWordPart2(word);
        }
    }


    static boolean scanningForAddSpecicificWord(Map.Entry<String, String[]> entry, boolean isCalled) throws IOException {
        System.out.println("Начало метода scanningForAddSpecicificWord ");
        String scanner1or2 = scanner.nextLine();
        if (scanner1or2.equals("1")) {
            Map.Entry<String, String[]> entry2 = new AbstractMap.SimpleEntry<>(entry.getKey(), entry.getValue());
            Word w1 = new Word(entry2);
            System.out.println(" Слово " + entry.getKey() + " было добавоено в словарь ");
            listWords.add(w1);
            saveTextWord(w1);
            System.out.println("scanningForAddSpecicificWord конец метода 1 ");
            return true;
        } else if (scanner1or2.equals("2")) {
            System.out.println("Вы хотите ввестри перевод вручную? \n1.Да \n2.Нет ");
            scanningForAddSpecicificWordPart2(entry.getKey());
            System.out.println("scanningForAddSpecicificWord конец метода 2 ");
            return true;
        } else {
            return scanningForAddSpecicificWord(entry, isCalled);
        }

    }


    //Добавляет новое слово
    static void addSpecificWord() throws IOException, ClassNotFoundException {
        scanner.nextLine();
        System.out.println("Введите слово, которое хотите добавить");
        String word = scanner.nextLine();
        boolean scanningIsCalled = false;
        readAllFile();
        for (Word w : listWords) {
            if (w.wordAndTranslate.getKey().equals(word)) {

                System.out.println("Слово " + word + " уже есть в словаре");
                return;
            }
        }
        if (fileLoaded == false) {
            loadAllWordsInList();
        }
        for (Map.Entry<String, String[]> entry : hashMapAllWord.entrySet()) {

            if (word.equals(entry.getKey())) {
                String[] translate = entry.getValue();
                Map.Entry<String, String[]> entry2 = new AbstractMap.SimpleEntry<>(word, translate);
                Word w1 = new Word(entry2);
                listWords.add(w1);
                saveTextWord(w1);
                System.out.println("Слово " + word + " было добавлено в словарь");
                return;
            }
        }
        System.out.println("Кажется в нашей базе нет слова " + word);

        for (Map.Entry<String, String[]> entry : hashMapAllWordsFromFile.entrySet()) {
            if (word.toLowerCase().equals(entry.getKey())) {

                System.out.println(entry.getKey() + "-" + Arrays.toString(entry.getValue()));
                System.out.println("Вы хотите добавить это слово: \n1.Да \n2.Нет ");


                scanningIsCalled = scanningForAddSpecicificWord(entry, scanningIsCalled);

            }


        }
        if (scanningIsCalled == false) {
            System.out.println("Конец метода");
            System.out.println("Вы хотите добавить новое слово вручную? \n1.Да \n2.Нет");

            // Map.Entry<String, String[]> entry = new AbstractMap.SimpleEntry<>(word, transformingLineToArray(array));

            boolean createNewWord = scanningForAddSpecicificWordIfWordAbsentInFile(word);
            if (createNewWord == true) {
                Word w1 = onlyValue(word, 0);
                listWords.add(w1);
                saveTextWord(w1);
                System.out.println("Добавление слова вручную завершенно");
            }
        }
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
    static void addSpecificWord(String word, String[] translate) throws IOException {
        readAllFile();
        for (Word w : listWords) {
            if (w.wordAndTranslate.getKey().equals(word)) {

                System.out.println("Слово " + word + " уже есть в словаре");
                return;
            }
        }
        Map.Entry<String, String[]> entry = new AbstractMap.SimpleEntry<>(word, translate);
        Word w1 = new Word(entry);
        w1.progressWord = 0;
        listWords.add(w1);
        saveTextWord(w1);
        System.out.println("Слово " + word + " с вашим переводом " + translate + " было добавлено в словарь");

    }


    static void infinityAddRandomWordPart1() throws InterruptedException {
        boolean containWord = false;
        int random_int = r.nextInt(hashMapAllWord.size());
        String key = getKey(random_int);
        String[] value = getValue(random_int);
        for (Word w : listWords) {
            if (w.wordAndTranslate.getKey().equals(key)) {
                containWord = true;
            }
        }
        if (containWord == false) {
            Map.Entry<String, String[]> entry = new AbstractMap.SimpleEntry<>(key, value);
            listWords.add(new Word(entry));
            System.out.println("Было добавлено слово " + entry.getKey());
            return;
        } else {
            System.out.println("Не получилось добавить слово " + key);
            //  Thread.sleep(1);
            Thread.sleep(25);

            try {
                infinityAddRandomWordPart1();
            } catch (StackOverflowError e) {
                System.out.println("!!!!!!!!!");
                Thread.sleep(500);
            }

        }

    }

    public static Map.Entry<String, String[]> infinityAddRandomWordPart1(List<Map.Entry<String, String[]>> entryList) throws InterruptedException {
        int random_int = r.nextInt(hashMapAllWord.size());
        String key = getKey(random_int);
        String[] value = getValue(random_int);

        Map.Entry<String, String[]> entry = new AbstractMap.SimpleEntry<>(key, value);
        if (!entryList.contains(entry)) {
            entryList.add(entry);
            System.out.println("Было добавлено слово " + entry.getKey());
            return entry;
        } else {
            System.out.println("Не получилось добавить слово " + entry.getKey());
            Thread.sleep(1);
            //  Thread.sleep(25);

            try {
                return infinityAddRandomWordPart1(entryList);
            } catch (StackOverflowError e) {
                System.out.println("!!!!!!!!!");
                Thread.sleep(500);
                return null;
            }

        }

    }

    public static Map.Entry<String, String[]> infinityAddRandomWordPart1(List<Map.Entry<String, String[]>> entryList, Map.Entry<String, String[]> keyWord) throws InterruptedException {


        int random_int = r.nextInt(hashMapAllWord.size());
        String key = getKey(random_int);
        String[] value = getValue(random_int);

        Map.Entry<String, String[]> entry = new AbstractMap.SimpleEntry<>(key, value);
        boolean rezult = entry.getKey().equals(keyWord.getKey());
        System.out.println("entry key " + entry.getKey() + " keyWord key " + keyWord.getKey() + " rezult " + rezult); //удалить если не будет повторов слов в playsimplemethod
        if (entry.getKey().equals(keyWord.getKey())) {
            System.out.println("inner!!!!!"); //удалить если не будет повторов слов в playsimplemethod
            System.out.println("entry key " + entry.getKey() + " keyWord key " + keyWord.getKey() + " rezult " + rezult); //удалить если не будет повторов слов в playsimplemethod
            return infinityAddRandomWordPart1(entryList, keyWord);
        }
        if (!entryList.contains(entry)) {
            entryList.add(entry);
            System.out.println("Было добавлено слово " + entry.getKey());
            return entry;
        } else {
            System.out.println("Не получилось добавить слово " + entry.getKey());
            Thread.sleep(1);
            //  Thread.sleep(25);

            try {
                return infinityAddRandomWordPart1(entryList);
            } catch (StackOverflowError e) {
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
        Collections.shuffle(listWords);
        System.out.println("Тест начался");
        for (int i = 0; i < listWords.size(); i++) {
            listWords.get(i).oneWordHandlingFindKeyOrValue(1);
        }

        saveListWords();
        System.out.println("Тест закончен, количество правильных ответов " + numberOfCorrectWords + " количество неправильных ответов " + numberOfIncorrectAnswers);

    }

    static void playSimpleModValue() throws InterruptedException, IOException {

        readAllFile();
        numberOfCorrectWords = 0;
        numberOfIncorrectAnswers = 0;
        Collections.shuffle(listWords);
        System.out.println("Тест начался");
        for (int i = 0; i < listWords.size(); i++) {
            listWords.get(i).oneWordHandlingFindKeyOrValue(2);
        }

        saveListWords();
        System.out.println("Тест закончен, количество правильных ответов " + numberOfCorrectWords + " количество неправильных ответов " + numberOfIncorrectAnswers);

    }

    static void playAdvancedModKey() throws InterruptedException, IOException {

        readAllFile();
        numberOfCorrectWords = 0;
        numberOfIncorrectWords = 0;
        numberOfIncorrectAnswers = 0;
        Collections.shuffle(listWords);
        System.out.println("Тест начался");
        for (int i = 0; i < listWords.size(); i++) {
            listWords.get(i).oneWordHandlingKeyForDifficultMethod();
        }

        saveListWords();
        System.out.println("Тест закончен, количество правильных ответов " + numberOfCorrectWords + " количество неправильных ответов " + numberOfIncorrectAnswers + " количнство неправильных слов " + numberOfIncorrectWords);

    }

    static void playAdvancedModValue() throws InterruptedException, IOException {

        readAllFile();
        numberOfCorrectWords = 0;
        numberOfIncorrectWords = 0;
        numberOfIncorrectAnswers = 0;
        Collections.shuffle(listWords);
        System.out.println("Тест начался");
        for (int i = 0; i < listWords.size(); i++) {
            listWords.get(i).oneWordHandlingValueForDifficultMethod();
        }

        saveListWords();
        System.out.println("Тест закончен, количество правильных ответов " + numberOfCorrectWords + " количество неправильных ответов " + numberOfIncorrectAnswers + " количнство неправильных слов " + numberOfIncorrectWords);

    }

    static void enableDictiorary() throws IOException, InterruptedException, ClassNotFoundException {
        System.out.println("1.Проверить знания \n2.Добавить новое слово \n3.Редактировать слово \n4.Удалить слово \n5.Просмотр моих слов\n9.Выйтм");
        int custom_input = 0;
        try {
            custom_input = scanner.nextInt();
           // scanner.close();
        }
        catch (InputMismatchException e){
            scanner.nextLine();
            enableDictiorary();
            return;
        }
        switch (custom_input){
            case 1:checkKnowledge();
            break;
            case 2:addSpecificWord();
            break;
            case 3:changeWord();
            break;
            case 4:deleteWord();
            break;
            case 5:viewMyWords();
            break;
            case 9:
                return;
            default:System.out.println("Вы ввели неверное число, попробуйте ещё раз");
          //  scanner.nextLine();
            enableDictiorary();
            return;
        }
        System.out.println("Финальный метод"); //удалить sout
        enableDictiorary();

    }


    static void checkKnowledge() throws IOException, InterruptedException {
        System.out.println("Выберите режим проверки \n1.Простой поиск слова \n2.Простой поиск перевода \n3.Продвинутый поиск слова \n4.Продвинутый поиск перевода \n5.Отмена");
        int enteredValue = 5;

        try {
            enteredValue = scanner.nextInt();

        } catch (InputMismatchException e) {
            System.out.println("Вы должны ввести число");
            scanner.nextLine();
    checkKnowledge();

        }

        switch (enteredValue) {
            case 1:
                playSimpleModKey();
                break;
            case 2:
                playSimpleModValue();
                break;
            case 3:
                playAdvancedModKey();
                break;
            case 4:
                playAdvancedModValue();
                break;
            case 5:
                return;
            default:
                System.out.println("Вы ввели неверное число, попробуйте ещё раз");

                checkKnowledge();

        }
    }
    static void sorting() throws IOException {
        System.out.println("Выберите режим сортировки \n1.A-Z \n2.Z-A \n3.Прогресс 0-100 \n4.Прогресс 100-0 \n5.Отмена");
        int custom_input = 0;
        try {
            custom_input=scanner.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println("Вы должны ввести число");
            scanner.nextLine();
            sorting();
        }
        switch (custom_input){
            case 1:
                sortingNameA_Z();
                break;
            case 2:
                sortingNameZ_A();
                break;
            case 3:
                sortingProgress0_100();
                break;
            case 4:
                sortingProgress100_0();
                break;
            case 5:
                return;

            default:
                System.out.println("Вы ввели неверное число, попробуйте ещё раз");
                sorting();
        }



    }

}
