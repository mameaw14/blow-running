
package com.blowrunning.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class World {
    public SpriteBatch batch;
    private Runner runner1, runner2;
    private BlowrunningGame blowrunningGame;
    
    World (BlowrunningGame blowrunningGame){
        runner1 = new Runner(10, 600, this);
        runner2 = new Runner(10, 600, this);
        this.blowrunningGame = blowrunningGame;
    }
}
