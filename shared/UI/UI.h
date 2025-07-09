#include <iostream>



class UI
{
    private:
        std::string _title;

        bool isQtAvailable();


    public:
        UI( bool useQt = false );

        void setWidth();
        void setHeight();
        void show();
        void hide();

        void openQt();


};