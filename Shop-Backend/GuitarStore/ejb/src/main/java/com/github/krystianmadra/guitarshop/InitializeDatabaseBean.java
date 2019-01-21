package com.github.krystianmadra.guitarshop;

import com.github.krystianmadra.guitarshop.entities.GuitarCategoryEntity;
import com.github.krystianmadra.guitarshop.entities.GuitarEntity;
import com.github.krystianmadra.guitarshop.entities.OpinionEntity;
import com.github.krystianmadra.guitarshop.entities.UserEntity;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Singleton
@Startup
public class InitializeDatabaseBean {

    @PersistenceContext(unitName = "primary")
    private EntityManager em;

    // Mock
    @PostConstruct
    public void init(){
        GuitarCategoryEntity electric = new GuitarCategoryEntity("Electric");
        GuitarCategoryEntity classic = new GuitarCategoryEntity("Classic");
        GuitarCategoryEntity acoustic = new GuitarCategoryEntity("Acoustic");
        GuitarCategoryEntity bass = new GuitarCategoryEntity("Bass");

        em.persist(electric);
        em.persist(classic);
        em.persist(acoustic);
        em.persist(bass);

        // Elektryczne
        GuitarEntity electric1 = new GuitarEntity("Cort G200 SRD", 535.0, 2,"Cort G200 SRD Szalenie uniwersalna gitara elektryczna, oparta o zestaw 3 pickup'ów single-coil o dużej selektywości", electric);
        GuitarEntity electric2 = new GuitarEntity("Cort G220 CAR", 699.0, 2,"Cort G220 CAR Wygodna gitara elektryczna, która dzięki podwójnemu wycięciu \"cutaway\" umożliwia ułatwiony dostęp do wysokich rejestrów", electric);
        GuitarEntity electric3 = new GuitarEntity("ESP LTD EC-1000FM STP", 3299.0, 2,"ESP LTD EC-1000T CTM DMZ BLK Gitara w kształcie zrobiona na wzór ESP Eclipse. Jej koreański odpowiednik jest równie starannie wykonany i daje dużą przyjemność z gry", electric);
        GuitarEntity electric4 = new GuitarEntity("ESP LTD F-50 BLK", 999.0, 2,"ESP LTD F-50 BLK Korpus lipa Gryf klon Podstrunnica palisander Pickups ESP LH-150 Set Hardware Chrom Mostek tune-o-matic 24 progi kolor BLK", electric);
        GuitarEntity electric5 = new GuitarEntity("ESP LTD M-50 FR NGR", 1199.0, 2,"ESP LTD M-50 FR NGR Bardzo ciekawa propozycja dla gitarzystów, którzy lubią się wyróżniać. M-50 FR NGR wyposażono w ruchomy most tremolo", electric);
        GuitarEntity electric6 = new GuitarEntity("Fender American Performer RW", 4599.0, 2,"Fender American Performer Stratocaster RW AWT Marka Fender prezentuje swoją najnowszą serię gitar elektrycznych - American Performer", electric);
        GuitarEntity electric7 = new GuitarEntity("Guild S-100 WHT", 2399.0, 2,"Guild S-100 WHT Doskonała gitara elektryczna wzorowana na klasycznym modelu z lat 70'. Prawdziwe vintage'owe brzmienie oraz wykonanie według najwyszych standardów", electric);
        GuitarEntity electric8 = new GuitarEntity("Ibanez GART60 WNS", 899.0, 2,"Ibanez GART60 WNS Nowa gitara elektryczna marki Ibanez z serii GIO. Model o szczególnie pozytywnym stosunku jakości do ceny", electric);
        GuitarEntity electric9 = new GuitarEntity(" Jackson Rhoads RR", 2999.0, 2,"Jackson Rhoads RR Pro Series GB Jackson Rhoads RR Pro Series to najwyższa jakość i powalające brzmienie instrumentu", electric);
        GuitarEntity electric10 = new GuitarEntity("Schecter C-1 Platinum SBK", 2499.0, 2,"Schecter C-1 Platinum SBK Gitara marki Schecter z serii Platinum to najwyższa jakość wykonania i dbałość o szczegóły w każdym egzemplarzu instrumentu", electric);

        // Klasyczne
        GuitarEntity classic1 = new GuitarEntity("Alhambra 5P", 2999.0, 2,"Alhambra 5P  Precyzyjnie wykonana hiszpańska gitara klasyczna z najwyższej jakości materiałów i starannie wyselekcjonowanego drewna",classic);
        GuitarEntity classic2 = new GuitarEntity("Manuel Rodriguez C10", 879.0, 2,"Manuel Rodriguez C10 Gitary Manuel Rodriguez to unikalne instrumenty dostępne w bardzo szerokiej gamie wyboru drewna",classic);
        GuitarEntity classic3 = new GuitarEntity("Ortega R122", 699.0, 2,"Ortega R122 Wyjątkowy instrument o rozmiarze 4/4, świetnej selekcji drewna oraz pięknej stylistyce Ortega R122 cechuje się brzmieniem wyraźnym i głośnym",classic);
        GuitarEntity classic4 = new GuitarEntity("Strunal 770", 1059.0, 2,"Strunal 770 Wysokiej jakości gitara klasyczna produkcji europejskiej. Instrument ten charakteryzuje się wzorowym brzmieniem oraz niesamowicie precyzyjnym wykończeniem",classic);
        GuitarEntity classic5 = new GuitarEntity("Yamaha CG142C", 999.0, 2,"Yamaha CG142C Znakomita gitara klasyczna, perfekcyjnie wykonana z najlepszych materiałów. Świetne brzmienie i duży komfort gry",classic);
        GuitarEntity classic6 = new GuitarEntity("Admira A5", 1249.0, 2,"Admira A5 Rasowa gitara klasyczna o prawdziwym hiszpańskim brzmieniu. Instrument wykonany jest ze starannej selekcji drewna Cedrowego oraz Palisandru",classic);
        GuitarEntity classic7 = new GuitarEntity("Admira Juanita", 799.0, 2,"Admira Juanita Juanita to dobrej klasy gitara klasyczna produkowana w Hiszpani, zgodnie ze sztuką lutniczą Hiszpańskich mistrzów",classic);
        GuitarEntity classic8 = new GuitarEntity("Alhambra 10FP Pinana", 7585.0, 2,"Alhambra 10FP Pinana Luksusowa gitara klasyczna typu flamenco. Wyprodukowana przez hiszpańską firmę Alhambra",classic);
        GuitarEntity classic9 = new GuitarEntity("Alvarez RC 26", 589.0, 2,"Alvarez RC 26 Piękna gitara klasyczna marki Alvarez słynącej z tradycji ręcznego wytwarzania instrumentów, świetnie dobranego drewna i precyzji wykonania",classic);
        GuitarEntity classic10 = new GuitarEntity("Ever Play C-200", 429.0, 2,"Ever Play C-200 Świetna gitara klasyczna marki Ever Play. Model wykonany precyzyjnie z najwyższej jakości drewna, co wpywa na przyjemne i ciepłe brzmienie",classic);

        // Akustyczne
        GuitarEntity acoustic1 = new GuitarEntity("Ever Play Taiki W-800 N", 679.0, 2,"Ever Play Taiki W-800 N Gitary akustyczne z serii Taiki znane są z dobrego wykonania i dużej wygody gry. Instrument dysponuje donośmym i ciepłym brzmieniem",acoustic);
        GuitarEntity acoustic2 = new GuitarEntity("Fender FA-125 Dreadnought", 439.0, 2,"Fender FA-125 Dreadnought BLK Nowa gitara akustyczna marki Fender z serii FA. Model jest idealnym rozwiązaniem dla muzyków poszukujacych porządnej gitary akustycznej",acoustic);
        GuitarEntity acoustic3 = new GuitarEntity("Furch D32 SM", 5299.0, 2,"Furch D32 SM Genialna gitara akustyczna renomowanej marki Furch z serii Vintage. Najwyzsza jakość wykonania, piękne wykończenie, duża grywalność i świetne brzmienie",acoustic);
        GuitarEntity acoustic4 = new GuitarEntity("Tanglewood TW130 SM", 959.0, 2,"Tanglewood TW130 SM Gitara akustyczna od firmy Tanglewood, która dzięki doskonałej selekcji drewna pozwoli uzyskać wyraźne i przejrzyste brzmienie",acoustic);
        GuitarEntity acoustic5 = new GuitarEntity("Taylor GA4", 4990L, 2,"Taylor GA4 Piękna gitara akustyczna marki Tylor. Instrument o świetnej kombinacji drewna w celu uzyskania optymalnego brzmienia",acoustic);
        GuitarEntity acoustic6 = new GuitarEntity("Yamaha F370 NT", 599.0, 2,"Yamaha F370 NT Jedna z najczęściej wybieranych gitar akustycznych. Yamaha F-370 swoją popularność zawdzięcza świetnemu wykonaniu a co za tym idzie, komfortowi gry",acoustic);
        GuitarEntity acoustic7 = new GuitarEntity("Yamaha FG850 NT", 1570.0, 2,"Yamaha FG850 NT Gitara akustyczna, wykonana według najlepszych zasad sztuki lutniczej. Dobór materiałów, walory manualne, wysokiej jakości, doskonałe brzmienie",acoustic);
        GuitarEntity acoustic8 = new GuitarEntity("Alvarez AD 60 N", 1399.0, 2,"Alvarez AD 60 N Piękna gitara akustyczna marki Alvarez słynącej z tradycji ręcznego wytwarzania instrumentów, świetnie dobranego drewna i precyzji wykonania",acoustic);
        GuitarEntity acoustic9 = new GuitarEntity("Cort AD810 12 OP", 489.0, 2,"Cort AD810 12 OP Doskonała 12-strunowa gitara akustyczna wykonana z najwyższej jakości drewna. Zapewnia ciepłe i przejrzyste brzmienie",acoustic);
        GuitarEntity acoustic10 = new GuitarEntity("Dowina Marus GA-S", 529.0, 2,"Dowina Marus GA-S Świetny instrument akustyczny o solidnej, litej płycie wierzchnej z litego świerku. Marus GA gwarantuje mocne i wyraźne brzmienie",acoustic);

        // Basowe
        GuitarEntity bass1 = new GuitarEntity("Epiphone Thunderbird IV VS", 1299.0,2,"Epiphone Thunderbird IV, Thunderbird to jeden z najbardziej kultowych instrumentów wymyślonych przez konstruktorów firmy Gibson", bass);
        GuitarEntity bass2 = new GuitarEntity("Cort GB14 PJ 2T", 699.0,2,"Cort GB14 PJ 2T Bardzo dobra gitara basowa w wyjątkowo niskiej cenie. Idealna dla początkujących jak i osób, które szukają niezawodnego instrumentu", bass);
        GuitarEntity bass3 = new GuitarEntity("Marcus Miller M7 Alder-4", 1699.0,2,"Marcus Miller M7 Alder-4 TBL Genialne gitary basowe zbudowane w ścisłej współpracy z legendą muzyki-Marcusem Millerem", bass);
        GuitarEntity bass4 = new GuitarEntity("Mayones BE 4", 4599.0,2,"Mayones BE 4 Gitara Basowa od polskiego producenta-marki Mayones. Instrument wykonany jest z egzotycznego drewna dającego ciepłą barwę i wyposażony został w przystawki MEC", bass);
        GuitarEntity bass5 = new GuitarEntity("Squier Affinity PJ Bass BSB", 1200L,2,"Squier Affinity PJ Bass BSB Gitara basowa o uniwersalnej konfiguracji pickupów Precision+Jazz nadających się do każdego stylu muzyki", bass);
        GuitarEntity bass6 = new GuitarEntity("Yamaha TRBX604FM TBK", 2499.0,2,"Yamaha TRBX604FM TBK Nowa gitara basowa z serii TRBX charakteryzuje się świetnym brzmieniem, komfortem gry i boutiqowym wyglądem", bass);
        GuitarEntity bass7 = new GuitarEntity("Cort Action Bass PJ OPB", 579.0,2,"Cort Action Bass PJ OPB Basówki marki cort to gwarancja porządnego wykonania każdego jednego egzemplarza oraz dość dużej wygody gry", bass);
        GuitarEntity bass8 = new GuitarEntity("Cort C4 Plus ZBMH OTAB", 1285.0,2,"Cort C4 Plus ZBMH OTAB 4-strunowa gitara basowa marki Cort. Model z serii Artisan został zbudowany z najwyzszej jakości materiałów", bass);
        GuitarEntity bass9 = new GuitarEntity("ESP LTD B-10KIT BLKS", 899.0,2,"ESP LTD B-10 BLS Gitary basowe ESP produkowane w Tokio to najlepszy wybór dla muzyków, którzy nie akceptują kompromisów", bass);
        GuitarEntity bass10 = new GuitarEntity("Fender Player Jazz Bass", 3089L,2,"Fender Player Jazz Bass MN PWT Najnowsze jazzbasy z serii Player to doskonała jakość wykonania oraz gwarancja satysfakcji i niezawodności", bass);

        em.persist(electric1);
        em.persist(electric2);
        em.persist(electric3);
        em.persist(electric4);
        em.persist(electric5);
        em.persist(electric6);
        em.persist(electric7);
        em.persist(electric8);
        em.persist(electric9);
        em.persist(electric10);

        em.persist(classic1);
        em.persist(classic2);
        em.persist(classic3);
        em.persist(classic4);
        em.persist(classic5);
        em.persist(classic6);
        em.persist(classic7);
        em.persist(classic8);
        em.persist(classic9);
        em.persist(classic10);

        em.persist(acoustic1);
        em.persist(acoustic2);
        em.persist(acoustic3);
        em.persist(acoustic4);
        em.persist(acoustic5);
        em.persist(acoustic6);
        em.persist(acoustic7);
        em.persist(acoustic8);
        em.persist(acoustic9);
        em.persist(acoustic10);

        em.persist(bass1);
        em.persist(bass2);
        em.persist(bass3);
        em.persist(bass4);
        em.persist(bass5);
        em.persist(bass6);
        em.persist(bass7);
        em.persist(bass8);
        em.persist(bass9);
        em.persist(bass10);

        UserEntity baska = new UserEntity("Baska","bas123","BassQwe@Lorem.ipsum");
        UserEntity ania = new UserEntity("Ania","ania123","AnkA1912@Lorem.ipsum");
        UserEntity zoska = new UserEntity("Zoska","Zos123","ZosKaka@Lorem.ipsum");

        em.persist(baska);
        em.persist(ania);
        em.persist(zoska);

        UserEntity admin = new UserEntity("admin","Q9jC23AdgkxI2zA#@0ix","Grzegorz@Lorem.ipsum");

        em.persist(admin);
    }
}