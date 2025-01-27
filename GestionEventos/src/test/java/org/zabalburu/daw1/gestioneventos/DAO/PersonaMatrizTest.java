/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.zabalburu.daw1.gestioneventos.DAO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.zabalburu.daw1.gestioneventos.modelo.Personas;

/**
 *
 * @author DAW1
 */
public class PersonaMatrizTest {
    
    private PersonaMatriz dao = new PersonaMatriz();
    
    public PersonaMatrizTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        dao.limpiarDatos();
                
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of añadirPersonas method, of class PersonaMatriz.
     */
    @Test
    public void testAñadirPersonas() {
        Personas p = new Personas("Juan", "Lopez", "12345678A","jlopez",null);
        dao.añadirPersonas(p);
        assertEquals(dao.getPersonas().size(),1);
        Personas p2 = new Personas("Ana", "Lopez", "12345678A","alopez",null);
        dao.añadirPersonas(p2);
        assertEquals(dao.getPersonas().size(), 1);
        assertEquals(dao.getPersonas().get(0 ), p2);
    }

    /**
     * Test of eliminarPersona method, of class PersonaMatriz.
     */
    @Test
    public void testEliminarPersona() {
        Personas p = new Personas("Juan", "Lopez", "12345678A","jlopez",null);
        dao.añadirPersonas(p);
        assertEquals(dao.getPersonas().size(),1);
        Personas p2 = new Personas("Ana", "Lopez", "12345678A","alopez",null);
        dao.eliminarPersona(1);
        assertEquals(dao.getPersonas().size(), 1);
        assertEquals(dao.getPersonas().get(0), p2);
    }

    /**
     * Test of modificarPersona method, of class PersonaMatriz.
     */
    @Test
    public void testModificarPersona() {
        Personas p = new Personas("Juan", "Lopez", "12345678A","jlopez",null);
        dao.añadirPersonas(p);
        assertEquals(dao.getPersonas().size(),1);
        Personas nueva = new Personas("Ana", "Lopez", "12345678A","alopez",null);
        nueva.setIdPersona(1);
        assertEquals(dao.getPersonas().size(), 1);
        assertEquals(dao.getPersonas().get(0), nueva);
    }

    /**
     * Test of getPersonas method, of class PersonaMatriz.
     */
    @Test
    public void testGetPersonas_0args() {
    }

    /**
     * Test of getPersona method, of class PersonaMatriz.
     */
    @Test
    public void testGetPersona() {
    }

    /**
     * Test of getPersonas method, of class PersonaMatriz.
     */
    @Test
    public void testGetPersonas_String() {
    }
    
}
