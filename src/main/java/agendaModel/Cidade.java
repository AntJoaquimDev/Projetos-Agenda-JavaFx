package agendaModel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="cidade")
public class Cidade implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id",nullable = false)
    private long id;

    @Column(name = "descricao", length = 100,nullable = false)
    private String descricao;

    @Column(name = "uf",length = 3, nullable = false)
    private String uf;

    @Column(name = "cep",length = 8,nullable = false)
    private String cep;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return descricao ;
    }
}
