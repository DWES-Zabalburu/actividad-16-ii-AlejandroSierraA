/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.zabalburu.daw1.gestioneventos.DAO;

import java.util.List;
import org.zabalburu.daw1.gestioneventos.modelo.Personas;

/**
 *
 * @author DAW1
 */
public interface personasDAO {
    public Personas añadirPersonas(Personas nueva);
    public void eliminarPersona(int id);
    void modificarPersona(Personas modificar);
    List<Personas> getPersonas();
    Personas getPersona(int id);
    Personas getPersonas(String dni);
}
