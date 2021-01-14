# hacka-ccr-backend

Projeto backend da equipe 145 do Hackathon CCR 2021

Equipe:

- matheussesh
- juliafaial
- luissofiste
- carlosdev404
- rayssasanches
- wmacibnc

## Instalação

1. Baixe o Eclipse, conforme o seu sistema operacional: https://www.eclipse.org/downloads/ 

  

2. Baixe o Java 11, conforme o seu sistema operacional: https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html


  
3. Baixe o Maven: https://maven.apache.org/download.cgi
  
  
  
	3.1 Baixe o apache-maven-***.bin.zip  
	
	3.2 Extrai e coloque na pasta C://maven  
	
	3.3 Adicione ao path a C://maven/bin  
	
	 
4. Baixe o projeto: https://github.com/wmacibnc/hacka-ccr-backend.git

5. Execute o maven 'clean install' pelo eclipse ou via terminal: mvn clean install


## Executando o projeto:

1. Execute o método main da classe: 'com.hacka.ccr.CcrApplication'  


2. Acesse o endereço: http://localhost:8080


## Desenvolvendo a API

### Controller

As requisições REST são recebidas pelo controlador(controller) anotadas com a anotação @Controller e @RequestMapping("/url") onde definimos que a classe é um controlador e qual é a url base de acesso.

```
@Controller
@RequestMapping(value = "/pessoa")
```

Sobre o método é preciso compor o restante da Uri. Utilizamos a mesma @RequestMapping("/uriMetodo"), informamos o tipo do método HTTP que será permitido e o formato do retorno(json, xml, txt, entre outros).

```
@RequestMapping(method = RequestMethod.GET, value = "/obter/{numeroPessoa}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Pessoa obter(@PathVariable(value = "numeroPessoa") Long numeroPessoa) throws CcrException {
		return service.obter(numeroPessoa);
	}
```

*Os métodos HTTP são:*    


- GET:  Requisita um representação do recurso especificado;

- HEAD:  Retorna os cabeçalhos de uma resposta (sem o corpo contendo o recurso);

- POST:  Envia uma entidade e requisita que o servidor aceita-a como subordinada do recurso identificado pela URI;

- PUT:  Requisita que um entidade seja armazenada embaixo da URI fornecida. Se a URI se refere a um recurso que já existe, ele é modificado; se a URI não aponta para um recurso existente, então o servidor pode criar o recurso com essa URI;

- DELETE:  Apaga o recurso especificado;

- TRACE:  Ecoa de volta a requisição recebida para que o cliente veja se houveram mudanças e adições feitas por servidores intermediários;

- OPTIONS:  Retorna os métodos HTTP que o servidor suporta para a URL especificada;

- CONNECT:  Converte a requisição de conexão para um túnel TCP/IP transparente, usualmente para facilitar comunicação criptografada com SSL (HTTPS) através de um proxy HTTP não criptografado;

- PATCH:  Usado para aplicar modificações parciais a um recurso.
 
 
Na classe controlador não deve existir lógica de negócio. A lógica de negócio deve ser tratada na classe de serviço que efetuará uma chamada para a classe de persistência.

```
	@Autowired
	private PessoaService service;
```

### Serviço

A classe de serviço mantém persistência com a base de dados por meio dos repositórios(repository) e também se relaciona com as outras classes de serviços.

```
@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;
	
```

### Camada de persistência

E uma interface da entidade que estende da interface CrudRepository do projeto Spring Data. Permitindo efetuar consultas com anotações e convenções.

```
public interface PessoaRepository extends CrudRepository<Pessoa, Long>{

}
```

