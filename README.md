DancingGrossini
===============

Android Cocos2d Dancing Grossini Animated Sprite
Its prepared using cocos2D android game engine.To make sprite dance or move you can use this code..
There is also backgorund moving for just trying but you can remove the code in GameLayer;
   // arka = CCSprite.sprite("arkaplan.jpg");

       // addChild(arka,-6,10);
//CCAction action2 = CCRepeatForever.action(
  //              CCMoveBy.action(2, CGPoint.make(-1000, 0)));
       
    //    arka.runAction(action2);
        
Because it has problem with scaling and setting position..You can use to make yellow background.Instead of it.
CCLayer layer = CCColorLayer.node(new ccColor4B(255, 255, 0, 255)); //Makes the background yellow
            addChild(layer, -1);
            
 At last if you want to make your sprite move can be added.If it were a walking sprite instead of dancing you would see
 a good animation.But still its good to see how its done.
 CCAction action2 = CCRepeatForever.action(
                CCMoveBy.action(2, CGPoint.make(0, 200)));
       
        grossini.runAction(action2);
       
            
