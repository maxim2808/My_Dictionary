package My_Dictonary_package;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;

import static My_Dictonary_package.dictonary_application.*;
import static My_Dictonary_package.method_for_dictionary.infinityAddRandomWordPart1;

class  Word implements Serializable {


    @Serial
    private static final long serialVersionUID = 7470618750420725594L;
    Map.Entry<String, String[]> wordAndTranslate;
    int progressWord;

    public Word(Map.Entry<String, String[]> wordAndTranslate) {
        this.wordAndTranslate = wordAndTranslate;
        this.progressWord = 0;

    }

    public Word(Map.Entry<String, String[]> wordAndTranslate, int progressWord) {
        this.wordAndTranslate = wordAndTranslate;
        this.progressWord = progressWord;
    }

    @Override
    public String toString() {
        return
                wordAndTranslate.getKey() + " " + Arrays.toString(wordAndTranslate.getValue()) +
                        ", progressWord=" + progressWord +
                        '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(wordAndTranslate, word.wordAndTranslate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wordAndTranslate);
    }

    int increaseValue(boolean firstTry, int multiplier){
        if (firstTry){
            numberOfCorrectWords++;
            progressWord+=(stepSize*multiplier);
            if(progressWord>=100){
                progressWord = 100;

                return progressWord;

            }
            else return progressWord;

        };
        return progressWord;
    };


    int decreaseValue(boolean firstTry, int multiplier){
        if (firstTry==true){
            numberOfIncorrectWords++;
        }
        progressWord-=(stepSize*multiplier);
        numberOfIncorrectAnswers++;
        if(progressWord<=0){
            progressWord = 0;
            return progressWord;
        }
        else  return progressWord;

    }

    StringBuilder patrialReconcilationKey(String keyWord, String scanningWord, int lenghHelpWord){
        int index = 0;
        int minLengh = Math.min(keyWord.length(), scanningWord.length());
        for (int i=0; i<minLengh; i++){
            if (keyWord.toLowerCase().charAt(i)==scanningWord.toLowerCase().charAt(i)){
                index++;

            }
            else {
                break;
            }
        }
        int finallyIndex = Math.max(lenghHelpWord, index);
        StringBuilder stringBuilder = new StringBuilder("");
        for(int i=0; i<finallyIndex; i++){
            stringBuilder.append(keyWord.charAt(i));

        }
        return stringBuilder;

    }



