# CS1111 Unit 5: Database Management Systems

## 📚 Unit Overview

Unit 5 covers database management systems and their role in organizing and managing data:
- Database fundamentals and concepts
- Database models (Relational, NoSQL)
- Database Management Systems (DBMS)
- SQL (Structured Query Language)
- Database design and normalization
- ACID properties and transactions
- Popular DBMS examples (MySQL, PostgreSQL, MongoDB, Oracle)

---

## 📁 Folder Structure

```
CS1111_Unit5_Database_Management/
├── Discussion/
│   ├── Discussion_Forum_Unit5.md
│   ├── Discussion_Forum_Unit5_FINAL.md
│   ├── Peer_Response_1.md
│   ├── Peer_Response_2.md
│   └── Peer_Response_3.md
├── Learning_Notes/
│   ├── DBMS_Study_Guide_Part1.md
│   ├── DBMS_Study_Guide_Part2.md
│   ├── DBMS_Study_Guide_Part3.md
│   └── DBMS_Quick_Reference.md
└── Resources/
    └── Unit5_Original_README.md
```

---

## 💬 Discussion Files

### Discussion_Forum_Unit5_FINAL.md
- **SUBMIT THIS VERSION**
- Final polished discussion post
- Covers DBMS concepts and applications
- Proper APA formatting and citations

### Discussion_Forum_Unit5.md
- Initial draft of discussion post
- Working version with notes

### Peer_Response_1.md, Peer_Response_2.md, Peer_Response_3.md
- Responses to classmates' discussion posts
- Thoughtful engagement with peers
- Proper citations and follow-up questions

---

## 📖 Learning Notes

### DBMS_Study_Guide_Part1.md
- Introduction to databases
- Database models and types
- DBMS architecture

### DBMS_Study_Guide_Part2.md
- Relational database concepts
- SQL fundamentals
- Database operations (CRUD)

### DBMS_Study_Guide_Part3.md
- Database design and normalization
- ACID properties
- Transactions and concurrency

### DBMS_Quick_Reference.md
- Quick study guide
- SQL command reference
- Key concepts summary

---

## 🎯 Key Topics Covered

### What is a Database?

A database is an organized collection of structured data stored electronically. It allows efficient storage, retrieval, modification, and deletion of data.

**Key Characteristics:**
- Organized structure
- Persistent storage
- Efficient access
- Data integrity
- Concurrent access
- Security and privacy

---

## 🗄️ Database Models

### Relational Database Model
- Data organized in tables (relations)
- Rows (tuples) and columns (attributes)
- Primary keys uniquely identify rows
- Foreign keys establish relationships
- SQL for querying
- Examples: MySQL, PostgreSQL, Oracle, SQL Server

**Advantages:**
- Structured data
- ACID compliance
- Powerful querying (SQL)
- Data integrity

**Disadvantages:**
- Rigid schema
- Scaling challenges
- Complex for unstructured data

### NoSQL Database Models

**Document Databases:**
- Store data as documents (JSON, XML)
- Flexible schema
- Example: MongoDB, CouchDB

**Key-Value Stores:**
- Simple key-value pairs
- Fast retrieval
- Example: Redis, DynamoDB

**Column-Family Stores:**
- Data stored in columns
- Optimized for analytics
- Example: Cassandra, HBase

**Graph Databases:**
- Nodes and relationships
- Social networks, recommendations
- Example: Neo4j, Amazon Neptune

---

## 📊 Relational Database Concepts

### Tables (Relations)
```
Students Table:
+----+----------+-----+-------+
| ID | Name     | Age | Major |
+----+----------+-----+-------+
| 1  | Alice    | 20  | CS    |
| 2  | Bob      | 22  | Math  |
| 3  | Charlie  | 21  | CS    |
+----+----------+-----+-------+
```

### Keys

**Primary Key:**
- Uniquely identifies each row
- Cannot be NULL
- Example: Student ID

**Foreign Key:**
- References primary key in another table
- Establishes relationships
- Example: Student ID in Enrollments table

**Composite Key:**
- Combination of multiple columns
- Together form unique identifier

---

## 💻 SQL (Structured Query Language)

### SQL Categories

**DDL (Data Definition Language):**
- Define database structure
- Commands: CREATE, ALTER, DROP

**DML (Data Manipulation Language):**
- Manipulate data
- Commands: SELECT, INSERT, UPDATE, DELETE

**DCL (Data Control Language):**
- Control access
- Commands: GRANT, REVOKE

**TCL (Transaction Control Language):**
- Manage transactions
- Commands: COMMIT, ROLLBACK, SAVEPOINT

### Basic SQL Commands

**CREATE TABLE:**
```sql
CREATE TABLE Students (
    ID INT PRIMARY KEY,
    Name VARCHAR(50),
    Age INT,
    Major VARCHAR(30)
);
```

**INSERT:**
```sql
INSERT INTO Students (ID, Name, Age, Major)
VALUES (1, 'Alice', 20, 'CS');
```

**SELECT:**
```sql
SELECT Name, Major FROM Students WHERE Age > 20;
```

**UPDATE:**
```sql
UPDATE Students SET Age = 21 WHERE ID = 1;
```

**DELETE:**
```sql
DELETE FROM Students WHERE ID = 3;
```

---

## 🔧 Database Design and Normalization

### Normalization

Process of organizing data to reduce redundancy and improve integrity.

**First Normal Form (1NF):**
- Atomic values (no repeating groups)
- Each column contains single value
- Unique identifier (primary key)

