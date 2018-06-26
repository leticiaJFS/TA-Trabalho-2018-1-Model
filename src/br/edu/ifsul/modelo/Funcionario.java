/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Leticia-PC
 */
@Entity
@Table(name="funcionario")
public class Funcionario implements Serializable{
    
    @Id
    @SequenceGenerator(name="seq_funcionario", sequenceName = "seq_funcionario_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_funcionario",strategy = GenerationType.SEQUENCE)    
    private Integer id;
    @NotBlank(message = "O nome não pode ser em branco.")
    @NotNull(message = "O nome não pode ser nulo.")
    @Length(max = 40, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 40, nullable = false)
    private String nome;
    @Column(name="loja", nullable = false)
    private Integer loja;
    @NotBlank(message = "A função não pode ser em branca.")
    @NotNull(message = "A função não pode ser nula.")
    @Length(max = 40, message = "A função não pode ter mais que {max} caracteres.")
    private String funcao;
    @NotBlank(message = "O login não pode ser em branco.")
    @NotNull(message = "O login não pode ser nulo.")
    @Length(max = 20, message = "O login não pode ter mais que {max} caracteres")
    @Column(name = "login", length = 20, nullable = false, unique=true)
    private String login;
    @NotBlank(message = "A password não pode ser em branca.")
    @NotNull(message = "A password não pode ser nula.")
    @Length(max = 40, message = "A password não pode ter mais que {max} caracteres")
    @Column(name = "password", length = 40, nullable = false)
    private String password;
    @ManyToMany
    @JoinTable(name = "liberacoes", 
            joinColumns 
            = @JoinColumn(name="funcionario", referencedColumnName="login", nullable=false),
            inverseJoinColumns
            = @JoinColumn (name="liberacao", referencedColumnName="identificacao", nullable=false),
            uniqueConstraints = {@UniqueConstraint(name="UK_liberacoes", columnNames={"funcionario","liberacao"})})
   private List<Liberacao> liberacoes = new ArrayList<>();
    
    
    public Funcionario(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getLoja() {
        return loja;
    }

    public void setLoja(Integer loja) {
        this.loja = loja;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Liberacao> getLiberacoes() {
        return liberacoes;
    }

    public void setLiberacoes(List<Liberacao> liberacoes) {
        this.liberacoes = liberacoes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionario other = (Funcionario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
