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

    int increaseValue(){
        progressWord+=stepSize;
        if(progressWord>=100){
            progressWord = 100;
            return progressWord;
        }
        else return progressWord;
    };

    int decreaseValue(){
        progressWord-=stepSize;
        if(progressWord<=0){
            progressWord = 0;
            return progressWord;
        }
        else  return progressWord;

    }
        public boolean oneWordHandling() throws InterruptedException {
        System.out.println("chooseWord is starting");
        List<Map.Entry<String, String[]>> entryList = new ArrayList<>();
        Map.Entry <String, String[]> rightCouple = this.wordAndTranslate;
        entryList.add(rightCouple);
        for(int i=0; i<numberOfSuggestedWords-1; i++){

            infinityAddRandomWordPart1(entryList, rightCouple);
        }
        List<WordFromCheck> listWordFromChek = new ArrayList<>();
        Collections.shuffle(entryList);
        System.out.println("\n" + "Найдите перевод");
        System.out.println(Arrays.toString(rightCouple.getValue() ) + "\n");
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

            System.out.println((index)+"."+entryList.get(i).getKey());
        }
        //return checkWord(rightCouple);
             List <List<WordFromCheck>> twoList = new ArrayList<>();
        twoList.add(listWordFromChek);
        twoList.add(listOneTrueWord);
    //return twoList;
            return checkWord(twoList);

    }
//    public boolean oneWordHandling() throws InterruptedException {
//        System.out.println("chooseWord is starting");
//        List<Map.Entry<String, String[]>> entryList = new ArrayList<>();
//        Map.Entry <String, String[]> rightCouple = this.wordAndTranslate;
//        entryList.add(rightCouple);
//        for(int i=0; i<numberOfSuggestedWords-1; i++){
//
//            infinityAddRandomWordPart1(entryList, rightCouple);
//        }
//
//        Collections.shuffle(entryList);
//        System.out.println("\n" + "Найдите перевод");
//        System.out.println(Arrays.toString(rightCouple.getValue() ) + "\n");
//        for(int i=0; i<numberOfSuggestedWords; i++){
//            //infinityAddRandomWordPart1(entryList);
//            //toStringMapEntry(entryList.get(i));
//            System.out.println((i+1)+"."+entryList.get(i).getKey());
//        }
//        return checkWord(rightCouple);
//
//
//    }
    private boolean checkWord(List <List<WordFromCheck>> listWordFromCheck){
        System.out.println("Please, enter a word");
        String enteredWord = scanner.nextLine().toLowerCase();
        WordFromCheck trueWord = listWordFromCheck.get(1).get(0);
        Map.Entry<String, String[]> rightCouple = trueWord.getEntry();
        if(enteredWord.equals(rightCouple.getKey().toLowerCase())||enteredWord.equals(String.valueOf(trueWord.index))){
            System.out.println("Вы правы, правильное слово " + rightCouple.getKey());
            increaseValue();
            numberOfCorrectAnswers++;
            return true;
        }
        List <WordFromCheck> listAllChekWord = listWordFromCheck.get(0);
        for (WordFromCheck wfch:listAllChekWord){
            if (enteredWord.equals(wfch.getEntry().getKey().toLowerCase())||enteredWord.equals(String.valueOf(wfch.index))){
                System.out.println("Неверный ответ, попробуйте ещё раз");
                decreaseValue();
                numberOfIncorrectAnswers++;
                return checkWord(listWordFromCheck);
            }
        }
            System.out.println("Нет такого слова, попробуйте еще раз");
            //decreaseValue();
            return checkWord(listWordFromCheck);


    };

}
