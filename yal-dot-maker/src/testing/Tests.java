package testing;

import java.awt.image.BufferedImage;

import org.junit.jupiter.api.Test;

import GUI.Map;
import core.Controller;
import core.Model;
import core.View;
import graphics.Vector2f;
import map.Asset;
/**
 * Test class not included in main program
 * @author bschab
 *
 */
class Tests {

	@Test
	void testNew() {
		Controller controller = new Controller();
		View view = controller.getView();
		Model model = controller.getModel();
		
		model.getMap().setName("Testname");
		model.getMap().setBackgroundImage(new BufferedImage(100,100,BufferedImage.TYPE_INT_ARGB));
		
		//simulates creating a new map
		model.setMap(new Map());
		view.resetGUI();
		//-----
		
		assert(!model.getMap().getName().equals("Testname"));
	}
	
	@Test
	void createAsset() {
		Controller controller = new Controller();
		View view = controller.getView();
		Model model = controller.getModel();
		
		model.getMap().getAssets().add(new Asset(null,"TestAsset",new Vector2f(0,0),new Vector2f(100,100),null));
		
		assert(!model.getMap().getAssets().isEmpty() && model.getMap().getAssets().get(0).getName().equals("TestAsset"));
	}
	
	@Test
	void copyTest() {
		Asset asset1 = new Asset(new BufferedImage(100,100,BufferedImage.TYPE_INT_ARGB),"TestAsset",new Vector2f(0,0), new Vector2f(100,100),null);
		Asset assetCopy = new Asset(asset1);
		
		assert(asset1 != assetCopy);
	}

}
