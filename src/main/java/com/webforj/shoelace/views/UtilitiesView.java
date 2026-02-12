package com.webforj.shoelace.views;

import com.webforj.component.Component;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.*;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;
import com.webforj.shoelace.Placement;
import com.webforj.shoelace.components.button.Button;
import com.webforj.shoelace.components.divider.Divider;
import com.webforj.shoelace.components.menu.Menu;
import com.webforj.shoelace.components.menuitem.MenuItem;
import com.webforj.shoelace.components.menuitem.MenuItemType;
import com.webforj.shoelace.components.menulabel.MenuLabel;
import com.webforj.shoelace.components.mutationobserver.MutationObserver;
import com.webforj.shoelace.components.popup.Popup;
import com.webforj.shoelace.components.resizeobserver.ResizeObserver;
import com.webforj.shoelace.components.visuallyhidden.VisuallyHidden;

@Route(value = "/utilities", outlet = MainLayout.class)
@FrameTitle("Utilities")
public class UtilitiesView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public UtilitiesView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setStyle("padding", "var(--dwc-space-l)")
        .setStyle("gap", "var(--dwc-space-xl)")
        .setStyle("max-width", "900px");

    self.add(
        createMenuSection(),
        createPopupSection(),
        createMutationObserverSection(),
        createResizeObserverSection(),
        createVisuallyHiddenSection());
  }

  private Component createMenuSection() {
    Menu menu = new Menu();
    menu.setStyle("max-width", "250px")
        .setStyle("border", "1px solid var(--sl-color-neutral-200)")
        .setStyle("border-radius", "var(--sl-border-radius-medium)");

    MenuLabel generalLabel = new MenuLabel("General");
    MenuItem homeItem = new MenuItem("Home");
    MenuItem settingsItem = new MenuItem("Settings");

    Divider divider1 = new Divider();

    MenuLabel preferencesLabel = new MenuLabel("Preferences");

    MenuItem darkModeItem = new MenuItem("Dark Mode");
    darkModeItem.setType(MenuItemType.CHECKBOX);

    MenuItem notificationsItem = new MenuItem("Notifications");
    notificationsItem.setType(MenuItemType.CHECKBOX);
    notificationsItem.setChecked(true);

    Divider divider2 = new Divider();

    MenuItem logoutItem = new MenuItem("Logout");
    logoutItem.setDisabled(true);

    menu.add(
        generalLabel, homeItem, settingsItem,
        divider1,
        preferencesLabel, darkModeItem, notificationsItem,
        divider2,
        logoutItem);

    Paragraph description = new Paragraph();
    description.setText(
        "Menu provides a list of options for the user to choose from. It supports "
            + "MenuLabel for grouping, MenuItem for options (including checkbox types), "
            + "and Divider for visual separation.");

    return section("Menu", description, menu);
  }

  private Component createPopupSection() {
    Div popupContainer = new Div();
    popupContainer.setStyle("position", "relative")
        .setStyle("min-height", "120px")
        .setStyle("display", "flex")
        .setStyle("align-items", "flex-end")
        .setStyle("justify-content", "center")
        .setStyle("padding-top", "var(--dwc-space-xl)");

    Button anchorButton = new Button("Anchor Element");

    Popup popup = new Popup();
    popup.addToAnchor(anchorButton);
    popup.setPlacement(Placement.TOP);
    popup.setActive(true);
    popup.setDistance(8);

    Div popupContent = new Div();
    popupContent.setStyle("padding", "var(--dwc-space-s) var(--dwc-space-m)")
        .setStyle("background", "var(--sl-color-primary-600)")
        .setStyle("color", "white")
        .setStyle("border-radius", "var(--sl-border-radius-medium)")
        .setStyle("font-size", "var(--sl-font-size-small)")
        .setStyle("white-space", "nowrap");
    popupContent.add(new Span("Popup content anchored to the button below"));

    popup.add(popupContent);

    popupContainer.add(popup);

    Paragraph description = new Paragraph();
    description.setText(
        "Popup is a utility component for declaratively anchoring floating content to "
            + "another element. It uses the Floating UI library for positioning and can be "
            + "used as a building block for tooltips, dropdowns, and similar patterns.");

    return section("Popup", description, popupContainer);
  }

  private Component createMutationObserverSection() {
    Div observedElement = new Div();
    observedElement.setText("This element is being observed for attribute changes.");
    observedElement.setStyle("padding", "var(--dwc-space-m)")
        .setStyle("border", "2px dashed var(--sl-color-neutral-300)")
        .setStyle("border-radius", "var(--sl-border-radius-medium)");

    MutationObserver mutationObserver = new MutationObserver();
    mutationObserver.setAttr("*");
    mutationObserver.setChildList(true);
    mutationObserver.add(observedElement);

    Paragraph description = new Paragraph();
    description.setText(
        "MutationObserver provides a thin, declarative interface to the MutationObserver API. "
            + "It watches for changes to attributes, child nodes, and character data within "
            + "slotted elements. In this example, it monitors all attribute changes and child "
            + "list modifications on the element below.");

    return section("Mutation Observer", description, mutationObserver);
  }

  private Component createResizeObserverSection() {
    Div resizableElement = new Div();
    resizableElement.setText("Resize this element by dragging the corner handle.");
    resizableElement.setStyle("padding", "var(--dwc-space-m)")
        .setStyle("border", "2px dashed var(--sl-color-neutral-300)")
        .setStyle("border-radius", "var(--sl-border-radius-medium)")
        .setStyle("resize", "both")
        .setStyle("overflow", "auto")
        .setStyle("min-width", "200px")
        .setStyle("min-height", "80px")
        .setStyle("max-width", "100%");

    ResizeObserver resizeObserver = new ResizeObserver();
    resizeObserver.add(resizableElement);

    Paragraph description = new Paragraph();
    description.setText(
        "ResizeObserver provides a thin, declarative interface to the ResizeObserver API. "
            + "It detects when slotted elements are resized. The element below has CSS "
            + "resize enabled so you can drag its corner to test the observer.");

    return section("Resize Observer", description, resizeObserver);
  }

  private Component createVisuallyHiddenSection() {
    VisuallyHidden visuallyHidden = new VisuallyHidden();
    Span hiddenText = new Span();
    hiddenText.setText("This text is only available to screen readers and assistive devices.");
    visuallyHidden.add(hiddenText);

    Div demoContainer = new Div();
    demoContainer.setStyle("padding", "var(--dwc-space-m)")
        .setStyle("border", "2px dashed var(--sl-color-neutral-300)")
        .setStyle("border-radius", "var(--sl-border-radius-medium)");

    Span visibleLabel = new Span();
    visibleLabel.setText("Visible label: ");
    visibleLabel.setStyle("font-weight", "var(--sl-font-weight-semibold)");

    Span visibleText = new Span();
    visibleText.setText("There is hidden text next to this sentence (inspect the DOM to see it).");

    demoContainer.add(visibleLabel, visibleText, visuallyHidden);

    Paragraph description = new Paragraph();
    description.setText(
        "VisuallyHidden makes content accessible to assistive devices without displaying "
            + "it on the screen. This is useful for providing additional context, such as "
            + "skip links or labels, that sighted users do not need to see. The element "
            + "below contains hidden text that is only available to screen readers.");

    return section("Visually Hidden", description, demoContainer);
  }

  private FlexLayout section(String title, Component... content) {
    FlexLayout layout = new FlexLayout();
    layout.setDirection(FlexDirection.COLUMN);
    layout.setStyle("gap", "var(--dwc-space-m)")
        .setStyle("padding", "var(--dwc-space-l)")
        .setStyle("border", "1px solid var(--dwc-color-default)")
        .setStyle("border-radius", "var(--dwc-border-radius-m)");

    H3 heading = new H3();
    heading.setText(title);
    heading.setStyle("margin", "0");

    layout.add(heading);
    layout.add(content);

    return layout;
  }
}
