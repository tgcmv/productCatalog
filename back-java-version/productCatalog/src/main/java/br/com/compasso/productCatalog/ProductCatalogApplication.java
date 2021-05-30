package br.com.compasso.productCatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
		  info = @Info(
				  title = "Product catalog",
				  version = "0.0.2",
				  description = "spring boot application 'product catalog' for job opportunity in compassouol (<a>https://compassouol.com</a>)",
				  contact = @Contact(
				    name = "Thiago Carvalho", 
				    url = "https://onovoprogramador.blogspot.com", 
				    email = "thiago.cmv@gmail.com"
				  ),
				  license = @License(
				    name = " GNU General Public License 3.0", 
				    url = "https://www.gnu.org/licenses/gpl-3.0.en.html")),
				  servers = @Server(url = "http://localhost:9999")
				)
@SpringBootApplication
public class ProductCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCatalogApplication.class, args);
	}

}
