package practicum;

import java.util.LinkedList;
import org.usb4java.Device;

public class TestPeri
{
    McuWithPeriBoard peri;
    LinkedList<Boolean> q;
    int s;
    public TestPeri()
    {
        McuBoard.initUsb();

        try
        {
        	Device[] devices = McuBoard.findBoards();
        	
        	if (devices.length == 0) {
                System.out.format("** Practicum board not found **\n");
                return;
        	}
        	else {
                System.out.format("** Found %d practicum board(s) **\n", devices.length);
        	}
            peri = new McuWithPeriBoard(devices[0]);

            System.out.format("** Practicum board found **\n");
            System.out.format("** Manufacturer: %s\n", peri.getManufacturer());
            System.out.format("** Product: %s\n", peri.getProduct());
            
            q = new LinkedList<Boolean>();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    
    int sum() {
      if(q.size() > 25) q.removeFirst();
      int sum = 0;
      for (boolean x: q) {
        if(x) sum++;
      }
      return sum;
    }
    public float getSpeed() {
      return sum() / 2F;
    }
    public void update() {
      boolean sw = peri.getLowerSound();
      System.out.println(sw);
      q.add(sw);
      s = sum();
    }
    public void dispose() {
      McuBoard.cleanupUsb();
    }
    public boolean getSwitch(int x) {
      return peri.getSwitch(x);
    }
}
