package util;
//---CPF----TP
public final class CPF {

    private CPF () {
        
    }
    
    public static boolean ehValido(String cpf){
        if(cpf.length() < 11 || cpf.length()>11)
            return false;
        return true;
        
    }
}
