/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.gestioneventos.DAO;

import java.util.ArrayList;
import java.util.List;
import org.zabalburu.daw1.gestioneventos.modelo.Eventos;

/**
 *
 * @author DAW1
 */
public class EventoList implements EventosDAO{

    private static List<Eventos> evento = new ArrayList<>();
    
    @Override
    public Eventos añadirEvento(Eventos nuevo) {
        evento.add(nuevo);
        return nuevo;
    }

    @Override
    public void eliminarEvento(int id) {
        // Creamos un evento con el id a eliminar (funciona porque equals se basa en el id)
        Eventos e = new Eventos();
        e.setIdEvento(id);
        evento.remove(e);
    }

    @Override
    public void modificarEvento(Eventos nuevo) {
        //buscamos la posicion en base al id (equals) --> indexO
        int pos = evento.indexOf(nuevo);
        if(pos != -1){
            evento.set(pos, nuevo);
        }
    }

    @Override
    public List<Eventos> getEventos() {
        return evento;
    }

    @Override
    public Eventos getEvento(int id) {
         Eventos evt = new Eventos();
        evt.setIdEvento(id);
        int pos = evento.indexOf(evt);
        if(pos != -1){
            return evento.get(pos);
        }else{
            return null;
        }
    }
    
}
