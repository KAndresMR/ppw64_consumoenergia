
### **Flujo de Trabajo General**

1. **Interacción del Usuario:**
   - El usuario accede a la página `index.xhtml`.
   - Ingresa el número de cédula y hace clic en el botón "Consultar".

2. **Proceso de Consulta:**
   - El **Managed Bean** (`ConsultaBean`) maneja la entrada del usuario.
   - `ConsultaBean` invoca el **EJB** (`UsuarioService`) para recuperar la información del usuario y sus datos de consumo y deuda.

3. **Acceso a Datos:**
   - `UsuarioService` interactúa con las entidades JPA (`Usuario` y `ConsumoDeuda`) para obtener los datos necesarios.
   - Los datos se recuperan de la base de datos a través del **EntityManager**.

4. **Actualización de la Vista:**
   - `ConsultaBean` almacena los resultados obtenidos en sus atributos (`usuario` y `consumoDeudas`).
   - La vista (`index.xhtml`) se actualiza para mostrar los datos recuperados en una tabla.

### **Descripción Detallada de Cada Componente**

#### **1. Clase `Usuario`:**
   - **Propósito:** Representa una entidad en la base de datos que almacena la información de un usuario.
   - **Atributos:** `id`, `nombre`, `apellido`, `cedula`, `consumoEnergia`, `deudaPendiente`, etc.
   - **Métodos:** Los métodos getter y setter permiten acceder y modificar los atributos de la entidad.

#### **2. Clase `ConsumoDeuda`:**
   - **Propósito:** Representa una entidad en la base de datos que almacena información sobre el consumo y la deuda de un usuario.
   - **Atributos:** `id`, `consumo`, `deuda`, `usuario` (relación con la entidad `Usuario`), etc.
   - **Métodos:** Los métodos getter y setter permiten acceder y modificar los atributos de la entidad.

#### **3. Clase `UsuarioService`:**
   - **Propósito:** Contiene la lógica de negocio para acceder a los datos de `Usuario` y `ConsumoDeuda`.
   - **Métodos:**
     - **`getUsuarioPorCedula(String cedula)`**: Busca y retorna un objeto `Usuario` basado en el número de cédula.
       - **Flujo:** Utiliza el `EntityManager` para realizar una consulta JPQL o SQL que recupera el usuario correspondiente.
     - **`getConsumoDeudaPorCedula(String cedula)`**: Busca y retorna una lista de objetos `ConsumoDeuda` para el usuario con la cédula dada.
       - **Flujo:** Utiliza el `EntityManager` para realizar una consulta que recupera los datos de consumo y deuda asociados con el usuario.

#### **4. Clase `ConsultaBean`:**
   - **Propósito:** Actúa como controlador para la página JSF, gestionando la interacción entre la vista y la lógica de negocio.
   - **Atributos:**
     - **`cedula`**: Almacena el número de cédula ingresado por el usuario.
     - **`usuario`**: Almacena el objeto `Usuario` recuperado por el servicio.
     - **`consumoDeudas`**: Almacena la lista de `ConsumoDeuda` recuperada por el servicio.
   - **Métodos:**
     - **`consultar()`**: Método que se llama cuando el usuario hace clic en el botón "Consultar".
       - **Flujo:** 
         - Invoca los métodos `UsuarioService` para obtener los datos del usuario y las deudas.
         - Actualiza los atributos `usuario` y `consumoDeudas` con los datos recuperados.

#### **5. Archivo `index.xhtml`:**
   - **Propósito:** Proporciona la interfaz de usuario donde el usuario ingresa la cédula y visualiza los resultados de la consulta.
   - **Elementos:**
     - **Campo de Texto:** Permite al usuario ingresar el número de cédula.
     - **Botón de Consulta:** Ejecuta el método `consultar()` del `ConsultaBean` al hacer clic.
     - **Tabla de Resultados:** Muestra la información del usuario y los datos de consumo y deuda en una tabla.

### **Flujo de Trabajo Completo**

1. **El usuario abre la página `index.xhtml`.**
2. **El usuario ingresa el número de cédula y hace clic en "Consultar".**
3. **JSF invoca el método `consultar()` en `ConsultaBean`.**
   - **`ConsultaBean` llama a `UsuarioService` para obtener el `Usuario` y la lista de `ConsumoDeuda`.**
4. **`UsuarioService` usa el `EntityManager` para recuperar los datos desde la base de datos.**
5. **`UsuarioService` retorna los datos a `ConsultaBean`.**
6. **`ConsultaBean` actualiza sus atributos (`usuario` y `consumoDeudas`).**
7. **La página `index.xhtml` se actualiza automáticamente con los datos recuperados y muestra la información del usuario y las deudas en la tabla.**

Este flujo asegura que los datos ingresados por el usuario sean procesados correctamente y que la vista se actualice con la información más reciente. Si tienes más preguntas o necesitas detalles adicionales, ¡avísame!
