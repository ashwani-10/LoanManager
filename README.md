# FinTech Customer & Loan Management System

A backend system to manage customers and their loan applications.

---

## Tech Stack
- Java
- Spring Boot
- PostgreSQL
- Lombok

---

## Thought Process
- Separated logic into controller, service, and repository layers.
- Used DTOs to handle request data.
- Designed two main entities: `Customer` and `Loan`.
- Established a `ManyToOne` relationship from Loan to Customer.
- Auto-generated credit scores and calculated interest rates based on it.

---

## APIs Implemented
- `POST /api/customers/registration` – Register new customer
- `POST /api/loans/apply` – Apply for loan
- `PUT /api/loans/{loanId}/status` – Approve/Reject loan
- `GET /api/loans` – Get all loans

---
