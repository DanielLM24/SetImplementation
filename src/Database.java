import java.util.Set;


public class Database<E> {
	Set<E> java;
	Set<E> web;
	Set<E> movil;

	public Database(String tipo){
		SetFactory<E> sFactory = new SetFactory<E>();
		java = sFactory.getSet(tipo);
		web = sFactory.getSet(tipo);
		movil = sFactory.getSet(tipo);
	}
	public Set<E> getJava() {
		return java;
	}

	public void setJava(Set<E> java) {
		this.java = java;
	}

	public Set<E> getWeb() {
		return web;
	}

	public void setWeb(Set<E> web) {
		this.web = web;
	}

	public Set<E> getMovil() {
		return movil;
	}

	public void setMovil(Set<E> movil) {
		this.movil = movil;
	}


}
