package com.webforj.shoelace.views;

import com.webforj.component.Component;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.*;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;
import com.webforj.shoelace.Placement;
import com.webforj.shoelace.components.alert.Alert;
import com.webforj.shoelace.components.alert.AlertVariant;
import com.webforj.shoelace.components.button.Button;
import com.webforj.shoelace.components.button.Variant;
import com.webforj.shoelace.components.dialog.Dialog;
import com.webforj.shoelace.components.drawer.Drawer;
import com.webforj.shoelace.components.drawer.DrawerPlacement;
import com.webforj.shoelace.components.icon.Icon;
import com.webforj.shoelace.components.progressbar.ProgressBar;
import com.webforj.shoelace.components.progressring.ProgressRing;
import com.webforj.shoelace.components.skeleton.Skeleton;
import com.webforj.shoelace.components.skeleton.SkeletonEffect;
import com.webforj.shoelace.components.spinner.Spinner;
import com.webforj.shoelace.components.tooltip.Tooltip;

@Route(value = "/feedback", outlet = MainLayout.class)
@FrameTitle("Feedback")
public class FeedbackView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public FeedbackView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setStyle("padding", "var(--dwc-space-l)");
    self.setStyle("gap", "var(--dwc-space-xl)");
    self.setMaxWidth("900px");

    self.add(
        createAlertSection(),
        createDialogSection(),
        createDrawerSection(),
        createProgressBarSection(),
        createProgressRingSection(),
        createSkeletonSection(),
        createSpinnerSection(),
        createTooltipSection()
    );
  }

  // ---------------------------------------------------------------------------
  // Alert
  // ---------------------------------------------------------------------------
  private FlexLayout createAlertSection() {
    Alert primaryAlert = new Alert();
    primaryAlert.setVariant(AlertVariant.PRIMARY);
    primaryAlert.setOpen(true);
    primaryAlert.setClosable(true);
    primaryAlert.add(new Icon("info-circle"), new Span("This is a primary alert. You can close it with the X button."));

    Alert successAlert = new Alert();
    successAlert.setVariant(AlertVariant.SUCCESS);
    successAlert.setOpen(true);
    successAlert.setClosable(true);
    successAlert.add(new Icon("check2-circle"), new Span("Your changes have been saved successfully."));

    Alert neutralAlert = new Alert();
    neutralAlert.setVariant(AlertVariant.NEUTRAL);
    neutralAlert.setOpen(true);
    neutralAlert.setClosable(true);
    neutralAlert.add(new Icon("gear"), new Span("This is a neutral informational alert."));

    Alert warningAlert = new Alert();
    warningAlert.setVariant(AlertVariant.WARNING);
    warningAlert.setOpen(true);
    warningAlert.setClosable(true);
    warningAlert.add(new Icon("exclamation-triangle"), new Span("Warning: this action may have unintended side effects."));

    Alert dangerAlert = new Alert();
    dangerAlert.setVariant(AlertVariant.DANGER);
    dangerAlert.setOpen(true);
    dangerAlert.setClosable(true);
    dangerAlert.add(new Icon("exclamation-octagon"), new Span("Danger! Something critical went wrong."));

    return section("Alert",
        "Alerts display important messages inline. Each variant conveys a different level of severity. All alerts below are closable.",
        primaryAlert, successAlert, neutralAlert, warningAlert, dangerAlert);
  }

  // ---------------------------------------------------------------------------
  // Dialog
  // ---------------------------------------------------------------------------
  private FlexLayout createDialogSection() {
    Dialog dialog = new Dialog("Example Dialog");
    dialog.add(new Paragraph("This is the dialog body. Dialogs appear above the page and require the user's immediate attention."));
    dialog.add(new Paragraph("Click the X button or press Escape to close."));

    Button closeFooterBtn = new Button("Close", Variant.PRIMARY);
    closeFooterBtn.onClick(e -> dialog.hide());
    dialog.addToFooter(closeFooterBtn);

    Button openDialogBtn = new Button("Open Dialog", Variant.PRIMARY);
    openDialogBtn.setStyle("align-self", "flex-start");
    openDialogBtn.onClick(e -> dialog.show());

    return section("Dialog",
        "Dialogs (modals) appear above the page and require the user's attention. Click the button below to open one.",
        openDialogBtn, dialog);
  }

  // ---------------------------------------------------------------------------
  // Drawer
  // ---------------------------------------------------------------------------
  private FlexLayout createDrawerSection() {
    Drawer endDrawer = new Drawer("End Drawer");
    endDrawer.setPlacement(DrawerPlacement.END);
    endDrawer.add(new Paragraph("This drawer slides in from the end (right) side of the viewport."));

    Button closeEndBtn = new Button("Close", Variant.PRIMARY);
    closeEndBtn.onClick(e -> endDrawer.hide());
    endDrawer.addToFooter(closeEndBtn);

    Drawer startDrawer = new Drawer("Start Drawer");
    startDrawer.setPlacement(DrawerPlacement.START);
    startDrawer.add(new Paragraph("This drawer slides in from the start (left) side of the viewport."));

    Button closeStartBtn = new Button("Close", Variant.PRIMARY);
    closeStartBtn.onClick(e -> startDrawer.hide());
    startDrawer.addToFooter(closeStartBtn);

    Drawer bottomDrawer = new Drawer("Bottom Drawer");
    bottomDrawer.setPlacement(DrawerPlacement.BOTTOM);
    bottomDrawer.add(new Paragraph("This drawer slides in from the bottom of the viewport."));

    Button closeBottomBtn = new Button("Close", Variant.PRIMARY);
    closeBottomBtn.onClick(e -> bottomDrawer.hide());
    bottomDrawer.addToFooter(closeBottomBtn);

    Button openEndBtn = new Button("Open End Drawer", Variant.NEUTRAL);
    openEndBtn.onClick(e -> endDrawer.show());

    Button openStartBtn = new Button("Open Start Drawer", Variant.NEUTRAL);
    openStartBtn.onClick(e -> startDrawer.show());

    Button openBottomBtn = new Button("Open Bottom Drawer", Variant.NEUTRAL);
    openBottomBtn.onClick(e -> bottomDrawer.show());

    FlexLayout buttons = new FlexLayout(FlexDirection.ROW, openEndBtn, openStartBtn, openBottomBtn);
    buttons.setStyle("gap", "var(--dwc-space-s)");
    buttons.setStyle("flex-wrap", "wrap");

    return section("Drawer",
        "Drawers slide in from the edge of the viewport to expose additional options. Click the buttons below to try different placements.",
        buttons, endDrawer, startDrawer, bottomDrawer);
  }

  // ---------------------------------------------------------------------------
  // ProgressBar
  // ---------------------------------------------------------------------------
  private FlexLayout createProgressBarSection() {
    ProgressBar bar25 = new ProgressBar(25);
    bar25.setLabel("25%");

    ProgressBar bar50 = new ProgressBar(50);
    bar50.setLabel("50%");

    ProgressBar bar75 = new ProgressBar(75);
    bar75.setLabel("75%");

    ProgressBar bar100 = new ProgressBar(100);
    bar100.setLabel("100%");

    ProgressBar barIndeterminate = new ProgressBar();
    barIndeterminate.setIndeterminate(true);
    barIndeterminate.setLabel("Loading...");

    return section("Progress Bar",
        "Progress bars show the status of an ongoing operation as a horizontal bar from 0% to 100%. The last bar uses indeterminate mode.",
        bar25, bar50, bar75, bar100, barIndeterminate);
  }

  // ---------------------------------------------------------------------------
  // ProgressRing
  // ---------------------------------------------------------------------------
  private FlexLayout createProgressRingSection() {
    ProgressRing ring25 = new ProgressRing(25);
    ring25.setLabel("25%");

    ProgressRing ring50 = new ProgressRing(50);
    ring50.setLabel("50%");

    ProgressRing ring75 = new ProgressRing(75);
    ring75.setLabel("75%");

    ProgressRing ring100 = new ProgressRing(100);
    ring100.setLabel("100%");

    FlexLayout rings = new FlexLayout(FlexDirection.ROW, ring25, ring50, ring75, ring100);
    rings.setStyle("gap", "var(--dwc-space-l)");
    rings.setStyle("align-items", "center");

    return section("Progress Ring",
        "Progress rings display progress in a circular format, useful for compact layouts or dashboards.",
        rings);
  }

  // ---------------------------------------------------------------------------
  // Skeleton
  // ---------------------------------------------------------------------------
  private FlexLayout createSkeletonSection() {
    Skeleton sheenSkeleton = new Skeleton();
    sheenSkeleton.setEffect(SkeletonEffect.SHEEN);
    sheenSkeleton.setStyle("width", "100%");
    sheenSkeleton.setStyle("height", "1.5rem");

    Skeleton pulseSkeleton = new Skeleton();
    pulseSkeleton.setEffect(SkeletonEffect.PULSE);
    pulseSkeleton.setStyle("width", "100%");
    pulseSkeleton.setStyle("height", "1.5rem");

    Skeleton noneSkeleton = new Skeleton();
    noneSkeleton.setEffect(SkeletonEffect.NONE);
    noneSkeleton.setStyle("width", "100%");
    noneSkeleton.setStyle("height", "1.5rem");

    Skeleton circleSkeleton = new Skeleton();
    circleSkeleton.setEffect(SkeletonEffect.SHEEN);
    circleSkeleton.setStyle("width", "3rem");
    circleSkeleton.setStyle("height", "3rem");
    circleSkeleton.setBorderRadius("50%");

    Skeleton wideSkeleton = new Skeleton();
    wideSkeleton.setEffect(SkeletonEffect.SHEEN);
    wideSkeleton.setStyle("width", "80%");
    wideSkeleton.setStyle("height", "1rem");

    Skeleton narrowSkeleton = new Skeleton();
    narrowSkeleton.setEffect(SkeletonEffect.SHEEN);
    narrowSkeleton.setStyle("width", "60%");
    narrowSkeleton.setStyle("height", "1rem");

    // Card-like skeleton layout
    FlexLayout cardSkeleton = new FlexLayout(FlexDirection.ROW, circleSkeleton,
        new FlexLayout(FlexDirection.COLUMN, wideSkeleton, narrowSkeleton) {{
          setStyle("gap", "var(--dwc-space-xs)");
          setStyle("flex", "1");
        }});
    cardSkeleton.setStyle("gap", "var(--dwc-space-m)");
    cardSkeleton.setStyle("align-items", "center");

    FlexLayout labeledSheen = labeled("Sheen effect", sheenSkeleton);
    FlexLayout labeledPulse = labeled("Pulse effect", pulseSkeleton);
    FlexLayout labeledNone = labeled("No effect", noneSkeleton);
    FlexLayout labeledCard = labeled("Card placeholder (sheen)", cardSkeleton);

    return section("Skeleton",
        "Skeletons are placeholder elements shown while content is loading. They support sheen, pulse, and no-animation effects.",
        labeledSheen, labeledPulse, labeledNone, labeledCard);
  }

  // ---------------------------------------------------------------------------
  // Spinner
  // ---------------------------------------------------------------------------
  private FlexLayout createSpinnerSection() {
    Spinner smallSpinner = new Spinner();
    smallSpinner.setStyle("font-size", "1rem");

    Spinner mediumSpinner = new Spinner();
    mediumSpinner.setStyle("font-size", "2rem");

    Spinner largeSpinner = new Spinner();
    largeSpinner.setStyle("font-size", "3rem");

    Spinner xlSpinner = new Spinner();
    xlSpinner.setStyle("font-size", "4rem");
    xlSpinner.setTrackWidth("6px");

    FlexLayout spinners = new FlexLayout(FlexDirection.ROW,
        labeled("1rem", smallSpinner),
        labeled("2rem", mediumSpinner),
        labeled("3rem", largeSpinner),
        labeled("4rem", xlSpinner));
    spinners.setStyle("gap", "var(--dwc-space-xl)");
    spinners.setStyle("align-items", "flex-end");

    return section("Spinner",
        "Spinners indicate an indeterminate loading operation. Size is controlled via font-size.",
        spinners);
  }

  // ---------------------------------------------------------------------------
  // Tooltip
  // ---------------------------------------------------------------------------
  private FlexLayout createTooltipSection() {
    Tooltip topTooltip = new Tooltip("Tooltip on top");
    topTooltip.setPlacement(Placement.TOP);
    topTooltip.add(new Button("Top", Variant.PRIMARY));

    Tooltip bottomTooltip = new Tooltip("Tooltip on bottom");
    bottomTooltip.setPlacement(Placement.BOTTOM);
    bottomTooltip.add(new Button("Bottom", Variant.SUCCESS));

    Tooltip leftTooltip = new Tooltip("Tooltip on left");
    leftTooltip.setPlacement(Placement.LEFT);
    leftTooltip.add(new Button("Left", Variant.NEUTRAL));

    Tooltip rightTooltip = new Tooltip("Tooltip on right");
    rightTooltip.setPlacement(Placement.RIGHT);
    rightTooltip.add(new Button("Right", Variant.WARNING));

    Tooltip iconTooltip = new Tooltip("Extra information");
    iconTooltip.setPlacement(Placement.TOP);
    iconTooltip.add(new Icon("info-circle"));

    FlexLayout tooltips = new FlexLayout(FlexDirection.ROW,
        topTooltip, bottomTooltip, leftTooltip, rightTooltip, iconTooltip);
    tooltips.setStyle("gap", "var(--dwc-space-m)");
    tooltips.setStyle("align-items", "center");
    tooltips.setStyle("flex-wrap", "wrap");

    return section("Tooltip",
        "Tooltips display additional information on hover or focus. Hover over the elements below to see tooltips in different placements.",
        tooltips);
  }

  // ---------------------------------------------------------------------------
  // Helpers
  // ---------------------------------------------------------------------------
  private FlexLayout section(String title, String description, Component... content) {
    H2 heading = new H2(title);
    Paragraph desc = new Paragraph(description);
    FlexLayout inner = new FlexLayout(FlexDirection.COLUMN, content);
    inner.setStyle("gap", "var(--dwc-space-s)");
    FlexLayout section = new FlexLayout(FlexDirection.COLUMN, heading, desc, inner);
    section.setStyle("gap", "var(--dwc-space-s)");
    return section;
  }

  private FlexLayout labeled(String label, Component component) {
    Span labelSpan = new Span(label);
    labelSpan.setStyle("font-size", "0.85rem");
    labelSpan.setStyle("color", "var(--sl-color-neutral-500)");
    FlexLayout wrapper = new FlexLayout(FlexDirection.COLUMN, labelSpan, component);
    wrapper.setStyle("gap", "var(--dwc-space-xs)");
    return wrapper;
  }
}
