package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Leticia-PC
 */
@Entity
@Table(name = "liberacao")
public class Liberacao implements Serializable{
    @Id
    @NotBlank(message = "A identificacao não pode ser em branco.")
    @NotNull(message = "A identificacao não pode ser nulo.")
    @Length(max = 40, message = "A identificacao não pode ter mais que {max} caracteres")
    @Column(name = "identificacao", length = 40, nullable = false)
    private String identificacao;
    @NotBlank(message = "A definicao não pode ser em branco.")
    @NotNull(message = "A definicao não pode ser nulo.")
    @Length(max = 60, message = "A definicao não pode ter mais que {max} caracteres")
    @Column(name = "definicao", length = 60, nullable = false)
    private String definicao;
   
    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getDefinicao() {
        return definicao;
    }

    public void setDefinicao(String definicao) {
        this.definicao = definicao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.identificacao);
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
        final Liberacao other = (Liberacao) obj;
        if (!Objects.equals(this.identificacao, other.identificacao)) {
            return false;
        }
        return true;
    }
    
    
    
}
