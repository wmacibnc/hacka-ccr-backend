//package com.hacka.ccr.filter;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.hacka.ccr.repository.AutenticacaoRepository;
//
//@Component
//public class AutenticacaoFilter implements Filter {
//
//	@Autowired
//	private AutenticacaoRepository autenticacaoRepository;
//
//	@Override
//	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
//			throws IOException, ServletException {
//
//		HttpServletResponse response = (HttpServletResponse) res;
//		HttpServletRequest request = (HttpServletRequest) req;
//
//		if(request.getServletPath().equalsIgnoreCase("/autenticacao")) {
//			chain.doFilter(req, res);
//			return;
//		}
//		
//		String headerAuthorization = request.getHeader("Authorization");
//
//		if (headerAuthorization == null) {
//			naoAutenticado(response, "Não foi informado o cabeçalho Authorization.");
//		} else if (autenticacaoRepository.obterToken(headerAuthorization) == null) {
//			naoAutenticado(response, "Cabeçalho informado é invalido.");
//		} else {
//			System.out.println("Autenticado!");
//			chain.doFilter(req, res);
//		}
//	}
//
//	private void naoAutenticado(HttpServletResponse response, String mensagem) throws IOException {
//		System.out.println("Não autenticado!");
//		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, mensagem);
//	}
//
//	@Override
//	public void destroy() {
//	}
//
//	@Override
//	public void init(FilterConfig arg0) throws ServletException {
//	}
//
//}