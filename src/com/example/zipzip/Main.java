package com.example.zipzip;

import org.cocos2d.actions.CCProgressTimer;
import org.cocos2d.actions.base.CCRepeatForever;
import org.cocos2d.actions.interval.CCFadeIn;
import org.cocos2d.actions.interval.CCFadeOut;
import org.cocos2d.actions.interval.CCJumpTo;
import org.cocos2d.actions.interval.CCMoveTo;
import org.cocos2d.actions.interval.CCRotateTo;
import org.cocos2d.actions.interval.CCSequence;
import org.cocos2d.events.CCTouchDispatcher;
import org.cocos2d.layers.CCColorLayer;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCLabel;
import org.cocos2d.nodes.CCNode;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.opengl.CCGLSurfaceView;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.ccColor4B;





import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;

public class Main extends Activity {
	public static Main app;
    private CCGLSurfaceView mGLSurfaceView;
GameLayer g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app = this;
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        
        mGLSurfaceView = new CCGLSurfaceView(this);
        setContentView(mGLSurfaceView);
        
        // attach the OpenGL view to a window
         
    }

    @Override
    public void onStart() {
    	  super.onStart();
    	   // attach the OpenGL view to a window
    	
  		CCDirector director = CCDirector.sharedDirector();
  		director.attachInView(mGLSurfaceView);
  		director.setDeviceOrientation(CCDirector.kCCDeviceOrientationPortrait);
  		CCDirector.sharedDirector().setAnimationInterval(1.0f / 60.0f);
  		CCDirector.sharedDirector().setDisplayFPS(true);
  		CCScene scene =  GameLayer.scene(); //  
  		CCDirector.sharedDirector().runWithScene(scene); 

    }

    @Override
    public void onPause() {
        super.onPause();

        CCDirector.sharedDirector().onPause();
    }

    @Override
    public void onResume() {
        super.onResume();

        CCDirector.sharedDirector().onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        CCDirector.sharedDirector().end();
    }



}
