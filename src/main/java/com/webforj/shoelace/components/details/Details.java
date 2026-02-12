package com.webforj.shoelace.components.details;

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
import com.webforj.shoelace.event.ShowEvent;

/**
 * Shoelace Details component ({@code <sl-details>}).
 *
 * <p>Details show a brief summary and expand to show additional content.</p>
 *
 * @see <a href="https://shoelace.style/components/details">Shoelace Details</a>
 */
@NodeName("sl-details")
public final class Details extends ElementCompositeContainer
    implements HasElementClickListener<Details>, HasClassName<Details>, HasStyle<Details>, HasVisibility<Details> {

  private final PropertyDescriptor<Boolean> openProp =
      PropertyDescriptor.property("open", false);
  private final PropertyDescriptor<String> summaryProp =
      PropertyDescriptor.property("summary", "");
  private final PropertyDescriptor<Boolean> disabledProp =
      PropertyDescriptor.property("disabled", false);

  /**
   * Creates a new Details.
   */
  public Details() {
    super();
  }

  /**
   * Creates a new Details with the given summary text.
   *
   * @param summary the summary text displayed in the header
   */
  public Details(String summary) {
    this();
    setSummary(summary);
  }

  /**
   * Checks whether the details element is open.
   *
   * @return {@code true} if the details element is open, {@code false} otherwise
   */
  public boolean isOpen() {
    return get(openProp);
  }

  /**
   * Sets whether the details element is open.
   *
   * @param open {@code true} to open the details element
   * @return this component
   */
  public Details setOpen(boolean open) {
    set(openProp, open);
    return this;
  }

  /**
   * Gets the summary text displayed in the header.
   *
   * @return the summary text
   */
  public String getSummary() {
    return get(summaryProp);
  }

  /**
   * Sets the summary text displayed in the header. If you need to display HTML, use the
   * {@code summary} slot instead.
   *
   * @param summary the summary text
   * @return this component
   */
  public Details setSummary(String summary) {
    set(summaryProp, summary);
    return this;
  }

  /**
   * Checks whether the details element is disabled.
   *
   * @return {@code true} if the details element is disabled, {@code false} otherwise
   */
  public boolean isDisabled() {
    return get(disabledProp);
  }

  /**
   * Sets whether the details element is disabled so it cannot be toggled.
   *
   * @param disabled {@code true} to disable the details element
   * @return this component
   */
  public Details setDisabled(boolean disabled) {
    set(disabledProp, disabled);
    return this;
  }

  /**
   * Adds content to the summary slot.
   *
   * @param components the components to add to the summary slot
   * @return this component
   */
  public Details addToSummary(Component... components) {
    getElement().add("summary", components);
    return this;
  }

  /**
   * Adds a custom expand icon to the expand-icon slot.
   *
   * @param components the components to add to the expand-icon slot
   * @return this component
   */
  public Details addToExpandIcon(Component... components) {
    getElement().add("expand-icon", components);
    return this;
  }

  /**
   * Adds a custom collapse icon to the collapse-icon slot.
   *
   * @param components the components to add to the collapse-icon slot
   * @return this component
   */
  public Details addToCollapseIcon(Component... components) {
    getElement().add("collapse-icon", components);
    return this;
  }

  /**
   * Shows the details element.
   */
  public void show() {
    getElement().callJsFunctionAsync("show");
  }

  /**
   * Hides the details element.
   */
  public void hide() {
    getElement().callJsFunctionAsync("hide");
  }

  /**
   * Adds a listener for the show event, fired when the details element begins to open.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ShowEvent<Details>> addShowListener(EventListener<ShowEvent<Details>> listener) {
    return addEventListener(ShowEvent.class, listener);
  }

  /**
   * Adds a listener for the show event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ShowEvent<Details>> onShow(EventListener<ShowEvent<Details>> listener) {
    return addShowListener(listener);
  }

  /**
   * Adds a listener for the after-show event, fired after the details element opens and all
   * animations are complete.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<AfterShowEvent<Details>> addAfterShowListener(
      EventListener<AfterShowEvent<Details>> listener) {
    return addEventListener(AfterShowEvent.class, listener);
  }

  /**
   * Adds a listener for the after-show event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<AfterShowEvent<Details>> onAfterShow(
      EventListener<AfterShowEvent<Details>> listener) {
    return addAfterShowListener(listener);
  }

  /**
   * Adds a listener for the hide event, fired when the details element begins to close.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<HideEvent<Details>> addHideListener(EventListener<HideEvent<Details>> listener) {
    return addEventListener(HideEvent.class, listener);
  }

  /**
   * Adds a listener for the hide event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<HideEvent<Details>> onHide(EventListener<HideEvent<Details>> listener) {
    return addHideListener(listener);
  }

  /**
   * Adds a listener for the after-hide event, fired after the details element closes and all
   * animations are complete.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<AfterHideEvent<Details>> addAfterHideListener(
      EventListener<AfterHideEvent<Details>> listener) {
    return addEventListener(AfterHideEvent.class, listener);
  }

  /**
   * Adds a listener for the after-hide event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<AfterHideEvent<Details>> onAfterHide(
      EventListener<AfterHideEvent<Details>> listener) {
    return addAfterHideListener(listener);
  }

  Element getOriginalElement() {
    return getElement();
  }
}
