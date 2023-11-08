# grupoG
Proyecto de almacenamiento

1ro Entrar al workbech de MySql y conectar a la base de datos


En el SQL File pegar o arrastras el documento sql el cual contiene los DDL de nuestra base


Seleccionar y ejecutar el script, presionando el icono del Rayo el cual se visualiza en la captura pasada, terminamos esta sección de la base de datos.



(IDE), al ingresar a NetBeans vamos a abrir un proyecto, seleccionamos, File, Open Project, en el gestor de documentos seleccionaremos el proyecto AlmacenTia y procedemos a abrir el proyecto.


Es muy probable que el documento marque algún error pero es porque es probable que falte agregar el Connector, el cual sirve para conectar de MySql al proyecto, dentro de requerimientos se solicitaba el Connecto a lo cual se puede descargar desde la página oficial y se procederá a agregarlo a la librería del proyecto.
En el apartado libraries procederemos a darle click derecho y seleccionaremos (Add Jar/folder)



En el zip se encuentra el connector/j, a lo cual cuando se abra el gestor de archivos se procede a ir a la carpeta del Connector y seleccionar el .jar y agregarlo. (Con esto ya tenemos conexión a base de datos)

Ahora debemos configurar la conexión de base al proyecto, expandimos el Source Packages, Expandimos el Package de Modelo y nos dirigimos a ConexionBase.java



En este paso se debe colocar la clave con la que se configuró el MySql entre las comillas de la línea 13 
   String password = "123456789";  // Contraseña de la base de datos


Si todos los pasos fueron ejecutados correctamente, dentro del package Tia se encuentra la clase Main la cual al ejecutarla no debería marcar ningún error
