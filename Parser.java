public class Parser {
    
    String[] validCommands = new String[]{"ADD", "SUBTRACT", "MULTIPLY", "DIVIDE", "LEFT", "RIGHT", "UP", "DOWN", "ASSIGN", "TO", "VAR", "IS", "VALUE", "IN", "PRINT."};

    public Parser () {
    }

    public int parse (String s, Grid grid) {
        String[] tokens1 = s.split(" ");
        boolean flag = true;

        for (String x : validCommands) {
            if (tokens1[0].equals(x)) {
                flag = false;
                break;
            }
        } 
        if (flag) {
            System.out.println("2048> Sorry, I don't understand that.");
            return DebugCodes.UNKNOWN_TOKEN;
        }

        if (!s.equals(s.toUpperCase())) {
            System.out.println("2048> Syntax error.");
            return DebugCodes.LOWER_CASE;
        } 

        if (s.charAt(s.length() - 1) != '.') {
            System.out.println("2048> Command must end with full stop.");
            return DebugCodes.NO_FULL_STOP;
        }

        s = s.substring(0, s.length() - 1);
        String[] tokens = s.split(" ");

        switch (tokens[0]) {

            case "ADD": {
                switch (tokens[1]) {
                    case "LEFT": return DebugCodes.ADD_LEFT;
                    case "RIGHT": return DebugCodes.ADD_RIGHT;
                    case "UP": return DebugCodes.ADD_UP;
                    case "DOWN": return DebugCodes.ADD_DOWN;
                    default : {
                        System.out.println("2048> Invalid direction for command.\nExpected:\n<COMMAND> <LEFT/RIGHT/UP/DOWN>\n GOT " + tokens[1]);
                        return DebugCodes.WRONG_DIRECTION;
                    }
                }
            }

            case "SUBTRACT": {
                switch (tokens[1]) {
                    case "LEFT": return DebugCodes.SUB_LEFT;
                    case "RIGHT": return DebugCodes.SUB_RIGHT;
                    case "UP": return DebugCodes.SUB_UP;
                    case "DOWN": return DebugCodes.SUB_DOWN;
                    default : {
                        System.out.println("2048> Invalid direction for command.\nExpected:\n<COMMAND> <LEFT/RIGHT/UP/DOWN>");
                        return DebugCodes.WRONG_DIRECTION;
                    }
                }
            }

            case "MULTIPLY": {
                switch (tokens[1]) {
                    case "LEFT": return DebugCodes.MUL_LEFT;
                    case "RIGHT": return DebugCodes.MUL_RIGHT;
                    case "UP": return DebugCodes.MUL_UP;
                    case "DOWN": return DebugCodes.MUL_DOWN;
                    default : {
                        System.out.println("2048> Invalid direction for command.\nExpected:\n<COMMAND> <LEFT/RIGHT/UP/DOWN>");
                        return DebugCodes.WRONG_DIRECTION;
                    }
                }
            }

            case "DIVIDE": {
                switch (tokens[1]) {
                    case "LEFT": return DebugCodes.DIV_LEFT;
                    case "RIGHT": return DebugCodes.DIV_RIGHT;
                    case "UP": return DebugCodes.DIV_UP;
                    case "DOWN": return DebugCodes.DIV_DOWN;
                    default : {
                        System.out.println("2048> Invalid direction for command.\nExpected:\n<COMMAND> <LEFT/RIGHT/UP/DOWN>");
                        return DebugCodes.WRONG_DIRECTION;
                    }
                }
            }

            case "PRINT" : {
                grid.printAllNames();
                return 800;
            }

            case "ASSIGN" : {
                try {
                    int value = Integer.parseInt(tokens[1]);
                    if (!tokens[2].equals("TO")) throw new Exception("Invalid Syntax");
                    try {
                        String[] split = tokens[3].split(",");
                        int x = Integer.parseInt(split[0]);
                        int y;
                        if(split.length >= 2 && split[1] != null && !split[1].equals("")) {
                            y = Integer.parseInt(split[1]);
                        } else {
                            y = Integer.parseInt(tokens[4]);
                        }

                        if(x > 0 && x < 5 && y > 0 && y < 5){
                            grid.assign(x-1, y-1, value);
                            System.out.println("2048> Thanks, assignment done.");
                            return DebugCodes.ASSIGN_CODE;
                        } else {
                            System.out.println("2048> There is no tile like that. The tile co-ordinates must be in the range 1,2,3,4.");
                            return DebugCodes.INVALID_COORDINATES;
                        }
                        
                    } catch (Exception e) {
                        String name = tokens[3];
                        int[] res = grid.findName(name);
                        if (res[0] != -1 && res[1] != -1) {
                            grid.assign(res[0], res[1], value);
                            System.out.println("2048> Thanks, assignment done.");
                            return DebugCodes.ASSIGN_CODE;
                        } else {
                            System.out.println("2048> There is no tile like that.");
                            return DebugCodes.UNKNOWN_TILE_NAME;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("2048> Syntax error.\nExpected:\nASSIGN <VALUE> TO <X>,<Y>");
                    return DebugCodes.ASSIGN_SYNTAX_ERROR;
                }
            }

            case "VALUE": {
                if (!tokens[1].equals("IN")) {
                    System.out.println("2048> Syntax error.\nExpected:\nVALUE IN <X>,<Y>");
                    return DebugCodes.VALUE_SYNTAX_ERROR;
                }

                try {
                    String[] split = tokens[2].split(",");
                    int x = Integer.parseInt(split[0]);
                    int y;

                    if (split.length >= 2 && split[1] != null && !split[1].equals("")) {
                        y = Integer.parseInt(split[1]);
                    } else {
                        y = Integer.parseInt(tokens[3]);
                    }
                    
                    if(x > 0 && x < 5 && y > 0 && y < 5){
                        int val = grid.getGrid()[x-1][y-1].getValue();
                        System.out.println("2048> Value is : " + val);
                        return DebugCodes.VALUE_CODE;
                    } else {
                        System.out.println("2048> There is no tile like that. The tile co-ordinates must be in the range 1,2,3,4.");
                        return DebugCodes.INVALID_COORDINATES;
                    }
                    
                } catch (Exception e) {
                    String name = tokens[3];
                    int[] res = grid.findName(name);
                    if (res[0] != -1 && res[1] != -1) {
                        int val = grid.getGrid()[res[0]][res[1]].getValue();
                        System.out.println("2048> Value is : " + val);
                        return DebugCodes.VALUE_CODE;
                    } else {
                        System.out.println("2048> There is no tile like that.");
                        return DebugCodes.UNKNOWN_TILE_NAME;
                    }
                    
                }
                
            }
        }

        return 0;
    }

}
