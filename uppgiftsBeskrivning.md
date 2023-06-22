<!-- vscode-markdown-toc -->
* 1. [Innehåll](#Innehll)
* 2. [Inledning](#Inledning)
    * 2.1. [Bakgrund](#Bakgrund)
    * 2.2. [Frågeställningen](#Frgestllningen)
    * 2.3. [Mål](#Ml)
    * 2.4. [Avgränsning](#Avgrnsning)
        * 2.4.1. [Ni ska använda:](#Niskaanvnda:)
        * 2.4.2. [Ni får använda en av följande:](#Nifranvndaenavfljande:)
        * 2.4.3. [Dvs inga:](#Dvsinga:)
        * 2.4.4. [Frivilligt](#Frivilligt)
    * 2.5. [Syfte](#Syfte)
    * 2.6. [Vad ska ni leverera?](#Vadskanileverera)
* 3. [Projekt Uppgift](#ProjektUppgift)
    * 3.1. [TODO](#TODO)
    * 3.2. [Funktioner som ska finnas för Godkänt samt Väl Godkänt](#FunktionersomskafinnasfrGodkntsamtVlGodknt)
        * 3.2.1. [CRUD metoder](#CRUDmetoder)
        * 3.2.2. [Egenskaper varje TODO ska ha](#EgenskapervarjeTODOskaha)
        * 3.2.3. [Egenskaper varje User ska ha](#EgenskapervarjeUserskaha)
* 4. [Betygskrav](#Betygskrav)
    * 4.1. [Projektet skall fungera som avsett av utbildaren, vid oklarheter fråga!](#Projektetskallfungerasomavsettavutbildarenvidoklarheterfrga)
    * 4.1. [Grundläggande Krav](#GrundlggandeKrav)
    * 4.2. [Funktionalitet](#Funktionalitet)
    * 4.3. [Dokumentation i mappen `documents` för projektet.](#Dokumentationimappendocumentsfrprojektet.)
    * 4.4. [I projektets `<ertNamnDokumentation>.md` fil!](#IprojektetsertNamnDokumentation.mdfil)
* 5. [Inlämning](#Inlmning)
* 6. [Sista inlämningstid](#Sistainlmningstid)

<!-- vscode-markdown-toc-config
	numbering=true
	autoSave=true
	/vscode-markdown-toc-config -->
<!-- /vscode-markdown-toc --># Enskild inlämningsuppgift Todo

##  1. <a name='Innehll'></a>Innehåll


##  2. <a name='Inledning'></a>Inledning

###  2.1. <a name='Bakgrund'></a>Bakgrund

Ni är nu i slutet på kursen Kvalitetssäkring och testning och har lärt er att testa backend med hjälp av automatiska tester i Junit5 samt att mocka bort beroenden med hjälp av Mockito. Ni ska även se till att testerna fungerar genom Github Actions.

###  2.2. <a name='Frgestllningen'></a>Frågeställningen

Hur kan vi skapa en TODO applikation med testning och mockning?

###  2.3. <a name='Ml'></a>Mål

Din uppgift är att skapa en TODO Applikation med ett menysystem som kan hantera TODO. Du ska även skapa tester för din applikation.

Ert program ska hantera TODO där ni ska kunna skapa, läsa ut, redigera samt radera TODO enligt CRUD principen. Era TODO ska existera i en databas, antingen MongoDB eller SQLite.

###  2.4. <a name='Avgrnsning'></a>Avgränsning

####  2.4.1. <a name='Niskaanvnda:'></a>Ni ska använda:

- JUnit Jupiter API » 5.9.3
- Mockito Core » 5.3.1
- JSON In Java » 20230227

####  2.4.2. <a name='Nifranvndaenavfljande:'></a>Ni får använda en av följande:

- MongoDB Driver » 4.9.1
- SQLite JDBC » 3.42.0.0

####  2.4.3. <a name='Dvsinga:'></a>Dvs inga:

- Andra paket för att bli godkända

####  2.4.4. <a name='Frivilligt'></a>Frivilligt

När uppgiften är klar så kan ni gå banans och tex skapa en JavaFX applikation som visar upp allt på ett snyggt sätt, detta sätts inte betyg på men kan bli häftigt till er presentation. Er JavaFX applikation ska använda befintliga funktioner i grunduppgiften samt behöver inte vara en del av er testning.

###  2.5. <a name='Syfte'></a>Syfte

Att ni ska sy ihop alla kunskaperna ni har lärt er under kursens gång och visa att ni kan skapa en applikation som använder sig av tester för att säkerställa att applikationen fungerar som den ska.

###  2.6. <a name='Vadskanileverera'></a>Vad ska ni leverera?

En TODO applikation som kan:

- Skapa nya TODO
- Visa alla TODO från databasen
- Visa en enskild TODO från databasen
- Uppdatera en TODO i databasen
    - Uppdatera texten
    - Uppdatera om en todo är klar eller inte
- Radera TODO från er databas
- Skapa en användare
- Visa alla användare
- Visa en enskild användare
- Uppdatera en användare
    - Uppdatera namn

Förväntad funktionalitet:

* [ ] Fullt fungerande TODO applikation som kan hantera TODO i kommandotolken.
  * [x] g nivå
  * [ ] vg nivå
* [ ] Fullt fungerande tester för er applikation.
* [ ] Fullt fungerande mockning av beroenden i era tester.
* [x] Fullt fungerande tester genom CI på Github
* [ ] Fullt fungerande JavaFX applikation som visar upp allt på ett snyggt sätt (frivilligt)
* [x] Todo ska existera i en databas, antingen MongoDB eller SQLite.
* [ ] Ni ska använda JUnit5, Mockito samt JSON In Java.
* [x] Ni ska använda Maven för att bygga ert projekt.
* [x] Ni ska använda Github Actions för att testa ert projekt.

##  3. <a name='ProjektUppgift'></a>Projekt Uppgift

###  3.1. <a name='TODO'></a>TODO

Skapa en TODO applikation som kan hantera TODO. Ni ska kunna skapa, läsa ut, redigera samt radera TODO enligt CRUD principen.

###  3.2. <a name='FunktionersomskafinnasfrGodkntsamtVlGodknt'></a>Funktioner som ska finnas för Godkänt samt Väl Godkänt

####  3.2.1. <a name='CRUDmetoder'></a>CRUD metoder

<table>
	<tr>
		<th>Område</th>
		<th>G-nivå</th>
		<th>VG-nivå</th>
	</tr>
    <tr>
        <td>Class namn</td>
        <td>Todo</td>
        <td>User</td>
    </tr>
	<tr>
		<td>Create</td>
        <td>Skapa en TODO</td>
        <td>Skapa en Användare</td>
	</tr>
	<tr>
		<td>Read</td>
        <td>Visa enskild</td>
        <td>Visa enskild alla Användare</td>
	</tr>
	<tr>
		<td>List</td>
        <td>Visa alla TODO</td>
        <td>Visa alla för alla Användare</td>
	</tr>
	<tr>
		<td>Update</td>
        <td>Uppdatera en TODO</td>
        <td>Uppdatera en Användare</td>
	</tr>
	<tr>
		<td>Delete</td>
        <td>Radera en TODO</td>
        <td>Radera en Användare</td>
	</tr>
</table>

####  3.2.2. <a name='EgenskapervarjeTODOskaha'></a>Egenskaper varje TODO ska ha

- `id` (unikt id på varje TODO)
- `text` (Själva todo meddelandet)
- `done` (är uppgiften klar)
- `assignedTo` (vem ska utföra uppgiften, **användarens id om VG delen görs**)

Ni får addera mer fält om ni vill.

####  3.2.3. <a name='EgenskapervarjeUserskaha'></a>Egenskaper varje User ska ha

- `id` (unikt id på varje användare)
- `name` (Namn på användaren)
- `age` (Ålder på användaren)
- `todos` (En lista med alla TODO som användaren har)

##  4. <a name='Betygskrav'></a>Betygskrav

####  4.1. <a name='Projektetskallfungerasomavsettavutbildarenvidoklarheterfrga'></a>Projektet skall fungera som avsett av utbildaren, vid oklarheter fråga!

_Möts inte detta kriteriet så är man underkänd per automatik!_

###  4.1. <a name='GrundlggandeKrav'></a>Grundläggande Krav

- [x] Komplett `pom.xml` fil som bygger projektet.
- [ ] Klasskamrat ska verifiera att er inlämning möter kraven innan ni lämnar in. Ni namnger vem som godkänt er
  inlämning i er README.md fil.
- [x] Fungerande YAML för testande på Github Actions CI
- [ ] Förbereda en max 5 min redovisning på vad ni gjort och hur ni gjort det. Ni ska kunna svara på frågor om er
  inlämning. Powerpoint eller liknande är inte ett krav.

###  4.2. <a name='Funktionalitet'></a>Funktionalitet

<table>
	<tr>
		<th>Område</th>
		<th>G-nivå</th>
		<th>VG-nivå</th>
	</tr>
    <tr>
        <td>Planering</td>
        <td>Enklare projektplan</td>
        <td>Upprätta en genomarbetad projektplan som revideras vid behov</td>
    </tr>
    <tr>
        <td>Kod stil</td>
        <td>Lättläst kod med kommentarer</td>
        <td>Skriv så tydlig kod så kommentarer ofta blir onödiga. Där du använder kommentarer ska de _**noggranna och utförliga/tydliga**_.</td>
    </tr>
    <tr>
        <td>Läsbarhet</td>
        <td>**Lättläst kod.**</td>
        <td>**Väldigt lättläst kod** dvs någon med kunskaper motsvarande den nivå ni befinner er på nu, ska kunna läsa och förstå er kod.</td>
    </tr>
    <tr>
        <td>Struktur</td>
        <td>Tydlig namngivning av variabler och funktioner</td>
        <td>Majoriteten av din kod ska bestå av strukturerade komponenter samt återanvända komponenter. Arbeta enligt **DRY-principen** (Do Not Repeat you’re self)</td>
    </tr>
    <tr>
        <td>Kontroll</td>
        <td>Gör en enklare kontroll så att dina funktioner fungerar som de ska.</td>
        <td>Kontrollera att dina funktioner inte har sidoeffekter, dvs se till så att det inte finns programlogiska fel. </td>
    </tr>
    <tr>
        <td>Automatiska tester på</td>
        <td>Todo klassen</td>
        <td>User klassen</td>
    </tr>
    <tr>
        <td>Mocka bort externa beroenden (ex databas)</td>
        <td>Todo klassen</td>
        <td>User klassen</td>
    </tr>
    <tr>
        <td>Fungerande gränssnitt för att hantera</td>
        <td>Todo</td>
        <td>Todo samt användare</td>
    </tr>
    <tr>
        <td>Antal Scanners</td>
        <td>Max 4</td>
        <td>Max 1</td>
    </tr>
    <tr>
        <td>Github Actions CI</td>
        <td>Fungerande</td>
        <td>Fungerande</td>
    </tr>
</table>

###  4.3. <a name='Dokumentationimappendocumentsfrprojektet.'></a>Dokumentation i mappen `documents` för projektet.

<table>
	<tr>
		<th>Område</th>
		<th>G-nivå</th>
		<th>VG-nivå</th>
	</tr>
    <tr>
        <td>README.md</td>
        <td>
            <ul>
                <li>Hur man driftar hela projektet</li>
                <li>Hur man startar/stoppar de olika delarna</li>
                <li>Allt som behövs för att vem som helst ska kunna starta projektet på sin dator</li>
                <li>Använd korrekta begrepp och syntax i dina beskrivningar.</li>
            </ul>
        </td>
        <td></td>
    </tr>
    <tr>
        <td>ertNamnDokumentation>.md</td>
        <td>Se mallen under tabellen</td>
        <td>
            <p>Addera följande sist i filen:</p>
            <ul>
                <li>Motivera varför du valt en specifik lösning.</li>
                <li>Lämna förslag på förbättringar av din kod.</li>
                <li>Lämna exempel på lösningar du valde att **inte** implementera</li>
                <li>Lämna förslag på förbättringar av din UI/UX design eller reflektera över den.</li>
            </ul>
        </td>
    </tr>
</table>

###  4.4. <a name='IprojektetsertNamnDokumentation.mdfil'></a>I projektets `<ertNamnDokumentation>.md` fil!

- [ ] Ni ska lämna in era **egna** reflektioner i en MarkDown fil
  enligt strukturen nedan.

Som **ska** innehålla rubrikerna nedan med **text** under varje rubrik och **minst 3 meningar under varje rubrik**:

- [ ] Projektet
    - [ ] Beskrivning av projektet
    - [ ] Vad du har gjort
- [ ] Planering
    - [ ] Lösningsförslag innan uppgiften påbörjas, exempelvis:
        - [ ] Skisser
        - [ ] Hur du tänker försöka lösa uppgiften.
        - [ ] Pseudokod.
        - [ ] Diagram.
    - [ ] Jira/Trello och projekthantering enligt Scrum/Kanban
- [ ] Arbetet och dess genomförande
    - [ ] Vad som varit svårt
    - [ ] Beskriv lite olika lösningar du gjort
    - [ ] Beskriv något som var besvärligt att få till
    - [ ] Beskriv om du fått byta lösning och varför i sådana fall
- [ ] Reflektion & Slutsatser
    - [ ] Vad gick bra
    - [ ] Vad gick dåligt
    - [ ] Vad har du lärt dig
    - [ ] Vad hade ni gjort annorlunda om ni gjort om projektet
    - [ ] Vilka möjligheter ser du med de kunskaper du fått under kursen.

Detta innebär:

1. `README.md`-fil i projektets rotmapp.
2. `<ertNamnDokumentation>.md`-fil i mappen `documents`

##  5. <a name='Inlmning'></a>Inlämning
Ni ska lämna in ert källkod i Google Classroom samt lämna in en länk till ert repo på GitHub.

##  6. <a name='Sistainlmningstid'></a>Sista inlämningstid

Lämna in uppgiften via GitHub-länk senast den 2023-06-27 kl. 12:00. För att det ska hinna bli rättat innan kursavslut.