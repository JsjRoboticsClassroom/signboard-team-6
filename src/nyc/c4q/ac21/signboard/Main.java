package nyc.c4q.ac21.signboard;

import java.util.Random;

public class Main {
    /**
     * Draws a scene with a scrolling multicolor zig-zag ribbon.
     * @param board
     *   The board on which to draw.
     * @param numCycles
     *   The number of cycles to draw for.
     */
    public static void ribbonScene(SignBoard board, int numCycles) {
        int width = board.getWidth();
        int height = board.getHeight();
        for (int i = 0; i < numCycles; ++i) {
            SignBoard.Frame frame = board.newFrame();

            for (int x = 2; x < width; ++x) {
                int y = (2 * height - 2 + x + i) % (2 * height - 2);
                if (y >= height)
                    y = 2 * height - y - 2;
                if (0 < x) {
                    frame.setYellow();
                    frame.write(x, y, "*");
                }
                if (0 < x + 1 && x + 1 < width) {
                    frame.setGreen();
                    frame.write(x + 1, y, "*");
                }
                if (x + 2 < width) {
                    frame.setRed();
                    frame.write(x + 2, y, "*");
                }
            }

            frame.finish(0.02);
        }
    }

    /**
     * Draws a scene with text scrolling across the screen..
     * @param board
     *   The board on which to draw.
     * @param text
     *   The text to scroll.
     */
    public static void scrollBeerTextScene(SignBoard board, String text) {
        int width = board.getWidth();
        int y = board.getHeight() / 2;
        for (int x = -text.length(); x <= width; ++x) {
            SignBoard.Frame frame = board.newFrame();

            if (x >= width)
                break;

            if (x < 0)
                // Scrolling on to the left side.
                frame.write(0, y, text.substring(-x));
            else if (x + text.length() <= width)
                // Fully on the board.
                frame.write(x, y, text);
            else
                // Scrolling off the board.
                frame.write(x, y, text.substring(0, width - x));

            frame.finish(0.02);
        }
    }

    /**
     * Draws a scene which flashes the words "FRESH" and "HOT".
     * @param board
     *   The board on which to draw.
     * @param cycles
     *   The number of cycles to draw for.
     */
    public static void flashColdBeerScene(SignBoard board, int cycles) {
        Random random = new Random();
        int width = board.getWidth();
        int leftPosition = width / 4 - 12;
        int rightPosition = 3 * width / 4 - 7;
        int y = board.getHeight() / 2;

        for (int i = 0; i < cycles * 2; ++i) {
            SignBoard.Frame frame = board.newFrame();

            // Choose a color at random.
            int color = random.nextInt(4);
            if (color == 0)
                frame.setGreen();
            else if (color == 1)
                frame.setRed();
            else if (color == 2)
                frame.setWhite();
            else
                frame.setYellow();
            // Write a word.
            if (i % 2 == 0) {
                frame.write(leftPosition, y - 3, "                                      OoOoOOoOooO   ");
                frame.write(leftPosition, y - 2, "               CCCC OOOO L    DDD    (_o__o____o_)  ");
                frame.write(leftPosition, y - 1, "               C    O  O L    D  D   o| |_| |_| |DD ");
                frame.write(leftPosition, y    , "               C    O  O L    D  D  oo| |_| |_| | DD");
                frame.write(leftPosition, y + 1, "               C    O  O L    D  D  oo| |_| |_| | DD");
                frame.write(leftPosition, y + 2, "               CCCC OOOO LLLL DDD   oo|_|_|_|_|_|DD ");
                frame.write(leftPosition, y + 3, "                                   ooo|_|_|_|_|_|   ");

            } else {
                frame.write(leftPosition, y - 3, "                                      ooooooooooo   ");
                frame.write(leftPosition, y - 2, "               BBBB EEEE EEEE RRR    (_o__o____o_)  ");
                frame.write(leftPosition, y - 1, "               B  B E    E    R  R    | |_| |_| |DD ");
                frame.write(leftPosition, y    , "               BBB  EEE  EEE  RRR     | |_| |_| | DD");
                frame.write(leftPosition, y + 1, "               B  B E    E    R  R    | |_| |_| | DD");
                frame.write(leftPosition, y + 2, "               BBBB EEEE EEEE R  R    |_|_|_|_|_|DD ");
                frame.write(leftPosition, y + 3, "                                      |_|_|_|_|_|   ");
            }




            frame.finish(0.25);
        }
    }



    public static void main(String[] args) {
        SignBoard signBoard = new SignBoard(8);

        // Run the sign board forever.
        while (true) {
            //ribbonScene(signBoard, 48);
            scrollBeerTextScene(signBoard, "!!!  W E  H A V E  B E E R  !!!");
            //ribbonScene(signBoard, 48);
            flashColdBeerScene(signBoard, 10);
        }
    }
}
