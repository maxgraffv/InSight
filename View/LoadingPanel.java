package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import Model.Config;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class LoadingPanel extends JPanel {
    private Image _logoImage;   
    private JLabel _logoLabel;
    volatile private JProgressBar _progressBar;

    public LoadingPanel()
    {
        /*
         * LOGO Image
         */
        _logoImage = getLogoImage();
        _logoLabel = new JLabel("");
        _logoLabel.setSize(new Dimension(600, 90));
        _logoLabel.setIcon(new ImageIcon(_logoImage));
        _logoLabel.setSize(650, 100);
        _logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        _logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);


        /*
         * Progress Bar
         */
        _progressBar = getProgressBar();
            

        /*
         * Loading Panel Setup
         */
        this.setSize(new Dimension(Config.width, Config.height));
        this.setBackground(new Color(10, 10, 15));
        this.setLayout(new BorderLayout());

        
        /*
         * Center Container
         */
        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
        containerPanel.setOpaque(false);

        containerPanel.add(Box.createVerticalGlue());
        containerPanel.add(_logoLabel);
        containerPanel.add(Box.createVerticalStrut(20));
        containerPanel.add(_progressBar);
        containerPanel.add(Box.createVerticalGlue());

        this.add( containerPanel, BorderLayout.CENTER );
    }

    private Image getLogoImage()
    {
        try {
            
            BufferedImage bufforemImage = ImageIO.read(new File(Config.logoImagePath));
            Image image = bufforemImage.getScaledInstance(1000, 200, Image.SCALE_SMOOTH);
            return image;
        } catch (IOException e) {
            System.err.println("Image IO");
            System.err.println(e.getMessage());
        }

        return null;
    }

    private JProgressBar getProgressBar()
    {
        JProgressBar progressBar = new JProgressBar();
        progressBar.setMinimum(0);
        progressBar.setMaximum(100);
        progressBar.setValue(70);
        
        Dimension progressDim = new Dimension(800, 10);

        progressBar.setPreferredSize(progressDim);
        progressBar.setMaximumSize(progressDim);
        progressBar.setForeground(new Color(255, 120, 0));
        progressBar.setBackground(new Color(30, 30, 30));

        return progressBar;
    }

    synchronized public void setProgressValue(int val)
    {
        _progressBar.setValue(val);
        this.revalidate();
        this.repaint();
    }


}
