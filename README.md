# hacka-ccr-backend

*URL do projeto backend:* 'https://floating-reef-30152.herokuapp.com/'

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


## Deploy

*Todos os comandos devem ser executados dentro da raiz do projeto.*
  
  
1. Efetue o merge do código da sua branch pra master;

```
git merge master
```
  
2. Efetue o commit na master

```
git checkout master
git push origin master
```
  
3. Efetue o login na sua conta Heroku, na pasta do projeto.

```
heroku login -i
```

*-i login via terminal*

    
4. Efetue o commit na branch do Heroku. Deploy já vai ser iniciado.

```
git push heroku HEAD:master
```

Se tudo ocorreu bem no log.  

Pronto! Deploy executado!


Url: https://floating-reef-30152.herokuapp.com/ 


## Scripts
### Banco de dados

-- Auto Declaração  

```
INSERT INTO public.auto_declaracao(id, nome) VALUES (1, 'branca');
INSERT INTO public.auto_declaracao(id, nome) VALUES (2, 'preta');
INSERT INTO public.auto_declaracao(id, nome) VALUES (3, 'parda');
INSERT INTO public.auto_declaracao(id, nome) VALUES (4, 'amarela');
INSERT INTO public.auto_declaracao(id, nome) VALUES (5, 'indígena');
```
     
-- Curso

```
INSERT INTO public.curso(id, nome, descricao, link) VALUES (1, 'Microsoft Office 365 - Conhecendo o Teams', 'O Office 365 é uma coleção de aplicativos da Microsoft que reúne as melhores ferramentas para as pessoas trabalharem de forma colaborativa e produtiva. Este curso é composto de sete vídeos, nos quais você aprenderá algumas funcionalidades da ferramenta Teams, para que possa trabalhar, de maneira eficiente, com uma plataforma de comunicação e colaboração no local de trabalho.','https://www.ev.org.br/cursos/microsoft-office-365-conhecendo-o-teams');
```
  
-- Estado Civil

```
INSERT INTO public.estado_civil(id, nome) VALUES (1, 'solteiro');
INSERT INTO public.estado_civil(id, nome) VALUES (2, 'casado');
INSERT INTO public.estado_civil(id, nome) VALUES (3, 'separado');
INSERT INTO public.estado_civil(id, nome) VALUES (4, 'divorciado');
INSERT INTO public.estado_civil(id, nome) VALUES (5, 'viúvo');
```


-- Formação Academica

