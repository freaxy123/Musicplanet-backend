# MusicPlanet Backend

MusicPlanet is een project ontwikkeld als onderdeel van semester 3 (2021) van de Software Engineering studie aan Fontys Hogescholen Eindhoven. Het project omvat zowel een front-end gebouwd met het JavaScript framework Vue.js als een backend met een API en database. Hieronder vind je de context en technische details van het backend project. De frontend repository is [hier](https://github.com/freekvlier/Musicplanet-frontend) te vinden.

## Projectomschrijving
MusicPlanet is een systeem voor het beheren van muziekcollecties waar gebruikers afspeellijsten kunnen maken en andere muziekcontent kunnen verkennen. Gebruikers moeten een account aanmaken om de applicatie te gebruiken. Na het inloggen kan de gebruiker een overzicht van alle nummers op het platform zien en zijn eigen afspeellijsten maken door nummers toe te voegen.

## Technologieën
#### Frontend Framework: Vue.js

Het frontend van MusicPlanet is gebouwd met behulp van Vue.js, een JavaScript framework voor het ontwikkelen van gebruikersinterfaces. De frontend repository is [hier](https://github.com/freekvlier/Musicplanet-frontend) te vinden.

#### Backend Framework: Spring Boot
Voor de backend is gebruik gemaakt van Spring Boot.

#### Database: MariaDB
Voor de database is gebruik gemaakt van MariaDB, een relationele database.

### Authenticatie:
De authenticatie is zelf geïmplementeerd door gebruik te maken van Spring Security. Bij de authenticatie wordt een JWT-token gegenereerd, dat door de front-end kan worden gebruikt voor autorisatie.

## Functionaliteiten
Bij het project zijn verschillende requirements opgesteld. De belangrijkste requirements omvatten onder andere:

- Registratie met gebruikersnaam, e-mail en wachtwoord, en e-mailbevestiging.
- Het aanmaken en bekijken van afspeellijsten
- Het toevoegen van nummers aan afspeellijsten 
- Het toevoegen van nummers door beheerders/moderators.
- Het zoeken naar nummers
- Het sorteren van nummers op basis van specificaties.
- Het beheren van gebruikers door beheerders/moderators.

## Leeruitkomsten
Gedurende het semester zijn de volgende leeruitkomsten aangetoond voor het behalen van het semester:

#### Learning outcome 1: You design and build user-friendly, full-stack web applications.
- **User friendly**: You apply basic User experience testing and development techniques.
- **Full-stack**: You design and build a full stack application using commonly accepted front end (Javascript-based framework) and back end techniques (e.g., Object Relational Mapping) choosing and implementing relevant communication protocols and addressing asynchronous communication issues.

#### Learning outcome 2: You use software tooling and methodology that continuously monitors and improve the software quality during software development.
- **Tooling and methodology**: Carry out, monitor and report on unit integration, regression and system tests, with attention for security and performance aspects, as well as applying static code analysis and code reviews.

#### Learning outcome 3: You choose and implement the most suitable agile software development method for your software project.
- **Choose**: You are aware of the most popular agile methods and their underlying agile principles. Your choice of a method is motivated and based on well-defined selection criteria and context analyses.

#### Learning outcome 4: You design and implement a (semi)automated software release process that matches the needs of the project context.
- **Design and implement**: You design a release process and implement a continuous integration and deployment solution (using e.g. Gitlab CI and Docker).

#### Learning outcome 5: You recognize and take into account cultural differences between project stakeholders and ethical aspects in software development.
- **Recognize**: Recognition is based on theoretically substantiated awareness of cultural differences and ethical aspects in software engineering.
- **Take into account**: Adapt your communication, working, and behavior styles to reflect project stakeholders from different cultures; Address one of the standard Programming Ethical Guidelines (e.g., ACM Code of Ethics and Professional Conduct) in your work.

#### Learning outcome 6: You analyze (non-functional) requirements, elaborate (architectural) designs and validate them using multiple types of test techniques.
- **Multiple types of test techniques**: You apply user acceptance testing and stakeholder feedback to validate the quality of the requirements. You evaluate the quality of the design (e.g., by testing or prototyping) taking into account the formulated quality properties like security and performance.

#### Learning outcome 7: You analyze and describe simple business processes that are related to your project.
- **Simple**: Involving stakeholders, predominantly sequential processes with one or two alternative paths.
- **Related**: 
    - Business processes during which the software that you are developing will be used (business processes that the software must  support by fully or partially automating them). 
    - Business processes needed for the success of your software development project (e.g., product release, market release, financial assurance).

#### Learning outcome 8: You act in a professional manner during software development and learning.
- **Professional manner**: You actively ask and apply feedback from stakeholders and advise them on the most optimal technical and design (architectural) solutions. You choose and substantiate solutions for a given problem.
