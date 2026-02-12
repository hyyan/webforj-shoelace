package com.webforj.shoelace.components.tabgroup;

import com.webforj.component.Component;
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
import com.webforj.shoelace.components.tabgroup.event.TabHideEvent;
import com.webforj.shoelace.components.tabgroup.event.TabShowEvent;

/**
 * Shoelace TabGroup component ({@code <sl-tab-group>}).
 *
 * <p>Tab groups organize content into a tabbed interface. Each tab group contains
 * {@code <sl-tab>} elements in the nav slot and {@code <sl-tab-panel>} elements in the default
 * slot.</p>
 *
 * @see <a href="https://shoelace.style/components/tab-group">Shoelace Tab Group</a>
 */
@NodeName("sl-tab-group")
public final class TabGroup extends ElementCompositeContainer
    implements HasElementClickListener<TabGroup>, HasClassName<TabGroup>, HasStyle<TabGroup>, HasVisibility<TabGroup> {

  private static final String NAV_SLOT = "nav";

  private final PropertyDescriptor<Placement> placementProp =
      PropertyDescriptor.property("placement", Placement.TOP);
  private final PropertyDescriptor<Activation> activationProp =
      PropertyDescriptor.property("activation", Activation.AUTO);
  private final PropertyDescriptor<Boolean> noScrollControlsProp =
      PropertyDescriptor.property("noScrollControls", false);
  private final PropertyDescriptor<Boolean> fixedScrollControlsProp =
      PropertyDescriptor.property("fixedScrollControls", false);

  /**
   * Creates a new TabGroup.
   */
  public TabGroup() {
    super();
  }

  /**
   * Gets the placement of the tabs.
   *
   * @return the placement
   */
  public Placement getPlacement() {
    return get(placementProp);
  }

  /**
   * Sets the placement of the tabs.
   *
   * @param placement the placement to set
   * @return this component
   */
  public TabGroup setPlacement(Placement placement) {
    set(placementProp, placement);
    return this;
  }

  /**
   * Gets the activation mode.
   *
   * @return the activation mode
   */
  public Activation getActivation() {
    return get(activationProp);
  }

  /**
   * Sets the activation mode. When set to auto, navigating tabs with the arrow keys will
   * instantly show the corresponding tab panel. When set to manual, the tab will receive focus
   * but will not show until the user presses spacebar or enter.
   *
   * @param activation the activation mode to set
   * @return this component
   */
  public TabGroup setActivation(Activation activation) {
    set(activationProp, activation);
    return this;
  }

  /**
   * Returns whether the scroll arrows are disabled.
   *
   * @return {@code true} if scroll controls are hidden
   */
  public boolean isNoScrollControls() {
    return get(noScrollControlsProp);
  }

  /**
   * Sets whether to disable the scroll arrows that appear when tabs overflow.
   *
   * @param noScrollControls {@code true} to hide scroll controls
   * @return this component
   */
  public TabGroup setNoScrollControls(boolean noScrollControls) {
    set(noScrollControlsProp, noScrollControls);
    return this;
  }

  /**
   * Returns whether the scroll controls are always visible.
   *
   * @return {@code true} if scroll controls are fixed
   */
  public boolean isFixedScrollControls() {
    return get(fixedScrollControlsProp);
  }

  /**
   * Sets whether to prevent scroll buttons from being hidden when inactive.
   *
   * @param fixedScrollControls {@code true} to keep scroll controls visible
   * @return this component
   */
  public TabGroup setFixedScrollControls(boolean fixedScrollControls) {
    set(fixedScrollControlsProp, fixedScrollControls);
    return this;
  }

  /**
   * Adds tabs to the nav slot. Use this method to add {@link com.webforj.shoelace.components.tab.Tab}
   * components to the tab group's navigation area.
   *
   * @param tabs the tab components to add
   * @return this component
   */
  public TabGroup addToNav(Component... tabs) {
    getElement().add(NAV_SLOT, tabs);
    return this;
  }

  /**
   * Shows the specified tab panel.
   *
   * @param panel the name of the panel to show
   */
  public void show(String panel) {
    getOriginalElement().callJsFunctionVoidAsync("show", panel);
  }

  /**
   * Adds a listener for the tab-show event, fired when a tab is shown.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<TabShowEvent<TabGroup>> addTabShowListener(
      EventListener<TabShowEvent<TabGroup>> listener) {
    return addEventListener(TabShowEvent.class, listener);
  }

  /**
   * Adds a listener for the tab-show event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<TabShowEvent<TabGroup>> onTabShow(EventListener<TabShowEvent<TabGroup>> listener) {
    return addTabShowListener(listener);
  }

  /**
   * Adds a listener for the tab-hide event, fired when a tab is hidden.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<TabHideEvent<TabGroup>> addTabHideListener(
      EventListener<TabHideEvent<TabGroup>> listener) {
    return addEventListener(TabHideEvent.class, listener);
  }

  /**
   * Adds a listener for the tab-hide event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<TabHideEvent<TabGroup>> onTabHide(EventListener<TabHideEvent<TabGroup>> listener) {
    return addTabHideListener(listener);
  }

  Element getOriginalElement() {
    return getElement();
  }
}
