package practicum;

import org.usb4java.Device;

public class McuWithPeriBoard extends McuBoard
{
    private static final byte RQ_GET_SWITCH = 0;
    private static final byte RQ_GET_UPPER_SOUND = 1;
    private static final byte RQ_GET_LOWER_SOUND = 2;

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
    public boolean getUpperSound()
    {
        byte[] ret = this.read(RQ_GET_UPPER_SOUND, (short) 0, (short) 0);
        return ret[0] == 1;
    }
    public boolean getLowerSound()
    {
        byte[] ret = this.read(RQ_GET_LOWER_SOUND, (short) 0, (short) 0);
        return ret[0] == 1;
    }
}