```
insert into public.formacao_academica(id, nome) VALUES (1, 'Administração - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (2, 'Agronomia - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (3, 'Arqueologia - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (4, 'Arquitetura e Urbanismo - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (5, 'Artes Visuais - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (6, 'Artes Visuais - Licenciatura');
insert into public.formacao_academica(id, nome) VALUES (7, 'Biblioteconomia - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (8, 'Biomedicina - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (9, 'Ciência da Computação - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (10, 'Ciências Biológicas - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (11, 'Ciências Biológicas - Licenciatura');
insert into public.formacao_academica(id, nome) VALUES (12, 'Ciências Atuariais - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (13, 'Ciências Contábeis - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (14, 'Ciências Econômicas - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (15, 'Ciências Naturais - Licenciatura');
insert into public.formacao_academica(id, nome) VALUES (16, 'Ciências Sociais - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (17, 'Ciências Sociais - Licenciatura');
insert into public.formacao_academica(id, nome) VALUES (18, 'Cinema e Audiovisual - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (19, 'Dança - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (20, 'Dança - Licenciatura');
insert into public.formacao_academica(id, nome) VALUES (21, 'Design - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (22, 'Direito - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (23, 'Educação Física - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (24, 'Educação Física - Licenciatura');
insert into public.formacao_academica(id, nome) VALUES (25, 'Enfermagem - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (26, 'Engenharia Aeronáutica - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (27, 'Engenharia Agrícola - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (28, 'Engenharia Ambiental e Sanitária - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (29, 'Engenharia Cartográfica e de Agrimensura - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (30, 'Engenharia Civil - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (31, 'Engenharia de Alimentos - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (32, 'Engenharia de Bioprocessos - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (33, 'Engenharia de Computação - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (34, 'Engenharia de Controle e Automação - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (35, 'Engenharia de Fortificação e Construção - Bacharelado (oferta exclusiva das Forças Armadas)');
insert into public.formacao_academica(id, nome) VALUES (36, 'Engenharia de Materiais - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (37, 'Engenharia de Minas - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (38, 'Engenharia de Pesca - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (39, 'Engenharia de Petróleo - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (40, 'Engenharia de Produção - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (41, 'Engenharia de Telecomunicações - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (42, 'Engenharia Elétrica - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (43, 'Engenharia Eletrônica - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (44, 'Engenharia Florestal - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (45, 'Engenharia Mecânica - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (46, 'Engenharia Mecânica de Armamentos - Bacharelado (oferta exclusiva das Forças Armadas)');
insert into public.formacao_academica(id, nome) VALUES (47, 'Engenharia Mecânica de Veículos Militares - Bacharelado (oferta exclusiva das Forças Armadas)');
insert into public.formacao_academica(id, nome) VALUES (48, 'Engenharia Metalúrgica - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (49, 'Engenharia Naval - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (50, 'Engenharia Química - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (51, 'Engenharia Têxtil - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (52, 'Estatística - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (53, 'Farmácia - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (54, 'Filosofia - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (55, 'Filosofia - Licenciatura');
insert into public.formacao_academica(id, nome) VALUES (56, 'Física - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (57, 'Física - Licenciatura');
insert into public.formacao_academica(id, nome) VALUES (58, 'Fisioterapia - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (59, 'Fonoaudiologia - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (60, 'Geografia - Licenciatura');
insert into public.formacao_academica(id, nome) VALUES (61, 'Geografia - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (62, 'Geologia - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (63, 'História - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (64, 'História - Licenciatura');
insert into public.formacao_academica(id, nome) VALUES (65, 'Informática - Licenciatura');
insert into public.formacao_academica(id, nome) VALUES (66, 'Jornalismo - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (67, 'Letras - Língua Estrangeira - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (68, 'Letras - Língua Portuguesa - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (69, 'Letras - Língua Estrangeira - Licenciatura');
insert into public.formacao_academica(id, nome) VALUES (70, 'Letras - Língua Portuguesa - Licenciatura');
insert into public.formacao_academica(id, nome) VALUES (71, 'Matemática - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (72, 'Matemática - Licenciatura');
insert into public.formacao_academica(id, nome) VALUES (73, 'Medicina - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (74, 'Medicina Veterinária - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (75, 'Meteorologia - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (76, 'Museologia - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (77, 'Música - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (78, 'Música - Licenciatura');
insert into public.formacao_academica(id, nome) VALUES (79, 'Nutrição - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (80, 'Odontologia - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (81, 'Pedagogia - Licenciatura');
insert into public.formacao_academica(id, nome) VALUES (82, 'Psicologia - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (83, 'Publicidade e Propaganda - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (84, 'Química - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (85, 'Química - Licenciatura');
insert into public.formacao_academica(id, nome) VALUES (86, 'Radio, TV, Internet (Comunicação Audiovisual e Multimídia) - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (87, 'Relações Internacionais - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (88, 'Relações Públicas - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (89, 'Secretariado Executivo - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (90, 'Serviço Social - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (91, 'Sistemas da Informação - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (92, 'Teatro - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (93, 'Teatro - Licenciatura');
insert into public.formacao_academica(id, nome) VALUES (94, 'Teologia - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (95, 'Terapia Ocupacional - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (96, 'Turismo - Bacharelado');
insert into public.formacao_academica(id, nome) VALUES (97, 'Zootecnia - Bacharelado');
```
  
-- Genero

```
insert into public.genero(id, nome) VALUES(1, 'Masculino');
insert into public.genero(id, nome) VALUES(2, 'Feminino');
insert into public.genero(id, nome) VALUES(3, 'Outros');
insert into public.genero(id, nome) VALUES(4, 'Não binário');
insert into public.genero(id, nome) VALUES(5, 'Prefiro não dizer');
```
  
-- Idioma

