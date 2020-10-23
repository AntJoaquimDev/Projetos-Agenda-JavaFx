package agendaModel;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "contato")
public class Contato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id",nullable = false)
    private long id;

    @Column(name = "descricao", length = 100,nullable = false)
    private String descricao;

    @Column(name = "endereco", length = 100,nullable = false)
    private String endereco;

    @Column(name = "numResidencia", length = 4,nullable = false)
    private int numero ;

    @OneToOne
    private Cidade cidade;
    @OneToOne
    private TipoContato tipoContato;

    @Column(name = "email", length = 50,nullable = false)
    private String email;

    @Column(name = "ativo")
    private boolean ativo;

    @Column(name = "sexo", length = 2,nullable = false)
    private String sexo;

    @Column(name = "nascimento", length = 100,nullable = false)
    private LocalDate nascimento;

    @Column(name = "telefone1", length = 11,nullable = true)
    private long telefone1;

    @Column(name = "telefone2", length = 11,nullable = false)
    private long telefone2;


    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public TipoContato getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(TipoContato tipoContato) {
        this.tipoContato = tipoContato;
    }



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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public long getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(long telefone1) {
        this.telefone1 = telefone1;
    }

    public long getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(long telefone2) {
        this.telefone2 = telefone2;
    }


}
