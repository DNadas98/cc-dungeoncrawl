<p align="center">
  <a href="https://github.com/DNadas98/cc-dungeoncrawl/releases/tag/original">
    <img src="https://img.shields.io/github/v/release/DNadas98/cc-dungeoncrawl.svg?style=for-the-badge" alt="Releases">
  </a>
  <a href="https://github.com/DNadas98/cc-dungeoncrawl/graphs/contributors">
    <img src="https://img.shields.io/github/contributors/DNadas98/cc-dungeoncrawl.svg?style=for-the-badge" alt="Contributors">
  </a>
  <a href="https://github.com/DNadas98/cc-dungeoncrawl/issues">
    <img src="https://img.shields.io/github/issues/DNadas98/cc-dungeoncrawl.svg?style=for-the-badge" alt="Issues">
  </a>
  <a href="https://linkedin.com/in/daniel-nadas">
    <img src="https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555" alt="LinkedIn">
  </a>
</p>

<br xmlns="http://www.w3.org/1999/html"/>
<div align="center">
  <a href="https://github.com/DNadas98/cc-dungeoncrawl">
    <img src="https://avatars.githubusercontent.com/u/125133206?v=4" alt="Logo" width="80" height="80">
  </a>

<h3 align="center">Java Dungeon Crawl RPG Game</h3>
  <p align="center">
    <a href="https://github.com/DNadas98/cc-dungeoncrawl/releases/tag/original">Download the game</a>
    .
    <a href="https://github.com/DNadas98/cc-dungeoncrawl/issues">Report Bug</a>
    ·
    <a href="https://github.com/DNadas98/cc-dungeoncrawl/issues">Request Feature</a>
  </p>
</div>

<details>
  <summary>Table of Contents</summary>
  <ol>
    <li><a href="#about-the-project">About The Project</a></li>
    <li><a href="#original-task-description">Original Task Description</a></li>
    <li><a href="#tech-stack">Tech Stack</a></li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#run-the-game">Run the game</a></li>
      </ul>
    </li>
    <li><a href="#images">Images</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>

## About The Project

This game was a Java learning project developed by me and a teammate during a one-week sprint at the
CodeCool Full-Stack Developer bootcamp. It's a simple roguelike RPG game built with JavaFX, an
open-source framework for building client applications.  
The game runs in real time and uses multiple Java threads to manage rendering, player movement, and
the behavior of enemies. The enemies move around randomly at first, then attempt to follow,
and surround the player if the player is within a certain distance.  
Due to the short development time of just one week and our relatively new experience with Java (only
2-3 weeks), the gameplay is quite basic. Our main focus was to practice Java syntax, explore OOP
basics, implement some logical game mechanics and experiment with threads, file I/O and this FX library.  
I've included this game in my public portfolio because I believe it's a fun and interesting project,
that adds variety to my main focus on web development projects.

## Codecool Task Description

[Roguelikes](https://en.wikipedia.org/wiki/Roguelike) are one of the oldest
types of video games. The earliest ones were made in the 70s, and they were inspired
a lot by tabletop RPGs. Your task is to create a roguelike.

#### What are you going to learn?

- Get more practice in OOP.
- Understand design patterns: layer separation. (All of the game logic, such as player
  movement, game rules, and so on), is in the `logic` package, completely
  independent of user interface code. In principle, you could implement a
  completely different interface, such as terminal, web, Virtual Reality, and so on, for
  the same logic code.)

#### Background materials

- [RogueBasin, a wiki with lots of resources on Roguelike creation](http://roguebasin.com/index.php?title=Articles)
- [Basics of OOP](pages/oop/basics-of-object-oriented-programming.md)
- [How to design classes](pages/java/how-to-design-classes.md)
- [JavaFX](https://en.wikipedia.org/wiki/JavaFX)
- [JavaFX Tutorial](http://tutorials.jenkov.com/javafx/index.html)
- [1-Bit Pack by Kenney](https://kenney.nl/assets/bit-pack)

## Tech Stack

[![Java](https://img.shields.io/badge/-Java-ED8B00?style=for-the-badge)](https://www.java.com/en/)
[![JavaFX](https://img.shields.io/badge/-JavaFX-ED8B00?style=for-the-badge)](https://openjfx.io/)

## Getting Started

### Prerequisites

- [Java Runtime Environment](https://www.java.com/en/download/manual.jsp)

### Run the game
- See the releases page to download the application.
- To run application with JRE, open a terminal at the folder of the jar file, and type:
```bash
java -jar dungeon-crawl-1.0-SNAPSHOT.jar
```
- Navigate the player using the arrow keys
- Press F repeatedly to fight the NPCs
- Press space to pick up the dropped items after defeating the NPCs
- Press space to open doors using your looted keys

## Images

<img src="https://raw.githubusercontent.com/DNadas98/cc-dungeoncrawl/main/images/Screenshot1.png" alt="Game screenshot">
[View project images](https://github.com/DNadas98/cc-dungeoncrawl/blob/development/images)

## Contact

Dániel Nádas

- My GitHub profile: [DNadas98](https://github.com/DNadas98)
- My webpage: [dnadas.net](https://dnadas.net)
- E-mail: [daniel.nadas@dnadas.net](mailto:daniel.nadas@dnadas.net)
- LinkedIn: [Dániel Nádas](https://www.linkedin.com/in/daniel-nadas)

Project
Link: [https://github.com/DNadas98/cc-dungeoncrawl](https://github.com/DNadas98/cc-dungeoncrawl)
