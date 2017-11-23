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
        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction tx = session.beginTransaction();
            Cennik cennik = new Cennik();
            cennik.setKwota(123.0);
            cennik.setOpis("opis kwoty");
            session.save(cennik);

            Adres lekarzAdres = new Adres();
            lekarzAdres.setKod("lekarz_kod");
            lekarzAdres.setMiejscowosc("zadupie dolne");
            lekarzAdres.setNrDomu(234);
            lekarzAdres.setNrMieszkania(345);
            lekarzAdres.setUlica("duga");
            session.save(lekarzAdres);

            Lekarz lekarz = new Lekarz();
            lekarz.setImie("grazyna");
            lekarz.setNazwisko("kowalska");
            lekarz.setSpecjalizacja("specka");
            lekarz.setTytulNauk("tytul naukowy");
            lekarz.setAdres(lekarzAdres);
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

            Usluga usluga = new Usluga();
            usluga.setCennik(cennik);
            usluga.setRabat(2.0);
            usluga.setCena(246.0);
            usluga.setOpis("naprawianie zebow XDDD");
            session.save(usluga);

            Wizyta wz = new Wizyta();
            wz.setZabiegi(new HashSet<>(Arrays.asList(latanie, wiercenie)));
            wz.setData(new Date());
            wz.setLekarz(lekarz);
            wz.setPacjent(pacjent);
            wz.setTyp("typ wizyty xD");
            wz.setUslugi(new HashSet<>(Collections.singletonList(usluga)));
            session.save(wz);
            tx.commit();
        }
        showAll();
    }

    private static void showAll() {
        try (Session session = SESSION_FACTORY.openSession()) {
            Query query = session.createQuery("from java.lang.Object");
            query.setComment("All objects list");
            List<Object> all = query.list();
            all.forEach(System.out::println);
        }
    }
}

