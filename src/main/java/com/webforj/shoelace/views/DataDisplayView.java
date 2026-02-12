package com.webforj.shoelace.views;

import com.webforj.component.Component;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.*;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;
import com.webforj.shoelace.Size;
import com.webforj.shoelace.components.avatar.Avatar;
import com.webforj.shoelace.components.avatar.AvatarShape;
import com.webforj.shoelace.components.badge.Badge;
import com.webforj.shoelace.components.badge.BadgeVariant;
import com.webforj.shoelace.components.card.Card;
import com.webforj.shoelace.components.carousel.Carousel;
import com.webforj.shoelace.components.carousel.CarouselItem;
import com.webforj.shoelace.components.formatbytes.FormatBytes;
import com.webforj.shoelace.components.formatdate.FormatDate;
import com.webforj.shoelace.components.formatdate.MonthFormat;
import com.webforj.shoelace.components.formatdate.NarrowShortLong;
import com.webforj.shoelace.components.formatdate.NumericTwoDigit;
import com.webforj.shoelace.components.formatnumber.FormatNumber;
import com.webforj.shoelace.components.formatnumber.NumberType;
import com.webforj.shoelace.components.icon.Icon;
import com.webforj.shoelace.components.qrcode.QrCode;
import com.webforj.shoelace.components.relativetime.RelativeTime;
import com.webforj.shoelace.components.tag.Tag;
import com.webforj.shoelace.components.tag.TagVariant;
import com.webforj.shoelace.components.tree.Tree;
import com.webforj.shoelace.components.treeitem.TreeItem;

