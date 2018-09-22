package topWord;

import java.util.Comparator;

public class SortBySize implements Comparator<Word> {
    public int compare(Word a, Word b) {
        if ( a.size < b.size ) return 1;
        else if ( a.size == b.size ) return 0;
        else return -1;
    }
}
