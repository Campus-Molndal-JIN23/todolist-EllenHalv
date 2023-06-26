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

#### Diagram.(exempelvis)

### Jira/Trello/Github Project och projekthantering enligt Scrum/Kanban
Jag använde mig av KanBan-boarden på Github för att enkelt se vad jag behövde göra. Sen kunde jag enkelt flytta uppgifterna som var klara till "done" och lägga till nya ifall det behövdes. Jag skrev även ett veckoschema för vilka uppgifter jag skulle göra på vilken dag, och följde det så gott det gick.

## Arbetet och dess genomförande
Jag följde mitt veckoschema och gjorde uppgifterna som stod nerskrivna varje dag. Jag började med planeringen, sedan börja jagg med kodskalet till klasserna och skrev pseudokod till ett antal tester. Sedan kodade jag CRUD-metoderna och kopplade mig till databasen. Jag skapade sen fler testklasser och såg till att testerna gick igenom.

### Vad som varit svårt
Jag stötte inte på några större problem men det var lite svårt att komma på exakt vilka metoder och klasser som skulle testas, och på vilket sätt testerna skulle skrivas. 

### Beskriv lite olika lösningar du gjort
Jag skapade en klass koppling till databasen och querys till databas. Jag skapade sen en facade för databasen som kommunicerar med menu-klassen eftersom jag tyckte det blev enklare och snyggare. Jag använde enbart Scanner i menu-klassen för att få in input från användaren eftersom jag då enbart har en klass som hanterar input och output.

### Beskriv något som var besvärligt att få till
Det var lite besvärligt med Prepared Statements, jag hade först skickat med en string-parameter när jag anropade executeUpdate() vilket jag sedan insåg att det var fel och fick ändra.

### Beskriv om du fått byta lösning och varför i sådana fall
Det var besvärligt när jag först använde nextInt() i mina metoder, men sedan bytte jag till nextLine() och konverterade inputen till int. Detta gjorde att input hanterades korrekt och utan problem.

## Reflektion & Slutsatser
Det var ett intressant projekt och 

### Vad gick bra

### Vad gick dåligt

### Vad har du lärt dig

### Vad hade ni gjort annorlunda om ni gjort om projektet

### Vilka möjligheter ser du med de kunskaper du fått under kursen.
