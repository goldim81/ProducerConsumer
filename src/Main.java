import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String fileName = "E:\\Downloads\\Books\\book1.txt";
        Queue<String> queue = new LinkedList<>();
        Counter counter = new Counter(queue);
        Thread trReader = new Thread(new Reader(fileName, queue));
        Thread trCounter = new Thread(counter);
        trReader.start();
        Thread.sleep(10);
        trCounter.start();
        try {
            trReader.join();
            trCounter.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Найдено слов: "+ counter.getCounter());


    }
}
