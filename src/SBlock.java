import java.awt.*;

public class SBlock {

    public static void drawNewSBlock() {

        System.out.println("x1:" + Round.x1 + ", y1:" + Round.y1);
        System.out.println("x2:" + Round.x2 + ", y1:" + Round.y2);
        System.out.println(Round.heights[(int) Round.x1][(int) Round.y1] + ";" +
                Round.heights[(int) Round.x1 + 1][(int) Round.y1] + ";" +
                Round.heights[(int) Round.x1 + 1][(int) Round.y1 + 1] + ";" +
                Round.heights[(int) Round.x1 + 2][(int) Round.y1 + 1]);

        if(Round.heights[(int) Round.x1][(int) Round.y1] != 0 ||
                Round.heights[(int) Round.x1 + 1][(int) Round.y1] != 0 ||
                Round.heights[(int) Round.x1 + 1][(int) Round.y1 + 1] != 0 ||
                Round.heights[(int) Round.x1 + 2][(int) Round.y1 + 1] != 0) {

            System.out.println("CONTROL");
            Round.y1++;
            Round.y2++;

            SBlockInMatrix(1);
            paintSBlock(Color.GREEN);

            Round.anew = 0;
            return;
        }

        SBlockInMatrix(1);

        paintSBlock(Color.GREEN);
    }

    public static void deleteSBlock() {

        SBlockInMatrix(0);
        paintSBlock(Color.LIGHT_GRAY);
    }

    public static void paintSBlock(Color color) {

        FrmTetris.graph.fillRect(Round.x1, Round.y1, Round.x1 + 1, Round.y1 + 1, color);
        FrmTetris.graph.fillRect(Round.x1 + 1, Round.y1, Round.x1 + 2, Round.y1 + 1, color);
        FrmTetris.graph.fillRect(Round.x1 + 1, Round.y2 - 1, Round.x1 + 2, Round.y2, color);
        FrmTetris.graph.fillRect(Round.x1 + 2, Round.y2 - 1, Round.x2, Round.y2, color);
    }

    public static void SBlockInMatrix(int value) {

        Round.heights[(int) Round.x1][(int) Round.y1] = value;
        Round.heights[(int) Round.x1 + 1][(int) Round.y1] = value;
        Round.heights[(int) Round.x1 + 1][(int) Round.y1 + 1] = value;
        Round.heights[(int) Round.x1 + 2][(int) Round.y2 - 1] = value;
    }
}
