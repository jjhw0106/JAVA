package generic;

public class GenericPrinter<T extends Material> {	//Material클래스를 상속받은 클래스만 사용가능
	private T material;

	public T getMaterial() {
		return material;
	}

	public void setMaterial(T material) {
		this.material = material;
	}

	public String toString() {
		return material.toString();
	}

}
