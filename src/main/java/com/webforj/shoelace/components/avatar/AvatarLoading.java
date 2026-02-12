package com.webforj.shoelace.components.avatar;

import com.google.gson.annotations.SerializedName;

/**
 * Loading strategies for the Avatar component image.
 */
public enum AvatarLoading {
  @SerializedName("eager")
  EAGER,

  @SerializedName("lazy")
  LAZY;
}
