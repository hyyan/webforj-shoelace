package com.webforj.shoelace.components.tab;

import com.webforj.component.element.Element;
import com.webforj.component.element.ElementCompositeContainer;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.component.element.concern.HasElementClickListener;
import com.webforj.concern.HasClassName;
import com.webforj.concern.HasStyle;
import com.webforj.concern.HasVisibility;
import com.webforj.dispatcher.EventListener;
import com.webforj.dispatcher.ListenerRegistration;
import com.webforj.shoelace.components.tab.event.CloseEvent;

/**
 * Shoelace Tab component ({@code <sl-tab>}).
 *
 * <p>Tabs are used inside tab groups to represent and activate tab panels. Each tab must be
 * associated with a tab panel by matching the tab's {@code panel} property to the panel's
 * {@code name} property.</p>
 *
 * @see <a href="https://shoelace.style/components/tab">Shoelace Tab</a>
 */
@NodeName("sl-tab")
public final class Tab extends ElementCompositeContainer
    implements HasElementClickListener<Tab>, HasClassName<Tab>, HasStyle<Tab>, HasVisibility<Tab> {

  private final PropertyDescriptor<String> panelProp =
      PropertyDescriptor.property("panel", "");
  private final PropertyDescriptor<Boolean> activeProp =
      PropertyDescriptor.property("active", false);
  private final PropertyDescriptor<Boolean> closableProp =
      PropertyDescriptor.property("closable", false);
  private final PropertyDescriptor<Boolean> disabledProp =
      PropertyDescriptor.property("disabled", false);

  /**
   * Creates a new Tab.
   */
  public Tab() {
    super();
  }

  /**
   * Gets the name of the tab panel this tab is associated with.
   *
   * @return the panel name
   */
  public String getPanel() {
    return get(panelProp);
  }

  /**
   * Sets the name of the tab panel this tab is associated with. The panel must be located in the
   * same tab group.
   *
   * @param panel the panel name
   * @return this component
   */
  public Tab setPanel(String panel) {
    set(panelProp, panel);
    return this;
  }

  /**
   * Returns whether the tab is drawn in an active state.
   *
   * @return {@code true} if the tab is active
   */
  public boolean isActive() {
    return get(activeProp);
  }

  /**
   * Sets whether the tab is drawn in an active state.
   *
   * @param active {@code true} to draw the tab as active
   * @return this component
   */
  public Tab setActive(boolean active) {
    set(activeProp, active);
    return this;
  }

  /**
   * Returns whether the tab is closable and shows a close button.
   *
   * @return {@code true} if the tab is closable
   */
  public boolean isClosable() {
    return get(closableProp);
  }

  /**
   * Sets whether the tab is closable and shows a close button.
   *
   * @param closable {@code true} to make the tab closable
   * @return this component
   */
  public Tab setClosable(boolean closable) {
    set(closableProp, closable);
    return this;
  }

  /**
   * Returns whether the tab is disabled.
   *
   * @return {@code true} if the tab is disabled
   */
  public boolean isDisabled() {
    return get(disabledProp);
  }

  /**
   * Sets whether the tab is disabled and prevents selection.
   *
   * @param disabled {@code true} to disable the tab
   * @return this component
   */
  public Tab setDisabled(boolean disabled) {
    set(disabledProp, disabled);
    return this;
  }

  /**
   * Adds a listener for the close event, fired when the tab is closable and the close button is
   * activated.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<CloseEvent<Tab>> addCloseListener(EventListener<CloseEvent<Tab>> listener) {
    return addEventListener(CloseEvent.class, listener);
  }

  /**
   * Adds a listener for the close event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<CloseEvent<Tab>> onClose(EventListener<CloseEvent<Tab>> listener) {
    return addCloseListener(listener);
  }

  Element getOriginalElement() {
    return getElement();
  }
}
