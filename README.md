# Práctica 7: Cliente - Servidor

## Descripción

En esta práctica vamos a establecer una conexión Socket Cliente/Servidor. Para ello, crearemos dos clases con el método `main`:

### Clase Servidor
Esta clase creará un `ServerSocket` para que un cliente, mediante un `Socket`, pueda conectarse y enviar datos. La clase realizará las siguientes acciones:
- Aceptar conexión con un cliente `Socket`.
- Leer los datos que envíe el cliente y mostrarlos por consola.
- Transformar los datos recibidos a mayúsculas y enviarlos al cliente.
- Mantener la comunicación hasta que el mensaje recibido por parte del cliente sea "salir".
- Cerrar la conexión y los buffers.

### Clase Cliente
Esta clase establecerá una conexión con el servidor a través de un `Socket` y permitirá la comunicación enviando y recibiendo mensajes.

## Objetivos

- Comprender el funcionamiento de la comunicación cliente-servidor mediante Sockets.
- Aprender a crear un servidor que acepte conexiones de clientes.
- Enviar y recibir datos entre un cliente y un servidor.
- Practicar el manejo de flujos de entrada y salida (streams).
- Aprender a cerrar conexiones y liberar recursos adecuadamente.

## Temas Trabajados

### 1. Entorno de Red
- Conceptos de conexión en redes y su implementación en Java.

### 2. Sockets
- Puntos de conexión para la comunicación bidireccional entre programas en una red.
- Implementación de `ServerSocket` en el servidor y `Socket` en el cliente.

### 3. Flujos de Entrada y Salida (Streams)
- Uso de `BufferedReader` y `PrintWriter` para la transmisión de datos.

### 4. Comunicación Cliente-Servidor
- Establecimiento de conexión y envío de mensajes entre ambas partes.
- Transformación de datos y respuesta del servidor.

### 5. Manejo de Conexiones
- Cierre adecuado de conexiones y liberación de recursos al finalizar la comunicación.

## Instrucciones

### Clase Servidor
1. Crear un `ServerSocket` en un puerto específico.
2. Aceptar la conexión de un cliente mediante `accept()`.
3. Leer los datos enviados por el cliente con `BufferedReader`.
4. Mostrar los datos recibidos en la consola.
5. Convertir los datos a mayúsculas y enviarlos de vuelta con `PrintWriter`.
6. Mantener la comunicación hasta recibir el mensaje "salir".
7. Cerrar la conexión y los buffers.

### Clase Cliente
1. Crear un `Socket` para conectarse al servidor.
2. Enviar mensajes al servidor con `PrintWriter`.
3. Leer las respuestas del servidor con `BufferedReader`.
4. Mostrar los mensajes recibidos en la consola.
5. Permitir al usuario ingresar mensajes para enviar al servidor.
6. Finalizar la comunicación al ingresar "salir".
7. Cerrar la conexión y los buffers.
