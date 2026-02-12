package com.webforj.shoelace.components.tabgroup;

import com.google.gson.annotations.SerializedName;

/**
 * Activation modes for the TabGroup component. Controls how tabs are activated when navigated
 * with the keyboard.
 */
public enum Activation {
  @SerializedName("auto")
  AUTO,

  @SerializedName("manual")
  MANUAL;
}
