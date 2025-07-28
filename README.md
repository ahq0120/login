# Spring Boot 登入系統

這是一個基礎的登入系統，使用Spring Boot搭配Thymeleaf、Spring Security、JPA和MySQL資料庫實作，支援用戶註冊與登入功能。

## 功能簡介

- 使用者註冊帳號（含帳號、密碼與 email）
- 使用者登入驗證
- 登入成功後顯示歡迎頁面
- 密碼加密儲存（使用 Spring Security 提供的加密機制）
- 表單具備 CSRF 保護

## 技術架構

- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- Thymeleaf
- MySQL

## 畫面路徑

- `/register`：用戶註冊頁面
- `/login`：用戶登入頁面
- `/home`：登入成功後導向的主頁

## 專案結構

```plaintext
login
├── src
│   └── main
│       ├── java
│       │   └── com.example.login
│       │       ├── LoginApplication.java
│       │       ├── controller
│       │       │   └── MemberController.java
│       │       ├── entity
│       │       │   └── Member.java
│       │       ├── repository
│       │       │   └── MemberRepository.java
│       │       ├── service
│       │       │   ├── MemberService.java
│       │       │   └── CustomUserDetailsService.java
│       │       └── security
│       │           └── SecurityConfig.java
│       └── resources
│           ├── templates
│           │   ├── register.html
│           │   ├── login.html
│           │   └── home.html
│           └── application.properties
```

## 設定說明

在 `application.properties` 填入MySQL資料庫資訊：

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/資料庫名稱
spring.datasource.username=你的帳號
spring.datasource.password=你的密碼

spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true

spring.thymeleaf.cache=false

