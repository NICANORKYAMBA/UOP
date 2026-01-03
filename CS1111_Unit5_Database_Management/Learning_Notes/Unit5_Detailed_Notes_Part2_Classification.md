# Unit 5: Database Management Systems - Part 2: Classification and Data Models

## 1. Classification of DBMS

Database Management Systems can be classified based on various criteria:

---

### A. Based on Data Model

#### 1. Hierarchical DBMS

**Structure:**
- Tree-like structure
- Parent-child relationships
- One-to-many relationships
- Root node at top, children below

**Characteristics:**
- Data organized in hierarchy
- Each child has only one parent
- Parent can have multiple children
- Fast access through predefined paths

**Advantages:**
- Simple and easy to understand
- Fast data retrieval (if path known)
- Data integrity maintained
- Efficient for one-to-many relationships

**Disadvantages:**
- Inflexible structure
- Difficult to reorganize
- Redundancy in many-to-many relationships
- Complex queries require multiple paths

**Example:**
```
        Company (Root)
           |
    ---------------
    |             |
Department1   Department2
    |             |
---------     ---------
|       |     |       |
Emp1  Emp2  Emp3   Emp4
```

**Use Cases:**
- File systems
- XML databases
- Organization charts
- Legacy banking systems

**Example DBMS:** IBM IMS (Information Management System)

---

#### 2. Network DBMS

**Structure:**
- Graph structure
- Many-to-many relationships
- Records connected through links (pointers)
- More flexible than hierarchical

**Characteristics:**
- Child can have multiple parents
- Complex relationships supported
- Set-based structure
- Owner-member relationships

**Advantages:**
- Handles complex relationships
- Reduces data redundancy
- More flexible than hierarchical
- Efficient data access

**Disadvantages:**
- Complex structure
- Difficult to design and maintain
- Changes require restructuring
- Requires understanding of physical structure

**Example:**
```
    Student1 -------- Course1
      |    \        /    |
      |     \      /     |
      |      \    /      |
    Student2 -------- Course2
```

**Use Cases:**
- Telecommunications networks
- Transportation systems
- Social networks (early implementations)

**Example DBMS:** Integrated Data Store (IDS), IDMS

---

#### 3. Relational DBMS (RDBMS)

**Structure:**
- Data organized in tables (relations)
- Rows (tuples) and columns (attributes)
- Relationships through keys
- Most widely used model

**Characteristics:**
- Tables with rows and columns
- Primary keys uniquely identify rows
- Foreign keys establish relationships
- SQL for querying
- ACID properties supported

**Principal Components:**

**a. Tables (Relations):**
- Two-dimensional structure
- Each row is a record
- Each column is an attribute

**b. Keys:**
- **Primary Key:** Unique identifier for each row
- **Foreign Key:** References primary key in another table
- **Candidate Key:** Potential primary keys
- **Composite Key:** Multiple columns as key

**c. Relationships:**
- **One-to-One:** One record relates to one record
- **One-to-Many:** One record relates to many records
- **Many-to-Many:** Many records relate to many records

**d. Constraints:**
- NOT NULL, UNIQUE, PRIMARY KEY, FOREIGN KEY
- CHECK constraints for validation
- DEFAULT values

**Advantages:**
- Simple and intuitive structure
- Flexible and easy to modify
- Powerful query language (SQL)
- Data independence
- Reduces redundancy through normalization
- Wide industry support

**Disadvantages:**
- Performance issues with very large datasets
- Complex queries can be slow
- Rigid schema (must define structure upfront)
- Scaling challenges for distributed systems

**Characteristics of Relational Model:**

1. **Data Structure:** Tables with rows and columns
2. **Data Manipulation:** SQL operations (SELECT, INSERT, UPDATE, DELETE)
3. **Data Integrity:** Constraints ensure valid data
4. **Normalization:** Reduce redundancy through normal forms
5. **Relationships:** Foreign keys link tables
6. **ACID Properties:** Atomicity, Consistency, Isolation, Durability

