import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {
    public static void main(String[] args) {
        /*
	 	1) Lambda "Functional Programming"-->method(action) kullanma pr dili.
	 	   Lambda --> mathod create  etme değil mevcut method'ları(library)secip kullanmaktır...
	       Lambda  kendi başına tanımlanabilen parametre alıp gönderebilen fonksiyonlardır.
	 	   Lambda’lar sayesinde daha az kod ve hızlı geliştirme sağlanabilmektedir.
	   	   Java 8 ile gelen bu özellik, Java 8’in en önemli özelliğidir.

	 		"Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
	 	2) "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
	 	3) "Functional Programming" hiz, code kisaligi, code okunabilirligi
	     	ve hatasiz code yazma acilarindan cok faydalidir.
	 	4) Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.
           Lambda kullanmak hatasız code kullanmaktır.

            Collections Nedir?
            Çoğu yazılım tek tek öğeler yerine öğelerden oluşan toplulukları depolar ve onlar üzerinde işlem
            yapar. Array’ler onlardan birisidir. Java Collections Framework, arraylerle yapılan işleri daha kolay
            yaptığı gibi, daha fazlasını da yapar.
            Java’da bir koleksiyon (collection - bazen container, ambar diye adlandırılır) nesnelerden oluşan bir
            topluluğu bir arada tutan bir yapıdır. ‘Collections Framework’ ise arayüzler ve onların kurgularından
            (implementations) oluşur.
	 */

        List<Integer> sayi = new ArrayList<>(Arrays.asList(34, 22, 16, 11, 35, 20, 63, 21, 65, 44, 66, 64, 81, 38, 15));

        System.out.println(sayi);
        printElStructured(sayi);
        System.out.println();
        printElFunctional(sayi);
        System.out.println();
        printElFunctional1(sayi);
        System.out.println("ciftleri  print");
        printCiftElStructured(sayi);
        System.out.println();

        printCiftElStructured(sayi);
        System.out.println();
        printCiftElFunctional(sayi);
        System.out.println();
        printCiftElFunctional1(sayi);

        System.out.println("\n34ten kucuk");

        printCiftEl34Functional(sayi);

        System.out.println("\n sa bruda");
        obuyukveya(sayi);
    }

    //Task: Structured programing kullanarak list elemanlarini
    //aralarinda bosluk olacak sekilde ayni satirda print ediniz.
    public static void printElStructured(List<Integer> sayi) {
        for (Integer each : sayi
        ) {
            System.out.print(each + " ");
        }
    }

    //Task: Functional programing kullanarak list elemanlarini
//  aralarinda bosluk olacak sekilde ayni satirda print ediniz.
    public static void printElFunctional(List<Integer> sayi) {
        sayi.stream().forEach(t -> System.out.print(t + " "));
    }


/*
        stream() : datalari yukaridan asagiya akis sekline getirir.
        Stream bir interface olduğundan dolayı doğrudan nesne almaz.
        (Akis,akarsu)

        forEach() :datanin parametresine gore her bir elemanı isler

        t-> : Lambda operatoru

         Lambda Expression-->(parameter list) -> {action body}
             Parameter list: Fonksiyonun parametreleri tanımlanır. Hiç parametre geçirmeden boşta olabilir.
             -> Arrow-token: Argüman listesi ile expression gövdesini birbirine bağlamak için kullanılır.

            Bir kod bloğundan oluşan bir body...
            Bu tip lambda body, block body olarak bilinir. Blok gövdesi, lambda gövdesinin birden çok ifade içermesine izin verir.
            Bu ifadeler parantez içine alınır ve parantezlerden sonra noktalı virgül eklemeniz gerekir.

                () -> {
                 double pi = 3.1415;
                    return pi;
                };
         Lambda Expression  yapisi cok tavsiye edilmez daha cok METHOD REFERENCE kullanilir

        */

    public static void printElFunctional1(List<Integer> sayi) {
        sayi.stream().forEach(System.out::print);//method reference--> System.outyapisinda print methodu refere et
        //bu action task'deki ayni satira ve bosluk ile yazmayi yapamaz bu yuzden
        //seed(tohum) method create edilip refere edilmeli
    }

    public static void yazdir(int a) {// verilen int degeri ayni satirda bosluk birakarak yazdirma
        // aksiyonu yapan seed(tohum) method create edildi
        System.out.print(a + " ");
    }

    public static void printElFunctional2(List<Integer> sayi) {
        sayi.stream().forEach(Lambda01::yazdir);//method reference--> System.outyapisinda print methodu refere et
    }
    //Structured Programming ile list elemanlarin cift olmalarini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void printCiftElStructured(List<Integer> sayi) {
        for (Integer w : sayi
        ) {
            if (w % 2 == 0) {
                System.out.print(w + " ");
            }
        }
    }

    //Task functional programming ile list elemanlarinin cift olanlarini ayni satirda aralarina bosluk birakarak printet
    public static void printCiftElFunctional(List<Integer> sayi) {

        sayi.
                stream().
                filter(t -> t % 2 == 0).
                forEach(Lambda01::yazdir);

    }

    public static boolean ciftBul(int a) {//seed method kendisine verilen int degerin cift olmasini kontrol eder
        return a % 2 == 0;
    }

    public static void printCiftElFunctional1(List<Integer> sayi) {

        sayi.
                stream().//list elemanlari akisa alindi
                filter(Lambda01::ciftBul).//ciftBul method refere edilerek akistaki elemanlar filtrelendi
                forEach(Lambda01::yazdir);//filtreden gelen elemanlar yazdir() method refere edilerek yazdirildi

    }

    //Task functional programming ile list elemanlarinin 34ten kucuk ve
    // cift olanlarini ayni satirda aralarina bosluk birakarak printet
    public static boolean kucukMu(int a) {

        return a < 34;
    }

    public static void printCiftEl34Functional(List<Integer> sayi) {

        sayi.
                stream().//list elemanlari akisa alindi
                filter(Lambda01::ciftBul).//ciftBul method refere edilerek akistaki elemanlar filtrelendi
                filter(Lambda01::kucukMu).//kucukMu method refere edilerek akistaki elemanlar 34 ten kucukse filtrelendi
                forEach(Lambda01::yazdir);//filtreden gelen elemanlar yazdir() method refere edilerek yazdirildi
    }
//Task functional programming ile list elemanlarinin 34ten buyuk veya
// cift olanlarini ayni satirda aralarina bosluk birakarak printet

    public static boolean obuyuk(int a) {//seed method kendisine verilen int degerin cift olmasini kontrol eder
        return (a % 2 == 0||a>34);
    }
    public static void obuyukveya(List<Integer> sayi){
        sayi.
                stream().
                filter(Lambda01::obuyuk).//birinci filtreden gecenler yalnizca ikinci filtre olursa oraya varabilirler
                //ikili kontrol yapilacak filtrelerdce hepsini ayni anda kontrol eden method cagirilmasi create edilmesi
                        //gereklidir
                forEach(Lambda01::yazdir);
    }





}


