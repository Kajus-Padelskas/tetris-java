package vgtu.game;

class TetrominosIndustry {

    private static final int[][][] TETROMINOS = new int[][][]
            {
                    {
                            {1, 0, 0},
                            {1, 0, 0},
                            {1, 1, 0}
                    },
                    {
                            {1, 0, 0},
                            {1, 1, 0},
                            {0, 1, 0}
                    },
                    {
                            {1, 1, 1},
                            {0, 0, 0},
                            {0, 0, 0}
                    },
                    {
                            {1, 1, 0},
                            {1, 1, 0},
                            {0, 0, 0}
                    },
                    {
                            {1, 1, 1},
                            {0, 1, 0},
                            {0, 0, 0}
                    } ,                          
                            {0, 0, 1},
                            {0, 1, 1},
                            {0, 1, 0}
                    }
            };

    public static Tetromino generateTetromino(int x, int y) {
        return new Tetromino(x, y, TETROMINOS[(int) (Math.random() * TETROMINOS.length)]);
    }
}
