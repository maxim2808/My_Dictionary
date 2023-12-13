package My_Dictonary_package;

import java.util.*;

import static My_Dictonary_package.dictonary_application.*;
import static My_Dictonary_package.method_for_dictionary.infinityAddRandomWordPart1;

class Word {
    Map.Entry<String, String[]> wordAndTranslate;
    int progressWord;

    public Word(Map.Entry<String, String[]> wordAndTranslate) {
        this.wordAndTranslate = wordAndTranslate;
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

        Collections.shuffle(entryList);
        System.out.println("\n" + "Найдите перевод");
        System.out.println(Arrays.toString(rightCouple.getValue() ) + "\n");
        for(int i=0; i<numberOfSuggestedWords; i++){
            //infinityAddRandomWordPart1(entryList);
            //toStringMapEntry(entryList.get(i));
            System.out.println(entryList.get(i).getKey());
        }
        return checkWord(rightCouple);


    }
    private boolean checkWord(Map.Entry<String, String[]> rightCouple){
        System.out.println("Please, enter a word");
        String enteredWord = scanner.nextLine();
        if(enteredWord.equals(rightCouple.getKey())){
            System.out.println("Вы правы, правильное слово " + rightCouple.getKey());
            increaseValue();
            return true;
        }
        else{
            System.out.println("Неверный ответ");
            decreaseValue();
            return checkWord(rightCouple);
        }

    };

}