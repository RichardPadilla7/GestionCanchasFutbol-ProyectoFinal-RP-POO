ESCUELA POLITECNICA NACIONAL <br>
PROGRAMACION ORIENTADA A OBJETOS <br>
Nombre: Richard Padilla <br>
Fecha: 6/8/2024 <br>
PROYECTO FINAL DE POO - GESTION DE CANCHAS <br>

-- INFORME --  <br>

A) Detallar cada parte del programa mediante capturas. <br>
B) Link del video: https://youtu.be/vMsl6-J5Fxc <br>

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

1.- En la parte de Admin, solo tiene la interfaz de menu que tendrá para cumplir su funcion como rol Administrador, tecnicamente tiene Jbuttons que les enviara mediante un JFrame a la interfaz debida donde podran desarrollar la funcionalidad destinada del button, en este caso consta con tres tipos: Agregar clientes, canchas y horarios. <br>

2.-LO que es AdmisFrame.dipose();,me sirve para poder cerrar la venta actual cuando vaya a otra interfaz de administrador.

![image](https://github.com/user-attachments/assets/b2e40aa5-5209-4d85-aacf-98ad411bb70e)

AGREGAR JUGADOR
1.- Linea 38: Tiene un constructor para inicializar los JFrame que se utilizaran para poder invocar la interfaz de agregar cliente en la parte de administrador, se usa para cambiar de pantalla a otra y que la anterior se cierre. <br>
2.- Tambien tenemos un JComboBox que me permite agregar varias opciones en un cuadro para poder seleccionar utilizando addItem, en este caso con las opciones de: Jugador y Encargado.

![image](https://github.com/user-attachments/assets/49547260-b7ee-43fd-b1c0-e50a83f3f54d)

3.- Después tenemos objetos validados que son necesarios para la creación de la tabla agregar jugadores en MySQL que son los mismo que en la tabla de usuarios, pero agregado teléfono y tipo Rol.

![image](https://github.com/user-attachments/assets/c3e7d82f-4bd5-4674-95cf-4312984b8792)

4.- Después tenemos la parte de conectar a la base de datos donde pido que se inserte (INSERT) a mi tabla los parametros ya mencionados y tambien medinate un int rowsAffected = pstmt.executeUpdate();, me de dos condiciones de éxito o error de agregar jugador.

![image](https://github.com/user-attachments/assets/3a697641-55b3-447a-a2d8-a6036f1ecabe)

5.-  Después tenemos objetos validados que son necesarios para la creación de la tabla agregar jugadores en MySQL que son los mismo que en la tabla de usuarios, pero agregado teléfono y tipo Rol. <br>
6.- Después tenemos la parte de conectar a la base de datos donde pido que se inserte (INSERT) a mi tabla los parametros ya mencionados y tambien medinate un int consultar = pstmt.executeUpdate();, me de dos condiciones de éxito o error de agregar jugador. <br>
7.- Después tenemos la parte de buscar jugador utilizando los objetos de cedula, le pido que me consulte en mi base de datos y me retorne con select * from los datos que estoy pidiendo con el parámetro ingresado y me imprima, y al igual contiene restricción de si encontró o no al jugador. <br>
8.- Y por último el de eliminar jugador mediante un método de DELETE ingresando el parámetro de cedula para que me consulte y me borre los datos de mi tabla. <br>

![image](https://github.com/user-attachments/assets/2d961f40-4a3a-46aa-aaa7-de0ec4d5bc33)

![image](https://github.com/user-attachments/assets/09e5316e-ae53-41ce-af9e-890b95c1abd8)

![image](https://github.com/user-attachments/assets/3bcccd93-c1c5-42aa-9d82-08eeabd2f3b2)

AGREGAR HORARIOS

1.- En parte el administrador podrá agregar horarios a los jugadores para que puedan luego reservar y confirmar su cancha, en este caso se utilizó objetos fecha y tipo_cancha para poder hacer el registro. <br>
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

JUGADOR

1.- En la ventana de Jugador lo que tiene es simplemente el menu que tendra el jugador para poder dar funcionalidad como el rol que es, en este caso consta con tres buttons que son: Reservar Canchas, Detalles Canchas y Cancelar Reservas

![image](https://github.com/user-attachments/assets/4d43ab0a-410d-4e50-993f-0f4a52910dd6)

![image](https://github.com/user-attachments/assets/106cde3b-7fb9-435a-a37e-9d9d5645ae64)

![image](https://github.com/user-attachments/assets/fb30f0b8-c481-43a1-83ac-fd765e50e025)

RESERVAR CANCHAS

1.- La funcionalidad que tendra es solo poder registrar su reserva de cancha donde se le ofrecera 4 tipos de canchas: cemento, tierra, cesped y sintetico mediante un JComboBox. <br>

2.- Despues Tendremos el boton confirmar reserva donde los objetos validados seran: cedula, fecha, hora de inicio y hora de fin y tipo de cancha  donde String tipoCancha = (String) TipoReservaCanchasBox.getSelectedItem();, me dira que los 4 items de tipos de canchas me tome como objetos String directamente para los 4 items.

![image](https://github.com/user-attachments/assets/cc80f834-24e5-47f0-98a0-1fa210414f85)

3.- E n esta parte tengo la validacion de la entrada que quiere decir que obligatoriamente el jugador debe llenar los campos para poder completar y registrar su reserva mediante un if con la condicion de completar los campos y si es cierto estos parametross me returne Por favor, complete todos los campos. <br>

![image](https://github.com/user-attachments/assets/836fcb7b-fe4e-45f9-a1af-4566637b18ba)

4.- Aqui tambien tengo el mismo formato de fecha para poder registrar la reserva y tambien tengo la parte de conectar a mi tabla llamada reservar_cancha pero ademas de esto dentro de este coneccion a mi MySQL, tengo un tipo verificador donde pido a mi tabla que antes de registrar mi reserva con el tipo de cancha, primero me busque sisque el encargado en la tabla llamada estado existe algun inpedimento en ese tipo de cancha. <br>

![image](https://github.com/user-attachments/assets/6208d7bc-f181-4b2e-9fe4-456343d0967d)

5.- La tabla estado tendra los parametros de: disponible, mantenimiento y cerrada. <br>

![image](https://github.com/user-attachments/assets/20599821-d18e-4fcb-ad48-e22acea3c688)

6.- Y sisque no existe algun inpedimento pues me permita registrar mi reserva en la tabla reservar_canchas ty en mi tabala horarios. <br>

![image](https://github.com/user-attachments/assets/5d207747-dcc0-4026-b096-efaa5e793c68)

7.- Y por ultimo dentro de mi reservar canchas y horario, tengo una estructura de validacion donde pido sisque existe algun horario en esa misma fecha ingresa recientemente me salga un mensaje de horario ya reservad y dentro de ese mismo una vez conectada a mi base reservar canchas y alla pasado la validacion de horarios me salga otra validacion de un registro exitoso o no con la reserva. <br>

![image](https://github.com/user-attachments/assets/06f40b24-9921-4f41-ad2d-00bdd6a85c29)

DETALLES CANCHAS

1.- Para la parte de detallar otras canchas utilice librerias para poder luego estructurar una parte de cargar imagenes con URL, en este caso librerias como: import java.net.URL;, import javax.imageio.ImageIO;, import java.io.IOException; <br>

![image](https://github.com/user-attachments/assets/7685a50f-7419-4756-aa32-343b125a264e)

2.- Tambien tengo una funcion donde configuro el poder mostrar mi URL en mi JLabel mendiante un mostrarURL.setHorizontalAlignment(SwingConstants.CENTER);, donde se mostrar de manera horizontal mi URL en un JLabel. <br>

3.- Despues tengo mi objeto validado: tipoCancha, solo utilice uno porque me base solo en que escogiendo el tipo de cancha le salga la informacion de las reservas ya realizadas para esa cancha. <br>

![image](https://github.com/user-attachments/assets/a11e58e6-cea3-49c7-b7ad-9a643d796ada)

4.- Aqui poderver que tengo StringBuilder detalles = new StringBuilder();, que me permite crear y modificar cadenas de texto con la ayuda de append que me sirvc para poder añadir texto a mi TextArea

![image](https://github.com/user-attachments/assets/f3d2056c-902d-491c-8926-344955f29b99)


5.- Luego tengo  mostrarDetallesCanchas.setText(detalles.toString());, que esi TextArea donde se mostraran los datos de detalles o de mi cadena de texto. <br>
6.- Despues tengo mi estructura para poder mostrar mi URL en mi JLabel. Basicamente me estoy basando en los tipos de canchas, cada cancha tiene su URL y por lo tanto utilice un switch. <br>

![image](https://github.com/user-attachments/assets/98e9b05a-2651-4b4e-b69b-9312f8a8f417)

7.- Luego tengo la estructura de poder agregar y mostrar mi imagen URL, en este caso tiene la estructura de:  <br>
URL urlImagen = new URL(imagenURL); //Crea una URl desde la cadena de texto imagenURL. >br>
ImageIcon imagen = new ImageIcon(ImageIO.read(urlImagen)); //Lee la imagen y la convierte en una imagenIncono que luego se imprime en la pantalla. <br>

Tamaño de la imagen. <br>
getScaledInstance tiene el parametro de Image.SCALE_SMOOTH que da el tipo de interpolación que se debe usar para dar el tamaño de una imagen. <br>

Image imgEscalada = imagen.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH); <br>
mostrarURL.setIcon(new ImageIcon(imgEscalada)); <br>


![image](https://github.com/user-attachments/assets/0cb287ea-6ca6-4571-a9a3-91335e9b6804)

CANCELAR RESERVA

1.- Esta parte de cancelar reserva pues es algo sencillo ya que solo debo conectar ami tabla reservar_canchas y mediante el metodo DELETE decirle que me borre la reserva por el parametroa buscar cedula y tipo cancha obviamente con las vaidaciones de sisque existe los parametros hara la funcion de borrar y si no pues no hara nada y le dira que ingrese datos primero. <br>


![image](https://github.com/user-attachments/assets/13386963-724b-47a8-b7db-4d98db2057ff)

ENCARGADO

1.- Pues al igual que la parte de Jugador y Administrador tiene un menu donde el Encargado podra dar funcionalidad a su rol con los botones: Visualizar, Actualizar y controlar el acceso. <br>

![image](https://github.com/user-attachments/assets/03aeb31b-7d3d-45dc-a74c-d27158236768)


VER REGISTRO

1.- Tiene la misma estructura de consultar ami base de datos y dependiendo el metodo (INSERTE, DELETE O SELECT * FROM) me imprima medinate mi cadena de texto y por medio de append me imprima los detalles de las reservas hasta el momento. Al encargado lo tome como tambien otro tipo de administrador pero este solo tiene la funcion de supervisar estas reservas y dar autorizacion en las canchas, tecnicamente es el responsable de las canchas.  <br>

![image](https://github.com/user-attachments/assets/86b53d2a-c76d-4780-8e47-96dc85f008f0)

![image](https://github.com/user-attachments/assets/faec805d-a345-476e-b771-33eae3b72f35)

![image](https://github.com/user-attachments/assets/b10adb41-1ee7-40ca-93d3-5459f2fb5e49)

ACTUALIZAR CANCHA

1.- Aqui ahora tuve que utilizar dos JComboBox para tipo cancha y estado ya que en esta venta del encargado solo debera seleccionar uno cada Jcombobox para luego poder registrar el estado de la cancha.  <br>

![image](https://github.com/user-attachments/assets/9da42516-9a78-416f-9bdc-e38bb248534e)

2.- Para este caso de detalles cancha tuve que usar otro metodo a las que utilice en las demas, basicamente tuve que crear funciones llamadas actualizar, quitar y mostrar estado de la cancha donde gracias a esto pude hacer mostrar que si existe el registro de algun estado en alguna cancha al reservar me salga la advertencia de estado de la cancha y obligatoriamente seleccionar otra cancha. <br>

3.- Lo que hago tambien es crear mis objetos ya validados y luego crear mis metodos de invocacion donde los parametros deberan ser tipo cancha y estado de la cancha que se guardaran en mi base de datos.

![image](https://github.com/user-attachments/assets/dde9aa0b-280a-42eb-b979-cebd01d01d95)

4.- Y aqui tengo mis funciones donde estaran conectadas a mi tabla de MySQL y podran consultar y agregar el estado de la cancha en mi tabla de datos yua registrados.

![image](https://github.com/user-attachments/assets/c25c522b-6e79-44c1-bc64-c3df4d6f3a37)

5.- Y por utlimo tenemos mi funcion de eliminar que es la misma estruyctura donde solo le pido que me consute ami MySQL por medio de PreparedStatement pstmt = conn.prepareStatement(query)) en mi tabla de base de datos con parametros    String query = "DELETE FROM estado WHERE tipo_cancha = ?";

![image](https://github.com/user-attachments/assets/41e4253c-54d5-48d4-bbac-991db7fd3b8f)














































