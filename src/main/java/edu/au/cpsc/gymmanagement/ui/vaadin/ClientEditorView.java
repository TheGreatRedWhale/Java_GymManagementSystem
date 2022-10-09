package edu.au.cpsc.gymmanagement.ui.vaadin;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import edu.au.cpsc.gymmanagement.entity.Client;
import java.awt.TextField;
import java.util.Collection;

public class ClientEditorView extends VerticalLayout {

  private final Binder<Client> clientBinder;

  public ClientEditorView() {

    clientBinder = new Binder<>();
    FormLayout form = new FormLayout();
    TextField nameField = new TextField("Name");
    TextField birthdateField = new TextField("DOB");
    TextField addressField = new TextField("Address");
    TextField emailField = new TextField("Email");
  }

  public void showClient(Client client) {
    clientBinder.readBean(client);
  }

  public void updateClient(Client client) throws ValidationException {
    clientBinder.writeBean(client);
  }

}
