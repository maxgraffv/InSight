package View;

import Model.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;

public class GraffView extends JFrame{

    private double _windowScalar;
    private int _height, _width;
    private int _radius;
    private JPanel _mainPanel;

    public GraffView(double windowScalar)
    {
        /*
         * Values
         */
        _windowScalar = windowScalar;
        _height = (int)((double)Config.height*_windowScalar);
        _width = (int)((double)Config.width*_windowScalar);
        _radius = Config.radius;

        /*
         * Rounded Corners
         */
        roundedCorners();

        /*
         * Window Dimesion
         */
        Dimension windowDimension = new Dimension(_width, _height);
        this.setSize(windowDimension);
        this.setPreferredSize(windowDimension);


        /*
         * MainPanel
         */
        _mainPanel = new JPanel();
        _mainPanel.setSize(windowDimension);
        _mainPanel.setBackground(Color.PINK);

        this.add(_mainPanel);



        /*
         * Miscellaneous
         */
        this.setLocationRelativeTo(null); // Center window on screen
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void roundedCorners()
    {
        this.setUndecorated(true);
        this.setShape(new RoundRectangle2D.Double(0,0, _width, _height, _radius, _radius) );
    }
   
    public void setView(JPanel panel)
    {
        if(_mainPanel != null)
            this.remove(_mainPanel);

        _mainPanel = panel;
        this.add(_mainPanel);
        this.invalidate();
        this.repaint();
    }

}
