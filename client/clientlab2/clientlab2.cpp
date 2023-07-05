#pragma comment(lib, "ws2_32.lib")
#include <winsock2.h>
#include <string>
#include <iostream>

#pragma warning(disable: 4996)
using namespace std;

int main()
{



    WORD wVersionRequested;

    WSADATA wsaData;

    SOCKET s;

    sockaddr_in addr;

    char b[200];

    int err, size, key;

    SetConsoleCP(1251); 

    SetConsoleOutputCP(1251); 

    wVersionRequested = MAKEWORD(2, 2);

    err = WSAStartup(wVersionRequested, &wsaData); // инициализация WinSock DLL

    if (err != 0) return 9; 

    s = socket(AF_INET, SOCK_DGRAM, 0); // создание сокета, протокол UDP

    addr.sin_family = AF_INET; 

    addr.sin_port = htons(1024); 

    addr.sin_addr.s_addr = inet_addr("127.0.0.1"); // IP-адрес сервера

    while (true) {
        cout << "Введите строку" << endl;

        cin.getline(b, sizeof(b), '\n'); // ввод слова

        size = sizeof(addr);

        sendto(s, b, sizeof(b), 0, (sockaddr*)&addr, size); // отправка слова серверу

        if (recvfrom(s, b, sizeof(b), 0, (sockaddr*)&addr, &size) != 0) { // получение ответа

            cout << b << endl;
        }

        cout << "Отправить еще одну строку?\n1 - да\n2 - нет" << endl;
        cin >> key;
        if (key == 2)
        {
            return 1;
        }
        cin.ignore(100, '\n');
        cin.clear();

    }




    closesocket(s); // закрытие сокета

    WSACleanup(); // завершение работы с WinSock API

}