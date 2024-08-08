ESCUELA POLITECNICA NACIONAL <br>
PROGRAMACION ORIENTADA A OBJETOS <br>
Nombre: Richard Padilla <br>
Fecha: 6/8/2024 <br>
PROYECTO FINAL DE POO - GESTION DE CANCHAS <br>

-- INFORME --  <br>

A) Detallar cada parte del programa mediante capturas.

LOGIN

1.-La primera parte de la codificación de este programa tiene lo que es iniciar sesión o registrarse conectándose a mi base de datos reservaCanchas donde se almacenara loa datos ingresados por el cliente.

![image](https://github.com/user-attachments/assets/0e726f90-7a8e-4e63-ba35-32bab253637a)

2. - Mediante una tabla de sql tipo_rol y usuario podrá verificar si existe el cliente o no por lo que tendrá que registrarse y guardarse en la base de datos.

![image](https://github.com/user-attachments/assets/d6422cc2-ffd7-474c-aa12-ecd9bed331c6)

3.-Y finalmente por un if-else dependiendo el tipo de rol con el cual se ha registrado al cliente podrá ingresar a una de las interfaces de tipo_rol y poder cumplir con su función en el sistema.

![image](https://github.com/user-attachments/assets/4b9bb870-1b8c-46bc-acbb-ec60e8056b13)


REGISTRO

1.- En la parte de registrarse tiene lo que es objetos validados como nombre, apellido, email, contraseña, cedula y modo que serán de utilidad más adelante en la codificación con los otros tipos de roles.

![image](https://github.com/user-attachments/assets/8ace378a-1f73-4d81-af3b-b640a1d2bd89)

2.- Tambien se crea una tabla de MySQL llamada usuarios donde se guardarán estos parámetros automáticamente y/o podre consultar o seleccionar el parámetro que quiero modificar o agregar para poder iniciar sesión una vez que se halla registrado y guardado en la tabla usuarios. 

3.- Y por último mediante un  int rowsAffected = pstmt.executeUpdate();, me dirá si se modificó o agrego algún tipo de parámetro en este caso si completo el registro de manera correcta por la cual se activará dos condiciones de si ubo un registro exitoso o un error de registro.

![image](https://github.com/user-attachments/assets/3144e6e0-2860-4a9b-97ec-ef3b213481d9)


CLASES DE USUSARIO

1.- Esta clase de usuarios fue la que utilice para validar en toda la parte de login y se me haga un poco mas sencillo a la hora de hacer objetos y luego invocarlos. Esta clase tiene constructor, setters y getters que luego facilito poder utilizar en la parte de registro y login

![image](https://github.com/user-attachments/assets/fda2d23a-4225-4a15-b292-624a35d1f42c)

ADMINISTRADOR

1.- En la parte de Admin, solo tiene la interfaz de menu que tendrá para cumplir su funcion como rol Administrador, tecnicamente tiene Jbuttons que les enviara mediante un JFrame a la interfaz debida donde podran desarrollar la funcionalidad destinada del button, en este caso consta con tres tipos: Agregar clientes, canchas y horarios.

2.-LO que es AdmisFrame.dipose();,me sirve para poder cerrar la venta actual cuando vaya a otra interfaz de administrador.

![image](https://github.com/user-attachments/assets/b2e40aa5-5209-4d85-aacf-98ad411bb70e)

AGREGAR JUGADOR
1.- Linea 38: Tiene un constructor para inicializar los JFrame que se utilizaran para poder invocar la interfaz de agregar cliente en la parte de administrador, se usa para cambiar de pantalla a otra y que la anterior se cierre.
2.- Tambien tenemos un JComboBox que me permite agregar varias opciones en un cuadro para poder seleccionar utilizando addItem, en este caso con las opciones de: Jugador y Encargado.

![image](https://github.com/user-attachments/assets/49547260-b7ee-43fd-b1c0-e50a83f3f54d)

3.- Después tenemos objetos validados que son necesarios para la creación de la tabla agregar jugadores en MySQL que son los mismo que en la tabla de usuarios, pero agregado teléfono y tipo Rol.

![image](https://github.com/user-attachments/assets/c3e7d82f-4bd5-4674-95cf-4312984b8792)

4.- Después tenemos la parte de conectar a la base de datos donde pido que se inserte (INSERT) a mi tabla los parametros ya mencionados y tambien medinate un int rowsAffected = pstmt.executeUpdate();, me de dos condiciones de éxito o error de agregar jugador.

![image](https://github.com/user-attachments/assets/3a697641-55b3-447a-a2d8-a6036f1ecabe)

5.-  Después tenemos objetos validados que son necesarios para la creación de la tabla agregar jugadores en MySQL que son los mismo que en la tabla de usuarios, pero agregado teléfono y tipo Rol.
6.- Después tenemos la parte de conectar a la base de datos donde pido que se inserte (INSERT) a mi tabla los parametros ya mencionados y tambien medinate un int consultar = pstmt.executeUpdate();, me de dos condiciones de éxito o error de agregar jugador.
7.- Después tenemos la parte de buscar jugador utilizando los objetos de cedula, le pido que me consulte en mi base de datos y me retorne con select * from los datos que estoy pidiendo con el parámetro ingresado y me imprima, y al igual contiene restricción de si encontró o no al jugador.
8.- Y por último el de eliminar jugador mediante un método de DELETE ingresando el parámetro de cedula para que me consulte y me borre los datos de mi tabla.

![image](https://github.com/user-attachments/assets/2d961f40-4a3a-46aa-aaa7-de0ec4d5bc33)

![image](https://github.com/user-attachments/assets/09e5316e-ae53-41ce-af9e-890b95c1abd8)

![image](https://github.com/user-attachments/assets/3bcccd93-c1c5-42aa-9d82-08eeabd2f3b2)

AGREGAR HORARIOS

1.- En parte el administrador podrá agregar horarios a los jugadores para que puedan luego reservar y confirmar su cancha, en este caso se utilizó objetos fecha y tipo_cancha para poder hacer el registro.
2.- Utilizando un formato de fecha DD/MM/YY le pido al usuario que debe ingresar la fecha con este formato y que a la hora de imprimir el dato le retorne el formato, pero en viceversa mediante una condición de fecha con formato que se requiere.

![image](https://github.com/user-attachments/assets/677ceaf1-1cb4-4236-a8e0-729603031a1f)

3.- En esta sección consta con lo mismo del Jugador, pero ahora con horarios. Podrá agregar, eliminar y buscar utilizando los parámetros de MySQL para consultar como: SELECT * FROM, DELET Y INSERT con los parámetros de fecha y tipo de cancha y dependiendo el método que quiera pues le imprimirá o eliminará en la tabla o en el programa.

![image](https://github.com/user-attachments/assets/7cf02321-e1c7-4579-a4d0-49b5d1fa43c3)

![image](https://github.com/user-attachments/assets/de319753-56f0-48d8-8b0b-a00e5be62694)

![image](https://github.com/user-attachments/assets/d7e7ad5e-c563-4260-8add-438c79741396)

AGREGAR CANCHAS

1.- En la parte de button regresar tengo lo que es una condición de ventanas, donde pido de que FrameAdmin si está disponible pero no visible me retorne la ventana de administrador mediante el permiso True, que es lo que me permitira ver la ventana de agregar canchas pero que la ventana admin se cierre.

![image](https://github.com/user-attachments/assets/1e6d475c-50d9-4e3b-8ef0-1e6499590979)

2.- Luego tenemos la misma estructura de agregar, eliminar y buscar en este caso las canchas con objetos validados como: facultad, cedula, tipo Cancha, ubicación, capacidad. Esta es una nueva tabla llamada canchas y dependiendo el método que pedira que me consulte en mi MySQL y me retorne o modifique con las condiciones debidas que cada una tiene, como es la misma estructura que las anteriores solo cambia los objetos y el nombre de la tabla.

![image](https://github.com/user-attachments/assets/fb870f24-0652-4f75-b5ba-9f5c53297c28)

![image](https://github.com/user-attachments/assets/4e645a7d-0b5e-42cf-ad40-252e7d9f9939)

3.- La parte de int consultar = pstmt.executeUpdate();, pues como mencione sirve para optener mis validaciones a la hora de buscar un dato en mi tabla de MySQL medinate un if-else donde me retornara de que sis existe el dato que quiero modificar o ver me dira un mensaje con la condicion de exito con la funcion pero sino me dira un mensaje de algun tipo de error o dato no encontrado.

![image](https://github.com/user-attachments/assets/bdd6225d-56dd-4b14-aaa0-049ca767ecdd)


























