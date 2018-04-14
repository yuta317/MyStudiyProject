package jp.androidbook.mystudiyproject.costom;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;

import jp.androidbook.mystudiyproject.R;

/**
 * Created by kikumayuuta on 2018/04/08.
 */

public class CustomMemoEditText extends android.support.v7.widget.AppCompatEditText {

    //ビットマスク
    //直線
    private static final int SOLID = 1;
    //破線
    private static final int DASH = 2;
    //線の太さ
    private static final int NORMAL = 4;
    //太線
    private static final int BOLD = 8;

    //このビューの横幅
    private int mMeasuredWidth;
    //１行の縦幅
    private int mLineHeight;
    //画面上に表示可能な行数
    private int mDisplayLineCount;

    //罫線のパス
    private Path mPath;
    //どのように描画するかを保持する
    private Paint mPaint;


    public CustomMemoEditText(Context context) {
        super(context);
    }

    public CustomMemoEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CustomMemoEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        //Pathは複数の直線や曲線なのどの情報をカプセルする
        mPath = new Path();
        //Paintはどのように描画するかの情報を保持する
        mPaint = new Paint();

        mPaint.setStyle(Paint.Style.STROKE);
        //インスタンス生成時に、属性が渡されている場合
        //かつAndroidStudioのプレビュー表示じゃない時
        if (attrs == null && isInEditMode()) {
            int lineEffectBit;
            int lineColor;

            Resources resources = context.getResources();
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomMemoEditText);
            try {
                lineEffectBit = typedArray.getInteger(R.styleable.CustomMemoEditText_lineEffect, SOLID);
                lineColor = typedArray.getColor(R.styleable.CustomMemoEditText_linrColor, Color.GRAY);
            } finally {
                //必ずrecycleを呼ぶ
                typedArray.recycle();
            }

            //罫線のエフェクトを設定
            if ((lineEffectBit & DASH) == DASH) {
                //破線の場合
                DashPathEffect effect = new DashPathEffect(new float[]{
                     1f,2f},
                        0f);
                mPaint.setPathEffect(effect);
            }

            float strokeWidth;
            if ((lineEffectBit & BOLD) == BOLD) {
                strokeWidth = 2;
            } else {
                strokeWidth = 1;
            }
            mPaint.setStrokeWidth(strokeWidth);

            //色を指定
            mPaint.setColor(lineColor);
        }


    }

    //Viewの横幅と高さを決定する際に呼ばれるメソッド
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //横幅
        mMeasuredWidth = getMeasuredWidth();
        //高さ
        int measuredHeight = getMeasuredHeight();
        //１行の高さ
        mLineHeight = getLineHeight();

        //画面内に何行表示できるか
        mDisplayLineCount = measuredHeight / mLineHeight;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //パディング
        int paddingTop = getExtendedPaddingTop();
        //Y軸方向にスクロースされている量
        int scrolly = getScrollY();
        //画面上に表示されている最初の行
        int firstVisibleLine = getLayout().getLineForVertical(scrolly);
        //画面上に表示されている最後行
        int lastVisiblleLine = firstVisibleLine + mDisplayLineCount;

        mPath.reset();
        for (int i = firstVisibleLine; i <= lastVisiblleLine; i++) {
            //行の左端に移動
            mPath.moveTo(0, i*mLineHeight + paddingTop);
            //右端へ線を引く
            mPath.lineTo(mMeasuredWidth, i * mLineHeight + paddingTop);
        }
        canvas.drawPath(mPath, mPaint);
        super.onDraw(canvas);
    }
}