```
insert into public.idioma(id, nome) VALUES(1, 'Inglês');
insert into public.idioma(id, nome) VALUES(2, 'Chinês');
insert into public.idioma(id, nome) VALUES(3, 'Hindi');
insert into public.idioma(id, nome) VALUES(4, 'Espanhol');
insert into public.idioma(id, nome) VALUES(5, 'Francês');
insert into public.idioma(id, nome) VALUES(6, 'Árabe');
insert into public.idioma(id, nome) VALUES(7, 'Bengali');
insert into public.idioma(id, nome) VALUES(8, 'Russo');
insert into public.idioma(id, nome) VALUES(9, 'Português');
insert into public.idioma(id, nome) VALUES(10, 'Indonésio');
```
  
-- Nacionalidade

```
insert into public.nacionalidade(id, nome) VALUES (1, 'Afeganistão');
insert into public.nacionalidade(id, nome) VALUES (2, 'África do Sul');
insert into public.nacionalidade(id, nome) VALUES (3, 'Albânia');
insert into public.nacionalidade(id, nome) VALUES (4, 'Alemanha');
insert into public.nacionalidade(id, nome) VALUES (5, 'Andorra');
insert into public.nacionalidade(id, nome) VALUES (6, 'Angola');
insert into public.nacionalidade(id, nome) VALUES (7, 'Antígua e Barbuda');
insert into public.nacionalidade(id, nome) VALUES (8, 'Arábia Saudita');
insert into public.nacionalidade(id, nome) VALUES (9, 'Argélia');
insert into public.nacionalidade(id, nome) VALUES (10, 'Argentina');
insert into public.nacionalidade(id, nome) VALUES (11, 'Armênia');
insert into public.nacionalidade(id, nome) VALUES (12, 'Austrália');
insert into public.nacionalidade(id, nome) VALUES (13, 'Áustria');
insert into public.nacionalidade(id, nome) VALUES (14, 'Azerbaidjão');
insert into public.nacionalidade(id, nome) VALUES (15, 'Bangladesh');
insert into public.nacionalidade(id, nome) VALUES (16, 'Barbados');
insert into public.nacionalidade(id, nome) VALUES (17, 'Belarus');
insert into public.nacionalidade(id, nome) VALUES (18, 'Belize');
insert into public.nacionalidade(id, nome) VALUES (19, 'Bolívia');
insert into public.nacionalidade(id, nome) VALUES (20, 'Bósnia-Herzegóvina');
insert into public.nacionalidade(id, nome) VALUES (21, 'Botsuana');
insert into public.nacionalidade(id, nome) VALUES (22, 'Brasil');
insert into public.nacionalidade(id, nome) VALUES (23, 'Brunei');
insert into public.nacionalidade(id, nome) VALUES (24, 'Bulgária');
insert into public.nacionalidade(id, nome) VALUES (25, 'Burundi');
insert into public.nacionalidade(id, nome) VALUES (26, 'Butão');
insert into public.nacionalidade(id, nome) VALUES (27, 'Cabo Verde');
insert into public.nacionalidade(id, nome) VALUES (28, 'Camarões');
insert into public.nacionalidade(id, nome) VALUES (29, 'Camboja');
insert into public.nacionalidade(id, nome) VALUES (30, 'Catar');
insert into public.nacionalidade(id, nome) VALUES (31, 'Chade');
insert into public.nacionalidade(id, nome) VALUES (32, 'Chile');
insert into public.nacionalidade(id, nome) VALUES (33, 'China');
insert into public.nacionalidade(id, nome) VALUES (34, 'Cingapura');
insert into public.nacionalidade(id, nome) VALUES (35, 'Colômbia');
insert into public.nacionalidade(id, nome) VALUES (36, 'Congo');
insert into public.nacionalidade(id, nome) VALUES (37, 'Coréia do Norte');
insert into public.nacionalidade(id, nome) VALUES (38, 'Coréia do Sul');
insert into public.nacionalidade(id, nome) VALUES (39, 'Costa Rica');
insert into public.nacionalidade(id, nome) VALUES (40, 'Cuba');
insert into public.nacionalidade(id, nome) VALUES (41, 'Dinamarca');
insert into public.nacionalidade(id, nome) VALUES (42, 'Djibuti');
insert into public.nacionalidade(id, nome) VALUES (43, 'Dominica');
insert into public.nacionalidade(id, nome) VALUES (44, 'Egito');
insert into public.nacionalidade(id, nome) VALUES (45, 'El Salvador');
insert into public.nacionalidade(id, nome) VALUES (46, 'Equador');
insert into public.nacionalidade(id, nome) VALUES (47, 'Eritreia');
insert into public.nacionalidade(id, nome) VALUES (48, 'Eslováquia');
insert into public.nacionalidade(id, nome) VALUES (49, 'Eslovênia');
insert into public.nacionalidade(id, nome) VALUES (50, 'Espanha');
insert into public.nacionalidade(id, nome) VALUES (51, 'Estados Unidos');
insert into public.nacionalidade(id, nome) VALUES (52, 'Estônia');
insert into public.nacionalidade(id, nome) VALUES (53, 'Federação Russa');
insert into public.nacionalidade(id, nome) VALUES (54, 'Fiji');
insert into public.nacionalidade(id, nome) VALUES (55, 'Filipinas');
insert into public.nacionalidade(id, nome) VALUES (56, 'Finlândia');
insert into public.nacionalidade(id, nome) VALUES (57, 'França');
insert into public.nacionalidade(id, nome) VALUES (58, 'Gabão');
insert into public.nacionalidade(id, nome) VALUES (59, 'Gâmbia');
insert into public.nacionalidade(id, nome) VALUES (60, 'Gana');
insert into public.nacionalidade(id, nome) VALUES (61, 'Geórgia');
insert into public.nacionalidade(id, nome) VALUES (62, 'Granada');
insert into public.nacionalidade(id, nome) VALUES (63, 'Grécia');
insert into public.nacionalidade(id, nome) VALUES (64, 'Guatemala');
insert into public.nacionalidade(id, nome) VALUES (65, 'Guiana');
insert into public.nacionalidade(id, nome) VALUES (66, 'Guiné-Equatorial');
insert into public.nacionalidade(id, nome) VALUES (67, 'Haiti');
insert into public.nacionalidade(id, nome) VALUES (68, 'Holanda');
insert into public.nacionalidade(id, nome) VALUES (69, 'Honduras');
insert into public.nacionalidade(id, nome) VALUES (70, 'Hungria');
insert into public.nacionalidade(id, nome) VALUES (71, 'Ilhas Marshall');
insert into public.nacionalidade(id, nome) VALUES (72, 'Ilhas Salomão');
insert into public.nacionalidade(id, nome) VALUES (73, 'Índia');
insert into public.nacionalidade(id, nome) VALUES (74, 'Indonésia');
insert into public.nacionalidade(id, nome) VALUES (75, 'Irã');
insert into public.nacionalidade(id, nome) VALUES (76, 'Iraque');
insert into public.nacionalidade(id, nome) VALUES (77, 'Irlanda');
insert into public.nacionalidade(id, nome) VALUES (78, 'Islândia');
insert into public.nacionalidade(id, nome) VALUES (79, 'Itália');
insert into public.nacionalidade(id, nome) VALUES (80, 'Jamaica');
insert into public.nacionalidade(id, nome) VALUES (81, 'Japão');
insert into public.nacionalidade(id, nome) VALUES (82, 'Jordânia');
insert into public.nacionalidade(id, nome) VALUES (83, 'Kiribati');
insert into public.nacionalidade(id, nome) VALUES (84, 'Kuwait');
insert into public.nacionalidade(id, nome) VALUES (85, 'Laos');
insert into public.nacionalidade(id, nome) VALUES (86, 'Lesoto');
insert into public.nacionalidade(id, nome) VALUES (87, 'Letônia');
insert into public.nacionalidade(id, nome) VALUES (88, 'Líbano');
insert into public.nacionalidade(id, nome) VALUES (89, 'Libéria');
insert into public.nacionalidade(id, nome) VALUES (90, 'Líbia');
insert into public.nacionalidade(id, nome) VALUES (91, 'Lituânia');
insert into public.nacionalidade(id, nome) VALUES (92, 'Luxemburgo');
insert into public.nacionalidade(id, nome) VALUES (93, 'Macedônia');
insert into public.nacionalidade(id, nome) VALUES (94, 'Malásia');
insert into public.nacionalidade(id, nome) VALUES (95, 'Malauí');
insert into public.nacionalidade(id, nome) VALUES (96, 'Maldivas');
insert into public.nacionalidade(id, nome) VALUES (97, 'Mali');
insert into public.nacionalidade(id, nome) VALUES (98, 'Malta');
insert into public.nacionalidade(id, nome) VALUES (99, 'Marrocos');
insert into public.nacionalidade(id, nome) VALUES (100, 'Maurício');
insert into public.nacionalidade(id, nome) VALUES (101, 'Mauritânia');
insert into public.nacionalidade(id, nome) VALUES (102, 'México');
insert into public.nacionalidade(id, nome) VALUES (103, 'Micronésia');
insert into public.nacionalidade(id, nome) VALUES (104, 'Moçambique');
insert into public.nacionalidade(id, nome) VALUES (105, 'Mianmar');
insert into public.nacionalidade(id, nome) VALUES (106, 'Moldávia');
insert into public.nacionalidade(id, nome) VALUES (107, 'Mônaco');
insert into public.nacionalidade(id, nome) VALUES (108, 'Montenegro');
insert into public.nacionalidade(id, nome) VALUES (109, 'Namíbia');
insert into public.nacionalidade(id, nome) VALUES (110, 'Nauru');
insert into public.nacionalidade(id, nome) VALUES (111, 'Nepal');
insert into public.nacionalidade(id, nome) VALUES (112, 'Níger');
insert into public.nacionalidade(id, nome) VALUES (113, 'Nigéria');
insert into public.nacionalidade(id, nome) VALUES (114, 'Noruega');
insert into public.nacionalidade(id, nome) VALUES (115, 'Nova Zelândia');
insert into public.nacionalidade(id, nome) VALUES (116, 'Panamá');
insert into public.nacionalidade(id, nome) VALUES (117, 'Papua Nova Guiné');
insert into public.nacionalidade(id, nome) VALUES (118, 'Paquistão');
insert into public.nacionalidade(id, nome) VALUES (119, 'Paraguai');
insert into public.nacionalidade(id, nome) VALUES (120, 'Peru');
insert into public.nacionalidade(id, nome) VALUES (121, 'Polônia');
insert into public.nacionalidade(id, nome) VALUES (122, 'Portugal');
insert into public.nacionalidade(id, nome) VALUES (123, 'Quênia');
insert into public.nacionalidade(id, nome) VALUES (124, 'Reino Unido');
insert into public.nacionalidade(id, nome) VALUES (125, 'República Centro-Africana');
insert into public.nacionalidade(id, nome) VALUES (126, 'República Dominicana');
insert into public.nacionalidade(id, nome) VALUES (127, 'República Tcheca');
insert into public.nacionalidade(id, nome) VALUES (128, 'Romênia');
insert into public.nacionalidade(id, nome) VALUES (129, 'Ruanda');
insert into public.nacionalidade(id, nome) VALUES (130, 'Samoa');
insert into public.nacionalidade(id, nome) VALUES (131, 'San Marino');
insert into public.nacionalidade(id, nome) VALUES (132, 'São Vicente e Granadinas');
insert into public.nacionalidade(id, nome) VALUES (133, 'Senegal');
insert into public.nacionalidade(id, nome) VALUES (134, 'Serra Leoa');
insert into public.nacionalidade(id, nome) VALUES (135, 'Sérvia');
insert into public.nacionalidade(id, nome) VALUES (136, 'Síria');
insert into public.nacionalidade(id, nome) VALUES (137, 'Sri Lanka');
insert into public.nacionalidade(id, nome) VALUES (138, 'Suazilândia');
insert into public.nacionalidade(id, nome) VALUES (139, 'Sudão');
insert into public.nacionalidade(id, nome) VALUES (140, 'Suécia');
insert into public.nacionalidade(id, nome) VALUES (141, 'Suíça');
insert into public.nacionalidade(id, nome) VALUES (142, 'Suriname');
insert into public.nacionalidade(id, nome) VALUES (143, 'Tailândia');
insert into public.nacionalidade(id, nome) VALUES (144, 'Tanzânia');
insert into public.nacionalidade(id, nome) VALUES (145, 'Togo');
insert into public.nacionalidade(id, nome) VALUES (146, 'Tonga');
insert into public.nacionalidade(id, nome) VALUES (147, 'Trinidad e Tobago');
insert into public.nacionalidade(id, nome) VALUES (148, 'Tunísia');
insert into public.nacionalidade(id, nome) VALUES (149, 'Turquia');
insert into public.nacionalidade(id, nome) VALUES (150, 'Turcomenistão');
insert into public.nacionalidade(id, nome) VALUES (151, 'Tuvalu');
insert into public.nacionalidade(id, nome) VALUES (152, 'Ucrânia');
insert into public.nacionalidade(id, nome) VALUES (153, 'Uruguai');
insert into public.nacionalidade(id, nome) VALUES (154, 'Venezuela');
insert into public.nacionalidade(id, nome) VALUES (155, 'Zâmbia');
insert into public.nacionalidade(id, nome) VALUES (156, 'Zimbábue');
```
  
