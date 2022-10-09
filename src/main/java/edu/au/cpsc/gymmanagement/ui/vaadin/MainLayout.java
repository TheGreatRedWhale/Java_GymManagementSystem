package edu.au.cpsc.gymmanagement.ui.vaadin;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Route("")
public class MainLayout extends AppLayout {

  private static Logger log = LoggerFactory.getLogger(MainLayout.class);

  public MainLayout () {
    DrawerToggle toggle = new DrawerToggle();

    H1 title = new H1("Gym Management");
    title.getStyle().set("font-size", "var(--lumo-font-size-l)")
        .set("margin", "0");

    Tabs tabs = getTabs();

    addToDrawer(tabs);
    addToNavbar(toggle, title);

    setPrimarySection(Section.DRAWER);
  }

  private Tabs getTabs() {
    Tabs tabs = new Tabs();
    tabs.add(createTab(VaadinIcon.USER_HEART, "Customers", ManageClientsView.class),
        createTab(VaadinIcon.RECORDS, "Contracts", ManageContractsView.class));
    tabs.setOrientation(Tabs.Orientation.VERTICAL);
    return tabs;
  }

  private Tab createTab(VaadinIcon viewIcon, String viewName,
      Class<? extends Component> componentClass) {
    Icon icon = viewIcon.create();
    icon.getStyle().set("box-sizing", "border-box")
        .set("margin-inline-end", "var(--lumo-space-m)")
        .set("padding", "var(--lumo-space-xs)");

    RouterLink link = new RouterLink(componentClass);
    link.add(icon, new Span(viewName));
    link.setTabIndex(-1);

    return new Tab(link);
  }
}
