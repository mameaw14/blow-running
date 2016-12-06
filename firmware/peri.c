#include <avr/io.h>
#include "peri.h"

void init_peripheral()
{
	DDRC &= ~((1<<PC0)|(1<<PC1)|(1<<PC2));
	PORTC |= (1<<PC0)|(1<<PC1)|(1<<PC2);
}

