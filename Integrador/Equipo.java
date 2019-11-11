import java.util.*;
/**
 * crea equipos de 7 jugadores
 */

public class Equipo
{
    private String nombre;
    Jugador[] jugadores = new Jugador [7];
   public Equipo(){
      setNombre();     
   }
   
    public String getNombre(){
       return nombre;
   }
   
   public void setNombre(){
       Scanner sc= new Scanner(System.in);
       System.out.println("Ingrese nombre del equipo");
       String nombre=sc.nextLine();
       this.nombre=valNombre(nombre);    
   }    
   
   public Jugador getJugador(int i){
        return this.jugadores[i];
   }
   
   /**
   * Este metodo permite agregar un jugador al array
   * Si el jugador que se desea ingrear ya existe mostrara "El jugador que desea ingresar ya esta en el equipo"
   */
   public void agregarJugador(Jugador jugador){
        int i = elementoVacio();//llamada a metodo
        if (i!=-1){
            if (mismoJugador(jugador)){
                System.out.println("El jugador que desea ingresar ya esta en el equipo");
            }else{
                jugador.setEquipo(this);
                this.jugadores[i]=jugador;//guarda el nuevo jugador            
            }
        }else{
            System.out.println("No hay lugar para agregar un nuevo jugador");
        }
   }
   
   /**
     * Este metodo listara los jugadores por pantalla
     * Si el array no tiene elemento mostrara un mensaje que no hay jugadores
     */
   public void listarJugadores(){
        System.out.println("Jugadores del equipo:");
        int contnull=0,z=0;
        //contnull es un contador de nulls y z es para imprimir la posicion en pantalla del array correctamente
        for (int x = 0; x<7;x++){
            z=x+1;
            if (jugadores[x]==null){   
                contnull=contnull+1;
            }else{
                System.out.println("\t"+z+") " + jugadores[x].getNombre());
                //imprime el numero almacenado en z que es la pisicion en el array + 1 mas el telefono
            }
         }
        if (contnull==7){
            System.out.println("No existen jugadores en el equipo");
        }
   }
    
   public void eliminarJugador(){
       Scanner sc= new Scanner(System.in);
       listarJugadores();
       boolean val = false; //para salir del while cuando se cupla la condicion
       int contador=0;//para contar la cantidad de nulls que tiene el array
       for (int carray = 0; carray<7;carray++){
           if(jugadores[carray]==null){
               contador=contador+1;
           }
       }
       if(contador !=7){
              System.out.println("Ingrese la posicion del jugador que desea eliminar");
              int numero=sc.nextInt();
              numero=numero-1;
              //permite borrar la opcion elejida por el operador, se resta 1 ya que en pantalla se muestra el indice del array +1
              while (val==false){
                  if (numero>=0 && numero<=6){
                     if (jugadores[numero]==null){
                        System.out.println("Posicion ingresada incorrecta, ingresela nuevamente");
                        numero=sc.nextInt();
                        numero=numero-1;
                     }else{
                        this.jugadores[numero]=null;
                        System.out.println("Jugador eliminado.");
                        acomodador();
                        val=true;
                     }
                  }else{
                    System.out.println("Posicion ingresada incorrecta, ingresela nuevamente");
                    numero=sc.nextInt();
                    numero=numero-1;
                  }
              }
       }
   }
   
   private void acomodador(){
        int elemvac=elementoVacio();
        boolean z=false;
        int cont = 6;
        while(z!=true && cont>=0){
            if(this.jugadores[cont]!=null){
                this.jugadores[elemvac]=this.jugadores[cont];
                this.jugadores[cont]=null;
                z=true;
            }else{                
                cont = cont -1;
            }
        }
    }
  
   private boolean mismoJugador(Jugador jugador){
       int viji=0;
       for(int x = 0; x<7;x++){
               if(jugadores[x]==jugador){
                   viji=viji+1;
               }          
       }
       if(viji!=0){
           return true;
        }else{
           return false;
        }
   }
    
   private int elementoVacio(){
        int elemento=0,z=0;
        boolean x= false;
        while(x==false){
            if(z<7){
                if (jugadores[z]==null){
                     elemento = z;
                     x=true;
                }
            }else{
                elemento=-1;
                x=true;                
            }
            z=z+1;
        }
        return elemento;
   }  
  
   private String valNombre(String nombre){
      Scanner sc = new Scanner (System.in);
      boolean dir = false;      
      while (dir!=true){
            nombre=nombre.trim();//Saca espacios por fuera
            nombre=nombre.toUpperCase();//Pasa todo a mayus
            boolean val = valLetrasNumeros(nombre);//llamada a metodo
            if (val){
                System.out.println("Nombre guardado correctamente");
                dir=true;
            }else{
                System.out.println("Nombre ingresado incorrecto, Ingreselo nuevamente");
                nombre=sc.nextLine();
            }
        }
      return nombre;
   }
   
   private boolean valLetrasNumeros(String a){    
     int val=0;
       if (a.length()!=0){
           for (int z=0;z<a.length();z++){
           Character p = a.charAt(z);
           char q= a.charAt(z);   
           if((q==' ')&&(a.charAt(z-1)==' ')){
               val=-1;
           }else{
               if ((p.isLetterOrDigit(q))||(q==' ')){
                   val = val + 1;
               }
           }
           }            
     }else{
         val=-1;
     }     
     boolean x;
     if (val==a.length()){
        return x=true;
        }else{
        return x=false;
     }
  }
}
