import static org.junit.Assert.*;
import lib.data.Item;
import lib.data.Koszyk;

import org.junit.Assert;
import org.junit.Test;


public class Test1 {

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		//Test klasy koszyk
		Koszyk testowy = new Koszyk(); 
		Assert.assertEquals(0,testowy.policzCene(),0);
		testowy.addItem(new Item(-1,"Maslo","Nabia³","NA","NA",10,(float) 2.70));
		Assert.assertEquals(2.70,testowy.policzCene(),0.001);
		testowy.clearKoszyk();
		Assert.assertEquals(0,testowy.policzCene(),0.001);
		testowy.addItem(new Item(-1,"Maslo","Nabia³","NA","NA",10,(float) 2.70));
		Assert.assertEquals(2.70,testowy.policzCene(),0.001);
		testowy.removeItem(0);
		Assert.assertEquals(0,testowy.policzCene(),0.001);	
	}

}
