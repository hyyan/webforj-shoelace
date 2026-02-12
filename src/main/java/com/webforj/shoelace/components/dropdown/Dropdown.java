package com.webforj.shoelace.components.dropdown;

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
import com.webforj.shoelace.Placement;
import com.webforj.shoelace.event.AfterHideEvent;
import com.webforj.shoelace.event.AfterShowEvent;
import com.webforj.shoelace.event.HideEvent;
import com.webforj.shoelace.event.ShowEvent;

/**
 * Shoelace Dropdown component ({@code <sl-dropdown>}).
 *
 * <p>Dropdowns expose additional content that "drops down" in a panel when the user clicks a
 * trigger element. The panel can contain a menu or other interactive content.</p>
 *
 * @see <a href="https://shoelace.style/components/dropdown">Shoelace Dropdown</a>
 */
@NodeName("sl-dropdown")
public final class Dropdown extends ElementCompositeContainer
    implements HasElementClickListener<Dropdown>, HasClassName<Dropdown>, HasStyle<Dropdown>, HasVisibility<Dropdown> {

  private final PropertyDescriptor<Boolean> openProp =
      PropertyDescriptor.property("open", false);
  private final PropertyDescriptor<Placement> placementProp =
      PropertyDescriptor.property("placement", Placement.BOTTOM_START);
  private final PropertyDescriptor<Boolean> disabledProp =
      PropertyDescriptor.property("disabled", false);
  private final PropertyDescriptor<Boolean> stayOpenOnSelectProp =
      PropertyDescriptor.property("stayOpenOnSelect", false);
  private final PropertyDescriptor<Integer> distanceProp =
      PropertyDescriptor.property("distance", 0);
  private final PropertyDescriptor<Integer> skiddingProp =
      PropertyDescriptor.property("skidding", 0);
  private final PropertyDescriptor<Boolean> hoistProp =
      PropertyDescriptor.property("hoist", false);
  private final PropertyDescriptor<String> syncProp =
      PropertyDescriptor.property("sync", "");

  /**
   * Creates a new Dropdown.
   */
  public Dropdown() {
    super();
  }

  /**
   * Returns whether the dropdown is open.
   *
   * @return {@code true} if the dropdown is open
   */
  public boolean isOpen() {
    return get(openProp);
  }

  /**
   * Sets whether the dropdown is open. You can toggle this attribute to show and hide the
   * dropdown, or you can use the {@link #show()} and {@link #hide()} methods.
   *
   * @param open {@code true} to open the dropdown
   * @return this component
   */
  public Dropdown setOpen(boolean open) {
    set(openProp, open);
    return this;
  }

  /**
   * Gets the preferred placement of the dropdown panel.
   *
   * @return the placement
   */
  public Placement getPlacement() {
    return get(placementProp);
  }

  /**
   * Sets the preferred placement of the dropdown panel. Note that the actual placement may vary as
   * needed to keep the panel inside of the viewport.
   *
   * @param placement the placement
   * @return this component
   */
  public Dropdown setPlacement(Placement placement) {
    set(placementProp, placement);
    return this;
  }

  /**
   * Returns whether the dropdown is disabled.
   *
   * @return {@code true} if the dropdown is disabled
   */
  public boolean isDisabled() {
    return get(disabledProp);
  }

  /**
   * Sets whether the dropdown is disabled so the panel will not open.
   *
   * @param disabled {@code true} to disable the dropdown
   * @return this component
   */
  public Dropdown setDisabled(boolean disabled) {
    set(disabledProp, disabled);
    return this;
  }

  /**
   * Returns whether the dropdown stays open when an item is selected.
   *
   * @return {@code true} if the dropdown stays open on select
   */
  public boolean isStayOpenOnSelect() {
    return get(stayOpenOnSelectProp);
  }

  /**
   * Sets whether the dropdown should stay open when an item is selected. By default, the dropdown
   * is closed when an item is selected. This is useful for dropdowns that allow for multiple
   * interactions.
   *
   * @param stayOpenOnSelect {@code true} to keep open on select
   * @return this component
   */
  public Dropdown setStayOpenOnSelect(boolean stayOpenOnSelect) {
    set(stayOpenOnSelectProp, stayOpenOnSelect);
    return this;
  }

  /**
   * Gets the distance in pixels from which to offset the panel away from its trigger.
   *
   * @return the distance in pixels
   */
  public int getDistance() {
    return get(distanceProp);
  }

  /**
   * Sets the distance in pixels from which to offset the panel away from its trigger.
   *
   * @param distance the distance in pixels
   * @return this component
   */
  public Dropdown setDistance(int distance) {
    set(distanceProp, distance);
    return this;
  }

  /**
   * Gets the distance in pixels from which to offset the panel along its trigger.
   *
   * @return the skidding in pixels
   */
  public int getSkidding() {
    return get(skiddingProp);
  }

  /**
   * Sets the distance in pixels from which to offset the panel along its trigger.
   *
   * @param skidding the skidding in pixels
   * @return this component
   */
  public Dropdown setSkidding(int skidding) {
    set(skiddingProp, skidding);
    return this;
  }

  /**
   * Returns whether hoisting is enabled.
   *
   * @return {@code true} if hoisting is enabled
   */
  public boolean isHoist() {
    return get(hoistProp);
  }

  /**
   * Sets whether to hoist the panel. Enable this option to prevent the panel from being clipped
   * when the component is placed inside a container with {@code overflow: auto|scroll}. Hoisting
   * uses a fixed positioning strategy that works in many, but not all, scenarios.
   *
   * @param hoist {@code true} to enable hoisting
   * @return this component
   */
  public Dropdown setHoist(boolean hoist) {
    set(hoistProp, hoist);
    return this;
  }

  /**
   * Gets the sync mode that syncs the popup width or height to the trigger element.
   *
   * @return the sync value
   */
  public String getSync() {
    return get(syncProp);
  }

  /**
   * Sets the sync mode. Syncs the popup width or height to that of the trigger element.
   *
   * @param sync the sync value (e.g. "width", "height", "both", or empty string for none)
   * @return this component
   */
  public Dropdown setSync(String sync) {
    set(syncProp, sync);
    return this;
  }

  /**
   * Sets the sync mode using a typed enum value.
   *
   * @param sync the sync option
   * @return this component
   */
  public Dropdown setSync(DropdownSync sync) {
    if (sync == null) {
      return setSync("");
    }
    return setSync(sync.name().toLowerCase().replace("_", "-"));
  }

  /**
   * Shows the dropdown panel.
   */
  public void show() {
    getOriginalElement().callJsFunctionVoidAsync("show");
  }

  /**
   * Hides the dropdown panel.
   */
  public void hide() {
    getOriginalElement().callJsFunctionVoidAsync("hide");
  }

  /**
   * Instructs the dropdown menu to reposition. Useful when the position or size of the trigger
   * changes when the menu is activated.
   */
  public void reposition() {
    getOriginalElement().callJsFunctionVoidAsync("reposition");
  }

  /**
   * Adds a listener for the show event, fired when the dropdown opens.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ShowEvent<Dropdown>> addShowListener(EventListener<ShowEvent<Dropdown>> listener) {
    return addEventListener(ShowEvent.class, listener);
  }

  /**
   * Adds a listener for the show event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ShowEvent<Dropdown>> onShow(EventListener<ShowEvent<Dropdown>> listener) {
    return addShowListener(listener);
  }

  /**
   * Adds a listener for the after-show event, fired after the dropdown opens and all animations
   * are complete.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<AfterShowEvent<Dropdown>> addAfterShowListener(
      EventListener<AfterShowEvent<Dropdown>> listener) {
    return addEventListener(AfterShowEvent.class, listener);
  }

  /**
   * Adds a listener for the after-show event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<AfterShowEvent<Dropdown>> onAfterShow(
      EventListener<AfterShowEvent<Dropdown>> listener) {
    return addAfterShowListener(listener);
  }

  /**
   * Adds a listener for the hide event, fired when the dropdown closes.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<HideEvent<Dropdown>> addHideListener(EventListener<HideEvent<Dropdown>> listener) {
    return addEventListener(HideEvent.class, listener);
  }

  /**
   * Adds a listener for the hide event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<HideEvent<Dropdown>> onHide(EventListener<HideEvent<Dropdown>> listener) {
    return addHideListener(listener);
  }

  /**
   * Adds a listener for the after-hide event, fired after the dropdown closes and all animations
   * are complete.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<AfterHideEvent<Dropdown>> addAfterHideListener(
      EventListener<AfterHideEvent<Dropdown>> listener) {
    return addEventListener(AfterHideEvent.class, listener);
  }

  /**
   * Adds a listener for the after-hide event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<AfterHideEvent<Dropdown>> onAfterHide(
      EventListener<AfterHideEvent<Dropdown>> listener) {
    return addAfterHideListener(listener);
  }

  Element getOriginalElement() {
    return getElement();
  }
}
