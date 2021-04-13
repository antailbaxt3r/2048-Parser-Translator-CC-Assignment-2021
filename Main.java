import java.util.*;

public class Main {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();
        Grid grid = new Grid();
        int lose = 0;

        System.out.println("2048> Hi, I am the 2048-game Engine.");
        System.out.println("2048> The start state is:");
        grid.print();

        while (true) {
            System.out.print("----> ");
            int code = parser.parse(sc.nextLine(), grid);

            //handle movement
            switch (code / 100) {
                case 2: {
                    grid.move('+', code % 10); 
                    lose = grid.addTile(); 
                    grid.print();
                    break;
                }
                case 3: {
                    grid.move('-', code % 10); 
                    lose = grid.addTile(); 
                    grid.print();
                    break;
                }
                case 4: {
                    grid.move('*', code % 10); 
                    lose = grid.addTile(); 
                    grid.print();
                    break;
                }
                case 5: {
                    grid.move('/', code % 10); 
                    lose = grid.addTile(); 
                    grid.print();
                    break;
                }
                case 7: {
                    break;
                }
                case 9: {
                    System.out.println("2048> Current State: ");
                    grid.print();
                    break;
                }
            }
        }
    }
}