**Example:**
```sql
Students Table:
+----+-------+-----+
| ID | Name  | Age |
+----+-------+-----+
| 1  | Alice | 20  |
| 2  | Bob   | 22  |
+----+-------+-----+

Courses Table:
+----+--------+
| ID | Course |
+----+--------+
| 1  | CS101  |
| 2  | MATH   |
+----+--------+

Enrollments Table (Many-to-Many):
+------------+-----------+
| Student_ID | Course_ID |
+------------+-----------+
| 1          | 1         |
| 1          | 2         |
| 2          | 1         |
+------------+-----------+
```

**Use Cases:**
- Business applications
- E-commerce platforms
- Banking systems
- Enterprise resource planning (ERP)
- Customer relationship management (CRM)

**Example DBMS:** MySQL, PostgreSQL, Oracle, SQL Server, SQLite

---

#### 4. Object-Oriented DBMS (OODBMS)

**Structure:**
- Data stored as objects (like OOP)
- Objects have attributes and methods
- Supports inheritance and polymorphism
- Complex data types

**Characteristics:**
- Objects with identity
- Encapsulation of data and behavior
- Class hierarchies and inheritance
- Complex data types (multimedia, spatial)
- Direct mapping to OOP languages

**Advantages:**
- Natural fit for OOP applications
- Handles complex data types
- Better performance for complex objects
- Supports multimedia data
- Reusability through inheritance

**Disadvantages:**
- Lack of standardization
- Limited adoption
- Complex query language
- Steep learning curve
- Less mature than RDBMS

**Use Cases:**
- CAD/CAM systems
- Multimedia databases
- Scientific applications
- Engineering design
- Telecommunications

**Example DBMS:** ObjectDB, db4o, Versant

---

#### 5. NoSQL DBMS

**Types of NoSQL Databases:**

**a. Document Databases:**
- Store data as documents (JSON, XML, BSON)
- Flexible schema
- Nested structures supported

**Example:** MongoDB, CouchDB
```json
{
  "_id": "1001",
  "name": "Alice",
  "age": 20,
  "courses": ["CS101", "MATH201"],
  "address": {
    "city": "Boston",
    "state": "MA"
  }
}
```

**b. Key-Value Stores:**
- Simple key-value pairs
- Fast retrieval by key
- No complex queries

**Example:** Redis, DynamoDB
```
Key: "user:1001"
Value: {"name": "Alice", "age": 20}
```

**c. Column-Family Stores:**
- Data stored in columns
- Optimized for analytics
- Sparse data handling

**Example:** Cassandra, HBase
```
Row Key: 1001
Column Family: Personal
  name: Alice
  age: 20
Column Family: Academic
  major: CS
  gpa: 3.8
```

**d. Graph Databases:**
- Nodes and relationships
- Optimized for connected data
- Social networks, recommendations

**Example:** Neo4j, Amazon Neptune
```
(Alice)-[:FRIENDS_WITH]->(Bob)
(Alice)-[:ENROLLED_IN]->(CS101)
```

**Advantages of NoSQL:**
- Flexible schema (schema-less)
- Horizontal scalability
- High performance for specific use cases
- Handles unstructured data
- Distributed architecture

**Disadvantages of NoSQL:**
- Limited ACID support (eventual consistency)
- No standard query language
- Less mature than RDBMS
- Complex joins difficult
- Limited tooling

**Use Cases:**
- Big data applications
- Real-time web applications
- Content management
- IoT data storage
- Social media platforms

---

### B. Based on Number of Users

#### 1. Single-User DBMS
- Supports one user at a time
- Desktop databases
- Example: Microsoft Access, SQLite

#### 2. Multi-User DBMS
- Supports multiple concurrent users
- Enterprise databases
- Example: MySQL, PostgreSQL, Oracle

---

### C. Based on Distribution

#### 1. Centralized DBMS
- Data stored in single location
- All users access central database
- Easier to manage and secure

**Advantages:**
- Simple administration
- Data consistency
- Lower cost

