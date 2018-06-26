/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Funcionario;
import br.edu.ifsul.modelo.Liberacao;
import java.util.ArrayList;
import java.util.List;
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
public class TestePersistirFuncionario {
        EntityManagerFactory emf;
        EntityManager em;
    public TestePersistirFuncionario() {
       
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
            List<Liberacao> liberacoes = new ArrayList<>();
            Liberacao l = em.find(Liberacao.class, "SUPER"); 
            liberacoes.add(l);
            
            Funcionario f = new Funcionario();
            f.setNome("Leticia");
            f.setLogin("Leticia");
            f.setPassword("123456");
            f.setFuncao("Administrador");
            f.setLoja(100);            
            f.setLiberacoes(liberacoes);
           
            em.getTransaction().begin();
            em.persist(f);
            em.getTransaction().commit();
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        //verifico se não ocorreu exceção para passar no teste
        Assert.assertEquals(false, exception);
    }
    
}
