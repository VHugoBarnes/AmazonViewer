package com.vhugobarnes.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * <h1>Book</h1>
 * <p>
 *     La clase Book hereda de {@link Publication}
 *      implemente la interfaz {@link IVisualizable}
 * </p>
 * <p>
 *     Fue diseñada para mostrar contener los libros disponibles en la plataforma.
 * </p>
 * @author  VHugoBarnes
 * @version 1.1
 * @since 1.0
 * */
public class Book extends Publication implements IVisualizable {
	private int id;
	private String isbn;
	private boolean readed;
	private int timeReaded;
	
	
	public Book(String title, Date edititionDate, String editorial, String[] authors) {
		super(title, edititionDate, editorial);
		// TODO Auto-generated constructor stub
		setAuthors(authors);
	}

	/**
	 * Obtiene el ID del libro.
	 * */
	public int getId() {
		return id;
	}

	/**
	 * Obtiene el ISBN del libro.
	 * */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * Establece el ISBN del libro.
	 * */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * Método que verifica si el libro ya se leyó o no.
	 * @return {@code leido}
	 * */
	public String isReaded() {
		String leido = "";
		if(readed == true) {
			leido = "Sí";
		}else {
			leido = "No";
		}
		
		return leido;
	}

	/**
	 * Establece el estado del libro (Leído/No Leído).
	 * */
	public void setReaded(boolean readed) {
		this.readed = readed;
	}

	/**
	 * Devuelve un boolean con el valor de si está leído o no.
	 * */
	public boolean getIsReaded() {
		return readed;
	}

	/**
	 * Devuelve el tiempo leído.
	 * */
	public int getTimeReaded() {
		return timeReaded;
	}


	/**
	 * Establece el tiempo leído.
	 * */
	public void setTimeReaded(int timeReaded) {
		this.timeReaded = timeReaded;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String detailBook = "\n :: BOOK ::" + 
							"\n Title: " + getTitle() +
							"\n Editorial: " + getEditorial() + 
							"\n Edition Date: " + getEdititionDate() +
							"\n Authors: ";
		for (int i = 0; i < getAuthors().length; i++) {
			detailBook += "\t" + getAuthors()[i] + " ";
		}
		return  detailBook;
	}


	@Override
	public Date startToSee(Date dateI) {
		// TODO Auto-generated method stub
		return dateI;
	}


	@Override
	public void stopToSee(Date dateI, Date dateF) {
		// TODO Auto-generated method stub
		if (dateF.getTime() > dateI.getTime()) {
			setTimeReaded((int)(dateF.getTime() - dateI.getTime()));
		}else {
			setTimeReaded(0);
		}
	}

	//VIEW METHOD
	/**
	 * {@inheritDoc} Método donde se visualiza el libro.
	 * */
	public void view(){
		setReaded(true);
		Date dateI = startToSee(new Date());

		for (int i = 0; i < 100000; i++) {
			System.out.println("..........");
		}

		//Termine de verla
		stopToSee(dateI, new Date());
		System.out.println();
		System.out.println("Leíste: " + toString());
		System.out.println("Por: " + getTimeReaded() + " milisegundos");
	}

	/**
	 * Método que genera 5 libros y los guarda en una colección de datos.
	 * */
	public static ArrayList<Book> makeBookList() {
		ArrayList<Book> books = new ArrayList();
		String[] authors = new String[3];
		for (int i = 0; i < 3; i++) {
			authors[i] = "author "+i;
		}
		for (int i = 1; i <= 5; i++) {
			books.add(new Book("Book " + i, new Date(), "editorial " + i, authors));
		}
		
		return books;
	}
}
