package KelimeTahmin;

import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class uygulama {

	public static int hak = 3;
	public static Character[] harfler = { 'a', 'b', 'c', 'ç', 'd', 'e', 'f', 'g', 'ğ', 'h', 'ı', 'i', 'j', 'k', 'l',
			'm', 'n', 'o', 'ö', 'p', 'r', 's', 'ş', 't', 'u', 'ü', 'v', 'y', 'z' };
	public static String[] kelimeler = { "bilgisayar", "matematik", "futbol", "yazılım", "fenerbahçe", "adam", "top",
			"telefon", "masa", "ev", "poster", "cansu" };

	public static void main(String[] args) {

		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		boolean kontrol = true;
		int deger = random.nextInt(kelimeler.length);
		String secilenKelime = kelimeler[deger];

		System.out.print("Tahmin edilecek kelime: ");
		char[] gizliKelime = new char[secilenKelime.length()];
		for (int i = 0; i < gizliKelime.length; i++) {
			gizliKelime[i] = '_';
			System.out.print(gizliKelime[i]);
		}

		// Tahmin edilen harfleri saklamak için bir set oluşturma
		Set<Character> tahminEdilenHarfler = new HashSet<>();

		System.out.println();

		while (kontrol) {

			System.out.print("\nEğer kullanabilceğiniz harfleri görmek isterseniz 'Harfler' yazabilirsiniz."
					+ "\nLütfen tahmin etmek istediğiniz harfi veya kelimeyi yazınız: ");
			String tahmin = scanner.next().toLowerCase();

			if (tahmin.length() > 1) {
				if (tahmin.equals("harfler")) {
					System.out.println();
					System.out.print("Kullanabilceğiniz harfler: ");
					for (int i = 0; i < harfler.length; i++) {
						System.out.print(harfler[i] + " ");
					}
					System.out.println();
					System.out.println("\n---------------------------------------------------------------------\n");
					System.out.println("Kullandığınız harfler: " + tahminEdilenHarfler);
					System.out.println();
					System.out.print("Tahmin edilen kelime: ");
					for (char c : gizliKelime) {
						System.out.print(c);
					}
					System.out.println();
				} else if (tahmin.equals(secilenKelime)) {
					System.out.println("\n---------------------------------------------------------------------\n");
					System.out.println("Tebrikler! Kelimeyi doğru tahmin ettiniz.\n");
					System.out.print("Tahmin edilen kelime: " + secilenKelime);
					System.out.println();
					kontrol = false;
				} else {
					System.out.println("Yanlış tahmin :(");
					hak--;
					System.out.println("Kalan hak sayısı: " + hak);
					System.out.println("\n---------------------------------------------------------------------\n");
					System.out.println("Kullandığınız harfler: " + tahminEdilenHarfler);
					if (hak == 0) {
						kontrol = false;
						System.out.println("Ne yazık ki hakkınız bitti kelimeyi doğru tahmin edemediniz.\n"
								+ "\nTahmin edilen kelime: " + secilenKelime);
						continue;
					}

				}
			} else {
				char tahminEdilenHarf = tahmin.charAt(0);
				// Harfin geçerli olup olmadığını kontrol edin
				if (!Set.of(harfler).contains(tahminEdilenHarf)) {
					System.out.println("\nGeçersiz harf girdiniz.Lütfen türk alfabesinden bir harf giriniz.\n");
					System.out.print("Kullanabilceğiniz harfler: ");
					for (int i = 0; i < harfler.length; i++) {
						System.out.print(harfler[i] + " ");
					}
					System.out.println();
					System.out.println("\n---------------------------------------------------------------------\n");
				} else if (tahminEdilenHarfler.contains(tahminEdilenHarf)) {
					System.out.println("Bu harfi '" + tahminEdilenHarf + "' zaten kullandınız.");
					System.out.println("\n---------------------------------------------------------------------\n");
					System.out.println("Kullandığınız harfler: " + tahminEdilenHarfler);
					System.out.println();
				} else {
					tahminEdilenHarfler.add(tahminEdilenHarf);

					boolean harfBulundu = false;
					for (int i = 0; i < secilenKelime.length(); i++) {
						if (secilenKelime.charAt(i) == tahminEdilenHarf) {
							gizliKelime[i] = tahminEdilenHarf;
							harfBulundu = true;
						}
					}

					if (harfBulundu) {
						System.out.println("Doğru tahmin!");
						System.out.println("\n---------------------------------------------------------------------\n");
						System.out.println("Kullandığınız harfler: " + tahminEdilenHarfler);
						System.out.println();
					} else {
						System.out.println("Yanlış tahmin :(");
						hak--;
						System.out.println("Kalan hak sayısı: " + hak);
						System.out.println("\n---------------------------------------------------------------------\n");
						if (hak == 0) {
							kontrol = false;
							System.out.println("\nNe yazık ki hakkınız bitti kelimeyi doğru tahmin edemediniz."
									+ "\nTahmin edilen kelime: " + secilenKelime);
							continue;
						}
						System.out.println("Kullandığınız harfler: " + tahminEdilenHarfler);
						System.out.println();

					}

					if (new String(gizliKelime).equals(secilenKelime)) {
						System.out.println("Tebrikler! Kelimeyi doğru tahmin ettiniz.\n");
						kontrol = false;
					}
					System.out.print("Tahmin edilen kelime: ");
					for (char c : gizliKelime) {
						System.out.print(c);
					}
					System.out.println();
				}
			}
		}
	}
}
