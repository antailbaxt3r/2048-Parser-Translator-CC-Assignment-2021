import java.util.*;

public class Grid {
    
    private Tile[][] m;

    public Grid () {
        m = new Tile[4][4];
        for(int i = 0; i < 4; i++) 
            for(int j = 0; j < 4; j++) m[i][j] = new Tile(0);

        Random random = new Random();
        m[random.nextInt(4)][random.nextInt(4)].setValue((random.nextFloat() > 0.5) ? 4 : 2);
    }

    public Tile[][] getGrid () {
        return m;
    }

    public void print () {
        String line_hz = "_____________________";
        for (Tile[] a : m) {
            System.out.println(line_hz);
            for (Tile num : a) {
                System.out.print("|");
                if (num.getValue() != 0) {
                    int i = num.getValue();
                    int length = 0;
                    for (; i != 0; i /= 10, ++length) ;
                    int spaces = 4 - length;
                    String s = " ".repeat(spaces) + num.getValue();
                    System.out.print(s);
                } else {
                    System.out.print("    ");
                }
            }
            System.out.println("|");
        }
        System.out.println(line_hz);
        System.out.println("\n\n");
    }

    public Tile[][] rotate () {
        final int M = 4;
        final int N = 4;
        Tile[][] ret = new Tile[4][4];
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                ret[c][M-1-r] = m[r][c];
            }
        }
        return ret;
    }

    public void move (char operation, int direction) {
        for (int i = 0; i < direction; i++) m = rotate();
        for (int i = 0; i < 4; i++) {
            ArrayList<Tile> temp1 = new ArrayList<>();
            Tile[] temp = new Tile[4];

            for (Tile j : m[i]) if (j.getValue() != 0) temp1.add(j);
            for (Tile j : m[i]) if (j.getValue() == 0) temp1.add(j);
            for (int j = 0; j < 4; j++) temp[j] = temp1.get(j);
            
            for (int j = 0; j < 3; j++) {
                if (temp[j].getValue() != 0 && temp[j+1].getValue() != 0) {
                    if (operation == '+') {
                        temp[j].setValue(temp[j].getValue() + temp[j+1].getValue());
                        temp[j].addName(temp[j+1].getNames());
                        temp[j+1].setValue(0);
                        temp[j+1].clearNames();
                    }
                    else if (temp[j].getValue() == temp[j+1].getValue()) {
                        switch (operation) {
                            case '-' : {
                                temp[j].setValue(temp[j].getValue() - temp[j+1].getValue());
                                temp[j].addName(temp[j+1].getNames());
                                break;
                            }
                            case '*' : {
                                temp[j].setValue(temp[j].getValue() * temp[j+1].getValue());
                                temp[j].addName(temp[j+1].getNames());
                                break;
                            }
                            case '/' : {
                                temp[j].setValue(temp[j].getValue() / temp[j+1].getValue());
                                temp[j].addName(temp[j+1].getNames());
                                break;
                            }
                        }
                        temp[j+1].setValue(0);
                        temp[j+1].clearNames();
                    }
                }
            }

            temp1.clear();
            for (Tile j : temp) if (j.getValue() != 0) temp1.add(j);
            for (Tile j : temp) if (j.getValue() == 0) temp1.add(j);
            for (int j = 0; j < 4; j++) m[i][j] = temp1.get(j);
        }
        for (int i = 0; i < 4-direction; i++) m = rotate();
    }

    public int[] findEmpty () {
        int[] result = new int[]{-1, -1, 1};
        for (int i = 0; i < 4; i++) 
            for (int j = 0; j < 4; j++) {
                if (m[i][j].getValue() == 0) {
                    result[0] = i;
                    result[1] = j;
                    result[2] = 0;
                    return result;
                }
            }
        return result;
    }

    public int addTile () {
        Random random = new Random();
        int num = (random.nextFloat() > 0.5) ? 4 : 2;
        int lost = 0;
        int x = random.nextInt(4);
        int y = random.nextInt(4);
        if (m[x][y].getValue() != 0) {
            int[] res = findEmpty();
            x = res[0];
            y = res[1];
            lost = res[2];
        }
        if (lost == 0) m[x][y].setValue(num);
        return lost;
    }

    public void assign (int x, int y, int value) {
        m[x][y].setValue(value);
    }

    public void nameTile (int x, int y, String s) {
        m[x][y].addName(s);
    }

    public int[] findName (String name) {
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                if(m[i][j].names.contains(name)) return new int[]{i, j};
        return new int[]{-1, -1};
    }

    public void printAllNames () {
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                for (String name : m[i][j].getNames())  
                    System.out.println(i + ", " + j + " : " + name);
    }
}
