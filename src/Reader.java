import java.io.*;
import java.util.Queue;
import java.util.regex.Pattern;

class Reader implements Runnable {
        private static int threadNum = 0;
        private final String threadName;
        private final String fileName;
        private final Queue<String> wordStore;

        public Reader(String fileName, Queue wordStore) {
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
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                while ((line = br.readLine()) != null) {
                           wordStore.add(line);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
