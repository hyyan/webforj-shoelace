package com.webforj.shoelace.components.avatar;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.webforj.component.element.PropertyDescriptorTester;
import com.webforj.shoelace.event.ErrorEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class AvatarTest {

  Avatar component;

  @BeforeEach
  void setUp() {
    component = new Avatar();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(Avatar.class, component));
    }

    @Test
    void shouldChainSetters() {
      Avatar result = component
          .setImage("https://example.com/avatar.png")
          .setLabel("User avatar")
          .setInitials("AB")
          .setLoading(AvatarLoading.LAZY)
          .setShape(AvatarShape.ROUNDED);

      assertEquals(component, result);
      assertEquals("https://example.com/avatar.png", component.getImage());
      assertEquals("User avatar", component.getLabel());
      assertEquals("AB", component.getInitials());
      assertEquals(AvatarLoading.LAZY, component.getLoading());
      assertEquals(AvatarShape.ROUNDED, component.getShape());
    }
  }

  @Nested
  @DisplayName("Events API")
  class EventsApi {

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
