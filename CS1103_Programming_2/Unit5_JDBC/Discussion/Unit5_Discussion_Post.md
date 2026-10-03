# JDBC: The Bridge Between Java and the Database

**Course:** CS 1103 Programming 2
**Student:** Nicanor Maswili
**Due:** October 7, 2026

Almost every real application stores its data in a database, and in Java that conversation goes
through JDBC (Java Database Connectivity). JDBC is a standard API in the java.sql package that lets
a Java program connect to a relational database, send SQL statements, and read the results, while a
vendor-supplied driver handles the details of each database product (Samoylov, 2018).

## Why JDBC Matters for Performance and Functionality

**One API for many databases.** The program talks to JDBC interfaces such as Connection, Statement,
and ResultSet, not to MySQL or PostgreSQL directly. The database is chosen by the driver and the
connection URL, which follows the pattern jdbc:mysql://hostname:port/databaseName plus a username
and password (Hock-Chuan, 2024). For the e-commerce system our team has been building, moving from
MySQL in development to PostgreSQL in production would mean changing the URL and the driver, not
rewriting every query.

**PreparedStatement for speed and safety.** A PreparedStatement is sent to the database once and can
then be run many times with different values, which saves the database from re-parsing the same
SQL (Oracle, n.d.-a). It also treats user input as data, never as SQL code. If a search box builds
its query by joining strings, an input such as x' OR '1'='1 changes the WHERE clause so that it
matches every row in the table. With a PreparedStatement, the same input simply matches nothing,
which is why parameterized queries are the main defense against SQL injection (OWASP Foundation,
n.d.).

**Batch processing for bulk work.** When a store imports a catalog of a thousand products, calling
addBatch() for each row and executeBatch() once sends them together instead of making a thousand
separate round trips to the server, which is far faster.

**Transactions for reliability.** By turning off auto-commit, several statements can succeed or fail
as one unit, using commit() and rollback() (Oracle, n.d.-b). The example below sells an item only if
enough stock remains. If the update affects no rows, the change is rolled back, so stock can never
go negative even when two customers buy the last item at the same moment:

```java
String sql = "UPDATE products SET stock = stock - ? WHERE id = ? AND stock >= ?";
try (Connection conn = DriverManager.getConnection(url, user, password);
     PreparedStatement ps = conn.prepareStatement(sql)) {
    conn.setAutoCommit(false);              // start a transaction
    ps.setInt(1, qty);
    ps.setInt(2, productId);
    ps.setInt(3, qty);
    if (ps.executeUpdate() == 1) {
        conn.commit();                      // stock reduced safely
    } else {
        conn.rollback();                    // not enough stock: undo
    }
}
```

The try-with-resources block also closes the connection and statement automatically, as
Hock-Chuan (2024) recommends, so a busy server does not run out of connections.

## Key Considerations When Implementing CRUD

Create, Read, Update, and Delete look simple, but each needs care (Samoylov, 2018):

- **Data integrity.** Validate input in Java before it reaches the database, and let the database
  enforce rules too, with primary keys, NOT NULL, and foreign keys. Group related changes, such as
  creating an order and reducing stock, in one transaction.
- **Security.** Use PreparedStatement for every query that includes user input, connect with a
  database account that has only the permissions the application needs, and keep passwords out of
  the source code by reading them from configuration or environment variables.
- **Efficiency.** In Read operations, select only the columns needed instead of SELECT *, add
  indexes on columns used in WHERE clauses, and page through large results instead of loading them
  all at once. Opening a connection is expensive, so production systems reuse connections from a
  pool rather than opening a new one for every request.
- **Error handling.** Every JDBC call can throw SQLException. Catch it, roll back any open
  transaction, log the details, and show the user a clear message rather than a stack trace.
- **Deletes.** A hard DELETE can break orders that reference a product, so many systems use a "soft
  delete", marking a row as inactive so its history is kept.

As Telusko (2023) demonstrates, the basic JDBC steps are short: load the driver, connect, run a
statement, process the results, and close. The real skill is applying those steps with integrity,
security, and efficiency in mind.

**Question for the class:** In Unit 3 we learned about multithreading. If a web shop handles many
users on separate threads, is it safe to share one Connection object through a Singleton, or
should each thread get its own connection from a pool? What problems could the shared connection
cause?

Word count: 733

## References

Hock-Chuan, C. (2024, March). *Java database (JDBC) programming by examples with MySQL*. Nanyang
Technological University. https://www3.ntu.edu.sg/home/ehchua/programming/java/jdbc_basic.html

Oracle. (n.d.-a). *Using prepared statements*. The Java Tutorials.
https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html

Oracle. (n.d.-b). *Using transactions*. The Java Tutorials.
https://docs.oracle.com/javase/tutorial/jdbc/basics/transactions.html

OWASP Foundation. (n.d.). *SQL injection prevention cheat sheet*. OWASP Cheat Sheet Series.
https://cheatsheetseries.owasp.org/cheatsheets/SQL_Injection_Prevention_Cheat_Sheet.html

Samoylov, N. (2018). *Introduction to programming: Learn to program in Java with data structures,
algorithms, and logic*. Packt Publishing.

Telusko. (2023, September 12). *Java database connectivity | JDBC* [Video]. YouTube.
https://www.youtube.com/watch?v=7v2OnUti2eM
