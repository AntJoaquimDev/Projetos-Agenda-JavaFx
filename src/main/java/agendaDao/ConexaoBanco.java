package agendaDao;

import agendaModel.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConexaoBanco {

    private static SessionFactory conexao = null;
    private static Configuration configuracao;

    private static SessionFactory buildSessionFactory() {
        //-->Criar obj para armazenar as configuracao
        configuracao = new Configuration().configure();

        // config user e login para acessar o banco
        configuracao.setProperty("hibernate.connection.username", "root");
        configuracao.setProperty("hibernate.connection.password","");
        //---> Indicar o Mapeamento das classes
        configuracao.addPackage("agenda.agendaModel").addAnnotatedClass(TipoContato.class);
        configuracao.addPackage("agenda.agendaModel").addAnnotatedClass(Usuario.class);
        configuracao.addPackage("agenda.agendaModel").addAnnotatedClass(Cidade.class);
        configuracao.addPackage("agenda.agendaModel").addAnnotatedClass(Contato.class);


        // ---> sessionFactoty recebe a construcao da sessao com o banco de dados
        conexao = configuracao.buildSessionFactory();

        return conexao;
    }
    //para acessara fabrica de conecao o bild
    public static SessionFactory getSessionFcatory(){
        if (conexao == null){
            conexao = buildSessionFactory();

        }
        System.out.println("ok"+conexao);
        return conexao;
    }
}


