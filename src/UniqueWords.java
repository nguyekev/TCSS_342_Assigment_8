
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
        String words = book.getWords().first();
        MyAVLTree<String> uniqueWords = new MyAVLTree<>();
        while (words != null) {
            if (!uniqueWords.contains(words)) {
                if (uniqueWords.isEmpty()) {
                    uniqueWords.add(words);
                } else {
                    uniqueWords.add(words);
                }
            }
            words = book.getWords().next();
        }
    }
    public static void main(String[] args) throws IOException {
        new UniqueWords();
    }

}
