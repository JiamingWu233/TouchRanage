package xyz.kaming.touchrange;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;

/**
 * https://github.com/JiamingWu233/TouchRange
 * Created by kaming on 2017/12/26.
 */
public class TouchRange {

    private static final float DEFAULT_BOUNDS = 14.0f;

    private Builder builder;

    private TouchRange(Builder builder) {
        this.builder = builder;
    }

    public void change() {
        View parent = (View) this.builder.view.getParent();
        parent.post(new Runnable() {
            @Override
            public void run() {
                Rect rect = new Rect();
                TouchRange.this.builder.view.setEnabled(true);
                TouchRange.this.builder.view.getHitRect(rect);

                rect.left -= TouchRange.this.builder.bounds[0];
                rect.top -= TouchRange.this.builder.bounds[1];
                rect.right += TouchRange.this.builder.bounds[2];
                rect.bottom += TouchRange.this.builder.bounds[3];

                TouchDelegate touchDelegate = new TouchDelegate(rect, TouchRange.this.builder.view);

                if (View.class.isInstance(TouchRange.this.builder.view.getParent())) {
                    ((View) TouchRange.this.builder.view.getParent()).setTouchDelegate(touchDelegate);
                }
            }
        });
    }

    public static Builder let(View v) {
        return new Builder(v);
    }

    public static class Builder {

        private View view;
        private int[] bounds;

        Builder(View view) {
            this.view = view;
        }

        /**
         * set touch bounds
         *
         * @param bounds Touch bounds value(left,top,right,bottom),the value unit is dp.
         *               If you do not set the bounds value, the default value is 20dp.
         * @return {@link #TouchRange}
         */
        public TouchRange bounds(float... bounds) {
            if (bounds.length == 0) {
                int bound = dp2px(DEFAULT_BOUNDS);
                this.bounds = new int[]{bound, bound, bound, bound};
            }
            if (bounds.length == 1) {
                int bound = dp2px(bounds[0]);
                this.bounds = new int[]{bound, bound, bound, bound};
            }
            if (bounds.length == 2) {
                int bound0 = dp2px(bounds[0]);
                int bound1 = dp2px(bounds[1]);
                this.bounds = new int[]{bound0, bound1, bound0, bound1};
            }
            if (bounds.length == 3) {
                this.bounds = new int[]{dp2px(bounds[0]), dp2px(bounds[1]),
                        dp2px(bounds[0]), 0};
            }
            if (bounds.length == 4) {
                this.bounds = new int[]{dp2px(bounds[0]), dp2px(bounds[1]),
                        dp2px(bounds[2]), dp2px(bounds[3])};
            }
            return new TouchRange(this);
        }

        /**
         * dp to px
         */
        private int dp2px(float dpValue) {
            return (int) (0.5f + dpValue * Resources.getSystem().getDisplayMetrics().density);
        }

    }


}
