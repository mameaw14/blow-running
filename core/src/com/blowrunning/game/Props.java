package com.blowrunning.game;

public class Props {
  Obj lane_1, lane_2;
  Props(String str) {
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
}
