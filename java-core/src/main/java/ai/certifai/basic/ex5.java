package ai.certifai.basic;

import ai.certifai.util.Dashboard;

import java.util.ArrayList;

public class ex5 {
    public static void main(String[] args)
    {

        java.util.List results = new ArrayList<Boolean>();
        results.add(true);
        results.add(false);
        results.add(true);
        results.add(true);
        results.add(false);
        results.add(true);


        new Dashboard().show(results);
    }
}
