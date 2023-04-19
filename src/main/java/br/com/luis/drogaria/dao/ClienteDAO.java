package br.com.luis.drogaria.dao;

import br.com.luis.drogaria.domain.Clientes;
import br.com.luis.drogaria.domain.Funcionario;
import br.com.luis.drogaria.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import java.util.List;

public class ClienteDAO extends GenericDAO<Clientes>{
    public List<Clientes> listarOrdenado() {
        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        try {
            Criteria consulta = sessao.createCriteria(Clientes.class);
            consulta.createAlias("pessoa","p");
            consulta.addOrder(Order.asc("p.nome"));
            List<Clientes> resultado = consulta.list();
            return resultado;
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }

}
