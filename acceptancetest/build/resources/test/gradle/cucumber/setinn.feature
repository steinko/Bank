# This feature covers the account transaction and hardware-driver modules
Feature: Set inn Penger
For å spare
Som en eier av kontoen
Ønker jeg sette inn penger

# Can't figure out how to integrate with magic wand interface
Scenario: Sett inn lovlig belop
Given  Jer person med person id "26076144574"
And  Jeg har 400 kr på sparekonto
When jeg setter inn 200 kr
Then kontoen skal ha en saldo på 600 kr