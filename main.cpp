#include <iostream>
#include <fstream>

class Leitor {

    std::string title;
    int width, height, fps;
    bool check;

public:
    Leitor(){}

    void readfile(const std::string& str){
        std::ifstream file(str);
        if( file.is_open() ){
            std::getline(file, this->title);
            file >> this->width >> this->height;
            file >> this->fps;
            file >> this->check;
        }
    }

    void show(){
        std::cout << "Name: " << this->title <<
                  "\nWidth: "  << this->width <<
                  "\nHeight: " << this->height <<
                  "\nFPS: "    << this->fps <<
                  "\nCHECK: " << this->check;
        std::cout.put('\n');
    }
};

int main( int argc , char **argv ){
    if( argc > 1 ){
        Leitor leitor;
        leitor.readfile(argv[1]);
        leitor.show();
    }else{
        std::cerr << "Informe o arquivo.\n";
        return 1;
    }
    return 0;
}