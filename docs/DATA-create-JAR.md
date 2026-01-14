# Maven JAR build (console) By AlbertProfe

## JAR

### What is a JAR?

A **JAR** (Java ARchive) is a single compressed file (ZIP format) that bundles:

- **Compiled Java classes** (`.class`)
- **Resources** (e.g., `application.properties`, CSV files under `src/main/resources`)
- **Metadata** (`META-INF/`)

For Spring Boot projects, you typically produce an **executable JAR**, which also contains:

- Your app code
- The dependencies (libraries) your app needs  
  So you can run it with `java -jar ...` on any machine with a compatible Java runtime.

### Why the JAR is relevant

The JAR is the **deliverable** of your project:

- **Deployable artifact**: you don’t ship source code, you ship the built app.
- **Same result everywhere**: building with Maven produces a consistent output.
- **Easy to run**: one command to start the application.
- **Used by CI/CD**: pipelines usually build the JAR and then deploy it.

### What is the `/target` folder and why it matters?

`/target` is Maven’s **build output directory** (generated automatically).

It typically contains:

- **Compiled classes**: `target/classes/`
- **Test classes**: `target/test-classes/`
- **Build reports** / surefire logs
- The final **JAR file**: `target/<artifactId>-<version>.jar`

Why it matters:

- It’s the **result of the build** (what you run/deploy).
- It is usually **not committed to git** (it’s reproducible output).
- If you delete it, nothing important is lost—Maven will recreate it.

### How to create the JAR from the console (Maven)

From the project folder that contains `pom.xml`, run:

```bash
mvn clean package
```

What it does:

- `clean` removes the old `target/` folder
- `package` compiles, runs tests, and builds the JAR into `target/`

If you want to skip tests (sometimes useful locally):

```bash
mvn clean package -DskipTests
```

![](https://raw.githubusercontent.com/AlbertProfe/ApartmentPredictor-React/refs/heads/master/docs/screenshots/CREATE-JAR-1.png)

### Where to find the JAR

After a successful build, check:

- `target/*.jar`

Commonly it looks like:

- `target/apartment_predictor-0.0.1-SNAPSHOT.jar` (name depends on your `pom.xml`)

### How to run the JAR

![](https://raw.githubusercontent.com/AlbertProfe/ApartmentPredictor-React/refs/heads/master/docs/screenshots/CREATE-JAR-2.png)

Run:

```bash
java -jar target/<your-jar-name>.jar
```

![](https://raw.githubusercontent.com/AlbertProfe/ApartmentPredictor-React/refs/heads/master/docs/screenshots/CREATE-JAR-3.png)

## How to check API REST

Open browser and:

- navigate to endpoint url:` http://localhost:8080/api/apartment/getAll`

- or test by POSTMAN [apartmentPredictorCRUD](https://documenter.getpostman.com/view/7473960/2sBXVeFs8L))

![](https://raw.githubusercontent.com/AlbertProfe/ApartmentPredictor-React/refs/heads/master/docs/screenshots/CREATE-JAR-4.png)

---
  [⬅️ Back to Index](../README.md#table-of-contents)
