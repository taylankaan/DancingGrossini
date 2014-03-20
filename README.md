DancingGrossini
===============

Android Cocos2d Dancing Grossini Animated Sprite
I suggest that use this code remove anything related with CCSprite arka.And instead of it use the code below.

 CCLayer layer = CCColorLayer.node(new ccColor4B(255, 255, 0, 255));
 
        addChild(layer,-7); 
        
        CCIntervalAction action = CCAnimate.action(animation);
        
        grossini.runAction(action);
        
        CCAction action2 = CCRepeatForever.action(
                CCMoveBy.action(2, CGPoint.make(-0,200)));
                
        grossini.runAction(action2);
      
       ------------------------------------------------------------------------------------------------------
       Its up to tou..instead of CCRepeatForever you can just move the person its better..Also you can click and move,
       with the another version of GameLayer above.It moves and animates every click you made.The code for this;
       
       ------------------------------------------------------------------------------------------------
       
       CCSprite grossini;
    CCSprite arka;
    boolean touched;
    private static final int GROSSINI_SPRITE_TAG = 21;
    public GameLayer() {
    	 
    	this.setIsTouchEnabled(true);
    	
    	
        grossini = CCSprite.sprite("grossini.png");
       // arka = CCSprite.sprite("arkaplan.jpg");

       // addChild(arka,-6,10);

         addChild(grossini,-5,GROSSINI_SPRITE_TAG);
    	centerSprites();
    	Log.d("Touch", "Istouchedson"+touched); 
    
        CCLayer layer = CCColorLayer.node(new ccColor4B(255, 255, 0, 255));
        addChild(layer, -7);
       
       
      
      
       grossini.runAction(CCMoveTo.action(1.0f, grossini.getPosition()));
  
       
    
       
       
     
    
    }
    
    @Override
    public boolean ccTouchesBegan(MotionEvent event) {
  
   Istouched();
   animate();
  
        CGPoint convertedLocation = CCDirector.sharedDirector()
        	.convertToGL(CGPoint.make(event.getX(), event.getY()));

        CCNode s = getChildByTag(GROSSINI_SPRITE_TAG);
     
        s.runAction(CCMoveTo.action(1.0f, convertedLocation));
       
        CGPoint pnt = s.getPosition();

        float at = CGPoint.ccpCalcRotate(pnt, convertedLocation);

        s.runAction(CCRotateTo.action(1, at));
        
        Log.d("Touch", "Istouched2"+touched);  

        return CCTouchDispatcher.kEventHandled;
    } 
    @Override
    public boolean ccTouchesEnded(MotionEvent event) {
    	
    	
    	endTouched();
    	// TODO Auto-generated method stub
    	return CCTouchDispatcher.kEventIgnored;
    }
   
   
    public boolean Istouched() {
    	touched=true;
        return touched;
    }
    public boolean endTouched() {
    	touched=false;
        return touched;
    }
   
public void animate(){
	if(touched){
    	CCAnimation animation = CCAnimation.animation("dance", 0.2f);
        for (int i = 1; i < 15; i++) {
           
            animation.addFrame(new CCFormatter().format("grossini_dance_"+i+".png"));
            
           
        
        }
      
    	
    	CCIntervalAction action = CCAnimate.action(animation);
        grossini.runAction(action);
    }
	
	
	
}
	protected void centerSprites() {
        CGSize s = CCDirector.sharedDirector().winSize();

        grossini.setPosition(CGPoint.make(s.width / 3, s.height / 2));
      
    }

 

	public static CCScene scene()
	{
	CCScene scene = CCScene.node();
	CCLayer layer = new GameLayer();
	scene.addChild(layer);
	return scene;
	}
}
