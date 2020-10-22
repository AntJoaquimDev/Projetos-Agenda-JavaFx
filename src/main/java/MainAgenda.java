import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainAgenda extends Application {

	    @Override
	    public void start(Stage stage) throws Exception {

			Parent root = FXMLLoader.load(getClass().getResource("/fxml_View/TelaInicial_View.fxml"));
			Stage stage1 = new Stage();

			Image appIcon = new Image(getClass().getResourceAsStream("/icones/iconeAplicacao.png"));
			stage.getIcons().add(appIcon);

			Scene scene = new Scene(root);
			scene.getStylesheets().add("/stylesCSS/Styles.css");

			stage1.setTitle("AGENDA DE CONTATOS");
			stage1.setMaximized(true);
			stage1.setScene(scene);
			stage1.show();

	    }

	    public static void main(String[] args) {
	        launch(args);
	    }
	    
	}

