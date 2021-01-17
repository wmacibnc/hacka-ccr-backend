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






 