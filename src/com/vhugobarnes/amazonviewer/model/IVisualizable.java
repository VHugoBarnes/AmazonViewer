package com.vhugobarnes.amazonviewer.model;

import java.util.Date;

/**
 * <h1>IVisualizable</h1>
 * <p>La interfaz contiene los 2 comportamientos base de visualización:</p>
 * <p>
 *     -Empezar a ver. <br>
 *     -Dejar de ver.
 * </p>
 * @author VHugoBarnes
 * @since 2019
 * @version 1.1
 * */

public interface IVisualizable {
	/**
	 * <p>
	 *     Éste método captura el tiempo exacto de inicio de vizualización.
	 * </p>
	 * @param dateI es un objeto {@code Date} con el tiempo de inicio exacto.
	 * @return Devuelve la fecha y hora capturada
	 * */
	Date startToSee(Date dateI);

	/**
	 * <p>
	 *     Éste método captura el tiempo exacto finalización de visualización.
	 * </p>
	 * @param dateI es un objeto {@code Date} con el tiempo de inicio exacto.
	 * @param dateF es un objeto {@code Date} con el tiempo final exacto.
	 * */
	void stopToSee(Date dateI, Date dateF);
	
}
