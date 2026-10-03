# CS 1103 Unit 5: Peer Responses

Author: Nicanor Maswili
Course: CS 1103 Programming 2

You need to post **2** replies by Wednesday (minimum 75 words each). Three drafts are provided
so you can pick the two that fit best. Each one engages the classmate's specific points, adds a
technical idea, answers their question, and ends with a question.

---

## Peer Response 1: to Bismark Asiedu

Hi Bismark,

Your student management example maps each CRUD operation clearly, and I agree that validating data
before inserting or updating it is the first line of defense. To answer your question, I would
combine three JDBC tools. First, PreparedStatement with ? placeholders for every value, so user
input can never change the SQL itself. Second, transactions: when a student enrolls, the program
can insert the enrollment and reduce the available seats inside one transaction, calling commit()
only if both succeed and rollback() otherwise, so the database never shows an enrollment without a
seat taken (Oracle, n.d.). Third, checking the number returned by executeUpdate(), because an UPDATE
that changes zero rows usually means the record was not found. Would you also let the database
enforce rules with constraints, or keep all validation in the Java code?

Best,
Nicanor

Reference:
Oracle. (n.d.). *Using transactions*. The Java Tutorials.
https://docs.oracle.com/javase/tutorial/jdbc/basics/transactions.html

---

## Peer Response 2: to Jagot Chakma

Hi Jagot,

This is a very thorough post, and I appreciated the page references and your honest point that
Hock-Chuan's examples put the password in the code, which is fine for learning but not for
production. To answer your question, I think a plain Statement still makes sense in two cases.
The first is one-time setup SQL with no user input, such as CREATE TABLE when an application
installs its database. The second is when the query needs a dynamic table or column name, for
example sorting by a column the user picks, because a ? placeholder can only hold values, not
names. In that case the safe approach is to check the name against an allow-list of permitted
columns before building the SQL (OWASP Foundation, n.d.). Outside those cases, I would always use
PreparedStatement. Do you think an allow-list is enough protection, or would you avoid user-chosen
column names altogether?

Best,
Nicanor

Reference:
OWASP Foundation. (n.d.). *SQL injection prevention cheat sheet*. OWASP Cheat Sheet Series.
https://cheatsheetseries.owasp.org/cheatsheets/SQL_Injection_Prevention_Cheat_Sheet.html

---

## Peer Response 3: to Mary Njeri

Hi Mary,

Your library example covers all four CRUD operations neatly, from SELECT for available books to
DELETE for removing a record. One small slip: in your security paragraph you wrote that security
comes from "avoiding the use of PreparedStatement", but I think you meant using it, since your
earlier paragraph explains why it is safer. To answer your question, PreparedStatement improves
security because it treats input as data, never as SQL. If a search builds its query by joining
strings, an input like x' OR '1'='1 makes it match every row, while the PreparedStatement version
matches none (OWASP Foundation, n.d.). It also improves reliability: a book title such as
"Ender's Game" contains an apostrophe that breaks a string-built query, but a PreparedStatement
handles it automatically. Have you tried a title with an apostrophe in your library example?

Best,
Nicanor

Reference:
OWASP Foundation. (n.d.). *SQL injection prevention cheat sheet*. OWASP Cheat Sheet Series.
https://cheatsheetseries.owasp.org/cheatsheets/SQL_Injection_Prevention_Cheat_Sheet.html
