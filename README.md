# Banking Management System (Java + JDBC)

## 📌 Project Overview

A **console-based Banking Management System** developed using **Java** and **JDBC** with **MySQL** as the backend database. The application allows users to manage bank accounts and perform basic banking operations.

---

## ✨ Features

* Create Account
* Deposit Money
* Withdraw Money
* Balance Enquiry
* Transaction History
* Menu-driven console interface

---

## 🛠 Technologies Used

* Java (JDK 8+)
* JDBC (MySQL Connector/J)
* MySQL Database
* Eclipse IDE

---

## 🗂 Project Structure

```
BankingManagementSystem
 └── src
     └── bank
         ├── BankApp.java
         ├── DBConnection.java
         ├── CreateAccount.java
         ├── Deposit.java
         ├── Withdraw.java
         ├── BalanceEnquiry.java
         ├── TransactionHistory.java
```

---

## 🧱 Database Setup

### 1️⃣ Create Database

```sql
CREATE DATABASE bankdb;
USE bankdb;
```

### 2️⃣ Create Tables

**Accounts Table**

```sql
CREATE TABLE accounts (
    account_no INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    balance DOUBLE
);
```

**Transactions Table**

```sql
CREATE TABLE transactions (
    tx_id INT PRIMARY KEY AUTO_INCREMENT,
    account_no INT,
    type VARCHAR(20),
    amount DOUBLE,
    tx_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_no) REFERENCES accounts(account_no)
);
```

---

## 🔌 JDBC Configuration

1. Download **MySQL Connector/J**
2. Add the `.jar` file to your project build path
3. Update database credentials in `DBConnection.java`

```java
String url = "jdbc:mysql://localhost:3306/bankdb";
String user = "root";
String password = "your_mysql_password";
```

---

## ▶ How to Run

1. Start **MySQL Server**
2. Open project in **Eclipse**
3. Run `BankApp.java`
4. Use the menu to perform operations

---

## ⚠ Important Notes

* Account number is **auto-generated**
* Always enter **numeric account number**
* MySQL server must be running

---

## 📷 Sample Output

--- Banking Management System ---
1. Create Account
2. Deposit
3. Withdraw
4. Balance Enquiry
5. Transaction History
6. Exit
   
📌 OUTPUT📌 
```
--- Banking Management System ---
1. Create Account
2. Deposit
3. Withdraw
4. Balance Enquiry
5. Transaction History
6. Exit
Choose option: 1
Enter Name: rahul kumar
Enter Initial Balance: 10000
Account Created Successfully

--- Banking Management System ---
1. Create Account
2. Deposit
3. Withdraw
4. Balance Enquiry
5. Transaction History
6. Exit
Choose option: 4
Enter Account Number: 3
Account Holder: rahul kumar
Current Balance: 10000.0

--- Banking Management System ---
1. Create Account
2. Deposit
3. Withdraw
4. Balance Enquiry
5. Transaction History
6. Exit
Choose option: 4
Enter Account Number: 1
Account Holder: sagar
Current Balance: 101.0

--- Banking Management System ---
1. Create Account
2. Deposit
3. Withdraw
4. Balance Enquiry
5. Transaction History
6. Exit
Choose option: 4
Enter Account Number: 2
Account Holder: sagar maharathi
Current Balance: 200000.0

--- Banking Management System ---
1. Create Account
2. Deposit
3. Withdraw
4. Balance Enquiry
5. Transaction History
6. Exit
Choose option: 2
Enter Account Number: 1
Enter Amount to Deposit: 30
Deposit Successful

--- Banking Management System ---
1. Create Account
2. Deposit
3. Withdraw
4. Balance Enquiry
5. Transaction History
6. Exit
Choose option: 4
Enter Account Number: 1
Account Holder: sagar
Current Balance: 131.0

--- Banking Management System ---
1. Create Account
2. Deposit
3. Withdraw
4. Balance Enquiry
5. Transaction History
6. Exit
Choose option:
```
## 🚀 Future Enhancements

* User login & PIN
* GUI using Swing / JavaFX
* Transaction rollback
* Spring Boot version

---

