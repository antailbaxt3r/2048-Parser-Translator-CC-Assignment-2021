import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) {		

        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();
        Handler handler = new Handler();
        Grid grid = new Grid();

        System.out.println("2048> Hi, I am the 2048-game Engine.");
        System.out.println("2048> The start state is:");
        grid.print();

        while (true) {
            System.out.print("----> ");
            int code = parser.parse(sc.nextLine(), grid, 0);
            handler.handle(code, grid);
        }
    }
}
