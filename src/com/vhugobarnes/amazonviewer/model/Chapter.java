package com.vhugobarnes.amazonviewer.model;

import java.util.ArrayList;

/**
 * <h1>Capter</h1>
 * <p>
 *     Es una clase que hereda de {@link Movie}. Contiene los capitulos de una serie.
 * </p>
 * @author VHugoBarnes
 * @since 1.0
 * @version 1.1
 * */
public class Chapter extends Movie {
	
	
	private int id;
	private int sessionNumber;
	private Serie serie;

	public Chapter(String title, String genre, String creator, int duration, short year, int sessionNumber, Serie serie) {
		super(title, genre, creator, duration, year);
		// TODO Auto-generated constructor stub
		this.setSessionNumber(sessionNumber);
		this.setSerie(serie);
	}

	/**
	 * Método que obtiene el ID del capitulo.
	 * */
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	/**
	 * Obtiene el número de sesión.
	 * */
	public int getSessionNumber() {
		return sessionNumber;
	}

	/**
	 * Obtiene el número de sesión.
	 * */
	public void setSessionNumber(int sessionNumber) {
		this.sessionNumber = sessionNumber;
	}

	/**
	 *Obtiene la serie.
	 * */
	public Serie getSerie() {
		return serie;
	}

	/**
	 *Establece la serie.
	 * */
	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  "\n :: SERIE ::" + 
				"\n Title: " + getSerie().getTitle() +
				"\n :: CHAPTER ::" + 
				"\n Title: " + getTitle() +
				"\n Year: " + getYear() + 
				"\n Creator: " + getCreator() +
				"\n Duration: " + getDuration();
	}
	
	
	public static ArrayList<Chapter> makeChaptersList(Serie serie) {
		ArrayList<Chapter> chapters = new ArrayList();
		
		for (int i = 1; i <= 5; i++) {
			chapters.add(new Chapter("Capituo "+i, "genero "+i, "creator" +i, 45, (short)(2017+i), i, serie));
		}
		
		return chapters;
	}

	@Override
	public void view() {
		super.view();
		ArrayList <Chapter> chapters = getSerie().getChapters();
		int chapterViewedCounter = 0;

		for (Chapter chapter: chapters) {
			if(chapter.getIsViewed()){
				chapterViewedCounter++;
			}
		}

		if (chapterViewedCounter == chapters.size()){
			getSerie().view();
		}
			
	}
}
