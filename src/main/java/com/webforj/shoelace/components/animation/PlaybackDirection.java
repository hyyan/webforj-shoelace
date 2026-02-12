package com.webforj.shoelace.components.animation;

import com.google.gson.annotations.SerializedName;

/**
 * Playback direction options for the Animation component.
 */
public enum PlaybackDirection {
  @SerializedName("normal")
  NORMAL,

  @SerializedName("reverse")
  REVERSE,

  @SerializedName("alternate")
  ALTERNATE,

  @SerializedName("alternate-reverse")
  ALTERNATE_REVERSE;
}
