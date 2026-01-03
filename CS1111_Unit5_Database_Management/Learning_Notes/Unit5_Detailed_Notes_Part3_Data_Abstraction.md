# Unit 5: Database Management Systems - Part 3: Views of Data, Data Abstraction, and Data Independence

## 1. Views of Data

In a database system, data can be viewed at different levels of abstraction. This multi-level view helps manage complexity and provides different perspectives for different users.

---

## 2. Data Abstraction

**Data Abstraction** is the process of hiding irrelevant details from users while highlighting the essential features. It simplifies the user's interaction with the database by presenting data in a way that is easy to understand and use.

**Purpose:**
- Simplify complex data structures
- Hide implementation details
- Provide user-friendly interfaces
- Enable data independence

---

## 3. Three-Schema Architecture (ANSI-SPARC Architecture)

The three-schema architecture divides the database into three levels of abstraction:

### Level 1: Physical Level (Internal Level)

**What it is:**
- Lowest level of abstraction
- Describes HOW data is physically stored
- Deals with storage details

**Details Include:**
- Physical storage structures
- File organization (sequential, indexed, hashed)
- Access paths and indexes
- Data compression techniques
- Encryption methods
- Storage allocation

**Who uses it:**
- Database administrators (DBAs)
- System programmers
- DBMS developers

**Example:**
```
Student record stored as:
- File: students.dat
- Location: Block 1024, Offset 512
- Index: B-tree on student_id
- Storage: 256 bytes per record
- Compression: Run-length encoding
```

**Characteristics:**
- Most complex level
- Hardware-dependent
- Performance-critical
- Hidden from end users

---

### Level 2: Logical Level (Conceptual Level)

**What it is:**
- Middle level of abstraction
- Describes WHAT data is stored
- Defines logical structure of entire database

**Details Include:**
- Tables and their relationships
- Data types and constraints
- Integrity rules
- Security and access controls
- Complete database schema

**Who uses it:**
- Database administrators
- Database designers
- Application developers

**Example:**
```sql
CREATE TABLE Students (
    student_id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    age INT CHECK (age >= 18),
    major VARCHAR(30),
    gpa DECIMAL(3,2)
);

CREATE TABLE Enrollments (
    student_id INT,
    course_id INT,
    grade CHAR(2),
    FOREIGN KEY (student_id) REFERENCES Students(student_id)
);
```

**Characteristics:**
- Describes entire database structure
- Independent of physical storage
- Defines relationships between entities
- Enforces business rules

---

### Level 3: View Level (External Level)

**What it is:**
- Highest level of abstraction
- Describes HOW users see data
- Multiple views for different users
- Customized perspectives

**Details Include:**
- User-specific data subsets
- Derived/calculated fields
- Simplified representations
- Security through restricted access

**Who uses it:**
- End users
- Application programs
- Different user groups

**Example:**
```sql
-- View for students (see only their own data)
CREATE VIEW StudentView AS
SELECT student_id, name, major, gpa
FROM Students
WHERE student_id = CURRENT_USER_ID;

-- View for faculty (see student grades)
CREATE VIEW FacultyView AS
SELECT s.name, e.course_id, e.grade
FROM Students s
JOIN Enrollments e ON s.student_id = e.student_id;

-- View for registrar (see enrollment statistics)
CREATE VIEW RegistrarView AS
SELECT major, COUNT(*) as student_count, AVG(gpa) as avg_gpa
FROM Students
GROUP BY major;
```

**Characteristics:**
- Simplest for users
- Hides complexity
- Provides security
- Multiple views possible
- Can include calculated fields

---

## 4. Three-Schema Architecture Diagram

```
┌─────────────────────────────────────────┐
│         VIEW LEVEL (External)           │
│  ┌──────────┐  ┌──────────┐  ┌────────┐│
│  │ View 1   │  │ View 2   │  │ View 3 ││
│  │(Students)│  │(Faculty) │  │(Admin) ││
│  └──────────┘  └──────────┘  └────────┘│
└─────────────────────────────────────────┘
              ↕ (External/Conceptual Mapping)
┌─────────────────────────────────────────┐
│      LOGICAL LEVEL (Conceptual)         │
│  ┌────────────────────────────────────┐ │
│  │  Complete Database Schema          │ │
│  │  - All tables and relationships    │ │
│  │  - Constraints and rules           │ │
│  │  - Security definitions            │ │
│  └────────────────────────────────────┘ │
└─────────────────────────────────────────┘
              ↕ (Conceptual/Internal Mapping)
┌─────────────────────────────────────────┐
│      PHYSICAL LEVEL (Internal)          │
│  ┌────────────────────────────────────┐ │
│  │  Physical Storage Details          │ │
│  │  - File structures                 │ │
│  │  - Indexes and access paths        │ │
│  │  - Storage allocation              │ │
│  └────────────────────────────────────┘ │
└─────────────────────────────────────────┘
```

