/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.educastur.danielap62.biblioteca2025;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Daniel Alonso Perez
 */
public class Biblioteca2025 {

    private ArrayList <Libro> libros;
    
    private ArrayList <Usuario> usuarios;
    
    private ArrayList <Prestamo> prestamos;
    
    private ArrayList <Prestamo> prestamosHist;

    public Biblioteca2025() {
        this.libros = new ArrayList();
        this.usuarios = new ArrayList();
        this.prestamos = new ArrayList();
        this.prestamosHist = new ArrayList();  
    }
    
    
    
    public static void main(String[] args) {
        Biblioteca2025 b= new Biblioteca2025();
        b.cargaDatos();
        b.fueraPlazo();
        b.menu();
    }

    
    
    //<editor-fold defaultstate="collapsed" desc="MENUS">
    //Para crear estas carpetas utilizamos "fcom"
    public void menu(){
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("");
            System.out.println("BIBLIOTECA\n");
            System.out.println("1 - LIBROS");
            System.out.println("2 - USUARIOS");
            System.out.println("3 - PRESTAMOS");
            System.out.println("9 - Salir");
            opcion = sc.nextInt();
             
            switch(opcion){
                case 1:{
                    menuLibros();
                    break;
                }

                case 2:{
                    menuUsuarios();
                    break;
                }

                case 3:{
                    menuPrestamos();
                    break;
                }
            }
        }while(opcion != 9);
    }


    private void fork(){
        // Prueba de Forks dia 20/01/2025
    }
    private void menuLibros() {
      
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("");
            System.out.println("LIBROS\n");
            System.out.println("1 - NUEVO LIBRO");
            System.out.println("2 - ELIMINAR LIBRO");
            System.out.println("3 - MODIFICAR LIBRO");
            System.out.println("4 - LISTA DE LIBROS");
            System.out.println("9 - Salir");
            opcion = sc.nextInt();
             
            switch(opcion){
                case 1:{
                    nuevoLibro();
                    break;
                }

                case 2:{
                    eliminarLibro();
                    break;
                }

                case 3:{
                    modificarLibro();
                    break;
                }

                case 4:{
                    listaLibros();
                    break;
                }
                
            }
        }while(opcion != 9);
    }  
    
    


    private void menuUsuarios() {
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("");
            System.out.println("USUARIOS\n");
            System.out.println("1 - NUEVO USUARIO");
            System.out.println("2 - ELIMINAR USUARIO");
            System.out.println("3 - MODIFICAR USUARIO");
            System.out.println("4 - LISTA DE USUARIOS");
            System.out.println("9 - Salir");
            opcion = sc.nextInt();
             
            switch(opcion){
                case 1:{
                    nuevoUsuario();
                    break;
                }

                case 2:{
                    eliminarUsuario();
                    break;
                }

                case 3:{
                    modificarUsuario();
                    break;
                }

                case 4:{
                    listaUsuarios();
                    break;
                }
            }
        }while(opcion != 9);
    }
    
    private void menuPrestamos() {
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("");
            System.out.println("PRESTAMOS\n");
            System.out.println("1 - NUEVO PRESTAMO");
            System.out.println("2 - DEVOLVER PRESTAMO");
            System.out.println("3 - MODIFICAR PRESTAMO");
            System.out.println("4 - LISTA DE PRESTAMOS");
            System.out.println("5 - LISTA PREST. USUARIO EN ESPECIFICO");
            System.out.println("6 - LISTA PREST. LIBRO EN ESPECIFICO");
            System.out.println("7 - LIBRO MAS PRESTADO");
            System.out.println("8 - USUARIO MAS LECTOR");
            System.out.println("9 - Salir");
            opcion = sc.nextInt();
             
            switch(opcion){
                case 1:{
                    nuevoPrestamo();
                    break;
                }

                case 2:{
                    devolucion();
                    break;
                }

                case 3:{
                    modificarPrestamo();
                    break;
                }

                case 4:{
                    listaPrestamos();
                    break;
                }
                
                case 5:{
                    listaPrestamosUsu();
                    break;
                }
                
                case 6: {
                    listaPrestamosLibro();
                }
                
                case 7: {
                    libroMasPrestado();
                    break;
                }
                
                case 8: {
                    usuMasLector();
                    break;
                }
            }
        }while(opcion != 9);
    }
    //</editor-fold>
    
    
    //<editor-fold defaultstate="collapsed" desc="Gestion Libros">
        private void nuevoLibro() {
            Scanner sc = new Scanner(System.in);             
            System.out.println("Creemos un nuevo Libro:");
            System.out.println("ISBN: ");
            String Isbn = sc.nextLine();
            System.out.println("Titulo: ");
            String titulo = sc.nextLine();
            System.out.println("Autor: ");
            String autor = sc.nextLine();
            System.out.println("Genero: ");
            String genero = sc.nextLine();
            
            String unidadesSt;
            do{
                System.out.println("¿Cuantos ejemplares tenemos?");
                unidadesSt = sc.next();
            }while(!MetodosAux.esInt(unidadesSt));
                int unidades=Integer.parseInt(unidadesSt);
                libros.add(new Libro(Isbn, titulo, autor, genero, unidades));
        }

        private void eliminarLibro() {
            Scanner sc= new Scanner(System.in);
            System.out.println("Que libro quieres elmininar?");
            int pos;
            String Isbn = solicitaIsbn();
            pos = buscaIsbn(Isbn);
            if(pos==-1){
                System.out.println("El ISBN introducido es incorrecto");
                
            }else{
                System.out.println("El libro '" + libros.get(pos).getTitulo() + "' ha sido eliminado correctamente.");
                libros.remove(pos);
                  
            }
        }

        private void modificarLibro() {
            Scanner sc = new Scanner(System.in);
            int pos;
            do{
            System.out.println("Introduce el Isbn del libro que quieras modificar");
            String isbn = sc.nextLine();
            pos = buscaIsbn(isbn);
            if(pos == -1){
                System.out.println("El Isbn introducide no existe. Aqui tienes una lista de los que si existen y su libro correspondiente:");
                
                for (int i = 0; i < libros.size(); i++) {
                            System.out.println("- " + libros.get(i).getIsbn() + " " + libros.get(i).getTitulo());
                    
                        }

                
            }else{
                System.out.println("Que quieres modificar?");
            
                int cierre = 0;
                
                do{
                    System.out.println("1 - Genero");
                    System.out.println("2 - Ejemplares");
                    System.out.println("9 - Cancelar");
                    cierre = sc.nextInt();
                    sc.nextLine();


                    switch(cierre){
                        case 1:{
                            System.out.println("Genero nuevo: ");
                            libros.get(pos).setGenero(sc.nextLine());
                            System.out.println("Genero cambiado con exito");
                            break;
                        }

                        case 2:{
                            System.out.println("Cuantos ejemplares?");
                            libros.get(pos).setEjemplares(sc.nextInt());
                            System.out.println("Ejemplares cambiados con exito");
                            break;
                        }
                    }
                }while(cierre !=9);
            }
        }while(pos == -1);
        }
        

        private void listaLibros() {
            System.out.println("Lista de prestamos activos");
            for (int i = 0; i < libros.size(); i++) {
                if(libros.get(i).getEjemplares()>= 1){
                    System.out.println("- " + libros.get(i));
                }
                
            }
        }
    //</editor-fold>
    
        
    //<editor-fold defaultstate="collapsed" desc="Gestion Usuarios">  
    private void nuevoUsuario() {
        Scanner sc = new Scanner(System.in);             
            System.out.println("Creemos un nuevo Libro:");
            System.out.println("DNI: ");
            String Dni = sc.nextLine();
            System.out.println("Nombre: ");
            String nombre = sc.nextLine();
            System.out.println("Email: ");
            String email = sc.nextLine();
            System.out.println("Telefono: ");
            String telefono = sc.nextLine();
            usuarios.add(new Usuario(Dni, nombre, email, telefono));
    }

    private void eliminarUsuario() {
        Scanner sc= new Scanner(System.in);
            System.out.println("Que Usuario quieres elmininar?");
            int pos;
            
            String dni = solicitaDni();
            pos = buscaDni(dni);
            if(pos==-1){
                System.out.println("El DNI introducido es incorrecto ");
                
            }else{
                System.out.println("El Usuario '" + usuarios.get(pos).getNombre() + "' ha sido eliminado correctamente.");
                usuarios.remove(pos);
                  
            }
        }
    

    private void modificarUsuario() {
        Scanner sc = new Scanner(System.in);
            int pos;
            do{
            System.out.println("Introduce el DNI del usuario que quieras modificar");
            String dni = sc.nextLine();
            pos = buscaDni(dni);
            if(pos == -1){
                System.out.println("El DNI introducide no existe. Aqui tienes una lista de los que si existen y su usuario correspondiente:");
                
                for (int i = 0; i < usuarios.size(); i++) {
                            System.out.println("- " + usuarios.get(i).getDni() + " " + usuarios.get(i).getNombre());
                    
                        }

                
            }else{
                System.out.println("Que quieres modificar?");
            
                int cierre = 0;
                
                do{
                    System.out.println("1 - Nombre");
                    System.out.println("2 - Email");
                    System.out.println("3 - Telefono");
                    System.out.println("9 - Cancelar");
                    cierre = sc.nextInt();
                    sc.nextLine();


                    switch(cierre){
                        case 1:{
                            System.out.println("Nombre nuevo: ");
                            usuarios.get(pos).setNombre(sc.nextLine());
                            System.out.println("Nombre cambiado con exito");
                            break;
                        }

                        case 2:{
                            System.out.println("Nuevo email: ");
                            usuarios.get(pos).setEmail(sc.nextLine());
                            System.out.println("Email cambiado con exito");
                            break;
                        }
                        
                        case 3:{
                            System.out.println("Nuevo Telefono: ");
                            usuarios.get(pos).setTelefono(sc.nextLine());
                            System.out.println("Telefono cambiado con exito");
                            break;
                        }
                    }
                }while(cierre !=9);
            }
        }while(pos == -1);
        }
    

    private void listaUsuarios() {
        for (Usuario u: usuarios) {
            System.out.println(u);
        }
    }
    //</editor-fold>
    
    
    //<editor-fold defaultstate="collapsed" desc="Gestion Prestamos">
    

    /**
     * Metodo para crear un nuevo prestamo, no pide nada ya que el propio metodo llama a otros para pedirlo.
     */
    private void nuevoPrestamo() {
        System.out.println("Identificacion del usuario:");
        String dni = solicitaDni();
        int posUsuario = buscaDni(dni);
        
        
        
        if (posUsuario==-1){
            System.out.println("No es socio de la Biblioteca");
        }else{
            
            String isbn=solicitaIsbn();
            
            try{
              int posLibro=stockLibro(isbn);
              LocalDate hoy=LocalDate.now();
                prestamos.add(new Prestamo(libros.get(posLibro),usuarios.get(posUsuario),hoy,hoy.plusDays(15)));
                libros.get(posLibro).setEjemplares(libros.get(posLibro).getEjemplares()-1);
            }catch (LibroNoExiste | LibroNoDisponible ex){
                System.out.println(ex.getMessage());
            }
            /* Version antes de las exceptions:
            int posLibro=buscaIsbn(solicitaIsbn());
            if(posLibro==-1){
            System.out.println("El ISBN no pertenece a un libro existente en nuestro Catalogo. \n Lo sentimos");
            }else if(libros.get(posLibro).getEjemplares()>0){
            LocalDate hoy=LocalDate.now();
            prestamos.add(new Prestamo(libros.get(posLibro),usuarios.get(posUsuario),hoy,hoy.plusDays(15)));
            libros.get(posLibro).setEjemplares(libros.get(posLibro).getEjemplares()-1);
            }else{
            System.out.println("No quedan unidades de este");
            }*/ 
        }
    }

    /**
     * Metodo para devolver un libro, añadiendo el prestamo a los historicos y quitandolo de los activos.
     */
    private void devolucion() {
        System.out.println("Datos para la devolucion del préstamo:");
        String isbnLibro=solicitaIsbn();
        int pos=encuentraPrestamo(solicitaDni(),isbnLibro);
        if (pos==-1){
            System.out.println("No hay ningún préstamo con esos datos");
        }else{
            prestamos.get(pos).setFechaDev(LocalDate.now());
            libros.get(buscaIsbn(isbnLibro))
              .setEjemplares(libros.get(buscaIsbn(isbnLibro)).getEjemplares()+1);
            prestamosHist.add(prestamos.get(pos));
            prestamos.remove(pos);
        }
    }

    /**
     * Metodo para modificar el prestamo. Solo permite cambiar la fecha de devolucion.
     */
    private void modificarPrestamo() {
        Scanner sc= new Scanner (System.in);   
        int pos;
        String Isbn = solicitaIsbn();
        buscaDni(Isbn);
            
        String Dni = solicitaDni();
        buscaDni(Dni);
            
        pos = encuentraPrestamo(Dni, Isbn);
        if(pos==-1){
             System.out.println("\nLos datos introducidos no eran correcots");
        }else{
            LocalDate dev=prestamos.get(pos).getFechaDev();
            System.out.println("Cuantos dias quieres añadir?");
            int dias = sc.nextInt();
            prestamos.get(pos).setFechaDev(dev.plusDays(dias));
            prestamos.get(pos).setFechaPrest(LocalDate.now());
            System.out.println("Has añadido " + dias + " con exito");
        }   
    }
    
    
    /**
     * Metodo que nos da una lista de todos los prestamos, tanto los que estan activos como los que ya se devolvieron.
     */
    private void listaPrestamos() {
        System.out.println("\nLista de prestamos activos:");
        for (Prestamo p: prestamos) {
            if(p.getFechaPrest().isBefore(LocalDate.now())){
                    System.out.print("Libro fuera de plazo:\t");
                }
            System.out.println(p);
            
        }
        System.out.println("\nLista de prestamos devueltos");
        for (Prestamo p : prestamosHist) {
            System.out.println(p);
        }
           
    }
    
    
    /**
     * Metodo que nos da una lista detallada de los prestamos que un usuario tiene activo o que tuvo en su momento.
     */
    private void listaPrestamosUsu() {
        String dni = solicitaDni();
        int pos=buscaDni(dni);
        if(pos==-1){
            System.out.println("Ese dni no corresponde a ningun usuario.");
            
        }
        
        else{
            
        System.out.println("Prestamos activos de: " + usuarios.get(pos).getNombre());
        for (Prestamo p : prestamos) {
            if(p.getUsuarioPrest().getDni().equals(dni)){
                if(p.getFechaPrest().isBefore(LocalDate.now())){
                    System.out.print("Libro fuera de plazo:\t");
                }
                System.out.println(p);
            }
        }
        
        System.out.println("Prestamos historicos de: " + usuarios.get(pos).getNombre());
        for (Prestamo p : prestamosHist) {
            if(p.getUsuarioPrest().getDni().equals(dni)){
                System.out.println(p);
            }
        }
        }
        
    }
    
        /**
         * Metodo que nos da una lista detallada de los usuuarios que o bien estan leyendo este libro o ya lo han leido.
         */
        private void listaPrestamosLibro(){
        String isbn=solicitaIsbn();
        int pos=buscaIsbn(isbn);
        if (pos==-1){
             System.out.println("No tengo ningún libro con ese ISBN");
        }else{
            System.out.println("Usuarios/as que lo estan leyendo");
            for (Prestamo p : prestamos) {
                if (p.getLibroPrest().getIsbn().equals(isbn)){
                    System.out.println(p.getUsuarioPrest());
                }
            }
            
            System.out.println("Usuarios/as que ya lo han leido");
            for (Prestamo p : prestamosHist) {
                if (p.getLibroPrest().getIsbn().equals(isbn)){
                    System.out.println(p.getUsuarioPrest());
                }
            }
        }
    }
        
        
    
        private void libroMasPrestado (){
            ArrayList <Integer> contadorLibros = new ArrayList();
            for (Libro l : libros) {
                int cont = 0;
                for (Prestamo p : prestamos) {
                    if (l == p.getLibroPrest())
                        cont++;
                }
                
                for (Prestamo p : prestamosHist) {
                    if (l == p.getLibroPrest())
                        cont++;
                }
                
                contadorLibros.add(cont);
            }
            
            int mayor = 0;
            for (int i = 1; i < contadorLibros.size(); i++) {
                if(contadorLibros.get(i) > mayor){
                    mayor = contadorLibros.get(i);
                }
                
            }
            System.out.println("El Libro/s mas leido/s son: ");
            for (int i = 0; i < contadorLibros.size(); i++) {
                if(contadorLibros.get(i) == mayor){
                    System.out.println("\t- " + libros.get(i).getTitulo());
                }
                
            }
        }
        
        /**
         * Metodo que busca los usuarios que mas libros han cogido y da una lista con ellos.
         */
        private void usuMasLector (){
            ArrayList <Integer> contadorUsu = new ArrayList();
            for (Usuario u : usuarios) {
                int cont = 0;
                for (Prestamo p : prestamos) {
                    if (u == p.getUsuarioPrest())
                        cont++;
                }
                
                for (Prestamo p : prestamosHist) {
                    if (u == p.getUsuarioPrest())
                        cont++;
                }
                
                contadorUsu.add(cont);
            }
            
            int mayor = 0;
            for (int i = 1; i < contadorUsu.size(); i++) {
                if(contadorUsu.get(i) > mayor){
                    mayor = contadorUsu.get(i);
                }
                
            }
            System.out.println("El Usuario/s mas lector/es es(son): ");
            for (int i = 0; i < contadorUsu.size(); i++) {
                if(contadorUsu.get(i) == mayor){
                    System.out.println("\t- " + usuarios.get(i).getNombre());
                }
                
            }
        }
    //</editor-fold>
    
    
    //<editor-fold defaultstate="collapsed" desc="Metodos Auxiliares">
    public void cargaDatos(){
        libros.add(new Libro("1-11","El Hobbit","JRR Tolkien","Aventuras",3)); 
        libros.add(new Libro("1-22","El Silmarillon","JRR Tolkien","Aventuras",3)); 
        libros.add(new Libro("1-33","El Medico","N. Gordon","Aventuras",4)); 
        libros.add(new Libro("1-44","Chaman","N. Gordon","Aventuras",3)); 
        libros.add(new Libro("1-55","Momo","M. Ende","Aventuras",2)); 
        libros.add(new Libro("1-66","Paraiso inhabitado","A.M.Matute","Aventuras",2)); 
        libros.add(new Libro("1-77","Olvidado Rey Gudu","A.M.Matute","Aventuras",2)); 
        libros.add(new Libro("1-88","El ultimo barco","D.Villar","Novela Negra",3)); 
        libros.add(new Libro("1-99","Ojos de agua","D.Villar","Novela Negra",2)); 

        usuarios.add(new Usuario("11","Ana","ana@email.com","621111111")); 
        usuarios.add(new Usuario("22","David","david@email.com","622222222")); 
        usuarios.add(new Usuario("33","Bea","bea@email.com","623333333")); 
        usuarios.add(new Usuario("44","Lucas","lucas@email.com","624444444")); 
        usuarios.add(new Usuario("55","Carlota","carlota@email.com","625555555")); 
        usuarios.add(new Usuario("66","Juan","juan@email.com","626666666"));
        
        LocalDate hoy= LocalDate.now();
        prestamos.add(new Prestamo(libros.get(2),usuarios.get(0), hoy.minusDays(20),hoy.minusDays(5)));
        prestamos.add(new Prestamo(libros.get(8),usuarios.get(2), hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(5),usuarios.get(4), hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(5),usuarios.get(0), hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(6),usuarios.get(2), hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(2),usuarios.get(1), hoy,hoy.plusDays(15)));
        
        prestamosHist.add(new Prestamo(libros.get(1), usuarios.get(3), hoy.minusDays(20),hoy.minusDays(10)));
    
        for (Libro l:libros) {
            System.out.println(l);
        }
        System.out.println("");
        for (Usuario u:usuarios) {
            System.out.println(u);
        }
        System.out.println("");
        for (Prestamo p:prestamos) {
            System.out.println(p);
        }
    }
    
    
            
        public int stockLibro (String isbn) throws LibroNoExiste, LibroNoDisponible{
            int pos=buscaIsbn(isbn);
            if (pos==-1){
                throw new LibroNoExiste ("No existe en esta biblioteca la referencia: " + isbn);
            }else if (libros.get(pos).getEjemplares() == 0){
                throw new LibroNoDisponible ("No hay unidades disponibles del libro con referencia: " + isbn);
            }else return pos;
            //Como es solo una instruccion hasta 1 ; (solo una instruccion) no es necesario que tenga corchetes ({}) 
        }
        
      
    
    
    /**
     * Metodo para buscar un DNI en un ArrayList, devuelve la posicion en este, si no le encuentra devuelve un -1
     * @param dni Recibe el DNI (String) a buscar
     * @return Devuelve la posicion (int) del DNI en el ArrayList, si no le encuentra devuelve un -1
     */
    public int buscaDni (String dni){
        int pos = -1;
        for (int i = 0; i<usuarios.size(); i++) {
                if(usuarios.get(i).getDni().equalsIgnoreCase(dni) ){
                    pos = i;
                    break;
                }
                
            }
        
        
        return pos;
    }
    
    /**
     * Metodo para buscar un ISBN en un ArrayList, devuelve la posicion en este, si no le encuentra devuelve un -1
     * @param isbn Recibe el Isbn (String) a buscar
     * @return Devulve la posicion (int) del DNI en el ArrayList, si no lo encuentra devuelve un -1
     */
    public int buscaIsbn (String isbn){
        int pos = -1;
        for (int i = 0; i<libros.size(); i++) {
                if(libros.get(i).getIsbn().equalsIgnoreCase(isbn) ){
                    pos = i;
                    break;
                }
                
            }
        
        
        return pos;
    }
    /**
     * Metodo que solicita un DNI. Pdte de validacion
     * @return (String) Devuelve el DNI introducido 
     */
    public String solicitaDni (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Teclea el dni del usuario: ");
        String dni=sc.next();
        return dni;
    }
    /**
     * Metodo que solicita un ISBN. Pdte de validacion
     * @return (String) Devuelve el ISBN introducido 
     */
    public String solicitaIsbn (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Teclea el isbn del libro: ");
        String isbn=sc.next();
        return isbn;
    }
    
    /**
     * Método para buscar un préstamo en la colección préstamos
     * @param dni (String) del usuario que realizó el préstamo
     * @param isbn (String) del libro prestado
     * @return posición (int) del préstamo en el Arraylist, 
     *         valor -1 si no se encuentra un préstamo con esos datos
     */
    public int encuentraPrestamo(String dni, String isbn){
        int pos=-1;
        for (int i = 0; i < prestamos.size(); i++) {
            if (prestamos.get(i).getUsuarioPrest().getDni().equals(dni)
                && prestamos.get(i).getLibroPrest().getIsbn().equals(isbn)){   
                pos=i;
                break;
            }
        }
        return pos;       
    }
    
    /**
     * Metodo que nos imprime los prestamos que estan fuera de plazo.
     */
    public void fueraPlazo(){
        System.out.println("Prestamos fuera de plazo:");
        for (Prestamo p : prestamos) {
            if (p.getFechaDev().isBefore(LocalDate.now())){
                    System.out.println(p);
            }
        }
    }
    //</editor-fold>

}
