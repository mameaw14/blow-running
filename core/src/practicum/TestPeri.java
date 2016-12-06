package practicum;

import java.util.Arrays;
import java.util.LinkedList;
import org.usb4java.Device;

public class TestPeri
{
    McuWithPeriBoard peri;
    LinkedList<Boolean>[] p;
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
            
            p[0] = new LinkedList<Boolean>(Arrays.asList(false, false, false, 
                false, false, false, false, false, false, false, false, false, 
                false, false, false, false, false, false, false, false, false, 
                false, false, false, false));
            p[1] = new LinkedList<Boolean>(Arrays.asList(false, false, false, 
                false, false, false, false, false, false, false, false, false, 
                false, false, false, false, false));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    
    int sum(int i) {
      i = i - 1;
      if(p[i].size() > 25) p[i].removeFirst();
      int sum = 0;
      for (boolean x: p[i]) {
        if(x) sum++;
      }
      return sum;
    }
    
    public float getSpeed(int i) {
      return sum(i) / 5F;
    }
    
    public void update() {
      boolean sw1 = peri.getLowerSound(1);
      p[0].add(sw1);
      sum(0);
      
      boolean sw2 = peri.getLowerSound(2);
      p[1].add(sw2);
      sum(1);
    }
    
    public void dispose() {
      McuBoard.cleanupUsb();
    }
    public boolean getSwitch(int x) {
      return peri.getSwitch(x);
    }
}
