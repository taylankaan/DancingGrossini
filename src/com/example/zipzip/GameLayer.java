package com.example.zipzip;

import java.util.ArrayList;

import org.cocos2d.actions.CCProgressTimer;
import org.cocos2d.actions.base.CCAction;
import org.cocos2d.actions.base.CCRepeatForever;
import org.cocos2d.actions.instant.CCCallFunc;
import org.cocos2d.actions.interval.CCAnimate;
import org.cocos2d.actions.interval.CCFadeIn;
import org.cocos2d.actions.interval.CCFadeOut;
import org.cocos2d.actions.interval.CCIntervalAction;
import org.cocos2d.actions.interval.CCJumpTo;
import org.cocos2d.actions.interval.CCMoveBy;
import org.cocos2d.actions.interval.CCMoveTo;
import org.cocos2d.actions.interval.CCRotateTo;
import org.cocos2d.actions.interval.CCSequence;
import org.cocos2d.events.CCTouchDispatcher;
import org.cocos2d.layers.CCColorLayer;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCAnimation;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCLabel;
import org.cocos2d.nodes.CCNode;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.nodes.CCSpriteFrame;
import org.cocos2d.nodes.CCSpriteFrameCache;
import org.cocos2d.nodes.CCSpriteSheet;

import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGSize;
import org.cocos2d.types.ccColor4B;
import org.cocos2d.utils.CCFormatter;




import android.util.Log;
import android.view.MotionEvent;
public class GameLayer extends CCLayer  {


    CCSprite grossini;
    CCSprite arka;
    private static final int GROSSINI_SPRITE_TAG = 21;
    public GameLayer() {
    	 
  
    	
    	
        grossini = CCSprite.sprite("grossini.png");
        arka = CCSprite.sprite("arkaplan.jpg");

        addChild(arka,-6,10);

         addChild(grossini,-5,GROSSINI_SPRITE_TAG);
    	centerSprites();
    	
    	CCAnimation animation = CCAnimation.animation("dance", 0.2f);
        for (int i = 1; i < 15; i++) {
           
            animation.addFrame(new CCFormatter().format("grossini_dance_"+i+".png"));
		
        }

        
       
       
       CCIntervalAction action = CCAnimate.action(animation);
        grossini.runAction(action);
        CCAction action2 = CCRepeatForever.action(
                CCMoveBy.action(2, CGPoint.make(-1000, 0)));
       
        arka.runAction(action2);
       
    
       
        
      
     
    
    }
   
   

	protected void centerSprites() {
        CGSize s = CCDirector.sharedDirector().winSize();

        grossini.setPosition(CGPoint.make(s.width / 3, s.height / 2));
        /*arka.setScaleX(s.width/arka.getTexture().getWidth());

        arka.setScaleY(s.height/arka.getTexture().getHeight());

        arka.setPosition(CGPoint.make(s.width/2, s.height/2));

        Log.d("uzunluk","geniþlik"+arka.getTexture().getWidth());
      
    */
    }

 

	public static CCScene scene()
	{
	CCScene scene = CCScene.node();
	CCLayer layer = new GameLayer();
	scene.addChild(layer);
	return scene;
	}
}

