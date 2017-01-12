package com.example.androidstudiogamedevelopmenttest;

/**
 * Created by WhiteWalker on 17/12/2016.
 */

public class GameView extends GLSurfaceView {
    private final GameRenderer gameRenderer;
    private GestureDetector gd;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gd = new GestureDetector(this, gestureListener);
    }

    public GameView(Context context) {
        super(context);
        setEGLContextClientVersion(2);
        gameRenderer = new GameRenderer(context);
        setRenderer(gameRenderer);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//get the non-touchable area of the screen -
//the upper 2/3rds of the screen
        Point size = new Point();
        activity.getWindowManager().getDefaultDisplay().getSize(size);
        //get the center point of the screen
        int width = size.x / 2;
        int height = size.y / 3;
        //the playable area is now the lower 3rd of the screen
        int playableArea = size.y - height;
        if (y > playableArea) {
//this y coordiate is within the touch zone
            if (x < center) {
//The player touched the left
            } else {
//The player touched the right
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gd.onTouchEvent(event);
    }

    GestureDetector.SimpleOnGestureListener gestureListener = new
            GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onDown(MotionEvent arg0) {
// TODO Auto-generated method stub
                    return false;
                }

                @Override
                public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                                       float velocityY) {
//React to the fling action
                    return false;
                }

                @Override
                public void onLongPress(MotionEvent e) {
// TODO Auto-generated method stub
                }

                @Override
                public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                                        float distanceY) {
// TODO Auto-generated method stub
                    return false;
                }

                @Override
                public void onShowPress(MotionEvent e) {
// TODO Auto-generated method stub
                }

                @Override
                public boolean onSingleTapUp(MotionEvent e) {
// TODO Auto-generated method stub
                    return false;
                }
            };

    float leftMotion = e1.getX() - e2.getX();
    float upMotion = e1.getY() - e2.getY();
    float rightMotion = e2.getX() - e1.getX();
    float downMotion = e2.getY() - e1.getY();
    if((leftMotion==Math.max(leftMotion,rightMotion))&&
            (leftMotion>Math.max(downMotion,upMotion)))

    {
//The player moved left
    }

    if((rightMotion==Math.max(leftMotion,rightMotion))
            &&rightMotion>Math.max(downMotion,upMotion))

    {
//The player moved right
    }

    if((upMotion==Math.max(upMotion,downMotion))
            &&(upMotion>Math.max(leftMotion,rightMotion)))

    {
//The player moved up
    }

    if((downMotion==Math.max(upMotion,downMotion))
            &&(downMotion>Math.max(leftMotion,rightMotion)))

    {
//The player moved down
    }


    float heroMove = 0;
    public void setHeroMove(float movement){
        heroMove = movement;
    }
    public float getHeroMove(){
        return heroMove;
    }

    public boolean onTouchEvent(MotionEvent e) {
        float x = e.getX();
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (x < getWidth() / 2) {
                    gameRenderer.setHeroMove(gameRenderer.getHeroMove() + .1f);
                }
                if (x > getWidth() /2){
                    gameRenderer.setHeroMove(gameRenderer.getHeroMove() - .1f);
                }
        }
        return true;
    }

}