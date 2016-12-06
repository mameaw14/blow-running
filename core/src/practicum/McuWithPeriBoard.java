package practicum;

import org.usb4java.Device;

public class McuWithPeriBoard extends McuBoard
{
    private static final byte RQ_GET_SWITCH    = 2;

    public McuWithPeriBoard(Device device) {
		super(device);
	}

    /**
     * Check the state of the switch
     * 
     * @return true when the switch is pressed; false otherwise
     */
    public boolean getSwitch()
    {
        byte[] ret = this.read(RQ_GET_SWITCH, (short) 0, (short) 0);
        return ret[0] == 1;
    }
}