---

## 5. Data Independence

**Data Independence** is the capacity to change the schema at one level without affecting the schema at the next higher level. It is a key benefit of the three-schema architecture.

**Purpose:**
- Protect applications from changes
- Enable system evolution
- Improve flexibility
- Reduce maintenance costs

---

### A. Physical Data Independence

**Definition:**
The ability to change the physical schema (internal level) without changing the logical schema (conceptual level) or application programs.

**What can change:**
- Storage structures
- File organization
- Access methods
- Indexes
- Storage devices
- Data compression
- Encryption methods

**What remains unchanged:**
- Logical structure (tables, relationships)
- Application programs
- User views

**Example:**
```
Change: Add an index on student_name for faster searches
Impact: None on applications or logical schema

Before:
- Sequential file scan for name searches
- Slow performance

After:
- B-tree index on student_name
- Fast indexed searches
- Applications work exactly the same
```

**Benefits:**
- Performance tuning without affecting applications
- Upgrade storage hardware
- Change file organization
- Add/remove indexes
- Optimize physical layout

**Real-World Example:**
A university database administrator decides to:
1. Move database from HDD to SSD (faster storage)
2. Add indexes on frequently queried columns
3. Change from sequential to hashed file organization

**Result:** Applications continue working without modification, but queries run faster.

---

### B. Logical Data Independence

**Definition:**
The ability to change the logical schema (conceptual level) without changing the external schema (view level) or application programs.

**What can change:**
- Add new tables
- Add new columns to existing tables
- Modify relationships
- Change constraints
- Reorganize data structure

**What remains unchanged:**
- User views (if designed properly)
- Application programs (if they use views)

**Example:**
```sql
-- Original logical schema
CREATE TABLE Students (
    student_id INT,
    name VARCHAR(50),
    contact VARCHAR(100)  -- Single field for all contact info
);

-- Modified logical schema (split contact into multiple fields)
CREATE TABLE Students (
    student_id INT,
    name VARCHAR(50),
    email VARCHAR(50),
    phone VARCHAR(15),
    address VARCHAR(100)
);

-- View maintains compatibility
CREATE VIEW StudentView AS
SELECT 
    student_id,
    name,
    CONCAT(email, ', ', phone, ', ', address) AS contact
FROM Students;

-- Applications using StudentView continue working unchanged
```

**Benefits:**
- Evolve database structure
- Add new features
- Improve data organization
- Maintain backward compatibility

**Challenges:**
- Harder to achieve than physical independence
- May require view updates
- Some changes break compatibility

**Real-World Example:**
A company decides to:
1. Split "Name" field into "FirstName" and "LastName"
2. Add new "MiddleName" field
3. Add "DateOfBirth" field

**Solution:** Create views that concatenate FirstName and LastName as "Name" for existing applications, while new applications use the detailed fields.

---

## 6. Comparison: Physical vs. Logical Data Independence

| Aspect | Physical Independence | Logical Independence |
|--------|----------------------|---------------------|
| **Level** | Internal → Conceptual | Conceptual → External |
| **Changes** | Storage, indexes, files | Tables, columns, relationships |
| **Difficulty** | Easier to achieve | Harder to achieve |
| **Frequency** | More common | Less common |
| **Impact** | Performance | Functionality |
| **Examples** | Add index, change storage | Add table, split column |
| **Tools** | DBMS handles automatically | Requires views/mappings |

---

## 7. Benefits of Data Abstraction and Independence

### For Users:
1. **Simplified Interaction:** Don't need to understand physical storage
2. **Customized Views:** See only relevant data
3. **Security:** Access only authorized information
4. **Consistency:** Same logical view despite physical changes

