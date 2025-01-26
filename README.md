# Fifteen Puzzle - Jetpack Compose

A modern implementation of the classic **Fifteen Puzzle** game built using **Kotlin** and **Jetpack Compose**. This app provides a fun and engaging sliding tile puzzle experience with a sleek design and smooth animations.

---

## 🎮 About the Game

The Fifteen Puzzle is a classic sliding tile puzzle where the objective is to arrange the tiles in ascending order. The grid consists of numbered tiles (1 through 15) and one empty space. Players slide tiles into the empty space to rearrange the grid.

### Objective:
Rearrange the tiles into the following order:

1 2 3 4 5 6 7 8 9 10 11 12 13 14 15

---

## ✨ Features

- **Modern UI**: Designed with Jetpack Compose for a clean and responsive interface.
- **Randomized Setup**: Each game starts with a unique, solvable configuration.
- **Move Counter**: Track the number of moves made to solve the puzzle.

---

## 📂 Project Structure

```
fifteen-puzzle-compose/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/alexanderaksonov/fifteen_kotlin/
│   │   │   │   ├── domain/         # Game logic and data models
│   │   │   │   ├── ui/             # Jetpack Compose UI components
│   │   │   │   └── MainActivity.kt
│   │   │   └── res/           # Resources (themes, strings, etc.)
│   │   └── test/              # Unit tests
├── build.gradle
└── settings.gradle
```

