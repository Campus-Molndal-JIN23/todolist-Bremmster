# Ditt namn
Kristian Karlson
## Egna reflektioner

## Projektet
En applikation för att hålla reda på att göra uppgifter, kopplade till användare. 
### Beskrivning av projektet

### Vad du har gjort

## Planering
Grovplanering
```mermaid
flowchart LR 
    A[Hacka]
    A --> C{Fungerar?}
    C -->|Nej| A
    C --> Ja
```

### Lösningsförslag innan uppgiften påbörjas

#### Skisser (exempelvis)
 todo sekvensdiagram av application ??? och databas. Ta med objekt

classdiagram med hjälpklassena som pekar på application

#### Hur du tänker försöka lösa uppgiften.(exempelvis)

#### Pseudokod.(exempelvis)

#### Diagram.(exempelvis)

### Jira/Trello/Github Project och projekthantering enligt Scrum/Kanban

klipp in bild på board

## Arbetet och dess genomförande

### Vad som varit svårt
Skriva bra tester, den testbara koden är klämd mellan application som bara har privata metoder och tar in input av användaren. Och klassen som hanterar databasen. 
Lektionen hur man skapar en CI pipe levererade inte fungerade exempel

### Beskriv lite olika lösningar du gjort
Fick problem med att databasen var ansluten flera gånger, gjorde om anslutningen till singleton.
Använder mig av två fasader för anslutningen till databas, en för saker som rör användaren den andra för todos.

### Beskriv något som var besvärligt att få till
Började med att skriva programmet mot nivån G. När det var klart började jag med VG delen med den tidigare lösningen behövde jag ändra för mig förvånansvärt mycket kod.

### Beskriv om du fått byta lösning och varför i sådana fall
Min första tanke var att Application.class bara skulle innehålla switchar och all kod skulle finnas i fasadklasserna. Det gjorde det svårt att skriva tester.
Så kod har flyttats ifrån fasadklasserna til application. 

## Reflektion & Slutsatser
Det är mycket roligare att skriva kod tillsammans i grupp, man bollar idéer och blir kreativare när man samarbetar.
När man kör själv är det lätt att glömma av att använda sin kanban board och man missar att reflektera över koden under pågående projekt. 
Periodvis var många uppgifter igång parallelt ett resultat av att jag kodade mot development istället för att skapa feature branches.

### Vad gick bra
Appen begränsar vad en användare kan mata in. Koden kan inte bli utsatt för sql injections. Klart i tid.
Scanner finns bara i en klass, lätt att kontrollera beteendet. All text finns på ett ställe, lätt att översätta appen till annat språk.

### Vad gick dåligt
Det finns några tester som egentligen inte säger jättemycket om hur applikationen fungerar. 
Ganska många av testerna är skriva efter koden.


### Vad har du lärt dig
Hur man skapar en CI pipe. Planerat och genomfört ett projekt på egen hand.
Reflekterat kring metodiken HTDF (Hacka tills det funkar) och sen skriva tester, Kontra TDD där testerna ska skapas före koden.



### Vad hade ni gjort annorlunda om ni gjort om projektet
Börjat med att skapa CI pipe. Börjat skriva test före koden, det skulle sparat tid vid refactoring. Jag visste med mig från börja att ambitionsnivån var VG skulle skrivit appen mot de kriterier direkt och implementerande av user i applikationen. 
Skapat en in memory databas för tester.

### Vilka möjligheter ser du med de kunskaper du fått under kursen.
Skriva bra kod med tester som bevisar att logiken fungerar. Jag har ändrat sätt kod skrivs för möjliggörande av testande. Många bra insikter i hur man skriver bra unittest och möjlighet att mocka klasser med externa beroende eller lång körtid för att snabba upp testande.

