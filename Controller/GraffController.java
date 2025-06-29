package Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Model.Config;
import View.GraffView;
import View.LoadingPanel;

public class GraffController
{
    private GraffView _graffView;

    public GraffController(GraffView gv)
    {
        _graffView = gv;
        addCloseByKey();




        LoadingController loadingController = new LoadingController();
        setView(loadingController.loadingPanel());

    }


    public void setView(JPanel panel)
    {
        _graffView.setView(panel);
    }

    
    
    public void addCloseByKey()
    {
        _graffView.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent var1)
            {

            }

            @Override
            public void keyPressed(KeyEvent var1)
            {
                if(var1.isControlDown() && var1.getKeyCode() == KeyEvent.VK_Q )
                    System.exit(0);
            }

            @Override
            public void keyReleased(KeyEvent var1)
            {

            }
        });
    }

}
