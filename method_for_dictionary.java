package My_Dictonary_package;

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

   private static void infinityAddRandomWordPart1() throws InterruptedException {


        Map.Entry<String, String[]> entry = getCoupleKeyValue(r.nextInt(hashMapAllWord.size()));
        if(!listPartOfWords.contains(entry)){listPartOfWords.add(entry);
            System.out.println("Было добавлено слово " + entry.getKey());
            return;
        }
        else {
            System.out.println("Не получилось добавить слово " + entry.getKey());
            Thread.sleep(1);
          //  Thread.sleep(25);

            try {
                infinityAddRandomWordPart1();
            }
            catch (StackOverflowError e){
                System.out.println("!!!!!!!!!");
                Thread.sleep(500);
            }

        }

    }
    static Map.Entry<String, String[]> infinityAddRandomWordPart1(List <Map.Entry<String, String[]>> entryList) throws InterruptedException {


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

    static Map.Entry<String, String[]> infinityAddRandomWordPart1(List <Map.Entry<String, String[]>> entryList, Map.Entry<String, String[]> keyWord) throws InterruptedException {


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

//        static public boolean oneWordHandling() throws InterruptedException {
//            System.out.println("chooseWord is starting");
//            List <Map.Entry<String, String[]>> entryList = new ArrayList<>();
//            for(int i=0; i<numberOfSuggestedWords; i++){
//                infinityAddRandomWordPart1(entryList);
//               // toStringMapEntry(entryList.get(i));
//            }
//
//           //заменить на рандомное число в последствии
//            Map.Entry <String, String[]> rightCouple = entryList.get(randomNumber);
//            System.out.println("\n" + "Найдите перевод");
//            System.out.println(Arrays.toString(rightCouple.getValue() ) + "\n");
//            for(int i=0; i<numberOfSuggestedWords; i++){
//                //infinityAddRandomWordPart1(entryList);
//                //toStringMapEntry(entryList.get(i));
//                System.out.println(entryList.get(i).getKey());
//            }
//          return checkWord(rightCouple);
//
//
//        }

//    static private boolean checkWord(Map.Entry<String, String[]> rightCouple){
//        System.out.println("Please, enter a word");
//        String enteredWord = scanner.nextLine();
//        if(enteredWord.equals(rightCouple.getKey())){
//            System.out.println("Вы правы, правильное слово " + rightCouple.getKey());
//            return true;
//        }
//        else{
//            System.out.println("Неверный ответ");
//            return checkWord(rightCouple);
//        }
//
//    };
    static List<Word> createWordObjects(){
        for(Map.Entry<String, String[]> entry:listPartOfWords){
            listWord.add(new Word(entry,0));

        }
        return listWord;
    }
    static void playSimpleMod() throws InterruptedException {
        Collections.shuffle(listWord);
        for(int i=0; i<listWord.size(); i++){
        listWord.get(i).oneWordHandling();
        }



    }


    }







