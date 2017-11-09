/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.*;

import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/*
 @author LabHiber
 */
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
//        createOsoby();
//        createPracownicy();
//        showOsoby();
//        showAll();
    }

    /**
     * Tworzy obiekty klasy model.Osoba, które nie są pracownikami ani dziećmi
     */
//    private static void createOsoby() {
//
//        try (Session session = SESSION_FACTORY.openSession()) {
//            Transaction tx = session.beginTransaction();
//            model.Osoba o1 = new model.Osoba("Jan", "Kowalski", new GregorianCalendar(1973, 11, 1));
//            session.save(o1);
//            model.Osoba o2 = new model.Osoba("Tomasz", "Barański", new GregorianCalendar(1980, 10, 13));
//            session.save(o2);
//            tx.commit();
//        }
//    }

    /**
     * Tworzy obiekty testowej bazy danych
     */
//    private static void createPracownicy() {
//        try (Session session = SESSION_FACTORY.openSession()) {
//            Transaction tx = session.beginTransaction();
//            Pracownik p1 = new Pracownik("Teodor", "Wolny", new GregorianCalendar(1973, 11, 1));
//            p1.setStanowisko("programista");
//
//            model.Adres adres1 = new model.Adres("44-100", "Gliwice", "Wesola", "12A", "3");
//            p1.setAdres(adres1);
//            HashSet<Dziecko> dzieci1 = new HashSet<>(2);
//            createDziecko(adres1, "Roman", "Wolny",
//                    new GregorianCalendar(2005, 1, 1), dzieci1);
//            createDziecko(adres1, "Maciej", "Wolny",
//                    new GregorianCalendar(2005, 1, 1), dzieci1);
//            p1.setDzieci(dzieci1);
//            session.save(p1);
//            Pracownik p2 = new Pracownik("Zbigniew", "Nowak", new GregorianCalendar(1968, 10, 13));
//            p2.setStanowisko("starszy programista");
//            model.Adres adres2 = new model.Adres("44-100", "Gliwice", "Ogrodowa", "5", "");
//            HashSet<Dziecko> dzieci2 = new HashSet<>(1);
//            createDziecko(adres2, "Agata", "Barańska",
//                    new GregorianCalendar(2010, 5, 20), dzieci2);
//            p2.setAdres(adres2);
//            p2.setDzieci(dzieci2);
//            session.save(p2);
//            Pracownik p3 = new Pracownik("Maria", "Orzech", new GregorianCalendar(1980, 10, 10));
//            p3.setStanowisko("analityk");
//            model.Adres adres3 = new model.Adres("44-100", "Gliwice", "Winna", "7", "10");
//            p3.setAdres(adres3);
//            session.save(p3);
//            //projekty
//            Projekt pr1 = new Projekt("LabIOR", new GregorianCalendar(2011, 3, 16),
//                    new GregorianCalendar(2011, 5, 8));
//            Projekt pr2 = new Projekt("ADA", new GregorianCalendar(2011, 1, 16),
//                    new GregorianCalendar(2012, 6, 8));
//            Projekt pr3 = new Projekt("XML", new GregorianCalendar(2010, 3, 16),
//                    new GregorianCalendar(2011, 11, 12));
//            Projekt pr4 = new Projekt("ANN", new GregorianCalendar(2011, 6, 10),
//                    new GregorianCalendar(2013, 6, 8));
//            HashSet<Projekt> zbpr1 = new HashSet<>();
//            HashSet<Projekt> zbpr2 = new HashSet<>();
//            HashSet<Projekt> zbpr3 = new HashSet<>();
//            //przypisanie projektów do pracowników
//            zbpr1.add(pr1);
//            zbpr2.add(pr3);
//            zbpr2.add(pr4);
//            zbpr3.add(pr1);
//            zbpr3.add(pr2);
//            zbpr3.add(pr4);
//            p1.setProjekty(zbpr1);
//            p2.setProjekty(zbpr2);
//            p3.setProjekty(zbpr3);
            //przypisnie pracowników do projektów
//            HashSet<Pracownik> zbpc1 = new HashSet<>(2);
//            zbpc1.add(p1);
//            zbpc1.add(p3);
//            HashSet<Pracownik> zbpc2 = new HashSet<>(1);
//            zbpc2.add(p3);
//            HashSet<Pracownik> zbpc3 = new HashSet<>(1);
//            zbpc3.add(p2);
//            HashSet<Pracownik> zbpc4 = new HashSet<>(2);
//            zbpc4.add(p2);
//            zbpc4.add(p3);
//            pr1.setPracownicy(zbpc1);
//            pr2.setPracownicy(zbpc2);
//            pr3.setPracownicy(zbpc3);
//            pr4.setPracownicy(zbpc4);
            //tworzenie działów
