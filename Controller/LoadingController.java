package Controller;

import View.LoadingPanel;

public class LoadingController {

    private LoadingPanel _loadingPanel;

    public LoadingController()
    {
        _loadingPanel = new LoadingPanel();

        Thread loadingThread = new Thread(()->{
            try{
                for(int i = 0; i <= 100; i++)
                {
                    _loadingPanel.setProgressValue(i);
                    Thread.sleep(110);
                }
            }catch(InterruptedException ie)
            {
                System.err.println("THREAD");
                System.err.println(ie.getMessage());
            }
        });

        loadingThread.start();
    }


    public LoadingPanel loadingPanel()
    {
        return _loadingPanel;
    }
    
}
