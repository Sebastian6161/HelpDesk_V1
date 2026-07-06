# 💻 HelpDeskPro v1

Sistema de Mesa de Ayuda desarrollado en **Java** utilizando **Programación Orientada a Objetos (POO)**, **Maven**, **JDBC** y **MySQL**.

Este proyecto simula un sistema básico de soporte técnico para la gestión de usuarios, equipos y tickets de incidencias.

---

## 🚀 Características

- Registro de usuarios
- Registro de equipos
- Creación de tickets de soporte
- Visualización de usuarios
- Visualización de equipos
- Visualización de tickets
- Cierre de tickets
- Persistencia de datos mediante MySQL
- Exportación de tickets a archivo CSV

---

## 🛠️ Tecnologías utilizadas

- Java 23
- Maven
- MySQL
- JDBC
- IntelliJ IDEA
- Git
- GitHub

---

## 📂 Estructura del proyecto

```
HelpDesk
│
├── src
│   └── main
│       └── java
│
│           ├── helpdesk
│           │      Main.java
│           │
│           ├── model
│           │      Usuario.java
│           │      Equipo.java
│           │      Ticket.java
│           │
│           ├── service
│           │      UsuarioService.java
│           │      UsuarioDBService.java
│           │      EquipoService.java
│           │      EquipoDBService.java
│           │      TicketService.java
│           │      TicketDBService.java
│           │
│           └── util
│                  ConexionBD.java
│                  ArchivoUtil.java
│
├── pom.xml
└── README.md
```

---

## 🗄️ Base de datos

El proyecto utiliza una base de datos MySQL llamada:

```
helpdesk_db
```

Tablas utilizadas:

- usuarios
- equipos
- tickets

---

## ▶️ Ejecución

1. Clonar el repositorio.
2. Crear la base de datos `helpdesk_db` en MySQL.
3. Ejecutar el script de creación de tablas.
4. Configurar el usuario y contraseña en `ConexionBD.java`.
5. Ejecutar el proyecto desde IntelliJ IDEA o mediante Maven.

---

## 📸 Funcionalidades

El sistema permite:

- Registrar usuarios.
- Registrar equipos.
- Crear tickets asociados a un usuario.
- Consultar información registrada.
- Guardar usuarios, equipos y tickets en MySQL.
- Exportar tickets a un archivo CSV.

---

## 📈 Próximas mejoras

- Arquitectura Repository Pattern.
- Eliminación del almacenamiento CSV.
- Lectura completa desde MySQL.
- Login de usuarios.
- Roles (Administrador / Técnico).
- Dashboard de estadísticas.
- Interfaz gráfica con JavaFX.

---

## 👨‍💻 Autor

**Sebastián Ignacio Ávila Sanhueza**

Estudiante de Analista Programador Computacional  
Duoc UC

---

## 📌 Estado del proyecto

✅ Versión 1.0 Finalizada

Este proyecto corresponde a la primera versión funcional del sistema **HelpDeskPro**. El desarrollo continuará en **HelpDeskPro v2**, incorporando una arquitectura más profesional basada en Repository Pattern, mejoras en la persistencia de datos y una futura interfaz gráfica.
