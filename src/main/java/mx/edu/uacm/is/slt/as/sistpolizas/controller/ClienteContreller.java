package mx.edu.uacm.is.slt.as.sistpolizas.controller;

import mx.edu.uacm.is.slt.as.sistpolizas.httpClient.ClienteHttpClient;
import mx.edu.uacm.is.slt.as.sistpolizas.model.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ClienteContreller {
    
    @GetMapping("/")
    public String mostrar(Model model){
        model.addAttribute("curp", new String());
        return "view";
    }
    
    @PostMapping("/respuesta")
    public String respuesta(@RequestBody MultiValueMap<String,String> form, Model model) throws Exception{
        ClienteHttpClient client;
        client = new ClienteHttpClient("http://nachintoch.mx:8080/cliente");
        String curp = form.getFirst("curp");
        Cliente cliente =  client.getClienteByCurp(curp);

        model.addAttribute("cliente", cliente);
        return "respuesta";
   }
}

