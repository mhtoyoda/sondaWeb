package br.com.toyoda.business;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.toyoda.SondaWebApplication;
import br.com.toyoda.direction.Direction;
import br.com.toyoda.model.ActionInput;
import br.com.toyoda.model.Sonda;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SondaWebApplication.class)
public class SondaActionTest {

    @Autowired
    private SondaAction sondaAction;
    
	@Test
	public void moveDirectionNorthLeft() {
		ActionInput actionInput = new ActionInput();
		actionInput.setInstructions("LM");
		actionInput.setSonda(new Sonda(1, 1, Direction.N));
        Sonda sonda = sondaAction.action(actionInput);
        Assert.assertEquals(Direction.W, sonda.getDirection());
        Assert.assertTrue(sonda.getCoordinateX() == 0);
	}
	
	@Test
    public void moveDirectionNorthRight() {
        ActionInput actionInput = new ActionInput();
        actionInput.setInstructions("RM");
        actionInput.setSonda(new Sonda(1, 1, Direction.N));
        Sonda sonda = sondaAction.action(actionInput);
        Assert.assertEquals(Direction.E, sonda.getDirection());
        Assert.assertTrue(sonda.getCoordinateX() == 2);
    }
	
	@Test
    public void moveDirectionSouthLeft() {
        ActionInput actionInput = new ActionInput();
        actionInput.setInstructions("LM");
        actionInput.setSonda(new Sonda(1, 1, Direction.S));
        Sonda sonda = sondaAction.action(actionInput);
        Assert.assertEquals(Direction.E, sonda.getDirection());
        Assert.assertTrue(sonda.getCoordinateX() == 2);
    }
    
    @Test
    public void moveDirectionSouthRight() {
        ActionInput actionInput = new ActionInput();
        actionInput.setInstructions("RM");
        actionInput.setSonda(new Sonda(1, 1, Direction.S));
        Sonda sonda = sondaAction.action(actionInput);
        Assert.assertEquals(Direction.W, sonda.getDirection());
        Assert.assertTrue(sonda.getCoordinateX() == 0);
    }
    
    @Test
    public void moveDirectionEastLeft() {
        ActionInput actionInput = new ActionInput();
        actionInput.setInstructions("LM");
        actionInput.setSonda(new Sonda(1, 1, Direction.E));
        Sonda sonda = sondaAction.action(actionInput);
        Assert.assertEquals(Direction.N, sonda.getDirection());
        Assert.assertTrue(sonda.getCoordinateY() == 2);
    }
    
    @Test
    public void moveDirectionEastRight() {
        ActionInput actionInput = new ActionInput();
        actionInput.setInstructions("RM");
        actionInput.setSonda(new Sonda(1, 1, Direction.E));
        Sonda sonda = sondaAction.action(actionInput);
        Assert.assertEquals(Direction.S, sonda.getDirection());
        Assert.assertTrue(sonda.getCoordinateY() == 0);
    }
    
    @Test
    public void moveDirectionWestLeft() {
        ActionInput actionInput = new ActionInput();
        actionInput.setInstructions("LM");
        actionInput.setSonda(new Sonda(1, 1, Direction.W));
        Sonda sonda = sondaAction.action(actionInput);
        Assert.assertEquals(Direction.S, sonda.getDirection());
        Assert.assertTrue(sonda.getCoordinateY() == 0);
    }
    
    @Test
    public void moveDirectionWetRight() {
        ActionInput actionInput = new ActionInput();
        actionInput.setInstructions("RM");
        actionInput.setSonda(new Sonda(1, 1, Direction.W));
        Sonda sonda = sondaAction.action(actionInput);
        Assert.assertEquals(Direction.N, sonda.getDirection());
        Assert.assertTrue(sonda.getCoordinateY() == 2);
    }
}