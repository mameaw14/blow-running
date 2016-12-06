package practicum;

import org.usb4java.Device;

public class TestUsb {
    public static void main(String[] args){
        McuBoard.initUsb();
        Device[] devs = McuBoard.findBoards();
        McuWithPeriBoard c = new McuWithPeriBoard(devs[0]);
        c.setLedValue(4);
        System.out.println(c.getLight());
        McuBoard.cleanupUsb ();
    }
}
