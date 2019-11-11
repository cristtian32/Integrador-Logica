import java.util.Scanner;
/**
 * Write a description of class Partido here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Partido
{
    private String arbitro;
    private Equipo equipo1;
    private Equipo equipo2;
    private int golesE1;
    private int golesE2;
    
    public Partido(Equipo equipo1, Equipo equipo2){
        if(equipo1!=equipo2){
            if( !(verificarHabilitacion(equipo1)) && !(verificarHabilitacion(equipo2)) ){
                System.out.println("Ninguno de los equipos se encuentran habilitados para jugar.");
            }else if( verificarHabilitacion(equipo1) ){
                if( verificarHabilitacion(equipo2) ){
                
                    this.equipo1 = equipo1;
                    this.equipo2 = equipo2;
                    setArbitro();
                }else
                    System.out.println("El equipo " +equipo2.getNombre()+ " no esta habilitado para jugar"); 
                }else{
                    System.out.println("El equipo " +equipo1.getNombre()+ " no esta habilitado para jugar");
                }
        }else{
            System.out.println("Los equipos que ingreso son los mismos");
        }
    }
    
    public String getArbitro(){
        return this.arbitro;
    }
    
    public Equipo getEquipo1(){
        return this.equipo1;
    }
    
    public Equipo getEquipo2(){
        return this.equipo2;
    }
    
    public int getGolesEquipo1(){
        return this.golesE1;
    }
    
    public int getGolesEquipo2(){
        return this.golesE2;
    }
        
    public void setGolesEquipo1(int goles){
        if(goles>0){
            this.golesE1=goles;
            asignarGoles(goles,this.equipo1);
        }else{
            System.out.println("Cantidad de goles ingresada incorrecta");
        }
    }
    
    public void setGolesEquipo2(int goles){
        if(goles>0){
            this.golesE2=goles;
            asignarGoles(goles,this.equipo2);
        }else{
            System.out.println("Cantidad de goles ingresada incorrecta");
        }
    }
    
    
    private void asignarGoles(int goles,Equipo equipo){
            Scanner sc = new Scanner (System.in);
            equipo.listarJugadores();
            int x=0;
            boolean z=false;
            while(z!=true){
                System.out.println("Ingrese jugador que convirtio");
                int jugador=sc.nextInt()-1;
                System.out.println("Ingrese la cantidad de goles que realizo");
                int gol=sc.nextInt();
                x = x + gol;
                if (x<=goles){
                    equipo.getJugador(jugador).setGolesXpartido(gol);
                    if(x==goles){
                        equipo.getJugador(jugador).setGolesXpartido(gol);
                        z=true;
                    }
                }else{
                    System.out.println("La cantidad de goles que ingreso no concuerda");
                    x=x-gol;
                }
            }        
    }
    
    public void listarGoleadores(){
        System.out.println("Goles del partido");
        for(int x = 0 ; x<7;x++){
            if(equipo1.getJugador(x)!=null){
                if(equipo1.getJugador(x).getGolesXpartido()>0){
                    System.out.println(equipo1.getJugador(x).getNombre()+" "+equipo1.getJugador(x).getGolesXpartido());
                }
            }
            if(equipo2.getJugador(x)!=null){
                if(equipo2.getJugador(x).getGolesXpartido()>0){
                    System.out.println(equipo2.getJugador(x).getNombre()+" "+equipo2.getJugador(x).getGolesXpartido());
                }
            }            
        }   
    }
    
    public void setArbitro(){
        Scanner sc = new Scanner (System.in);
        System.out.println("Ingrese el nombre del arbitro: ");
        String nombre=sc.nextLine();
        this.arbitro=valNombre(nombre);
        System.out.println("Arbitro guardado correctamente");
    }
    
    public void finalDelPartido(){
        System.out.println("\t\tFINAL DEL PARTIDO");
        if(golesE1>golesE2){
            System.out.print(equipo1.getNombre()+" "+this.golesE1+" - "+this.golesE2+" "+equipo2.getNombre());
            System.out.println("Ganador: "+equipo1.getNombre());            
        }else if(golesE2>golesE1){
            System.out.print(equipo2.getNombre()+" "+this.golesE2+" - "+this.golesE1+" "+equipo1.getNombre());
            System.out.println("Ganador: "+equipo2.getNombre());
        }else{
            System.out.print(equipo1.getNombre()+" "+this.golesE1+" - "+this.golesE2+" "+equipo2.getNombre());
            System.out.println("Empate");
        }
        listarGoleadores();
        
    }
    
    private boolean verificarHabilitacion(Equipo equipo){
        int cantHab = 0;
        for( int i = 0; i < 7; i++ ){
            if( equipo.getJugador(i) != null ){
                    Jugador jugador = equipo.getJugador(i);
                if( !(jugador.getSuspendido()) )
                    cantHab++;
            }
        }
        if ( cantHab < 5 )
            return false;
        else
            return true;
    }
   
         
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