### For Developers:
1. **Easier Development:** Work with logical structures, not physical details
2. **Reduced Maintenance:** Changes at one level don't cascade
3. **Flexibility:** Modify database without breaking applications
4. **Reusability:** Same logical schema, different physical implementations

### For Administrators:
1. **Performance Tuning:** Optimize physical storage without affecting users
2. **System Evolution:** Upgrade hardware and software independently
3. **Scalability:** Distribute data without changing logical structure
4. **Backup/Recovery:** Manage physical storage independently

---

## 8. Database Schema vs. Database Instance

### Schema
- **Definition:** Overall design/structure of database
- **Characteristics:** Rarely changes, defines organization
- **Example:** Table definitions, relationships, constraints
- **Analogy:** Blueprint of a house

### Instance
- **Definition:** Actual data stored at a particular moment
- **Characteristics:** Changes frequently, actual content
- **Example:** Specific student records, course enrollments
- **Analogy:** Furniture and people in the house

**Relationship:**
- Schema defines structure
- Instance contains data conforming to schema
- Multiple instances over time, one schema (unless modified)

---

## 9. Mappings Between Levels

### External/Conceptual Mapping
- Defines how views are derived from logical schema
- Implemented through view definitions
- Enables logical data independence

### Conceptual/Internal Mapping
- Defines how logical structures map to physical storage
- Handled by DBMS
- Enables physical data independence

**Example:**
```
View Level:     SELECT name, gpa FROM StudentView
                        ↓ (External/Conceptual Mapping)
Logical Level:  Students table with columns: id, name, age, major, gpa
                        ↓ (Conceptual/Internal Mapping)
Physical Level: File: students.dat, B-tree index on id, 256 bytes/record
```

---

## 10. Real-World Scenario

**Scenario:** University Database Evolution

**Initial State:**
- Physical: Data on slow HDDs
- Logical: Students table with basic fields
- Views: Student portal, faculty portal, admin portal

**Change 1 (Physical Independence):**
- Migrate to SSDs
- Add indexes on frequently queried fields
- Change file organization
- **Result:** Faster performance, no application changes needed

**Change 2 (Logical Independence):**
- Split Name into FirstName, LastName
- Add MiddleName, DateOfBirth fields
- Add new Addresses table
- **Result:** Update views to maintain compatibility, old applications work, new applications use detailed fields

---

## Key Takeaways

1. **Three levels of abstraction:** Physical, Logical, View
2. **Physical level:** How data is stored (files, indexes)
3. **Logical level:** What data is stored (tables, relationships)
4. **View level:** How users see data (customized perspectives)
5. **Physical independence:** Change storage without affecting logic
6. **Logical independence:** Change structure without affecting views
7. **Data abstraction:** Hide complexity, show essentials
8. **Benefits:** Flexibility, security, simplified interaction, easier maintenance
9. **Mappings:** Connect levels, enable independence
10. **Schema vs. Instance:** Structure vs. actual data

---

## Essential Questions

1. **How does data abstraction contribute to the efficiency of a database system?**
   - Hides complexity from users
   - Simplifies interaction
   - Enables changes at one level without affecting others
   - Provides customized views for different users
   - Improves security through restricted access

2. **What is the difference between physical and logical data independence?**
   - Physical: Change storage without affecting logical structure
   - Logical: Change structure without affecting user views
   - Physical is easier to achieve
   - Both enable system evolution without breaking applications

3. **Why is the three-schema architecture important?**
   - Separates concerns (storage, structure, presentation)
   - Enables data independence
   - Provides security through views
   - Simplifies database management
   - Supports multiple user perspectives

---

## References

Vidhya, V., Jeyaram, G., & Ishwarya, K. (2016). *Database management systems*. Alpha Science International.

IBM. (n.d.). What is a database schema? https://www.ibm.com/topics/database-schema

Tutorials Point. (2021, March 18). *Three-schema architecture & data independence* [Video]. YouTube. https://www.youtube.com/watch?v=5Q8Kqpp0gqw

The Knowledge Adda. (2025, January 30). *RDBMS - L5: Data models | Data abstraction | Data independence* [Video]. YouTube. https://www.youtube.com/watch?v=example

Neso Academy. (2022, August 18). *View of data* [Video]. YouTube. https://www.youtube.com/watch?v=example
