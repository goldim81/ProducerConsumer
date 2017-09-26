import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String fileName = "E:\\Downloads\\Books\\book1.txt";
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        Counter counter = new Counter(queue);
        Thread trReader = new Thread(new Reader(fileName, queue));
        Thread trCounter = new Thread(counter);
        trReader.start();
        trCounter.start();
    }
}
