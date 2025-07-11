#include <iostream>



class UI
{
    private:
        std::string _title;

    public:
        UI();

        virtual void setWidth() = 0;
        virtual void setHeight() = 0;
        virtual void run() = 0;

};