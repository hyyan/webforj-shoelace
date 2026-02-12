package com.webforj.shoelace.components.mutationobserver;

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
import com.webforj.shoelace.components.mutationobserver.event.MutationEvent;

/**
 * Shoelace Mutation Observer component ({@code <sl-mutation-observer>}).
 *
 * <p>The mutation observer component offers a thin, declarative interface to the
 * {@code MutationObserver API}. It allows you to watch for changes to attributes, child nodes, and
 * character data within slotted elements.</p>
 *
 * @see <a href="https://shoelace.style/components/mutation-observer">Shoelace Mutation Observer</a>
 */
@NodeName("sl-mutation-observer")
public final class MutationObserver extends ElementCompositeContainer
    implements HasElementClickListener<MutationObserver>, HasClassName<MutationObserver>, HasStyle<MutationObserver>,
    HasVisibility<MutationObserver> {

  private final PropertyDescriptor<String> attrProp =
      PropertyDescriptor.property("attr", "");
  private final PropertyDescriptor<Boolean> attrOldValueProp =
      PropertyDescriptor.property("attrOldValue", false);
  private final PropertyDescriptor<Boolean> charDataProp =
      PropertyDescriptor.property("charData", false);
  private final PropertyDescriptor<Boolean> charDataOldValueProp =
      PropertyDescriptor.property("charDataOldValue", false);
  private final PropertyDescriptor<Boolean> childListProp =
      PropertyDescriptor.property("childList", false);
  private final PropertyDescriptor<Boolean> disabledProp =
      PropertyDescriptor.property("disabled", false);

  /**
   * Creates a new MutationObserver.
   */
  public MutationObserver() {
    super();
  }

  /**
   * Gets the attributes to watch for changes. Use {@code *} to watch all attributes.
   *
   * @return the attribute filter string
   */
  public String getAttr() {
    return get(attrProp);
  }

  /**
   * Sets the attributes to watch for changes. To watch only specific attributes, separate them by
   * a space, e.g. {@code "class id title"}. To watch all attributes, use {@code "*"}.
   *
   * @param attr the attribute filter string
   * @return this component
   */
  public MutationObserver setAttr(String attr) {
    set(attrProp, attr);
    return this;
  }

  /**
   * Returns whether the attribute's previous value should be recorded when monitoring changes.
   *
   * @return {@code true} if old attribute values are recorded
   */
  public boolean isAttrOldValue() {
    return get(attrOldValueProp);
  }

  /**
   * Sets whether the attribute's previous value should be recorded when monitoring changes.
   *
   * @param attrOldValue {@code true} to record old attribute values
   * @return this component
   */
  public MutationObserver setAttrOldValue(boolean attrOldValue) {
    set(attrOldValueProp, attrOldValue);
    return this;
  }

  /**
   * Returns whether changes to the character data contained within the node are watched.
   *
   * @return {@code true} if character data changes are watched
   */
  public boolean isCharData() {
    return get(charDataProp);
  }

  /**
   * Sets whether to watch for changes to the character data contained within the node.
   *
   * @param charData {@code true} to watch character data changes
   * @return this component
   */
  public MutationObserver setCharData(boolean charData) {
    set(charDataProp, charData);
    return this;
  }

  /**
   * Returns whether the previous value of the node's text should be recorded.
   *
   * @return {@code true} if old character data values are recorded
   */
  public boolean isCharDataOldValue() {
    return get(charDataOldValueProp);
  }

  /**
   * Sets whether the previous value of the node's text should be recorded.
   *
   * @param charDataOldValue {@code true} to record old character data values
   * @return this component
   */
  public MutationObserver setCharDataOldValue(boolean charDataOldValue) {
    set(charDataOldValueProp, charDataOldValue);
    return this;
  }

  /**
   * Returns whether the addition or removal of new child nodes is watched.
   *
   * @return {@code true} if child list changes are watched
   */
  public boolean isChildList() {
    return get(childListProp);
  }

  /**
   * Sets whether to watch for the addition or removal of new child nodes.
   *
   * @param childList {@code true} to watch child list changes
   * @return this component
   */
  public MutationObserver setChildList(boolean childList) {
    set(childListProp, childList);
    return this;
  }

  /**
   * Returns whether the observer is disabled.
   *
   * @return {@code true} if the observer is disabled
   */
  public boolean isDisabled() {
    return get(disabledProp);
  }

  /**
   * Sets whether the observer is disabled.
   *
   * @param disabled {@code true} to disable the observer
   * @return this component
   */
  public MutationObserver setDisabled(boolean disabled) {
    set(disabledProp, disabled);
    return this;
  }

  /**
   * Adds a listener for the mutation event, fired when a mutation occurs.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<MutationEvent<MutationObserver>> addMutationListener(
      EventListener<MutationEvent<MutationObserver>> listener) {
    return addEventListener(MutationEvent.class, listener);
  }

  /**
   * Adds a listener for the mutation event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<MutationEvent<MutationObserver>> onMutation(
      EventListener<MutationEvent<MutationObserver>> listener) {
    return addMutationListener(listener);
  }

  Element getOriginalElement() {
    return getElement();
  }
}
