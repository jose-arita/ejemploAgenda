
import java.util.List;
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
public class TestCostumerLiist {
    
    public static void main(String[] args) {
    
        List<Costumer> list = dao.CostumerDao.costumerList();

        for(Costumer c : list){
                System.out.println(c.getName());
        }
    
    }
    
}
