package com.webforj.shoelace.components.popup;

import com.google.gson.annotations.SerializedName;

/**
 * Flip fallback strategy options for the Popup component.
 */
public enum FlipFallbackStrategy {
  @SerializedName("best-fit")
  BEST_FIT,

  @SerializedName("initial")
  INITIAL;
}
