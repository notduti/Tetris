import java.awt.*;

public class SquareBlock extends CurrentBlock {

    SquareBlock() { super(); }




    //-- -- changing direction -- --//

    public void changeOrientation(int spin) {

        return;
    }




    //-- -- general functions -- --//

    public void drawNewBlock() {

        FallingControls();
        SquareBlockInMatrix(2);
        PaintSquareBlock(Color.YELLOW);
    }

    public void deleteBlock() {

        SquareBlockInMatrix(0);
        PaintSquareBlock(Color.LIGHT_GRAY);
    }

    public void controlLateralMovementBlock(String direction) {

        ControlLateralMovementSquareBlock(direction);
    }




    //-- -- lateral movement controls -- --//

    public static void ControlLateralMovementSquareBlock(String direction) {

        if(direction.compareTo("increase") == 0) {

            if(Round.x1 > 7) return;
            if(Round.heights[(int) Round.x1 + 2][(int) Round.y1] == 0 &&
                    Round.heights[(int) Round.x1 + 2][(int) Round.y1 + 1] == 0) {

                Round.x1increase();
                FallingControls();
            }
        }
        else if(direction.compareTo("decrease") == 0) {

            if(Round.x1 < 1) return;
            if(Round.heights[(int) Round.x1 - 1][(int) Round.y1] == 0 &&
                    Round.heights[(int) Round.x1 - 1][(int) Round.y1 + 1] == 0) {

                Round.x1decrease();
                FallingControls();
            }
        }
    }




    //-- -- falling controls -- --//

    public static void FallingControls() {

        if(Round.heights[(int) Round.x1][(int) Round.y1] != 0 ||
                Round.heights[(int) Round.x1 + 1][(int) Round.y1] != 0) {

            Round.y1++;

            SquareBlockInMatrix(2);
            PaintSquareBlock(Color.YELLOW);

            SquareBlock.blockOrientation = 0;
            Round.anew = 0;
        }
    }




    //-- -- painting the block -- --//

    public static void PaintSquareBlock(Color color) {

        FrmTetris.graph.fillRect(Round.x1, Round.y1, Round.x1 + 1, Round.y1 + 1, color);
        FrmTetris.graph.fillRect(Round.x1 + 1, Round.y1, Round.x1 + 2, Round.y1 + 1, color);
        FrmTetris.graph.fillRect(Round.x1 + 1, Round.y1 + 1, Round.x1 + 2, Round.y1 + 2, color);
        FrmTetris.graph.fillRect(Round.x1, Round.y1 + 1, Round.x1 + 1, Round.y1 + 2, color);
    }




    //-- -- Modifying matrix -- --//

    public static void SquareBlockInMatrix(int value) {

        Round.heights[(int) Round.x1][(int) Round.y1] = value;
        Round.heights[(int) Round.x1 + 1][(int) Round.y1] = value;
        Round.heights[(int) Round.x1 + 1][(int) Round.y1 + 1] = value;
        Round.heights[(int) Round.x1][(int) Round.y1 + 1] = value;
    }

}
