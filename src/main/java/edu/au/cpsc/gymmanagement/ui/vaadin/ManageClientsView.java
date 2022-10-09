package edu.au.cpsc.gymmanagement.ui.vaadin;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import edu.au.cpsc.gymmanagement.entity.Client;
import edu.au.cpsc.gymmanagement.repository.ClientRepository;

@Route(value = "/manageclients", layout = MainLayout.class)
public class ManageClientsView extends Div {
  private ClientRepository clientRepository;
  private final Grid<Client> clientGrid;

  public ManageClientsView(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;

    VerticalLayout rootSection = new VerticalLayout();
    HorizontalLayout toolbar = new HorizontalLayout();
    HorizontalLayout clientEditorRow = new HorizontalLayout();
    clientGrid = createGrid();
    VerticalLayout rightSection = new VerticalLayout();
    populateGrid();

    for (Client client: clientRepository.findAll()) {
      add(new Paragraph(client.toString()));
    }
    clientEditorRow.add(clientGrid, rightSection);
    rootSection.add(toolbar,clientEditorRow);
    this.add(rootSection);
  }

  private Grid<Client> createGrid() {
    return new Grid<>(Client.class, false);
  }

  private void populateGrid() {
    clientGrid.setColumns("id", "name","birthdate","address","email");
    clientGrid.setItems(clientRepository.findAll());
  }
}
