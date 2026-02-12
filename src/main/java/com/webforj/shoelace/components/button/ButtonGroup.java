package com.webforj.shoelace.components.button;

import com.webforj.component.element.Element;
import com.webforj.component.element.ElementCompositeContainer;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.component.element.concern.HasElementClickListener;
import com.webforj.concern.HasClassName;
import com.webforj.concern.HasStyle;
import com.webforj.concern.HasVisibility;

/**
 * Shoelace ButtonGroup component ({@code <sl-button-group>}).
 *
 * <p>Button groups can be used to group related buttons into sections. They support a single
 * default slot for one or more {@code <sl-button>} elements.</p>
 *
 * @see <a href="https://shoelace.style/components/button-group">Shoelace Button Group</a>
 */
@NodeName("sl-button-group")
public final class ButtonGroup extends ElementCompositeContainer
    implements HasElementClickListener<ButtonGroup>, HasClassName<ButtonGroup>, HasStyle<ButtonGroup>, HasVisibility<ButtonGroup> {

  private final PropertyDescriptor<String> labelProp =
      PropertyDescriptor.property("label", "");

  /**
   * Creates a new ButtonGroup.
   */
  public ButtonGroup() {
    super();
  }

  /**
   * Creates a new ButtonGroup with the given label.
   *
   * @param label the accessibility label for the button group
   */
  public ButtonGroup(String label) {
    this();
    setLabel(label);
  }

  /**
   * Gets the accessibility label.
   *
   * @return the label
   */
  public String getLabel() {
    return get(labelProp);
  }

  /**
   * Sets the accessibility label for the button group. This won't be displayed on the screen, but
   * it will be announced by assistive devices when interacting with the control and is strongly
   * recommended.
   *
   * @param label the accessibility label
   * @return this component
   */
  public ButtonGroup setLabel(String label) {
    set(labelProp, label);
    return this;
  }

  Element getOriginalElement() {
    return getElement();
  }
}