    Map.Entry<Integer, StringBuilder> patrialReconcilationValue(String scanningWord, int lenghHelpWord){
        int [] numberReconcilationArray = new int[this.wordAndTranslate.getValue().length];

for(int i=0; i<this.wordAndTranslate.getValue().length; i++){
    int number_coindences = 0;
    int minLengh = Math.min(this.wordAndTranslate.getValue()[i].length(), scanningWord.length());

    for(int j=0; j<minLengh; j++) {

        if (scanningWord.toLowerCase().charAt(j) == this.wordAndTranslate.getValue()[i].toLowerCase().charAt(j)) {
            number_coindences++;
        }
numberReconcilationArray[i]=number_coindences;
    }

}
        int maxCoindence = numberReconcilationArray[0];
        int word_number = 0;
        for(int i=1; i<numberReconcilationArray.length; i++){
            if(numberReconcilationArray[i]>maxCoindence){
                maxCoindence = numberReconcilationArray[i];
                word_number = i;
            }

        }

        System.out.println("max " + maxCoindence);
        System.out.println("word number " + word_number);
        StringBuilder stringBuilder = new StringBuilder("");
        if(lenghHelpWord<maxCoindence){

            for(int i=0; i<maxCoindence; i++){
                stringBuilder.append(this.wordAndTranslate.getValue()[word_number].charAt(i));

            }
            Map.Entry<Integer, StringBuilder> entry = new AbstractMap.SimpleEntry<>(word_number, stringBuilder);
            return entry;


        }
        else {
            for(int i=0; i<lenghHelpWord; i++){
                stringBuilder.append(this.wordAndTranslate.getValue()[word_number].charAt(i)); //если совпадает второе слово то код лломается при привышении длинны

            }
            Map.Entry<Integer, StringBuilder> entry = new AbstractMap.SimpleEntry<>(word_number, stringBuilder);
            return entry;


        }
       // int finallyCoindences = Math.max(lenghHelpWord, maxCoindence);




//        int index = 0;
//        int minLengh = Math.min(keyWord.length(), scanningWord.length());
//        for (int i=0; i<minLengh; i++){
//            if (keyWord.toLowerCase().charAt(i)==scanningWord.toLowerCase().charAt(i)){
//                index++;
//
//            }
//            else {
//                break;
//            }
//        }
//        int finallyIndex = Math.max(lenghHelpWord, index);
//        StringBuilder stringBuilder = new StringBuilder("");
//        for(int i=0; i<finallyIndex; i++){
//            stringBuilder.append(keyWord.charAt(i));
//
//        }

    }







boolean wordFromTheArrayMatches(String enteredWord){
    boolean wordFromTheArrayMatches = false;
    for (int i=0; i<this.wordAndTranslate.getValue().length; i++){
//            System.out.println("!!!!!");
//            System.out.println(Arrays.toString(this.wordAndTranslate.getValue()));
//            System.out.println(this.wordAndTranslate.getValue()[i].equals(enteredWord));


        if(this.wordAndTranslate.getValue()[i].toLowerCase().equals(enteredWord)){


            wordFromTheArrayMatches = true;
            break;
        }}
return wordFromTheArrayMatches;
    };

    //delete method
    //    List<Map.Entry<String, String[]>> fillOutTheList(Map.Entry <String, String[]> rightCouple) throws InterruptedException {
//        System.out.println("chooseWord is starting");
//        List<Map.Entry<String, String[]>> entryList = new ArrayList<>();
//        entryList.add(rightCouple);
//        for(int i=0; i<numberOfSuggestedWords-1; i++){
//
//            infinityAddRandomWordPart1(entryList, rightCouple);
//        }
//        List<WordFromCheck> listWordFromChek = new ArrayList<>();
//        Collections.shuffle(entryList);
//        System.out.println("\n" + "Найдите перевод");
//        return entryList;
//
//
//    }

        public boolean oneWordHandlingFindKeyOrValue(int incomingNumber) throws InterruptedException {
        System.out.println("chooseWord is starting");
        List<Map.Entry<String, String[]>> entryList = new ArrayList<>();
            Map.Entry <String, String[]> rightCouple = this.wordAndTranslate;

        entryList.add(rightCouple);
        for(int i=0; i<numberOfSuggestedWords-1; i++){

            infinityAddRandomWordPart1(entryList, rightCouple);
        }

        Collections.shuffle(entryList);
        System.out.println("\n" + "Найдите перевод");

            List<WordFromCheck> listWordFromChek = new ArrayList<>();
         //   List<Map.Entry<String, String[]>> entryList = fillOutTheList(rightCouple);
            if (incomingNumber==1)
        System.out.println(Arrays.toString(rightCouple.getValue() ) + "\n");
            if(incomingNumber==2)
                System.out.println(rightCouple.getKey()  + "\n");
        int index;
            List<WordFromCheck> listOneTrueWord = new ArrayList<>();
        for(int i=0; i<numberOfSuggestedWords; i++){
            //infinityAddRandomWordPart1(entryList);
            //toStringMapEntry(entryList.get(i));
            index = i+1;

            if(rightCouple.getKey().equals(entryList.get(i).getKey())){
                WordFromCheck w = new WordFromCheck(entryList.get(i), true, index);
                listWordFromChek.add(w);
                listOneTrueWord.add(w);
            }
            else listWordFromChek.add(new WordFromCheck(entryList.get(i), false, index));
            if(incomingNumber==1)
            System.out.println((index)+"."+entryList.get(i).getKey());
            if(incomingNumber==2)
                System.out.println((index)+"."+Arrays.toString(entryList.get(i).getValue()));

        }
        //return checkWord(rightCouple);
             List <List<WordFromCheck>> twoList = new ArrayList<>();
        twoList.add(listWordFromChek);
        twoList.add(listOneTrueWord);
    //return twoList;
            return simpleCheckWord(twoList, true);

    }
    public boolean oneWordHandlingKeyForDifficultMethod (){
        String [] copyArray = this.wordAndTranslate.getValue();
        Collections.shuffle(Arrays.asList(copyArray));
        System.out.println(Arrays.toString(copyArray));
        return advancedCheckWord(new StringBuilder(""), 0, true, "key");


    }