**Disadvantages:**
- Single point of failure
- Network dependency
- Scalability limits

#### 2. Distributed DBMS
- Data distributed across multiple locations
- Connected through network
- Appears as single database to users

**Advantages:**
- Improved reliability (no single point of failure)
- Better performance (data closer to users)
- Scalability
- Local autonomy

**Disadvantages:**
- Complex management
- Data consistency challenges
- Higher cost
- Security concerns

**Types:**
- **Homogeneous:** Same DBMS at all sites
- **Heterogeneous:** Different DBMS at different sites

---

### D. Based on Purpose

#### 1. OLTP (Online Transaction Processing)
- Handle day-to-day transactions
- Many short transactions
- Insert, update, delete operations
- Example: Banking, e-commerce

**Characteristics:**
- High volume of transactions
- Fast query processing
- Data integrity critical
- Normalized data

#### 2. OLAP (Online Analytical Processing)
- Complex queries and analysis
- Read-heavy operations
- Historical data analysis
- Example: Business intelligence, data warehousing

**Characteristics:**
- Complex queries
- Large data volumes
- Aggregations and calculations
- Denormalized data (for performance)

---

## 2. Comparison of Database Models

| Feature | Hierarchical | Network | Relational | Object-Oriented | NoSQL |
|---------|-------------|---------|-----------|----------------|-------|
| **Structure** | Tree | Graph | Tables | Objects | Varies |
| **Relationships** | One-to-many | Many-to-many | All types | All types | Varies |
| **Flexibility** | Low | Medium | High | High | Very High |
| **Complexity** | Low | High | Medium | High | Medium |
| **Query Language** | Procedural | Procedural | SQL | OQL | Varies |
| **Performance** | Fast (predefined paths) | Fast | Good | Good | Excellent (specific use) |
| **Scalability** | Limited | Limited | Good | Good | Excellent |
| **Use Cases** | Legacy systems | Telecom | Business apps | CAD/CAM | Big data, web |

---

## 3. Evolution of Database Systems

**1960s - Hierarchical and Network Models:**
- First DBMS developed
- IBM IMS (hierarchical)
- CODASYL (network)

**1970s - Relational Model:**
- E.F. Codd proposes relational model
- SQL developed
- Foundation for modern databases

**1980s - Commercial RDBMS:**
- Oracle, DB2, SQL Server emerge
- SQL becomes standard
- Widespread adoption

**1990s - Object-Oriented and Object-Relational:**
- OODBMS for complex data
- Object-relational features added to RDBMS

**2000s - NoSQL Movement:**
- Web-scale applications
- Big data challenges
- CAP theorem
- MongoDB, Cassandra, Redis

**2010s - NewSQL and Cloud Databases:**
- Combine SQL and NoSQL benefits
- Cloud-native databases
- Database-as-a-Service (DBaaS)

**2020s - AI and Automation:**
- Self-tuning databases
- AI-powered query optimization
- Automated administration

---

## Key Takeaways

1. **DBMS classified** by data model, users, distribution, purpose
2. **Hierarchical:** Tree structure, one-to-many, fast but inflexible
3. **Network:** Graph structure, many-to-many, complex but flexible
4. **Relational:** Tables, SQL, most popular, ACID compliant
5. **Object-Oriented:** Objects with methods, good for complex data
6. **NoSQL:** Flexible schema, scalable, various types (document, key-value, column, graph)
7. **Choose model** based on data structure, relationships, scalability needs
8. **Relational** dominates business applications
9. **NoSQL** excels in big data and web-scale applications

---

## References

Vidhya, V., Jeyaram, G., & Ishwarya, K. (2016). *Database management systems*. Alpha Science International.

IBM. (n.d.). What are NoSQL databases? https://www.ibm.com/topics/nosql-databases

techTFQ. (2020, August 30). *Learn what is database | Types of database | DBMS* [Video]. YouTube. https://www.youtube.com/watch?v=FR4QIeZaPeM
