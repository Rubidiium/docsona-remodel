//BUILD 2.0.0

public class Clear{
    public static void clear(){  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}