# 🔗 URL Shortener (Java Web Application)

## 📌 Overview

This project is a **URL Shortener Web Application** built using **Java Servlets, JSP, and Maven**.
It allows users to convert long URLs into short, shareable links and redirect them efficiently.

---

## 🚀 Features

* 🔗 Shorten long URLs instantly
* 🔁 Redirect short URLs to original links
* 📱 QR Code generation for shortened URLs
* 💾 Database integration for storing mappings
* 🌐 Simple and user-friendly interface

---

## 🛠️ Tech Stack

* **Backend:** Java Servlets
* **Frontend:** JSP, HTML, CSS
* **Build Tool:** Maven
* **Database:** MySQL (or any JDBC-supported DB)
* **Server:** Apache Tomcat

---

## 📂 Project Structure

```
url_shortener/
│── src/
│   ├── main/
│   │   ├── java/com/app/
│   │   │   ├── DBConnection.java
│   │   │   ├── ShortenServlet.java
│   │   │   ├── RedirectServlet.java
│   │   │   └── QRUtil.java
│   │   ├── webapp/
│   │   │   ├── index.jsp
│   │   │   ├── result.jsp
│   │   │   └── WEB-INF/web.xml
│── pom.xml
│── README.md
```

---

## ⚙️ Setup & Installation

### 1️⃣ Clone the repository

```bash
git clone https://github.com/Raghu162005/Url_Shortner.git
cd Url_Shortner
```

### 2️⃣ Configure Database

* Create a MySQL database
* Update credentials in `DBConnection.java`

Example:

```java
String url = "jdbc:mysql://localhost:3306/url_db";
String user = "root";
String password = "your_password";
```

---

### 3️⃣ Build the project

```bash
mvn clean install
```

---

### 4️⃣ Deploy on Tomcat

* Copy the generated `.war` file from `target/`
* Paste it into Tomcat’s `webapps/` folder
* Start Tomcat server

---

### 5️⃣ Run the application

Open browser:

```
http://localhost:8080/url-shortener/
```

---

## 🔮 Future Enhancements

* User authentication
* Analytics (click tracking)
* Custom short URLs
* API support

---

## 🤝 Contributing

Contributions are welcome! Feel free to fork the repo and submit pull requests.

---

## 📜 License

This project is open-source and available under the MIT License.

---

## 👨‍💻 Author

**Raghavendra Patne**
GitHub: https://github.com/Raghu162005
