package com.blowrunning.game;

public class Props {
  float FOS = 50F;
  Obj lane_1, lane_2;
  float dist;
  Props(String str, float dist) {
    this.dist = dist;
    if("lane_item1".equals(str) || "lane_item2".equals(str)) {
      lane_1 = new Obj(str, 3);
      lane_2 = new Obj(str, 4);
    } else {
      lane_1 = new Obj(str, 1);
      lane_2 = new Obj(str, 2);
    }
  }

  public Obj getObj(int i) {
    if (i == 1) return lane_1;
    return lane_2;
  }
  void render(float delta, float dis1, float dis2) {
    if(dist - dis1 < 50) {
      lane_1.render(delta, (dist - dis1) / FOS);
    }
    if(dist - dis2 < 50) {
      lane_2.render(delta, (dist - dis2) / FOS);
    }
  }
}
