package br.com.lucasbdourado.dao;

import br.com.lucasbdourado.domain.Carro;
import br.com.lucasbdourado.domain.Marca;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class CarroDao implements ICarroDao{
    @Override
    public Carro create(Carro carro) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(carro);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return carro;
    }

    @Override
    public Marca queryMarca(Carro carro) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT m FROM Marca m");
        sb.append("INNER JOIN Carro c on m = c.marca");
        sb.append("WHERE c.id = :carroId");

        entityManager.getTransaction().begin();
        TypedQuery<Marca> query = entityManager.createQuery(sb.toString(), Marca.class);
        query.setParameter("carroId", carro.getId());
        Marca marca = query.getSingleResult();
        entityManager.close();
        entityManagerFactory.close();


        return marca;
    }


}
