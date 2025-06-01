# IVT Spaceship

## Overview

The project represents an alpha version of a spaceship.

- The ship (`SpaceShip` interface) can fire one or more lasers or torpedos.
- We have only one spaceship as of now (`GT4500`).
- Currently two firing modes (`FiringMode`) are supported: firing only one or all instances of a given weapon type.
- Lasers are not yet implemented, but the code for torpedo stores are ready (`TorpedoStore`).
- For the GT4500 ship the rules for firing torpedoes can be found in the Javadoc comment of method `fireTorpedos`. They are already partially implemented.
- There are currently two tests (`GT4500Test`), but be aware that they are not proper unit tests, as they do not isolate the dependencies of the tested class.

The code can be built, but due to missing features one of the tests fails. The first execercise will be to fix this.
