package com.khaled.test;

import com.khaled.dao.VideoGamesDAO;
import com.khaled.entities.VideoGames;

public class videoGamesTest {
	public static void main(String[] args) {

		VideoGames vg = new VideoGames();
		vg.setNom("GTA 6");
		vg.setPrespective("TPS");

		VideoGamesDAO vgDao = new VideoGamesDAO();
		vgDao.ajouter(vg);
		System.out.println("Appel de la méthode listerTous");
		for (VideoGames vg1 : vgDao.listerTous())
			System.out.println(vg1.getCode() + " " + vg1.getNom());
		System.out.println("Appel de la méthode listerParNom");
		for (VideoGames v1 : vgDao.listerParNom("nadh"))

			System.out.println(v1.getCode() + " " + v1.getNom());

		vgDao.supprimer(vg);
		vgDao.listerTous();
	}
}
