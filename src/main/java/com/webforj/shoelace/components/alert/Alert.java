package com.webforj.shoelace.components.alert;

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
import com.webforj.shoelace.event.ShowEvent;

/**
 * Shoelace Alert component ({@code <sl-alert>}).
 *
 * <p>Alerts are used to display important messages inline or as toast notifications. They can be
 * configured with different variants, durations, and countdown indicators.</p>
 *
 * @see <a href="https://shoelace.style/components/alert">Shoelace Alert</a>
 */
@NodeName("sl-alert")
public final class Alert extends ElementCompositeContainer
    implements HasElementClickListener<Alert>, HasClassName<Alert>, HasStyle<Alert>, HasVisibility<Alert> {

  private final PropertyDescriptor<Boolean> openProp =
      PropertyDescriptor.property("open", false);
  private final PropertyDescriptor<Boolean> closableProp =
      PropertyDescriptor.property("closable", false);
  private final PropertyDescriptor<AlertVariant> variantProp =
      PropertyDescriptor.property("variant", AlertVariant.PRIMARY);
  private final PropertyDescriptor<String> durationProp =
      PropertyDescriptor.property("duration", "Infinity");
  private final PropertyDescriptor<AlertCountdown> countdownProp =
      PropertyDescriptor.property("countdown", AlertCountdown.RTL);

  /**
   * Creates a new Alert.
   */
  public Alert() {
    super();
  }

  /**
   * Returns whether the alert is open.
   *
   * @return {@code true} if the alert is open
   */
  public boolean isOpen() {
    return get(openProp);
  }

  /**
   * Sets whether the alert is open. You can toggle this to show and hide the alert, or use the
   * {@link #show()} and {@link #hide()} methods.
   *
   * @param open {@code true} to open the alert
   * @return this component
   */
  public Alert setOpen(boolean open) {
    set(openProp, open);
    return this;
  }

  /**
   * Returns whether the alert has a close button.
   *
   * @return {@code true} if the alert is closable
   */
  public boolean isClosable() {
    return get(closableProp);
  }

  /**
   * Sets whether a close button is displayed that allows the user to dismiss the alert.
   *
   * @param closable {@code true} to show a close button
   * @return this component
   */
  public Alert setClosable(boolean closable) {
    set(closableProp, closable);
    return this;
  }

  /**
   * Gets the alert's theme variant.
   *
   * @return the variant
   */
  public AlertVariant getVariant() {
    return get(variantProp);
  }

  /**
   * Sets the alert's theme variant.
   *
   * @param variant the variant to set
   * @return this component
   */
  public Alert setVariant(AlertVariant variant) {
    set(variantProp, variant);
    return this;
  }

  /**
   * Gets the duration in milliseconds before the alert auto-closes.
   *
   * @return the duration string
   */
  public String getDuration() {
    return get(durationProp);
  }

  /**
   * Sets the length of time, in milliseconds, the alert will show before closing itself. If the
   * user interacts with the alert before it closes (e.g. moves the mouse over it), the timer will
   * restart. Defaults to {@code Infinity}, meaning the alert will not close on its own.
   *
   * @param duration the duration in milliseconds
   * @return this component
   */
  public Alert setDuration(String duration) {
    set(durationProp, duration);
    return this;
  }

  /**
   * Gets the countdown direction.
   *
   * @return the countdown direction, or {@code null} if not set
   */
  public AlertCountdown getCountdown() {
    return get(countdownProp);
  }

  /**
   * Sets the countdown direction that indicates the remaining time the alert will be displayed.
   * Typically used to indicate the remaining time before a whole app refresh.
   *
   * @param countdown the countdown direction
   * @return this component
   */
  public Alert setCountdown(AlertCountdown countdown) {
    set(countdownProp, countdown);
    return this;
  }

  /**
   * Shows the alert.
   */
  public void show() {
    getOriginalElement().callJsFunctionVoidAsync("show");
  }

  /**
   * Hides the alert.
   */
  public void hide() {
    getOriginalElement().callJsFunctionVoidAsync("hide");
  }

  /**
   * Displays the alert as a toast notification. This will move the alert out of its position in
   * the DOM and, when dismissed, it will be removed from the DOM completely. By storing a reference
   * to the alert, you can reuse it by calling this method again.
   */
  public void toast() {
    getOriginalElement().callJsFunctionVoidAsync("toast");
  }

  /**
   * Adds a listener for the show event, fired when the alert opens.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ShowEvent<Alert>> addShowListener(EventListener<ShowEvent<Alert>> listener) {
    return addEventListener(ShowEvent.class, listener);
  }

  /**
   * Adds a listener for the show event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ShowEvent<Alert>> onShow(EventListener<ShowEvent<Alert>> listener) {
    return addShowListener(listener);
  }

  /**
   * Adds a listener for the after-show event, fired after the alert opens and all animations are
   * complete.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<AfterShowEvent<Alert>> addAfterShowListener(
      EventListener<AfterShowEvent<Alert>> listener) {
    return addEventListener(AfterShowEvent.class, listener);
  }

  /**
   * Adds a listener for the after-show event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<AfterShowEvent<Alert>> onAfterShow(
      EventListener<AfterShowEvent<Alert>> listener) {
    return addAfterShowListener(listener);
  }

  /**
   * Adds a listener for the hide event, fired when the alert closes.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<HideEvent<Alert>> addHideListener(EventListener<HideEvent<Alert>> listener) {
    return addEventListener(HideEvent.class, listener);
  }

  /**
   * Adds a listener for the hide event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<HideEvent<Alert>> onHide(EventListener<HideEvent<Alert>> listener) {
    return addHideListener(listener);
  }

  /**
   * Adds a listener for the after-hide event, fired after the alert closes and all animations are
   * complete.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<AfterHideEvent<Alert>> addAfterHideListener(
      EventListener<AfterHideEvent<Alert>> listener) {
    return addEventListener(AfterHideEvent.class, listener);
  }

  /**
   * Adds a listener for the after-hide event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<AfterHideEvent<Alert>> onAfterHide(
      EventListener<AfterHideEvent<Alert>> listener) {
    return addAfterHideListener(listener);
  }

  Element getOriginalElement() {
    return getElement();
  }
}
