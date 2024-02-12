package My_Dictonary_package;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;

import static My_Dictonary_package.ForFile.*;
import static My_Dictonary_package.SortingWords.*;
import static My_Dictonary_package.dictonary_application.*;

public class method_for_dictionary {

    public static void toStringMapEntry(Map.Entry<String, String[]> entry) {
        System.out.println(entry.getKey() + " " + Arrays.toString(entry.getValue()));
    }


    public static String getKey(int justNumber, Map<String, String[]> hashMap) {
        Iterator<Map.Entry<String, String[]>> iterator = dictonary_application.hashMapAllWord.entrySet().iterator();

        String[] arrayKey = hashMap.keySet().toArray(new String[hashMap.size()]);
        // String [][] arrayValue = hashMapAllWord.values().toArray(new String[hashMapAllWord.size()][]);
        return arrayKey[justNumber];

    }

    public static String[] getValue(int justNumber, Map<String, String[]> hashMap) {

        String[][] arrayValue = hashMap.values().toArray(new String[hashMap.size()][]);

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
       // readAllFile();
        for (int i = 0; i < listWords.size(); i++) {
            if (listWords.get(i).wordAndTranslate.getKey().toLowerCase().equals(word.toLowerCase())) {
                System.out.println("Вы хотите изменить слово " + listWords.get(i).wordAndTranslate.getKey() +
                        " или перевод к нему? Введите\n1.Только слово \n2.Только перевод\n3.И слово и перевод\n4.Отмена ");
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
       // readAllFile();
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

    static void deleteAllWord() throws IOException {
        scanner.nextLine();
        System.out.println("Вы точно хотите удалить все слова без возможности восстановления? \n1.Да \n2.Нет");
        String inputValue = scanner.nextLine();
        if(inputValue.equals("1")){
         //   readAllFile();
            listWords.removeAll(listWords);
            saveListWords();
        }
        if(inputValue.equals("2")){
            return;
        }
        else {
            System.out.println("Вы ввели неверное значение, попробуйте ещё раз");
        }
    }

    //Просмотр всех слов в listWord
    static void viewMyWords() throws FileNotFoundException {
     //   readAllFile();
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
      //  readAllFile();
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

    static int addRandomFordFromFile(int numberOfFailedAttempts
                                              ) throws InterruptedException {
        if(numberOfFailedAttempts>50){
            continueAddRandom = false;
            System.out.println("Прерывание метода addRandomWord " + numberOfFailedAttempts);
            return numberOfFailedAttempts; }

        boolean containWord = false;

        int random_int = r.nextInt(hashMapAllWordsFromFile.size());
        String key = getKey(random_int, hashMapAllWordsFromFile);
        String[] value = getValue(random_int, hashMapAllWordsFromFile);
        for (Word w : listWords) {
            if (w.wordAndTranslate.getKey().equals(key)) {
                containWord = true;
            }
        }
        if (containWord == false) {
            Map.Entry<String, String[]> entry = new AbstractMap.SimpleEntry<>(key, value);
            listWords.add(new Word(entry));
            System.out.println("Было добавлено слово " + entry.getKey());
            numberOfFailedAttempts = 0;
            return numberOfFailedAttempts;
        }
        else {
          //  System.out.println("Не получилось добавить слово " + key ); //убрать
          //  System.out.println("Не получилось добавить слово " + key ); //убрать
            numberOfFailedAttempts++;
            try {
                addRandomFordFromFile(numberOfFailedAttempts);
            } catch (Exception e) {
                System.out.println("Произошла ошибка");

            }
            return numberOfFailedAttempts;
        }
    };

    public static Map.Entry<String, String[]> addRandomFordFromFile(List<Map.Entry<String, String[]>> entryList) throws InterruptedException {
        int random_int = r.nextInt(listWords.size());
        String key = listWords.get(random_int).wordAndTranslate.getKey();
        String[] value = listWords.get(random_int).wordAndTranslate.getValue();

        Map.Entry<String, String[]> entry = new AbstractMap.SimpleEntry<>(key, value);
        if (!entryList.contains(entry)) {
            entryList.add(entry);
        //    System.out.println("Было добавлено слово " + entry.getKey());
            return entry;
        } else {
           // System.out.println("Не получилось добавить слово " + entry.getKey());
            Thread.sleep(1);

            try {
                return addRandomFordFromFile(entryList);
            } catch (StackOverflowError e) {
                System.out.println("!!!!!!!!!");
                Thread.sleep(500);
                return null;
            }

        }

    }

    public static Map.Entry<String, String[]> addRandomFordFromFile(List<Map.Entry<String, String[]>> entryList, Map.Entry<String, String[]> keyWord) throws FileNotFoundException, InterruptedException {
//            if(fileLoaded==false){
//            readAllFile();}
        int random_int = r.nextInt(listWords.size());
        String key = listWords.get(random_int).wordAndTranslate.getKey();
        String[] value = listWords.get(random_int).wordAndTranslate.getValue();

        Map.Entry<String, String[]> entry = new AbstractMap.SimpleEntry<>(key, value);
        boolean rezult = entry.getKey().equals(keyWord.getKey());

        if (entry.getKey().equals(keyWord.getKey())) {
            return addRandomFordFromFile(entryList, keyWord);
        };
        boolean wordPresentInList = false;
        for(Map.Entry<String, String[]> entryFromList:entryList){
            if (entryFromList.getKey().equals(entry.getKey())){
                wordPresentInList = true;
            }
        }
        if (wordPresentInList==false){

            entryList.add(entry);
            System.out.println("Было добавлено слово " + entry.getKey());
            return entry;
        }
        else {
            System.out.println("Не получилось добавить слово " + entry.getKey());
            Thread.sleep(1);
            //  Thread.sleep(25);

            try {
                return addRandomFordFromFile(entryList, keyWord);
            } catch (StackOverflowError e) {
                System.out.println("!!!!!!!!!");
                Thread.sleep(500);
                return null;
            }
        }

    }
//    public static Map.Entry<String, String[]> addRandomFordFromFile(List<Map.Entry<String, String[]>> entryList, Map.Entry<String, String[]> keyWord)
//            throws InterruptedException, FileNotFoundException {
//        if(fileLoaded==false){
//            readAllFile();}
//        int random_int = r.nextInt(listWords.size());
//        String key = listWords.get(random_int).wordAndTranslate.getKey();
//        String[] value = listWords.get(random_int).wordAndTranslate.getValue();
//
//        Map.Entry<String, String[]> entry = new AbstractMap.SimpleEntry<>(key, value);
//        boolean rezult = entry.getKey().equals(keyWord.getKey());
//
//        if (entry.getKey().equals(keyWord.getKey())) {
//            return addRandomFordFromFile(entryList, keyWord);
//        };
//        boolean wordPresentInList = false;
//        for(Map.Entry<String, String[]> entryFromList:entryList){
//            if (entryFromList.getKey().equals(entry.getKey())){
//                wordPresentInList = true;
//            }
//        }
//        if (wordPresentInList==false){
//
//            entryList.add(entry);
//            System.out.println("Было добавлено слово " + entry.getKey());
//            return entry;
//        }
//        else {
//            System.out.println("Не получилось добавить слово " + entry.getKey());
//            Thread.sleep(1);
//            //  Thread.sleep(25);
//
//            try {
//                return addRandomFordFromFile(entryList, keyWord);
//            } catch (StackOverflowError e) {
//                System.out.println("!!!!!!!!!");
//                Thread.sleep(500);
//                return null;
//            }
//        }
//
//    }


    public static void addMuchWords() throws InterruptedException, IOException {
        int number = 0;
        System.out.println("Введите количество слов, которое вы хотите добавить");
        try {
             number = scanner.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println("Вы ввели неверное значение, попробуйте ещё раз");
            scanner.nextLine();
            addMuchWords();
            return;
            //доделать метод через сканнер
        }
        if (fileLoaded == false) {
            loadAllWordsInList();
        }
        ;
            for (int i = 0; i < number; i++) {
             addRandomFordFromFile(0);
               if (continueAddRandom==false){
                   System.out.println("Не получается добавить слово/слова, возможно все/почти все слова из базы уже есть в вашем словаре");
                   return;
               }

            }
            saveListWords();
    }

    static void playSimpleModKey() throws InterruptedException, IOException {
       // readAllFile();
        if (fileLoaded==false){readAllFile();}
        if (listWords.size()>=numberOfSuggestedWords) {
           // readAllFile();
            numberOfCorrectWords = 0;
            numberOfIncorrectAnswers = 0;
            Collections.shuffle(listWords); //вернуть после теста

            System.out.println("Тест начался");


            for (int i = 0; i < listWords.size(); i++) {
//                System.out.println(listWords);
//                System.out.println("Запускаем метод oneWordHandlingFindKeyOrValue на слове " + listWords.get(i).wordAndTranslate.getKey());
                listWords.get(i).oneWordHandlingFindKeyOrValue(1, i);
            }
;

            saveListWords();
            System.out.println("Тест закончен, количество правильных ответов " + numberOfCorrectWords + " количество неправильных ответов " + numberOfIncorrectAnswers);
        }
        else {
            System.out.println("Для запуска данного режима в словаре должно быть минимум " + numberOfSuggestedWords + " слов, сейчас в словаре их " + listWords.size());

        }
    }

    static void playSimpleModValue() throws InterruptedException, IOException {
        if (listWords.size()>=numberOfSuggestedWords) {
          //  if (fileLoaded==false){readAllFile();}
            numberOfCorrectWords = 0;
            numberOfIncorrectAnswers = 0;
            Collections.shuffle(listWords);
            System.out.println("Тест начался");
            for (int i = 0; i < listWords.size(); i++) {
                listWords.get(i).oneWordHandlingFindKeyOrValue(2, i);
            }

            saveListWords();
            System.out.println("Тест закончен, количество правильных ответов " + numberOfCorrectWords + " количество неправильных ответов " + numberOfIncorrectAnswers);
        }
        else {System.out.println("Для запуска данного режима в словаре должно быть минимум " + numberOfSuggestedWords + " слов");}
    }

    static void playAdvancedModKey() throws InterruptedException, IOException {

       // if (fileLoaded==false){readAllFile();}
        numberOfCorrectWords = 0;
        numberOfIncorrectWords = 0;
        numberOfIncorrectAnswers = 0;
      //  Collections.shuffle(listWords);
        System.out.println("Тест начался");
        for (int i = 0; i < listWords.size(); i++) {
            listWords.get(i).oneWordHandlingKeyForDifficultMethod();
        }

        saveListWords();
        System.out.println("Тест закончен, количество правильных ответов " + numberOfCorrectWords + " количество неправильных ответов " + numberOfIncorrectAnswers + " количнство неправильных слов " + numberOfIncorrectWords);

    }

    static void playAdvancedModValue() throws InterruptedException, IOException {
    scanner.nextLine();
      //  if (fileLoaded==false){readAllFile();}
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
        if(fileLoaded==false){readAllFile();};
        System.out.println("1.Проверить знания \n2.Добавить новое слово \n3.Редактировать слово \n4.Удалить слово" +
                " \n5.Просмотр моих слов\n6.Выбрать сортировку слов \n7.Особые возможности\n9.Выйтм");
        int custom_input = 0;
        try {
            custom_input = scanner.nextInt();
           // scanner.close();
        }
        catch (InputMismatchException e){
            System.out.println("Вы ввели неверное значение, попробуйте ещё раз");
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
            case 6:sorting();
            break;
            case 7:specialFeatures();
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
       // if(fileLoaded==false){readAllFile();};
     //   Collections.shuffle(listWords);
       // scanner.nextLine();
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

    static  void specialFeatures() throws IOException, InterruptedException {
        System.out.println("1.Добавить случайные слова из базы \n2.Удалить все слова \n3.Отмена");
        int custom_input = 0;
        try {
            custom_input=scanner.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println("Вы должны ввести число");
            scanner.nextLine();
            specialFeatures();
        }
        switch (custom_input){
            case 1:
                addMuchWords();
                break;
            case 2:
                deleteAllWord();
                break;
            case 3:
                return;
            default:
                System.out.println("Вы ввели неверное число, попробуйте ещё раз");
                specialFeatures();

        }
    }

}