    public boolean oneWordHandlingValueForDifficultMethod (){
        System.out.println(this.wordAndTranslate.getKey())
        ;
        System.out.println("Подсказка (потом удалить) " + Arrays.toString(this.wordAndTranslate.getValue()) );
        return advancedCheckWord(new StringBuilder(""), 0, true, "value");


    }




//    public boolean oneWordHandlingFindValue() throws InterruptedException {
//        Map.Entry <String, String[]> rightCouple = this.wordAndTranslate;
//        List<WordFromCheck> listWordFromChek = new ArrayList<>();
//        List<Map.Entry<String, String[]>> entryList = fillOutTheList(rightCouple);
//        System.out.println(rightCouple.getKey() + "\n");
//    }




    private boolean simpleCheckWord(List <List<WordFromCheck>> listWordFromCheck, boolean first_try){
        System.out.println("Please, enter a word");
        String enteredWord = scanner.nextLine().toLowerCase();
        WordFromCheck trueWord = listWordFromCheck.get(1).get(0);
        Map.Entry<String, String[]> rightCouple = trueWord.getEntry();
        if(enteredWord.equals(String.valueOf(trueWord.index))){
            System.out.println("Вы правы, правильное слово " + rightCouple.getKey());
            increaseValue(first_try, 1);
            //numberOfCorrectWords++;
            return true;
        }
        List <WordFromCheck> listAllChekWord = listWordFromCheck.get(0);
        for (WordFromCheck wfch:listAllChekWord){
            if (enteredWord.equals(String.valueOf(wfch.index))){
                System.out.println("Неверный ответ, попробуйте ещё раз");
                decreaseValue(false, 1);
                //numberOfIncorrectAnswers++;
                return simpleCheckWord(listWordFromCheck, false);
            }
        }
        System.out.println("Нет такого слова, попробуйте еще раз");
        //decreaseValue();
        return simpleCheckWord(listWordFromCheck, first_try);


    };


