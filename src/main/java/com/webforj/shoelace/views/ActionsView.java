package com.webforj.shoelace.views;

import com.webforj.component.Component;
import com.webforj.component.ComponentUtil;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.H2;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.element.Element;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;
import com.webforj.shoelace.Size;
import com.webforj.shoelace.components.button.Button;
import com.webforj.shoelace.components.button.ButtonGroup;
import com.webforj.shoelace.components.button.Variant;
import com.webforj.shoelace.components.copybutton.CopyButton;
import com.webforj.shoelace.components.divider.Divider;
import com.webforj.shoelace.components.dropdown.Dropdown;
import com.webforj.shoelace.components.icon.Icon;
import com.webforj.shoelace.components.iconbutton.IconButton;
import com.webforj.shoelace.components.menu.Menu;
import com.webforj.shoelace.components.menuitem.MenuItem;
import com.webforj.shoelace.components.menulabel.MenuLabel;

@Route(value = "/actions", outlet = MainLayout.class)
@FrameTitle("Actions")
public class ActionsView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public ActionsView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setStyle("padding", "var(--dwc-space-l)");
    self.setStyle("gap", "var(--dwc-space-xl)");
    self.setMaxWidth("900px");

    self.add(
        buildButtonVariantsSection(),
        buildButtonSizesSection(),
        buildButtonStylesSection(),
        buildButtonWithIconsSection(),
        buildButtonGroupSection(),
        buildIconButtonSection(),
        buildCopyButtonSection(),
        buildDropdownSection()
    );
  }

  private FlexLayout buildButtonVariantsSection() {
    Button defaultBtn = new Button("Default");
    Button primaryBtn = new Button("Primary", Variant.PRIMARY);
    Button successBtn = new Button("Success", Variant.SUCCESS);
    Button neutralBtn = new Button("Neutral", Variant.NEUTRAL);
    Button warningBtn = new Button("Warning", Variant.WARNING);
    Button dangerBtn = new Button("Danger", Variant.DANGER);
    Button textBtn = new Button("Text", Variant.TEXT);

    return section(
        "Button Variants",
        "Buttons support several theme variants to communicate different levels of importance and intent.",
        defaultBtn, primaryBtn, successBtn, neutralBtn, warningBtn, dangerBtn, textBtn
    );
  }

  private FlexLayout buildButtonSizesSection() {
    Button smallBtn = new Button("Small", Variant.PRIMARY);
    smallBtn.setSize(Size.SMALL);

    Button mediumBtn = new Button("Medium", Variant.PRIMARY);
    mediumBtn.setSize(Size.MEDIUM);

    Button largeBtn = new Button("Large", Variant.PRIMARY);
    largeBtn.setSize(Size.LARGE);

    return section(
        "Button Sizes",
        "Buttons come in small, medium, and large sizes. The default size is medium.",
        smallBtn, mediumBtn, largeBtn
    );
  }

  private FlexLayout buildButtonStylesSection() {
    Button outlineDefault = new Button("Default");
    outlineDefault.setOutline(true);

    Button outlinePrimary = new Button("Primary", Variant.PRIMARY);
    outlinePrimary.setOutline(true);

    Button outlineSuccess = new Button("Success", Variant.SUCCESS);
    outlineSuccess.setOutline(true);

    Button outlineDanger = new Button("Danger", Variant.DANGER);
    outlineDanger.setOutline(true);

    Button pillDefault = new Button("Default");
    pillDefault.setPill(true);

    Button pillPrimary = new Button("Primary", Variant.PRIMARY);
    pillPrimary.setPill(true);

    Button pillSuccess = new Button("Success", Variant.SUCCESS);
    pillSuccess.setPill(true);

    Button pillWarning = new Button("Warning", Variant.WARNING);
    pillWarning.setPill(true);

    Button loadingDefault = new Button("Loading");
    loadingDefault.setLoading(true);

    Button loadingPrimary = new Button("Loading", Variant.PRIMARY);
    loadingPrimary.setLoading(true);

    Button disabledBtn = new Button("Disabled", Variant.PRIMARY);
    disabledBtn.setDisabled(true);

    FlexLayout outlineRow = row(outlineDefault, outlinePrimary, outlineSuccess, outlineDanger);
    FlexLayout pillRow = row(pillDefault, pillPrimary, pillSuccess, pillWarning);
    FlexLayout stateRow = row(loadingDefault, loadingPrimary, disabledBtn);

    FlexLayout content = new FlexLayout(FlexDirection.COLUMN, outlineRow, pillRow, stateRow);
    content.setStyle("gap", "var(--dwc-space-m)");

    return section(
        "Button Styles",
        "Buttons can be rendered as outline, pill-shaped, loading, or disabled to convey different states and visual treatments.",
        content
    );
  }

  private FlexLayout buildButtonWithIconsSection() {
    Button settingsBtn = new Button("Settings", Variant.DEFAULT);
    settingsBtn.addToPrefix(new Icon("gear"));

    Button refreshBtn = new Button("Refresh", Variant.PRIMARY);
    refreshBtn.addToPrefix(new Icon("arrow-repeat"));

    Button downloadBtn = new Button("Download", Variant.SUCCESS);
    downloadBtn.addToSuffix(new Icon("download"));

    Button linkBtn = new Button("Open Link", Variant.NEUTRAL);
    linkBtn.addToPrefix(new Icon("box-arrow-up-right"));

    Button trashBtn = new Button("Delete", Variant.DANGER);
    trashBtn.addToPrefix(new Icon("trash"));

    Button heartBtn = new Button("Favorite", Variant.WARNING);
    heartBtn.addToPrefix(new Icon("heart"));
    heartBtn.addToSuffix(new Icon("heart-fill"));

    return section(
        "Buttons with Icons",
        "Buttons support prefix and suffix icon slots to enhance visual context and improve user recognition.",
        settingsBtn, refreshBtn, downloadBtn, linkBtn, trashBtn, heartBtn
    );
  }

  private FlexLayout buildButtonGroupSection() {
    ButtonGroup group1 = new ButtonGroup("Alignment");
    Button leftBtn = new Button("Left");
    Button centerBtn = new Button("Center");
    Button rightBtn = new Button("Right");
    group1.add(leftBtn, centerBtn, rightBtn);

    ButtonGroup group2 = new ButtonGroup("Actions");
    Button cutBtn = new Button("Cut", Variant.PRIMARY);
    Button copyBtn = new Button("Copy", Variant.PRIMARY);
    Button pasteBtn = new Button("Paste", Variant.PRIMARY);
    group2.add(cutBtn, copyBtn, pasteBtn);

    ButtonGroup group3 = new ButtonGroup("Toolbar");
    Button boldBtn = new Button();
    boldBtn.addToPrefix(new Icon("type-bold"));
    Button italicBtn = new Button();
    italicBtn.addToPrefix(new Icon("type-italic"));
    Button underlineBtn = new Button();
    underlineBtn.addToPrefix(new Icon("type-underline"));
    group3.add(boldBtn, italicBtn, underlineBtn);

    return section(
        "Button Group",
        "Button groups cluster related buttons into a single horizontal row, visually connecting them as a cohesive set of actions.",
        group1, group2, group3
    );
  }

  private FlexLayout buildIconButtonSection() {
    IconButton settingsIcon = new IconButton("gear", "Settings");
    IconButton searchIcon = new IconButton("search", "Search");
    IconButton bellIcon = new IconButton("bell", "Notifications");
    IconButton heartIcon = new IconButton("heart", "Favorite");
    IconButton trashIcon = new IconButton("trash", "Delete");
    IconButton pencilIcon = new IconButton("pencil", "Edit");
    IconButton starIcon = new IconButton("star", "Bookmark");
    IconButton chatIcon = new IconButton("chat-dots", "Messages");
    IconButton personIcon = new IconButton("person", "Profile");
    IconButton houseIcon = new IconButton("house", "Home");

    IconButton disabledIcon = new IconButton("lock", "Locked");
    disabledIcon.setDisabled(true);

    IconButton linkedIcon = new IconButton("github", "GitHub");
    linkedIcon.setHref("https://github.com");

    return section(
        "Icon Button",
        "Icon buttons are compact, icon-only buttons ideal for toolbars and actions where space is limited. Always provide a label for accessibility.",
        settingsIcon, searchIcon, bellIcon, heartIcon, trashIcon, pencilIcon,
        starIcon, chatIcon, personIcon, houseIcon, disabledIcon, linkedIcon
    );
  }

  private FlexLayout buildCopyButtonSection() {
    CopyButton simpleCopy = new CopyButton("Hello, World!");

    CopyButton labeledCopy = new CopyButton("https://webforj.com");
    labeledCopy.setCopyLabel("Copy URL");
    labeledCopy.setSuccessLabel("URL Copied!");
    labeledCopy.setErrorLabel("Failed to copy");

    CopyButton customDuration = new CopyButton("Copied text with longer feedback");
    customDuration.setFeedbackDuration(3000);
    customDuration.setCopyLabel("Copy (3s feedback)");

    CopyButton disabledCopy = new CopyButton("Cannot copy this");
    disabledCopy.setDisabled(true);
    disabledCopy.setCopyLabel("Disabled");

    return section(
        "Copy Button",
        "Copy buttons provide a one-click mechanism to copy text to the clipboard, complete with visual feedback on success or failure.",
        simpleCopy, labeledCopy, customDuration, disabledCopy
    );
  }

  private FlexLayout buildDropdownSection() {
    Dropdown dropdown1 = new Dropdown();
    Button trigger1 = new Button("Dropdown", Variant.PRIMARY);
    trigger1.setCaret(true);
    Menu menu1 = new Menu();
    menu1.add(
        new MenuItem("Cut", "cut"),
        new MenuItem("Copy", "copy"),
        new MenuItem("Paste", "paste"),
        new Divider(),
        new MenuItem("Select All", "select-all")
    );
    Element dropdown1Element = (Element) ComponentUtil.getBoundComponent(dropdown1);
    dropdown1Element.add("trigger", trigger1);
    dropdown1.add(menu1);

    Dropdown dropdown2 = new Dropdown();
    Button trigger2 = new Button("File Menu");
    trigger2.setCaret(true);
    Menu menu2 = new Menu();
    MenuLabel fileLabel = new MenuLabel("File Operations");
    MenuItem newItem = new MenuItem("New File");
    newItem.addToPrefix(new Icon("file-earmark-plus"));
    MenuItem openItem = new MenuItem("Open File");
    openItem.addToPrefix(new Icon("folder2-open"));
    MenuItem saveItem = new MenuItem("Save");
    saveItem.addToPrefix(new Icon("save"));
    MenuItem saveAsItem = new MenuItem("Save As...");
    saveAsItem.addToPrefix(new Icon("save2"));
    MenuLabel exportLabel = new MenuLabel("Export");
    MenuItem pdfItem = new MenuItem("Export as PDF");
    pdfItem.addToPrefix(new Icon("file-earmark-pdf"));
    MenuItem csvItem = new MenuItem("Export as CSV");
    csvItem.addToPrefix(new Icon("filetype-csv"));
    MenuItem disabledItem = new MenuItem("Print");
    disabledItem.addToPrefix(new Icon("printer"));
    disabledItem.setDisabled(true);
    menu2.add(
        fileLabel,
        newItem,
        openItem,
        saveItem,
        saveAsItem,
        new Divider(),
        exportLabel,
        pdfItem,
        csvItem,
        new Divider(),
        disabledItem
    );
    Element dropdown2Element = (Element) ComponentUtil.getBoundComponent(dropdown2);
    dropdown2Element.add("trigger", trigger2);
    dropdown2.add(menu2);

    Dropdown dropdown3 = new Dropdown();
    Button trigger3 = new Button("Edit", Variant.SUCCESS);
    trigger3.setCaret(true);
    Menu menu3 = new Menu();
    MenuItem undoItem = new MenuItem("Undo");
    undoItem.addToPrefix(new Icon("arrow-counterclockwise"));
    MenuItem redoItem = new MenuItem("Redo");
    redoItem.addToPrefix(new Icon("arrow-clockwise"));
    MenuItem findItem = new MenuItem("Find & Replace");
    findItem.addToPrefix(new Icon("search"));
    menu3.add(
        undoItem,
        redoItem,
        new Divider(),
        findItem
    );
    Element dropdown3Element = (Element) ComponentUtil.getBoundComponent(dropdown3);
    dropdown3Element.add("trigger", trigger3);
    dropdown3.add(menu3);

    return section(
        "Dropdown",
        "Dropdowns display a panel of content that drops down when the user clicks a trigger element. They are commonly used for menus, actions, and navigation.",
        dropdown1, dropdown2, dropdown3
    );
  }

  private FlexLayout section(String title, String description, Component... content) {
    H2 heading = new H2(title);
    Paragraph desc = new Paragraph(description);
    FlexLayout contentRow = row(content);

    FlexLayout sectionLayout = new FlexLayout(FlexDirection.COLUMN, heading, desc, contentRow);
    sectionLayout.setStyle("gap", "var(--dwc-space-s)");
    return sectionLayout;
  }

  private FlexLayout row(Component... components) {
    FlexLayout rowLayout = new FlexLayout(FlexDirection.ROW, components);
    rowLayout.setStyle("gap", "var(--dwc-space-s)");
    rowLayout.setStyle("align-items", "center");
    rowLayout.setStyle("flex-wrap", "wrap");
    return rowLayout;
  }
}
