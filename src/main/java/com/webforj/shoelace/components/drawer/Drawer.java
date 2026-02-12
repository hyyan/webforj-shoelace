package com.webforj.shoelace.components.drawer;

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
import com.webforj.shoelace.event.AfterHideEvent;
import com.webforj.shoelace.event.AfterShowEvent;
import com.webforj.shoelace.event.HideEvent;
import com.webforj.shoelace.event.InitialFocusEvent;
import com.webforj.shoelace.event.RequestCloseEvent;
import com.webforj.shoelace.event.ShowEvent;

/**
 * Shoelace Drawer component ({@code <sl-drawer>}).
 *
 * <p>Drawers slide in from a container to expose additional options and information. They are
 * commonly used as side panels that slide out from the edge of the viewport.</p>
 *
 * @see <a href="https://shoelace.style/components/drawer">Shoelace Drawer</a>
 */
@NodeName("sl-drawer")
public final class Drawer extends ElementCompositeContainer
    implements HasElementClickListener<Drawer>, HasClassName<Drawer>, HasStyle<Drawer>, HasVisibility<Drawer> {

  private final PropertyDescriptor<Boolean> openProp =
      PropertyDescriptor.property("open", false);
  private final PropertyDescriptor<String> labelProp =
      PropertyDescriptor.property("label", "");
  private final PropertyDescriptor<DrawerPlacement> placementProp =
      PropertyDescriptor.property("placement", DrawerPlacement.END);
  private final PropertyDescriptor<Boolean> containedProp =
      PropertyDescriptor.property("contained", false);
  private final PropertyDescriptor<Boolean> noHeaderProp =
      PropertyDescriptor.property("noHeader", false);

  /**
   * Creates a new Drawer.
   */
  public Drawer() {
    super();
  }

  /**
   * Creates a new Drawer with the given label.
   *
   * @param label the drawer's label as displayed in the header
   */
  public Drawer(String label) {
    this();
    setLabel(label);
  }

  /**
   * Checks whether the drawer is open.
   *
   * @return {@code true} if the drawer is open, {@code false} otherwise
   */
  public boolean isOpen() {
    return get(openProp);
  }

  /**
   * Sets whether the drawer is open. You can toggle this to show and hide the drawer, or use the
   * {@link #show()} and {@link #hide()} methods.
   *
   * @param open {@code true} to open the drawer
   * @return this component
   */
  public Drawer setOpen(boolean open) {
    set(openProp, open);
    return this;
  }

  /**
   * Gets the drawer's label as displayed in the header.
   *
   * @return the label text
   */
  public String getLabel() {
    return get(labelProp);
  }

  /**
   * Sets the drawer's label as displayed in the header. You should always include a relevant label
   * even when using {@code noHeader}, as it is required for proper accessibility. If you need to
   * display HTML, use the {@code label} slot instead.
   *
   * @param label the label text
   * @return this component
   */
  public Drawer setLabel(String label) {
    set(labelProp, label);
    return this;
  }

  /**
   * Gets the direction from which the drawer will open.
   *
   * @return the drawer placement
   */
  public DrawerPlacement getPlacement() {
    return get(placementProp);
  }

  /**
   * Sets the direction from which the drawer will open.
   *
   * @param placement the drawer placement
   * @return this component
   */
  public Drawer setPlacement(DrawerPlacement placement) {
    set(placementProp, placement);
    return this;
  }

  /**
   * Checks whether the drawer is contained within its parent element.
   *
   * @return {@code true} if the drawer is contained, {@code false} otherwise
   */
  public boolean isContained() {
    return get(containedProp);
  }

  /**
   * Sets whether the drawer slides out of its parent element instead of the viewport. When
   * enabled, add {@code position: relative} to the parent element.
   *
   * @param contained {@code true} to contain the drawer within its parent
   * @return this component
   */
  public Drawer setContained(boolean contained) {
    set(containedProp, contained);
    return this;
  }

  /**
   * Checks whether the header is hidden.
   *
   * @return {@code true} if the header is hidden, {@code false} otherwise
   */
  public boolean isNoHeader() {
    return get(noHeaderProp);
  }

  /**
   * Sets whether the header is hidden. This will also remove the default close button, so please
   * ensure you provide an easy, accessible way for users to dismiss the drawer.
   *
   * @param noHeader {@code true} to hide the header
   * @return this component
   */
  public Drawer setNoHeader(boolean noHeader) {
    set(noHeaderProp, noHeader);
    return this;
  }

  /**
   * Adds content to the label slot.
   *
   * @param components the components to add to the label slot
   * @return this component
   */
  public Drawer addToLabel(Component... components) {
    getElement().add("label", components);
    return this;
  }

  /**
   * Adds content to the header-actions slot.
   *
   * @param components the components to add to the header-actions slot
   * @return this component
   */
  public Drawer addToHeaderActions(Component... components) {
    getElement().add("header-actions", components);
    return this;
  }

  /**
   * Adds content to the footer slot.
   *
   * @param components the components to add to the footer slot
   * @return this component
   */
  public Drawer addToFooter(Component... components) {
    getElement().add("footer", components);
    return this;
  }

  /**
   * Shows the drawer.
   */
  public void show() {
    getElement().executeJsVoidAsync("document.body.appendChild(component)");
    getElement().callJsFunctionAsync("show");
  }

  /**
   * Hides the drawer.
   */
  public void hide() {
    getElement().callJsFunctionAsync("hide");
  }

  /**
   * Sets the preferred size of the drawer. This will be applied to the drawer's width or height
   * depending on its placement.
   *
   * @param value the CSS size value
   * @return this component
   */
  public Drawer setDrawerSize(String value) {
    setStyle("--size", value);
    return this;
  }

  /**
   * Sets the amount of padding to use for the header.
   *
   * @param value the CSS padding value
   * @return this component
   */
  public Drawer setHeaderSpacing(String value) {
    setStyle("--header-spacing", value);
    return this;
  }

  /**
   * Sets the amount of padding to use for the body.
   *
   * @param value the CSS padding value
   * @return this component
   */
  public Drawer setBodySpacing(String value) {
    setStyle("--body-spacing", value);
    return this;
  }

  /**
   * Sets the amount of padding to use for the footer.
   *
   * @param value the CSS padding value
   * @return this component
   */
  public Drawer setFooterSpacing(String value) {
    setStyle("--footer-spacing", value);
    return this;
  }

  /**
   * Adds a listener for the show event, fired when the drawer begins to open.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ShowEvent<Drawer>> addShowListener(EventListener<ShowEvent<Drawer>> listener) {
    return addEventListener(ShowEvent.class, listener);
  }

  /**
   * Adds a listener for the show event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ShowEvent<Drawer>> onShow(EventListener<ShowEvent<Drawer>> listener) {
    return addShowListener(listener);
  }

  /**
   * Adds a listener for the after-show event, fired after the drawer opens and all animations
   * are complete.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<AfterShowEvent<Drawer>> addAfterShowListener(
      EventListener<AfterShowEvent<Drawer>> listener) {
    return addEventListener(AfterShowEvent.class, listener);
  }

  /**
   * Adds a listener for the after-show event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<AfterShowEvent<Drawer>> onAfterShow(
      EventListener<AfterShowEvent<Drawer>> listener) {
    return addAfterShowListener(listener);
  }

  /**
   * Adds a listener for the hide event, fired when the drawer begins to close.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<HideEvent<Drawer>> addHideListener(EventListener<HideEvent<Drawer>> listener) {
    return addEventListener(HideEvent.class, listener);
  }

  /**
   * Adds a listener for the hide event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<HideEvent<Drawer>> onHide(EventListener<HideEvent<Drawer>> listener) {
    return addHideListener(listener);
  }

  /**
   * Adds a listener for the after-hide event, fired after the drawer closes and all animations
   * are complete.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<AfterHideEvent<Drawer>> addAfterHideListener(
      EventListener<AfterHideEvent<Drawer>> listener) {
    return addEventListener(AfterHideEvent.class, listener);
  }

  /**
   * Adds a listener for the after-hide event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<AfterHideEvent<Drawer>> onAfterHide(
      EventListener<AfterHideEvent<Drawer>> listener) {
    return addAfterHideListener(listener);
  }

  /**
   * Adds a listener for the initial-focus event, fired when the drawer opens and is ready to
   * receive focus.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<InitialFocusEvent<Drawer>> addInitialFocusListener(
      EventListener<InitialFocusEvent<Drawer>> listener) {
    return addEventListener(InitialFocusEvent.class, listener);
  }

  /**
   * Adds a listener for the initial-focus event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<InitialFocusEvent<Drawer>> onInitialFocus(
      EventListener<InitialFocusEvent<Drawer>> listener) {
    return addInitialFocusListener(listener);
  }

  /**
   * Adds a listener for the request-close event, fired when the user attempts to close the drawer
   * by clicking the close button, clicking the overlay, or pressing escape.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<RequestCloseEvent<Drawer>> addRequestCloseListener(
      EventListener<RequestCloseEvent<Drawer>> listener) {
    return addEventListener(RequestCloseEvent.class, listener);
  }

  /**
   * Adds a listener for the request-close event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<RequestCloseEvent<Drawer>> onRequestClose(
      EventListener<RequestCloseEvent<Drawer>> listener) {
    return addRequestCloseListener(listener);
  }

  Element getOriginalElement() {
    return getElement();
  }
}
