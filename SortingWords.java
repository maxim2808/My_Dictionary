package My_Dictonary_package;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

import static My_Dictonary_package.ForFile.readAllFile;
import static My_Dictonary_package.ForFile.saveListWords;
import static My_Dictonary_package.dictonary_application.listWords;

public class SortingWords {
    static void sortingNameA_Z() throws IOException {
        readAllFile();
        Collections.sort(listWords, Comparator.comparing(Word::wordGetKey));
        saveListWords();
    }
    static void sortingNameZ_A() throws IOException {
        readAllFile();
        Collections.sort(listWords, Comparator.comparing(Word::wordGetKey).reversed());
        saveListWords();
    }
    static void sortingProgress0_100() throws IOException {
        readAllFile();
        Collections.sort(listWords, new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                if(o1.progressWord>o2.progressWord){return 1;}
               else if(o1.progressWord<o2.progressWord){return -1;}
                else return 0;

            }
        });
saveListWords();
    }

    static void sortingProgress100_0() throws IOException {
        readAllFile();
        Collections.sort(listWords, new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                if(o1.progressWord>o2.progressWord){return -1;}
                else if(o1.progressWord<o2.progressWord){return 1;}
                else return 0;

            }
        });
    saveListWords();
    }






    public static void main(String[] args) throws IOException {
       // sortingNameA_Z();
        //sortingNameZ_A();
        sortingProgress0_100();
       // sortingProgress100_0();
        System.out.println(listWords);
    }


}
