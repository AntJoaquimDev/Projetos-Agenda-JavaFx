package agendaDao;

import agendaModel.Contato;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class TipoContatoDao {
//tds os mtd migraram para class genericdao tdo processo de conexao sera feito pot la
    // aula 046  link  -> https://youtu.be/066fYrGD0Yw
    // para liberar a exlcusão de tipo contatos
    public static boolean liberarExlcusao(long id){
        List <Contato>lista = new ArrayList(); //aula 53
        Session session = ConexaoBanco.getSessionFcatory().openSession();
        session.beginTransaction();
        lista = session.createQuery("from Contato  where tipoContato_id = "+id).getResultList();
        session.getTransaction().commit();
        session.close();
        if(lista.isEmpty()){
            return true;
        }

        return  false;
    }

}



