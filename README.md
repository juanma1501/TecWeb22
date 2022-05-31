# Minijuegos Tec22
>Trabajo de prácticas de la asignatura __Tecnologías y Sistemas Web__. Implementación de una aplicación web (cliente-servidor) que ofrece a los usuarios la posibilidad de jugar a dos juegos __Tres en raya__ y __Piedra, papel o tijera__.


## Tecnologías utilizadas 🛠

- HTML5, CSS3, Javascript
- Bootstrap 4
- JQuery
- KnockoutJS
- Spring
- MySQL
- Selenium y JUnit para pruebas funcionales.
- JMeter para pruebas de rendimiento

---

## Funcionalidades implementadas 📋

### Gestión de cuentas

#### Identificación y registro mediante redes sociales
Hemos incluido el inicio de sesión mediante Google utilizando el protocolo OAuth.

<p align="center">
<img src="/screenshots/cuentas/login.png" width="700" > 
</p>

#### Registro
Un usuario nuevo se puede dar de alta rellenando el siguiente formulario, después se le enviará un correo de confirmación para validar la cuenta.

<p align="center">
<img src="/screenshots/cuentas/registro.PNG" width="700" > 
</p>

#### Recuperación de contraseña
La recuperación de contraseña la hemos implementado mediante el envío al correo electrónico del usuario un link con un token con fecha de caducidad.

<p align="center">
<img src="/screenshots/cuentas/restablecer.PNG" width="700" > 

<p align="center">
<img src="/screenshots/cuentas/restablecer2.PNG" width="700">
</p>



### Partidas

#### Unirse a una partida
Un usuario puede entrar logueado o no, si se loguea, se mostrarán sus estadísticas y se actualizarán. Una vez en el menú de juegos se puede optar por jugar a los dos juegos en modalidad ONLINE o contra la CPU

<p align="center">
<img src="/screenshots/juegos/menujuegos.PNG" width="700">
</p>

#### Chat
Todos los usuarios estarán conectados mediante un chat de texto que se activará al comenzar una partida

<p align="center">
<img src="/screenshots/juegos/chat.PNG" width="700">
</p>

#### Ejemplo de partida Tres en Raya
Ejemplo de juego

<p align="center">
<img src="/screenshots/juegos/partida.PNG" width="700">
</p>

#### Abandono
Por último, un jugador puede rendirse en cualquier momento y la partida se le da por perdida.

<p align="center">
<img src="/screenshots/juegos/perdedor.PNG" width="700">
</p>

---
## Alerts personalizados ⚙️
Todo el sistema de juegos cuenta con notificaciones personalizadas que variarán en color:
Verde (para exito), Rojo(para errores) y Azul para notificaciones

<p align="center">
<img src="/screenshots/juegos/rojo.PNG" width="700">
</p>

<p align="center">
<img src="/screenshots/juegos/verde.PNG" width="700">
</p>

<p align="center">
<img src="/screenshots/juegos/azul.PNG" width="700">
</p>

---
## Autores ✒️

* **Juan Manuel Porrero Almansa** - [Click para ir a mi página personal](https://juanmanuelpa.com)
* **Alonso Díaz Sobrino** - [Click para ir a mi página personal](https://alonsodiazsobrino.com)

## Sobre este trabajo ℹ️
<p align="center">
<img src="/screenshots/juegos/about.PNG" width="700">
</p>
