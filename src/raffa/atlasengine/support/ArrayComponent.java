package raffa.atlasengine.support;

import raffa.atlasengine.sprite.Sprite;

public class ArrayComponent {

	/**
	 * Sort the comp_added array basing
	 * on the zLevel variable of each component
	 */

	public static Sprite[] sort(Sprite components[]) {
		
		boolean flag = false;
		
		for (int i = 0; i < components.length; i++) {
			
			for(int j = 0; j < components.length - 1; j++) {
				
				if(components[j].getZLevel() > components[j+1].getZLevel()) {
					Sprite k = components[j];
					components[j] = components[j+1];
					components[j+1] = k;
                    flag = true;
                }
			}
			
			if (!flag) break;
		}
		
		return components;
	}
	
	/**
	 * Add a new empty slot to the array
	 */
	
	public static Sprite[] addNullSlot(Sprite components[]) {
		
		int length = components.length;
		
		Sprite[] temp = new Sprite[length + 1];
		
		for (int i = 0; i < length; i++)
			temp[i] = components[i];
		
		return temp;
	}
	
	/**
	 * Remove all the null slots from the array
	 */
	
	public static Sprite[] removeNullSlots(Sprite components[]) {
		
		int countNull = 0;
		
		int length = components.length;
		
		for (int i = 0; i < length; i++) {
			if (components[i] == null)
				countNull++;
		}
		
		length -= countNull;
		
		Sprite[] temp = new Sprite[length];
		
		int j = 0;
		int w = 0;
		while (w < length) {
			if (components[j] == null)
				j++;
			temp[w] = components[j];
			j++;
			w++;
		}
		
		return temp;
	}
	
	/**
	 * Add a component to the array
	 * If a slot of the array is null, the component will replace it
	 */

	public static Sprite[] add(Sprite components[], Sprite component) {
		
		int countNull = 0;
		
		for (int i = 0; i < components.length; i++) {
			if (components[i] == null)
				countNull++;
		}
		
		if (countNull == 0) {
			components = addNullSlot(components);
			components[components.length - 1] = component;
		} else {
			boolean notFound = true;
			for (int i = 0; notFound; i++) {
				if (components[i] == null) {
					components[i] = component;
					notFound = false;
				}
			}
		}
		
		return components;
	}
	
	/**
	 * Remove a component from the array
	 * letting a null slot in it
	 */
	
	public static Sprite[] remove(Sprite components[], Sprite component) {
		
		for (int i = 0; i < components.length; i++) {
			if (components[i] == component)
				components[i] = null;
		}
		
		return components;
	}
}
