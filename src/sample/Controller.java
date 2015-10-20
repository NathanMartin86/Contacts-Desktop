package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    ObservableList<Contact> contacts = FXCollections.observableArrayList();

    @FXML
    TextField nameField;
    @FXML
    TextField emailField;
    @FXML
    TextField phoneField;
    @FXML
    ListView listView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listView.setItems(contacts);

    }
    public void addContact() {
        Contact contact = new Contact(nameField.getText(), emailField.getText(), phoneField.getText());
        if(!nameField.getText().equals("") && !emailField.getText().equals("")&&!phoneField.getText().equals("")){
            contacts.add(contact);
        }
        nameField.setText("");
        phoneField.setText("");
        emailField.setText("");
    }

    public void removeContact(){
        Contact contact = (Contact) listView.getSelectionModel().getSelectedItem();
        if (contact != null) {
            contacts.remove(contact);
        }
    }
}