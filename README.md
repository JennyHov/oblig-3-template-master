# Obligatorisk oppgave 3 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende student:
* Jenny Hovland, s364545, s364545@oslomet.no


# Oppgavebeskrivelse

I oppgave 1 så gikk jeg frem ved å initialisere p og en hjelpevariabel. Koden fungerer med en while løkke og en if, 
else if og else. I if setningene blir den nye noden brukt til å få riktig verdi. Så blir rotnoden omgjort til p hvis 
q er null. 

I oppgave 2 så startet jeg likt med oppgave 1 med å initialisere p og en hjelpevariabel. I en while løkke får jeg 
sammenlignet verdiene og bruker deretter if setninger for å kunne oppdatere venstrebarnet hvis det er ulike verdier
og hvis det er like verdier oppdaterer jeg høyre barnet. 

I oppgave 3 gikk jeg frem ved å først sjekke om p er en nullverdi ved bruk av en requireNonNull. Gjennom en while løkke 
returnerer første node post orden med p som rot. NestePostorden brukes til å returnere noden som kom etter p. Her har 
jeg også initialisert en variabel som kan brukes som "p.forelder". Returnerer også her null hvis i dette tilfellet, 
forelderen, er null. Forelderverdien h blir da returnert hvis høyrebarn er lik p eller at verdien er null. 

I oppgave 4 prøvde jeg og failet. ER usikker på hvordan jeg skal gå fram og synes det var vanskelig å bruke kompendiet
til denne oppgaven. Følte jeg manglet informasjon. 

I oppgave 5 startet jeg med å initialisere arrayet som verdiene skal inn i, jeg initialiserte også en kø. I binær-
treet(køen) la jeg inn en rot. Jeg tar i bruk en while løkke for å sjekke at treet til køen ikke er tom og at verdier 
fra toppen av køen blir tatt ut og legges inn i arrayet. Returnerer også arrayet til slutt etter å ha lagt inn barna i 
køen. I den deseialiserte arrayet/køen initialiserte jeg et nytt binærtre. Med en enkel for løkke her kunne jeg legge
til verdier i treet for hver verdi som er nytt. Returnerer også treet. 

I oppgave 6 startet jeg med å kopiere koden fra kompendiet som henvist. Klarte også å legge til if setninger for å kunne
referere til foreldrenoden etter fjerningen. I fjernAlle startet jeg med å returnere 0 hvis treet er tomt. Her bruker 
jeg egentlig en enkel while løkke som bruker metoden fjern for å kunne telle antall verdier ved bruk av en hjelpemetode.
Fikk ikke til å fullføre metoden nullstill, skjønner ikke alt av å skulle traversere. 
