package com.webforj.shoelace.views;

import com.webforj.component.Component;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.H2;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.html.elements.Span;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;
import com.webforj.shoelace.components.checkbox.Checkbox;
import com.webforj.shoelace.components.colorpicker.ColorPicker;
import com.webforj.shoelace.components.input.Input;
import com.webforj.shoelace.components.input.InputType;
import com.webforj.shoelace.components.option.Option;
import com.webforj.shoelace.components.radio.Radio;
import com.webforj.shoelace.components.radiobutton.RadioButton;
import com.webforj.shoelace.components.radiogroup.RadioGroup;
import com.webforj.shoelace.components.range.Range;
import com.webforj.shoelace.components.rating.Rating;
import com.webforj.shoelace.components.select.Select;
import com.webforj.shoelace.components.switchc.Switch;
import com.webforj.shoelace.components.textarea.Textarea;

@Route(value = "/form-controls", outlet = MainLayout.class)
@FrameTitle("Form Controls")
public class FormControlsView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public FormControlsView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setStyle("padding", "var(--dwc-space-l)");
    self.setStyle("gap", "var(--dwc-space-xl)");
    self.setMaxWidth("900px");

    self.add(createInputSection());
    self.add(createTextareaSection());
    self.add(createCheckboxSection());
    self.add(createSwitchSection());
    self.add(createRadioGroupSection());
    self.add(createRadioButtonSection());
    self.add(createSelectSection());
    self.add(createRangeSection());
    self.add(createRatingSection());
    self.add(createColorPickerSection());
  }

  private FlexLayout createInputSection() {
    Input textInput = new Input();
    textInput.setLabel("Name");
    textInput.setPlaceholder("Enter your name");
    textInput.setHelpText("Your full name");
    textInput.setClearable(true);

    Input passwordInput = new Input();
    passwordInput.setType(InputType.PASSWORD);
    passwordInput.setLabel("Password");
    passwordInput.setPlaceholder("Enter your password");
    passwordInput.setPasswordToggle(true);

    Input searchInput = new Input();
    searchInput.setType(InputType.SEARCH);
    searchInput.setLabel("Search");
    searchInput.setPlaceholder("Search for something");
    searchInput.setClearable(true);

    Input numberInput = new Input();
    numberInput.setType(InputType.NUMBER);
    numberInput.setLabel("Quantity");
    numberInput.setPlaceholder("Enter a number");
    numberInput.setMin("0");
    numberInput.setMax("100");
    numberInput.setStep("1");

    return section(
        "Input",
        "Inputs collect data from the user. They support text, password, search, number, and more.",
        textInput, passwordInput, searchInput, numberInput);
  }

  private FlexLayout createTextareaSection() {
    Textarea textarea = new Textarea();
    textarea.setLabel("Comments");
    textarea.setPlaceholder("Enter comments");
    textarea.setRows(4);
    textarea.setHelpText("Please provide detailed feedback");

    return section(
        "Textarea",
        "Textareas collect longer form text input from the user and allow multiple lines.",
        textarea);
  }

  private FlexLayout createCheckboxSection() {
    Checkbox checkbox1 = new Checkbox();
    checkbox1.add(new Span("Option 1"));

    Checkbox checkbox2 = new Checkbox();
    checkbox2.setChecked(true);
    checkbox2.add(new Span("Option 2 (checked by default)"));

    Checkbox checkbox3 = new Checkbox();
    checkbox3.setIndeterminate(true);
    checkbox3.add(new Span("Option 3 (indeterminate)"));

    Checkbox checkbox4 = new Checkbox();
    checkbox4.add(new Span("Option 4"));

    return section(
        "Checkbox",
        "Checkboxes allow the user to toggle an option on or off.",
        checkbox1, checkbox2, checkbox3, checkbox4);
  }

  private FlexLayout createSwitchSection() {
    Switch toggle = new Switch();
    toggle.setChecked(true);
    toggle.add(new Span("Enable notifications"));

    Switch toggle2 = new Switch();
    toggle2.add(new Span("Enable dark mode"));

    return section(
        "Switch",
        "Switches allow the user to toggle an option on or off, similar to a checkbox but with a different visual style.",
        toggle, toggle2);
  }

  private FlexLayout createRadioGroupSection() {
    Radio radioRed = new Radio("red");
    radioRed.add(new Span("Red"));

    Radio radioGreen = new Radio("green");
    radioGreen.add(new Span("Green"));

    Radio radioBlue = new Radio("blue");
    radioBlue.add(new Span("Blue"));

    Radio radioYellow = new Radio("yellow");
    radioYellow.add(new Span("Yellow"));

    RadioGroup radioGroup = new RadioGroup("Favorite Color");
    radioGroup.setValue("green");
    radioGroup.add(radioRed, radioGreen, radioBlue, radioYellow);

    return section(
        "Radio Group",
        "Radio groups allow the user to select a single option from a set of radios.",
        radioGroup);
  }

  private FlexLayout createRadioButtonSection() {
    RadioButton btnSmall = new RadioButton("small");
    btnSmall.add(new Span("Small"));

    RadioButton btnMedium = new RadioButton("medium");
    btnMedium.add(new Span("Medium"));

    RadioButton btnLarge = new RadioButton("large");
    btnLarge.add(new Span("Large"));

    RadioButton btnExtraLarge = new RadioButton("xl");
    btnExtraLarge.add(new Span("Extra Large"));

    RadioGroup buttonGroup = new RadioGroup("T-Shirt Size");
    buttonGroup.setValue("medium");
    buttonGroup.add(btnSmall, btnMedium, btnLarge, btnExtraLarge);

    return section(
        "Radio Button",
        "Radio buttons offer a button-style alternative to standard radios within a radio group.",
        buttonGroup);
  }

  private FlexLayout createSelectSection() {
    Select select = new Select("Favorite Fruit");
    select.setPlaceholder("Select a fruit");
    select.setClearable(true);
    select.add(
        new Option("apple", "Apple"),
        new Option("banana", "Banana"),
        new Option("cherry", "Cherry"),
        new Option("grape", "Grape"),
        new Option("orange", "Orange"),
        new Option("strawberry", "Strawberry"));

    return section(
        "Select",
        "Selects allow you to choose items from a menu of predefined options.",
        select);
  }

  private FlexLayout createRangeSection() {
    Range range = new Range();
    range.setLabel("Volume");
    range.setMin(0);
    range.setMax(100);
    range.setStep(1);
    range.setValue(50);
    range.setHelpText("Adjust the volume level");

    return section(
        "Range",
        "Ranges allow the user to select a single value within a given range using a slider.",
        range);
  }

  private FlexLayout createRatingSection() {
    Rating rating = new Rating();
    rating.setLabel("Rating");
    rating.setPrecision(0.5);
    rating.setValue(3.5);

    Rating ratingWhole = new Rating();
    ratingWhole.setLabel("Whole star rating");
    ratingWhole.setPrecision(1);
    ratingWhole.setValue(4);

    return section(
        "Rating",
        "Ratings give users a way to quickly view and provide feedback using a star-based scale.",
        rating, ratingWhole);
  }

  private FlexLayout createColorPickerSection() {
    ColorPicker colorPicker = new ColorPicker();
    colorPicker.setLabel("Color");
    colorPicker.setValue("#4a90d9");

    return section(
        "Color Picker",
        "Color pickers allow the user to select a color from a visual interface.",
        colorPicker);
  }

  private FlexLayout section(String title, String description, Component... content) {
    H2 heading = new H2(title);
    Paragraph desc = new Paragraph(description);
    FlexLayout row = new FlexLayout(FlexDirection.COLUMN, content);
    row.setStyle("gap", "var(--dwc-space-s)");
    FlexLayout section = new FlexLayout(FlexDirection.COLUMN, heading, desc, row);
    section.setStyle("gap", "var(--dwc-space-s)");
    return section;
  }
}
