#include <avr/io.h>
#include <avr/interrupt.h>  /* for sei() */
#include <util/delay.h>     /* for _delay_ms() */
#include <avr/pgmspace.h>   /* required by usbdrv.h */

#include "peri.h"
#include "usbdrv.h"

#define RQ_GET_SWITCH      0
#define RQ_GET_UPPER_SOUND 1
#define RQ_GET_LOWER_SOUND 2

/* ------------------------------------------------------------------------- */
/* ----------------------------- USB interface ----------------------------- */
/* ------------------------------------------------------------------------- */
usbMsgLen_t usbFunctionSetup(uint8_t data[8])
{
    usbRequest_t *rq = (void *)data;
	static uint16_t light;

    /* declared as static so they stay valid when usbFunctionSetup returns */
    static uint8_t switch_state;  

        switch_state = !(PINC&(1 << rq->bRequest));

        /* point usbMsgPtr to the data to be returned to host */
        usbMsgPtr = &switch_state;

        /* return the number of bytes of data to be returned to host */
        return 1;

    /* default for not implemented requests: return no data back to host */
    return 0;
}

/* ------------------------------------------------------------------------- */
int main(void)
{
    init_peripheral();

    usbInit();

    /* enforce re-enumeration, do this while interrupts are disabled! */
    usbDeviceDisconnect();
    _delay_ms(300);
    usbDeviceConnect();

    /* enable global interrupts */
    sei();

    /* main event loop */
    for(;;)
    {
        usbPoll();
    }

    return 0;
}

/* ------------------------------------------------------------------------- */
