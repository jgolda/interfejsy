package app;

import model.Osoba;
import model.Usluga;
import model.Wizyta;

import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.*;


public final class MainAppJPA {

    private final static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("labPU");

    public static void main(String[] args) {
        zap01JPQL();
        zap01Criteria();
        zap02JPQL();
        zap02Criteria();
        zap03JPQL();
        zap03Criteria();
    }

    private static void zap01JPQL() {
        EntityManager em = FACTORY.createEntityManager();
        List<String> resultList = em.createQuery(
                "select o.imie " +
                   "from Osoba o " +
                   "where o.nazwisko = :nazwisko", String.class)
                .setParameter("nazwisko", "skowronek")
                .getResultList();
        em.close();
        System.out.println("\nwyniki:");
        resultList.forEach(System.out::println);
    }

    private static void zap02JPQL() {
        EntityManager em = FACTORY.createEntityManager();
        List<Wizyta> results = em.createQuery(
                "select w " +
                   "from Wizyta w " +
                   "where size(w.uslugi) > :cnt", Wizyta.class)
                .setParameter("cnt", 2)
                .getResultList();
        em.close();
        results.forEach(System.out::println);
    }

    private static void zap03JPQL() {
        EntityManager em = FACTORY.createEntityManager();
        List<Tuple> results = em.createQuery(
                "select " +
                        "u.wizyta.id as WIZ_ID, " +
                        "sum(u.cena) as SUMA " +
                   "from Usluga u " +
                   "group by u.wizyta.id " +
                   "having sum(u.cena) > :suma", Tuple.class)
                .setParameter("suma", 1000.0)
                .getResultList();
        em.close();
        results.stream()
                .map(tuple -> tuple.get("WIZ_ID") + ": " + tuple.get("SUMA"))
                .forEach(System.out::println);
    }

    private static void zap01Criteria() {
        EntityManager em = FACTORY.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<String> criteriaQuery = builder.createQuery(String.class);
        Root<Osoba> root = criteriaQuery.from(Osoba.class);
        ParameterExpression<String> nazwisko = builder.parameter(String.class);
        criteriaQuery
                .select(root.get("imie"))
                .where(builder.equal(root.get("nazwisko"), nazwisko));

        List<String> resultList = em.createQuery(criteriaQuery)
                .setParameter(nazwisko, "skowronek")
                .getResultList();
        em.close();
        System.out.println("\nwyniki:");
        resultList.forEach(System.out::println);
    }

    private static void zap02Criteria() {
        EntityManager em = FACTORY.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Wizyta> criteriaQuery = builder.createQuery(Wizyta.class);
        Root<Wizyta> root = criteriaQuery.from(Wizyta.class);
        ParameterExpression<Integer> count = builder.parameter(Integer.class);
        criteriaQuery
                .select(root)
                .where(builder.ge(builder.size(root.get("uslugi")), count));

        List<Wizyta> resultList = em.createQuery(criteriaQuery)
                .setParameter(count, 2)
                .getResultList();

        em.close();
        System.out.println("\nwyniki:");
        resultList.forEach(System.out::println);
    }

    private static void zap03Criteria() {
        EntityManager em = FACTORY.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Tuple> criteriaQuery = builder.createQuery(Tuple.class);
        Root<Usluga> root = criteriaQuery.from(Usluga.class);
        ParameterExpression<Double> sum = builder.parameter(Double.class);
        criteriaQuery
                .multiselect(root.get("wizyta").get("id"), builder.sum(root.get("cena")))
                .groupBy(root.get("wizyta").get("id"))
                .having(builder.ge(builder.sum(root.get("cena")), sum));

        List<Tuple> resultList = em.createQuery(criteriaQuery)
                .setParameter(sum, 1000.0)
                .getResultList();

        em.close();
        System.out.println("\nwyniki:");
        resultList.stream()
                .map(tuple -> tuple.get(0) + ": " + tuple.get(1))
                .forEach(System.out::println);
    }

    public static void showAllEmployees() {
        EntityManager em = FACTORY.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
//        CriteriaQuery criteria = builder.createQuery(Pracownik.class);
//        Root<Pracownik> root = criteria.from(Pracownik.class);
//        criteria.select(root);
//        List<Pracownik> result = em.createQuery(criteria).getResultList();
//        result.forEach(System.out::println);
//        em.close();
    }

}

