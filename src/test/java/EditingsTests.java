import operations.Editings;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by toprak on 29-Mar-17.
 */
public class EditingsTests {

  @Before
  public void setUp(){

  }

  @Test
  public void test_calculate_additional_pixels(){
    int expansion = Editings.calculateAdditionalPixelsForEachDimension(7);
    assertEquals(3, expansion);
  }
}
