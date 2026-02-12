package com.webforj.shoelace.components.dialog;

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
 * Shoelace Dialog component ({@code <sl-dialog>}).
 *
 * <p>Dialogs, sometimes called "modals", appear above the page and require the user's immediate
 * attention. They are used to confirm actions, display information, or collect input.</p>
 *
 * @see <a href="https://shoelace.style/components/dialog">Shoelace Dialog</a>
 */
@NodeName("sl-dialog")
public final class Dialog extends ElementCompositeContainer
    implements HasElementClickListener<Dialog>, HasClassName<Dialog>, HasStyle<Dialog>, HasVisibility<Dialog> {

  private final PropertyDescriptor<Boolean> openProp =
      PropertyDescriptor.property("open", false);
  private final PropertyDescriptor<String> labelProp =
      PropertyDescriptor.property("label", "");
  private final PropertyDescriptor<Boolean> noHeaderProp =
      PropertyDescriptor.property("noHeader", false);

  /**
   * Creates a new Dialog.
   */
  public Dialog() {
    super();
  }

  /**
   * Creates a new Dialog with the given label.
   *
   * @param label the dialog's label as displayed in the header
   */
  public Dialog(String label) {
    this();
    setLabel(label);
  }

  /**
   * Checks whether the dialog is open.
   *
   * @return {@code true} if the dialog is open, {@code false} otherwise
   */
  public boolean isOpen() {
    return get(openProp);
  }

  /**
   * Sets whether the dialog is open. You can toggle this to show and hide the dialog, or use the
   * {@link #show()} and {@link #hide()} methods.
   *
   * @param open {@code true} to open the dialog
   * @return this component
   */
  public Dialog setOpen(boolean open) {
    set(openProp, open);
    return this;
  }

  /**
   * Gets the dialog's label as displayed in the header.
   *
   * @return the label text
   */
  public String getLabel() {
    return get(labelProp);
  }

  /**
   * Sets the dialog's label as displayed in the header. You should always include a relevant label
   * even when using {@code noHeader}, as it is required for proper accessibility. If you need to
   * display HTML, use the {@code label} slot instead.
   *
   * @param label the label text
   * @return this component
   */
  public Dialog setLabel(String label) {
    set(labelProp, label);
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
   * ensure you provide an easy, accessible way for users to dismiss the dialog.
   *
   * @param noHeader {@code true} to hide the header
   * @return this component
   */
  public Dialog setNoHeader(boolean noHeader) {
    set(noHeaderProp, noHeader);
    return this;
  }

  /**
   * Adds content to the label slot.
   *
   * @param components the components to add to the label slot
   * @return this component
   */
  public Dialog addToLabel(Component... components) {
    getElement().add("label", components);
    return this;
  }

  /**
   * Adds content to the header-actions slot.
   *
   * @param components the components to add to the header-actions slot
   * @return this component
   */
  public Dialog addToHeaderActions(Component... components) {
    getElement().add("header-actions", components);
    return this;
  }

  /**
   * Adds content to the footer slot.
   *
   * @param components the components to add to the footer slot
   * @return this component
   */
  public Dialog addToFooter(Component... components) {
    getElement().add("footer", components);
    return this;
  }

  /**
   * Shows the dialog.
   */
  public void show() {
    getElement().executeJsVoidAsync("document.body.appendChild(component)");
    getElement().callJsFunctionAsync("show");
  }

  /**
   * Hides the dialog.
   */
  public void hide() {
    getElement().callJsFunctionAsync("hide");
  }

  /**
   * Sets the preferred width of the dialog. Note that the dialog will shrink to accommodate
   * smaller screens.
   *
   * @param value the CSS width value
   * @return this component
   */
  public Dialog setDialogWidth(String value) {
    setStyle("--width", value);
    return this;
  }

  /**
   * Sets the amount of padding to use for the header.
   *
   * @param value the CSS padding value
   * @return this component
   */
  public Dialog setHeaderSpacing(String value) {
    setStyle("--header-spacing", value);
    return this;
  }

  /**
   * Sets the amount of padding to use for the body.
   *
   * @param value the CSS padding value
   * @return this component
   */
  public Dialog setBodySpacing(String value) {
    setStyle("--body-spacing", value);
    return this;
  }

  /**
   * Sets the amount of padding to use for the footer.
   *
   * @param value the CSS padding value
   * @return this component
   */
  public Dialog setFooterSpacing(String value) {
    setStyle("--footer-spacing", value);
    return this;
  }

  /**
   * Adds a listener for the show event, fired when the dialog begins to open.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ShowEvent<Dialog>> addShowListener(EventListener<ShowEvent<Dialog>> listener) {
    return addEventListener(ShowEvent.class, listener);
  }

  /**
   * Adds a listener for the show event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ShowEvent<Dialog>> onShow(EventListener<ShowEvent<Dialog>> listener) {
    return addShowListener(listener);
  }

  /**
   * Adds a listener for the after-show event, fired after the dialog opens and all animations
   * are complete.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<AfterShowEvent<Dialog>> addAfterShowListener(
      EventListener<AfterShowEvent<Dialog>> listener) {
    return addEventListener(AfterShowEvent.class, listener);
  }

  /**
   * Adds a listener for the after-show event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<AfterShowEvent<Dialog>> onAfterShow(
      EventListener<AfterShowEvent<Dialog>> listener) {
    return addAfterShowListener(listener);
  }

  /**
   * Adds a listener for the hide event, fired when the dialog begins to close.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<HideEvent<Dialog>> addHideListener(EventListener<HideEvent<Dialog>> listener) {
    return addEventListener(HideEvent.class, listener);
  }

  /**
   * Adds a listener for the hide event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<HideEvent<Dialog>> onHide(EventListener<HideEvent<Dialog>> listener) {
    return addHideListener(listener);
  }

  /**
   * Adds a listener for the after-hide event, fired after the dialog closes and all animations
   * are complete.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<AfterHideEvent<Dialog>> addAfterHideListener(
      EventListener<AfterHideEvent<Dialog>> listener) {
    return addEventListener(AfterHideEvent.class, listener);
  }

  /**
   * Adds a listener for the after-hide event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<AfterHideEvent<Dialog>> onAfterHide(
      EventListener<AfterHideEvent<Dialog>> listener) {
    return addAfterHideListener(listener);
  }

  /**
   * Adds a listener for the initial-focus event, fired when the dialog opens and is ready to
   * receive focus.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<InitialFocusEvent<Dialog>> addInitialFocusListener(
      EventListener<InitialFocusEvent<Dialog>> listener) {
    return addEventListener(InitialFocusEvent.class, listener);
  }

  /**
   * Adds a listener for the initial-focus event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<InitialFocusEvent<Dialog>> onInitialFocus(
      EventListener<InitialFocusEvent<Dialog>> listener) {
    return addInitialFocusListener(listener);
  }

  /**
   * Adds a listener for the request-close event, fired when the user attempts to close the dialog
   * by clicking the close button, clicking the overlay, or pressing escape.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<RequestCloseEvent<Dialog>> addRequestCloseListener(
      EventListener<RequestCloseEvent<Dialog>> listener) {
    return addEventListener(RequestCloseEvent.class, listener);
  }

  /**
   * Adds a listener for the request-close event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<RequestCloseEvent<Dialog>> onRequestClose(
      EventListener<RequestCloseEvent<Dialog>> listener) {
    return addRequestCloseListener(listener);
  }

  Element getOriginalElement() {
    return getElement();
  }
}