//            Dzial d1 = new Dzial("Programowanie");
//            Dzial d2 = new Dzial("Analiza");
//            Dzial d3 = new Dzial("Finanse");
//            //pracownicy finansów
//            Pracownik p4 = new Pracownik("Olga", "Birkut", new GregorianCalendar(1960, 3, 10));
//            p4.setStanowisko("główna księgowa");
//            model.Adres adres4 = new model.Adres("44-109", "Gliwice", "Rolżana", "5", "");
//            session.save(p4);
//            p4.setAdres(adres4);
//            Pracownik p5 = new Pracownik("Ryszard", "Kiepura", new GregorianCalendar(1980, 10, 10));
//            p5.setStanowisko("referent");
//            model.Adres adres5 = new model.Adres("44-100", "Gliwice", "Dworcowa", "12", "10");
//            session.save(p5);
//            p5.setAdres(adres5);
//            Pracownik p6 = new Pracownik("Alina", "Bryka", new GregorianCalendar(1979, 5, 15));
//            p6.setStanowisko("referent");
//            model.Adres adres6 = new model.Adres("44-100", "Gliwice", "Bajkowa", "10A", "");
//            session.save(p6);
//            p6.setAdres(adres6);
//            //przypisanie pracownikom działów
//            //finanse
//            p4.setDzial(d3);
//            p5.setDzial(d3);
//            p6.setDzial(d3);
//            //analiza
//            p3.setDzial(d2);
//            //programowanie
//            p2.setDzial(d1);
//            p1.setDzial(d1);
            //przypisanie pracownikow do działów
//            HashSet<Pracownik> zbd1 = new HashSet<>(2);
//            zbd1.add(p1);
//            zbd1.add(p2);
//            d1.setPracownicy(zbd1);
//            HashSet<Pracownik> zbd2 = new HashSet<>(1);
//            zbd2.add(p3);
//            d2.setPracownicy(zbd2);
//            HashSet<Pracownik> zbd3 = new HashSet<>(3);
//            zbd3.add(p4);
//            zbd3.add(p5);
//            zbd3.add(p6);
//            d3.setPracownicy(zbd3);
            //tworzenie kierowników
//            Kierownik k1 = new Kierownik("Adam", "Borek", new GregorianCalendar(1969, 5, 15));
//            k1.setStanowisko("kierownik");
//            model.Adres adres7 = new model.Adres("44-105", "Gliwice", "Orzechowa", "1", "");
//            k1.setAdres(adres7);
//            k1.setDodatek(0.2);
//            session.save(k1);
//            Kierownik k2 = new Kierownik("Irena", "Dukaj", new GregorianCalendar(1972, 11, 1));
//            k2.setStanowisko("kierownik");
//            model.Adres adres8 = new model.Adres("44-100", "Gliwice", "Bielska", "1", "12");
//            k2.setAdres(adres8);
//            k2.setDodatek(0.1);
//            session.save(k2);
//            Kierownik k3 = new Kierownik("Igor", "Berber", new GregorianCalendar(1965, 7, 12));
//            k3.setStanowisko("kierownik");
//            model.Adres adres9 = new model.Adres("44-105", "Gliwice", "Jabloni", "7", "");
//            k3.setAdres(adres9);
//            k3.setDodatek(0.15);
//            session.save(k3);
//            //przypisanie kierownikom działów
//            k1.setDzial(d1);
//            k2.setDzial(d2);
//            k3.setDzial(d3);
//            //przypisanie działom kierowników
//            d1.setKierownik(k1);
//            d2.setKierownik(k2);
//            d3.setKierownik(k3);
//            tx.commit();
//        }
//
//    }

    /**
     * tworzy obiekty klasy Dziecko i dodaje je do listy dzieci
     *
     * @param adres
     * @param imie
     * @param nazwisko
     * @param dataUr
     * @param dzieci
     */
//    private static void createDziecko(model.Adres adres, String imie,
//                                      String nazwisko, GregorianCalendar dataUr,
//                                      HashSet<Dziecko> dzieci) {
//        Dziecko d = new Dziecko(imie, nazwisko, dataUr);
//        d.setAdres(adres);
//        dzieci.add(d);
//    }
//
//    private static void showOsoby() {
//        try (Session session = SESSION_FACTORY.openSession()) {
//            Query query = session.createQuery("from model.Osoba");
//            List<model.Osoba> osoby = query.list();
//            osoby.stream().forEach((osoba) -> {
//                System.out.println(osoba.getImie() + " " + osoba.getNazwisko()
//                        + " " + osoba.getWiek());
//            });
//            Criteria crit = session.createCriteria(Projekt.class);
//            List pr = crit.list();
//            System.out.println(pr.toString());
//        }
//
//    }
//    private static void showAll() {
//        try (Session session = SESSION_FACTORY.openSession()) {
//            Query query = session.createQuery("from java.lang.Object");
//            query.setComment("All objects list");
//            List<Object> all = query.list();
//            all.forEach(System.out::println);
//        }
//    }
}

