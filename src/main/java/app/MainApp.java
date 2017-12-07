package app;

import java.util.*;

import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public final class MainApp {

    private static final SessionFactory SESSION_FACTORY = HiberUtil.getSessionFactory(HiberUtil.Mapping.XML);

    public static void main(String[] args) {
        try ( Session session = SESSION_FACTORY.openSession() ) {
            Transaction tx = session.beginTransaction();

            Adres lekarzAdres = new Adres();
            lekarzAdres.setKod("lekarz_kod");
            lekarzAdres.setMiejscowosc("zadupie dolne");
            lekarzAdres.setNrDomu(234);
            lekarzAdres.setNrMieszkania(345);
            lekarzAdres.setUlica("duga");
            session.save(lekarzAdres);

            Adres drugi = new Adres();
            drugi.setKod("drugi_kod");
            drugi.setMiejscowosc("zadupie dolne");
            drugi.setNrDomu(234);
            drugi.setNrMieszkania(345);
            drugi.setUlica("duga");
            session.save(drugi);

            Lekarz lekarz = new Lekarz();
            lekarz.setImie("grazyna");
            lekarz.setNazwisko("kowalska");
            lekarz.setSpecjalizacja("specka");
            lekarz.setTytulNauk("tytul naukowy");
            lekarz.setAdres(drugi);
            session.save(lekarz);

            Adres pacjentAdres = new Adres();
            pacjentAdres.setKod("pacjent_kod");
            pacjentAdres.setMiejscowosc("zadupie gorne");
            pacjentAdres.setNrDomu(987);
            pacjentAdres.setNrMieszkania(876);
            pacjentAdres.setUlica("krotka");
            session.save(pacjentAdres);

            Pacjent pacjent = new Pacjent();
            pacjent.setNrKartyUbezpieczeniowej("nr_karty");
            pacjent.setImie("marcin");
            pacjent.setNazwisko("skowronek");
            pacjent.setAdres(pacjentAdres);
            session.save(pacjent);

            Zabieg wiercenie = new Zabieg();
            wiercenie.setNrZeba("666");
            wiercenie.setOpis("wiercenie w zebie czarnym jak dupa szatana");
            session.save(wiercenie);

            Zabieg latanie = new Zabieg();
            latanie.setNrZeba("665");
            latanie.setOpis("Łatanie dziury w moście");
            session.save(latanie);

            Cennik cennik1 = new Cennik();
            cennik1.setKwota(1.0);
            cennik1.setOpis("kwota1");
            session.save(cennik1);

            Cennik cennik2 = new Cennik();
            cennik2.setKwota(2.0);
            cennik2.setOpis("kwota2");
            session.save(cennik2);

            Cennik cennik3 = new Cennik();
            cennik3.setKwota(3.0);
            cennik3.setOpis("kwota1");
            session.save(cennik3);

            Usluga usluga = new Usluga();
            usluga.setCennik(cennik1);
            usluga.setRabat(2.0);
            usluga.setCena(246.0);
            usluga.setOpis("naprawianie zebow XDDD");
            session.save(usluga);

            Usluga usluga2 = new Usluga();
            usluga2.setCennik(cennik2);
            usluga2.setRabat(2.0);
            usluga2.setCena(123.0);
            usluga2.setOpis("naprawianie zeba");
            session.save(usluga2);

            Usluga usluga3 = new Usluga();
            usluga3.setCennik(cennik3);
            usluga3.setRabat(2.0);
            usluga3.setCena(234.0);
            usluga3.setOpis("naprawianie zeba");
            session.save(usluga3);

            Usluga usluga4 = new Usluga();
            usluga4.setCennik(cennik1);
            usluga4.setRabat(2.0);
            usluga4.setCena(345.0);
            usluga4.setOpis("naprawianie zeba");
            session.save(usluga4);

            Usluga usluga5 = new Usluga();
            usluga5.setCennik(cennik2);
            usluga5.setRabat(2.0);
            usluga5.setCena(456.0);
            usluga5.setOpis("naprawianie zeba");
            session.save(usluga5);

            Usluga usluga6 = new Usluga();
            usluga6.setCennik(cennik3);
            usluga6.setRabat(2.0);
            usluga6.setCena(567.0);
            usluga6.setOpis("naprawianie zeba");
            session.save(usluga6);

            Usluga usluga7 = new Usluga();
            usluga7.setCennik(cennik1);
            usluga7.setRabat(2.0);
            usluga7.setCena(246.0);
            usluga7.setOpis("naprawianie zeba");
            session.save(usluga7);

            Usluga usluga8 = new Usluga();
            usluga8.setCennik(cennik2);
            usluga8.setRabat(2.0);
            usluga8.setCena(678.0);
            usluga8.setOpis("naprawianie zeba");
            session.save(usluga8);

            Wizyta wz = new Wizyta();
            wz.setZabiegi(new HashSet<>(Arrays.asList(latanie, wiercenie)));
            wz.setData(new Date());
            wz.setLekarz(lekarz);
            wz.setPacjent(pacjent);
            wz.setTyp("typ wizyty xD");
            wz.setUslugi(new HashSet<>(Arrays.asList(usluga, usluga4, usluga8)));
            session.save(wz);

            Wizyta wz2 = new Wizyta();
            wz2.setZabiegi(new HashSet<>(Arrays.asList(latanie, wiercenie)));
            wz2.setData(new Date());
            wz2.setLekarz(lekarz);
            wz2.setPacjent(pacjent);
            wz2.setTyp("typ wizyty xD");
            wz2.setUslugi(new HashSet<>(Arrays.asList(usluga2)));
            session.save(wz2);

            Wizyta wz3 = new Wizyta();
            wz3.setZabiegi(new HashSet<>(Arrays.asList(latanie, wiercenie)));
            wz3.setData(new Date());
            wz3.setLekarz(lekarz);
            wz3.setPacjent(pacjent);
            wz3.setTyp("typ wizyty xD");
            wz3.setUslugi(new HashSet<>(Arrays.asList(usluga3, usluga5, usluga6, usluga7)));
            session.save(wz3);
            tx.commit();
        }
        showAll();
    }

    private static void showAll() {
        try ( Session session = SESSION_FACTORY.openSession() ) {
            Query query = session.createQuery("from java.lang.Object");
            query.setComment("All objects list");
            List<Object> all = query.list();
            all.forEach(System.out::println);
        }
    }
}

