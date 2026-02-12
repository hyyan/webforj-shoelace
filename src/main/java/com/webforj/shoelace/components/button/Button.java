package com.webforj.shoelace.components.button;

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
import com.webforj.shoelace.Size;
import com.webforj.shoelace.event.BlurEvent;
import com.webforj.shoelace.event.FocusEvent;
import com.webforj.shoelace.event.InvalidEvent;

/**
 * Shoelace Button component ({@code <sl-button>}).
 *
 * <p>Buttons represent actions that are available to the user. They support several variants,
 * sizes, and states, and can contain prefix and suffix icons.</p>
 *
 * @see <a href="https://shoelace.style/components/button">Shoelace Button</a>
 */
@NodeName("sl-button")
public final class Button extends ElementCompositeContainer
    implements HasElementClickListener<Button>, HasClassName<Button>, HasStyle<Button>, HasVisibility<Button> {

  // Slot constants
  private static final String PREFIX_SLOT = "prefix";
  private static final String SUFFIX_SLOT = "suffix";

  // Property descriptors
  private final PropertyDescriptor<Variant> variantProp =
      PropertyDescriptor.property("variant", Variant.DEFAULT);
  private final PropertyDescriptor<Size> sizeProp =
      PropertyDescriptor.property("size", Size.MEDIUM);
  private final PropertyDescriptor<Boolean> caretProp =
      PropertyDescriptor.property("caret", false);
  private final PropertyDescriptor<Boolean> disabledProp =
      PropertyDescriptor.property("disabled", false);
  private final PropertyDescriptor<Boolean> loadingProp =
      PropertyDescriptor.property("loading", false);
  private final PropertyDescriptor<Boolean> outlineProp =
      PropertyDescriptor.property("outline", false);
  private final PropertyDescriptor<Boolean> pillProp =
      PropertyDescriptor.property("pill", false);
  private final PropertyDescriptor<Boolean> circleProp =
      PropertyDescriptor.property("circle", false);
  private final PropertyDescriptor<ButtonType> typeProp =
      PropertyDescriptor.property("type", ButtonType.BUTTON);
  private final PropertyDescriptor<String> nameProp =
      PropertyDescriptor.property("name", "");
  private final PropertyDescriptor<String> valueProp =
      PropertyDescriptor.property("value", "");
  private final PropertyDescriptor<String> hrefProp =
      PropertyDescriptor.property("href", "");
  private final PropertyDescriptor<Target> targetProp =
      PropertyDescriptor.property("target", Target.SELF);
  private final PropertyDescriptor<String> relProp =
      PropertyDescriptor.property("rel", "noreferrer noopener");
  private final PropertyDescriptor<String> downloadProp =
      PropertyDescriptor.property("download", "");
  private final PropertyDescriptor<String> formProp =
      PropertyDescriptor.property("form", "");
  private final PropertyDescriptor<String> formActionProp =
      PropertyDescriptor.property("formAction", "");
  private final PropertyDescriptor<Boolean> formNoValidateProp =
      PropertyDescriptor.property("formNoValidate", false);

  /**
   * Creates a new Button.
   */
  public Button() {
    super();
  }

  /**
   * Creates a new Button with the given text.
   *
   * @param text the button label text
   */
  public Button(String text) {
    this();
    setText(text);
  }

  /**
   * Creates a new Button with the given text and variant.
   *
   * @param text the button label text
   * @param variant the button variant
   */
  public Button(String text, Variant variant) {
    this();
    setText(text);
    setVariant(variant);
  }

  /**
   * Gets the button's theme variant.
   *
   * @return the variant
   */
  public Variant getVariant() {
    return get(variantProp);
  }

  /**
   * Sets the button's theme variant.
   *
   * @param variant the variant
   * @return this component
   */
  public Button setVariant(Variant variant) {
    set(variantProp, variant);
    return this;
  }

  /**
   * Gets the button's size.
   *
   * @return the size
   */
  public Size getSize() {
    return get(sizeProp);
  }

  /**
   * Sets the button's size.
   *
   * @param size the size
   * @return this component
   */
  public Button setSize(Size size) {
    set(sizeProp, size);
    return this;
  }

  /**
   * Gets whether the button draws a caret.
   *
   * @return {@code true} if the caret is shown
   */
  public boolean isCaret() {
    return get(caretProp);
  }

  /**
   * Sets whether to draw the button with a caret. Used to indicate that the button triggers a
   * dropdown menu or similar behavior.
   *
   * @param caret {@code true} to show the caret
   * @return this component
   */
  public Button setCaret(boolean caret) {
    set(caretProp, caret);
    return this;
  }

  /**
   * Gets whether the button is disabled.
   *
   * @return {@code true} if the button is disabled
   */
  public boolean isDisabled() {
    return get(disabledProp);
  }

  /**
   * Sets whether the button is disabled.
   *
   * @param disabled {@code true} to disable the button
   * @return this component
   */
  public Button setDisabled(boolean disabled) {
    set(disabledProp, disabled);
    return this;
  }

  /**
   * Gets whether the button is in a loading state.
   *
   * @return {@code true} if the button is loading
   */
  public boolean isLoading() {
    return get(loadingProp);
  }

  /**
   * Sets whether to draw the button in a loading state.
   *
   * @param loading {@code true} to show loading state
   * @return this component
   */
  public Button setLoading(boolean loading) {
    set(loadingProp, loading);
    return this;
  }

  /**
   * Gets whether the button is outlined.
   *
   * @return {@code true} if the button is outlined
   */
  public boolean isOutline() {
    return get(outlineProp);
  }

  /**
   * Sets whether to draw an outlined button.
   *
   * @param outline {@code true} to draw an outlined button
   * @return this component
   */
  public Button setOutline(boolean outline) {
    set(outlineProp, outline);
    return this;
  }

  /**
   * Gets whether the button is pill-style.
   *
   * @return {@code true} if the button is pill-style
   */
  public boolean isPill() {
    return get(pillProp);
  }

  /**
   * Sets whether to draw a pill-style button with rounded edges.
   *
   * @param pill {@code true} to draw a pill-style button
   * @return this component
   */
  public Button setPill(boolean pill) {
    set(pillProp, pill);
    return this;
  }

  /**
   * Gets whether the button is circular.
   *
   * @return {@code true} if the button is circular
   */
  public boolean isCircle() {
    return get(circleProp);
  }

  /**
   * Sets whether to draw a circular icon button.
   *
   * @param circle {@code true} to draw a circular button
   * @return this component
   */
  public Button setCircle(boolean circle) {
    set(circleProp, circle);
    return this;
  }

  /**
   * Gets the type of button.
   *
   * @return the button type
   */
  public ButtonType getType() {
    return get(typeProp);
  }

  /**
   * Sets the type of button. Note that the default value is {@code button} instead of
   * {@code submit}, which is opposite of how native {@code <button>} elements behave. When the
   * type is {@code submit}, the button will submit the surrounding form.
   *
   * @param type the button type
   * @return this component
   */
  public Button setType(ButtonType type) {
    set(typeProp, type);
    return this;
  }

  /**
   * Gets the name of the button.
   *
   * @return the name
   */
  public String getName() {
    return get(nameProp);
  }

  /**
   * Sets the name of the button, submitted as a name/value pair with form data.
   *
   * @param name the name
   * @return this component
   */
  public Button setName(String name) {
    set(nameProp, name);
    return this;
  }

  /**
   * Gets the value of the button.
   *
   * @return the value
   */
  public String getValue() {
    return get(valueProp);
  }

  /**
   * Sets the value of the button, submitted as a pair with the button's name as part of the form
   * data.
   *
   * @param value the value
   * @return this component
   */
  public Button setValue(String value) {
    set(valueProp, value);
    return this;
  }

  /**
   * Gets the href URL.
   *
   * @return the href URL
   */
  public String getHref() {
    return get(hrefProp);
  }

  /**
   * Sets the href URL. When set, the underlying button will be rendered as an {@code <a>} with
   * this href instead of a {@code <button>}.
   *
   * @param href the href URL
   * @return this component
   */
  public Button setHref(String href) {
    set(hrefProp, href);
    return this;
  }

  /**
   * Gets the link target.
   *
   * @return the target
   */
  public Target getTarget() {
    return get(targetProp);
  }

  /**
   * Sets the link target. Tells the browser where to open the link. Only used when {@code href} is
   * present.
   *
   * @param target the target
   * @return this component
   */
  public Button setTarget(Target target) {
    set(targetProp, target);
    return this;
  }

  /**
   * Gets the rel attribute.
   *
   * @return the rel attribute value
   */
  public String getRel() {
    return get(relProp);
  }

  /**
   * Sets the rel attribute for the underlying link. Only used when {@code href} is present. The
   * default is {@code noreferrer noopener} to prevent security exploits.
   *
   * @param rel the rel attribute value
   * @return this component
   */
  public Button setRel(String rel) {
    set(relProp, rel);
    return this;
  }

  /**
   * Gets the download filename.
   *
   * @return the download filename
   */
  public String getDownload() {
    return get(downloadProp);
  }

  /**
   * Sets the download filename. Tells the browser to download the linked file as this filename.
   * Only used when {@code href} is present.
   *
   * @param download the download filename
   * @return this component
   */
  public Button setDownload(String download) {
    set(downloadProp, download);
    return this;
  }

  /**
   * Gets the form owner ID.
   *
   * @return the form owner ID
   */
  public String getForm() {
    return get(formProp);
  }

  /**
   * Sets the form owner ID. If omitted, the closest containing form will be used instead. The
   * value of this attribute must be an ID of a form in the same document or shadow root as the
   * button.
   *
   * @param form the form owner ID
   * @return this component
   */
  public Button setForm(String form) {
    set(formProp, form);
    return this;
  }

  /**
   * Gets the form action override.
   *
   * @return the form action URL
   */
  public String getFormAction() {
    return get(formActionProp);
  }

  /**
   * Sets the form action override. Used to override the form owner's {@code action} attribute.
   *
   * @param formAction the form action URL
   * @return this component
   */
  public Button setFormAction(String formAction) {
    set(formActionProp, formAction);
    return this;
  }

  /**
   * Gets whether form validation is skipped on submit.
   *
   * @return {@code true} if form validation is skipped
   */
  public boolean isFormNoValidate() {
    return get(formNoValidateProp);
  }

  /**
   * Sets whether to skip form validation on submit. Used to override the form owner's
   * {@code novalidate} attribute.
   *
   * @param formNoValidate {@code true} to skip form validation
   * @return this component
   */
  public Button setFormNoValidate(boolean formNoValidate) {
    set(formNoValidateProp, formNoValidate);
    return this;
  }

  /**
   * Sets the button's text content.
   *
   * @param text the text to display
   * @return this component
   */
  public Button setText(String text) {
    getElement().setHtml(text);
    return this;
  }

  /**
   * Gets the button's text content.
   *
   * @return the button text
   */
  public String getText() {
    return getElement().getHtml();
  }

  /**
   * Adds components to the prefix slot.
   *
   * @param components the components to add to the prefix slot
   * @return this component
   */
  public Button addToPrefix(Component... components) {
    getElement().add(PREFIX_SLOT, components);
    return this;
  }

  /**
   * Adds components to the suffix slot.
   *
   * @param components the components to add to the suffix slot
   * @return this component
   */
  public Button addToSuffix(Component... components) {
    getElement().add(SUFFIX_SLOT, components);
    return this;
  }

  /**
   * Sets focus on the button.
   */
  public void focus() {
    getElement().callJsFunctionVoidAsync("focus");
  }

  /**
   * Removes focus from the button.
   */
  public void blur() {
    getElement().callJsFunctionVoidAsync("blur");
  }

  /**
   * Simulates a click on the button.
   */
  public void click() {
    getElement().callJsFunctionVoidAsync("click");
  }

  /**
   * Adds a listener for the blur event, fired when the button loses focus.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<BlurEvent<Button>> addBlurListener(EventListener<BlurEvent<Button>> listener) {
    return addEventListener(BlurEvent.class, listener);
  }

  /**
   * Adds a listener for the blur event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<BlurEvent<Button>> onBlur(EventListener<BlurEvent<Button>> listener) {
    return addBlurListener(listener);
  }

  /**
   * Adds a listener for the focus event, fired when the button gains focus.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<FocusEvent<Button>> addFocusListener(EventListener<FocusEvent<Button>> listener) {
    return addEventListener(FocusEvent.class, listener);
  }

  /**
   * Adds a listener for the focus event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<FocusEvent<Button>> onFocus(EventListener<FocusEvent<Button>> listener) {
    return addFocusListener(listener);
  }

  /**
   * Adds a listener for the invalid event, fired when the form control has been checked for
   * validity and its constraints aren't satisfied.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<InvalidEvent<Button>> addInvalidListener(
      EventListener<InvalidEvent<Button>> listener) {
    return addEventListener(InvalidEvent.class, listener);
  }

  /**
   * Adds a listener for the invalid event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<InvalidEvent<Button>> onInvalid(EventListener<InvalidEvent<Button>> listener) {
    return addInvalidListener(listener);
  }

  Element getOriginalElement() {
    return getElement();
  }
}
