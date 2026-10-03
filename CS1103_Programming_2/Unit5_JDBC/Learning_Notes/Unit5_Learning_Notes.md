# Unit 5 Learning Notes: JDBC and CRUD

Course: CS 1103 Programming 2
Reading: Hock-Chuan (2024), Java database (JDBC) programming by examples with MySQL; Samoylov
(2018), Chapter 16, Database Programming
Videos: Simplilearn (2020), Java JDBC tutorial; Telusko (2023), Java database connectivity

Due October 7, 2026: Discussion (post by **Sunday Oct 4**, 2 replies by **Wednesday Oct 7**) and
the Self-Quiz. No programming assignment this unit.

---

## 1. What JDBC is

JDBC is the standard Java API (package **java.sql**) for working with relational databases. The
program talks to JDBC interfaces; a **driver** (for example MySQL Connector/J) translates the calls
for one specific database.

## 2. The JDBC steps

1. Add the driver JAR to the classpath (modern drivers register themselves).
2. **Connect:** `DriverManager.getConnection(url, user, password)`
   - URL pattern: `jdbc:mysql://hostname:port/databaseName`
3. **Create a statement:** `Statement`, or better `PreparedStatement` with `?` placeholders.
4. **Execute:** `executeQuery()` for SELECT (returns a `ResultSet`), `executeUpdate()` for
   INSERT, UPDATE, DELETE (returns the number of rows changed).
5. **Process results:** `while (rs.next()) { rs.getString("name"); ... }`
6. **Close** everything, ideally with **try-with-resources**.

## 3. CRUD mapped to SQL and JDBC

| CRUD | SQL | JDBC method |
|---|---|---|
| Create | INSERT INTO ... VALUES (...) | executeUpdate() |
| Read | SELECT ... FROM ... WHERE ... | executeQuery() → ResultSet |
| Update | UPDATE ... SET ... WHERE ... | executeUpdate() |
| Delete | DELETE FROM ... WHERE ... | executeUpdate() |

## 4. Important features

- **PreparedStatement:** precompiled, faster when repeated, and prevents **SQL injection**.
- **Batch processing:** `addBatch()` then `executeBatch()` runs many statements in one trip.
- **Transactions:** `setAutoCommit(false)`, then `commit()` or `rollback()`; all or nothing.
- **Metadata:** `rs.getMetaData()` gives column names and types; `conn.getMetaData()` describes
  the database.
- **Connection pooling:** reuse connections instead of opening new ones (often managed as a single
  shared pool object, the Singleton idea).
- **SQLException:** every JDBC call can throw it; catch, roll back, log.

---

## Self-Quiz answers

| # | Question | Answer |
|---|---|---|
| 1 | Statement used to update data | **UPDATE** |
| 2 | Method to get ResultSet metadata | **getMetaData()** |
| 3 | Purpose of batch processing | **Executing multiple SQL statements as a single batch** |
| 4 | JDBC stands for | **Java Database Connectivity** |
| 5 | Design pattern often used for database connections | **Singleton** |

## References

Hock-Chuan, C. (2024, March). *Java database (JDBC) programming by examples with MySQL*. Nanyang
Technological University. https://www3.ntu.edu.sg/home/ehchua/programming/java/jdbc_basic.html

Telusko. (2023, September 12). *Java database connectivity | JDBC* [Video]. YouTube.
https://www.youtube.com/watch?v=7v2OnUti2eM
