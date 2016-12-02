/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blowrunning.game;

import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author natachit
 */
public class Runner {
    private Vector2 position;
    
    public Runner (int x, int y, World world) {
        position = new Vector2 (x, y);
    }
    
    public void updatePosition(){
        position.x++;
    }
}
