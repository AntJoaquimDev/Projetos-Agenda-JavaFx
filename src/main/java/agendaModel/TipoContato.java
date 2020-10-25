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
    private String descricaoTipo;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricaoTipo() {
        return descricaoTipo;
    }

    public void setDescricaoTipo(String descricaoTipo) {
        this.descricaoTipo = descricaoTipo;
    }

    @Override // para listar dados na combox. controleTipo. A044
    public String toString() {
        return descricaoTipo ;
    }
}
