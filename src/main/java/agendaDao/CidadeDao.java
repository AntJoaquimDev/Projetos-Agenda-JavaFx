package agendaDao;

import agendaModel.Contato;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class CidadeDao {

    public static boolean liberarExlcusao(long id){
        List<Contato> lista = new ArrayList();
        Session session = ConexaoBanco.getSessionFcatory().openSession();
        session.beginTransaction();
        lista = session.createQuery("from Contato where cidade_id = "+id).getResultList();
        session.getTransaction().commit();
        session.close();
        if(lista.isEmpty()){
            return true;
        }

        return  false;
    }
}
