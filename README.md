# Spring Boot登入系統

這是一個基礎的登入系統，使用Spring Boot搭配Thymeleaf、Spring Security、JPA和MySQL資料庫實作，支援用戶註冊與登入功能。

## 功能簡介

- 使用者註冊帳號（含帳號、密碼與email）
- 使用者登入驗證
- 登入成功後顯示歡迎頁面
- 密碼加密儲存（使用Spring Security提供的加密機制）
- CSRF防護

## 技術架構

- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- Thymeleaf
- MySQL

## 頁面路徑

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

在`application.properties`填入MySQL資料庫資訊：

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/資料庫名稱
spring.datasource.username=你的帳號
spring.datasource.password=你的密碼

spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true

spring.thymeleaf.cache=false
```

## 資料庫：`member`資料表結構

| 欄位名稱        | Type         | Not Null | Auto Increment | Unique | Primary Key | 補充說明                          |
|-----------------|--------------|----------|----------------|--------|--------------|-----------------------------------|
| id              | int          | ✅        | ✅              |        | ✅            |                           |
| username        | varchar(50)  | ✅        |                | ✅      |              | 使用者帳號                   |
| password        | varchar(255) | ✅        |                |        |              | 密碼                       |
| email           | varchar(100) |          |                |        |              | 可空白                  |
| created_at      | datetime     |          |                |        |              | 註冊時間                        |

## 執行方式

1. 建立資料表（可參考上方member資料表結構）
2. 修改application.properties設定資料庫連線資訊
3. 執行LoginApplication.java
4. 開啟瀏覽器：
   - 註冊頁面：http://localhost:8080/register  
   - 登入頁面：http://localhost:8080/login

## 執行畫面

### 註冊畫面
![register](https://github.com/ahq0120/image/blob/main/register_form.png?raw=true)

### 登入畫面
![login](https://github.com/ahq0120/image/blob/main/login_form.png?raw=true)

### 登入成功
![success](https://github.com/ahq0120/image/blob/main/login_success.png?raw=true)

### 登入失敗
![failed](https://github.com/ahq0120/image/blob/main/login_failed.png?raw=true)

### 資料庫中的使用者資料
![user table](https://github.com/ahq0120/image/blob/main/user_table.png?raw=true)
