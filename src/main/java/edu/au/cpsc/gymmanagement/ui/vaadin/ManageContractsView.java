package edu.au.cpsc.gymmanagement.ui.vaadin;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.router.Route;
import edu.au.cpsc.gymmanagement.entity.Client;
import edu.au.cpsc.gymmanagement.entity.Contract;
import edu.au.cpsc.gymmanagement.repository.ClientRepository;
import edu.au.cpsc.gymmanagement.repository.ContractRepository;
import edu.au.cpsc.gymmanagement.repository.ContractTypeRepository;


@Route(value = "/managecontracts", layout = MainLayout.class)
public class ManageContractsView extends Div {

  public ManageContractsView(
    ContractTypeRepository contractTypeRepository,
    ContractRepository contractRepository,
    ClientRepository clientRepository) {
      for (Contract contract: contractRepository.findAll()) {
        add(new Paragraph(contract.toString()));
      }
  }
}
