import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) {		

        File file = new File("stderr.txt");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            PrintStream ps = new PrintStream(fos);
            System.setErr(ps);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("STDERR could not be sent to stderr.txt so it will appear on console.");
        }

        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();
        Handler handler = new Handler();
        Grid grid = new Grid();

        System.out.println("2048> Hi, I am the 2048-game Engine.");
        System.out.println("2048> The start state is:");
        grid.print();

        while (true) {
            System.out.print("----> ");
            int code = parser.parse(sc.nextLine(), grid);
            handler.handle(code, grid);
        }
    }
}
