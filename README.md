# Blow Running
* Running game
* Multiplayer
* Need unique controller

## How to play
1. blow = run
2. shout = activate Lane Item
3. first press button = activate global item
4. first to goal = WIN!

## Project Developers
We are students of the Faculty of Computer Engineering at Kasetsart University
* [Mameaw14](https://github.com/mameaw14)
* [natachit](https://github.com/natachit)

## Files
* **core/** - Java code of the game
* **desktop/** - Java build file for desktop
* **firmware/** - C files firmware for controller

## Setup
**controller** change directory to firmware/
```c
make main.flash
```
**Java game**
```java
./gradlew run
```

## Libraries and Tools
### software
**Java**
- [libGDX](https://github.com/libGDX/libGDX)
- [libusb4java](https://github.com/usb4java/libusb4java)

**C**
- [v-usb](https://github.com/obdev/v-usb)

### hardware
- Practicum Board v3 CPE, KU 06/2013
- Sound Sensors
- LED Buttons