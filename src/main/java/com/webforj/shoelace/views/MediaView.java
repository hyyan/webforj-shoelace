package com.webforj.shoelace.views;

import com.webforj.component.Component;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.*;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;
import com.webforj.shoelace.components.animatedimage.AnimatedImage;
import com.webforj.shoelace.components.animation.Animation;
import com.webforj.shoelace.components.icon.Icon;
import com.webforj.shoelace.components.imagecomparer.ImageComparer;
import com.webforj.shoelace.components.include.Include;

@Route(value = "/media", outlet = MainLayout.class)
@FrameTitle("Media")
public class MediaView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public MediaView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setStyle("padding", "var(--dwc-space-l)")
        .setStyle("gap", "var(--dwc-space-xl)")
        .setStyle("max-width", "900px");

    self.add(
        createAnimatedImageSection(),
        createAnimationSection(),
        createImageComparerSection(),
        createIncludeSection());
  }

  private Component createAnimatedImageSection() {
    AnimatedImage animatedImage = new AnimatedImage();
    animatedImage.setSrc("https://shoelace.style/assets/images/walk.gif");
    animatedImage.setAlt("Animation of a person walking");
    animatedImage.setStyle("width", "150px");

    Paragraph description = new Paragraph();
    description.setText(
        "AnimatedImage displays animated GIFs and WEBPs that play and pause on interaction. "
            + "Hover over or click the image to toggle playback.");

    return section("Animated Image", description, animatedImage);
  }

  private Component createAnimationSection() {
    Icon icon = new Icon("arrow-counterclockwise");
    icon.setStyle("font-size", "2rem").setStyle("color", "var(--sl-color-primary-600)");

    Animation animation = new Animation();
    animation.setName("bounce");
    animation.setDuration(2000);
    animation.setIterations("Infinity");
    animation.setPlay(true);
    animation.add(icon);

    Paragraph description = new Paragraph();
    description.setText(
        "Animation wraps any element and applies Web Animations API-based effects. "
            + "This example uses the built-in 'bounce' animation running infinitely.");

    Div animationContainer = new Div();
    animationContainer.setStyle("padding", "var(--dwc-space-l)")
        .setStyle("display", "flex")
        .setStyle("justify-content", "center");
    animationContainer.add(animation);

    return section("Animation", description, animationContainer);
  }

  private Component createImageComparerSection() {
    Img beforeImage = new Img();
    beforeImage.setAttribute("src",
        "https://images.unsplash.com/photo-1517331156700-3c241d2b4d83?w=800&q=80");
    beforeImage.setAttribute("alt", "Before image - a cat photo");
    beforeImage.setStyle("width", "100%");

    Img afterImage = new Img();
    afterImage.setAttribute("src",
        "https://images.unsplash.com/photo-1559181567-c3190ca9959b?w=800&q=80");
    afterImage.setAttribute("alt", "After image - a different cat photo");
    afterImage.setStyle("width", "100%");

    ImageComparer imageComparer = new ImageComparer();
    imageComparer.setPosition(50);
    imageComparer.addToBefore(beforeImage);
    imageComparer.addToAfter(afterImage);
    imageComparer.setStyle("max-width", "600px");

    Paragraph description = new Paragraph();
    description.setText(
        "ImageComparer lets you compare visual differences between two images side by side. "
            + "Drag the divider to reveal more or less of each image. The position is set to 50%.");

    return section("Image Comparer", description, imageComparer);
  }

  private Component createIncludeSection() {
    Include include = new Include();
    include.setSrc("https://shoelace.style/assets/examples/include.html");

    Paragraph description = new Paragraph();
    description.setText(
        "Include embeds external HTML files into the page. It fetches the content from "
            + "the specified URL and renders it inline. Be sure you trust the content you are "
            + "including, as it will be executed as code.");

    return section("Include", description, include);
  }

  private FlexLayout section(String title, Component... content) {
    FlexLayout layout = new FlexLayout();
    layout.setDirection(FlexDirection.COLUMN);
    layout.setStyle("gap", "var(--dwc-space-m)")
        .setStyle("padding", "var(--dwc-space-l)")
        .setStyle("border", "1px solid var(--dwc-color-default)")
        .setStyle("border-radius", "var(--dwc-border-radius-m)");

    H3 heading = new H3();
    heading.setText(title);
    heading.setStyle("margin", "0");

    layout.add(heading);
    layout.add(content);

    return layout;
  }
}
