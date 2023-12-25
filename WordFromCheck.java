package My_Dictonary_package;

import java.util.Arrays;
import java.util.Map;

public class WordFromCheck {
    Map.Entry <String, String[]> entry;
    boolean correctness;
    int index;
    int indexTrueWord;

    public WordFromCheck(Map.Entry<String, String[]> entry) {
        this.entry = entry;
        this.correctness = false;
    }

    public WordFromCheck(Map.Entry<String, String[]> entry, boolean correctness, int index) {
        this.entry = entry;
        this.correctness = correctness;
        this.index = index;
    }

    public Map.Entry<String, String[]> getEntry() {
        return entry;
    }

    public void setEntry(Map.Entry<String, String[]> entry) {
        this.entry = entry;
    }

    public boolean isCorrectness() {
        return correctness;
    }

    public void setCorrectness(boolean correctness) {
        this.correctness = correctness;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    //    public WordFromCheck(Map.Entry<String, String[]> entry, boolean correctness) {
//        this.entry = entry;
//        this.correctness = correctness;
//    }


    @Override
    public String toString() {
        return "WordFromCheck{" +
                "entry=" + entry.getKey() + " " + Arrays.toString(entry.getValue()) +
                ", correctness=" + correctness +
                ", index=" + index +
                '}';
    }
}
