import java.util.*;
/**
 * 
 * 
 * @author Federico Diaz, Diego Pagani, Cristian Lopez 
 * @version 1.0.0
 */
public class Jugador
{
   private String nombre;
   private int edad;
   private int golestemporada;
   private int golespartido;
   private Equipo equipo;
   private boolean suspendido;
   
   public Jugador(){
       setNombre();
       setEdad();
       this.suspendido=false;
   }
   
   public String getNombre(){
       return this.nombre;
   }
   
   public int getEdad(){
       return this.edad;
   }
   
   public int getGolesXpartido(){
       return this.golespartido;
   }
   
   public int getGolesTemporada(){
       return this.golestemporada;
   }
   
   public boolean getSuspendido(){
       return this.suspendido;
   }
   
   public Equipo getEquipo(){
       return this.equipo;
   }
   
   public void setNombre(){
       Scanner sc= new Scanner(System.in);
       System.out.println("Ingrese nombre");
       String nombre=sc.nextLine();
       this.nombre=valNombre(nombre);    
   }
   
   public void setEquipo(Equipo equipo){
       this.equipo=equipo;
   }
   
   public void setEdad(){
       Scanner sc= new Scanner(System.in);
       System.out.println("Ingrese edad, solo se aceptan jugadores de 18 a 50 años");
       int edad=sc.nextInt();
       while(edad<18 || edad > 50){
           System.out.println("No se acepta la edad ingresada, ingrese nuevamente");
           edad=sc.nextInt();
       }
       this.edad=edad;
   }
   
   public void setGolesXpartido(int goles){
      Scanner sc= new Scanner(System.in);
      while(goles<0){
           System.out.println("Goles ingresados incorrectamente, ingrese nuevamente");
           goles=sc.nextInt();
      }
      this.golespartido=goles;
      setGolesTemporada(this.golespartido);
   }
   
   public void setGolesTemporada(int goles){
      this.golestemporada=this.golestemporada+goles;
   }
  
   public void setSuspendido(){
       Scanner sc= new Scanner(System.in);
       System.out.println("Si el jugador está suspendido ingrese 'S'. Si está habilitado ingrese 'N'");
       String suspen = sc.nextLine().toUpperCase().trim();
       while( !(suspen.equals("S")) && !(suspen.equals("N"))){
            System.out.println("Ingreso invalido. Vuelva a intentarlo.");
            suspen = sc.nextLine().toUpperCase().trim();
        }
       if(suspen.equals("S")){
           this.suspendido = true;
           System.out.println("El jugador ahora esta suspendido.");
        }
       else if (suspen.equals("N")){
           this.suspendido = false;
           System.out.println("El jugador ahora esta habilitado.");
        }
    }
    
   /**
       * Este metodo valida que el nombre ingresado sean todas letras
       * @param String a, es el nombre que se aprueba si tiene letras y solamente un espacio entre palabras.
       * @return nombre aprobado.
       */     
     private String valNombre(String a){
         boolean s= false;
         Scanner sc = new Scanner (System.in);
        while (s!=true){//recorre el string
            a = a.trim();//sin espacios por fuera
            a = a.toUpperCase();//pasado a mayusculas
            boolean val = valLetras(a);//Llamada a metodo
            if (val){
                System.out.println("Se guardo correctamente");
                s = true;
            }else{
                System.out.println("Solo debe ingresar letras y un espacio entre palabras, por favor ingreselo nuevamente");
                a=sc.nextLine();
            }
        }
        return a;
    }
   
   /**
         * Verifica si son todas letras y permite un espacio
         * Se utiliza para validar nombre
         * @param String a, es el que verifica que no contenga numeros ni signos.
         * @return true o false
         */
       private boolean valLetras(String a){
        int val=0;
        boolean x;
       if (a.length()!=0){
           for (int z=0;z<a.length();z++){
               Character p = a.charAt(z);
               char q= a.charAt(z);
               if((q==' ')&&(a.charAt(z-1)==' ')){
                     val=-1;
               }else{
                   if (p.isLetter(q)||q==' '){
                     
                     val = val + 1;
                    }
                }
           }           
       }else{
                val=-1;
       }
       if (val==a.length()){
        return x=true;
        }else{
        return x=false;
        }
    }
}
