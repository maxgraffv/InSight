import Controller.GraffController;
import View.GraffView;

import javax.swing.*;
public class Main
{




    public static void main(String[] args)
    {


        SwingUtilities.invokeLater(()->{
            new GraffController(new GraffView(1));

        });





    }
}