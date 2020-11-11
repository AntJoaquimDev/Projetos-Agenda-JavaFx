package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerTelaInicialView implements Initializable {

    @FXML
    private MenuItem menuItemRelContatos;

    @FXML
    private Menu menuAquivo;

    @FXML
    private MenuItem menuItemContato;
    @FXML
    private MenuItem menuItemTipoContato;

    @FXML
    private MenuItem menuItemUsuario;

    @FXML
    private MenuItem menuItemCidades;

    @FXML
    private MenuItem menuItemSair;

    @FXML
    private Menu menuItemRel;

    @FXML
    private MenuItem menuItemRelEnerec;

    @FXML
    private MenuItem menuItemRelTelefones;


    @FXML
    private MenuItem menuItemRelTipoContatos;

    @FXML
    private Menu menuSobre;
    @FXML
    public void listarContatos(ActionEvent event) {
    }

    @FXML
    void listarEnderecos(ActionEvent event)throws IOException {

    }

    @FXML
    void listarTelefones(ActionEvent event) throws IOException{

    }

    @FXML
    void listarTiposContatos(ActionEvent event) throws IOException{

    }

    @FXML
    void sair(ActionEvent event) throws IOException{

    }

    @FXML
    void telaCidades(ActionEvent event) throws IOException{
        // chamar tela cidades
        carregarForms("Cidadesview","CIDADES");

    }

    @FXML
    void telaContatos(ActionEvent event)throws IOException {
        //montar tela Contato
        carregarForms("Contatoview","CONTATO");

    }
    @FXML
    void telaTiposContatos(ActionEvent event) throws IOException{
        carregarForms("TipoContato_view","TIPOS DE CONTATO");
    }
    @FXML
    void telasUsuarios(ActionEvent event) throws IOException {
        //listar tela  Usuario

        carregarForms("Usuario_View", "Usuários");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarIcones();
    }
    public  void carregarForms(String form,String titulo) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/fxml_View/" +form+".fxml"));
        Stage stage = new Stage();
        Image appIcon = new Image(getClass().getResourceAsStream("/icones/iconeAplicacao.png"));
        stage.getIcons().add(appIcon);
        Scene scene = new Scene(root);
        //scene.getStylesheets().add("/stylesCSS/Styles.css");
        stage.setTitle(titulo);
        stage.setResizable(false);
        //stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.show();
    }
    public void carregarIcones(){

        menuItemContato.setGraphic(new ImageView("icones/iconeMenuContatoTipo.png"));
        menuItemTipoContato.setGraphic(new ImageView("/icones/iconeMenuContato.png"));
        menuItemCidades.setGraphic(new ImageView("/icones/iconeMenuCidade.png"));
        menuItemUsuario.setGraphic(new ImageView("/icones/iconeMenuUsuario.png"));
        menuItemSair.setGraphic(new ImageView("/icones/iconeMenuSair.png"));

        menuItemRelContatos.setGraphic(new ImageView("/icones/iconeMenuRelatorio.png"));
        menuItemRelEnerec.setGraphic(new ImageView("/icones/iconeMenuRelatorio.png"));
        menuItemRelTelefones.setGraphic(new ImageView("/icones/iconeMenuRelatorio.png"));
        menuItemRelTipoContatos.setGraphic(new ImageView("/icones/iconeMenuRelatorio.png"));
        menuSobre.setGraphic(new ImageView("/icones/iconeMenuSobre.png"));
    }
}

