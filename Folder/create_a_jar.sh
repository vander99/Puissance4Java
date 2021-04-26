#!/bin/bash
make release
cd build
jar -cfe puissance.jar Main Players/Player.class Players/IA.class Players/Human.class Management/Grid.class Management/Round.class Features/Display.class Features/Errors.class Features/History.class Features/Scan.class Main.class
cd ..
cp build/puissance.jar puissance.jar
