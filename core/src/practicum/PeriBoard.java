package practicum;

import java.util.Arrays;
import java.util.LinkedList;
import org.usb4java.Device;

public class PeriBoard
{
    McuWithPeriBoard peri;
    LinkedList<Boolean>[] p;
    public PeriBoard()
    {
        McuBoard.initUsb();
        p = new LinkedList[2];
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
      int sum = 0;
      for (boolean x: p[i]) {
        if(x) sum++;
      }
      return sum;
    }
    
    public float getSpeed(int i) {
      return sum(i) / 10F;
    }
    
    public void update() {
      for(int i = 0; i < 2; i++) {
        boolean sw = peri.getUpperSound(i + 1);
        p[i].removeFirst();
        p[i].add(sw);
      }
    }
    
    public void dispose() {
      McuBoard.cleanupUsb();
    }
    
    public boolean getSwitch(int x) {
      return peri.getSwitch(x);
    }
    
    public boolean getLowerSound(int x) {
      return peri.getLowerSound(x);
    }
}
