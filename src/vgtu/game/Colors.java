package vgtu.game;

public class Colors {
    private static final String ANSI_RESET;
    private static final String ANSI_RED;
    private static final String ANSI_GREEN;
    private static final String ANSI_YELLOW;
    private static final String ANSI_PURPLE;
    private static final String ANSI_CYAN;

    static {
        ANSI_RESET = "\u001B[0m";
        ANSI_RED = "\u001B[31m";
        ANSI_GREEN = "\u001B[32m";
        ANSI_YELLOW = "\u001B[33m";
        ANSI_PURPLE = "\u001B[35m";
        ANSI_CYAN = "\u001B[36m";
    }

    public static String getAnsiReset() {
        return ANSI_RESET;
    }

    public static String getAnsiRed() {
        return ANSI_RED;
    }

    public static String getAnsiGreen() {
        return ANSI_GREEN;
    }

    public static String getAnsiYellow() {
        return ANSI_YELLOW;
    }

    public static String getAnsiPurple() {
        return ANSI_PURPLE;
    }

    public static String getAnsiCyan() {
        return ANSI_CYAN;
    }

}
