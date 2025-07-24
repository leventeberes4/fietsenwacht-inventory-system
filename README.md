# Fietsenwacht Inventory System

An internal tool for Fietsenwacht, a mobile bike repair company in the Netherlands.  
The application connects mechanics working on the road with the company’s inventory system, allowing fast bill creation for clients and seamless tracking of used parts.

## 🔧 Purpose

Mechanics use the app to quickly create bills while on-site with clients.  
While they don’t interact with inventory directly, their actions automatically update stock levels and part usage in the backend — giving admins real-time insights and control.

## 🧱 Tech Stack

- **Frontend**: React, Redux Toolkit, Tailwind CSS
- **Backend**: Spring Boot
- **Database**: MongoDB
- **Other**: RESTful APIs, Docker

## ✅ Features (so far)

- Full CRUD operations for SKUs

- Basic inventory tracking implemented for both warehouses and mobile repair buses

## 🛠️ Planned Features

- Authentication & role-based access (Admin vs Mechanic)
- Offline-first mode with sync on reconnection
- Versioning or optimistic locking for safe staged updates
- Full history of used parts and bill edits
- Barcode scanning for fast part entry

## 🚧 Status

Work in progress — currently building the core flows and syncing logic.

---

> This project was built as part of a real-world use case for a working mobile repair team.

