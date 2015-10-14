/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package importDb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author  fchakti
 */
@Stateless
public class OperationsFacade extends AbstractFacade<Operations> {
    @PersistenceContext(unitName = "family_expensesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OperationsFacade() {
        super(Operations.class);
    }
    
}
