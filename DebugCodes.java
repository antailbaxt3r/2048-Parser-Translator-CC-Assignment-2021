public final class DebugCodes {

    private DebugCodes() {
    }

    //EXIT CODE
    public static final int EXIT_CODE = 0;

    //ERRORS
    public static final int NO_FULL_STOP = 100;
    public static final int LOWER_CASE = 101;
    public static final int UNKNOWN_TOKEN = 102;
    public static final int WRONG_DIRECTION = 103;
    public static final int INVALID_COORDINATES = 104;
    public static final int ASSIGN_SYNTAX_ERROR = 105;
    public static final int VALUE_SYNTAX_ERROR = 106;
    public static final int UNKNOWN_TILE_NAME = 107;

    //SUCCESSFUL PARSES
    public static final int ADD_LEFT = 200;
    public static final int ADD_RIGHT = 202;
    public static final int ADD_UP = 203;
    public static final int ADD_DOWN = 201;

    public static final int SUB_LEFT = 300;
    public static final int SUB_RIGHT = 302;
    public static final int SUB_UP = 303;
    public static final int SUB_DOWN = 301;

    public static final int MUL_LEFT = 400;
    public static final int MUL_RIGHT = 402;
    public static final int MUL_UP = 403;
    public static final int MUL_DOWN = 401;

    public static final int DIV_LEFT = 500;
    public static final int DIV_RIGHT = 502;
    public static final int DIV_UP = 503;
    public static final int DIV_DOWN = 501;

    public static final int VALUE_CODE = 700;

    public static final int ASSIGN_CODE = 900;
}
