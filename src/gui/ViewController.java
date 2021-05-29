package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import entities.Piramide;
import entities.Poliedro;
import entities.Poligono;
import entities.Prisma;
import entities.Tronco;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ViewController implements Initializable {
    String[] poliedros = { "PRISMA", "PIRAMIDE", "TRONCO" };
    String[] bases = { "QUADRADO", "TRIANGULO_EQUILATERO", "HEXAGONO_REGULAR", "CIRCULO" };

    @FXML
    private Label lbPoliedro;

    @FXML
    private Label lbBase;

    @FXML
    private Label lbArestaMaior;

    @FXML
    private Label lbAltura;

    @FXML
    private Label lbArestaMenor;

    @FXML
    private TextField txtArestaMaior;

    @FXML
    private TextField txtAltura;

    @FXML
    private TextField txtArestaMenor;

    @FXML
    private ChoiceBox<String> cbPoliedro;

    @FXML
    private ChoiceBox<String> cbBase;

    @FXML
    private Button btCalcula;

    @FXML
    private TextArea txtLista;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        cbPoliedro.getItems().addAll(poliedros);
        cbBase.getItems().addAll(bases);
        cbPoliedro.setOnAction(this::verificaSelecao);

    }

    @FXML
    public void btCalculaClick() {
        Locale.setDefault(Locale.US);

        try {
            String tipoPoliedro = cbPoliedro.getValue();
            String base = cbBase.getValue();
            Poligono poligono = Poligono.valueOf(base);
            Double arestaMaior = Double.parseDouble(txtArestaMaior.getText());
            Double altura = Double.parseDouble(txtAltura.getText());

            Poliedro pol = null;

            switch (tipoPoliedro) {
                case "PRISMA":
                    pol = new Prisma(poligono, altura, arestaMaior);
                    break;
                case "PIRAMIDE":
                    pol = new Piramide(poligono, altura, arestaMaior);
                    break;
                case "TRONCO":
                    Double arestaMenor = Double.parseDouble(txtArestaMenor.getText());
                    pol = new Tronco(poligono, altura, arestaMaior, arestaMenor);
                    break;
                default:
                    txtLista.appendText("\nISSO NÃO FOI IMPLEMENTADO");
            }
            if (pol != null) {
                txtLista.clear();
                txtLista.appendText(pol.toString());
            }
        } catch (NumberFormatException e) {
            txtLista.clear();
            txtLista.appendText("\nFORMATO DE NÚMERO INVÁLIDO");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void verificaSelecao(ActionEvent event) {

        if (cbPoliedro.getValue() != "TRONCO") {
            lbArestaMenor.setVisible(false);
            txtArestaMenor.setVisible(false);
        } else {
            lbArestaMenor.setVisible(true);
            txtArestaMenor.setVisible(true);
        }

    }
}
