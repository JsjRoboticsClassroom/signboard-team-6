package nyc.c4q.ac21.signboard;

import java.util.Random;

public class Main {

    public static void truckMoving(SignBoard board) {
        String line1 = "      ____________________        ";
        String line2 = "     |                 ___|       ";
        String line3 = "     |                 |----.     ";
        String line4 = "     |                 | |O,|____ ";
        String line5 = "@    |  .-.            | -  .-.  |";
        String line6 = "`@@ =(_| @ |___________|___| @ |_)";
        String line7 = "        `-'                 `-'   ";




        int truckLength = line1.length();


        int width = board.getWidth();
        int y = board.getHeight() - 1;
        for (int x = -truckLength; x <= width; x++) {

            SignBoard.Frame frame = board.newFrame();

            if (x >= width){
                break;
            }

            if(x < 0){
                frame.write(0, y - 7, line1.substring(-x));
                frame.write(0, y - 6, line2.substring(-x));
                frame.write(0, y - 5, line3.substring(-x));
                frame.write(0, y - 4, line4.substring(-x));
                frame.write(0, y - 3, line5.substring(-x));
                frame.write(0, y - 2, line6.substring(-x));
                frame.write(0, y - 1, line7.substring(-x));


            }
            else if(x + truckLength <= width) {

                frame.write(x, y - 7, line1);
                frame.write(x, y - 6, line2);
                frame.write(x, y - 5, line3);
                frame.write(x, y - 4, line4);
                frame.write(x, y - 3, line5);
                frame.write(x, y - 2, line6);
                frame.write(x, y - 1, line7);
            }
            else{

                frame.write(x, y - 7, line1.substring(0, width - x));
                frame.write(x, y - 6,line2.substring(0, width - x));
                frame.write(x, y - 5, line3.substring(0, width - x));
                frame.write(x, y - 4, line4.substring(0, width - x));
                frame.write(x, y - 3, line5.substring(0, width - x));
                frame.write(x, y - 2, line6.substring(0, width - x));
                frame.write(x, y - 1, line7.substring(0, width - x));

            }

            frame.finish(0.02);

        }
    }

    public static void tacoTrucksOnEveryCorner (SignBoard board) {

        String line1 = "      ____________________        ";
        String line2 = "     |                 ___|       ";
        String line3 = "     |                 |----.     ";
        String line4 = "     |                 | |O,|____ ";
        String line5 = "@    |  .-.            | -  .-.  |";
        String line6 = "`@@ =(_| @ |___________|___| @ |_)";
        String line7 = "        `-'                 `-'   ";

        int truckLength = line1.length();


        int width = board.getWidth();
        int y = board.getHeight() - 1;
        for (int x = -truckLength; x <= width/2; x++) {

            SignBoard.Frame frame = board.newFrame();

            if (x >= width) {
                break;
            }

            if (x < 0) {
                frame.write(0, y - 7, line1.substring(-x));
                frame.write(0, y - 6, line2.substring(-x));
                frame.write(0, y - 5, line3.substring(-x));
                frame.write(0, y - 4, line4.substring(-x));
                frame.write(0, y - 3, line5.substring(-x));
                frame.write(0, y - 2, line6.substring(-x));
                frame.write(0, y - 1, line7.substring(-x));

            }
            else if (x >= 0) {

                frame.write(0, y - 7, line1);
                frame.write(0, y - 6, line2);
                frame.write(0, y - 5, line3);
                frame.write(0, y - 4, line4);
                frame.write(0, y - 3, line5);
                frame.write(0, y - 2, line6);
                frame.write(0, y - 1, line7);

                if(x % 2 == 0) {
                    frame.setRed();
                }
                else{
                    frame.setGreen();
                }
                frame.write(width / 2, y - 6, "Tacos Trucks");

                if(x % 2 != 0) {
                    frame.setRed();
                }
                else{
                    frame.setGreen();
                }

                frame.write(width / 2, y - 4, "On Every Corner");
            }

            frame.finish(0.09);



        }

    }







    public static void main(String[] args) {
        SignBoard signBoard = new SignBoard(8);

        // Run the sign board forever.
        while (true) {
            truckMoving(signBoard);
            tacoTrucksOnEveryCorner(signBoard);

        }
    }
}
