package agendaDao;

import agendaModel.Usuario;
import org.hibernate.Session;

public class UsuarioDao {

    public void salvar(Usuario tipo){
        try {
            Session session = ConexaoDao.getSessionFcatory().openSession();
            session.beginTransaction(); //iniciar transaçao
            session.merge(tipo); //pegar os dados do form
            session.getTransaction().commit(); //gravar no banco
            session.close(); //encerrar conexao
            System.out.println("dados cadastrado com sucesso");

        }catch (Exception e){
            System.out.println("Errro" + e);
        }
    }

}
