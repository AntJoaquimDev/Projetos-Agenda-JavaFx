package agendaDao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
// aula045 -> link  https://youtu.be/Oytzkopq49Y
public class ComboBoxGenericDao<TG> {

    private ObservableList<TG> obsList = FXCollections.observableArrayList();

    public ObservableList<TG> comboBox(String nomeClasse) {
        // carregar list de contatos no combox A044 buscar inf no bancoDD
        List<TG> lista = new ArrayList<>();
        Session session = ConexaoBanco.getSessionFcatory().openSession();
        session.beginTransaction();
        lista = session.createQuery("from "+ nomeClasse).getResultList();
        session.getTransaction().commit();
        session.close();

        for (TG tp : lista) { //forEach para percorrer a lista
            obsList.add(tp);
        }
        return obsList;
    }
}
