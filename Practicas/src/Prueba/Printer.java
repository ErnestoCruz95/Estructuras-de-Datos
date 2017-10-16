package Prueba;
import Queue.Queue;

/**
 * Created by AntonioRang on 10/12/17.
 */
public class Printer {
    private Queue<String> printerSpool;

    public Printer() {
        printerSpool = new Queue<String>();
    }

    public void printDocument(String name) {
        printerSpool.offer(name);

    }

    public void runPrinter() throws InterruptedException {
        int sizePrin = printerSpool.size();
        for (int i = 0; i <= sizePrin ; i++) {
            System.out.println(printerSpool.remove());
            Thread.sleep(5000);
            if(printerSpool.isEmpty()){
                System.out.println("Finished printing documents");
                break;
            }
        }
    }
}