@Route(value = "/data-display", outlet = MainLayout.class)
@FrameTitle("Data Display")
public class DataDisplayView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public DataDisplayView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setStyle("padding", "var(--dwc-space-l)");
    self.setStyle("gap", "var(--dwc-space-xl)");
    self.setMaxWidth("900px");

    self.add(
        createAvatarSection(),
        createBadgeSection(),
        createCardSection(),
        createCarouselSection(),
        createFormatBytesSection(),
        createFormatDateSection(),
        createFormatNumberSection(),
        createIconSection(),
        createQrCodeSection(),
        createRelativeTimeSection(),
        createTagSection(),
        createTreeSection()
    );
  }

  // ---------- Avatar ----------
  private FlexLayout createAvatarSection() {
    Avatar circleAvatar = new Avatar();
    circleAvatar.setImage("https://i.pravatar.cc/128");
    circleAvatar.setLabel("User avatar");
    circleAvatar.setShape(AvatarShape.CIRCLE);

    Avatar squareAvatar = new Avatar();
    squareAvatar.setInitials("AB");
    squareAvatar.setShape(AvatarShape.SQUARE);
    squareAvatar.setLabel("Square avatar");

    Avatar roundedAvatar = new Avatar();
    roundedAvatar.setInitials("CD");
    roundedAvatar.setShape(AvatarShape.ROUNDED);
    roundedAvatar.setLabel("Rounded avatar");

    Avatar smallAvatar = new Avatar();
    smallAvatar.setInitials("SM");
    smallAvatar.setStyle("--size", "2rem");
    smallAvatar.setLabel("Small avatar");

    Avatar largeAvatar = new Avatar();
    largeAvatar.setImage("https://i.pravatar.cc/128?img=3");
    largeAvatar.setStyle("--size", "4rem");
    largeAvatar.setLabel("Large avatar");

    return section(
        "Avatar",
        "Avatars represent a person or object. They support images, initials, and different shapes.",
        circleAvatar, squareAvatar, roundedAvatar, smallAvatar, largeAvatar
    );
  }

  // ---------- Badge ----------
  private FlexLayout createBadgeSection() {
    Badge primaryBadge = new Badge();
    primaryBadge.setVariant(BadgeVariant.PRIMARY);
    primaryBadge.add(new Span("Primary"));

    Badge successBadge = new Badge();
    successBadge.setVariant(BadgeVariant.SUCCESS);
    successBadge.add(new Span("Success"));

    Badge neutralBadge = new Badge();
    neutralBadge.setVariant(BadgeVariant.NEUTRAL);
    neutralBadge.add(new Span("Neutral"));

    Badge warningBadge = new Badge();
    warningBadge.setVariant(BadgeVariant.WARNING);
    warningBadge.add(new Span("Warning"));

    Badge dangerBadge = new Badge();
    dangerBadge.setVariant(BadgeVariant.DANGER);
    dangerBadge.add(new Span("Danger"));

    Badge pillBadge = new Badge();
    pillBadge.setVariant(BadgeVariant.PRIMARY);
    pillBadge.setPill(true);
    pillBadge.add(new Span("Pill"));

    Badge pulseBadge = new Badge();
    pulseBadge.setVariant(BadgeVariant.DANGER);
    pulseBadge.setPill(true);
    pulseBadge.setPulse(true);
    pulseBadge.add(new Span("Pulse"));

    return section(
        "Badge",
        "Badges draw attention and display statuses or counts. Shown in all variants, plus pill and pulse styles.",
        primaryBadge, successBadge, neutralBadge, warningBadge, dangerBadge, pillBadge, pulseBadge
    );
  }

  // ---------- Card ----------
  private FlexLayout createCardSection() {
    Card card = new Card();
    card.setStyle("max-width", "400px");

    Img cardImage = new Img();
    cardImage.setAttribute("src",
        "https://images.unsplash.com/photo-1559209172-0ff8f6d49ff7?w=400&h=200&fit=crop");
    cardImage.setAttribute("alt", "A kitten sits patiently between a pair of shoes.");
    card.addToImage(cardImage);

    Strong headerText = new Strong("Mittens");
    card.addToHeader(headerText);

    Paragraph bodyText = new Paragraph(
        "This kitten is as cute as it is playful. Bring it home today!");
    Paragraph bodySmall = new Paragraph("6 weeks old");
    card.add(bodyText, bodySmall);

    Div footerContent = new Div();
    footerContent.setStyle("display", "flex");
    footerContent.setStyle("justify-content", "space-between");
    footerContent.setStyle("align-items", "center");
    Span priceSpan = new Span("Free");
    priceSpan.setStyle("font-weight", "bold");
    Span ratingSpan = new Span("4.5 / 5");
    footerContent.add(priceSpan, ratingSpan);
    card.addToFooter(footerContent);

    return section(
        "Card",
        "Cards group related content in a container with optional header, footer, and image slots.",
        card
    );
  }

  // ---------- Carousel ----------
  private FlexLayout createCarouselSection() {
    Carousel carousel = new Carousel();
    carousel.setPagination(true);
    carousel.setNavigation(true);
    carousel.setLoop(true);
    carousel.setMouseDragging(true);
    carousel.setStyle("width", "100%");
    carousel.setStyle("max-width", "600px");

    CarouselItem item1 = new CarouselItem();
    item1.add(createSlide("#3b82f6", "Slide 1"));

    CarouselItem item2 = new CarouselItem();
    item2.add(createSlide("#10b981", "Slide 2"));

    CarouselItem item3 = new CarouselItem();
    item3.add(createSlide("#f59e0b", "Slide 3"));

    carousel.add(item1, item2, item3);

    return section(
        "Carousel",
        "Carousels display content slides with navigation, pagination, and mouse dragging support.",
        carousel
    );
  }

  private Div createSlide(String color, String label) {
    Div slide = new Div();
    slide.setStyle("background-color", color);
    slide.setStyle("width", "100%");
    slide.setStyle("height", "200px");
    slide.setStyle("display", "flex");
    slide.setStyle("align-items", "center");
    slide.setStyle("justify-content", "center");
    slide.setStyle("color", "white");
    slide.setStyle("font-size", "1.5rem");
    slide.setStyle("border-radius", "var(--sl-border-radius-medium)");
    slide.add(new Span(label));
    return slide;
  }

  // ---------- FormatBytes ----------
  private FlexLayout createFormatBytesSection() {
    FlexLayout column = new FlexLayout(FlexDirection.COLUMN);
    column.setStyle("gap", "var(--dwc-space-xs)");

    FormatBytes zeroBytes = new FormatBytes(0);
    FormatBytes oneKb = new FormatBytes(1024);
    FormatBytes oneMb = new FormatBytes(1048576);
    FormatBytes oneGb = new FormatBytes(1073741824);

    column.add(
        labeledValue("0 bytes:", zeroBytes),
        labeledValue("1,024 bytes:", oneKb),
        labeledValue("1,048,576 bytes:", oneMb),
        labeledValue("1,073,741,824 bytes:", oneGb)
    );

    return section(
        "Format Bytes",
        "Formats a number as a human-readable byte value using the browser's locale.",
        column
    );
  }

  // ---------- FormatDate ----------
  private FlexLayout createFormatDateSection() {
    FlexLayout column = new FlexLayout(FlexDirection.COLUMN);
    column.setStyle("gap", "var(--dwc-space-xs)");

    FormatDate defaultDate = new FormatDate();
    defaultDate.setDate("2024-01-15T09:30:00Z");

    FormatDate longDate = new FormatDate();
    longDate.setDate("2024-01-15T09:30:00Z");
    longDate.setWeekday(NarrowShortLong.LONG);
    longDate.setMonth(MonthFormat.LONG);
    longDate.setDay(NumericTwoDigit.NUMERIC);
    longDate.setYear(NumericTwoDigit.NUMERIC);

    FormatDate withTime = new FormatDate();
    withTime.setDate("2024-01-15T09:30:00Z");
    withTime.setMonth(MonthFormat.SHORT);
    withTime.setDay(NumericTwoDigit.NUMERIC);
    withTime.setYear(NumericTwoDigit.NUMERIC);
    withTime.setHour(NumericTwoDigit.NUMERIC);
    withTime.setMinute(NumericTwoDigit.TWO_DIGIT);

    FormatDate numericDate = new FormatDate();
    numericDate.setDate("2024-01-15T09:30:00Z");
    numericDate.setMonth(MonthFormat.TWO_DIGIT);
    numericDate.setDay(NumericTwoDigit.TWO_DIGIT);
    numericDate.setYear(NumericTwoDigit.NUMERIC);

    column.add(
        labeledValue("Default:", defaultDate),
        labeledValue("Long format:", longDate),
        labeledValue("With time:", withTime),
        labeledValue("Numeric:", numericDate)
    );

    return section(
        "Format Date",
        "Formats a date/time using the Intl.DateTimeFormat API with configurable locale and display options.",
        column
    );
  }

  // ---------- FormatNumber ----------
  private FlexLayout createFormatNumberSection() {
    FlexLayout column = new FlexLayout(FlexDirection.COLUMN);
    column.setStyle("gap", "var(--dwc-space-xs)");

    FormatNumber decimal = new FormatNumber(1234567.89);

    FormatNumber currency = new FormatNumber(1234.56);
    currency.setType(NumberType.CURRENCY);
    currency.setCurrency("USD");

    FormatNumber euroCurrency = new FormatNumber(1234.56);
    euroCurrency.setType(NumberType.CURRENCY);
    euroCurrency.setCurrency("EUR");

    FormatNumber percent = new FormatNumber(0.875);
    percent.setType(NumberType.PERCENT);

    FormatNumber precision = new FormatNumber(3.14159265);
    precision.setMinimumFractionDigits(4);
    precision.setMaximumFractionDigits(4);

    column.add(
        labeledValue("Decimal:", decimal),
        labeledValue("USD Currency:", currency),
        labeledValue("EUR Currency:", euroCurrency),
        labeledValue("Percent:", percent),
        labeledValue("4 decimal places:", precision)
    );

    return section(
        "Format Number",
        "Formats numbers using the Intl.NumberFormat API. Supports decimal, currency, and percent styles.",
        column
    );
  }

  // ---------- Icon ----------
  private FlexLayout createIconSection() {
    Icon houseIcon = new Icon("house");
    houseIcon.setStyle("font-size", "1.5rem");

    Icon gearIcon = new Icon("gear");
    gearIcon.setStyle("font-size", "1.5rem");

    Icon personIcon = new Icon("person");
    personIcon.setStyle("font-size", "1.5rem");

    Icon starIcon = new Icon("star");
    starIcon.setStyle("font-size", "1.5rem");
    starIcon.setStyle("color", "#f59e0b");

    Icon heartIcon = new Icon("heart");
    heartIcon.setStyle("font-size", "1.5rem");
    heartIcon.setStyle("color", "#ef4444");

    Icon envelopeIcon = new Icon("envelope");
    envelopeIcon.setStyle("font-size", "1.5rem");

    return section(
        "Icon",
        "Icons are symbols from Bootstrap Icons (bundled by default). They can be styled with color and size.",
        houseIcon, gearIcon, personIcon, starIcon, heartIcon, envelopeIcon
    );
  }

  // ---------- QR Code ----------
  private FlexLayout createQrCodeSection() {
    QrCode qrCode = new QrCode();
    qrCode.setValue("https://shoelace.style");
    qrCode.setLabel("QR code linking to Shoelace website");
    qrCode.setSize(200);

    return section(
        "QR Code",
        "Generates a QR code rendered via the Canvas API. Useful for providing scannable links or data.",
        qrCode
    );
  }

  // ---------- RelativeTime ----------
  private FlexLayout createRelativeTimeSection() {
    FlexLayout column = new FlexLayout(FlexDirection.COLUMN);
    column.setStyle("gap", "var(--dwc-space-xs)");

    RelativeTime pastTime = new RelativeTime();
    pastTime.setDate("2024-01-01T00:00:00Z");

    RelativeTime recentPast = new RelativeTime();
    recentPast.setDate("2024-06-15T12:00:00Z");

    RelativeTime syncedTime = new RelativeTime();
    syncedTime.setDate("2024-01-01T00:00:00Z");
    syncedTime.setSync(true);

    column.add(
        labeledValue("Jan 1, 2024:", pastTime),
        labeledValue("Jun 15, 2024:", recentPast),
        labeledValue("Synced (auto-updates):", syncedTime)
    );

    return section(
        "Relative Time",
        "Displays a localized time phrase relative to the current date, such as '2 years ago'.",
        column
    );
  }

  // ---------- Tag ----------
  private FlexLayout createTagSection() {
    Tag primaryTag = new Tag();
    primaryTag.setVariant(TagVariant.PRIMARY);
    primaryTag.add(new Span("Primary"));

    Tag successTag = new Tag();
    successTag.setVariant(TagVariant.SUCCESS);
    successTag.add(new Span("Success"));

    Tag neutralTag = new Tag();
    neutralTag.setVariant(TagVariant.NEUTRAL);
    neutralTag.add(new Span("Neutral"));

    Tag warningTag = new Tag();
    warningTag.setVariant(TagVariant.WARNING);
    warningTag.add(new Span("Warning"));

    Tag dangerTag = new Tag();
    dangerTag.setVariant(TagVariant.DANGER);
    dangerTag.add(new Span("Danger"));

    Tag smallTag = new Tag();
    smallTag.setVariant(TagVariant.PRIMARY);
    smallTag.setSize(Size.SMALL);
    smallTag.add(new Span("Small"));

    Tag largeTag = new Tag();
    largeTag.setVariant(TagVariant.PRIMARY);
    largeTag.setSize(Size.LARGE);
    largeTag.add(new Span("Large"));

    Tag pillTag = new Tag();
    pillTag.setVariant(TagVariant.SUCCESS);
    pillTag.setPill(true);
    pillTag.add(new Span("Pill Tag"));

    Tag removableTag = new Tag();
    removableTag.setVariant(TagVariant.DANGER);
    removableTag.setRemovable(true);
    removableTag.add(new Span("Removable"));

    return section(
        "Tag",
        "Tags are labels used to organize items or indicate a selection. They support variants, sizes, pills, and removable behavior.",
        primaryTag, successTag, neutralTag, warningTag, dangerTag,
        smallTag, largeTag, pillTag, removableTag
    );
  }

  // ---------- Tree ----------
  private FlexLayout createTreeSection() {
    Tree tree = new Tree();

    // Root: Documents
    TreeItem documents = new TreeItem();
    documents.add(new Span("Documents"));
    documents.setExpanded(true);

    TreeItem personal = new TreeItem();
    personal.add(new Span("Personal"));
    personal.setExpanded(true);

    TreeItem resume = new TreeItem();
    resume.add(new Span("Resume.pdf"));
    personal.add(resume);

    TreeItem coverLetter = new TreeItem();
    coverLetter.add(new Span("CoverLetter.docx"));
    personal.add(coverLetter);

    TreeItem work = new TreeItem();
    work.add(new Span("Work"));

    TreeItem report = new TreeItem();
    report.add(new Span("Q4-Report.xlsx"));
    work.add(report);

    TreeItem presentation = new TreeItem();
    presentation.add(new Span("Presentation.pptx"));
    work.add(presentation);

    documents.add(personal, work);

    // Root: Pictures
    TreeItem pictures = new TreeItem();
    pictures.add(new Span("Pictures"));

    TreeItem vacation = new TreeItem();
    vacation.add(new Span("Vacation"));

    TreeItem beach = new TreeItem();
    beach.add(new Span("beach.jpg"));
    vacation.add(beach);

    TreeItem sunset = new TreeItem();
    sunset.add(new Span("sunset.png"));
    vacation.add(sunset);

    pictures.add(vacation);

    // Root: Music
    TreeItem music = new TreeItem();
    music.add(new Span("Music"));

    TreeItem rock = new TreeItem();
    rock.add(new Span("Rock"));

    TreeItem song1 = new TreeItem();
    song1.add(new Span("song1.mp3"));
    rock.add(song1);

    TreeItem jazz = new TreeItem();
    jazz.add(new Span("Jazz"));

    TreeItem song2 = new TreeItem();
    song2.add(new Span("smooth.mp3"));
    jazz.add(song2);

    music.add(rock, jazz);

    tree.add(documents, pictures, music);

    return section(
        "Tree / Tree Item",
        "Trees display a hierarchical list of selectable items. Items with children can be expanded and collapsed.",
        tree
    );
  }

  // ---------- Helpers ----------

  private FlexLayout section(String title, String description, Component... content) {
    H2 heading = new H2(title);
    Paragraph desc = new Paragraph(description);
    FlexLayout row = new FlexLayout(FlexDirection.ROW, content);
    row.setStyle("gap", "var(--dwc-space-s)");
    row.setStyle("align-items", "center");
    row.setStyle("flex-wrap", "wrap");
    FlexLayout section = new FlexLayout(FlexDirection.COLUMN, heading, desc, row);
    section.setStyle("gap", "var(--dwc-space-s)");
    return section;
  }

  private FlexLayout labeledValue(String label, Component value) {
    Span labelSpan = new Span(label);
    labelSpan.setStyle("font-weight", "600");
    labelSpan.setStyle("min-width", "160px");
    FlexLayout row = new FlexLayout(FlexDirection.ROW, labelSpan, value);
    row.setStyle("gap", "var(--dwc-space-s)");
    row.setStyle("align-items", "center");
    return row;
  }
}
