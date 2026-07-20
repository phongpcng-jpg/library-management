﻿<div align="center">

# ☕ Java Assignment

### **IOC-Session08: Library Management**

</div>

---

### 📚 Course Information

|                 |                                                                    |
|-----------------|--------------------------------------------------------------------|
| **Institution** | RIKKEI EDUCATION                                                   |
| **Course**      | IOC - Java Web Services And Security                               |
| **Class**       | PTHB260316 - Java Backend                                          |
| **Session**     | Session08 - Exception Handling & File Upload                       |
| **Instructor**  | Pham Tuan Binh - Github: [tuan-binh](https://github.com/tuan-binh) |

---

### 🛠️ Project Structure

```text
com/example/library_management/
    │
    ├── 📦 configs/
    │   ├── ☁️ CloudinaryConfig.java
    │   └── 🔑 CloudinaryProperties.java
    │
    ├── 📦 exception/
    │   ├── 🛡️ GlobalExceptionHandler.java
    │   ├── 🚨 ResourceNotFoundException.java
    │   └── 🚨 UploadCloudinaryMessage.java
    │
    ├── 📦 message/
    │   ├── 🔒 BookMessage.java
    │   ├── 🔒 UploadCloudinaryMessage.java
    │   └── 🔒 CommonMessage.java
    │
    ├── 📦 utils/
    │   └── 📦 validations/
    │       ├── 📦 annotations/
    │       │   └── 🏷️ FileExtension.java
    │       └── 📦 handle/
    │           └── ✅ FileExtensionValidator.java
    │
    ├── 📦 models/
    │   ├── 📦 dtos/
    │   │   ├── 📦 wrapper/
    │   │   │   ├── 📨 ApiResponse.java
    │   │   │   └── 📄 PageResponse.java
    │   │   ├── 📦 response/
    │   │   │   └── 📋 ErrorResponse.java
    │   │   └── 📦 request/
    │   │       ├── 📋 BookUpdateStockDTO.java
    │   │       └── 📋 BookCreateDTO.java
    │   ├── 📦 entities/
    │   │   └── 💾 Book.java
    │   ├── 📦 repositories/
    │   │   └── 🟤 IBookRepository.java
    │   └── 📦 services/
    │       ├── 📦 uploads/
    │       │   └── 🟢 UploadService.java
    │       ├── 📦 impl/
    │       │   └── 🟢 BookServiceImpl.java
    │       └── 🟤 IBookService.java
    │
    ├── 📦 controller/
    │   └── 🟢 BookController.java
    │
    └── 🚀 LibraryManagementApplication.java

```


---

## 👨‍💻 Author

| |                                                                             |
|---|-----------------------------------------------------------------------------|
| **Full Name** | Nguyen Que Phong                                                            |
| **Email** | [nguyenquephong13062003@gmail.com](mailto:nguyenquephong13062003@gmail.com) |
| **Phone** | [0908130603](tel:+84908130603)                                              |

---

<div align="center">

**Made with ❤️ using Java**

</div>