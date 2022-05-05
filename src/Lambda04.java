import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {

    /*
    TASK :
    fields --> Universite (String)
               bolum (String)
               ogrcSayisi (int)
               notOrt (int)
               olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
     */
    public static void main(String[] args) {

        Universite bogazici = new Universite("bogazici", "matematik", 571, 93);
        Universite itu = new Universite("istanbul teknik", "matematik", 622, 81);
        Universite istanbul = new Universite("istanbul", "hukuk", 1453, 71);
        Universite marmara = new Universite("marmara", "bilgisayar muh", 1071, 77);
        Universite ytu = new Universite("yıldız teknik", "gemi", 333, 74);
        List<Universite> unv = new ArrayList<>(Arrays.asList(bogazici, itu, istanbul, marmara, ytu));

        System.out.println(notOrt74BykUnv(unv));
    }

    //task 01--> notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.
    public static boolean notOrt74BykUnv(List<Universite> unv) {

        return unv.
                stream().
                allMatch(t -> t.getNotOrt() > 74);
    }

    //task 02-->ogrc sayilarinin   110 den az olmadigini  kontrol eden pr create ediniz.

    public static boolean ogrcSayisi110AzMi(List<Universite> unv) {
        return unv.
                stream().
                allMatch(t -> t.getOgrSayisi() > 110);
    }
    //task 03-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.

    public static boolean matBolumVarmi(List<Universite> unv) {
        return unv.stream().
                anyMatch(t -> t.getBolum().toLowerCase().contains("mat"));
    }

    //task 04-->universite'leri ogr sayilarina gore b->k siralayiniz.
    public static List<Universite> ogrSayiBkSirala(List<Universite> unv) {
        return unv.
                stream().
                sorted(Comparator.comparing(Universite::getOgrSayisi).reversed()).
                collect(Collectors.toList());
    }

    public static void ogrSayiBkSiralaVoid(List<Universite> unv) {
        System.out.println(unv.
                stream().
                sorted(Comparator.comparing(Universite::getOgrSayisi).reversed()).
                collect(Collectors.toList()));//collect()->akısdaki elamanları istenen sarta gore toplar
        //Collectors.toList()->collect'e toplanan elemanlari list'e cevirir
    }

    //task 05-->universite'leri notOrt gore  b->k siralayip ilk 3 'unu print ediniz.
    public static List<Universite> notOrtBkSialiIlkUc(List<Universite> unv) {
        return unv.
                stream().//akısa alındı
                        sorted(Comparator.comparing(Universite::getNotOrt).reversed()).//notOrt a göre b->k sıralandı
                        limit(3).//akısın ilk 3 elemanı alındı
                        collect(Collectors.toList());//akısın ilk 3 elemanı list'e assign edildi
        //toList());//akısın ilk 3 elemanı list'e assign edildi
    }


    //task 06--> ogrc sayisi en az olan 2. universite'yi  print ediniz.

    public static List<Universite> enAzOgrcSaysi2Unv(List<Universite> unv) {
        return unv.
                stream().
                sorted(Comparator.comparing(Universite::getOgrSayisi)).
                limit(2).
                skip(1).
                collect(Collectors.toList());

    }

    //task 07--> notOrt 63 'den buyuk olan universite'lerin ogrc sayilarini toplamini print ediniz.
    public static int notOrt63BykUnvOgrcSayisiTopla(List<Universite> unv) {
        return unv.
                stream().
                filter(t -> t.getNotOrt() > 63).
                map(t -> t.getOgrSayisi()).
                // reduce(Integer::sum);
                // reduce(Math::addExact);
                        reduce(0, (t, u) -> t + u);

    }

    public static int notOrt63BykUnvOgrcSayisiToplaToInt(List<Universite> unv) {
        return unv.
                stream().
                filter(t -> t.getNotOrt() > 63).
                mapToInt(t -> t.getOgrSayisi()).
                sum();
        // mapToInt() --> bu method akısdaki elemanların data type'nı
        // parameterisindeki() degere göre Int data type update eder

    }

    //task 08--> Ogrenci sayisi 333'dan buyuk olan universite'lerin notOrt'larinin ortalamasini bulunuz.
    public static OptionalDouble ogrcSayisi333BykNotOrtOrtlamaAl(List<Universite> unv) {

        return unv.
                stream().
                filter(t -> t.getOgrSayisi() > 333).
                mapToDouble(t -> t.getNotOrt()).//
                        average();//akısdakş elamnalrın ortlaması alındı
        // mapToDouble() --> bu method akısdaki elemanların data type'nı
        // parameterisindeki degere göre dooble data type update eder

    }

    //task 09-->"matematik" bolumlerinin sayisini  print ediniz.
    public static int mathBolmSayısı(List<Universite> unv) {
        return (int) unv.
                stream().
                filter(t -> t.getBolum().contains("mat")).
                count();//akısdaki elelman sayısını return eder
        //count();-->akısdaki elelman sayısını return eder

    }

    //task 10-->Ogrenci sayilari 571'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz.
    public static OptionalInt ogrcSayisi571BykMaxNotort(List<Universite> unv) {
        return unv.
                stream().//akıs
                        filter(t -> t.getOgrSayisi() > 571).//unv obj akısı fittrelendi
                        mapToInt(t -> t.getNotOrt()).//akısdaki unv obj notOrt akısı olarak update edildi
                        max();   //akısın en byk degerini return eder

    }

    //task 11-->Ogrenci sayilari 1071'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.
    public static OptionalInt ogrcSayisi1071AzMinnotOrt(List<Universite> unv) {
        return unv.
                stream().
                filter(t -> t.getOgrSayisi() < 1071).
                mapToInt(t -> t.getNotOrt()).
                min();

    }
}