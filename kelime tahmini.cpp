#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#include <conio.h>
#include <stdbool.h>

#define MAX_KELIME_UZUNLUK 20
#define MAX_TAHMIN_HAKKI 3

const char* kelimeler[] = {"bilgisayar", "programlama", "gelistirici", "merhaba", "kodlama", "ogrenme", "basari", "fenerbahce", "matematik", "klavye"};

void girismesaji(){
	
	printf("\n\n\n\n\n\n\n\n\n");
	printf("\n\t\t\t\t\t-\t\t\t\t\t-");
	printf("\n\t\t\t\t|\t\t\t\t\t\t\t|");
	printf("\n\t\t\t\t|\t\tKelime Oyununa Hosgeldiniz\t\t|");
	printf("\n\t\t\t\t|\t\t\t\t\t\t\t|");
	printf("\n\t\t\t\t\t-\t\t\t\t\t-");
	printf("\n\n\n\n");
    getch();
    system("cls");
	
}

void oyunuBaslat() {
    srand(time(0));

    int toplamKelimeSayisi = sizeof(kelimeler) / sizeof(kelimeler[0]);
    int rastgeleIndex = rand() % toplamKelimeSayisi;

    const char* secilenKelime = kelimeler[rastgeleIndex];

    int kelimeUzunluk = strlen(secilenKelime);
    char* tahminEdilenKelime = (char*)malloc((kelimeUzunluk + 1) * sizeof(char));

    for (int i = 0; i < kelimeUzunluk; i++) {
        tahminEdilenKelime[i] = '_';
    }

    tahminEdilenKelime[kelimeUzunluk] = '\0';

    int kalanTahminHakki = MAX_TAHMIN_HAKKI;
    while (kalanTahminHakki > 0) {
        printf("Tahmin edilen kelime: %s\n", tahminEdilenKelime);
        printf("Kalan tahmin hakki: %d\n", kalanTahminHakki);
        char tahmin;
        printf("Bir harf tahmin edin: ");
        scanf(" %c", &tahmin);
        printf("\n------------------------------------------------------------\n\n");
        
        int dogruTahmin = 0;

        for (int i = 0; i < kelimeUzunluk; i++) {
            if (secilenKelime[i] == tahmin) {
                tahminEdilenKelime[i] = tahmin;
                dogruTahmin = 1;
            }
        }

        if (!dogruTahmin) {
            kalanTahminHakki--;
            printf("Hatali tahmin! Kalan tahmin hakki: %d\n", kalanTahminHakki);
            if (kalanTahminHakki==0){
            	printf("Kelime: %s\n",secilenKelime);
			}
        }

        if (strcmp(secilenKelime, tahminEdilenKelime) == 0) {
            printf("Tebrikler! Kelimeyi dogru tahmin ettiniz: %s\n", secilenKelime);
            break;
        }
     }

    free(tahminEdilenKelime);
}

int main() {
    girismesaji();
    char devam[10];
    bool kontrol=false;
    printf("\t\t**KELIME OYUNU**");
    printf("\n------------------------------------------------------------\n\n");
    oyunuBaslat();
    while (kontrol==false){
        printf("Yeni bir oyun oynamak ister misiniz? (E/H): ");
        scanf("%s", &devam);

        if (strcmp(devam,"EVET")==0 || strcmp(devam,"evet")==0){
            system("cls");
            printf("\t\t**KELIME OYUNU**");
            printf("\n------------------------------------------------------------\n\n");
            oyunuBaslat();
		    kontrol=false;
		}
		else if(strcmp(devam,"HAYIR")==0 || strcmp(devam,"hayir")==0)
		{
            printf("\n------------------------------------------------------------\n\n");
            printf("Oyun sona erdi. Tesekkurler!\n");
            kontrol=true;
        }
        else {
        	printf("\nYanlis giris yaptiniz lutfen tekrar deneyiniz.\n");
		}

    } 

    return 0;
}

