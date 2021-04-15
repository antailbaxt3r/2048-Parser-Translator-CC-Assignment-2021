public class Handler {
    
    int lose;
    public Handler () {
        lose = 0;
    }

    public void handle (int code, Grid grid) {
        if (code == 0) System.exit(code);

        //handle debug codes
        switch (code / 100) {
            //success codes start with [2-9]
            case 2: {
                //add
                grid.move('+', code % 10); 
                lose = grid.addTile(); 
                grid.print();
                break;
            }
            case 3: {
                //subtract
                grid.move('-', code % 10); 
                lose = grid.addTile(); 
                grid.print();
                break;
            }
            case 4: {
                //multiply
                grid.move('*', code % 10); 
                lose = grid.addTile(); 
                grid.print();
                break;
            }
            case 5: {
                //divide
                grid.move('/', code % 10); 
                lose = grid.addTile(); 
                grid.print();
                break;
            }
            case 7: {
                //value in
                break;
            }
            case 8: {
                // var is
                break;
            }
            case 9: {
                //assign value to 
                System.out.println("2048> Current State: ");
                grid.print();
                break;
            }
        }

        handleSystemError(code, grid);
    }

    public void handleSystemError(int code, Grid grid) {
        if (code / 100 == 1) {
            //handle error 
            //all error codes start with 1
            System.err.println(-1);
            return;
        }

        Tile[][] m = grid.getGrid();

        String values = "";
        String names = "";
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                values += m[i][j].getValue() + " ";
                if (!m[i][j].getNames().isEmpty()) {
                    names += (i+1) + "," + (j+1);
                    for (String n : m[i][j].getNames()) {
                        names += n + ',';
                    }
                    names = names.substring(0, names.length()-1);
                    names += " ";
                }
            }
        }
        System.err.println(values + names);
        
    }
}
