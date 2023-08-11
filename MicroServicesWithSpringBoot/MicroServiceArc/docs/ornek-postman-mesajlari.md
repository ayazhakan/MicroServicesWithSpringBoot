
#### Account Servisi (Account Yaratma)
```
 http://localhost:8501/account

{
	"username" : "ayazhakan",
    "name" : "Hakan",
    "surname" : "AYAZ",
    "email" : "hakanayaz9844@outlook.com",
    "birthDate" : "1998-01-01"
}
```

#### Ticket Servisi (Ticket Yaratma)

```
 http://localhost:8502/ticket

{
	"description" : "Test Ticket 1",
    "notes" : "Test Ticket 1 - Docker Compose Hatasi",
    "assignee" : "ayazhakan",
    "priorityType" : "URGENT",
    "ticketStatus" : "OPEN",
    "ticketDate" : "2023-10-08"
}
```