package com.webforj.shoelace.components.tabpanel;

import com.webforj.component.element.Element;
import com.webforj.component.element.ElementCompositeContainer;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.component.element.concern.HasElementClickListener;
import com.webforj.concern.HasClassName;
import com.webforj.concern.HasStyle;
import com.webforj.concern.HasVisibility;

/**
 * Shoelace TabPanel component ({@code <sl-tab-panel>}).
 *
 * <p>Tab panels are used inside tab groups to display the content associated with a tab. Each tab
 * panel must have a unique {@code name} that matches the {@code panel} attribute of its
 * corresponding tab.</p>
 *
 * @see <a href="https://shoelace.style/components/tab-panel">Shoelace Tab Panel</a>
 */
@NodeName("sl-tab-panel")
public final class TabPanel extends ElementCompositeContainer
    implements HasElementClickListener<TabPanel>, HasClassName<TabPanel>, HasStyle<TabPanel>, HasVisibility<TabPanel> {

  private final PropertyDescriptor<String> nameProp =
      PropertyDescriptor.property("name", "");
  private final PropertyDescriptor<Boolean> activeProp =
      PropertyDescriptor.property("active", false);

  /**
   * Creates a new TabPanel.
   */
  public TabPanel() {
    super();
  }

  /**
   * Creates a new TabPanel with the given name.
   *
   * @param name the panel name
   */
  public TabPanel(String name) {
    this();
    setName(name);
  }

  /**
   * Gets the tab panel's name.
   *
   * @return the name
   */
  public String getName() {
    return get(nameProp);
  }

  /**
   * Sets the tab panel's name. This must match the {@code panel} attribute of its corresponding
   * tab.
   *
   * @param name the name to set
   * @return this component
   */
  public TabPanel setName(String name) {
    set(nameProp, name);
    return this;
  }

  /**
   * Returns whether the tab panel is shown.
   *
   * @return {@code true} if the tab panel is active
   */
  public boolean isActive() {
    return get(activeProp);
  }

  /**
   * Sets whether the tab panel is shown.
   *
   * @param active {@code true} to show the tab panel
   * @return this component
   */
  public TabPanel setActive(boolean active) {
    set(activeProp, active);
    return this;
  }

  Element getOriginalElement() {
    return getElement();
  }
}
