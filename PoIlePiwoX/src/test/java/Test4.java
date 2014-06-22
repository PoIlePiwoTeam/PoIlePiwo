import static org.junit.Assert.*;
import junit.framework.Assert;
import lib.data.Item;
import lib.main.BazaDanych;
import lib.main.Init;

import org.junit.Test;


public class Test4 {

	@Test
	public void test() {
		BazaDanych bd = new BazaDanych();
		int it = bd.getMaxId();
		bd.insertItem(new Item(-1,"Mleko","Nabia�","NA","NA",10,(float) 2.7));
		assertEquals(it+1, bd.getMaxId());
		bd.deleteItem(it+1);
		assertEquals(it, bd.getMaxId());
	}

}
