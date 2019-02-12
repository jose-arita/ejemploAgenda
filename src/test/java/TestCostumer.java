
import dao.CostumerDao;
import models.Costumer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class TestCostumer {
    
    public static void main(String[] args) {
        boolean inserted = CostumerDao.add(
                new Costumer("Jose")
        );
        System.out.println(inserted);
    }
}
