package com.webforj.shoelace.components.splitpanel;

import com.google.gson.annotations.SerializedName;

/**
 * Primary panel options for the SplitPanel component. Designates which panel maintains its size
 * when the host element is resized.
 */
public enum Primary {
  @SerializedName("start")
  START,

  @SerializedName("end")
  END;
}
