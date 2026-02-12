package com.webforj.shoelace.components.select;

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
import com.webforj.shoelace.Size;
import com.webforj.shoelace.event.AfterHideEvent;
import com.webforj.shoelace.event.AfterShowEvent;
import com.webforj.shoelace.event.BlurEvent;
import com.webforj.shoelace.event.ChangeEvent;
import com.webforj.shoelace.event.ClearEvent;
import com.webforj.shoelace.event.FocusEvent;
import com.webforj.shoelace.event.HideEvent;
import com.webforj.shoelace.event.InputEvent;
import com.webforj.shoelace.event.InvalidEvent;
import com.webforj.shoelace.event.ShowEvent;

/**
 * Shoelace Select component ({@code <sl-select>}).
 *
 * <p>Selects allow you to choose items from a menu of predefined options. Selects are powered
 * by {@code <sl-option>} elements which must be slotted in the default slot.</p>
 *
 * @see <a href="https://shoelace.style/components/select">Shoelace Select</a>
 */
@NodeName("sl-select")
public final class Select extends ElementCompositeContainer
    implements HasElementClickListener<Select>, HasClassName<Select>, HasStyle<Select>, HasVisibility<Select> {

  private final PropertyDescriptor<String> nameProp =
      PropertyDescriptor.property("name", "");
  private final PropertyDescriptor<String> valueProp =
      PropertyDescriptor.property("value", "");
  private final PropertyDescriptor<Size> sizeProp =
      PropertyDescriptor.property("size", Size.MEDIUM);
  private final PropertyDescriptor<String> placeholderProp =
      PropertyDescriptor.property("placeholder", "");
  private final PropertyDescriptor<Boolean> multipleProp =
      PropertyDescriptor.property("multiple", false);
  private final PropertyDescriptor<Integer> maxOptionsVisibleProp =
      PropertyDescriptor.property("maxOptionsVisible", 3);
  private final PropertyDescriptor<Boolean> disabledProp =
      PropertyDescriptor.property("disabled", false);
  private final PropertyDescriptor<Boolean> clearableProp =
      PropertyDescriptor.property("clearable", false);
  private final PropertyDescriptor<Boolean> openProp =
      PropertyDescriptor.property("open", false);
  private final PropertyDescriptor<Boolean> hoistProp =
      PropertyDescriptor.property("hoist", false);
  private final PropertyDescriptor<Boolean> filledProp =
      PropertyDescriptor.property("filled", false);
  private final PropertyDescriptor<Boolean> pillProp =
      PropertyDescriptor.property("pill", false);
  private final PropertyDescriptor<String> labelProp =
      PropertyDescriptor.property("label", "");
  private final PropertyDescriptor<SelectPlacement> placementProp =
      PropertyDescriptor.property("placement", SelectPlacement.BOTTOM);
  private final PropertyDescriptor<String> helpTextProp =
      PropertyDescriptor.property("helpText", "");
  private final PropertyDescriptor<String> formProp =
      PropertyDescriptor.property("form", "");
  private final PropertyDescriptor<Boolean> requiredProp =
      PropertyDescriptor.property("required", false);

  /**
   * Creates a new Select.
   */
  public Select() {
    super();
  }

  /**
   * Creates a new Select with the given label.
   *
   * @param label the select's label
   */
  public Select(String label) {
    this();
    setLabel(label);
  }

  /**
   * Gets the name of the select.
   *
   * @return the name
   */
  public String getName() {
    return get(nameProp);
  }

  /**
   * Sets the name of the select, submitted as a name/value pair with form data.
   *
   * @param name the name
   * @return this component
   */
  public Select setName(String name) {
    set(nameProp, name);
    return this;
  }

  /**
   * Gets the current value of the select.
   *
   * @return the value
   */
  public String getValue() {
    return get(valueProp);
  }

  /**
   * Sets the current value of the select, submitted as a name/value pair with form data. When
   * {@code multiple} is enabled, the value will be a space-delimited list of values based on the
   * options selected. Values must not contain spaces.
   *
   * @param value the value
   * @return this component
   */
  public Select setValue(String value) {
    set(valueProp, value);
    return this;
  }

  /**
   * Gets the select's size.
   *
   * @return the size
   */
  public Size getSize() {
    return get(sizeProp);
  }

  /**
   * Sets the select's size.
   *
   * @param size the size
   * @return this component
   */
  public Select setSize(Size size) {
    set(sizeProp, size);
    return this;
  }

  /**
   * Gets the placeholder text.
   *
   * @return the placeholder
   */
  public String getPlaceholder() {
    return get(placeholderProp);
  }

  /**
   * Sets placeholder text to show as a hint when the select is empty.
   *
   * @param placeholder the placeholder text
   * @return this component
   */
  public Select setPlaceholder(String placeholder) {
    set(placeholderProp, placeholder);
    return this;
  }

  /**
   * Checks whether multiple selection is enabled.
   *
   * @return {@code true} if multiple selection is allowed
   */
  public boolean isMultiple() {
    return get(multipleProp);
  }

  /**
   * Sets whether more than one option can be selected.
   *
   * @param multiple {@code true} to allow multiple selections
   * @return this component
   */
  public Select setMultiple(boolean multiple) {
    set(multipleProp, multiple);
    return this;
  }

  /**
   * Gets the maximum number of selected options visible.
   *
   * @return the maximum options visible
   */
  public Integer getMaxOptionsVisible() {
    return get(maxOptionsVisibleProp);
  }

  /**
   * Sets the maximum number of selected options to show when {@code multiple} is true. After the
   * maximum, "+n" will be shown to indicate additional selected items. Set to 0 to remove the
   * limit.
   *
   * @param maxOptionsVisible the maximum number of visible options
   * @return this component
   */
  public Select setMaxOptionsVisible(Integer maxOptionsVisible) {
    set(maxOptionsVisibleProp, maxOptionsVisible);
    return this;
  }

  /**
   * Checks whether the select is disabled.
   *
   * @return {@code true} if disabled
   */
  public boolean isDisabled() {
    return get(disabledProp);
  }

  /**
   * Sets whether the select control is disabled.
   *
   * @param disabled {@code true} to disable
   * @return this component
   */
  public Select setDisabled(boolean disabled) {
    set(disabledProp, disabled);
    return this;
  }

  /**
   * Checks whether the clear button is shown.
   *
   * @return {@code true} if clearable
   */
  public boolean isClearable() {
    return get(clearableProp);
  }

  /**
   * Sets whether a clear button is shown when the select is not empty.
   *
   * @param clearable {@code true} to show the clear button
   * @return this component
   */
  public Select setClearable(boolean clearable) {
    set(clearableProp, clearable);
    return this;
  }

  /**
   * Checks whether the select's menu is open.
   *
   * @return {@code true} if open
   */
  public boolean isOpen() {
    return get(openProp);
  }

  /**
   * Sets whether the select's menu is open. You can toggle this attribute to show and hide the
   * menu, or use the {@link #show()} and {@link #hide()} methods.
   *
   * @param open {@code true} to open the menu
   * @return this component
   */
  public Select setOpen(boolean open) {
    set(openProp, open);
    return this;
  }

  /**
   * Checks whether hoisting is enabled.
   *
   * @return {@code true} if hoisting is enabled
   */
  public boolean isHoist() {
    return get(hoistProp);
  }

  /**
   * Sets whether to use a fixed positioning strategy to prevent the listbox from being clipped
   * when the component is placed inside a container with {@code overflow: auto|scroll}.
   *
   * @param hoist {@code true} to enable hoisting
   * @return this component
   */
  public Select setHoist(boolean hoist) {
    set(hoistProp, hoist);
    return this;
  }

  /**
   * Checks whether the select uses filled style.
   *
   * @return {@code true} if filled
   */
  public boolean isFilled() {
    return get(filledProp);
  }

  /**
   * Sets whether the select draws with a filled style.
   *
   * @param filled {@code true} to draw filled
   * @return this component
   */
  public Select setFilled(boolean filled) {
    set(filledProp, filled);
    return this;
  }

  /**
   * Checks whether the select uses pill style.
   *
   * @return {@code true} if pill style is applied
   */
  public boolean isPill() {
    return get(pillProp);
  }

  /**
   * Sets whether the select uses a pill style with rounded edges.
   *
   * @param pill {@code true} to apply pill style
   * @return this component
   */
  public Select setPill(boolean pill) {
    set(pillProp, pill);
    return this;
  }

  /**
   * Gets the select's label.
   *
   * @return the label
   */
  public String getLabel() {
    return get(labelProp);
  }

  /**
   * Sets the select's label. If you need to display HTML, use the label slot instead.
   *
   * @param label the label
   * @return this component
   */
  public Select setLabel(String label) {
    set(labelProp, label);
    return this;
  }

  /**
   * Gets the preferred placement of the select's menu.
   *
   * @return the placement
   */
  public SelectPlacement getPlacement() {
    return get(placementProp);
  }

  /**
   * Sets the preferred placement of the select's menu. The actual placement may vary to keep the
   * listbox inside the viewport.
   *
   * @param placement the placement
   * @return this component
   */
  public Select setPlacement(SelectPlacement placement) {
    set(placementProp, placement);
    return this;
  }

  /**
   * Gets the select's help text.
   *
   * @return the help text
   */
  public String getHelpText() {
    return get(helpTextProp);
  }

  /**
   * Sets the select's help text. If you need to display HTML, use the help-text slot instead.
   *
   * @param helpText the help text
   * @return this component
   */
  public Select setHelpText(String helpText) {
    set(helpTextProp, helpText);
    return this;
  }

  /**
   * Gets the form ID that this control is associated with.
   *
   * @return the form ID
   */
  public String getForm() {
    return get(formProp);
  }

  /**
   * Sets the form ID to associate this control with. The form must be in the same document or
   * shadow root for this to work.
   *
   * @param form the form ID
   * @return this component
   */
  public Select setForm(String form) {
    set(formProp, form);
    return this;
  }

  /**
   * Checks whether the select is required.
   *
   * @return {@code true} if required
   */
  public boolean isRequired() {
    return get(requiredProp);
  }

  /**
   * Sets whether the select is required.
   *
   * @param required {@code true} to require a value
   * @return this component
   */
  public Select setRequired(boolean required) {
    set(requiredProp, required);
    return this;
  }

  /**
   * Shows the select's listbox.
   */
  public void show() {
    getElement().callJsFunction("show");
  }

  /**
   * Hides the select's listbox.
   */
  public void hide() {
    getElement().callJsFunction("hide");
  }

  /**
   * Sets focus on the select control.
   */
  public void focus() {
    getElement().callJsFunction("focus");
  }

  /**
   * Removes focus from the select control.
   */
  public void blur() {
    getElement().callJsFunction("blur");
  }

  /**
   * Checks for validity but does not show a validation message. Returns {@code true} when valid
   * and {@code false} when invalid.
   */
  public void checkValidity() {
    getElement().callJsFunction("checkValidity");
  }

  /**
   * Checks for validity and shows the browser's validation message if the control is invalid.
   */
  public void reportValidity() {
    getElement().callJsFunction("reportValidity");
  }

  /**
   * Sets a custom validation message. Pass an empty string to restore validity.
   *
   * @param message the custom validation message
   */
  public void setCustomValidity(String message) {
    getElement().callJsFunction("setCustomValidity", message);
  }

  /**
   * Adds a listener for the change event, fired when the control's value changes.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ChangeEvent<Select>> addChangeListener(
      EventListener<ChangeEvent<Select>> listener) {
    return addEventListener(ChangeEvent.class, listener);
  }

  /**
   * Adds a listener for the change event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ChangeEvent<Select>> onChange(EventListener<ChangeEvent<Select>> listener) {
    return addChangeListener(listener);
  }

  /**
   * Adds a listener for the clear event, fired when the control's value is cleared.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ClearEvent<Select>> addClearListener(
      EventListener<ClearEvent<Select>> listener) {
    return addEventListener(ClearEvent.class, listener);
  }

  /**
   * Adds a listener for the clear event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ClearEvent<Select>> onClear(EventListener<ClearEvent<Select>> listener) {
    return addClearListener(listener);
  }

  /**
   * Adds a listener for the input event, fired when the control receives input.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<InputEvent<Select>> addInputListener(
      EventListener<InputEvent<Select>> listener) {
    return addEventListener(InputEvent.class, listener);
  }

  /**
   * Adds a listener for the input event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<InputEvent<Select>> onInput(EventListener<InputEvent<Select>> listener) {
    return addInputListener(listener);
  }

  /**
   * Adds a listener for the focus event, fired when the control gains focus.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<FocusEvent<Select>> addFocusListener(
      EventListener<FocusEvent<Select>> listener) {
    return addEventListener(FocusEvent.class, listener);
  }

  /**
   * Adds a listener for the focus event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<FocusEvent<Select>> onFocus(EventListener<FocusEvent<Select>> listener) {
    return addFocusListener(listener);
  }

  /**
   * Adds a listener for the blur event, fired when the control loses focus.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<BlurEvent<Select>> addBlurListener(
      EventListener<BlurEvent<Select>> listener) {
    return addEventListener(BlurEvent.class, listener);
  }

  /**
   * Adds a listener for the blur event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<BlurEvent<Select>> onBlur(EventListener<BlurEvent<Select>> listener) {
    return addBlurListener(listener);
  }

  /**
   * Adds a listener for the show event, fired when the select's menu opens.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ShowEvent<Select>> addShowListener(
      EventListener<ShowEvent<Select>> listener) {
    return addEventListener(ShowEvent.class, listener);
  }

  /**
   * Adds a listener for the show event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ShowEvent<Select>> onShow(EventListener<ShowEvent<Select>> listener) {
    return addShowListener(listener);
  }

  /**
   * Adds a listener for the after-show event, fired after the select's menu opens and all
   * animations are complete.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<AfterShowEvent<Select>> addAfterShowListener(
      EventListener<AfterShowEvent<Select>> listener) {
    return addEventListener(AfterShowEvent.class, listener);
  }

  /**
   * Adds a listener for the after-show event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<AfterShowEvent<Select>> onAfterShow(
      EventListener<AfterShowEvent<Select>> listener) {
    return addAfterShowListener(listener);
  }

  /**
   * Adds a listener for the hide event, fired when the select's menu closes.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<HideEvent<Select>> addHideListener(
      EventListener<HideEvent<Select>> listener) {
    return addEventListener(HideEvent.class, listener);
  }

  /**
   * Adds a listener for the hide event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<HideEvent<Select>> onHide(EventListener<HideEvent<Select>> listener) {
    return addHideListener(listener);
  }

  /**
   * Adds a listener for the after-hide event, fired after the select's menu closes and all
   * animations are complete.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<AfterHideEvent<Select>> addAfterHideListener(
      EventListener<AfterHideEvent<Select>> listener) {
    return addEventListener(AfterHideEvent.class, listener);
  }

  /**
   * Adds a listener for the after-hide event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<AfterHideEvent<Select>> onAfterHide(
      EventListener<AfterHideEvent<Select>> listener) {
    return addAfterHideListener(listener);
  }

  /**
   * Adds a listener for the invalid event, fired when the form control has been checked for
   * validity and its constraints are not satisfied.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<InvalidEvent<Select>> addInvalidListener(
      EventListener<InvalidEvent<Select>> listener) {
    return addEventListener(InvalidEvent.class, listener);
  }

  /**
   * Adds a listener for the invalid event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<InvalidEvent<Select>> onInvalid(EventListener<InvalidEvent<Select>> listener) {
    return addInvalidListener(listener);
  }

  Element getOriginalElement() {
    return getElement();
  }
}
