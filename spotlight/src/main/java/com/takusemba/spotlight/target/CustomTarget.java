package com.takusemba.spotlight.target;

import android.animation.TimeInterpolator;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.LayoutRes;
import com.takusemba.spotlight.OnTargetStateChangedListener;
import com.takusemba.spotlight.shape.Shape;

/**
 * CustomTarget can set your own custom view for a overlay.
 * If you do not care about much about a overlay, consider using {@link SimpleTarget} instead.
 **/
public class CustomTarget extends Target {

  private CustomTarget(Shape shape, Rect rect, RectSupplier deferredRectSupplier, View overlay,
      long duration, boolean autoStart, TimeInterpolator animation,
      OnTargetStateChangedListener listener) {
    super(shape, rect, deferredRectSupplier, overlay, duration, autoStart, animation, listener);
  }

  public static class Builder extends AbstractTargetBuilder<Builder, CustomTarget> {

    @Override protected Builder self() {
      return this;
    }

    private View overlay;

    public Builder(Activity context) {
      super(context);
    }

    public Builder setOverlay(@LayoutRes int layoutId) {
      this.overlay = getContext().getLayoutInflater().inflate(layoutId, null);
      return this;
    }

    public Builder setOverlay(View overlay) {
      this.overlay = overlay;
      return this;
    }

    @Override public CustomTarget build() {
      return new CustomTarget(shape, rect, deferredRectSupplier, overlay, duration, autoStart,
          animation, listener);
    }
  }
}
