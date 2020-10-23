package controller;

import agendaDao.CrudGernecDao;
import agendaModel.Cidade;
import agendaUtil.Alerta;
import agendaUtil.UF;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerCidadesView implements Initializable,IntCadastro {

    @FXML
    private JFXTextField tfCep;

    @FXML
    private JFXTextField tfId;
    @FXML
    private Label lblTitulo;
    @FXML
    private JFXTextField tfDescricao;

    @FXML
    private Button btnNovo;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnDeletar;

    @FXML
    private TextField tfPesquisar;
    @FXML
    private ComboBox<String> cboxUf;
    @FXML
    private TableView<Cidade> tbView;

    private CrudGernecDao<Cidade> dao = new CrudGernecDao();
    private ObservableList<Cidade> observableList = FXCollections.observableArrayList();
    private List<Cidade> lista;
    private Cidade objSelecionado = new Cidade();
   //eventos e actions
   @Override
   public void initialize(URL location, ResourceBundle resources) {
       lblTitulo.setText("Cadastro de Cidades");
      // ocultar();
       criarColunasTabela();
       cboxUf.setItems(UF.gerarUF());
       atualizarTabela();
   }
    @FXML
    void deletarRegistro(ActionEvent event) {
        if (Alerta.msgConfimarExclusao(tfDescricao.getText())) {
            dao.excluis(objSelecionado);
            limparCamposFormes();
            atualizarTabela();
            Alerta.msgInformacao("Registro Excluído com Sucesso");
        } else {

        }
    }

    @FXML
    void incluirRegistro(ActionEvent event) {
        limparCamposFormes();
    }

    @FXML
    void salvarRegistro(ActionEvent event) {
        Cidade objeto = new Cidade();
//     testar se o campo Id esta selecionado ou nao. se sim ele altera se nao ele inclui nova registro
        if (objSelecionado != null) {
            objeto.setId(objSelecionado.getId());   // apenas isso para alterar Tipo contato
        }
        objeto.setDescricao(tfDescricao.getText());
        objeto.setCep(tfCep.getText());
        objeto.setUf(cboxUf.getValue());

        if (dao.salvar(objeto)) {
            Alerta.msgInformacao("Registro Gravado com Sucesso");
        } else {
            Alerta.msgInformacao("Erro ao tentar gravar o registro");
        }
        lblTitulo.setText("Cidade Cadastrada ");
        tfId.clear();
        tfDescricao.clear();
        atualizarTabela();
        limparCamposFormes();

    }

    @Override
    public void criarColunasTabela() {

        TableColumn<Cidade, Long> colunaId = new TableColumn<>("ID");
        colunaId.setMinWidth(40);
        colunaId.setMaxWidth(40);

        TableColumn<Cidade, String> colunaDescricao= new TableColumn<>("DESCRIÇÃO");

        TableColumn<Cidade, String> colunaUf = new TableColumn<>("UF");
        colunaUf.setMinWidth(40);
        colunaUf.setMaxWidth(40);

        TableColumn<Cidade, String> colunaCep= new TableColumn<>("CEP");

        tbView.getColumns().addAll(colunaId,colunaDescricao,colunaUf,colunaCep);

        tbView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

            colunaId.setCellValueFactory(new PropertyValueFactory<Cidade,Long>("id"));
            colunaDescricao.setCellValueFactory(new PropertyValueFactory<Cidade,String>("descricao"));
            colunaUf.setCellValueFactory(new PropertyValueFactory<Cidade,String>("uf"));
            colunaCep.setCellValueFactory(new PropertyValueFactory<Cidade,String>("cep"));

    }

    @Override
    public void atualizarTabela() {
        observableList.clear();
        lista = dao.consultar(tfPesquisar.getText(),"Cidade");

        //percorrer cada registro na lista
        for(Cidade t: lista){ //forEach
            observableList.add(t);
        }
        tbView.getItems().setAll(observableList);
        tbView.getSelectionModel().selectFirst();
    }

    @Override
    public void seteCamposFormes() {
        //pegar o objeto selecionado e preencher o form pelo index;;;;
        if (!tbView.getItems().isEmpty()) {
            objSelecionado = tbView.getItems().get(tbView.getSelectionModel().getFocusedIndex());
            tfId.setText(String.valueOf(objSelecionado.getId()));
            tfDescricao.setText(objSelecionado.getDescricao());
            tfCep.setText(String.valueOf(objSelecionado.getCep()));
            cboxUf.setValue(objSelecionado.getUf());
        }
    }

    @Override
    public void limparCamposFormes() {
        objSelecionado = null;
        lista.clear();
        lblTitulo.setText("");
        tfId.clear();
        tfDescricao.clear();
        tfCep.clear();
        cboxUf.getSelectionModel().select(-1);
        tfDescricao.requestFocus();
    }



    @FXML
    void clicarTabela(MouseEvent event) {
        seteCamposFormes();
    }

    @FXML
    void moverTabela(KeyEvent event) {
        seteCamposFormes();
    }

    @FXML
    void filtarRegistros(MouseEvent event) {
        atualizarTabela();
    }
    @FXML
    void filtarRegistros(KeyEvent event) {
        atualizarTabela();
    }
    @FXML
    void atualizarListaClick(MouseEvent event) {
        atualizarTabela();
    }

    public void filtrarRegistro(KeyEvent keyEvent) {
        atualizarTabela();
    }

    public void ocultar(){
        tfId.setDisable(true);
        tfDescricao.setDisable(true);
    }

    public void ativar(){
        tfId.setDisable(false);
        tfDescricao.setDisable(false);
    }
}