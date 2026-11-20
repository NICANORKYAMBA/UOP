# CS 2203 Unit 2 Learning Notes: Entity-Relationship Modelling

Reading: Vidhya et al. (2016), Section 2.8 (pp. 43-60); Nalimov (2021); Ellie (2022) video.

## Three levels of data model
| Level | Shows | Audience | DBMS-specific? |
|---|---|---|---|
| Conceptual | Entities and relationships (few or no attributes) | Business stakeholders | No |
| Logical | Attributes, keys, relationships resolved | Analysts, designers | No |
| Physical | Tables, data types, constraints, indexes, storage | Developers, DBA | Yes |

## ER building blocks (Chen notation)
- **Entity** (rectangle), **weak entity** (double rectangle, depends on an owner).
- **Attribute** (oval): key (underlined), composite, multivalued (double oval), derived (dashed oval).
- **Relationship** (diamond), can have its own attributes (quantity on Order contains Product).

## Constraints
- **Cardinality ratio:** 1:1, 1:N, M:N.
- **Participation:** total (double line, every instance must take part) vs partial (single line).
- Crow's foot: bar = one/mandatory, circle = zero/optional, crow's foot = many. Read as min..max (0..*, 1..1, 1..*).

## Keys
Super key ⊇ candidate key (minimal) → primary key (chosen); alternate key = unused candidate; foreign key = references another table's PK; composite key = more than one column.

## Mapping ER to tables
1. Each strong entity → table, its key → PK.
2. 1:N → put the "1" side's PK as an FK in the "N" table.
3. M:N → new associative table with both PKs as a composite PK (Order_Item).
4. 1:1 → FK on the side with total participation.
5. Multivalued attribute → separate table.

## Extended ER
Specialization/generalization (ISA), aggregation, inheritance of attributes by subclasses.
