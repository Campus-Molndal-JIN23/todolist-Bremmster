``` mermaid
classDiagram
TodoTable -- UserTable
class TodoTable{
int id_PK
String text
int done
int asignedTo_FK
}
class UserTable{
int id_PK
String name
int age
}
```
