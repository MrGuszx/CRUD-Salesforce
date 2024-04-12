package program;

import service.ViaCepService;
import java.io.IOException;
import model.Usuario;

public class TesteAPI {
	public static void main(String[] args)throws IOException {
	
	ViaCepService viacepservice = new ViaCepService();

    	try {
    		Usuario endereco = viacepservice.getEndereco("40254280");
             
	        System.out.println(endereco.getCep());
	        System.out.println(endereco.getLocalidade());
	        System.out.println(endereco.getUf());
	       
	    } catch (IOException e) {
	        e.printStackTrace();
	    }  
	}
}



