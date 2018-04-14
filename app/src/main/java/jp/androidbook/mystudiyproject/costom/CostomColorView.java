package jp.androidbook.mystudiyproject.costom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


public class CostomColorView extends View {
    private int color;
    private Paint paint;
    private Rect rect;
    private int status = 0;

    public CostomColorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        paint = new Paint();
        paint.setColor(getColor());
        rect = new Rect();
    }

    @Override
    protected void onSizeChanged(int w, int h, int old_w, int old_h) {
        rect.left = w/10;
        rect.top = h/10;
        rect.right = w*3/10;
        rect.bottom = h*3/10;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(rect, paint);
    }


    public int getColor() {

        switch(this.status) {
            case 0:
                color = Color.RED;
                break;
            case 1:
                color = Color.GREEN;
                break;
            default:
                color = Color.BLACK;
        }
        return color;
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        if(e.getAction() == MotionEvent.ACTION_DOWN) {
            status = (status >= 1) ? 0 : status+1;
            paint.setColor(getColor());
            invalidate();
        }
        return true;
    }
}
