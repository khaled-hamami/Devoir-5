package com.khaled.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.khaled.entities.VideoGames;
import com.khaled.util.JPAutil;

public class VideoGamesDAO {

	private EntityManager entityManager = JPAutil.getEntityManager("MonProjetJPA");

	public void ajouter(VideoGames vg) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(vg);
		tx.commit();
	}

	public void modifier(VideoGames vg) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(vg);
		tx.commit();
	}

	public void supprimer(VideoGames vg) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		vg = entityManager.merge(vg);
		entityManager.remove(vg);
		tx.commit();
	}

	public VideoGames consulter(VideoGames vg, Object id) {
		return entityManager.find(vg.getClass(), id);
	}

	public List<VideoGames> listerTous() {
		List<VideoGames> clients = entityManager.createQuery("select vg from VideoGames vg").getResultList();

		return clients;
	}

	public List<VideoGames> listerParNom(String nom) {
		List<VideoGames> clients = entityManager.createQuery("select vg from VideoGames vg where vg.nom like :pnom").setParameter("pnom", "%" + nom + "%").getResultList();

		return clients;
	}
}
