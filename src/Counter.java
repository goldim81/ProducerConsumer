import java.util.Queue;

public class Counter implements Runnable{
    private Queue<String> queue;
    private int counter = 0;

    public Counter(Queue<String> queue) {
        this.queue = queue;
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public void run() {
        System.out.println("Коунтер запущен");
        while (queue.size()>0) {
            String lineString = queue.poll();
            if (lineString.contains("страдание")) counter++;
        }
    }
}
