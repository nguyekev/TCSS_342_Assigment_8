
import java.io.IOException;
public class UniqueWords {
    private BookReader book = new BookReader("WarAndPeace.txt");

    public UniqueWords() throws IOException {
        addUniqueWordsToLinkedList();
        addUniqueWordsToAVL();
    }

    public void addUniqueWordsToLinkedList() {
        String words = book.getWords().first();
        MyLinkedList<String> uniqueWords = new MyLinkedList<>();
        while (words != null) {
            if (!uniqueWords.contains(words)) {
                if (uniqueWords.isEmpty()) {
                    uniqueWords.addBefore(words);
                    uniqueWords.first();
                } else {
                    uniqueWords.addAfter(words);
                    uniqueWords.next();
                }
            }
            words = book.getWords().next();
        }
    }
    public void addUniqueWordsToAVL() {
    }
    public static void main(String[] args) throws IOException {
        new UniqueWords();
    }

}
