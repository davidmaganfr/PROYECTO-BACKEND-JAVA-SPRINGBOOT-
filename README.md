# PROYECTO-BACKEND JAVA-SPRINGBOOT
Proyecto elaborado con java y SpringBoot para una empresa de energías renovables que tiene la necesidad de recoger algunas mediciones meteorológicas. Se compone de una API REST que obtiene datos de una empresa llamada "Meteojava" en la que se almacenan registros meteorológicos diarios, la cual incorpora operaciones CRUD. 

Por otro lado, una aplicación web "springrenovables" que trabaja desde el navegador para acceder a la API REST para consultar, agregar, modificar o eliminar datos. Esta aplicación, además, hace uso de un archivo JSON del cual obtiene una medición extra para dar el mejor servicio, de manera que se usa un patrón DTO para reunir el conjunto de mediciones que proviene de la API REST y del archivo JSON.

La aplicación web tiene un mecanismo de seguridad para que exclusivamente el administrador pueda realizar actualizaciones, borrados y agregación de datos, y el resto de usuarios simplemente pueda verlos.
