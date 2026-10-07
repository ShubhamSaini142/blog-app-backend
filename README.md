<h1 align="center">📝 Blog App Backend</h1>

<p align="center">
  A RESTful blogging API built with <b>Spring Boot 3</b>, <b>Spring Data JPA</b> and <b>MySQL</b>. It manages users, categories and posts, and the relationships between them.
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-ED8B00?style=flat-square&logo=openjdk&logoColor=white" alt="Java 17"/>
  <img src="https://img.shields.io/badge/Spring%20Boot-3.2-6DB33F?style=flat-square&logo=springboot&logoColor=white" alt="Spring Boot 3.2"/>
  <img src="https://img.shields.io/badge/Spring%20Data%20JPA-Hibernate-59666C?style=flat-square&logo=hibernate&logoColor=white" alt="Spring Data JPA"/>
  <img src="https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=mysql&logoColor=white" alt="MySQL"/>
  <img src="https://img.shields.io/badge/Gradle-02303A?style=flat-square&logo=gradle&logoColor=white" alt="Gradle"/>
</p>

## ✨ Features

- 👤 **Users**: create, update, fetch and delete users
- 🗂️ **Categories**: group posts into categories, each with a title and description
- 📰 **Posts**: create a post for a user within a category, then list posts by user or by category
- 🔗 **JPA relationships**: each user and category has many posts, with cascading operations
- ✅ **Request validation** with Bean Validation (`@Valid`)
- ⚠️ **Error handling**: a custom `ResourceNotFoundException` for missing users, categories and posts

## 🔌 API

**Users** (`/api/users`)

| Method | Endpoint | Description |
|:--|:--|:--|
| `POST` | `/api/users/` | Create a user |
| `PUT` | `/api/users/update/{id}` | Update a user |
| `GET` | `/api/users/{id}` | Get a user |
| `GET` | `/api/users/all` | List all users |
| `DELETE` | `/api/users/delete/{id}` | Delete a user |
| `DELETE` | `/api/users/deleteAll` | Delete all users |

**Categories** (`/api/category`)

| Method | Endpoint | Description |
|:--|:--|:--|
| `POST` | `/api/category/` | Create a category |
| `PUT` | `/api/category/update/{id}` | Update a category |
| `GET` | `/api/category/{id}` | Get a category |
| `GET` | `/api/category/all` | List all categories |
| `DELETE` | `/api/category/delete/{id}` | Delete a category |
| `DELETE` | `/api/category/deleteAll` | Delete all categories |

**Posts** (`/api/posts`)

| Method | Endpoint | Description |
|:--|:--|:--|
| `POST` | `/api/posts/user/{userId}/category/{catId}/create` | Create a post |
| `PUT` | `/api/posts/{postId}/update` | Update a post |
| `GET` | `/api/posts/{postId}` | Get a post |
| `GET` | `/api/posts/getallposts` | List all posts |
| `GET` | `/api/posts/user/{userId}` | List posts by a user |
| `GET` | `/api/posts/category/{catId}` | List posts in a category |
| `DELETE` | `/api/posts/delete/{postId}` | Delete a post |

## 🚀 Getting Started

**Prerequisites:** Java 17, MySQL

```bash
# 1. Create the database
mysql -u root -p -e "CREATE DATABASE blogapp;"

# 2. Set your database credentials in src/main/resources/application.properties

# 3. Run the app
./gradlew bootRun             # runs on http://localhost:8080
```