**Second Normal Form (2NF):**
- Must be in 1NF
- No partial dependencies
- All non-key attributes depend on entire primary key

**Third Normal Form (3NF):**
- Must be in 2NF
- No transitive dependencies
- Non-key attributes depend only on primary key

**Benefits:**
- Eliminate data redundancy
- Ensure data integrity
- Simplify maintenance
- Improve query performance

---

## ⚡ ACID Properties

Ensure reliable database transactions:

**Atomicity:**
- All or nothing
- Transaction completes fully or not at all
- Example: Bank transfer (debit and credit both succeed or both fail)

**Consistency:**
- Database remains in valid state
- All rules and constraints maintained
- Example: Account balance never negative

**Isolation:**
- Concurrent transactions don't interfere
- Each transaction independent
- Example: Two users updating same record

**Durability:**
- Committed changes permanent
- Survive system failures
- Example: Transaction saved even if power fails

---

## 🔄 Transactions

A transaction is a sequence of operations performed as a single logical unit.

**Transaction States:**
1. **Active**: Transaction executing
2. **Partially Committed**: After final operation
3. **Committed**: Successfully completed
4. **Failed**: Cannot proceed
5. **Aborted**: Rolled back to previous state

**Transaction Commands:**
- **BEGIN TRANSACTION**: Start transaction
- **COMMIT**: Save changes permanently
- **ROLLBACK**: Undo changes

---

## 🗃️ Popular DBMS

### MySQL
- **Type**: Relational (Open-source)
- **Use Cases**: Web applications, WordPress
- **Strengths**: Fast, reliable, easy to use
- **Owner**: Oracle

### PostgreSQL
- **Type**: Relational (Open-source)
- **Use Cases**: Complex queries, data warehousing
- **Strengths**: Advanced features, standards-compliant
- **Community**: Active open-source community

### MongoDB
- **Type**: NoSQL Document (Open-source)
- **Use Cases**: Flexible schema, big data
- **Strengths**: Scalable, JSON-like documents
- **Company**: MongoDB Inc.

### Oracle Database
- **Type**: Relational (Proprietary)
- **Use Cases**: Enterprise applications
- **Strengths**: Robust, scalable, feature-rich
- **Owner**: Oracle Corporation

### Microsoft SQL Server
- **Type**: Relational (Proprietary)
- **Use Cases**: Windows environments, .NET apps
- **Strengths**: Integration with Microsoft tools
- **Owner**: Microsoft

### SQLite
- **Type**: Relational (Open-source)
- **Use Cases**: Mobile apps, embedded systems
- **Strengths**: Lightweight, serverless, self-contained
- **Public Domain**: Free for any use

---

## 📊 DBMS Comparison Table

| DBMS | Type | License | Best For | Scalability |
|------|------|---------|----------|-------------|
| **MySQL** | Relational | Open-source | Web apps | Good |
| **PostgreSQL** | Relational | Open-source | Complex queries | Excellent |
| **MongoDB** | NoSQL | Open-source | Flexible data | Excellent |
| **Oracle** | Relational | Proprietary | Enterprise | Excellent |
| **SQL Server** | Relational | Proprietary | Windows/.NET | Excellent |
| **SQLite** | Relational | Open-source | Mobile/Embedded | Limited |

---

## 💡 Study Tips

1. **Understand database models**: Relational vs. NoSQL
2. **Learn SQL basics**: SELECT, INSERT, UPDATE, DELETE
3. **Master normalization**: 1NF, 2NF, 3NF concepts
4. **Know ACID properties**: Atomicity, Consistency, Isolation, Durability
5. **Practice SQL queries**: Write queries for different scenarios
6. **Compare DBMS**: Know strengths of MySQL, PostgreSQL, MongoDB
7. **Understand transactions**: COMMIT, ROLLBACK operations

---

## ✅ Unit 5 Checklist

- [ ] Understand database fundamentals
- [ ] Learn relational database concepts
- [ ] Master basic SQL commands
- [ ] Understand database normalization
- [ ] Know ACID properties
- [ ] Learn about transactions
- [ ] Compare different DBMS
- [ ] Complete discussion post
- [ ] Respond to peers (3 responses)
- [ ] Review all study guides
- [ ] Prepare for quiz

---

## 🎓 Real-World Applications

- **E-Commerce**: Product catalogs, orders, customers (MySQL, PostgreSQL)
- **Social Media**: User profiles, posts, relationships (MongoDB, Cassandra)
- **Banking**: Transactions, accounts (Oracle, SQL Server)
- **Healthcare**: Patient records, medical history (PostgreSQL, Oracle)
- **Mobile Apps**: Local data storage (SQLite)
- **Analytics**: Data warehousing, reporting (PostgreSQL, Snowflake)
- **Gaming**: Player data, leaderboards (MongoDB, Redis)

---

## 🔑 Key SQL Commands Reference

```sql
-- Create database
CREATE DATABASE school;

-- Use database
USE school;

-- Create table
CREATE TABLE students (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    age INT
);

-- Insert data
INSERT INTO students VALUES (1, 'Alice', 20);

-- Query data
SELECT * FROM students WHERE age > 18;

-- Update data
UPDATE students SET age = 21 WHERE id = 1;

-- Delete data
DELETE FROM students WHERE id = 1;

-- Join tables
SELECT s.name, c.course_name
FROM students s
JOIN enrollments e ON s.id = e.student_id
JOIN courses c ON e.course_id = c.id;
```

---

**Note**: Database management is crucial for modern applications. Understanding DBMS concepts and SQL is essential for software development, data analysis, and system administration careers.