-- Rede Social

```
insert into public.rede_social (id, nome) VALUES (1, 'LinkedIn');
insert into public.rede_social (id, nome) VALUES (2, 'Facebook');
insert into public.rede_social (id, nome) VALUES (3, 'YouTube');
insert into public.rede_social (id, nome) VALUES (4, 'Instagram');
insert into public.rede_social (id, nome) VALUES (5, 'Behance');
```

-- Interesse

```

insert into public.interesse(id, nome) VALUES(1, 'Viajar');
insert into public.interesse(id, nome) VALUES(2, 'Ter um canal no youtube');
insert into public.interesse(id, nome) VALUES(3, 'Jogar carta com amigos');
insert into public.interesse(id, nome) VALUES(4, 'Praticar artes marciais');
insert into public.interesse(id, nome) VALUES(5, 'Ser adepto as palavras cruzadas');
insert into public.interesse(id, nome) VALUES(6, 'Estar em contato com a natureza');
insert into public.interesse(id, nome) VALUES(7, 'Visitar museus');
insert into public.interesse(id, nome) VALUES(8, 'Ir ao cinemaIr ao cinema');
insert into public.interesse(id, nome) VALUES(9, 'Pescar');
insert into public.interesse(id, nome) VALUES(10, 'Ir ao estádio de futebol');
insert into public.interesse(id, nome) VALUES(11, 'Assistir peças de teatro');
insert into public.interesse(id, nome) VALUES(12, 'Fazer aulas de teatro');
insert into public.interesse(id, nome) VALUES(13, 'Ler livrosler livros');
insert into public.interesse(id, nome) VALUES(14, 'Dançar balé');
insert into public.interesse(id, nome) VALUES(15, 'Acampar com os amigos');
insert into public.interesse(id, nome) VALUES(16, 'Fazer trilhas');
insert into public.interesse(id, nome) VALUES(17, 'Participar de corridas');
insert into public.interesse(id, nome) VALUES(18, 'Desenhardesenhar');
insert into public.interesse(id, nome) VALUES(19, 'Escrever poesias');
insert into public.interesse(id, nome) VALUES(20, 'Ouvir músicas');
insert into public.interesse(id, nome) VALUES(21, 'Dedicar-se a um voluntariado');
insert into public.interesse(id, nome) VALUES(22, 'Estudar');
insert into public.interesse(id, nome) VALUES(23, 'Cuidar de plantas');
insert into public.interesse(id, nome) VALUES(24, 'Jogar tênis');
insert into public.interesse(id, nome) VALUES(25, 'Andar de skateandar de skate');
insert into public.interesse(id, nome) VALUES(26, 'Praticar yoga e meditação');
insert into public.interesse(id, nome) VALUES(27, 'Fazer um curso de idiomas');
insert into public.interesse(id, nome) VALUES(28, 'Fotografar');
insert into public.interesse(id, nome) VALUES(29, 'Escrever para um blog');
insert into public.interesse(id, nome) VALUES(30, 'Pedalarpedalar');
insert into public.interesse(id, nome) VALUES(31, 'Tocar um instrumento musical');
insert into public.interesse(id, nome) VALUES(32, 'Fazer artesanato');
insert into public.interesse(id, nome) VALUES(33, 'Planejar eventos');
insert into public.interesse(id, nome) VALUES(34, 'Cozinhar');
insert into public.interesse(id, nome) VALUES(35, 'Decorar ambientes');
insert into public.interesse(id, nome) VALUES(36, 'Assistir ao pôr ou o nascer do sol');
insert into public.interesse(id, nome) VALUES(37, 'Jogar vôleijogar vôlei');
insert into public.interesse(id, nome) VALUES(38, 'Surfar');
insert into public.interesse(id, nome) VALUES(39, 'Colecionar objetos');
insert into public.interesse(id, nome) VALUES(40, 'Fazer natação');
insert into public.interesse(id, nome) VALUES(41, 'Editar vídeo');
insert into public.interesse(id, nome) VALUES(42, 'Costurar e produzir os seus próprios looks');
insert into public.interesse(id, nome) VALUES(43, 'Escalar');
insert into public.interesse(id, nome) VALUES(44, 'Jogar futeboljogar futebol');
insert into public.interesse(id, nome) VALUES(45, 'Treinar musculação');
insert into public.interesse(id, nome) VALUES(46, 'Dançar');
insert into public.interesse(id, nome) VALUES(47, 'Ensinar');
insert into public.interesse(id, nome) VALUES(48, 'Maratonar séries');
insert into public.interesse(id, nome) VALUES(49, 'Jogar basquete');
insert into public.interesse(id, nome) VALUES(50, 'Empinar pipa');
```

