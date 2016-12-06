#include <avr/io.h>
#include "peri.h"

void init_peripheral()
{
	DDRC &= ~((1<<PC0)|(1<<PC1)|(1<<PC2));
	PORTC |= (1<<PC0)|(1<<PC1)|(1<<PC2);
	DDRB &= ~((1<<PB0)|(1<<PB1)|(1<<PB2));
	PORTB |= (1<<PB0)|(1<<PB1)|(1<<PB2);
}

