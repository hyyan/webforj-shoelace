package com.webforj.shoelace.components.carousel;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.webforj.component.element.PropertyDescriptorTester;
import com.webforj.shoelace.components.carousel.event.SlideChangeEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CarouselTest {

  Carousel component;

  @BeforeEach
  void setUp() {
    component = new Carousel();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(Carousel.class, component));
    }

    @Test
    void shouldDefaultLoopToFalse() {
      assertFalse(component.isLoop());
    }

    @Test
    void shouldSetLoop() {
      component.setLoop(true);
      assertTrue(component.isLoop());
    }

    @Test
    void shouldDefaultNavigationToFalse() {
      assertFalse(component.isNavigation());
    }

    @Test
    void shouldSetNavigation() {
      component.setNavigation(true);
      assertTrue(component.isNavigation());
    }

    @Test
    void shouldDefaultPaginationToFalse() {
      assertFalse(component.isPagination());
    }

    @Test
    void shouldSetPagination() {
      component.setPagination(true);
      assertTrue(component.isPagination());
    }

    @Test
    void shouldDefaultAutoplayToFalse() {
      assertFalse(component.isAutoplay());
    }

    @Test
    void shouldSetAutoplay() {
      component.setAutoplay(true);
      assertTrue(component.isAutoplay());
    }

    @Test
    void shouldDefaultAutoplayIntervalTo3000() {
      assertEquals(3000, component.getAutoplayInterval());
    }

    @Test
    void shouldSetAutoplayInterval() {
      component.setAutoplayInterval(5000);
      assertEquals(5000, component.getAutoplayInterval());
    }

    @Test
    void shouldDefaultSlidesPerPageTo1() {
      assertEquals(1, component.getSlidesPerPage());
    }

    @Test
    void shouldSetSlidesPerPage() {
      component.setSlidesPerPage(3);
      assertEquals(3, component.getSlidesPerPage());
    }

    @Test
    void shouldDefaultSlidesPerMoveTo1() {
      assertEquals(1, component.getSlidesPerMove());
    }

    @Test
    void shouldSetSlidesPerMove() {
      component.setSlidesPerMove(2);
      assertEquals(2, component.getSlidesPerMove());
    }

    @Test
    void shouldDefaultOrientationToHorizontal() {
      assertEquals(CarouselOrientation.HORIZONTAL, component.getOrientation());
    }

    @Test
    void shouldSetOrientation() {
      component.setOrientation(CarouselOrientation.VERTICAL);
      assertEquals(CarouselOrientation.VERTICAL, component.getOrientation());
    }

    @Test
    void shouldDefaultMouseDraggingToFalse() {
      assertFalse(component.isMouseDragging());
    }

    @Test
    void shouldSetMouseDragging() {
      component.setMouseDragging(true);
      assertTrue(component.isMouseDragging());
    }

    @Test
    void shouldChainSetters() {
      Carousel result = component
          .setLoop(true)
          .setNavigation(true)
          .setPagination(true)
          .setAutoplay(true)
          .setAutoplayInterval(5000)
          .setSlidesPerPage(2)
          .setSlidesPerMove(1)
          .setOrientation(CarouselOrientation.VERTICAL)
          .setMouseDragging(true);

      assertEquals(component, result);
      assertTrue(component.isLoop());
      assertTrue(component.isNavigation());
      assertTrue(component.isPagination());
      assertTrue(component.isAutoplay());
      assertEquals(5000, component.getAutoplayInterval());
      assertEquals(2, component.getSlidesPerPage());
      assertEquals(1, component.getSlidesPerMove());
      assertEquals(CarouselOrientation.VERTICAL, component.getOrientation());
      assertTrue(component.isMouseDragging());
    }
  }

  @Nested
  @DisplayName("Events API")
  class EventsApi {

    @Test
    void shouldAddSlideChangeListener() {
      component.onSlideChange(event -> {});
      assertEquals(1, component.getEventListeners(SlideChangeEvent.class).size());
    }

    @Test
    void shouldAddSlideChangeListenerViaAdd() {
      component.addSlideChangeListener(event -> {});
      assertEquals(1, component.getEventListeners(SlideChangeEvent.class).size());
    }
  }
}
