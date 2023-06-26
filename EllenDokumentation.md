# Ellen Halvardsson

## ToDo applikation

### Beskrivning av projektet
Jag har skapat en ToDo applikation som använder sig av CRUD-metoder för att skapa och hantera todo-uppgifter. Applikationen använder sig av en SQLite-databas för att hantera datan. Jag har även skapat testklasser för programmets olika klasser med publika metoder.

## Planering
Jag planerade i KanBan på Github, Miro och Mermaid Live Editor. Där skapade jag planeringen av projektet, flödesschema och klassdiagram. Jag skapade även pseudokod för att få en bättre överblick över projektet.

### Lösningsförslag innan uppgiften påbörjas
Jag började planera mockandet av databasen och vilka tester som kunde tänkas behövas. Jag valde att använda mig av SQLite databas eftersom jag tycker det känns enklast. Jag såg till att planera noggrant och skapade klassdiagram och flödesschema för att sätta mig in i projektet.

#### Hur du tänker försöka lösa uppgiften.(exempelvis)
Jag tänker lösa uppgiften genom att först planera och skapa skalet av projektet. Sedan kommer jag att skapa tester och sedan mocka en databas för att säkerställa att applikationen senare kommer att fungera som den ska med en riktig databas.

#### Pseudokod.(exempelvis)
Jag började med att skriva pseudokod som förklarar vad varje klass ska göra och hur de ska fungera tillsammans. Jag skrev även pseudokod för metoderna i facaderna samt testerna i testklasserna. Det gjorde det enklare för mig när jag väl började koda och gjorde att jag bara kunde koda "enligt manus".

#### Diagram

Jag skapade klassdiagram och flödesschema samt KanBan board. Klassdiagrammet är ej komplett utan jag använde det mer som en grund för att komma igång med tänkandet och hur jag skulle lägga upp projektet.

[klassdiagram](..%2F..%2FPictures%2FScreenshots%2Fklassdia-todo.jpg)
[flowchart](..%2F..%2FPictures%2FScreenshots%2Fflowchart-todo.jpg)
[KanBan](https://user-images.githubusercontent.com/102437613/248950240-040808c7-125a-4478-aa9f-366a13b05faf.jpg)

### Jira/Trello/Github Project och projekthantering enligt Scrum/Kanban
Jag använde mig av KanBan-boarden på Github för att enkelt se vad jag behövde göra. Sen kunde jag enkelt flytta uppgifterna som var klara till "done" och lägga till nya ifall det behövdes. Jag skrev även ett veckoschema för vilka uppgifter jag skulle göra på vilken dag, och följde det så gott det gick.

## Arbetet och dess genomförande
Jag följde mitt veckoschema och gjorde uppgifterna som stod nerskrivna varje dag. Jag började med planeringen, sedan börja jagg med kodskalet till klasserna och skrev pseudokod till ett antal tester. Sedan kodade jag CRUD-metoderna och kopplade mig till databasen. Jag skapade sen fler testklasser och såg till att testerna gick igenom.

### Vad som varit svårt
Jag stötte inte på några större problem men det var lite svårt att komma på exakt vilka metoder och klasser som skulle testas, och på vilket sätt testerna skulle skrivas. 

Det var även en utmaning att använda GitHub Actions och skapa yaml-fil för första gången. 

Även att hantera alla möjliga fel som kan uppstå när programmet används var en utmaning. Men det var hjälpsamt att få en klasskamrat som testade koden och gav feedback.

### Beskriv lite olika lösningar du gjort
Jag skapade en klass som kopplar sig till databasen och utför querys till databas. Jag skapade sen en facade för databasen som kommunicerar mellan menu-klassen och databas-klassen. Jag hade enbart en instans av Scanner eftersom jag ville begränsa användar-input till enbart en klass.

### Beskriv något som var besvärligt att få till
Det var lite besvärligt med Prepared Statements, jag hade först skickat med en string-parameter när jag anropade executeUpdate() vilket jag sedan insåg att det var fel och fick ändra.
Det var också svårt att använda mock vid testning, jag fick, pun intended, testa mig fram och be Marcus om goda råd angående mockningen.

### Beskriv om du fått byta lösning och varför i sådana fall
Det var besvärligt när jag först använde nextInt() i mina metoder, men sedan bytte jag till nextLine() och konverterade inputen till int. Detta gjorde att input hanterades korrekt och utan problem.
Jag fick ändra i den ena testklassen, eftersom jag tidigare anropade min mock men med hjälp av Marcus förstod att det var facaden som skulle anropas.

## Reflektion & Slutsatser
Det var ett intressant projekt och det var kul att bygga upp en applikation från grunden. Det var intressant att använda GitHub Actions, verkar väldigt användbart för framtida kod!

### Vad gick bra
Jag kom igång ganska snabbt och fick en bra idé av vad som behövde göras tack vare planeringen. Jag tycker att jag tillslut fick till en bra struktur på koden och att felhanteringen av input gick lättare efter ett tag.

### Vad gick dåligt
Det var svårt att veta hur jag skulle lägga upp testerna och vad som skulle testas för bästa resultat. Det var också svårt att veta hur jag skulle utforma felhanteringen. Jag hade gärna lärt mig mer om exceptions och hur man ska/kan använda dom. I mitt projekt använde jag mestadels if-satser för att hantera felinmatningar.

### Vad har du lärt dig
Jag har lärt mig att planering är A och O, och att det är viktigt att ha en bra struktur på koden. Jag har även lärt mig att det är viktigt att testa koden och att GitHub Actions är ett bra verktyg för att testa koden automatiskt.

### Vad hade ni gjort annorlunda om ni gjort om projektet
Jag hade velat göra VG-delen, jag började på den, men jag tror faktiskt det hade varit enklast att få med VG-delen från början, istället för att implementera allt i efterhand.

### Vilka möjligheter ser du med de kunskaper du fått under kursen.
Jag tror att jag kommer att kunna använda mig av det jag lärt mig i framtida projekt. Jag har lärt mig att planera och strukturera koden, och att testa koden för att se till att den fungerar som den ska. 
Jag kännner mig mer bekväm med att arbeta med databaser och att kvalitetsäkra kod. Jag har fått med mig värdefulla kunskaper som jag kommer att ha nytta av i framtiden.
