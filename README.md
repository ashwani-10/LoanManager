Customer & Loan Management System

A backend system to manage customers and their loan applications.

---

## Tech Stack
- Java
- Spring Boot
- PostgreSQL
---

## Thought Process
- Separated logic into controller, service, and repository layers.
- Used DTOs to handle request data.
- Designed two main entities: `Customer` and `Loan`.
- Established a `ManyToOne` relationship from Loan to Customer.
- Auto-generated credit scores and calculated interest rates based on it.
- After aprooving/rejecting loan application by admin customer will get notified through email.
---

## Possible Improvements
- Loan Repayment Tracker and EMI schedule
- Application Security (JWT/Spring Security)
- Admin Dashboard to view customer and loan stats

---
