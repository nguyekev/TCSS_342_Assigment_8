
import java.io.IOException;
public class UniqueWords {
    private BookReader book = new BookReader("WarAndPeace.txt");

    public UniqueWords() throws IOException {
        addUniqueWordsToLinkedList();
        addUniqueWordsToHashTable();
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

    public void addUniqueWordsToHashTable() {
        long start, finish, difference;
        start = System.currentTimeMillis();
        MyHashTable<String, String> uniqueWords = new MyHashTable<>();
        for (book.words.first(); book.words.current() != null; book.words.next()) {
            if (uniqueWords.get(book.words.current()) == null) {
                uniqueWords.put(book.words.current(), book.words.current());
            }
        }
        finish = System.currentTimeMillis();
        difference = finish - start;
        System.out.println("Time taken to add unique words to hash table: " + difference + " milliseconds");
        System.out.println("Number of unique words in hash table: " + uniqueWords.size());
        System.out.println("Number of comparisons in hash table: " + uniqueWords.comparisons);
        System.out.println("Max probe of hash table: " + uniqueWords.maxProbe);
        System.out.println("Extracting the key-value pairs from the hash table:" + (difference/10) + " milliseconds");
    }
}
