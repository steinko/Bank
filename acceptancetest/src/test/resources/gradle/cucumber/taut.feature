# This feature covers the account transaction and hardware-driver modules
Feature: Ta Ut Penger
For å kjøpe noen øl 
Som en eier av kontorn
Ønker jeg ta ut penger

# Can't figure out how to integrate with magic wand interface
Scenario: Ta ut lovlig belop
Given person med personId 26076144574
And Jeg har 400 kr på konto
When jeg tar ut 200 kr
Then kontoen skal ha en saldo på 200kr