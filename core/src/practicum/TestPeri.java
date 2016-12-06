package practicum;

import java.util.LinkedList;
import org.usb4java.Device;

public class TestPeri
{
    public static void main(String[] args) throws Exception
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
            McuWithPeriBoard peri = new McuWithPeriBoard(devices[0]);

            System.out.format("** Practicum board found **\n");
            System.out.format("** Manufacturer: %s\n", peri.getManufacturer());
            System.out.format("** Product: %s\n", peri.getProduct());

            int count = 0;
            LinkedList<Boolean> q;
            q = new LinkedList<Boolean>();
            float speed = 0;
            while (true) 
            {
                Thread.sleep(90);
                //peri.setLedValue(count);
                boolean sw = peri.getSwitch();
                //int light = peri.getLight();
                System.out.format("Switch state: %s\n",
                         sw);
                q.add(sw);
                System.out.println(sum(q));
                if (count > 7) count = 0;
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        McuBoard.cleanupUsb();
    }
    
    static int sum(LinkedList<Boolean> q) {
      if(q.size() > 25) q.removeFirst();
      int sum = 0;
      for (boolean x: q) {
        if(x) sum++;
      }
      return sum;
    }
}
