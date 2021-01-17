package com.hacka.ccr.controller;

public enum ResultadoAnaliseVocacionalEnum {

	LETRA_A("A", "Você tirou a área A: Ar livre. /n Os cursos e as profissões que combinam com você são: /n - Biologia /n - Oceanografia  /n - Geografia - Turismo /n - Guarda Florestal /n - Jardineiro /n - Botânico /n Entre muitas outras coisas!"), 
	LETRA_B("B", "Você tirou a área B: Mecánica. /n Os cursos e as profissões que combinam com você são: /n - Engenharia /n - Torneiro mecânico  /n - Mecânico industrial /n - Mecânico automotivo /n - Manutenção de máquinas e equipamentos /n Entre muitas outras coisas!"), 
	LETRA_C("C", "Você tirou a área C: Cálculo. /n Os cursos e as profissões que combinam com você são: /n - Economia /n - Estatística /n - Administração /n - Contabilidade /n - Geologia /n - Informática /n - Nutrição /n - Arquitetura  /n - Matemática  /n - Física /n - Engenharia /n Entre muitas outras coisas!"), 
	LETRA_D("D", "Você tirou a área D: Científica. /n Os cursos e as profissões que combinam com você são: /n - Biomedicina /n - Química /n - Física /n - Ciências da Computação /n - Sistemas de informação /n Entre muitas outras coisas!"),
	LETRA_E("E", "Você tirou a área E: Persuasiva. /n Os cursos e as profissões que combinam com você são: /n - Gestor de Negócios /n - Corretor de imóveis /n - Vendedor /n - Médico /n - Planejador financeiro /n - Relações Públicas /n - Relações internacionais /n -Advogado /n Entre muitas outras coisas!"), 
	LETRA_F("F", "Você tirou a área F: Artística. /n Os cursos e as profissões que combinam com você são: /n - Arquitetura /n - Artes plásticas /n - Design /n - Cenografia /n - Dança /n - Design de interiores /n - Moda /n - Programação visual /n - Fotografia /n - Odontológia /n - Modelo /n Entre muitas outras coisas!"), 
	LETRA_G("G", "Você tirou a área G: Literária. /n Os cursos e as profissões que combinam com você são: /n - Artes cênicas /n - Comentarista /n - Escritor /n - Professor /n - Sociologia /n - Turismo  /n - Advogado /n Entre muitas outras coisas!"), 
	LETRA_H("H", "Você tirou a área H: Musical. /n Os cursos e as profissões que combinam com você são: /n - produção cultural /n - Cantor /n - Musico Instrumentista  /n - Maestro  /n - Musicoterapia  /n - Cinema e Audiovisual /n Entre muitas outras coisas!"),
	LETRA_I("I", "Você tirou a área I: Assistencial. /n Os cursos e as profissões que combinam com você são: /n - Telemarketing /n - Direito /n - Desenvolvimento social /n - Enfermagem /n - Estética /n - Fisioterapia /n - Medicina /n - Fonoaudiólogo /n - Pedagogia /n - Psicologia /n - Serviço social /n Entre muitas outras coisas!"), 
	LETRA_J("J", "Você tirou a área J: Administrativa. /n Os cursos e as profissões que combinam com você são: /n - Administração /n - Planejamento estratégico /n - Marketing /n - Logística /n - Vendas /n Entre muitas outras coisas!"), 
	LETRA_L("L", "Você tirou a área L: Religiosa. /n Os cursos e as profissões que combinam com você são: /n - Pesquisa - Trabalho social /n - Administração de instituições religiosas /n - Mercado editorial - Aconselhamento espiritual /n Entre muitas outras coisas!"), 
	LETRA_M("M", "Você tirou a área M: Militar. /n Os cursos e as profissões que combinam com você são: /n - Piloto /n - Soldado /n - Marinheiro /n - Policial /n - Bombeiro /n Entre muitas outras coisas!");

	private String tipo;
	private String resultado;

	private ResultadoAnaliseVocacionalEnum(String tipo, String resultado) {
		this.tipo = tipo;
		this.resultado = resultado;
	}

	public String getTipo() {
		return tipo;
	}

	public String getResultado() {
		return resultado;
	}

	public static ResultadoAnaliseVocacionalEnum obterValor(String tipo) {
		for(ResultadoAnaliseVocacionalEnum resultado : ResultadoAnaliseVocacionalEnum.values()) {
			if(resultado.getTipo().equalsIgnoreCase(tipo)){
				return resultado;
			}
		}
		return null;
	}

}
