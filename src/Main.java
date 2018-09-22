//Написать программу для подсчета наиболее встречающихся слов в неком тексте произведения Алиса в стране чудес.
//        Файл с текстом прилагается.
//        При выводе резульатов привести первые 10 наиболее встречающихся слова с указанием их количества.
//        Пример вывода:
//
//        алиса: 406
//        сказала: 126
//        было: 105
//        сказал: 100
//        если: 87
//        только: 87
//        очень: 71
//        когда: 64
//        король: 61
//        подумала: 61
//
//        Подсчет слов не должен учитывать регистр и знаки препинания
//        Желательно использовать стримы при решении этой задачи

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.Comparator;
public class Main {

    public static <subStr> void main(String[] args) throws IOException {
        List<Word> words = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get("alice.txt"), StandardCharsets.UTF_8);
        for (String line : lines) {
            String[] subStr = line.split("\\s");
            for (int i = 0; i < subStr.length; i++){

                if (!subStr[i].equals("")&&!subStr[i].equals("-")) {
                    if(words.size()==0) {
                        words.add(new Word(subStr[i]));
                    }
                    else {
                        int f=0;
                        for (Word word : words) {
                            if (word.word.equals(subStr[i])) {
                                word.size += 1;
                                f=1;
                            }
                       }
                        if (f==0)
                        words.add(new Word(subStr[i]));
                    }
             }
        }

        }
        Map map=new LinkedHashMap();
        words.sort(new SortByCost());
        for (Word word : words) {
           // System.out.println("Слово: %s Встречается: %d раз ", word.word, word.size);
            map.put(word.word,word.size);
            System.out.println("Слово: "+word.word+" Встречается: "+word.size+" раз \n ");
        }
        System.out.println(map);
    }
}
class Word{
    public Word(String word) {
        this.word = word;
    }
   String word;
    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    int size=1;
}
class SortByCost implements Comparator<Word> {
    public int compare(Word a, Word b) {
        if ( a.size < b.size ) return 1;
        else if ( a.size == b.size ) return 0;
        else return -1;
    }
}
