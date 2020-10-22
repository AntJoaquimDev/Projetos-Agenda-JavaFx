package agendaDao;

import agendaModel.TipoContato;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class CrudGernecDao<T> { //CRUD generico

    public boolean salvar(T tipo) {
        // conectar e abrir uma conexao depois tem q feichar
        try {
            Session session = ConexaoDao.getSessionFcatory().openSession();
            session.beginTransaction(); //iniciar transaçao
            session.merge(tipo); //pegar os dados do form
            session.getTransaction().commit(); //gtavar no banco
            session.close(); //encerrar conexao
            return true;
        } catch (Exception erro) {
            System.out.println("Erro " + erro);
            //criar arquivo de logs
            return false;
        }

    }

    //buscar lista no banco e mostrar na tableview
    public List<T> consultar(String descricao, String nomeClasse) {

        List<T> lista = new ArrayList<>();
        Session session = ConexaoDao.getSessionFcatory().openSession();
        session.beginTransaction();

        // lista = session.createQuery("from TipoContato ").getResultList();
        // -> esse comando seria para retornar td da tabela tds os registros

        if (descricao.length() == 0) {
            lista = session.createQuery(" from " + nomeClasse).getResultList();
        } else {
            lista = session.createQuery(" from " + nomeClasse+" tm where  tm.descricao like "
                    + "'" + descricao + "%'").getResultList();
        }
        session.getTransaction().commit(); //gtavar no banco
        session.close(); //encerrar conexao

        return lista;
    }

    public void excluis(T tipo) {
        try {
            Session session = ConexaoDao.getSessionFcatory().openSession();
            session.beginTransaction();
            session.delete(tipo);
            session.getTransaction().commit();
            session.close();
        } catch (Exception erro) {
            System.out.println("Erro " + erro);
        }

    }
}
