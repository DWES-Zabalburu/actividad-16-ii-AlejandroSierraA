/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.gestioneventos.servicio;

import java.util.GregorianCalendar;
import java.util.List;
import org.zabalburu.daw1.gestioneventos.DAO.EventoList;
import org.zabalburu.daw1.gestioneventos.DAO.EventosDAO;
import org.zabalburu.daw1.gestioneventos.DAO.PersonaMatriz;
import org.zabalburu.daw1.gestioneventos.DAO.personasDAO;
import org.zabalburu.daw1.gestioneventos.LoginException;
import org.zabalburu.daw1.gestioneventos.modelo.Eventos;
import org.zabalburu.daw1.gestioneventos.modelo.Personas;

/**
 *
 * @author DAW1
 */
public class EventosServicio {
    private personasDAO personasDao = new PersonaMatriz();
    private EventosDAO eventosDao = new EventoList();
    
    public EventosServicio(){
        personasDao.añadirPersonas(new Personas("Juan","Lopez","12345678A","juan",new GregorianCalendar(1990,2,1).getTime()));
        personasDao.añadirPersonas(new Personas("Ana","Marin","12345678B","ana",new GregorianCalendar(1993,7,19).getTime()));
        personasDao.añadirPersonas(new Personas("Carlos","Lopez","12345678C","car", new GregorianCalendar(1990,1,15).getTime()));
        personasDao.añadirPersonas(new Personas("Eva","Lopez","12345678D","eva", new GregorianCalendar(1989,2,13).getTime()));
        personasDao.añadirPersonas(new Personas("Luisa","Lopez","12345678E","lui", new GregorianCalendar(1996,7,21).getTime()));
        personasDao.añadirPersonas(new Personas("Miguel","De Miguel","12345678F","mig", new GregorianCalendar(1978,2,18).getTime()));
        personasDao.añadirPersonas(new Personas("Sonia","Lucas","12345678G","sona", new GregorianCalendar(1990,5,19).getTime()));
        eventosDao.añadirEvento(new Eventos("Evento Uno", new GregorianCalendar(2025,1,21).getTime(), "Bilbao", true, 50));
        eventosDao.añadirEvento(new Eventos("Evento Dos", new GregorianCalendar(2025,5,21).getTime(), "Barakaldo", false, 20));
        eventosDao.añadirEvento(new Eventos("Evento Tres", new GregorianCalendar(2025,11,5).getTime(), "Sesta", true, 30));
        eventosDao.añadirEvento(new Eventos("Evento Cuatro", new GregorianCalendar(2025,4,19).getTime(), "Bilbao", false, 40));
        this.apuntarAEvento(2, 3);
        this.apuntarAEvento(3, 2);
        this.apuntarAEvento(4, 1);
    }
    
    public Eventos añadirEvento(Eventos nuevo){
        return eventosDao.añadirEvento(nuevo);
    }
    public void eliminarEvento(int id){
        eventosDao.eliminarEvento(id);
    }
    public void modificarEvento(Eventos nuevo){
        eventosDao.modificarEvento(nuevo);
    }
    public List<Eventos> getEventos(){
        return eventosDao.getEventos();
    }
    public Eventos getEvento(int id){
        return eventosDao.getEvento(id);
    }
    public Personas añadirPersonas(Personas nueva){
        return personasDao.añadirPersonas(nueva);
    }
    public void eliminarPersona(int id){
        personasDao.eliminarPersona(id);
    }
    public void modificarPersona(Personas modificar){
        personasDao.modificarPersona(modificar);
    }
    public List<Personas> getPersonas(){
        return personasDao.getPersonas();
    }
    public Personas getPersona(int id){
        return personasDao.getPersona(id);
    }
    public Personas login(String dni, String password)throws LoginException{
        Personas p = personasDao.getPersonas(dni);
        if(p != null && password.equals(p.getPassword())){
            return p;
        }
        throw new LoginException();
    }
    public boolean apuntarAEvento(int idPersona,int idEvento){
        Personas p = personasDao.getPersona(idPersona);
        Eventos e = eventosDao.getEvento(idEvento);
        if(p != null && e != null){
            e.getAsistentes().add(p);
            p.getEvento().add(e);
            return true;
        }
        return false;
    }
    public void desapuntarAEvento(int idPersona, int idEvento){
        Personas p = personasDao.getPersona(idPersona);
        Eventos e = eventosDao.getEvento(idEvento);
        if(e != null && p != null){
        e.getAsistentes().remove(p);
        p.getEvento().remove(e);
        }
    }
    public static void main(String[] args) {
        EventosServicio servicio = new EventosServicio();
        for(Personas p : servicio.getPersonas()){
            System.out.println(p);
        }
        for(Eventos e : servicio.getEventos()){
            System.out.println(e);
        }
    }
}
