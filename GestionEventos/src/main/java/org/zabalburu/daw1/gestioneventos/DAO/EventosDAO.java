/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.zabalburu.daw1.gestioneventos.DAO;

import java.util.List;
import org.zabalburu.daw1.gestioneventos.modelo.Eventos;

/**
 *
 * @author DAW1
 */
public interface EventosDAO {
    Eventos añadirEvento(Eventos nuevo);
    void eliminarEvento(int id);
    void modificarEvento(Eventos nuevo);
    List<Eventos> getEventos();
    Eventos getEvento(int id);
    
}
