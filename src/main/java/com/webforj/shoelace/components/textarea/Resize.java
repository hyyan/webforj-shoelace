package com.webforj.shoelace.components.textarea;

import com.google.gson.annotations.SerializedName;

/**
 * Controls how the textarea can be resized.
 */
public enum Resize {
  @SerializedName("none")
  NONE,

  @SerializedName("vertical")
  VERTICAL,

  @SerializedName("auto")
  AUTO;
}
