package com.webforj.shoelace.components.include;

import com.google.gson.annotations.SerializedName;

/**
 * The fetch mode for the Include component.
 */
public enum IncludeMode {
  @SerializedName("cors")
  CORS,

  @SerializedName("no-cors")
  NO_CORS,

  @SerializedName("same-origin")
  SAME_ORIGIN;
}
