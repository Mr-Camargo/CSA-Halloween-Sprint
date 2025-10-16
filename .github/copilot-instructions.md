## Quick context

This repository is a small, educational Java project for a Halloween-themed text adventure. Source files live in `src/` and compiled classes (if present) are in `bin/`. There is no package declaration in sources — all classes are in the default package.

Keep changes minimal and aligned with the project skeleton in `README.md`. This repo is intended for classroom sprints, so prefer clear, short, and well-commented edits.

## Big-picture architecture (what to know)

- Core domain objects: `Room`, `Monster`, `Item`, `Player` (located in `src/`). The README contains the expected field/method skeletons and the intended data flows: Rooms hold Items and exits; Players have inventory and current room; Monsters interact with Players.
- There is no top-level `Main` or driver in the repo. Agents should not assume an existing game loop; adding a driver class is OK but keep it small and optional.
- No package statements: compile and run tools should operate from the repository root using `src/` and `bin/`.

## Build / run / debug (PowerShell examples)

- Compile all sources into `bin/` (create `bin` if missing):

```powershell
mkdir bin; javac -d bin src/*.java
```

- Run a class with a `main` method (example after adding `Main.java`):

```powershell
java -cp bin Main
```

- If you only want to compile a single file for testing, run:

```powershell
javac -d bin src/Room.java
```

Notes: Because there is no provided runner, any automated change that adds execution must also add a short README note and keep the default behaviour untouched.

## Project-specific conventions & patterns

- Keep classes simple and focused: these are student-facing models (no frameworks). Prefer explicit fields and small methods like `addItem`, `addExit`, `pickUpItem`, and `move` as described in `README.md`.
- Avoid introducing packages or external build tools (Maven/Gradle) unless the user asks — the project is intentionally lightweight.
- Preserve filesystem layout: sources in `src/`, compiled classes in `bin/`.

## Examples from this repo

- The README gives canonical examples of the intended fields/methods. Use those signatures where applicable (e.g., `ArrayList<Item> items`, `ArrayList<Room> exits`, `int health` on `Player`).
- Because `src/*.java` files currently contain little or no implementation, prefer small, incremental additions and add unit-like driver tests rather than large refactors.

## Integration points & external dependencies

- There are no external dependencies or third-party libraries present. All changes should compile with a standard JDK (Java 8+).

## AI agent behavior rules (how you should modify the repo)

1. Read `README.md` first and keep behavior consistent with the sprint's intended design.
2. Make minimal, testable edits. If adding executable code (e.g., a `Main`), include a brief comment and a usage note in the repo README.
3. Don't introduce build systems, packages, or third-party libraries without explicit user consent.
4. When changing APIs (class fields/methods), update or add short inline comments and mention the change in the top-level `README.md` or the new file's header.

## When you are unsure

- If you need to run the game but there is no `Main`, add a small `Main.java` under `src/` that demonstrates a minimal playthrough and document it in `README.md`.
- If a requested change would substantially alter project structure (add Gradle, packages, etc.), ask the user before proceeding.

---

If any of the above is unclear or you want me to adopt a different approach (for example, add a test harness or implement a `Main` driver), tell me which you prefer and I'll update the instructions and/or implement it.
