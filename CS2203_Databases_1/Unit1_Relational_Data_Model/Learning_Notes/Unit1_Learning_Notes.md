# CS 2203 Unit 1 Learning Notes: Databases and the Relational Data Model

## Database vs DBMS
- **Database:** a repository of data designed for efficient storage, retrieval and maintenance
  (Sharma et al., 2010, p. 23).
- **DBMS:** the software that controls access to the data and organizes, stores, retrieves and
  maintains it. An RDBMS does this for tables (MySQL, PostgreSQL, SQL Server, Oracle, DB2).

## File processing system vs database (Vidhya et al., 2016, pp. 24-29)
| File system problem | How a DBMS fixes it |
|---|---|
| Same data copied into many files (redundancy) | Each fact stored once, redundancy controlled |
| Copies disagree (inconsistency) | One source of truth, integrity constraints |
| Programs depend on the file layout | Program-data independence through the catalogue |
| Hard to share, no concurrent use | Many users at once with concurrency control |
| Weak security, no backup tools | Access rights, backup and recovery |

Disadvantages of a DBMS: cost, complexity, needs trained staff, more hardware, and a single
failure point if not backed up.

## Characteristics of the database approach (Watt & Eng, 2014, Chapter 3)
1. Self-describing (metadata in the system catalogue)
2. Insulation between programs and data (program-data independence)
3. Support for multiple views of data
4. Sharing of data and multiuser transaction processing (concurrency control)
Also: controlled redundancy, integrity constraints, restricted unauthorized access, backup.

## Information model vs data model (Sharma et al., 2010, pp. 26-27)
- **Information model:** conceptual, hides implementation details, for designers.
- **Data model:** concrete blueprint for implementers. One information model can produce several
  data models.
- Watt & Eng (2014, Chapter 4): high-level conceptual (ER) model; record-based logical models
  (relational, network, hierarchical); physical model.

## Types of data models
| Model | Structure | Key point |
|---|---|---|
| Hierarchical (IMS, 1968) | Tree | A child has only one parent |
| Network (CODASYL) | Graph of record types | A child can have many parents |
| Relational (Codd, 1970) | Tables | Data independence, set-based SQL, most used |
| Entity-Relationship (Chen) | Entities, attributes, relationships | Used to design relational databases |
| Object-oriented | Objects and classes | Popular in research, less in industry |
| Object-relational | Tables plus user-defined types and inheritance | Mix of both |

## Job roles (Sharma et al., 2010, pp. 32-34)
- **Data architect (data modeler):** enterprise data strategy, standards, logical and physical models.
- **Database architect:** solution architecture, standards, SLAs for availability, backup, security.
- **DBA:** maintenance, performance, integrity, security, users and access, backup and recovery.
- **Application developer:** writes the programs that access the database.
- Others: data analyst (reports and insights), end users.

## Relational model terms (Watt & Eng, 2014, Chapter 7)
| Formal | Everyday |
|---|---|
| Relation | Table |
| Tuple | Row / record |
| Attribute | Column / field |
| Domain | Set of allowed values |
| Degree | Number of attributes |
| Cardinality | Number of tuples |

Table rules: unique name, no duplicate rows, atomic values, one domain per column, order of rows
and columns does not matter.

## Keys and constraints (Watt & Eng, 2014, Chapters 8 and 9)
- **Candidate key:** a minimal set of columns that identifies a row. **Primary key:** the chosen one.
- **Foreign key:** a column that points to a primary key in another table.
- **Entity integrity:** a primary key can never be null.
- **Referential integrity:** a foreign key must match an existing primary key or be null
  (no orphan rows).
- **Domain integrity:** values must come from the column's domain (type, range, format).

## Relationship types
- **1:1** one person, one passport.
- **1:M** one customer, many orders: put the foreign key on the "many" side.
- **M:N** orders and products: needs a bridge (associative) table holding both keys.
- **Unary:** a table related to itself (category and subcategory, employee and manager).

## References
Sharma, N., Perniu, L., Chong, R. F., Iyer, A., Nandan, C., Mitea, A. C., Nonvinkere, M., &
Danubianu, M. (2010). *Database fundamentals*. IBM Corporation.
https://public.dhe.ibm.com/software/dw/db2/express-c/wiki/Database_fundamentals.pdf

Vidhya, V., Jeyaram, G., & Ishwarya, K. R. (2016). *Database management systems*. Alpha Science
International.

Watt, A., & Eng, N. (2014). *Database design* (2nd ed.). BCcampus. https://opentextbc.ca/dbdesign01/