    private boolean advancedCheckWord(StringBuilder s, int index, boolean first_try, String mode ){
        System.out.println("Mode " + mode);
        StringBuilder helpWord = new StringBuilder(s);
        System.out.println("Please, enter a word");
        String enteredWord = scanner.nextLine().toLowerCase();
        String trueKey;
        trueKey = this.wordAndTranslate.getKey();
        if(mode.equals("key")){

        if(enteredWord.toLowerCase().equals(trueKey.toLowerCase())){
            System.out.println("Вы правы, правильное слово " + trueKey);
            increaseValue(first_try, 2);
            return true;
        }
        };
        if(mode.equals("value"))
        {
          //  System.out.println("value starting");
        boolean Matches = wordFromTheArrayMatches(enteredWord);
//        for (int i=0; i<this.wordAndTranslate.getValue().length; i++){
////            System.out.println("!!!!!");
////            System.out.println(Arrays.toString(this.wordAndTranslate.getValue()));
////            System.out.println(this.wordAndTranslate.getValue()[i].equals(enteredWord));
//
//
//            if(this.wordAndTranslate.getValue()[i].toLowerCase().equals(enteredWord)){
//
//
//                wordFromTheArrayMatches = true;
//                break;
//            }
//        }
            System.out.println("Есть совпадение " + Matches);

        if (Matches==true){
            System.out.println("Вы правы, правильный перевод " + Arrays.toString(this.wordAndTranslate.getValue()));
            increaseValue(first_try, 2);
            return true;
        }
        }
        if (enteredWord.replaceAll(" ","").equals("")){
            System.out.println("Вы ничего не ввели");
            if(mode.equals("key")){
            return  advancedCheckWord(helpWord, index, first_try, "key");

            }
            if(mode.equals("value")){
                return  advancedCheckWord(helpWord, index, first_try, "value");

            }
        }
        if(enteredWord.toLowerCase().equals("help")){
            if(mode.equals("key")) {
                System.out.println(trueKey);
            }
            if(mode.equals("value")){
                System.out.println(Arrays.toString(this.wordAndTranslate.getValue()));
            }

          decreaseValue(first_try, 2);
            numberOfIncorrectAnswers--;
            return true;
        }
        else {
            //  System.out.println("Неверный ответ, правильное слово " + trueKey);
            //  helpWord.append(trueKey.charAt(index));
            // System.out.println(helpWord);
            if (mode.equals("key")) {
                helpWord = patrialReconcilationKey(trueKey, enteredWord, index);

            index = helpWord.length();
            helpWord.append(trueKey.charAt(index));
            index++;
            System.out.println(helpWord);
            decreaseValue(first_try, 1);

            if (helpWord.toString().equals(trueKey)) {

                System.out.println("Правильное слово " + trueKey);

//                increaseValue();
//                increaseValue();
//                numberOfCorrectWords++;}
                return true;
            }

            else {

            System.out.println("Неверный ответ, правильное слово " + trueKey);

            return advancedCheckWord(helpWord, index, false, "key");}
        }

            if(mode=="value"){
                Map.Entry <Integer, StringBuilder> entry = patrialReconcilationValue(enteredWord, index);
                helpWord = entry.getValue();
                index = helpWord.length();
                int word_number = entry.getKey();
                if(this.wordAndTranslate.getValue().length>0) {
                    helpWord.append(this.wordAndTranslate.getValue()[word_number].charAt(index));
                    index++;
                    System.out.println(helpWord);
                    decreaseValue(first_try, 1);
                    for(int i=0; i<this.wordAndTranslate.getValue().length; i++){




                    }
                    System.out.println();
                    if (wordFromTheArrayMatches(helpWord.toString().toLowerCase())==true) {


                        System.out.println("Правильный перевод " + Arrays.toString(this.wordAndTranslate.getValue()));

//                increaseValue();
//                increaseValue();
//                numberOfCorrectWords++;}
                        return true;
                    }

                }


                return advancedCheckWord(helpWord, index, false, "value");
            }


        else return true;}




    }}






//    private boolean advancedCheckWord(List <List<WordFromCheck>> listWordFromCheck){
//        System.out.println("Please, enter a word");
//        String enteredWord = scanner.nextLine().toLowerCase();
//        WordFromCheck trueWord = listWordFromCheck.get(1).get(0);
//        Map.Entry<String, String[]> rightCouple = trueWord.getEntry();
//        if(enteredWord.equals(rightCouple.getKey().toLowerCase())){
//            System.out.println("Вы правы, правильное слово " + rightCouple.getKey());
//            increaseValue();
//            numberOfCorrectAnswers++;
//            return true;
//        }
//        List <WordFromCheck> listAllChekWord = listWordFromCheck.get(0);
//        for (WordFromCheck wfch:listAllChekWord){
//            if (enteredWord.equals(wfch.getEntry().getKey().toLowerCase())){
//                System.out.println("Неверный ответ, попробуйте ещё раз");
//                decreaseValue();
//                numberOfIncorrectAnswers++;
//                return advancedCheckWord(listWordFromCheck);
//            }
//        }
//            System.out.println("Нет такого слова, попробуйте еще раз");
//            //decreaseValue();
//            return advancedCheckWord(listWordFromCheck);
//
//
//    };


