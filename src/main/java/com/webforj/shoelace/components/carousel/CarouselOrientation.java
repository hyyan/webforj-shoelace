package com.webforj.shoelace.components.carousel;

import com.google.gson.annotations.SerializedName;

/**
 * The orientation in which the carousel will lay out.
 */
public enum CarouselOrientation {
  @SerializedName("horizontal")
  HORIZONTAL,

  @SerializedName("vertical")
  VERTICAL;
}
