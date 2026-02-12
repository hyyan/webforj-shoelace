package com.webforj.shoelace.views;

import java.util.Set;

import com.webforj.component.Component;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.H1;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.icons.TablerIcon;
import com.webforj.component.layout.applayout.AppDrawerToggle;
import com.webforj.component.layout.applayout.AppLayout;
import com.webforj.component.layout.appnav.AppNav;
import com.webforj.component.layout.appnav.AppNavItem;
import com.webforj.component.layout.toolbar.Toolbar;
import com.webforj.router.Router;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;
import com.webforj.router.event.NavigateEvent;

@Route
public class MainLayout extends Composite<AppLayout> {
  private AppLayout self = getBoundComponent();
  private H1 title = new H1();

  public MainLayout() {
    setHeader();
    setDrawer();
    Router.getCurrent().onNavigate(this::onNavigate);
  }

  private void setHeader() {
    self.setDrawerHeaderVisible(true);

    Paragraph drawerTitle = new Paragraph("Shoelace for webforJ");
    drawerTitle.setStyle("font-weight", "bold");
    drawerTitle.setStyle("font-size", "1.2rem");
    drawerTitle.setStyle("padding", "var(--dwc-space-s) var(--dwc-space-m)");
    self.addToDrawerTitle(drawerTitle);

    Toolbar toolbar = new Toolbar();
    toolbar.addToStart(new AppDrawerToggle());
    toolbar.addToTitle(title);

    self.addToHeader(toolbar);
  }

  private void setDrawer() {
    AppNav appNav = new AppNav();
    appNav.addItem(
        new AppNavItem("Actions", ActionsView.class, TablerIcon.create("click")));
    appNav.addItem(
        new AppNavItem("Data Display", DataDisplayView.class, TablerIcon.create("table")));
    appNav.addItem(
        new AppNavItem("Form Controls", FormControlsView.class, TablerIcon.create("forms")));
    appNav.addItem(
        new AppNavItem("Feedback", FeedbackView.class, TablerIcon.create("bell")));
    appNav.addItem(
        new AppNavItem("Layout", LayoutView.class, TablerIcon.create("layout")));
    appNav.addItem(
        new AppNavItem("Media", MediaView.class, TablerIcon.create("photo")));
    appNav.addItem(
        new AppNavItem("Utilities", UtilitiesView.class, TablerIcon.create("tool")));

    self.addToDrawer(appNav);
  }

  private void onNavigate(NavigateEvent ev) {
    Set<Component> components = ev.getContext().getAllComponents();
    Component view = components.stream()
        .filter(c -> c.getClass().getSimpleName().endsWith("View"))
        .findFirst()
        .orElse(null);

    if (view != null) {
      FrameTitle frameTitle = view.getClass().getAnnotation(FrameTitle.class);
      title.setText(frameTitle != null ? frameTitle.value() : "");
    }
  }
}
