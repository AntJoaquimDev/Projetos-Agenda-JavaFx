package agendaModel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "tipo_Contato")
public class TipoContato implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name ="id",nullable = false)
   private long id;

   @Column (name ="descricao",length = 100,nullable = false)
    private String descricao;


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

    @Override // para listar dados na combox. controleTipo. A044
    public String toString() {
        return descricao ;
    }
}
