//Клиент вводит с клавиатуры строку символов и посылает ее серверу.Признак окончания ввода строки – нажатие  клавиши «Ввод».
//Сервер, получив эту строку, должен определить длину введенной строки, и, если эта длина нечетная, 
//то удаляется символ, стоящий посередине строки.Преобразованная строка передается назад клиенту.
#include <winsock2.h>
#pragma comment(lib, "ws2_32.lib")
#include <iostream>
#include <string>
#pragma warning(disable: 4996)
using namespace std;

int main()
{


    SetConsoleCP(1251); 

    SetConsoleOutputCP(1251); 

    WORD wVersionRequested;

    WSADATA wsaData;

    SOCKET s;

    sockaddr_in addr;

    int err, size;

    string temp;

    char b1[200], b2[200];

    int i, k, n, v1, v2, s1, s2;

    wVersionRequested = MAKEWORD(2, 2); 

    err = WSAStartup(wVersionRequested, &wsaData); // инициализация WinSock DLL

    if (err != 0) return 9; 

    addr.sin_family = AF_INET; 

    addr.sin_port = htons(1024); 

    addr.sin_addr.s_addr = inet_addr("127.0.0.1"); // IP-адрес сервера

    s = socket(AF_INET, SOCK_DGRAM, 0); // создание сокета потока, протокол UDP

    bind(s, (sockaddr*)&addr, sizeof(addr)); // связывание сокета с локальным адресом

    while (true) 

    {

        size = sizeof(addr);

        recvfrom(s, b1, sizeof(b1), 0, (sockaddr*)&addr, &size); // приём строки

        n = strlen(b1); 

        if (n % 2 == 0)
        {
            cout << "Строка является четной" << endl;
            temp = "Строка является четной";
            for (int i = 0; i < temp.size(); i++)
            {
                b1[i] = temp[i];
            }
            b1[temp.size()] = '\0';
            sendto(s, b1, sizeof(b1), 0, (sockaddr*)&addr, size); // отправка ответа
            continue;

        }
        else {
            int counter = 0;
            cout << "Строка нечетная" << endl;
            for (int i = 0; i < n; i++)
            {

                if (i == n / 2)
                {
                    continue;
                }

                b2[counter] = b1[i];
                counter++;
            }
            b2[counter] = '\0';
            sendto(s, b2, sizeof(b2), 0, (sockaddr*)&addr, size); // отправка ответа


        }







    }

    closesocket(s); 

    WSACleanup(); 





}

