/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Liberacao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Leticia-PC
 */
public class TestePersistirLiberacao {
        EntityManagerFactory emf;
        EntityManager em;
    public TestePersistirLiberacao() {
       
    }
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("TA-Trabalho-2018PU");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void teste(){
        boolean exception = false;
        try{
                                   
            Liberacao l = new Liberacao();            
            l.setIdentificacao("SUPER");
            l.setDefinicao("Liberação de super usuário.");
           
            em.getTransaction().begin();
            em.persist(l);
            em.getTransaction().commit();
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        //verifico se não ocorreu exceção para passar no teste
        Assert.assertEquals(false, exception);
    }
    
}
