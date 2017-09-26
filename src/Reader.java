import java.io.*;
import java.util.concurrent.ConcurrentLinkedQueue;


class Reader implements Runnable {
        private static int threadNum = 0;
        private static volatile boolean finish = false;
        private static volatile boolean start = false;
        private final String threadName;
        private final String fileName;
        private final ConcurrentLinkedQueue<String> wordStore;

        public Reader(String fileName, ConcurrentLinkedQueue<String> wordStore) {
            threadName = "Thread" + (++threadNum);
            this.fileName = fileName;
            this.wordStore = wordStore;
        }

        @Override
        public void run() {
            System.out.println(threadName + " запущен.");
            File file = new File(fileName);
            processingFile(file);
            System.out.println(threadName + " остановлен.");
        }

        private void processingFile(File file) {
            String line;
            start = true;
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                int countLine = 0;
                while ((line = br.readLine()) != null) {
                    wordStore.add(line);
                    countLine++;
                }
                System.out.println("Всего записано строк: " + countLine);
                finish = true;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static boolean isFinish(){
            return finish;
        }

        public static boolean isStart() {
            return start;
        }
}
