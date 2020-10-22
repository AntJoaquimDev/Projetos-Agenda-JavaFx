package agendaUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UF {
    private  static ObservableList<String > obs0leList;
    public static ObservableList gerarUF(){
        obs0leList= FXCollections.observableArrayList("AL","CE","AM","MA","BA","ES","PA","PI","PR","DF","SP"
                ,"RJ"," GO","MT","MS","MG","PB","RS","RO","SE","SC","RN"
        );
    return obs0leList;
    }
}
