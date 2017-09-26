import java.util.concurrent.ConcurrentLinkedQueue;

public class Counter implements Runnable {
    private ConcurrentLinkedQueue<String> queue;
    private int counter = 0;

    public Counter(ConcurrentLinkedQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("Коунтер запущен");
        count();
        System.out.println("Найдено слов: " + counter);
        System.out.println("Коунтер завершен.");
    }

    private void count() {
        int countLine = 0;
        while (queue.size() > 0 | !Reader.isFinish()) {
            if (queue.size() > 0 ) {
                String lineString = queue.poll();
                countLine++;
                if (lineString == null) System.out.println("Строка равна null");
                else if (lineString.contains("страдание")) {
                    counter++;
                }
            }

        }
        System.out.println("Прочитано строк: " + countLine);

    }
}
