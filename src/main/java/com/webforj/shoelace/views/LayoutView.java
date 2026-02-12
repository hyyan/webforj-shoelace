package com.webforj.shoelace.views;

import com.webforj.component.Component;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.H2;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.html.elements.Span;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;
import com.webforj.shoelace.components.breadcrumb.Breadcrumb;
import com.webforj.shoelace.components.breadcrumbitem.BreadcrumbItem;
import com.webforj.shoelace.components.details.Details;
import com.webforj.shoelace.components.divider.Divider;
import com.webforj.shoelace.components.splitpanel.SplitPanel;
import com.webforj.shoelace.components.tab.Tab;
import com.webforj.shoelace.components.tabgroup.TabGroup;
import com.webforj.shoelace.components.tabpanel.TabPanel;

@Route(value = "/layout", outlet = MainLayout.class)
@FrameTitle("Layout")
public class LayoutView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public LayoutView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setStyle("padding", "var(--dwc-space-l)");
    self.setStyle("gap", "var(--dwc-space-xl)");
    self.setMaxWidth("900px");

    self.add(
        buildBreadcrumbSection(),
        buildDetailsSection(),
        buildDividerSection(),
        buildSplitPanelSection(),
        buildTabGroupSection());
  }

  private FlexLayout buildBreadcrumbSection() {
    Breadcrumb breadcrumb = new Breadcrumb();

    BreadcrumbItem home = new BreadcrumbItem();
    home.add(new Span("Home"));
    home.setHref("/");

    BreadcrumbItem products = new BreadcrumbItem();
    products.add(new Span("Products"));
    products.setHref("/products");

    BreadcrumbItem shoes = new BreadcrumbItem();
    shoes.add(new Span("Shoes"));
    shoes.setHref("/products/shoes");

    BreadcrumbItem running = new BreadcrumbItem();
    running.add(new Span("Running Shoes"));

    breadcrumb.add(home, products, shoes, running);

    return section("Breadcrumb",
        "Shows the user's location within a navigational hierarchy.",
        breadcrumb);
  }

  private FlexLayout buildDetailsSection() {
    Details details1 = new Details();
    details1.setSummary("What is Shoelace?");
    details1.setOpen(true);
    details1.add(new Paragraph(
        "Shoelace is a library of web components built with LitElement. "
            + "It provides a collection of professionally designed, accessible UI components."));

    Details details2 = new Details();
    details2.setSummary("Can I use Shoelace with webforJ?");
    details2.add(new Paragraph(
        "Yes! This demo project wraps every Shoelace component as a Java-first webforJ component "
            + "with type-safe APIs, fluent builders, and proper enums."));

    Details details3 = new Details();
    details3.setSummary("Is this section disabled?");
    details3.setDisabled(true);
    details3.add(new Paragraph("You shouldn't be able to see this."));

    return section("Details",
        "Expandable sections that reveal hidden content when toggled.",
        details1, details2, details3);
  }

  private FlexLayout buildDividerSection() {
    Paragraph before = new Paragraph("Content above the divider");
    Divider horizontal = new Divider();
    Paragraph after = new Paragraph("Content below the divider");

    FlexLayout verticalDemo = new FlexLayout(FlexDirection.ROW);
    verticalDemo.setStyle("gap", "var(--dwc-space-m)");
    verticalDemo.setStyle("align-items", "center");
    verticalDemo.setStyle("height", "40px");
    Span left = new Span("Left");
    Divider vertical = new Divider();
    vertical.setVertical(true);
    Span right = new Span("Right");
    verticalDemo.add(left, vertical, right);

    return section("Divider",
        "Visual separators for content, horizontal or vertical.",
        before, horizontal, after, verticalDemo);
  }

  private FlexLayout buildSplitPanelSection() {
    SplitPanel splitPanel = new SplitPanel();
    splitPanel.setPosition(40);
    splitPanel.setStyle("height", "200px");
    splitPanel.setStyle("border", "1px solid var(--sl-color-neutral-200)");
    splitPanel.setStyle("border-radius", "var(--sl-border-radius-medium)");

    Div startPanel = new Div();
    startPanel.setStyle("height", "100%");
    startPanel.setStyle("display", "flex");
    startPanel.setStyle("align-items", "center");
    startPanel.setStyle("justify-content", "center");
    startPanel.setStyle("background", "var(--sl-color-neutral-50)");
    startPanel.add(new Span("Start Panel"));

    Div endPanel = new Div();
    endPanel.setStyle("height", "100%");
    endPanel.setStyle("display", "flex");
    endPanel.setStyle("align-items", "center");
    endPanel.setStyle("justify-content", "center");
    endPanel.setStyle("background", "var(--sl-color-primary-50)");
    endPanel.add(new Span("End Panel"));

    splitPanel.addToStart(startPanel);
    splitPanel.addToEnd(endPanel);

    return section("Split Panel",
        "Two resizable panels separated by a draggable divider.",
        splitPanel);
  }

  private FlexLayout buildTabGroupSection() {
    TabGroup tabGroup = new TabGroup();

    Tab tab1 = new Tab();
    tab1.setPanel("general");
    tab1.add(new Span("General"));

    Tab tab2 = new Tab();
    tab2.setPanel("custom");
    tab2.add(new Span("Custom"));

    Tab tab3 = new Tab();
    tab3.setPanel("advanced");
    tab3.add(new Span("Advanced"));

    Tab tab4 = new Tab();
    tab4.setPanel("disabled");
    tab4.add(new Span("Disabled"));
    tab4.setDisabled(true);

    tabGroup.addToNav(tab1, tab2, tab3, tab4);

    TabPanel panel1 = new TabPanel();
    panel1.setName("general");
    panel1.add(new Paragraph("This is the general tab panel."));

    TabPanel panel2 = new TabPanel();
    panel2.setName("custom");
    panel2.add(new Paragraph("This is the custom tab panel."));

    TabPanel panel3 = new TabPanel();
    panel3.setName("advanced");
    panel3.add(new Paragraph("This is the advanced tab panel."));

    TabPanel panel4 = new TabPanel();
    panel4.setName("disabled");
    panel4.add(new Paragraph("This tab is disabled."));

    tabGroup.add(panel1, panel2, panel3, panel4);

    return section("Tab Group",
        "Organize content into tabbed sections. The last tab is disabled.",
        tabGroup);
  }

  private FlexLayout section(String title, String description, Component... content) {
    H2 heading = new H2(title);
    Paragraph desc = new Paragraph(description);
    FlexLayout inner = new FlexLayout(FlexDirection.COLUMN, content);
    inner.setStyle("gap", "var(--dwc-space-s)");
    FlexLayout sectionLayout = new FlexLayout(FlexDirection.COLUMN, heading, desc, inner);
    sectionLayout.setStyle("gap", "var(--dwc-space-s)");
    return sectionLayout;
  }
}