--- Pergunta Boot

```
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (1, 'A', 'Frequentar cursos relacionados com a natureza.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (2, 'A', 'Praticar jardinagem ou atividade correlata, como cuidar de um orquidário ou colecionar bromélias.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (3, 'A', 'Fazer caminhadas.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (4, 'A', 'Trabalhar na preservação da flora e da fauna.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (5, 'A', 'Cuidar de plantas e animais, atuando como agente regional de agricultura, ou florestal.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (6, 'A', 'Participar de competições esportivas.');



insert into public.pergunta_boot(id, tipo, pergunta) VALUES (7, 'B', 'Participar de uma equipe marítima como encarregado(a) das máquinas.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (8, 'B', 'Trabalhar na torre de tráfego aéreo de um aerporto.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (9, 'B', 'Montar miniaturas de modelos de avião, carro ou navio.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (10, 'B', 'Atuar no controle e manutenção de uma usina elétrica.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (11, 'B', 'Construir maquetes.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (12, 'B', 'Trabalhar como instrutor(a) numa escola técnica profissional ou frequentar curso na mesma.');


insert into public.pergunta_boot(id, tipo, pergunta) VALUES (13, 'C', 'Frequentar curso de Pesquisa Matemática Pura e Aplicada.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (14, 'C', 'Trabalhar como calculista em atividade relacionada com engenharia.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (15, 'C', 'Cursar Engenharia.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (16, 'C', 'Frequentar cursos de Contabilidade.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (17, 'C', 'Ser Engenheiro(a) de computação.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (18, 'C', 'Dar aulas de Matemática.');

insert into public.pergunta_boot(id, tipo, pergunta) VALUES (19, 'D', 'Ser aviador.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (20, 'D', 'Frequentar curso na área de científica.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (21, 'D', 'Estudar a evolução tecnológica de veiculos automotores como automóveis, ou aviões.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (22, 'D', 'Trabalhar num setor ligado à Psicologia ou Psiquiatria.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (23, 'D', 'Ler livros e revistas sobre ficção científica.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (24, 'D', 'Ser membro de uma equipe de centro médico cirúrgico.');

insert into public.pergunta_boot(id, tipo, pergunta) VALUES (25, 'E', 'Frequentar cursos na área de Direito.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (26, 'E', 'Estruturar e dirigir o departamento de compras e vendas de uma empresa.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (27, 'E', 'Trabalhar como entrevistador no setor de seleção de pessoal de uma empresa.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (28, 'E', 'Escrever artigos sobre técnicas de vendas.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (29, 'E', 'Trabalhar como Relações Públicas em uma empresa.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (30, 'E', 'Atuar como Jornalista na imprensa falsa, escrita ou televisiva.');


insert into public.pergunta_boot(id, tipo, pergunta) VALUES (31, 'F', 'Frequentar curso na área artística.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (32, 'F', 'Dar aulas de Artes.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (33, 'F', 'Atuar na montagem de uma peça teatral na finalização dos cenários.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (34, 'F', 'Confeccionar home-pages.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (35, 'F', 'Visitar um Museu de Artes.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (36, 'F', 'Administrar uma galeria de artes.');

insert into public.pergunta_boot(id, tipo, pergunta) VALUES (37, 'G', 'Ser professor de português.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (38, 'G', 'Trabalhar como advogado.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (39, 'G', 'Escrever artigos.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (40, 'G', 'Visitar a biblioteca nacional.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (41, 'G', 'Criar textos para propagandas.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (42, 'G', 'Ler poesia.');

insert into public.pergunta_boot(id, tipo, pergunta) VALUES (43, 'H', 'Colecionar arquivos de música no computador(MP3, Midia ou similar).');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (44, 'H', 'Compor música.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (45, 'H', 'Trabalhar como Professor(a) de Música.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (46, 'H', 'Reger uma orquestra.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (47, 'H', 'Trabalhar como coletor de baladas e pesquisador de música e danças folclóricas.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (48, 'H', 'Participar de um coral.');


insert into public.pergunta_boot(id, tipo, pergunta) VALUES (49, 'I', 'Ser Diretor(a) de um colégio de ensino fundamental ou médio.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (50, 'I', 'Atuar numa empresa como Diretor(a) de Pessoal.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (51, 'I', 'Trabalhar como Assistente Social num centro médico, escolar, de reabilitação ou psicológico.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (52, 'I', 'Atuar na área esportiva, na assistência a jovens carentes..');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (53, 'I', 'Atuar em Orientação Profissional.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (54, 'I', 'Participar como profissional de um centro de reabilitação.');


insert into public.pergunta_boot(id, tipo, pergunta) VALUES (55, 'J', 'Trabalhar como digitador(a).');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (56, 'J', 'Implementar programa de qualidade em uma empresa.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (57, 'J', 'Organizar um arquivo que envolva números e letras.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (58, 'J', 'Dirigr uma agência de viagens e turismo.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (59, 'J', 'Desenvolver novos métodos de trabalhos.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (60, 'J', 'Atuar como Administrador(a) de uma empresa.');


insert into public.pergunta_boot(id, tipo, pergunta) VALUES (61, 'L', 'Participar de grupos de jovens da igreja.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (62, 'L', 'Ouvir músicas sacras ou cantos gregorianos.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (63, 'L', 'Orar diariamente.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (64, 'L', 'Pesquisar a ocorrência de milagres.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (65, 'L', 'Visitar tempos religiosos.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (66, 'L', 'Trabalhar com comunidades fortalecendo a fé.');


insert into public.pergunta_boot(id, tipo, pergunta) VALUES (67, 'M', 'Cumprir rigorosamente normas estabelecidas.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (68, 'M', 'Comandar pessoas.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (69, 'M', 'Ler livros relatando feitos heróicos.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (70, 'M', 'Participar de desfiles cívicos.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (71, 'M', 'Ter um apurado senso de responsabilidade.');
insert into public.pergunta_boot(id, tipo, pergunta) VALUES (72, 'M', 'Ter amor a Pátria.');

```



--- Noticia

```
INSERT INTO public.noticia(
	id, nome, data_expiracao, descricao, foto, ocupacao, titulo)
	VALUES (1, 'Flávio Sousa', '2021-06-30', 'Aprenda como se tornar um freelancer e um empreendedor de sucesso. /n Curso totalmente didático e gratuito.', 'data:image/png;base64,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', 'EMPREENDEDOR', 'Novo Curso Online Disponível.');
   


INSERT INTO public.noticia(
	id, nome, data_expiracao, descricao, foto, ocupacao, titulo)
	VALUES (2, 'Cláudia Ferreira', '2021-06-30', 'Procuro jovens formados na área de arquitetura que tenham interesse em desgin de interiores para pesquisa.', 'data:image/webp;base64,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', 'Professora Universitária', 'Oportunidade para Arquitetos');
```

-- Vaga

```

```

 