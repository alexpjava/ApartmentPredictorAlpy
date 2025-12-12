# Loading CSV Data into H2 Database Using Spring Boot

This document describes two methods for importing data from a CSV file (e.g., **Housing.csv**) into an **H2 in-memory database** in a Spring Boot application:
1. **Direct SQL import using H2's `CSVREAD` function**.
2. **Programmatic import using Java code**, creating entities and persisting them via JPA.

---

## 1. Creating the Database Table in H2
Before importing the CSV, ensure the target table exists. The following SQL example matches the structure of the **Housing.csv** file:

```sql
CREATE TABLE apartment (
    id UUID PRIMARY KEY,
    price DOUBLE,
    area DOUBLE,
    bedrooms INT,
    bathrooms INT,
    stories INT,
    mainroad VARCHAR(10),
    guestroom VARCHAR(10),
    basement VARCHAR(10),
    hotwaterheating VARCHAR(10),
    airconditioning VARCHAR(10),
    parking INT,
    prefarea VARCHAR(10),
    furnishingstatus VARCHAR(30)
);
```

---

## 2. Importing Data Directly Using SQL (H2 `CSVREAD`)
H2 provides a built-in function, `CSVREAD`, which reads CSV files and converts them into a virtual table. This allows direct bulk insertion without writing individual `INSERT` statements.

Place the file **Housing.csv** in:
```
src/main/resources/Housing.csv
```

Then execute the following SQL in the H2 console:

```sql
INSERT INTO apartment (
    id, price, area, bedrooms, bathrooms, stories,
    mainroad, guestroom, basement, hotwaterheating,
    airconditioning, parking, prefarea, furnishingstatus
)
SELECT 
    RANDOM_UUID(),
    price,
    area,
    bedrooms,
    bathrooms,
    stories,
    mainroad,
    guestroom,
    basement,
    hotwaterheating,
    airconditioning,
    parking,
    prefarea,
    furnishingstatus
FROM CSVREAD('classpath:Housing.csv');
```

### What This SQL Does
- Reads the CSV file from the classpath.
- Treats each CSV row as a row in a temporary table.
- Inserts all rows into the `apartment` table.
- Generates a unique UUID for each inserted record.

This is the fastest and simplest way to bulk-load CSV data during development or testing.

---

## 3. Programmatic Import Using Java (Spring Boot)
For automated testing or production-like initialization, you may prefer loading the CSV programmatically.

### Example JPA Entity
```java
@Entity
public class Apartment {

    @Id
    private UUID id;

    private Double price;
    private Double area;
    private Integer bedrooms;
    private Integer bathrooms;
    private Integer stories;
    private String mainroad;
    private String guestroom;
    private String basement;
    private String hotwaterheating;
    private String airconditioning;
    private Integer parking;
    private String prefarea;
    private String furnishingstatus;

    // Getters and setters
}
```

### Repository
```java
public interface ApartmentRepository extends JpaRepository<Apartment, UUID> {}
```

### CSV Loader Service
```java
@Service
public class ApartmentCsvLoader {

    @Autowired
    private ApartmentRepository repository;

    public void loadCsv(Path csvPath) {
        try (BufferedReader br = Files.newBufferedReader(csvPath)) {

            String line;
            boolean skipHeader = true;

            while ((line = br.readLine()) != null) {
                if (skipHeader) {
                    skipHeader = false;
                    continue;
                }

                String[] tokens = line.split(",");

                Apartment a = new Apartment();
                a.setId(UUID.randomUUID());
                a.setPrice(Double.valueOf(tokens[0]));
                a.setArea(Double.valueOf(tokens[1]));
                a.setBedrooms(Integer.valueOf(tokens[2]));
                a.setBathrooms(Integer.valueOf(tokens[3]));
                a.setStories(Integer.valueOf(tokens[4]));
                a.setMainroad(tokens[5]);
                a.setGuestroom(tokens[6]);
                a.setBasement(tokens[7]);
                a.setHotwaterheating(tokens[8]);
                a.setAirconditioning(tokens[9]);
                a.setParking(Integer.valueOf(tokens[10]));
                a.setPrefarea(tokens[11]));
                a.setFurnishingstatus(tokens[12]);

                repository.save(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### Automatic Execution at Startup (Optional)
```java
@Component
public class StartupRunner implements CommandLineRunner {

    @Autowired
    private ApartmentCsvLoader loader;

    @Override
    public void run(String... args) throws Exception {
        loader.loadCsv(Path.of("src/main/resources/Housing.csv"));
    }
}
```

---

## Summary
This documentation provides two fully functional methods for loading CSV data into an H2 database:
- **Direct SQL import using H2's `CSVREAD` for fast loading**.
- **Java-based programmatic import for automated testing or initialization**.

These approaches allow flexible and maintainable data population strategies in Spring Boot projects.
