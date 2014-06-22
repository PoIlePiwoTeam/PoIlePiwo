import static org.junit.Assert.*;
import junit.framework.Assert;
import lib.data.HistoryItem;

import org.junit.Test;


public class Test3 {

	@Test
	public void test() {
		HistoryItem it = new HistoryItem(-1,"JUN 12 12:12:22 2014","1,2,3,",(float) 123.0);
		Assert.assertEquals("1,2,3,", it.getItems());
		Assert.assertEquals("JUN 12 12:12:22 2014",it.getDate());
		Assert.assertEquals(123,it.getCena(),0.001);
	}

}
