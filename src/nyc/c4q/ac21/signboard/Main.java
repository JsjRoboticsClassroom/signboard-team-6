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

    public static void arrowScene(SignBoard board, int numCycles) {
        int width = board.getWidth();
        int height = board.getHeight();
        for (int i = 0; i < numCycles; ++i) {
            SignBoard.Frame frame = board.newFrame();

            for (int x = -2; x < width; ++x) {
                int y = (2 * height - 2 + x + i) % (2 * height - 2);
                if (y >= height)
                    y = 2 * height - y - 2;
                if (0 < x) {
                    frame.setYellow();
                    frame.write(x, y, "<");
                }
                if (0 < x + 1 && x + 1 < width) {
                    frame.setGreen();
                    frame.write(x + 1, y, "-");
                }
                if (x + 2 < width) {
                    frame.setRed();
                    frame.write(x + 2, y, ">");
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
    public static void scrollTextSceneMultiplier(SignBoard board, String text) {
        int width = board.getWidth();
        int y = board.getHeight() / 2;
        for (int x = -text.length(); x <= width; ++x) {
            SignBoard.Frame frame = board.newFrame();

            if (x >= width)
                break;

            if (x < 0) {
                // Scrolling on to the left side.
                frame.write(0, y - 2, text.substring(-x));
                frame.write(0, y - 1, text.substring(-x));
                frame.write(0, y, text.substring(-x));
                frame.write(0, y + 1, text.substring(-x));
                frame.write(0, y + 2, text.substring(-x));
            }
            else if (x + text.length() <= width) {
                // Fully on the board.
                frame.write(x, y - 2, text);
                frame.write(x, y - 1, text);
                frame.write(x, y, text);
                frame.write(x, y + 1, text);
                frame.write(x, y + 2, text);
            }
            else{
                // Scrolling off the board.
                frame.write(x, y - 2, text.substring(0, width - x));
                frame.write(x, y - 1, text.substring(0, width - x));
                frame.write(x, y, text.substring(0, width - x));
                frame.write(x, y + 1, text.substring(0, width - x));
                frame.write(x, y + 2, text.substring(0, width - x));
            }
            frame.finish(0.02);
        }
    }
    public static void scrollFishScene(SignBoard board) {
        Random random = new Random();
        String text1 =" _______  ___   _______  __   __   _______  _______  _______  _______  _______ ";
        String text2 ="|       ||   | |       ||  | |  | |       ||   _   ||       ||       ||       |";
        String text3 ="|    ___||   | |  _____||  |_|  | |_     _||  |_|  ||       ||   _   ||  _____|";
        String text4 ="|   |___ |   | | |_____ |       |   |   |  |       ||       ||  | |  || |_____ ";
        String text5 ="|    ___||   | |_____  ||       |   |   |  |       ||      _||  |_|  ||_____  |";
        String text6 ="|   |    |   |  _____| ||   _   |   |   |  |   _   ||     |_ |       | _____| |";
        String text7 ="|___|    |___| |_______||__| |__|   |___|  |__| |__||_______||_______||_______|";

        int width = board.getWidth();
        int y = board.getHeight() / 2;
        for (int x = -text1.length(); x <= width; ++x) {
            SignBoard.Frame frame = board.newFrame();
            int color = random.nextInt(4);
            if (color == 0)
                frame.setGreen();
            else if (color == 1)
                frame.setRed();
            else if (color == 2)
                frame.setWhite();
            else
                frame.setYellow();

            if (x >= width)
                break;

            if (x < 0) {
                // Scrolling on to the left side.
                frame.write(0, y - 4, text1.substring(-x));
                frame.write(0, y - 3, text2.substring(-x));
                frame.write(0, y - 2, text3.substring(-x));
                frame.write(0, y - 1, text4.substring(-x));
                frame.write(0, y, text5.substring(-x));
                frame.write(0, y + 1, text6.substring(-x));
                frame.write(0, y + 2, text7.substring(-x));
            }
            else if (x + text1.length() <= width) {
                // Fully on the board.
                frame.write(x, y - 4, text1);
                frame.write(x, y - 3, text2);
                frame.write(x, y - 2, text3);
                frame.write(x, y - 1, text4);
                frame.write(x, y, text5);
                frame.write(x, y + 1, text6);
                frame.write(x, y + 2, text7);
            }
            else{
                // Scrolling off the board.
                frame.write(x, y - 4, text1.substring(0, width - x));
                frame.write(x, y - 3, text2.substring(0, width - x));
                frame.write(x, y - 2, text3.substring(0, width - x));
                frame.write(x, y - 1, text4.substring(0, width - x));
                frame.write(x, y, text5.substring(0, width - x));
                frame.write(x, y + 1, text6.substring(0, width - x));
                frame.write(x, y + 2, text7.substring(0, width - x));
            }
            frame.finish(0.04);
        }
    }
    public static void scrollCarnitasScene(SignBoard board) {
        Random random = new Random();
        String text1 =" (\\____/)   _____ _____ _____ _____ _____ _____ _____ _____ ";
        String text2 =" / @__@ \\  |     |  _  | __  |   | |     |_   _|  _  |   __|";
        String text3 ="(  (oo)  ) |   --|     |    -| | | |-   -| | | |     |__   |";
        String text4 =" `-.~~.-'  |_____|__|__|__|__|_|___|_____| |_| |__|__|_____|";

        int width = board.getWidth();
        int y = board.getHeight() / 2;
        for (int x = -text1.length(); x <= width; ++x) {
            SignBoard.Frame frame = board.newFrame();
            int color = random.nextInt(4);
            if (color == 0)
                frame.setGreen();
            else if (color == 1)
                frame.setRed();
            else if (color == 2)
                frame.setWhite();
            else
                frame.setYellow();

            if (x >= width)
                break;

            if (x < 0) {
                // Scrolling on to the left side.
                frame.write(0, y - 2, text1.substring(-x));
                frame.write(0, y - 1, text2.substring(-x));
                frame.write(0, y, text3.substring(-x));
                frame.write(0, y + 1, text4.substring(-x));
            }
            else if (x + text1.length() <= width) {
                // Fully on the board.
                frame.write(x, y - 2, text1);
                frame.write(x, y - 1, text2);
                frame.write(x, y, text3);
                frame.write(x, y + 1, text4);
            }
            else{
                // Scrolling off the board.
                frame.write(x, y - 2, text1.substring(0, width - x));
                frame.write(x, y - 1, text2.substring(0, width - x));
                frame.write(x, y, text3.substring(0, width - x));
                frame.write(x, y + 1, text4.substring(0, width - x));
            }
            frame.finish(0.04);
        }
    }
    public static void scrollFajitasScene(SignBoard board) {
        Random random = new Random();
        String text1 =",---.,---.    ||--.--,---.,---.  (___)";
        String text2 ="|__. |---|    ||  |  |---|`---.  (o o)";
        String text3 ="|    |   |    ||  |  |   |    |   @@ `";
        String text4 ="`    `   '`---'`  `  `   '`---'       ";

        int width = board.getWidth();
        int y = board.getHeight() / 2;
        for (int x = text1.length(); x <= width; --x) {
            SignBoard.Frame frame = board.newFrame();
            int color = random.nextInt(4);
            if (color == 0)
                frame.setGreen();
            else if (color == 1)
                frame.setRed();
            else if (color == 2)
                frame.setWhite();
            else
                frame.setYellow();

            if (x < 0 - text1.length())
                break;

            if (x < 0) {
                // Scrolling on to the left side.
                frame.write(0, y - 2, text1.substring(-x));
                frame.write(0, y - 1, text2.substring(-x));
                frame.write(0, y, text3.substring(-x));
                frame.write(0, y + 1, text4.substring(-x));
            }
            else if (x + text1.length() <= width) {
                // Fully on the board.
                frame.write(x, y - 2, text1);
                frame.write(x, y - 1, text2);
                frame.write(x, y, text3);
                frame.write(x, y + 1, text4);
            }
            else{
                // Scrolling off the board.
                frame.write(x, y - 2, text1.substring(0, width - x));
                frame.write(x, y - 1, text2.substring(0, width - x));
                frame.write(x, y, text3.substring(0, width - x));
                frame.write(x, y + 1, text4.substring(0, width - x));
            }
            frame.finish(0.04);
        }
    }



    public static void scrollTextSceneReverse(SignBoard board, String text) {
        int width = board.getWidth();
        int y = board.getHeight() / 2;
        for (int x = width + text.length(); x == 0; x--) {
            SignBoard.Frame frame = board.newFrame();

            if (x < 0)
                break;

            if (x > width)
                // Scrolling on to the right side.
                frame.write(x - text.length(), y, text.substring (-(x - width - text.length())));
            else if (x + text.length() <= width)
                // Fully on the board.
                frame.write(x, y, text);
            else
                // Scrolling off the board.
                frame.write(x, y, text.substring(0, (text.length() - x)));

            frame.finish(0.05);
        }
    }

    /**
     * Draws a scene which flashes the words "FRESH" and "HOT".
     * @param board
     *   The board on which to draw.
     * @param cycles
     *   The number of cycles to draw for.
     */

    public static void flashTacosScene(SignBoard board, int cycles) {
        Random random = new Random();
        int width = board.getWidth();
        int leftPosition = width / 6 - 12;
        int rightPosition = 2 * width / 4 - 12;
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
                frame.write(leftPosition, y - 4, " _______  _______  _______  _______  _______  ");
                frame.write(leftPosition, y - 3, "|       ||   _   ||       ||       ||       | ");
                frame.write(leftPosition, y - 2, "|_     _||  |_|  ||       ||   _   ||  _____| ");
                frame.write(leftPosition, y - 1, "  |   |  |       ||       ||  | |  || |_____  ");
                frame.write(leftPosition, y    , "  |   |  |       ||      _||  |_|  ||_____  | ");
                frame.write(leftPosition, y + 1, "  |   |  |   _   ||     |_ |       | _____| | ");
                frame.write(leftPosition, y + 2, "  |___|  |__| |__||_______||_______||_______| ");
            }
            else {
                frame.write(rightPosition, y - 4, " _______  _______  _______  _______  _______  ");
                frame.write(rightPosition, y - 3, "|       ||   _   ||       ||       ||       | ");
                frame.write(rightPosition, y - 2, "|_     _||  |_|  ||       ||   _   ||  _____| ");
                frame.write(rightPosition, y - 1, "  |   |  |       ||       ||  | |  || |_____  ");
                frame.write(rightPosition, y    , "  |   |  |       ||      _||  |_|  ||_____  | ");
                frame.write(rightPosition, y + 1, "  |   |  |   _   ||     |_ |       | _____| | ");
                frame.write(rightPosition, y + 2, "  |___|  |__| |__||_______||_______||_______| ");
            }

            frame.finish(0.03);
        }
    }
    public static void flashFishTacosScene(SignBoard board, int cycles) {
        Random random = new Random();
        int width = board.getWidth();
        int leftPosition = width / 6 - 12;
        int rightPosition = 2 * width / 4 - 12;
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
                frame.write(leftPosition, y - 4, " _______  ___   _______  __   __ ");
                frame.write(leftPosition, y - 3, "|       ||   | |       ||  | |  |");
                frame.write(leftPosition, y - 2, "|    ___||   | |  _____||  |_|  |");
                frame.write(leftPosition, y - 1, "|   |___ |   | | |_____ |       |");
                frame.write(leftPosition, y    , "|    ___||   | |_____  ||       |");
                frame.write(leftPosition, y + 1, "|   |    |   |  _____| ||   _   |");
                frame.write(leftPosition, y + 2, "|___|    |___| |_______||__| |__|");
            }
            else {
                frame.write(rightPosition, y - 4, " _______  _______  _______  _______  _______  ");
                frame.write(rightPosition, y - 3, "|       ||   _   ||       ||       ||       | ");
                frame.write(rightPosition, y - 2, "|_     _||  |_|  ||       ||   _   ||  _____| ");
                frame.write(rightPosition, y - 1, "  |   |  |       ||       ||  | |  || |_____  ");
                frame.write(rightPosition, y    , "  |   |  |       ||      _||  |_|  ||_____  | ");
                frame.write(rightPosition, y + 1, "  |   |  |   _   ||     |_ |       | _____| | ");
                frame.write(rightPosition, y + 2, "  |___|  |__| |__||_______||_______||_______| ");
            }

            frame.finish(0.04);
        }
    }

    public static void flashTequilaScene(SignBoard board, int cycles) {
        Random random = new Random();
        int width = board.getWidth();
        int leftPosition = width / 6 - 6;
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
                frame.write(leftPosition, y - 4, " _______  _______  _______  __   __  ___   ___      _______");
                frame.write(leftPosition, y - 3, "|       ||       ||       ||  | |  ||   | |   |    |   _   |");
                frame.write(leftPosition, y - 2, "|_     _||    ___||   _   ||  | |  ||   | |   |    |  |_|  |");
                frame.write(leftPosition, y - 1, "  |   |  |   |___ |  | |  ||  |_|  ||   | |   |    |       |");
                frame.write(leftPosition, y    , "  |   |  |    ___||  |_|  ||       ||   | |   |___ |       |");
                frame.write(leftPosition, y + 1, "  |   |  |   |___ |      | |       ||   | |       ||   _   |");
                frame.write(leftPosition, y + 2, "  |___|  |_______||____||_||_______||___| |_______||__| |__|");
            }
            else {
                continue;
            }

            frame.finish(0.20);
        }
    }
    public static void main(String[] args) {
        SignBoard signBoard = new SignBoard(8);

        // Run the sign board forever.
        while (true) {
           arrowScene(signBoard, 48);
           scrollTextSceneMultiplier(signBoard, "###  T A C O S  Y  T E Q U I L L A ###");
           arrowScene(signBoard, 48);
           flashTacosScene(signBoard, 10);
           flashTequilaScene(signBoard, 10);
            arrowScene(signBoard, 48);
            scrollTextSceneMultiplier(signBoard,  "><)))'>  ><)))'>  ><)))'>");
            scrollFishScene(signBoard);
            scrollCarnitasScene(signBoard);
            scrollFajitasScene(signBoard);

        }
    }
}
