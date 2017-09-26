import java.util.concurrent.ConcurrentLinkedQueue;

public class Counter implements Runnable{
    private ConcurrentLinkedQueue<String> queue;
    private int counter = 0;

    public Counter(ConcurrentLinkedQueue<String> queue) {
        this.queue = queue;
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public void run() {
        System.out.println("Коунтер запущен");
        count();
        System.out.println("Коунтер завершен.");
    }

    private void count() {
        while (!Reader.isFinish()) {
            if (queue.size()>0) {
                String lineString = queue.poll();
                if (lineString == null) System.out.println("Строка равна null");
//                System.out.println("Прочли строку.");
                else if (lineString.contains("страдание")) counter++;
            }

        }

    }
}
