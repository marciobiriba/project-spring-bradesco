package br.com.bradesco.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import br.com.bradesco.business.ContaDTO;
import br.com.bradesco.domain.Conta;

/**
 * Servlet implementation class ServletTesteSpring
 */
@WebServlet("/ServletTesteSpring")
public class ServletTesteSpring extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private ContaDTO contaDto;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTesteSpring() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Conta cto = new Conta();
		cto.setCodAgencia(1);
		cto.setCodConta(1L);
		cto.setSaldo(12d);
		contaDto.depositar(cto);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	public ContaDTO getContaDto() {
		return contaDto;
	}

	public void setContaDto(ContaDTO contaDto) {
		this.contaDto = contaDto;
	}
	public void init(ServletConfig config) throws ServletException {
	    super.init(config);
	    SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
	      config.getServletContext());
	  }
	
	

}
