ESCUELA POLITECNICA NACIONAL
PROGRAMACION ORIENTADA A OBJETOS
Nombre: Richard Padilla
Fecha: 6/8/2024
PROYECTO FINAL DE POO - GESTION DE CANCHAS

-- INFORME -- 

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







