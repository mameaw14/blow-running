package com.blowrunning.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import java.util.Map;
import java.util.TreeMap;

public class Maps implements Entity {
  Map<Integer, Sprite> map;
  
  Maps() {
    Texture grass = new Texture("grass.png");
    Texture flag = new Texture("flag.png");
    map = new TreeMap<Integer, Sprite>();
    map.put(100, new Sprite(grass));
    map.put(200, new Sprite(grass));
    map.put(140, new Sprite(flag));
    for(int key: map.keySet()) {
      System.out.println(key + " - " + map.get(key));
    }
  }
  @Override
  public void render(float delta) {
    Sprite sprite = map.get(100);
    sprite.setPosition(BlowrunningGame.WIDTH/3, 500);
  }
}
