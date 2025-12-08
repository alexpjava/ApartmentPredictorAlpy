# H2 Database --- Connection Modes Explained

H2 supports several connection modes depending on how you want your
application to access the database. Below is a clear explanation of each
mode and what it means for H2 to run in **TCP server mode**.

------------------------------------------------------------------------

## 1. Embedded Mode (Same Process)

In embedded mode, the database runs **inside the same Java process**
that opens it.

Example JDBC URLs:

    jdbc:h2:~/test
    jdbc:h2:file:/path/to/database

### Characteristics

-   Fastest mode
-   No network communication
-   Only one Java process can open the database
-   External tools (IntelliJ, DBeaver) cannot connect

------------------------------------------------------------------------

## 2. In-Memory Mode

The database exists only in **RAM** and disappears when the application
stops.

Example:

    jdbc:h2:mem:mydb

### Characteristics

-   Extremely fast
-   Perfect for automated tests
-   No persistence
-   Cannot be shared between applications

------------------------------------------------------------------------

## 3. TCP Server Mode

In this mode, H2 acts like a **real database server** (similar to MySQL
or PostgreSQL).\
It listens on a TCP port---commonly **9092**---allowing external
applications to connect.

Example:

    jdbc:h2:tcp://localhost:9092/~/test

### What does *TCP mode* mean?

-   H2 starts a server process accessible via **TCP/IP**
-   Multiple applications can connect to the same database file
    simultaneously
-   Tools like IntelliJ, DBeaver, or another Spring Boot service can
    connect

### Characteristics

-   Supports multiple concurrent connections
-   Ideal for development with external SQL tools
-   Prevents file-locking issues
-   Slightly slower than embedded mode
-   Requires a running H2 server
-   Opens a network port (must be secured)

------------------------------------------------------------------------

## 4. Web Console Mode

This is not a database mode but a **web-based admin console**:

    http://localhost:8082

It allows you to: - View tables - Execute SQL queries - Inspect the
schema\
But it is **not** a JDBC connection.

------------------------------------------------------------------------

# Summary

  -----------------------------------------------------------------------------------
  Mode         Description                     External        Persistent   Speed
                                               Connections                  
  ------------ ------------------------------- --------------- ------------ ---------
  Embedded     Runs inside the same JVM        No              Yes          Fast
               process                                                      

  In-Memory    Lives only in RAM               No              No           Fastest

  TCP Server   Network-accessible DB server    Yes             Yes          Medium

  Web Console  Browser UI for managing the     N/A             N/A          N/A
               database                                                     
  -----------------------------------------------------------------------------------

------------------------------------------------------------------------

# In Short

TCP mode turns H2 into a network-accessible database server, allowing
multiple tools and applications to connect simultaneously.
