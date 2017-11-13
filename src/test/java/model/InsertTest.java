package model;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;

public class InsertTest {

    @Test
    public void testInitializeDB() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ior");

        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        Cennik cennik = new Cennik();
        cennik.setKwota(123.0);
        cennik.setOpis("opis kwoty");
        entityManager.persist(cennik);

        Adres lekarzAdres = new Adres();
        lekarzAdres.setKod("lekarz_kod");
        lekarzAdres.setMiejscowosc("zadupie dolne");
        lekarzAdres.setNrDomu(234);
        lekarzAdres.setNrMieszkania(345);
        lekarzAdres.setUlica("duga");

        Lekarz lekarz = new Lekarz();
        lekarz.setImie("grazyna");
        lekarz.setNazwisko("kowalska");
        lekarz.setSpecjalizacja("specka");
        lekarz.setTytulNauk("tytul naukowy");
        lekarz.setAdres(lekarzAdres);
        entityManager.persist(lekarz);

        Adres pacjentAdres = new Adres();
        pacjentAdres.setKod("pacjent_kod");
        pacjentAdres.setMiejscowosc("zadupie gorne");
        pacjentAdres.setNrDomu(987);
        pacjentAdres.setNrMieszkania(876);
        pacjentAdres.setUlica("krotka");

        Pacjent pacjent = new Pacjent();
        pacjent.setNrKartyUbezpieczeniowej("nr_karty");
        pacjent.setImie("marcin");
        pacjent.setNazwisko("skowronek");
        pacjent.setAdres(pacjentAdres);
        entityManager.persist(pacjent);

        Zabieg wiercenie = new Zabieg();
        wiercenie.setNrZeba("666");
        wiercenie.setOpis("wiercenie w zebie czarnym jak dupa szatana");

        Zabieg latanie = new Zabieg();
        latanie.setNrZeba("665");
        latanie.setOpis("Łatanie dziury w moście");

        Usluga usluga = new Usluga();
        usluga.setCennik(cennik);
        usluga.setRabat(2.0);
        usluga.setCena(246.0);
        usluga.setOpis("naprawianie zebow XDDD");

        Wizyta wz = new Wizyta();
        wz.setZabiegi(new HashSet<>(Arrays.asList(latanie, wiercenie)));
        wz.setData(new Date());
        wz.setLekarz(lekarz);
        lekarz.setWizyty(new HashSet<>(Collections.singletonList(wz)));
        wz.setPacjent(pacjent);
        wz.setTyp("typ wizyty xD");
        wz.setUslugi(new HashSet<>(Collections.singletonList(usluga)));
        entityManager.persist(wz);

        entityManager.getTransaction().commit();
        entityManager.close();
        emf.close();
    }
}
