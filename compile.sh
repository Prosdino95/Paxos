#!/bin/sh

gradle clean
gradle NetworkJar
gradle PaxosJarTestNet
gradle PaxosJarTestNaming
gradle PaxosJarFaultTestNaming
gradle PaxosJarTestProp1
gradle PaxosJarTestProp2
gradle PaxosJarTestNoProp

