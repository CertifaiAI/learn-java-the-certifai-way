package ai.certifai.basic;

import ai.certifai.util.ResultBoard;

import java.util.ArrayList;

public class ex5 {
    public static void main(String[] args)
    {
        ResultBoard board = new ResultBoard();

        java.util.List results = new ArrayList<Boolean>();
        results.add(true);
        results.add(false);
        results.add(true);
        results.add(true);
        results.add(false);
        results.add(true);


        board.display(results);
    }
}
