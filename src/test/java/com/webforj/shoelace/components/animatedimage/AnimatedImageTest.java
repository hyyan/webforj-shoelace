package com.webforj.shoelace.components.animatedimage;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.webforj.component.element.PropertyDescriptorTester;
import com.webforj.shoelace.event.ErrorEvent;
import com.webforj.shoelace.event.LoadEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class AnimatedImageTest {

  AnimatedImage component;

  @BeforeEach
  void setUp() {
    component = new AnimatedImage();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(AnimatedImage.class, component));
    }

    @Test
    void shouldConstructWithSrc() {
      AnimatedImage image = new AnimatedImage("/images/animation.gif");
      assertEquals("/images/animation.gif", image.getSrc());
    }

    @Test
    void shouldConstructWithSrcAndAlt() {
      AnimatedImage image = new AnimatedImage("/images/animation.gif", "An animation");
      assertEquals("/images/animation.gif", image.getSrc());
      assertEquals("An animation", image.getAlt());
    }

    @Test
    void shouldChainSetters() {
      AnimatedImage result = component
          .setSrc("/images/test.gif")
          .setAlt("Test image")
          .setPlay(true);

      assertEquals(component, result);
      assertEquals("/images/test.gif", component.getSrc());
      assertEquals("Test image", component.getAlt());
      assertEquals(true, component.isPlay());
    }
  }

  @Nested
  @DisplayName("Events API")
  class EventsApi {

    @Test
    void shouldAddLoadListener() {
      component.onLoad(event -> {});
      assertEquals(1, component.getEventListeners(LoadEvent.class).size());
    }

    @Test
    void shouldAddLoadListenerViaAdd() {
      component.addLoadListener(event -> {});
      assertEquals(1, component.getEventListeners(LoadEvent.class).size());
    }

    @Test
    void shouldAddErrorListener() {
      component.onError(event -> {});
      assertEquals(1, component.getEventListeners(ErrorEvent.class).size());
    }

    @Test
    void shouldAddErrorListenerViaAdd() {
      component.addErrorListener(event -> {});
      assertEquals(1, component.getEventListeners(ErrorEvent.class).size());
    }
  }
}
